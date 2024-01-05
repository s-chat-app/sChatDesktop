package indi.midreamsheep.schatapp.desktop.context.di.mapdi.annotation;

import live.midreamsheep.frame.sioc.scan.annotation.meta.SIocFlag;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE,ElementType.FIELD})
@SIocFlag
public @interface MapInjector {
    /**
     * 声明是注入方还是被注入方
     * true表示注入方，false表示被注入方
     * */
    boolean Inject() default true;
    /**
     * 用于表示注入到哪个map
     * */
    String target() default "SChatApplication";
    /**
     * 用于标记注入的map的value值
     * */
    String value() default "";
}
