package com.zsj.mybatis.type;

import org.apache.ibatis.type.IntegerTypeHandler;
import org.apache.ibatis.type.TypeHandler;
import org.junit.Test;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;


/**
 * @desc:
 * @author: zhangshengjun
 * @createDate: 2021/1/10
 */
public class TypeHandlerTest {

    @Test
    public void test1()
    {
        TypeHandler<Integer> typeHandler = new IntegerTypeHandler();
        Type type = typeHandler.getClass().getGenericSuperclass();
        System.out.println(type);
        Type[] typeArguments = ((ParameterizedType) type).getActualTypeArguments();
        System.out.println(Arrays.toString(typeArguments));
    }

}
