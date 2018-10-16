package com.fys.music.controller;

import com.fys.music.util.MailUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *   Test Github Push
 */

@Controller
public class MusicController {
    boolean b = true;

    /**
     * 主页
     */
    @RequestMapping("/")
    public String index(HttpServletRequest req, HttpServletResponse resp) {
        String addr = req.getRemoteAddr();
        if (b) {
            if (!(addr.equals("127.0.0.1")) && !(addr.equals("117.159.12.38"))) {
                MailUtil.sendTo("有人访问你的的网站了~~ IP是： " + addr, "849485789@qq.com", "有人访问您的FMusic网站啦。嘤嘤嘤");
                b = false;
            }
        }

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
