package com.simon;

/**
 * bean的属性值
 *
 * @Author: wuzhaoyi
 * @version: $id:PropertyValue.java,v0.1  2019/5/9 10:16 PM wuzhaoyi Exp$
 */
public class PropertyValue {

    private final String key;

    private final Object value;

    public PropertyValue(String key, Object value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public Object getValue() {
        return value;
    }
}
