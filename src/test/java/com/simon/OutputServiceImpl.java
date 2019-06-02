package com.simon;

/**
 * todo
 *
 * @Author: wuzhaoyi
 * @version: $id:OutputServiceImpl.java,v0.1  2019/6/2 4:14 PM wuzhaoyi Exp$
 */
public class OutputServiceImpl implements OutputService{

    @Override
    public void output(String text){
        System.out.println(text);
    }
}
