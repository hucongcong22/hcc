package com.aifule.jxc.site.web.controller;


import com.aifule.jxc.core.bo.GoodsBo;
import com.aifule.jxc.core.domain.*;
import com.aifule.jxc.core.mybatispage.Page;
import com.aifule.jxc.site.common.util.FileUtil;
import com.aifule.jxc.site.service.GoodsService;
import com.aifule.jxc.site.service.GoodsleiService;
import com.aifule.jxc.site.vo.Goodsvo;
import com.aifule.jxc.site.web.WebController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;


@Controller
public class GoodsController extends WebController {
    @Resource
    private GoodsService goodsService;
    @Resource
    private GoodsleiService goodsleiService;

    /**
     * 商品添加
     *
     * @param fileToUpload
     * @param request
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/goods/upload", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> upload(@RequestParam("file") MultipartFile fileToUpload, HttpServletRequest request) throws IOException {
        boolean up = goodsService.tianjia(fileToUpload, request);
        String gname = request.getParameter("gname");
        System.out.print(gname);

        return getResultMap(up);

    }


    /**
     * 获得所有手机类型
     *
     * @param httpSession
     * @return
     */
    @RequestMapping(value = "/goods/goodslei", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> goodslei(@RequestBody Goodslei goodslei, HttpSession httpSession) {
        List<Goodslei> list = goodsleiService.suoyou(httpSession);
        return getResultMap(list);
    }


    /**
     * 添加手机类型
     *
     * @param goodslei
     * @param httpSession
     * @return
     */
    @RequestMapping(value = "/goods/tjlei", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> tianjialei(@RequestBody Goodslei goodslei, HttpSession httpSession) {
        boolean list = goodsleiService.tj(goodslei);
        return getResultMap(list);
    }

    /**
     * 获得所有手机属性
     *
     * @param httpSession
     * @return
     */
    @RequestMapping(value = "/goods/allshow", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> allShow(HttpSession httpSession, @RequestBody Page page) {
        List<GoodsBo> list = goodsService.allgoods(page);
        return getResultMap(list);
    }


    /**
     * 手机上下架
     *
     * @param httpSession
     * @param goods
     * @return
     */

    @RequestMapping(value = "/goods/zhuantai", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> gstart(HttpSession httpSession, @RequestBody Goods goods) {
        boolean sd = goodsService.xiajia(goods);
        return getResultMap(sd);
    }

    /**
     * 修改手机优惠
     *
     * @param httpSession
     * @param goodsmiao
     * @return
     */
    @RequestMapping(value = "/goods/xiougai", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> xiougai(HttpSession httpSession, @RequestBody Goodsmiao goodsmiao) {
        boolean sd = goodsService.xiougai(goodsmiao);
        return getResultMap(sd);
    }

}
