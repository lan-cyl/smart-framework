package org.smart4j.framework.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 读取属性的工具类
 *
 * Created by lan_cyl on 2016/11/2.
 */
public final class PropsUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(PropsUtil.class);

    /**
     * 加载属性文件
     *
     * @param fileName 属性文件
     * @return
     */
    public static Properties loadProps(String fileName) {
        Properties props = null;
        try(InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName)) {
            props = new Properties();
            props.load(in);
        }catch (IOException e) {
            LOGGER.error("load properties file failure", e);
        }
        return props;
    }

    /**
     * 获取字符型属性（默认值为空字符串）
     *
     * @param props
     * @param key
     * @return
     */
    public static String getString(Properties props, String key) {
        return getString(props, key, "");
    }

    /**
     * 获取字符型属性（可指定默认值）
     *
     * @param props
     * @param key
     * @param defaultValue
     * @return
     */
    public static String getString(Properties props, String key, String defaultValue) {
        return props.getProperty(key, defaultValue);
    }

    /**
     * 获取整数型属性（默认值为0）
     *
     * @param props
     * @param key
     * @return
     */
    public static int getInt(Properties props, String key) {
        return getInt(props, key , 0);
    }

    /**
     * 获取整数型属性（可指定默认值）
     * @param props
     * @param key
     * @param defaultValue
     * @return
     */
    public static int getInt(Properties props, String key, int defaultValue) {
        String value = props.getProperty(key);
        return value == null ? defaultValue : Integer.parseInt(value);
    }

    /**
     * 获取布尔型属性（默认值为false）
     * @param props
     * @param key
     * @return
     */
    public static boolean getBoolean(Properties props, String key) {
        return getBoolean(props, key, false);
    }

    /**
     * 获取布尔型属性（可指定默认值）
     * @param props
     * @param key
     * @param defaultValue
     * @return
     */
    public static boolean getBoolean(Properties props, String key, boolean defaultValue) {
        String value = props.getProperty(key);
        return value == null ? defaultValue : Boolean.parseBoolean(value);
    }
}
