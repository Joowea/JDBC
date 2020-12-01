package JDBC05工具类;

import JDBC04类封装.Student;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Main111302 {

    public static void main(String[] args) throws SQLException {

        Connection conn = null;
        ResultSet rs = null;
        Statement stat = null;
        List<Student> stu = new ArrayList<>();

        conn = JDBCUtils.getConnection();

        //定义sql
        String sqlQuery = "select * from students";

        stat = conn.createStatement();

        rs = stat.executeQuery(sqlQuery);

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

        System.out.println(stu);

        JDBCUtils.close(stat,conn,rs);
    }
}
