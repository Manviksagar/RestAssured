package com.sag.RestAssured;

import org.testng.annotations.Test;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;

import static com.jayway.restassured.RestAssured.*;

public class FirstApiTest {
	
	@Test
	public void t1() {
		
		Response rep=when().
				get("http://localhost:3000/posts");
		System.out.println(rep.asString());
		System.out.println(rep.getStatusCode());
		
		
	}
	@Test
	public void t2() {
		JsonBean jb= new JsonBean();
		jb.setId(3);
		jb.setTitle("sagar");
		jb.setAuthor("Python");
		
		//GWCBP-Give When Content Body Post
		Response rep=given().
				when().
				contentType(ContentType.JSON).
				body(jb).
				post("http://localhost:3000/posts");
		System.out.println(rep.asString());
		System.out.println(rep.getStatusCode());
		
		
	}
	@Test
	public void t3() {
		
		when().
				get("http://localhost:3000/posts")
				.then().assertThat().statusCode(500);//actual is 200 hence it is fail
		
		
		
	}
	

}
