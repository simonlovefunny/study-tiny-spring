package com.simon;


import com.simon.io.ResourceLoader;

import java.util.HashMap;
import java.util.Map;

/**
 * BeanDefinitionReader抽象类
 *
 * @Author: wuzhaoyi
 * @version: $id:AbstractBeanDefinitionReader.java,v0.1  2019/5/25 8:43 PM wuzhaoyi Exp$
 */
public abstract class AbstractBeanDefinitionReader implements BeanDefinitionReader{

    private Map<String,BeanDefinition> registry;

    private ResourceLoader resourceLoader;

    public AbstractBeanDefinitionReader(ResourceLoader resourceLoader) {
        this.registry = new HashMap<String, BeanDefinition>();
        this.resourceLoader = resourceLoader;
    }

    public Map<String, BeanDefinition> getRegistry() {
        return registry;
    }

    public ResourceLoader getResourceLoader() {
        return resourceLoader;
    }
}
