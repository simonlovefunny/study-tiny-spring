package com.simon.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * Resource为Spring内部使用的定位资源（配置文件）的接口
 *
 * @Author: wuzhaoyi
 * @version: $id:Resource.java,v0.1  2019/5/21 9:06 AM wuzhaoyi Exp$
 */
public interface Resource {

    /**
     * 通过输入流获取资源
     *
     * @return
     * @throws IOException
     */
    InputStream getInputStream() throws IOException;
}
