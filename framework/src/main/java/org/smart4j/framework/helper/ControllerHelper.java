package org.smart4j.framework.helper;

import org.apache.commons.collections.map.HashedMap;
import org.smart4j.framework.annotation.Action;
import org.smart4j.framework.bean.Handler;
import org.smart4j.framework.bean.Request;
import org.smart4j.framework.util.ClassUtil;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.Set;

/**
 * Created by lan_cyl on 2016/11/2.
 */
public final class ControllerHelper {
    private static final Map<Request, Handler> ACTION_MAP = new HashedMap();

    static {
        Set<Class<?>> actionClassSet = ClassHelper.getControllerClassSet();
        for (Class<?> aClass : actionClassSet) {
            Method[] methods = aClass.getDeclaredMethods();
            for (Method method : methods) {
                if (method.isAnnotationPresent(Action.class)){
                    Action action = method.getAnnotation(Action.class);
                    String mapping = action.value();
                    if (mapping.matches("\\w+:/\\w*")) {
                        String[] array = mapping.split(":");
                        Request request = new Request(array[0], array[1]);
                        Handler handler = new Handler(aClass, method);
                        ACTION_MAP.put(request, handler);
                    }
                }
            }
        }
    }

    public static Handler getHandler(String requestMethod, String requestPath) {
        Request request = new Request(requestMethod, requestPath);
        return ACTION_MAP.get(request);
    }
}
