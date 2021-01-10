package cn.hd.mybatis.po;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Student {
    private long id;
    private String name;
    private Classes classes;
}
