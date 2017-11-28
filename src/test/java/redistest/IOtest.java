package redistest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.junit.Test;

import com.sun.mail.iap.ByteArray;

public class IOtest {
	@Test
	public void demo1() throws IOException{
		FileInputStream InputStream=new FileInputStream(new File("G:\\iotest\\02.jpg"));
		FileOutputStream OutputStream=new FileOutputStream(new File("G:\\iotest\\03.jpg"));
		byte[] b=new byte[20];
		int x;
		while((x=InputStream.read(b))!=-1){
			OutputStream.write(b, 0, x);
		}
		OutputStream.close();
		
	}
}
