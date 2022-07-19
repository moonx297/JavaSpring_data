package com.spring.ex01;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

public class PersonTest {

	public static void main(String[] args) {
		BeanFactory factory = new XmlBeanFactory (new FileSystemResource("person.xml"));		//new -> spring container 만들기
		PersonService person = (PersonService) factory.getBean("personService");
		person.sayHello();
	}
}