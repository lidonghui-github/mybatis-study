package cn.hd.mybatis.po;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Husband {
    private long id;
    private String name;
    private Wife wife;
}
