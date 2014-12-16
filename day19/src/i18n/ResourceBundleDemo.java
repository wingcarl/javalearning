package i18n;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

import org.junit.Test;

public class ResourceBundleDemo {

	@Test
	public void test1() throws ParseException{
		//ResourceBundle rb = ResourceBundle.getBundle("resources.msg",Locale.JAPANESE);
		//System.out.println(rb.getString("hello") );
		Date date = new Date();
		/**
		 * FULL 2014年12月15日 星期一
		 * LONG 2014年12月15日
		 * MEDIUM 2014-12-15
		 * SHORT 14-12-15
		 */
		Locale locale =Locale.TAIWAN;
		DateFormat df = DateFormat.getTimeInstance(DateFormat.FULL,locale);
		String s = df.format(date);
		System.out.println(s);// 2013-5-11
		
		int i = 100000000;
		NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.JAPANESE);
		System.out.println(nf.format(i));
		
		
	}
}
