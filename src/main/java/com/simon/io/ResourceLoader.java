package com.simon.io;

import java.net.URL;

/**
 * URL资源加载器
 *
 * @Author: wuzhaoyi
 * @version: $id:ResourceLoader.java,v0.1  2019/5/21 9:14 AM wuzhaoyi Exp$
 */
public class ResourceLoader {

    public Resource getResource(String location){

        URL resource = this.getClass().getClassLoader().getResource(location);
        return new URLResource(resource);
    }
}
