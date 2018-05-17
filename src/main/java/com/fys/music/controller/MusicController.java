package com.fys.music.controller;

import com.fys.music.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MusicController {

    /**
     * 主页
     */
    @RequestMapping("/")
    public String index() {
        return "index";
    }

    /**
     * 播放音乐
     */
    @RequestMapping("/music")
    public String music() {
        return "music";
    }

    /**
     * 热门音乐
     */
    @RequestMapping("/hotmusic")
    public String hotmusic() {
        return "hotmusic";
    }
}
