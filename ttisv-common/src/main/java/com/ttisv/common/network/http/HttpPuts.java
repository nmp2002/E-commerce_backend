package com.ttisv.common.network.http;

import java.io.IOException;
import java.util.Base64;

import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

public class HttpPuts {
	private static String TAG = "2DegreesHttpGetter";
	private String response = null;
	private HttpPut httpput = null;

	
	
	public HttpPuts(String completeUrl, String body, String userName,String passWord) {
		httpput = new HttpPut(completeUrl);
		try {
//			String auth = Base64.getEncoder().encodeToString(("User: "+userName+", Pass: "+passWord).getBytes());
//			String auth = Base64.getEncoder().encodeToString(("User: EBANK, Pass: 12345678").getBytes());
			if(StringUtils.isNotBlank(userName)) {
				String auth = Base64.getEncoder().encodeToString((userName+":"+passWord).getBytes());
				auth = "Basic "+auth;
				httpput.setHeader(HttpHeaders.AUTHORIZATION, auth);
			}
			httpput.setHeader(HTTP.CONTENT_TYPE, "application/json;charset=UTF-8");
			StringEntity stringEntity = new StringEntity(body, "UTF-8");
			httpput.getRequestLine();
			httpput.setEntity(stringEntity);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	public String execute() throws ClientProtocolException, IOException {
		// TODO: Better exception handling/retries here
		if (response == null) {
			HttpClient httpClient = HttpClientSingleton.getInstance();
			HttpResponse serverresponse = null;
			serverresponse = httpClient.execute(httpput);
			HttpEntity entity = serverresponse.getEntity();

			// StringWriter writer = new StringWriter();
			// IOUtils.copy(entity.getContent(), writer);
			response = EntityUtils.toString(entity, "UTF-8");

			if (entity != null) {
				EntityUtils.consumeQuietly(entity);
			}

			// response = writer.toString();
		}
		return response;
	}
}
