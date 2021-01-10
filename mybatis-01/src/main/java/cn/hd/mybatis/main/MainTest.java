package cn.hd.mybatis.main;

import cn.hd.mybatis.mapper.RoleMapper;
import cn.hd.mybatis.po.Role;
import cn.hd.mybatis.util.SqlSessionFactoryUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * 主测试类
 * 2021-1-4
 */
public class MainTest {
    public static void main(String[] args) {
        // test1();
        // test2();
        //  System.out.println("*************************");
        //  test3();
        //  testSaveBatch();
        // testFindBatch();
        //  testUpdateBatch();
        //  testFindBatch();
     //   testDeleteBatch();
    //    testFindBatch();

        test4();
    }

    public static void test1() {
        try {
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            System.out.println("sqlSessionFactory--->:" + sqlSessionFactory);
            SqlSession sqlSession = sqlSessionFactory.openSession();
            System.out.println("sqlSession--->:" + sqlSession);
            Object o = sqlSession.selectOne("cn.hd.mybatis.mapper.RoleMapper.getRole", 1L);
            System.out.println(o);

            RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
            Role role = roleMapper.getRole(3L);
            System.out.println(role);
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
    }

    public static void test2() {
        SqlSession sqlSession = null;
        try {
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            System.out.println("sqlSessionFactory--->:" + sqlSessionFactory);
            sqlSession = sqlSessionFactory.openSession();
            System.out.println("sqlSession--->:" + sqlSession);
            Object o = sqlSession.selectOne("cn.hd.mybatis.mapper.RoleMapper.getRole", 1L);
            System.out.println(o);

            RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);

            Role role = new Role();
            role.setRoleName("sxy");
            role.setNote("hwuigi");
            roleMapper.saveRole(role);
            sqlSession.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            if (sqlSession != null) {
                sqlSession.rollback();
            }

        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }


    public static void test3() {
        SqlSession sqlSession = null;
        try {

            sqlSession = SqlSessionFactoryUtil.openSqlSession();
            System.out.println("sqlSession--->:" + sqlSession);

            RoleMapper mapper = sqlSession.getMapper(RoleMapper.class);
            Role role = mapper.getRole(10L);
            System.out.println(role);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            if (sqlSession != null) {
                sqlSession.rollback();
            }

        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }

    public static void testSaveBatch() {
        SqlSession sqlSession = null;
        try {

            sqlSession = SqlSessionFactoryUtil.openSqlSession();
            System.out.println("sqlSession--->:" + sqlSession);

            RoleMapper mapper = sqlSession.getMapper(RoleMapper.class);
            List<Role> list = new ArrayList<>();
            for (int k = 1; k < 50; k++) {
                Role role = new Role();
                role.setRoleName("ldh-sxy:" + k);
                role.setNote("test:" + k);
                list.add(role);
            }
            int i = mapper.saveBatch(list);
            System.out.println("保存了:" + i);
            sqlSession.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            if (sqlSession != null) {
                sqlSession.rollback();
            }

        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }

    public static void testFindBatch() {
        SqlSession sqlSession = null;
        try {

            sqlSession = SqlSessionFactoryUtil.openSqlSession();
            System.out.println("sqlSession--->:" + sqlSession);

            RoleMapper mapper = sqlSession.getMapper(RoleMapper.class);
            List<Long> list = new ArrayList<>();
            for (int k = 1; k < 50; k++) {

                list.add(Long.parseLong("" + k));
            }
            List<Role> batch = mapper.findBatch(list);
            System.out.println("查询了:" + batch);
            sqlSession.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            if (sqlSession != null) {
                sqlSession.rollback();
            }

        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }

    public static void testUpdateBatch() {
        SqlSession sqlSession = null;
        try {

            sqlSession = SqlSessionFactoryUtil.openSqlSession();
            System.out.println("sqlSession--->:" + sqlSession);

            RoleMapper mapper = sqlSession.getMapper(RoleMapper.class);
            List<Long> list = new ArrayList<>();
            for (int k = 1; k < 50; k++) {

                list.add(Long.parseLong("" + k));
            }
            int i = mapper.updateBatch(list);
            System.out.println("更新了:" + i);
            sqlSession.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            if (sqlSession != null) {
                sqlSession.rollback();
            }

        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }


    public static void testDeleteBatch() {
        SqlSession sqlSession = null;
        try {

            sqlSession = SqlSessionFactoryUtil.openSqlSession();
            System.out.println("sqlSession--->:" + sqlSession);

            RoleMapper mapper = sqlSession.getMapper(RoleMapper.class);
            List<Long> list = new ArrayList<>();
            for (int k = 1; k < 10; k++) {

                list.add(Long.parseLong("" + k));
            }
            int i = mapper.deleteBatch(list);
            System.out.println("删除了:" + i);
            sqlSession.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            if (sqlSession != null) {
                sqlSession.rollback();
            }

        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }


    public static void test4() {
        SqlSession sqlSession = null;
        try {

            sqlSession = SqlSessionFactoryUtil.openSqlSession();
            System.out.println("sqlSession--->:" + sqlSession);

            RoleMapper mapper = sqlSession.getMapper(RoleMapper.class);
            Role role = mapper.getRole(69L);
            System.out.println(role);
            System.out.println("************");
            Role role1 = mapper.getRole(69L);
            System.out.println(role1);
            sqlSession.commit();
            RoleMapper mapper2 = sqlSession.getMapper(RoleMapper.class);
            Role role2 = mapper2.getRole(69L);
            System.out.println(role2);
            sqlSession.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
    }

}
