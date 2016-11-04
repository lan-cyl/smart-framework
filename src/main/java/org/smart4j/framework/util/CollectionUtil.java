package org.smart4j.framework.util;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;

import java.util.Collection;
import java.util.Map;

/**
 * 集合工具类
 *
 * Created by lan_cyl on 2016/11/2.
 */
public final class CollectionUtil {

    /**
     * 判断Collection是否为空
     *
     * @param coll
     * @return
     */
    public static boolean isEmpty(Collection<?> coll) {
        return CollectionUtils.isEmpty(coll);
    }

    /**
     * 判断Collection是否非空
     * @param coll
     * @return
     */
    public static boolean isNotEmpty(Collection<?> coll) {
        return !isEmpty(coll);
    }

    /**
     * 判断Map是否为空
     *
     * @param map
     * @return
     */
    public static boolean isEmpty(Map<?, ?> map) {
        return MapUtils.isEmpty(map);
    }

    /**
     * 判断Map是否非空
     *
     * @param map
     * @return
     */
    public static boolean isNotEmpty(Map<?, ?> map) {
        return !isEmpty(map);
    }
}
