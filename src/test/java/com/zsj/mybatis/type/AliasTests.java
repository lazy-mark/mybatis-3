package com.zsj.mybatis.type;

import org.apache.ibatis.type.Alias;
import org.apache.ibatis.type.TypeAliasRegistry;
import org.junit.Test;

import java.util.Locale;
import java.util.Map;

/**
 * @desc:
 * @author: zhangshengjun
 * @createDate: 2021/1/9
 */
public class AliasTests {

    @Test
    public void test1() {
        String s = "sys_user";
        String s1 = s.toLowerCase(Locale.ENGLISH);
        System.out.println(s1);
    }

    @Test
    public void test2()
    {
        TypeAliasRegistry registry = new TypeAliasRegistry();
        registry.registerAlias(AliasTests.class);

//        Class<User> user = registry.resolveAlias("com.zsj.mybatis.type.AliasTests");

        Map<String, Class<?>> typeAliases = registry.getTypeAliases();
        typeAliases.forEach((k,v) -> {
            System.out.println(k + ": " + v);
        });

        typeAliases.put("as", Object.class);
    }

    /**
     *  通过包名注册包内的所有类到别名映射表中
     */
    @Test
    public void test3()
    {
        TypeAliasRegistry registry = new TypeAliasRegistry();
        registry.registerAliases("com.zsj.mybatis.custom");

        Map<String, Class<?>> typeAliases = registry.getTypeAliases();
        typeAliases.forEach((k,v) -> System.out.println(k + ":" + v));
    }

    @Alias("user")
    public static class User{
        private String id;
        private String name;
    }

}
