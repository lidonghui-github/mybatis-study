package cn.hd.mybatis.po;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Wife {
    private long id;
    private String name;
    private Husband husband;
}
