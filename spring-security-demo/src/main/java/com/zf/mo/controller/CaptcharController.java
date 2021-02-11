package com.zf.mo.controller;

import com.google.code.kaptcha.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

@Controller
public class CaptcharController  {

    @Autowired
    private Producer captchaProducer;

    @GetMapping("/captcha.jpg")
    public void getCaptcha(HttpServletRequest request, HttpServletResponse response)throws IOException {
        //设置内容类型
        response.setContentType("image/jpeg");
        //创建验证文本
        String capText = captchaProducer.createText();
        //将验证码文本设置到session
        request.getSession().setAttribute("captcha",capText);
        BufferedImage bi = captchaProducer.createImage(capText);
        ServletOutputStream out = response.getOutputStream();
        ImageIO.write(bi,"jpg",out);
        try {
            out.flush();
        } finally {
            out.close();
        }

    }


}
