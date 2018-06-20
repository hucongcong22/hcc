package com.aifule.jxc.site.service;


import com.aifule.jxc.core.dao.mysql.GoodsleiMapper;
import com.aifule.jxc.core.domain.Goodslei;
import com.aifule.jxc.core.mybatispage.Page;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class GoodsleiService {
    @Resource
    private GoodsleiMapper goodsleiMapper;

    /**
     * 获取手机类型
     *
     * @return
     */

    public List<Goodslei> suoyou(HttpSession httpSession) {
        List<Goodslei> list = goodsleiMapper.selectsBySelective(new Goodslei(), new Page());
        httpSession.setAttribute("goodsList", list);
        return list;
    }

    /**
     * 添加手机类型
     *
     * @return
     */
    public boolean tj(Goodslei goodslei) {
        int s = goodsleiMapper.insertSelective(goodslei);
        if (s != 0) {
            return true;
        } else {
            return false;
        }

    }
}
