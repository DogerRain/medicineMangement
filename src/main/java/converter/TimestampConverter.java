package converter;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
public class TimestampConverter implements Converter<String,Timestamp>{

	@Override
	public Timestamp convert(String arg0) {
		// TODO Auto-generated method stub
		arg0=arg0.replaceAll("下午", "").replaceAll("上午" ,"").replaceAll("/", "-");
		
		if(arg0!=null){
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");//小写的mm表示的是分钟   
			try {
				java.util.Date date=sdf.parse(arg0);
				Timestamp timestamp = new Timestamp(date.getTime());
				return timestamp;
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}  
			
			
		}
		return null;

	}

}