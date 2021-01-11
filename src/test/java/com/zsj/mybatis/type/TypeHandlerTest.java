package com.zsj.mybatis.type;

import org.apache.ibatis.submitted.typehandler.StringTrimmingTypeHandler;
import org.apache.ibatis.type.*;
import org.junit.Test;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.*;


/**
 * @desc:
 * @author: zhangshengjun
 * @createDate: 2021/1/10
 */
public class TypeHandlerTest {

    /** 测试获取 IntegerTypeHandler 的参数化类型 */
    @Test
    public void test1()
    {
        TypeHandler<Integer> typeHandler = new IntegerTypeHandler();
        Type type = typeHandler.getClass().getGenericSuperclass();
        System.out.println(type);
        Type[] typeArguments = ((ParameterizedType) type).getActualTypeArguments();
        System.out.println(Arrays.toString(typeArguments));
    }

    /** TypeReference抽象类的作用：getRawType方法 */
    @Test
    public void test2()
    {
        TypeReference<BigDecimal> typeReference = new BigDecimalTypeHandler();
        Type rawType = typeReference.getRawType();
        System.out.println(rawType);
    }

    @Test
    public void test3()
    {
        TypeHandlerRegistry registry = new TypeHandlerRegistry();
        registry.register(String.class, StringTrimmingTypeHandler.class);
    }

}
