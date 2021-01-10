package cn.hd.mybatis.main;

import cn.hd.mybatis.mapper.HusbandMapper;
import cn.hd.mybatis.po.Husband;
import cn.hd.mybatis.util.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;

public class HusbandTest {
    public static void main(String[] args) {
       // test1();
        test2();
    }

    public static void test1() {
        SqlSession sqlSession = null;
        try {

            sqlSession = SqlSessionFactoryUtil.openSqlSession();
            System.out.println("sqlSession--->:" + sqlSession);

            HusbandMapper husbandMapper = sqlSession.getMapper(HusbandMapper.class);
            for (int k=2;k<=10;k++) {
                Husband husband = new Husband();
                husband.setName("ldh"+k);
                int s = husbandMapper.saveHusband(husband);
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

            HusbandMapper husbandMapper = sqlSession.getMapper(HusbandMapper.class);
            Husband husband = husbandMapper.findHusbandById(1L);
            System.out.println(husband);
            System.out.println("*********");
            Husband husband2 = husbandMapper.findHusbandById(1L);
            System.out.println(husband2);
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
