package cn.hd.mybatis.main;

import cn.hd.mybatis.mapper.ClassesMapper;
import cn.hd.mybatis.po.Classes;
import cn.hd.mybatis.util.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;

public class ClassesTest {
    public static void main(String[] args) {
        //test1();
        test2();
    }

    public static void test1() {
        SqlSession sqlSession = null;
        try {

            sqlSession = SqlSessionFactoryUtil.openSqlSession();
            System.out.println("sqlSession--->:" + sqlSession);

            ClassesMapper classesMapper = sqlSession.getMapper(ClassesMapper.class);
            for (int k = 1; k <= 10; k++) {
                Classes classes = new Classes();
                classes.setName("班级" + k);
                int s = classesMapper.saveClasses(classes);
                System.out.println(s);
            }
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


    public static void test2() {
        SqlSession sqlSession = null;
        try {

            sqlSession = SqlSessionFactoryUtil.openSqlSession();
            System.out.println("sqlSession--->:" + sqlSession);

            ClassesMapper classesMapper = sqlSession.getMapper(ClassesMapper.class);
            Classes classes = classesMapper.findClassesById(1L);
            System.out.println(classes);
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
}
