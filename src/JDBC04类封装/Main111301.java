package JDBC04类封装;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Main111301 {
    public static void main(String[] args) {

        System.out.println(findAll());

    }


    public static List<Student> findAll() {

        Connection conn = null;
        ResultSet rs = null;
        Statement stat = null;
        List<Student> stu = new ArrayList<>();


        try {
            //1.注册驱动
            Class.forName("com.mysql.cj.jdbc.Driver");

            //2.连接数据库
            conn = DriverManager.getConnection(
                    "jdbc:mysql:///dbTest1113?serverTimezone=Asia/Shanghai",
                    "root",
                    "root");

            //3.定义sql语句
            String sqlQuery = "select * from students";

            //4.获取执行sql对象
            stat = conn.createStatement();

            //5.执行sql
            rs = stat.executeQuery(sqlQuery);

            //6.处理结果
            while(rs.next()){

                stu.add(new Student(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getDouble(6))
                );
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (conn!=null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (rs!=null){
                try {
                    rs.close();
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

        return stu;
    }
}
