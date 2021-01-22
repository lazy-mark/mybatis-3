package com.zsj.mybatis.builder.xml;

import org.apache.ibatis.builder.xml.XMLMapperEntityResolver;
import org.junit.Test;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;

/**
 * @desc:
 * @author: zhangshengjun
 * @createDate: 2021/1/19
 */
public class XMLMapperEntityResolverTest {

    private static final String PUBLIC_ID = "-//mybatis.org//DTD Mapper 3.0//EN".toUpperCase(Locale.ENGLISH);
    private static final String SYSTEM_ID = "http://mybatis.org/dtd/mybatis-3-mapper.dtd".toUpperCase(Locale.ENGLISH);

    private static final String MYBATIS_CONFIG_PUBLIC = "-//mybatis.org//DTD Config 3.0//EN".toUpperCase(Locale.ENGLISH);
    private static final String MYBATIS_CONFIG_SYSTEM = "http://mybatis.org/dtd/mybatis-3-config.dtd".toUpperCase(Locale.ENGLISH);

    @Test
    public void test() throws SAXException, IOException {
        XMLMapperEntityResolver resolver = new XMLMapperEntityResolver();
        InputSource inputSource = resolver.resolveEntity(MYBATIS_CONFIG_PUBLIC, MYBATIS_CONFIG_SYSTEM);
        InputStream byteStream = inputSource.getByteStream();
        BufferedInputStream inputStream = new BufferedInputStream(byteStream);
        byte[] bytes = inputStream.readAllBytes();
        String s = new String(bytes);
        System.out.println(s);
    }
}
