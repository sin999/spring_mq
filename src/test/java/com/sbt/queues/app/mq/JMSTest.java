package com.sbt.queues.app.mq;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/app-context.xml" })
public class JMSTest {
    @Resource
    private JMSSender jmsSender;


//    @Autowired
//    public void setJsmSender(JMSSender jmsSender) {
//        this.jmsSender = jmsSender;
//    }

    @Test
    public void testJMSSend() throws Exception {
        String text = "123456";
        jmsSender.sendMesage(text.getBytes());
    }

    @Test
    public void testJMSSendNew() throws Exception {
        String text = "123456  >> "+(new Date());
        jmsSender.sendMesage(text.getBytes());
        Thread.sleep(3000);
    }

}