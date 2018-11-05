package com.fys.music.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.fys.music.service.AdminService;
import com.fys.music.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String admin() {
        return "admin";
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    public @ResponseBody String upload(@RequestParam("file") MultipartFile multipartFile, HttpServletRequest req) {
        String fileName = multipartFile.getOriginalFilename();
        //如果歌曲已经存在了，不再进行上传操作
        if (adminService.musicIsExist(fileName) > 0) {
            ResultUtil resultUtil = new ResultUtil("400", "该歌曲已经存在！", null);
            return JSON.toJSONString(resultUtil);
        }
        //上传音乐
        String json = adminService.uploadMusic(multipartFile, req);
        ResultUtil resultUtil = JSON.parseObject(json, ResultUtil.class);
        if (resultUtil.getCode().equals("200")) {
            adminService.addMusic(fileName, "-", "localhost:8080//FMusic/music/"+fileName);
        }
        return json;
    }
}
