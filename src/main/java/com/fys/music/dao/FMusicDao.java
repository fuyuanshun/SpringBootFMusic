package com.fys.music.dao;

import com.fys.music.model.Resource;
import com.fys.music.model.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
@Mapper
public interface FMusicDao {
    /**
     * 注册用户，往数据库插入一条信息
     * @param user
     */
    @Insert("insert into fmusic.user (username, password, email, url, state, sex, age, phone, birthday, hobby, address) values (#{username},#{password}, #{email}, #{url}, #{state}, #{sex}, #{age}, #{phone}, #{birthday}, #{hobby}, #{address})")
    int insertUser(User user);


    /**
     * 通过用户名查询用户是否存在
     */
    @Select("select username from fmusic.user where username = #{username}")
    String selectByUsername(String username);

    /**
     * 通过用户名查询密码
     */
    @Select("select password from fmusic.user where username = #{username}")
    String selectPasswordByUsername(String username);


    /**
     * 根据用户名查询用户的状态
     */
    @Select("select state from user where username = #{username}")
    Integer selectState(String username);

    /**
     * 激活用户
     */
    @Update("update user set state = 1 where url = #{url}")
    void updateState(String url);

    /**
     * 查询邮箱是否已经被使用
     */
    @Select("select email from user where email = #{email}")
    String selectMailIsExist(String mail);

    /**
     * 查询所有的磁力链
     */
    @Select("select id, magnet from resource")
    List<Resource> selectResource();

    /**
     * 分页查询磁力链
     */
    @Select("select id, magnet from resource limit #{currentPage},#{pageSize}")
    List<Resource> selectResourceByPage(@Param("currentPage") int currentPage, @Param("pageSize") int pageSize);

    /**
     * 更新找回密码的validateCode
     */
    @Update("update user set validatecode = #{validateCode} where email = #{email}")
    void updateValidateCode(@Param("validateCode") String validateCode, @Param("email") String email);

    /**
     * 查询找回密码的validateCode
     */
    @Select("select validatecode from user where email = #{email}")
    String selectValidateCode(String email);

    /**
     * 更新找回密码的过期时间
     */
    @Update("update user set outdate = #{outDate}")
    void updateOutDate(Date outDate);

    /**
     * 查询找回密码的过期时间
     */
    @Select("select outdate from user where validatecode = #{validateCode}")
    String selectOutDate(String validateCode);

    /**
     * 通过用户名修改密码
     */
    @Update("update user set password = #{password} where username = #{username}")
    void updatePassword(@Param("username")String username, @Param("password")String password);

    /**
     * 通过email查询用户名
     */
    @Select("select username from user where email = #{email}")
    String selectUsernameByEmail(String email);
}
