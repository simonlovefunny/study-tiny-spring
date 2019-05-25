package com.simon.io;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * todo
 *
 * @Author: wuzhaoyi
 * @version: $id:URLResource.java,v0.1  2019/5/21 9:10 AM wuzhaoyi Exp$
 */
public class URLResource implements Resource{

    private final URL url;

    public URLResource(URL url) {
        this.url = url;
    }

    @Override
    public InputStream getInputStream() throws IOException {

        URLConnection urlConnection = url.openConnection();
        urlConnection.connect();
        return urlConnection.getInputStream();
    }
}
