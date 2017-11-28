package redistest;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

import redis.clients.jedis.Jedis;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class SearchYouhua {
	@Test
	//简历索引
	public void buildIndex(){
		Jedis jedis=new Jedis("192.168.58.132", 6379);
		System.out.println(jedis.ping());
		 try{
	            //调用Class.forName()方法加载驱动程序
	            Class.forName("com.mysql.jdbc.Driver");
	            System.out.println("成功加载MySQL驱动！");
	        }catch(ClassNotFoundException e1){
	            System.out.println("找不到MySQL驱动!");
	            e1.printStackTrace();
	        }
	        
	        String url="jdbc:mysql://localhost:3306/temp";    //JDBC的URL    
	        //调用DriverManager对象的getConnection()方法，获得一个Connection对象
	        Connection conn;
	        try {
	            conn = (Connection) DriverManager.getConnection(url,    "root","root");
	            //创建一个Statement对象
	            Statement stmt = (Statement) conn.createStatement(); //创建Statement对象
	            System.out.print("成功连接到数据库！");
	            String sql="select  empno,ename from emp";
	            ResultSet rs= stmt.executeQuery(sql);
	            int count=0;
	            while(rs.next()){
	            	String name=rs.getString(2);
	            	for(int i=0;i<name.length();++i)
	            		for(int j=i;j<name.length();++j)
	            			jedis.rpush(name.substring(i, j+1), String.valueOf(rs.getInt(1)));
	            	System.out.println(++count);
	            }
	            stmt.close();
	            conn.close();
	        } catch (SQLException e){
	            e.printStackTrace();
	        }
	}

}
