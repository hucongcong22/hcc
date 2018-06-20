package com.aifule.jxc.site.service;

import com.aifule.jxc.core.bo.GoodsBo;
import com.aifule.jxc.core.dao.mysql.GoodsMapper;
import com.aifule.jxc.core.dao.mysql.GoodsleiMapper;
import com.aifule.jxc.core.dao.mysql.GoodsmiaoMapper;
import com.aifule.jxc.core.domain.Goods;
import com.aifule.jxc.core.domain.Goodsmiao;
import com.aifule.jxc.core.mybatispage.Page;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class ServiceService {
    @Resource
    private GoodsMapper goodsMapper;
    @Resource
    private GoodsleiMapper goodsleiMapper;
    @Resource
    private GoodsmiaoMapper goodsmiaoMapper;

    /**
     * 特价商品
     *
     * @return
     */
    public List<GoodsBo> tejia() {
        List<GoodsBo> goodsBoList = new ArrayList<>();
        return goodsBoList;
    }

    /**
     * 新上架的商品
     *
     * @return
     */
    public List<GoodsBo> newgoods() {
        List<GoodsBo> goodsBoList = new ArrayList<>();
        List<Goods> goodsList = goodsMapper.sxinshang(new Page());
        for (Goods g : goodsList
                ) {
            GoodsBo goodsBo = new GoodsBo(g);
            Goodsmiao goodsmiao = goodsmiaoMapper.selectByPrimaryKey(g.getGid());
            if (goodsmiao != null) {
                goodsBo.setTupian(goodsmiao.getTupian());
                goodsBo.setMiao(goodsmiao.getMiao());
                goodsBo.setYmoney(goodsmiao.getYmoney());
            }
            goodsBoList.add(goodsBo);
        }
        return goodsBoList;
    }

    /**
     * 优惠价加排序
     *
     * @return
     */
    public List<GoodsBo> tehui() {
        List<GoodsBo> goodsBoList = new ArrayList<>();
        List<Goods> goodsList = goodsMapper.selectsBySelective(new Goods(), new Page());
        List<Goodsmiao> goodsmiaos = goodsmiaoMapper.selectsBySelective(new Goodsmiao(), new Page());
        for (Goods gf : goodsList
                ) {
            GoodsBo goodsBo = new GoodsBo(gf);
            goodsBo.setLname(goodsleiMapper.selectByPrimaryKey(gf.getLid()).getLname());
            for (Goodsmiao gm : goodsmiaos
                    ) {
                if (gf.getGid() == gm.getGid()) {
                    goodsBo.setGaid(gm.getGaid());
                    goodsBo.setYmoney(gm.getYmoney());
                    goodsBo.setTupian(gm.getTupian());
                    goodsBo.setMiao(gm.getMiao());
                }
            }
            goodsBoList.add(goodsBo);
        }
        Collections.sort(goodsBoList, new Comparator<GoodsBo>() {

            @Override
            public int compare(GoodsBo o1, GoodsBo o2) {
                int i = new Double(o2.getPrice() - o2.getYmoney()).compareTo(new Double(o1.getPrice() - o1.getYmoney()));
                if (i == 0) {
                    return new Double(o2.getPrice()).compareTo(new Double(o1.getPrice()));
                }
                return i;
            }
        });
        return goodsBoList;
    }

    /**
     * 根据手机类型查手机
     *
     * @param goods
     * @return
     */
    public List<GoodsBo> piinpai(Goods goods) {
        List<GoodsBo> goodsBoList = new ArrayList<>();
        List<Goods> goodsList = goodsMapper.selectsBySelective(goods, new Page());
        for (Goods gf : goodsList
                ) {
            GoodsBo goodsBo = new GoodsBo(gf);
            Goodsmiao goodsmiao = new Goodsmiao();
            goodsmiao.setGid(gf.getGid());
            List<Goodsmiao> goodsmiaoList = goodsmiaoMapper.selectsBySelective(goodsmiao, new Page());
            for (Goodsmiao gg : goodsmiaoList
                    ) {
                goodsBo.setYmoney(gg.getYmoney());
                goodsBo.setMiao(gg.getMiao());
                goodsBo.setTupian(gg.getTupian());
                goodsBo.setGaid(gg.getGaid());
            }
            goodsBoList.add(goodsBo);
        }
        return goodsBoList;
    }
}
