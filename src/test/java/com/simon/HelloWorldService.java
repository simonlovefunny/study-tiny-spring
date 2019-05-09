package com.simon;

/**
 * todo
 *
 * @Author: wuzhaoyi
 * @version: $id:HelloWorldService.java,v0.1  2019/5/9 11:24 PM wuzhaoyi Exp$
 */
public class HelloWorldService {

    private String text;

    public void helloWorld(){
        System.out.println(text);
    }

    public void setText(String text) {
        this.text = text;
    }
}
