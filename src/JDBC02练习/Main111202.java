package JDBC02练习;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main111202 {

    public static void main(String[] args) {

        Connection conn = null;

        Statement stat = null;

        try {
            //1.注册驱动
            Class.forName("com.mysql.cj.jdbc.Driver");

            //2.获取数据库连接
            conn = DriverManager.getConnection(
                    "jdbc:mysql:///dbTest1112?serverTimezone=Asia/Shanghai",
                    "root",
                    "root");

            //3.定义sql语言
            String sqlInsert = "insert into student(id,name,sex) values('3','安度因','男')";
            String sqlInsert2 = "insert into student(id,name,sex) values('4','吉安娜','女')";
            String sqlUpdate = "update student set sex = '女' where id =3";
            String sqlDelete = "delete from student where name = '伊利丹'";

            //4.获取执行sql的对象
            stat = conn.createStatement();

            //5.执行sql
            int i = stat.executeUpdate(sqlInsert);
            int i2 = stat.executeUpdate(sqlInsert2);
            int iu = stat.executeUpdate(sqlUpdate);
            int id = stat.executeUpdate(sqlDelete);

            //6.处理结果
            System.out.println(i);
            System.out.println(i2);
            System.out.println(iu);
            System.out.println(id);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

            //7.释放资源
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
