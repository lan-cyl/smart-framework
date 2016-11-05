package org.smart4j.framework.util;

import org.apache.commons.lang3.StringUtils;

/**
 * 字符串处理的工具类
 *
 * Created by lan_cyl on 2016/11/2.
 */
public final class StringUtil {

    /**
     * 判断字符串是否为空
     *
     * @param str
     * @return
     */
    public static boolean isEmpty(String str) {
        if (str != null)
            str = str.trim();
        return StringUtils.isEmpty(str);
    }

    /**
     * 判断字符串是否非空
     *
     * @param str
     * @return
     */
    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }
}
