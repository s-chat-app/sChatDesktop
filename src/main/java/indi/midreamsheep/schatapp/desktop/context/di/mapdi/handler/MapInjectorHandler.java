package indi.midreamsheep.schatapp.desktop.context.di.mapdi.handler;

import indi.midreamsheep.schatapp.desktop.context.di.mapdi.processor.MapInjectorProcessor;
import live.midreamsheep.frame.sioc.api.context.application.ApplicationContext;
import live.midreamsheep.frame.sioc.api.handle.AbstractContextHandler;
import live.midreamsheep.frame.sioc.api.handle.HandlerLevel;
import lombok.AllArgsConstructor;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
public class MapInjectorHandler extends AbstractContextHandler {

    private List<MapInjectorProcessor.MapInjectorMapping> mapInjectorMappings;
    private Field field;
    private Class<?> clazz;
    @Override
    public void handle(ApplicationContext applicationContext) {
        try {
            field.setAccessible(true);
            Map<String,Object> map = new HashMap<>();
            for (MapInjectorProcessor.MapInjectorMapping mapInjectorMapping : mapInjectorMappings) {
                map.put(mapInjectorMapping.getValue(),applicationContext.getBean(mapInjectorMapping.getClazz()));
                field.set(applicationContext.getBean(clazz),map);
            }
        } catch (IllegalAccessException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public HandlerLevel getHandlerLevel() {
        return HandlerLevel.DECORATE;
    }
}
