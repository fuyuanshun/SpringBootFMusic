package com.fys.music.service;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

public interface AdminService {
    /**
     * 上传音乐
     * @param multipartFile 音乐文件
     * @param req
     * @return
     */
    String uploadMusic(MultipartFile multipartFile, HttpServletRequest req);

    /**
     * 查询音乐是否已经存在
     * @param musicName 音乐名称
     * @return
     */
    int musicIsExist(String musicName);

    /**
     * 添加音乐到数据库
     * @param name 音乐名称
     * @param author 演唱者
     * @param path 音乐路径
     */
    void addMusic(String name, String author, String path);
}
