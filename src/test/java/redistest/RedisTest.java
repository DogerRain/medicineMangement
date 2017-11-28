package redistest;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.security.auth.login.AppConfigurationEntry;

import mapper.UserMapper;
import net.sf.json.JSONObject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.google.gson.Gson;

import po.User;
import redis.clients.jedis.Jedis;
import service.UserService;
import tool.SerializeUtil;

public class RedisTest {
	
	@Test
	//insertString
	public void demo1(){
		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext-redis.xml");
		RedisTemplate<String, Object> redisTemplate=(RedisTemplate<String, Object>) ac.getBean("redisTemplate");
		redisTemplate.opsForValue().set("name", "liujun");
		System.out.println(redisTemplate.opsForValue().get("name"));
		redisTemplate.delete("name");
		
		
	}
	@Test
	//mysql
	public void demo2(){
		ApplicationContext ac=new ClassPathXmlApplicationContext("classpath:app.xml");
		UserMapper userService=(UserMapper) ac.getBean("userMapper");
		long start=System.currentTimeMillis();
		for(int i=1;i<=1000;++i)
			System.out.println(userService.selectUserById("1").toString());
		System.out.println(System.currentTimeMillis()-start);
	}
	@Test
	//redis
	public void demo3(){
		ApplicationContext ac=new ClassPathXmlApplicationContext("classpath:app.xml");
		UserMapper userService=(UserMapper) ac.getBean("userMapper");
		Jedis jedis=new Jedis("192.168.58.132", 6379);
		String id="1";
		long start=System.currentTimeMillis();
		System.out.println(cast(null));
		int count=0;
		for(int i=1;i<=1000000;++i){
			if(jedis.hget(id, "userid")==null){
				++count;
				User user= userService.selectUserById(id);
				jedis.hset(id, "userid", user.getUserid());
				jedis.hset(id, "password", user.getPassword());
				jedis.hset(id, "win", cast(user.getWin()));
				jedis.hset(id, "fail",cast( user.getFail()));
				if(user.getLast()!=null)
					jedis.hset(id, "last",cast( user.getLast()));
				
				System.out.println("sql="+user);
			}
			else{
				User user=new User();
				user.setUserid((String)jedis.hget(id, "userid"));
				user.setPassword((String)jedis.hget(id, "userid"));
				user.setFail(new Integer(jedis.hget(id, "fail")));
				user.setWin(new Integer(jedis.hget(id, "win")));
				if(jedis.hget(id, "last")!=null)
					user.setLast(new Integer(jedis.hget(id, "last")));
				System.out.println(user.toString());
			}
		}
		System.out.println(System.currentTimeMillis()-start);
		System.out.println("count="+count);
	
	}
	public String cast(Object x){
		if(x==null)
			return null;
		return String.valueOf(x);
	}
	@Test
	//redisTemple
	public void demo4(){
		ApplicationContext ac=new ClassPathXmlApplicationContext("classpath:app.xml");
		UserMapper userService=(UserMapper) ac.getBean("userMapper");
		RedisTemplate<String,Serializable> redisTemplate=(RedisTemplate<String, Serializable>) ac.getBean("redisTemplate");
		redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());  
		String id="1";
		long start=System.currentTimeMillis();
		for(int i=1;i<=1000;++i){
			Serializable obj=null;
			if((obj=redisTemplate.opsForValue().get(id))==null){
				User user= userService.selectUserById(id);
				redisTemplate.opsForValue().set(id, user);
				
				System.out.println(user);
			}
			else{
				User user=(User) obj;
				System.out.println(user);
			}
		}
		System.out.println(System.currentTimeMillis()-start);
	
	}
	@Test
	//hashmap���л�
	public void demo5(){
		ApplicationContext ac=new ClassPathXmlApplicationContext("classpath:app.xml");
		UserMapper userService=(UserMapper) ac.getBean("userMapper");
		HashMap<String, Object> map=new HashMap<>();
		String id="1";
		long start=System.currentTimeMillis();
		for(int i=1;i<=10000;++i){
			if(map.get(id)==null){
				User user= userService.selectUserById(id);
				map.put(id, SerializeUtil.serialize(user));
				
				System.out.println(user);
			}
			else{
				User user=(User) SerializeUtil.unserialize( (byte[]) map.get(id));
				System.out.println("hashmap="+user);
			}
		}
		System.out.println(System.currentTimeMillis()-start);
	
	}
	@Test
	//redisCacheTest
	public void redisCacheTest(){
		ApplicationContext ac=new ClassPathXmlApplicationContext("classpath:app.xml");
		UserService userService=(UserService) ac.getBean("userService");
		long start=System.currentTimeMillis();
		for(int i=1;i<=100;++i){
			ArrayList<User> list= userService.selectUserListbyUserid("1");
			System.out.println(list.size());
		}
		System.out.println(System.currentTimeMillis()-start);
	}
	
	@Test
	public void er(){
		
		long start=System.currentTimeMillis();
		String str="";
		for(int i=1;i<=100000;++i)
			str+=i;
		System.out.println(System.currentTimeMillis()-start);
	}	
	@Test
	public void er2(){
		
		long start=System.currentTimeMillis();
		StringBuffer str=new StringBuffer("");
		for(int i=1;i<=100000;++i)
			str.append(i);
		System.out.println(System.currentTimeMillis()-start);
	}	
}
