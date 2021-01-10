package cn.hd.mybatis.mapper;

import cn.hd.mybatis.po.Classes;

public interface ClassesMapper {
    public int saveClasses(Classes classes);
    public Classes findClassesById(long id);
}
