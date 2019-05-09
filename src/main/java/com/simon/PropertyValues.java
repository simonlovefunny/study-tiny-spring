package com.simon;

import java.util.ArrayList;
import java.util.List;

/**
 * PropertyValue容器，不直接使用list方拜年实现更多功能
 *
 * @Author: wuzhaoyi
 * @version: $id:PropertyValues.java,v0.1  2019/5/9 10:18 PM wuzhaoyi Exp$
 */
public class PropertyValues {

    List<PropertyValue> propertyValueList = new ArrayList<>();

    public PropertyValues() {
    }

    public void addProperty(PropertyValue pv){
        //可以对PropertyValue值进行重复和null判断，直接用list无法实现
        propertyValueList.add(pv);
    }

    public List<PropertyValue> getPropertyValueList() {
        return propertyValueList;
    }
}
