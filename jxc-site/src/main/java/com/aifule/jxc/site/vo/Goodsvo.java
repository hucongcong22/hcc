package com.aifule.jxc.site.vo;

import com.aifule.jxc.core.domain.Goods;
import com.aifule.jxc.core.domain.Goodslei;
import com.aifule.jxc.core.domain.Goodsmiao;

public class Goodsvo extends Goods {
    private Goods goods;
    private Goodsmiao goodsmiao;
    private Goodslei goodslei;

    public Goodsmiao getGoodsmiao() {
        return goodsmiao;
    }

    public void setGoodsmiao(Goodsmiao goodsmiao) {
        this.goodsmiao = goodsmiao;
    }

    public Goods getGoods() {

        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public Goodslei getGoodslei() {
        return goodslei;
    }

    public void setGoodslei(Goodslei goodslei) {
        this.goodslei = goodslei;
    }

    public Goodsvo() {
    }

    public void GoodsVo(Goods goods, Goodslei goodslei, Goodsmiao goodsmiao) {
        this.goodsmiao = goodsmiao;
        this.goods = goods;
        this.goodslei = goodslei;
    }
}
