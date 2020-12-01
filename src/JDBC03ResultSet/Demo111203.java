package JDBC03ResultSet;

import java.sql.*;

public class Demo111203 {
    public static void main(String[] args) {

        Connection conn = null;
        Statement stat = null;
        try {
            //1、注册
            Class.forName("com.mysql.cj.jdbc.Driver");

            //2、获取数据库连接
            conn = DriverManager.getConnection(
                    "jdbc:mysql:///dbTest1112?serverTimezone=Asia/Shanghai",
                    "root",
                    "root");

            //3、定义sql
            String sqlQuery = "select * from student";

            //4、获取执行sql的对象
            stat = conn.createStatement();

            //5、执行sql
            ResultSet rs = stat.executeQuery(sqlQuery);

            //6、处理结果
//            rs.next();
//            int id = rs.getInt(1);
//            String name = rs.getString(2);
//            String sex = rs.getString(3);
//
//            System.out.println("id:"+id+"---"+"name:"+name+"---"+"sex:"+sex);

            while(rs.next()){
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String sex = rs.getString(3);

                System.out.println("id:"+id+"---name:"+name+"---sex:"+sex);

            }


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (stat != null) {
                try {
                    stat.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if ( conn != null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
