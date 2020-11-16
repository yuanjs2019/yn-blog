package com.yuan.farmerwork.ynblog.rest.wechat;

import com.yuan.farmerwork.ynblog.utils.Result;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.mp.api.WxMpMessageRouter;
import me.chanjar.weixin.mp.bean.message.WxMpXmlMessage;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

/**
 * 微信接口.
 *
 * @author : YJS
 * @date: 2020-11-13 13:27
 */
@Slf4j
@RestController
@RequestMapping("/wechat")
public class WechatController {

    private static String WECHAT_TOKEN = "yuan_js"; //WECHAT_TOKEN和你申请时填写的Token一样
    @RequestMapping("/verifyToken")
    public void event(HttpServletRequest request, HttpServletResponse response) throws IOException {
        log.info("请求进来了...");

        Enumeration pNames = request.getParameterNames();
        while (pNames.hasMoreElements()) {
            String name = (String) pNames.nextElement();
            String value = request.getParameter(name);
            String logs = "name =" + name + "     value =" + value;
            log.info(logs);
        }

        String signature = request.getParameter("signature");/// 微信加密签名
        String timestamp = request.getParameter("timestamp");/// 时间戳
        String nonce = request.getParameter("nonce"); /// 随机数
        String echostr = request.getParameter("echostr"); // 随机字符串
        PrintWriter out = response.getWriter();
        out.print(echostr);
        out.close();
    }
}
