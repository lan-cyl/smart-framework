package org.smart4j.framework.helper;

import org.smart4j.framework.util.ClassUtil;

/**
 * Created by lan_cyl on 2016/11/2.
 */
public final class HelperLoader {

    public static void init() {
        ClassUtil.loadClass(ClassHelper.class.getName(), true);
        ClassUtil.loadClass(BeanHelper.class.getName(), true);
        ClassUtil.loadClass(IocHelper.class.getName(), true);
        ClassUtil.loadClass(ControllerHelper.class.getName(), true);
    }
}
