package cn.hd.mybatis.po;

import lombok.Data;
import lombok.ToString;

import java.util.List;

@ToString
@Data
public class Customer {
    private long id;
    private String name;
    private List<Goods> goods;

}
