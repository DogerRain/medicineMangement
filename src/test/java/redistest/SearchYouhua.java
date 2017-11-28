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
	//��������
	public void buildIndex(){
		Jedis jedis=new Jedis("192.168.58.132", 6379);
		System.out.println(jedis.ping());
		 try{
	            //����Class.forName()����������������
	            Class.forName("com.mysql.jdbc.Driver");
	            System.out.println("�ɹ�����MySQL������");
	        }catch(ClassNotFoundException e1){
	            System.out.println("�Ҳ���MySQL����!");
	            e1.printStackTrace();
	        }
	        
	        String url="jdbc:mysql://localhost:3306/temp";    //JDBC��URL    
	        //����DriverManager�����getConnection()���������һ��Connection����
	        Connection conn;
	        try {
	            conn = (Connection) DriverManager.getConnection(url,    "root","root");
	            //����һ��Statement����
	            Statement stmt = (Statement) conn.createStatement(); //����Statement����
	            System.out.print("�ɹ����ӵ����ݿ⣡");
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
