package com.fys.music.util;

import java.io.*;
import java.sql.*;
import java.util.*;

/**
 * 将数据库的音乐读取到json文件中
 */
public class UpdateMusic {
    static String url = "jdbc:mysql://localhost/fmusic?characterEncoding=UTF-8";
    static String username = "root";
    static String password = "root";

    public static void main(String[] args) {
        String path = System.getProperty("user.dir");
        String filename = path + "\\src\\main\\resources\\static\\json\\list.json";
        Map<String, String> musics = queryMusicList();
        writeToFile(musics, filename);
    }

    private static void writeToFile(Map<String, String> music, String fileName) {
        Set<String> keys =  music.keySet();
        File file = new File(fileName);
        FileWriter fileWriter = null;
        StringBuffer fileContent = new StringBuffer();
        fileContent.append("[\r\n");
        try {
            fileWriter = new FileWriter(file);
            for (String key : keys) {
                String path = music.get(key);
                fileContent.append( "{\r\n\"title\":\""+ key +"\", \"mp3\":\""+ path +"\"\r\n},\r\n");
            }
            fileContent = fileContent.delete(fileContent.length()-3, fileContent.length()-2);
            fileContent = fileContent.append("\r\n]");
            fileWriter.write(fileContent.toString());
            System.out.println("写出成功! 路径为:" + file.getPath());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != fileWriter) {
                    fileWriter.close();
                }
            } catch (IOException e) {

            }
        }
    }

    private static Map<String, String> queryMusicList() {
        Map<String, String> hashMap = new HashMap<>();
        ResultSet resultSet = null;
        String sql = "select * from music";
        Connection connection = getConn(url, username, password);
        PreparedStatement preparedStatement = getPreparedStatement(connection, sql);
        try {
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String path = resultSet.getString("path");
                hashMap.put(name, path);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            //如果连接不为空，则关闭连接
        } finally {
            try {
                if (null != resultSet) {
                    resultSet.close();
                }
                if (null != preparedStatement) {
                    preparedStatement.close();
                }
                if (null != connection) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return hashMap;
    }

    public static PreparedStatement getPreparedStatement(Connection connection, String sql) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return preparedStatement;
    }

    private static Connection getConn(String url, String username, String password) {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}