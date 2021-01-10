package cn.hd.mybatis.mapper;

import cn.hd.mybatis.po.Husband;

public interface HusbandMapper {
    public int saveHusband(Husband husband);
    public Husband findHusbandById(long id);
}
