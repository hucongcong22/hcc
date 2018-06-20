package com.aifule.jxc.site.service;


import com.aifule.jxc.core.bo.OdersxingVo;
import com.aifule.jxc.core.bo.OrdersVo;
import com.aifule.jxc.core.dao.mysql.*;
import com.aifule.jxc.core.domain.*;
import com.aifule.jxc.core.mybatispage.Page;
import com.aifule.jxc.site.gongzhu.DataObtain;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Service
public class CatgoodsService {
    @Resource
    OrdersMapper ordersMapper;
    @Resource
    OdersxiangMapper odersxiangMapper;
    @Resource
    UsersMapper usersMapper;
    @Resource
    GoodsMapper goodsMapper;
    @Resource
    GoodsmiaoMapper goodsmiaoMapper;

    /**
     * 添加购物车
     *
     * @param odersxiang
     * @param httpSession
     */
    public boolean chuan(Odersxiang odersxiang, HttpSession httpSession) {
        int sd = 0;
        List<Orders> ordersList = new ArrayList<>();
        List<Odersxiang> odersxiangList = new ArrayList<>();
        Object oid = httpSession.getAttribute("_OID");
        int oid1 = 0;
        if (oid == null) {
            Object uid = httpSession.getAttribute("_UID");
            Users users = usersMapper.selectByPrimaryKey(Integer.parseInt(uid.toString()));
            Orders orders = new Orders();
            orders.setOderstate("预交易");
            orders.setUid(users.getUid());
            orders.setAddress(users.getAddress());
            ordersList = ordersMapper.selectsBySelective(orders, new Page());
            if (ordersList.size() == 0) {
                ordersMapper.insertSelective(orders);
                ordersList = ordersMapper.selectsBySelective(orders, new Page());
            }
            for (Orders oa : ordersList
                    ) {
                oid1 = oa.getOid();
                httpSession.setAttribute("_OID", oid1);
            }
        } else {
            oid1 = Integer.parseInt(oid.toString());
        }
        odersxiang.setOid(oid1);
        odersxiangList = odersxiangMapper.selectsByOneKey("oid", oid1, new Page());
        System.out.print(odersxiangList.size());
        if (odersxiangList.size() == 0) {
            //检查订单详情有没有这件商品没有就添加
            int s = odersxiangMapper.insertSelective(odersxiang);
            if (s != 0) {
                return true;
            } else {
                return false;
            }
        } else {
            for (Odersxiang rt : odersxiangList
                    ) {
                if (rt.getGid() == odersxiang.getGid()) {
                    rt.setOderprize(rt.getOderprize() + odersxiang.getOderprize());
                    rt.setShuliang(rt.getShuliang() + odersxiang.getShuliang());
                    rt.setZhekou(odersxiang.getZhekou());
                    sd = odersxiangMapper.updateByPrimaryKeySelective(rt);
                }
            }
            if (sd != 0) {
                return true;
            } else {
                sd = odersxiangMapper.insertSelective(odersxiang);
                if (sd != 0) {
                    return true;
                }
                return false;
            }
        }
    }

    /**
     * 前台查看订单
     *
     * @param httpSession
     * @return
     */
    public List<Orders> chakan(HttpSession httpSession) {
        Object uid = httpSession.getAttribute("_UID");
        Orders orders = new Orders();
        orders.setOderstate("预交易");
        orders.setUid(Integer.parseInt(uid.toString()));
        List<Orders> ordersList = ordersMapper.selectsBySelective(orders, new Page());
        for (Orders df : ordersList
                ) {
            double money = 0d;
            Odersxiang odersxiang = new Odersxiang();
            odersxiang.setOid(df.getOid());
            List<Odersxiang> odersxiangList = odersxiangMapper.selectsBySelective(odersxiang, new Page());
            for (Odersxiang od : odersxiangList
                    ) {
                money += od.getOderprize();
            }
            df.setMoney(money);
            ordersMapper.updateByPrimaryKeySelective(df);
        }
        return ordersList;
    }

    /**
     * 所有订单
     *
     * @return
     */
    public List<OrdersVo> allOrders() {
        List<Orders> ordersList = ordersMapper.selectsBySelective(new Orders(), new Page());
        List<OrdersVo> ordersVoList = new ArrayList<>();

        for (Orders sa : ordersList
                ) {

            OrdersVo ordersVo = new OrdersVo(sa);
            Users users = usersMapper.selectByPrimaryKey(sa.getUid());
            ordersVo.setUname(users.getUname());
            ordersVo.setDatea(sa.getOdate());
            ordersVoList.add(ordersVo);

        }
        return ordersVoList;
    }

    /**
     * 查看订单详情
     *
     * @param odersxiang
     * @return
     */
    public List<OdersxingVo> xiangqing(Odersxiang odersxiang) {
        List<Odersxiang> odersxiangList = odersxiangMapper.selectsBySelective(odersxiang, new Page());
        List<OdersxingVo> odersxingVoList = new ArrayList<>();
        for (Odersxiang xs : odersxiangList
                ) {
            OdersxingVo odersxingVo = new OdersxingVo(xs);
            Goods goods = goodsMapper.selectByPrimaryKey(xs.getGid());
            Goodsmiao goodsmiao = goodsmiaoMapper.selectByPrimaryKey(xs.getGid());
            odersxingVo.setGname(goods.getGname());
            odersxingVo.setPrice(goods.getPrice());
            odersxingVo.setTupian(goodsmiao.getTupian());
            odersxingVo.setMiao(goodsmiao.getMiao());
            odersxingVoList.add(odersxingVo);

        }
        return odersxingVoList;
    }


    /**
     * 删除所商品
     *
     * @param odersxiang
     */
    public void delect(Odersxiang odersxiang) {
        odersxiangMapper.deleteByPrimaryKey(odersxiang.getOderid());
    }


    /**
     * 结算
     *
     * @param orders
     * @return
     */
    public boolean jieshuan(Orders orders) {
        DataObtain dataObtain = new DataObtain();
        orders.setOdate(dataObtain.dataMos());
        orders.setOderstate("交易完成");
        int sf = ordersMapper.updateByPrimaryKeySelective(orders);
        if (sf != 0) {
            return true;
        }
        return false;
    }

    public boolean gaibian(Orders orders) {
        int sd = ordersMapper.updateByPrimaryKeySelective(orders);
        if (sd != 0) {
            return true;
        }
        return false;
    }
}
