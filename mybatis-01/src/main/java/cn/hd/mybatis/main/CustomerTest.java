package cn.hd.mybatis.main;


import cn.hd.mybatis.mapper.CustomerMapper;
import cn.hd.mybatis.po.Customer;
import cn.hd.mybatis.util.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
public class CustomerTest {
    public static void main(String[] args) {
       // test1();
        test2();
    }
    public static void test1() {
        SqlSession sqlSession = null;
        try {

            sqlSession = SqlSessionFactoryUtil.openSqlSession();
            System.out.println("sqlSession--->:" + sqlSession);

            CustomerMapper customerMapper = sqlSession.getMapper(CustomerMapper.class);
            for (int k = 1; k <= 10; k++) {
                Customer customer = new Customer();
                customer.setName("顾客" + k);
                int s = customerMapper.saveCustomer(customer);
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

            CustomerMapper customerMapper = sqlSession.getMapper(CustomerMapper.class);
            Customer customer = customerMapper.findCustomerById(1L);
            System.out.println(customer);
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
