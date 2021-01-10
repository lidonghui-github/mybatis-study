package cn.hd.mybatis.mapper;

import cn.hd.mybatis.po.Student;

public interface StudentMapper {
    public int saveStudent(Student student);
    public Student findStudentById(long id);
}
