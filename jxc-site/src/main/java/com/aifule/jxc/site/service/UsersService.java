package com.aifule.jxc.site.service;

import com.aifule.jxc.core.dao.mysql.UsersMapper;

import com.aifule.jxc.core.domain.Users;

import com.aifule.jxc.core.mybatispage.Page;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;


@Service
public class UsersService {
    @Resource
    UsersMapper usersMapper;

    /**
     * 用户登陆
     *
     * @param users
     * @param httpSession
     * @return
     */
    public boolean login(Users users, HttpSession httpSession) {
        List<Users> users1 = usersMapper.selectsBySelective(users, new Page());
        if (users1.size() != 0) {
            for (Users u : users1
                    ) {
                httpSession.setAttribute("_UID", u.getUid());
                httpSession.setAttribute("_UNAME", u.getUname());
            }
            return true;
        }
        return false;
    }

    /**
     * 注册
     *
     * @param users
     * @return
     */
    public boolean registered(Users users, HttpSession httpSession) {
        int sd = usersMapper.insertSelective(users);
        if (sd != 0) {
            login(users, httpSession);
            return true;
        }
        return false;
    }

    /**
     * 检查是否重名
     *
     * @return
     */
    public boolean cass(Users users) {
        List<Users> users1 = usersMapper.selectsBySelective(users, new Page());
        if (users1.size() != 0) {
            return false;
        }
        return true;
    }
}
