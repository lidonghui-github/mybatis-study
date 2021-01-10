package cn.hd.mybatis.main;

import cn.hd.mybatis.mapper.GoodsMapper;
import cn.hd.mybatis.po.Goods;
import cn.hd.mybatis.util.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;

public class GoodsTest {
    public static void main(String[] args) {
       // test1();
        test2();
    }

    public static void test1() {
        SqlSession sqlSession = null;
        try {

            sqlSession = SqlSessionFactoryUtil.openSqlSession();
            System.out.println("sqlSession--->:" + sqlSession);

            GoodsMapper goodsMapper = sqlSession.getMapper(GoodsMapper.class);
            for (int k = 1; k <= 10; k++) {
                Goods goods = new Goods();
                goods.setName("商品" + k);
                int s = goodsMapper.saveGoods(goods);
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

            GoodsMapper goodsMapper = sqlSession.getMapper(GoodsMapper.class);
            Goods goods = goodsMapper.findGoodsById(1L);
            System.out.println(goods);
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
