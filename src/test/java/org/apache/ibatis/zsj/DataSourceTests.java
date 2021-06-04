package org.apache.ibatis.zsj;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.session.SqlSessionManager;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Proxy;

/**
 * @Auther: zhangshengjun
 * @Date: 2021/6/4
 * @Description:
 */
public class DataSourceTests {


    @Test
    public void test1() {
        try {
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession sqlSession = factory.openSession();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test2() {
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionManager sqlSessionManager = SqlSessionManager.newInstance(inputStream);
            sqlSessionManager.startManagedSession();
            sqlSessionManager.selectList("");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
