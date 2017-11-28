package redistest;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Test;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import redis.clients.jedis.Jedis;

public class SearchTEst {
	@Test
	public void seach(){
		Jedis jedis=new Jedis("192.168.58.132", 6379);
		ArrayList<String> list=(ArrayList<String>) jedis.lrange("v", 0, -10);
		System.out.println(list.size());
		System.out.println(list.size());
		 try{
	            //����Class.forName()�������������
	            Class.forName("com.mysql.jdbc.Driver");
	            System.out.println("�ɹ�����MySQL��");
	        }catch(ClassNotFoundException e1){
	            System.out.println("�Ҳ���MySQL��!");
	            e1.printStackTrace();
	        }
	        
	        String url="jdbc:mysql://localhost:3306/temp";    //JDBC��URL    
	        //����DriverManager�����getConnection()���������һ��Connection����
	        Connection conn;
	        try {
	            conn = (Connection) DriverManager.getConnection(url,    "root","root");
	            //����һ��Statement����
	            Statement stmt = (Statement) conn.createStatement(); //����Statement����
	            System.out.print("�ɹ����ӵ���ݿ⣡");
	            StringBuffer sb=new StringBuffer("select  empno,ename from emp where empno in (");
	            boolean flag=true;
	            for(String l:list){
	            	if(flag){
	            		sb.append(l);
	            		flag=!flag;
	            	}
	            	else{
	            		sb.append(",").append(l);
	            	}
	            }
	            sb.append(")");
	            ResultSet rs= stmt.executeQuery(sb.toString());
	            int count=0;
	            while(rs.next()){
	            	
	            
	            	System.out.println(rs.getInt(1)+" "+rs.getString(2));
	            }
	            stmt.close();
	            conn.close();
	        } catch (SQLException e){
	            e.printStackTrace();
	        }
			System.out.println(list.size());

	}
}
