package com.carl.base.introspector;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;
import org.apache.commons.beanutils.converters.DateConverter;
import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;
import org.junit.Test;

//��ʡ
public class Demo1 {
	@Test
	public void test1() throws Exception{
		//�õ�student���е����ԣ�����װ����beaninfo��
		BeanInfo bi = Introspector.getBeanInfo(Student.class);
		//�õ����е����е�����������
		PropertyDescriptor[] pds = bi.getPropertyDescriptors();
		System.out.println(pds.length);
		for(PropertyDescriptor pd:pds){
			System.out.println(pd.getName());
		}
	}
	@Test
	public void test2() throws Exception{
		Student s = new Student();
		PropertyDescriptor pd = new PropertyDescriptor("name",Student.class);
		Method m = pd.getReadMethod();
		String value = (String)m.invoke(s, null);
		System.out.println(value);
		Method m1 = pd.getWriteMethod();
		m1.invoke(s, "Caroline");
		value = (String)m.invoke(s, null);
		System.out.println(value);
	}
	
	@Test
	public void test3() throws Exception{
		Student s = new Student();
		System.out.println(BeanUtils.getProperty(s, "name"));
		BeanUtils.setProperty(s, "name", "Caroline");
		System.out.println(s.getName());
	}
	
	//BeanUtils���Խ�������ת���������޻������͡���Ҫint�ͣ����Ը��ַ���
	@Test
	public void test4() throws Exception{
		Student s = new Student();
		System.out.println(BeanUtils.getProperty(s, "age"));
		BeanUtils.setProperty(s, "age", "10");
		System.out.println(s.getAge());
	}
	
	@Test
	public void test5() throws Exception{
		Student s = new Student();
		ConvertUtils.register(new Converter(){

			@Override
			public Object convert(Class type, Object value) {
				DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
				if(type.equals(Date.class)){
					String v =(String)value;
					try {
						java.util.Date d = df.parse(v);
						return d;
					} catch (ParseException e) {
						throw new RuntimeException(e);
					}
				}else{
					Date d = (Date)value;
					return df.format(d);
							//Dateת��Ϊ�ַ���
				}
			}
			
		}, Date.class);
		BeanUtils.setProperty(s, "birthday", "1989-11-29");
		System.out.println(s.getBirthday());
	}
	@Test
	public void test6() throws Exception{
		Student s = new Student();
		ConvertUtils.register(new DateLocaleConverter(), Date.class);
		BeanUtils.setProperty(s, "birthday", "1989-11-29");
		System.out.println(s.getBirthday());
	}
}
