package com.fys.music.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 将密码进行MD5加密的辅助类
 */
public class MD5Util {
    public static void main(String[] args) {

    }

    public static String getMD5(String string) {
        StringBuffer stringBuffer = new StringBuffer();
        MessageDigest messageDigest = null;
        byte[] b = string.getBytes();
        try {
            messageDigest = MessageDigest.getInstance("md5");
            messageDigest.digest(b);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }
}