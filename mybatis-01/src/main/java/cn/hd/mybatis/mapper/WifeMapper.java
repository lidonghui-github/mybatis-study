package cn.hd.mybatis.mapper;

import cn.hd.mybatis.po.Wife;

public interface WifeMapper {
    public int saveWife(Wife wife);
    public Wife findWifeById(long id);
}
