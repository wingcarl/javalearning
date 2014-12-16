package i18n;

import java.text.MessageFormat;
import java.util.Date;
import java.util.Locale;

import org.junit.Test;

public class MessageFormatDemo {

	@Test
	public void test01(){
		String s = "At {0,time,long} on {0,date,medium} , a hurricance destroyed {1} houses and causes {2,number,currency} damage";
		Object params[] = new Object[]{new Date(),10000,20000};
		MessageFormat mf = new MessageFormat(s,Locale.US);
		String s1 = mf.format( params);
		System.out.println(s1);
	}
}
