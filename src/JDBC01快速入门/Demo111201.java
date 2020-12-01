package JDBC01快速入门;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class Demo111201 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        //1.导入驱动jar包

        //2.注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");

        //3.获取数据库连接
        Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/dbTest1112?serverTimezone=Asia/Shanghai",
                "root",
                "root");

        //4.定义sql语句
        String sql = "update student set sex = '女' where id = 2";

        //5.获取执行sql的对象
        Statement stat = conn.createStatement();

        //6.执行sql 返回值是影响行数
        int i = stat.executeUpdate(sql);

        System.out.println(i);

        //7.释放内存
        stat.close();
        conn.close();
    }
}
