package com.cas.springboot.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
@RequestMapping("/auth")
public class CasController {

    @Value("${caslogout}")
    private String casServerLogoutUrl;

    @Value("${cas.client-host-url}")
    private String casClientUrl;

    @RequestMapping("/index")
    @ResponseBody
    public void index(@RequestParam(value="isLocal", required = false, defaultValue = "false") Boolean isLocal,
                      HttpServletResponse response,
                      HttpServletRequest request) throws IOException {
        String path = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort();
        if (isLocal) {
            response.sendRedirect(path + "/index.html");
        } else {
            response.sendRedirect(path + "/home.html");
        }
    }

    @RequestMapping("/logout")
    public void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        session.invalidate();
        String path = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort();
        response.sendRedirect(casServerLogoutUrl + "?service=" + path + "/login.html");
    }
}
