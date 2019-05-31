package com.simon;

/**
 * helloService实现类
 *
 * @Author: wuzhaoyi
 * @version: $id:HelloWorldServiceImpl.java,v0.1  2019/5/31 7:41 PM wuzhaoyi Exp$
 */
public class HelloWorldServiceImpl implements HelloWorldService{

    private String text;

    private OutputService outputService;

    @Override
    public void helloWorld(){
        outputService.output(text);
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setOutputService(OutputService outputService) {
        this.outputService = outputService;
    }
}
