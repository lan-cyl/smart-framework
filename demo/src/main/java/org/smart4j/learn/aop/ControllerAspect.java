package org.smart4j.learn.aop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.smart4j.framework.annotation.Aspect;
import org.smart4j.framework.annotation.Controller;
import org.smart4j.framework.proxy.AspectProxy;

import java.lang.reflect.Method;

/**
 * Created by lan_cyl on 2016/11/5.
 */
@Aspect(Controller.class)
public class ControllerAspect extends AspectProxy {
    private static final Logger LOGGER = LoggerFactory.getLogger(ControllerAspect.class);
    private long begin;

    @Override
    public void before(Class<?> targetClass, Method targetMethod, Object[] params) {
        LOGGER.debug("-----------begin-----------");
        LOGGER.debug(String.format("class: %s", targetClass.getName()));
        LOGGER.debug(String.format("method: %s", targetMethod.getName()));
        begin = System.currentTimeMillis();
    }

    @Override
    public void after(Class<?> targetClass, Method targetMethod, Object[] params, Object result) {
        begin = System.currentTimeMillis();
        LOGGER.debug(String.format("result: %s", result));
        LOGGER.debug(String.format("time: %dms", System.currentTimeMillis() - begin));
        LOGGER.debug("------------end------------");
    }
}
