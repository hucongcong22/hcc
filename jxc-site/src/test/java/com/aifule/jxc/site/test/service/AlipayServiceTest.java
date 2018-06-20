package com.aifule.jxc.site.test.service;

import com.aifule.jxc.site.test.SpringTest;
import com.aifule.jxc.core.alipay.AlipayFactory;
import org.junit.Test;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * Created by libiao on 2016/12/28.
 */
public class AlipayServiceTest extends SpringTest {
    @Resource
    private AlipayFactory alipayFactory;

    @Test
    public void test() throws Exception {
        alipayFactory.tradePrecreate("1484379648892", BigDecimal.valueOf(0.1));

    }
}
