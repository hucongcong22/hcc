package com.aifule.jxc.site.service;


import com.aifule.jxc.core.dao.mysql.AdminsMapper;
import com.aifule.jxc.core.domain.Admins;
import com.aifule.jxc.core.mybatispage.Page;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class AdminsService {
    @Resource
    private AdminsMapper adminsMapper;


    /**
     * 登陆
     *
     * @param admin
     * @param httpSession
     * @return
     */
    public boolean login(Admins admin, HttpSession httpSession) {
        List<Admins> admins1 = adminsMapper.selectsBySelective(admin, new Page());

        if (admins1.size() == 0) {
            return false;
        } else {
            for (Admins ad : admins1) {
                httpSession.setAttribute("_ADMINS_ID", ad.getAid());
                httpSession.setAttribute("_ADMINS_ANAME", ad.getAname());
            }
            return true;
        }
    }

    /**
     * 修改密码
     *
     * @param admins
     * @param httpSession
     * @return
     */
    public boolean xiougai(Admins admins, HttpSession httpSession) {
        admins.setAid(Integer.parseInt(String.valueOf(httpSession.getAttribute("_ADMINS_ID"))));
        int xg = adminsMapper.updateByPrimaryKeySelective(admins);
        System.out.print(xg);
        if (xg == 0) {
            return false;
        } else {
            return true;
        }

    }
}
