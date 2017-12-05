package dataBase;

/**
 * Created by mff on 2017/5/15.
 */

import java.sql.*;

public class MysqlConnect {
    public static void connectMysql(String s){
        // 驱动程序名
        String driver = "com.mysql.jdbc.Driver";
        // URL指向要访问的数据库名students
        String url = "jdbc:mysql://localhost/framework";
        // MySQL配置时的用户名
        String user = "root";
        // MySQL配置时的密码
        String password = "1234";
        String userid,username;
        String [] strings = s.split("\n");
        try {
            // 加载驱动程序
            Class.forName(driver);
            // 连接数据库
            Connection conn = DriverManager.getConnection(url, user, password);
            if(!conn.isClosed()) {
                System.out.println("Succeeded connecting to the Database!");
            }
            for (String insertString: strings) {
                // 要执行的SQL语句
                String sql1 = "insert into userInfo values(" + insertString + ")";
                // Preparestatement用来执行SQL的insert语句
                PreparedStatement statement1 = conn.prepareStatement(sql1);
                int count = statement1.executeUpdate();
                if (count > 0) {
                    System.out.println("插入成功！");
                } else {
                    System.out.println("插入失败！");
                }
            }
            // statement用来执行SQL语句
            Statement statement = conn.createStatement();
            // 要执行的SQL语句
            String sql = "select * from userInfo";
            // 结果集
            ResultSet rs = statement.executeQuery(sql);
            while(rs.next())  {
                // 选择runResult这列数据
                userid = rs.getString("userid");
                username = rs.getString("username");
                // 输出结果
                System.out.println("userid:"+"\t"+userid+"\t"+"username:"+ "\t" + username);
            }
            rs.close();
            conn.close();
        }catch(ClassNotFoundException e) {
            System.out.println("Sorry,can`t find the Driver!");
            e.printStackTrace();
        } catch(SQLException e) {
            e.printStackTrace();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        connectMysql("5,\"小明\"\n6,\"小花\"");
    }
}