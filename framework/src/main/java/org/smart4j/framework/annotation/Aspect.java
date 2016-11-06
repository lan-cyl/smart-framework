package org.smart4j.framework.annotation;

import java.lang.annotation.*;

/**
 * Created by lan_cyl on 2016/11/4.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Aspect {
    Class<? extends Annotation> value();
}
