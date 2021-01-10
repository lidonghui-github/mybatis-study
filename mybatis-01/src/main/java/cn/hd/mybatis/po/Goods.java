package cn.hd.mybatis.po;

import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString
public class Goods {
    private long id;
    private String name;
    List<Customer> customers;
}
