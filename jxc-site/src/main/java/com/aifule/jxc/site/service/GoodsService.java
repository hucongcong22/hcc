package com.aifule.jxc.site.service;


import com.aifule.jxc.core.bo.GoodsBo;
import com.aifule.jxc.core.dao.mysql.GoodsMapper;
import com.aifule.jxc.core.dao.mysql.GoodsleiMapper;
import com.aifule.jxc.core.dao.mysql.GoodsmiaoMapper;
import com.aifule.jxc.core.dao.mysql.PhotosMapper;
import com.aifule.jxc.core.domain.Goods;
import com.aifule.jxc.core.domain.Goodsmiao;
import com.aifule.jxc.core.mybatispage.Page;
import com.aifule.jxc.site.common.util.FileUtil;
import com.aifule.jxc.site.gongzhu.DataObtain;
import com.aifule.jxc.site.gongzhu.WriteFile;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Service
public class GoodsService {
    @Resource
    private GoodsMapper goodsMapper;
    @Resource
    private GoodsmiaoMapper goodsmiaoMapper;
    @Resource
    private GoodsleiMapper goodsleiMapper;
    @Resource
    private PhotosMapper photosMapper;

    /**
     * 添加商品
     *
     * @return
     */
    public boolean tianjia(MultipartFile fileToUpload, HttpServletRequest request) {
        String rootPath = request.getSession().getServletContext().getRealPath("ck/images/");
        FileUtil fileUtil = new FileUtil();
        String wenjian = "b";
        wenjian += fileUtil.uploading(fileToUpload, rootPath);
        String gname, lid, miao, prize;
        gname = request.getParameter("gname");
        lid = request.getParameter("lid");
        miao = request.getParameter("miao");
        prize = request.getParameter("price");
        Goods goods = new Goods();
        Goodsmiao goodsmiao = new Goodsmiao();
        goods.setGdate(new DataObtain().dataMos());
        goods.setGname(gname);
        goods.setPrice(Double.parseDouble(prize));
        goods.setLid(Integer.parseInt(lid));
        goods.setGstate("上架");
        int id = goodsMapper.insertSelective(goods);
        if (id != 0) {
            int gid = 0;
            for (Goods d : goodsMapper.selectsBySelective(goods, new Page())
                    ) {
                gid = d.getGid();
            }
            goodsmiao.setGid(gid);
            goodsmiao.setMiao(miao);
            goodsmiao.setYmoney(Double.parseDouble(prize));
            goodsmiao.setTupian(wenjian);
            int sd = goodsmiaoMapper.insertSelective(goodsmiao);
            if (sd != 0) {
                return true;
            }
            return false;

        }
        return false;

    }

    /**
     * 获取当前页所有商品信息
     *
     * @param page
     * @return
     */

    public List<GoodsBo> allgoods(Page page) {
        List<GoodsBo> goodsBoList = new ArrayList<>();
        List<Goods> goodsList = goodsMapper.selectsBySelective(new Goods(), page);
        List<Goodsmiao> goodsmiaos = goodsmiaoMapper.selectsBySelective(new Goodsmiao(), page);
        for (Goods gf : goodsList
                ) {
            GoodsBo goodsBo = new GoodsBo(gf);
            goodsBo.setLname(goodsleiMapper.selectByPrimaryKey(gf.getLid()).getLname());
            for (Goodsmiao gm : goodsmiaos
                    ) {
                if (gf.getGid() == gm.getGid()) {
                    goodsBo.setGaid(gm.getGaid());
                    goodsBo.setYmoney(gm.getYmoney());
                    goodsBo.setMiao(gm.getMiao());
                    goodsBo.setTupian(gm.getTupian());
                }
            }
            goodsBoList.add(goodsBo);
        }
        return goodsBoList;
    }

    /**
     * 修改
     *
     * @param goodsmiao
     * @return
     */
    public boolean xiougai(Goodsmiao goodsmiao) {
        int d = goodsmiaoMapper.updateByPrimaryKeySelective(goodsmiao);
        if (d != 0) {
            return true;
        } else {
            return false;
        }

    }

    /**
     * 手机下架
     *
     * @param goods
     * @return
     */
    public boolean xiajia(Goods goods) {
        int s = goodsMapper.updateByPrimaryKeySelective(goods);
        if (s != 0) {
            return true;
        } else {
            return false;
        }
    }

}
