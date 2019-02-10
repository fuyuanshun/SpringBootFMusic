package com.fys.music.dao;

import com.fys.music.model.Music;
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

    /**
     * 根据id查询音乐信息
     */
    @Select("select id, name, author, path, picpath from music where id = #{id}")
    Music selectMusicById(String id);

    /**
     * 查询所有的歌曲
     */
    @Select("select id, name, author, path, picpath from music")
    List<Music> selectMusic();

    /**
     * 根据id查询歌曲是否已经被收藏
     */
    @Select("select * from user_music where music_id = #{id} and user_id = #{user_id}")
    String selectCollectById(@Param("id") String id, @Param("user_id") String userId);

    /**
     * 收藏歌曲
     */
    @Select("insert into user_music (user_id, music_id) values (#{user_id}, #{id})")
    void collectMusic(@Param("id") String id, @Param("user_id") String userId);

    /**
     * 根据用户名查询用户id
     */
    @Select("select id from user where username = #{username}")
    String selectIdByUsername(String username);

    /**
     * 查询用户的收藏列表
     */
    @Select("select * from music where id in (select music_id from user_music where user_id=#{userId}) group by id")
    List<Music> selectAllMusic(String userId);

    /**
     * 查询用户信息
     */
    @Select("select username, email, sex, age, birthday, hobby, phone, address, last_login as lastLoginTime, signature from user where username = #{username}")
    User getUserInfo(String username);

    /**
     * 更新个性签名
     * @param signature 用户输入的数据
     * @return
     */
    @Update("update user set signature = #{signature} where username = #{username}")
    Integer updateSignature(@Param("signature")String signature, @Param("username") String username);

    /**
     * 更新最后登录的时间
     * @param username
     */
    @Update("update user set last_login = now() where username = #{username}")
    void updateLastLoginTime(String username);

    /**
     * 取消收藏音乐
     * @param userId 用户id
     * @param id 歌曲id
     * @return
     */
    @Delete("delete from user_music where user_id = #{user_id} and music_id = #{music_id}")
    Integer deleteFav(@Param("user_id")String userId, @Param("music_id")String id);

    /**
     * 搜索音乐信息
     * @param searchContent
     * @return
     */
    @Select("select * from music where concat(name, author) like \"%\"#{searchContent}\"%\"")
    List<Music> search(String searchContent);
}
