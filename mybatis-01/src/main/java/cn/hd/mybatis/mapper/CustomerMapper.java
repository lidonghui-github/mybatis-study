package cn.hd.mybatis.mapper;

import cn.hd.mybatis.po.Customer;

public interface CustomerMapper {
    public int saveCustomer(Customer customer);

    public Customer findCustomerById(long id);
}
