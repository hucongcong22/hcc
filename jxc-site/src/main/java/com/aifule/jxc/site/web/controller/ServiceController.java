package com.aifule.jxc.site.web.controller;

import com.aifule.jxc.core.bo.GoodsBo;
import com.aifule.jxc.core.domain.Admins;
import com.aifule.jxc.core.domain.Goods;
import com.aifule.jxc.site.service.ServiceService;
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
public class ServiceController extends WebController {
    @Resource
    private ServiceService serviceService;

    /**
     * 新上架的手机
     *
     * @param httpSession
     * @return
     */
    @RequestMapping(value = "/Service/newGoods", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> newGoods(HttpSession httpSession) {
        List<GoodsBo> goodsBoList = serviceService.newgoods();
        return getResultMap(goodsBoList);
    }

    /**
     * 手机优惠
     *
     * @param httpSession
     * @return
     */
    @RequestMapping(value = "/Service/youhu", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> youhu(HttpSession httpSession) {
        List<GoodsBo> goodsBoList = serviceService.tehui();
        return getResultMap(goodsBoList);
    }

    @RequestMapping(value = "/Service/pingpai", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> cha(@RequestBody Goods goods, HttpSession httpSession) {
        List<GoodsBo> goodsBoList = serviceService.piinpai(goods);
        return getResultMap(goodsBoList);
    }
}
