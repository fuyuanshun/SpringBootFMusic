package com.fys.music.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class SearchController {
    /**
     * 搜索
     */
    @RequestMapping("/search")
    public String search(HttpServletRequest req, HttpServletResponse resp) {
        String searchContent = req.getParameter("searchContent");
        System.out.println(searchContent);
        return "search";
    }
}