package cn.hd.mybatis.mapper;

import cn.hd.mybatis.po.Role;

import java.util.List;

public interface RoleMapper {
    public Role getRole(long id);

    public int saveRole(Role role);

    public int saveBatch(List<Role> list);

    public int updateBatch(List<Long> list);

    public int deleteBatch(List<Long> list);

    public List<Role> findBatch(List<Long> list);
}
