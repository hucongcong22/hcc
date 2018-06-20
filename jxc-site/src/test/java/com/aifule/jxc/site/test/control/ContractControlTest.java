//package com.aifule.jxc.site.test.control;
//
//import User;
//import SysConstant;
//import SpringTest;
//import com.aifule.jxc.site.vo.ContractVo;
//import com.aifule.jxc.site.web.controller.ContractController;
//import org.junit.Before;
//import org.junit.Test;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.mock.web.MockHttpServletRequest;
//import org.springframework.mock.web.MockHttpServletResponse;
//
//import javax.annotation.Resource;
//import java.math.BigDecimal;
//import java.util.Date;
//import java.util.LinkedList;
//import java.util.List;
//import java.util.Map;
//
///**
// * Created by Administrator on 2016/8/24.
// */
//public class ContractControlTest extends SpringTest {
//    Logger log = LoggerFactory.getLogger(ContractControlTest.class);
//    @Resource
//    private ContractController contractController;
//    private MockHttpServletRequest request;
//    private MockHttpServletResponse response;
//
//    @Before
//    public void setUp() {
//        request = new MockHttpServletRequest();
//        User user = new User();
//        user.setId(2);
//        request.getSession().setAttribute(SysConstant.CURRENT_USER, user);
//    }
//
//    @Test
//    public void commitContract() {
//    }
//
//    @Test
//    public void getContractVo(){
//    }
//
//    @Test
//    public void getCompanyContract(){
////        Map<String, Object> map = contractController.getCompnayContract(request,0,10);
////        System.out.println(map.toString());
//    }
//
//    @Test
//    public void getMotherContract(){
//    }
//}
