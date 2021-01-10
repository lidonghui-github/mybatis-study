package cn.hd.mybatis.po;

import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString
public class Classes {
    private long id;
    private String name;
    private List<Student> students;
}
