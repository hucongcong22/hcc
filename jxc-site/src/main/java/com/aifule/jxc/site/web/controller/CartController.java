package com.aifule.jxc.site.web.controller;

import com.aifule.jxc.core.bo.OdersxingVo;
import com.aifule.jxc.core.bo.OrdersVo;
import com.aifule.jxc.core.dao.mysql.UsersMapper;
import com.aifule.jxc.core.domain.Odersxiang;
import com.aifule.jxc.core.domain.Orders;
import com.aifule.jxc.core.domain.Users;
import com.aifule.jxc.site.service.CatgoodsService;
import com.aifule.jxc.site.web.WebController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
public class CartController extends WebController {
    @Resource
    CatgoodsService catgoodsService;


    /**
     * 向购物车添加商品
     *
     * @param odersxiang
     * @param httpSession
     * @return
     */
    @RequestMapping(value = "/cart/tianjia", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> tianjia(@RequestBody Odersxiang odersxiang, HttpSession httpSession) {
        boolean ss = catgoodsService.chuan(odersxiang, httpSession);
        return getResultMap(ss);
    }

    /**
     * 用户的订单
     *
     * @param httpSession
     * @return
     */
    @RequestMapping(value = "/cart/ding", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> ding(HttpSession httpSession) {
        List<Orders> ordersList = catgoodsService.chakan(httpSession);
        return getResultMap(ordersList);
    }


    /**
     * 订单详情
     *
     * @param odersxiang
     * @param httpSession
     * @return
     */

    @RequestMapping(value = "/cart/xiangping", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> xiangqing(@RequestBody Odersxiang odersxiang, HttpSession httpSession) {
        List<OdersxingVo> ordersList = catgoodsService.xiangqing(odersxiang);
        return getResultMap(ordersList);
    }

    /**
     * 所有订单
     *
     * @param odersxiang
     * @param httpSession
     * @return
     */
    @RequestMapping(value = "/cart/allding", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> allding(@RequestBody Odersxiang odersxiang, HttpSession httpSession) {
        List<OrdersVo> ordersList = catgoodsService.allOrders();
        return getResultMap(ordersList);
    }

    /**
     * 删除
     *
     * @param odersxiang
     * @param httpSession
     * @return
     */
    @RequestMapping(value = "/cart/delect", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> delect(@RequestBody Odersxiang odersxiang, HttpSession httpSession) {
        catgoodsService.delect(odersxiang);
        return getResultMap("asas");
    }


    /**
     * 结算
     *
     * @param orders
     * @param httpSession
     * @return
     */
    @RequestMapping(value = "/cart/jieshuan", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> jieshuan(@RequestBody Orders orders, HttpSession httpSession) {
        boolean sd = catgoodsService.jieshuan(orders);
        return getResultMap(sd);
    }


    @RequestMapping(value = "/cart/gaibian", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> gaibian(@RequestBody Orders orders, HttpSession httpSession) {
        boolean sd = catgoodsService.gaibian(orders);
        return getResultMap(sd);
    }

}
