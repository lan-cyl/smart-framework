package org.smart4j.framework.util;

/**
 * Created by lan_cyl on 2016/11/2.
 */
public final class CastUtil {

    public static String castString(Object o) {
        return CastUtil.castString(o, "");
    }

    private static String castString(Object o, String defaultValue) {
        return o == null ? defaultValue : String.valueOf(o);
    }

    public static long castLong(Object o) {
        return castLong(o, 0);
    }

    private static long castLong(Object o, int defaultValue) {
        if (o == null)
            return defaultValue;
        try {
            return Long.parseLong(castString(o));
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }
}
