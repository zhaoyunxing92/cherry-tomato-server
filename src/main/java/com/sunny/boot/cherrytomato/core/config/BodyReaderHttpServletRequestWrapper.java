/**
 * Copyright(C) 2018 Hangzhou sunny Technology Co., Ltd. All rights reserved.
 */
package com.sunny.boot.cherrytomato.core.config;

import org.springframework.util.StreamUtils;

import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.*;
import java.nio.charset.Charset;

/**
 * @author sunny
 * @class: com.sunny.boot.cherrytomato.core.config.BodyReaderHttpServletRequestWrapper
 * @date: 2018-06-12 11:25
 * @des: 自定义的Http请求封装类，解决RequestBody只能读取一次问题
 */
public class BodyReaderHttpServletRequestWrapper extends HttpServletRequestWrapper {
  private final byte[] body;

  public BodyReaderHttpServletRequestWrapper(HttpServletRequest request) throws IOException {
    super(request);
    this.body = StreamUtils.copyToByteArray(request.getInputStream());
  }

  @Override
  public BufferedReader getReader() throws IOException {
    return new BufferedReader(new InputStreamReader(getInputStream()));
  }

  @Override
  public ServletInputStream getInputStream() throws IOException {
    final ByteArrayInputStream bais = new ByteArrayInputStream(body);
    return new ServletInputStream() {
      @Override
      public int read() throws IOException {
        return bais.read();
      }

      @Override
      public boolean isFinished() {
        return false;
      }

      @Override
      public boolean isReady() {
        return false;
      }

      @Override
      public void setReadListener(ReadListener readListener) {
      }
    };
  }

}
