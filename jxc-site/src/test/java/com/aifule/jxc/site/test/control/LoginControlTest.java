package com.aifule.jxc.site.test.control;


import com.aifule.jxc.site.test.SpringTest;
import org.slf4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.LoggerFactory;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

public class LoginControlTest extends SpringTest {
    Logger log = LoggerFactory.getLogger(LoginControlTest.class); // 模拟request,response
    private MockHttpServletRequest request;
    private MockHttpServletResponse response;

    @Before
    public void setUp() {
        request = new MockHttpServletRequest();
        request.setCharacterEncoding("UTF-8");
        response = new MockHttpServletResponse();
    }

    @Test
    public void loginTest() {
        try {
            request.setParameter("stunum", "001");
            request.setParameter("cardnum", "000000");
            request.setParameter("ticket", "10001");
            request.setParameter("truename", "wanger");
            request.setParameter("uname", "nick");
            request.setParameter("schoolname", "华中科技大学");
            request.setParameter("depart", "法学11");
            request.setParameter("profession", "经济法11");
            request.setParameter("class", "2015001");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
