package com.fys.music.service.impl;

import com.fys.music.dao.FMusicDao;
import com.fys.music.model.Music;
import com.fys.music.model.Resource;
import com.fys.music.model.User;
import com.fys.music.service.FMusicService;
import com.fys.music.util.MD5Util;
import com.fys.music.util.MailUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class FMusicServiceImpl implements FMusicService {
    @Autowired
    private FMusicDao FMusicDao;

    /**
     * 注册用户
     */
    @Override
    public int insertUser(User user) {
        return FMusicDao.insertUser(user);
    }

    /**
     * 通过用户名查询数据库是否有此数据
     */
    @Override
    public String selectByUsername(String username) {
        return FMusicDao.selectByUsername(username);
    }

    @Override
    public String selectPasswordByUsername(String username) {
        return FMusicDao.selectPasswordByUsername(username);
    }

    @Override
    public String registerDeal(String username, String password, String password2, String email, String sex, Integer age, String birthday, String hobby, String phone, String address, String sessionCode, String validateCode, String emailCode, String emailCodeWithSession) {
        //服务器地址
        String path = "139.199.198.151:8080";
        String isexist = selectByUsername(username);
        String mail = selectMailIsExist(email);

        if (!validateCode.equalsIgnoreCase(sessionCode)) {
            return "validateCodeERROR";
        }
        if(null == isexist) {
            if(null != mail) {
                return "emailIsExist";
            }
            if (!emailCode.equals(emailCodeWithSession)) {
                return "emailCodeError";
            }
            /**
             * 后台对数据的验证,保证值不为空才发送至后台
             */
            if(password.equals(password2) && null != email && null != sex && null != age && null != birthday && null != hobby && null != phone && null != address) {

                //将密码加密后存储到数据库
                password = MD5Util.getMD5(password);

                User user = new User(username, password, email, sex, age, phone, birthday, hobby, address);
                String url = UUID.randomUUID().toString();
                url = url.replace("-", "");
                user.setState(1);
                user.setUrl(url);

                //防止用户注册的时候一直点击，从而数据库出现多条记录
                if (null == selectByUsername(username)) {
                    if (1 == insertUser(user)) {
                        return "registerSuccess";
                    }
                }
            }
            return "userIsExist";
        } else {
            return "userIsExist";
        }
    }

    /**
     * 用户登陆处理
     */
    @Override
    public String loginDeal(String username, String password) {
        if(null != password && null != username) {
            String dbpassword = selectPasswordByUsername(username);
            Integer state = selectState(username);

            password = MD5Util.getMD5(password);

            if(null != state && state == 0) {
                return "userIsNotActive";
            }
            if(password.equals(dbpassword)) {
                //更新最后登录的时间
                FMusicDao.updateLastLoginTime(username);
                return "loginSuccess";
            } else {
                return "loginError";
            }
        } else return "loginError";
    }

    /**
     * 调用激活用户的方法
     * @param url 用户的uuid
     */
    @Override
    public void mailConf(String url) {
        updateState(url);
    }

    /**
     * 查询用户的状态 是否激活
     * @param username 用户名
     */
    @Override
    public Integer selectState(String username) {
        return FMusicDao.selectState(username);
    }

    /**
     * 激活用户
     * @param url
     */
    @Override
    public void updateState(String url) {
        FMusicDao.updateState(url);
    }

    /**
     * 查询邮箱是否已经被使用
     * @param mail
     * @return
     */
    @Override
    public String selectMailIsExist(String mail) {
        return FMusicDao.selectMailIsExist(mail);
    }

    /**
     * 查询所有的磁力链和id
     * @return
     */
    @Override
    public List<Resource> selectResource() {
        return FMusicDao.selectResource();
    }

    /**
     * 分页查询磁力链
     * @return
     */
    @Override
    public List<Resource> selectResourceByPage(int currentPage, int pageSize) {
        currentPage = (currentPage-1)*10;
        return FMusicDao.selectResourceByPage(currentPage, pageSize);
    }

    /**
     * 找回密码的处理逻辑
     */
    @Override
    public void forgetPasswordDeal(String email) {
        //服务器地址
        String path = "139.199.198.151:8080";

        String validateCode = UUID.randomUUID().toString();
        validateCode = validateCode.replace("-", "");
        try {
            MailUtil.sendTo("<a href='" + path + "/FMusic/resetPassword?url='"+validateCode+">请点击修改密码</a> 如果链接无法点击，请复制以下链接到浏览器: <a>" + path + "/FMusic/resetPassword?validateCode="+validateCode+"&email="+email+"</a>", email, "激活您的帐号");
            updateValidateCode(validateCode, email);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //30分钟后过期
        Timestamp outDate = new Timestamp(System.currentTimeMillis() + 30 * 60 * 1000);
        long date = outDate.getTime() /1000 * 1000; //忽略毫秒数 mysql取出时间是忽略毫秒数的
        updateOutDate(outDate);
    }

    /**
     * 更新找回密码的ValidateCode
     */
    @Override
    public void updateValidateCode(String validateCode, String email) {
        FMusicDao.updateValidateCode(validateCode, email);
    }

    /**
     * 查询找回密码的validateCode
     */
    @Override
    public String selectValidateCode(String email) {
        return FMusicDao.selectValidateCode(email);
    }

    /**
     * 设置找回密码的过期时间
     */
    @Override
    public void updateOutDate(Date outDate) {
        FMusicDao.updateOutDate(outDate);
    }

    @Override
    public String selectOutDate(String validateCode) {
        return FMusicDao.selectOutDate(validateCode);
    }

    /**
     * 检查找回密码的时间是否过期
     */
    @Override
    public String checkValidateCode(String validateCode, String email) {

        if(null != validateCode && !validateCode.equals("")) {
            if(null == selectOutDate(validateCode)) {
                return "reseterror";
            }

            if(null == selectValidateCode(email)) {
                return "reseterror";
            }
            long outTime = Timestamp.valueOf(selectOutDate(validateCode)).getTime();
            if(selectValidateCode(email).equals(validateCode) && System.currentTimeMillis() < outTime) {
                return "resetpage";
            }
        }
        return "reseterror";
    }

    @Override
    public String selectUsernameByEmail(String email) {
        return FMusicDao.selectUsernameByEmail(email);
    }

    /**
     * 修改密码
     */
    @Override
    public String updatePassword(String username, String password, String password2, String email) {
        if(null != username && null != password && null != password2 && password.equals(password2)) {
            if(selectUsernameByEmail(email).equals(username)) {
                FMusicDao.updatePassword(username, MD5Util.getMD5(password));
                String validateCode = UUID.randomUUID().toString();
                validateCode = validateCode.replace("-", "");
                updateValidateCode(validateCode, email);
                return "updateSuccess";
            } else {
                return "updateError";
            }
        } else {
            return "updateError";
        }
    }

    /**
     * 根据id查询音乐
     * @param id id
     * @return 音乐信息
     */
    @Override
    public Music selectMusicById(String id) {
        return FMusicDao.selectMusicById(id);
    }

    /**
     * 查询所有的音乐
     * @return
     */
    @Override
    public List<Music> selectMusic() {
        return FMusicDao.selectMusic();
    }


    /**
     * 查询歌曲是否已经被收藏
     * @param id
     * @return
     */
    @Override
    public String selectCollectById(String id, String userId) {
        return FMusicDao.selectCollectById(id, userId);
    }

    /**
     * 根据收藏歌曲
     * @param id id
     */
    @Override
    public void collectMusic(String id, String userId) {
        FMusicDao.collectMusic(id, userId);
    }

    /**
     * 收藏歌曲
     * @param id
     * @return
     */
    @Override
    public String collect(String id, String userId) {
        String isCollected = selectCollectById(id, userId);
        if (null != isCollected) {
            return "exist";
        } else {
            collectMusic(id, userId);
            return "success";
        }
    }

    /**
     *
     *   根据用户名查询用户id
     *
     * @param username
     * @return
     */
    @Override
    public String selectIdByUsername(String username) {
        return FMusicDao.selectIdByUsername(username);
    }

    /**
     * 查询用户收藏的音乐列表
     * @param userId
     * @return
     */
    @Override
    public List<Music> selectAllMusic(String userId) {
        return FMusicDao.selectAllMusic(userId);
    }


    /**
     * 查询用户信息
     */
    @Override
    public User getUserInfo(String username) {
        return FMusicDao.getUserInfo(username);
    }

    /**
     * 更新个性签名
     * @param signature 从前台获取到的数据
     * @return
     */
    @Override
    public String updateSignature(String signature, String username) {
        int state = FMusicDao.updateSignature(signature, username);
        if (state == 1) {
            return "保存成功!";
        } else {
            return "保存失败!";
        }
    }

    /**
     * 取消收藏音乐
     * @param userId
     * @param id
     */
    @Override
    public String deleteFav(String userId, String id) {
        if (FMusicDao.deleteFav(userId, id) == 1) {
            return "success";
        } else {
            return "error";
        }
    }
}
