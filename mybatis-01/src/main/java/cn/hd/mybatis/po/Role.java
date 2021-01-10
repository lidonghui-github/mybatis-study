package cn.hd.mybatis.po;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
public class Role implements Serializable {
    private long id;
    private String roleName;
    private String note;
}
