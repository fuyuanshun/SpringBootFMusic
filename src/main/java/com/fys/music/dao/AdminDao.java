package com.fys.music.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface AdminDao {

    /**
     * 查询歌曲是否已经存在
     * @param musicName
     * @return
     */
    @Select("select count(id) from music where name = #{musicName}")
    int musicIsExist(String musicName);

    /**
     * 将音乐添加到数据库
     */
    @Insert(("insert into music (name, author, path) values (#{name}, #{author}, #{path})"))
    void addMusic(@Param("name")String name, @Param("author")String author, @Param("path")String path);
}
