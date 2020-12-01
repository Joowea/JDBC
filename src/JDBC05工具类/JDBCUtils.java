package JDBC05工具类;

import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class JDBCUtils {

    private static String url;
    private static String user;
    private static String password;
    private static String driver;

    /*文件的读取 只需要读取一次即可*/
    static {
        /*读取文件获取值*/

        try {
            //1.创建集合类
            Properties pro = new Properties();

            //2.读取文件
            pro.load(new FileReader("O:\\IntelliJ_WorkSpace\\20201112JDBC\\src\\JDBC05工具类\\jdbc.properties"));

            //3.获取数据赋值
            url = pro.getProperty("url");
            user = pro.getProperty("user");
            password = pro.getProperty("password");
            driver = pro.getProperty("driver");

            //注册
            Class.forName(driver);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {

        return DriverManager.getConnection(url,user,password);
    }

    public static void close(Statement stat, Connection conn){
        if (conn!=null){

            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (stat!=null){

            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


    public static void close(Statement stat, Connection conn, ResultSet rs){

        close(stat,conn);

        if (rs!=null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
