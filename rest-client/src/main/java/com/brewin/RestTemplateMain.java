package com.brewin;

import org.springframework.web.client.RestTemplate;

public class RestTemplateMain {

	public static void main(String[] args) {
		RestTemplate tpl = new RestTemplate();
		Person p = tpl.getForObject("http://localhost:8080/person/angus", Person.class);
		System.out.println(p.getName() + "---" + p.getAge());
	}

}