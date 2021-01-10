package cn.hd.mybatis.main;

import cn.hd.mybatis.mapper.HusbandMapper;
import cn.hd.mybatis.mapper.WifeMapper;
import cn.hd.mybatis.po.Husband;
import cn.hd.mybatis.po.Wife;
import cn.hd.mybatis.util.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;

public class WifeTest {
    public static void main(String[] args) {
        //test1();
        test2();
    }

    public static void test1() {
        SqlSession sqlSession = null;
        try {

            sqlSession = SqlSessionFactoryUtil.openSqlSession();
            System.out.println("sqlSession--->:" + sqlSession);

            WifeMapper wifeMapper = sqlSession.getMapper(WifeMapper.class);
            for (int k = 1; k <= 10; k++) {
                Wife wife = new Wife();
                wife.setName("sxy" + k);
                int s = wifeMapper.saveWife(wife);
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

            WifeMapper wifeMapper = sqlSession.getMapper(WifeMapper.class);
            Wife wife = wifeMapper.findWifeById(2L);
            System.out.println(wife);
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
