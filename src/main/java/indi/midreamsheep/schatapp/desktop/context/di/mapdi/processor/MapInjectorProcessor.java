package indi.midreamsheep.schatapp.desktop.context.di.mapdi.processor;

import indi.midreamsheep.schatapp.desktop.context.di.mapdi.annotation.MapInjector;
import indi.midreamsheep.schatapp.desktop.context.di.mapdi.handler.MapInjectorHandler;
import live.midreamsheep.frame.sioc.api.handle.ContextHandler;
import live.midreamsheep.frame.sioc.scan.annotation.meta.ProcessorFlag;
import live.midreamsheep.frame.sioc.scan.clazz.ClassMetaDefinition;
import live.midreamsheep.frame.sioc.scan.clazz.field.FieldInter;
import live.midreamsheep.frame.sioc.scan.processor.core.register.RegisterProcessor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@ProcessorFlag({MapInjector.class})
public class MapInjectorProcessor extends RegisterProcessor {

    private final Map<String,List<MapInjectorMapping>> map = new HashMap<>();

    @Override
    public void process(ClassMetaDefinition classMetaDefinition, List<ContextHandler> list) {
        MapInjector annotation = classMetaDefinition.getAnnotationInfo().getAnnotation(MapInjector.class);
        String target = annotation.target();
        if (!map.containsKey(target)) {
            map.put(target,new LinkedList<>());
        }
        if (annotation.Inject()) {
            //是注入方，建立映射
            String value = annotation.value();
            map.get(target).add(new MapInjectorMapping(value,classMetaDefinition.getOwnClass()));
            return;
        }
        //是被注入方，进行注入
        for (FieldInter fieldInter : classMetaDefinition.getFieldInfo().getFieldInterList()) {
            if ((annotation = fieldInter.getAnnotationInfo().getAnnotation(MapInjector.class)) == null) {
                continue;
            }
            List<MapInjectorMapping> mapInjectorMappings = map.get(target);
            list.add(new MapInjectorHandler(mapInjectorMappings,fieldInter.getField(),classMetaDefinition.getOwnClass()));
        }
    }
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class MapInjectorMapping{
        private String value;
        private Class<?> clazz;
    }
}
