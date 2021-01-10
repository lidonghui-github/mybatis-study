package cn.hd.mybatis.mapper;

import cn.hd.mybatis.po.Goods;

public interface GoodsMapper {
    public int saveGoods(Goods goods);

    public Goods findGoodsById(long id);
}
