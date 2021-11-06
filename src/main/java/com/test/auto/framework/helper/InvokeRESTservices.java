package com.test.auto.framework.helper;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;

import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class InvokeRESTservices {

	public static HashMap<String,String> authMap = new HashMap<String,String>()
	{
		{  
			put("AcccountId","AC5e7f5460db3fab0c72e4bcd04789d61b");
			put("AuthToken","25a9a3b7129b4f9ec15c58fa6b214c08");
				
		}
		
	};
	
	private InvokeRESTservices()
	{
		
	}
	
	public static Response SubmitRestPostRequestWithRelaxedValidation(Headers requestHeaders,Object obj,String endpoint)
	{
		return RestAssured
				.given()
				.relaxedHTTPSValidation()
				.headers(requestHeaders)
				.when().log().headers()
				.body(new Gson().toJson(obj))
				.when().log().body()
				.post(endpoint);
		
	}
	
	public static Response SubmitRestPatchRequestWithRelaxedValidation(Headers requestHeaders,Object obj,String endpoint)
	{
		return RestAssured
				.given()
				.relaxedHTTPSValidation()
				.headers(requestHeaders)
				.when().log().headers()
				.body(new Gson().toJson(obj))
				.when().log().body()
				.patch(endpoint);
		
	}
	public static Response SubmitRestGetRequestWithRelaxedValidation(Headers requestHeaders,String endpoint)
	{
		
		if(requestHeaders.size() > 0)
		{
				return RestAssured
						.given()
						///.auth().basic(authMap.get("AcccountId"), authMap.get("AuthToken"))
						.relaxedHTTPSValidation()
						.headers(requestHeaders)
						.when().log().headers()
						.get(endpoint);		
		}
		else
		{
				 return	RestAssured
					.given()
					.relaxedHTTPSValidation()
					.get(endpoint);
				 
				 
		}
	}
	public static Response SubmitRestPostRequestRelaxedValidationWithBasicAuthAndFormParam(Headers requestHeaders,String endpoint,String authKey,Map<String,String> formparams)
	{
		return RestAssured
				.given()
				.relaxedHTTPSValidation()
				.auth().preemptive().basic(authKey, authMap.get(authKey))
				.headers(requestHeaders)
				.when().log().headers()
				.formParams(formparams)
				.when().log().body()
				.post(endpoint);
		
	}
	
}
