package com.ttisv.common.network.http;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.util.Base64;
import java.util.List;

public class HttpPoster {
	// This class handles the simple posting of a url resource and returning the
	// result
	// Since it's a pain to write out all the IOUtils stuff all the time.
	private static String TAG = "2DegreesHttpGetter";
	private String response = null;
	private HttpPost httppost = null;

	public HttpPoster(URI uri, List<? extends NameValuePair> values) {
		httppost = new HttpPost(uri);
		try {
			httppost.setHeader(HTTP.CONTENT_TYPE, "application/json;charset=UTF-8");
			httppost.setHeader(HttpHeaders.AUTHORIZATION, "Bearer " + CallAPI.FINALTOKEN);
			httppost.setEntity(new UrlEncodedFormEntity(values, HTTP.UTF_8));
		} catch (UnsupportedEncodingException e) {

		}
	}

	public HttpPoster(String completeUrl, String body) {
		httppost = new HttpPost(completeUrl);
		try {
			httppost.setHeader(HTTP.CONTENT_TYPE, "application/json;charset=UTF-8");

			StringEntity stringEntity = new StringEntity(body, "UTF-8");
			httppost.getRequestLine();
			httppost.setEntity(stringEntity);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public HttpPoster(String completeUrl, String body, String token) {
		httppost = new HttpPost(completeUrl);
		try {
			httppost.setHeader(HTTP.CONTENT_TYPE, "application/json;charset=UTF-8");
			httppost.setHeader(HttpHeaders.AUTHORIZATION, "Bearer " + token);
			StringEntity stringEntity = new StringEntity(body, "UTF-8");
			httppost.getRequestLine();
			httppost.setEntity(stringEntity);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public HttpPoster(String completeUrl, String body, String userName,String passWord) {
		httppost = new HttpPost(completeUrl);
		try {
//			String auth = Base64.getEncoder().encodeToString(("User: "+userName+", Pass: "+passWord).getBytes());
//			String auth = Base64.getEncoder().encodeToString(("User: EBANK, Pass: 12345678").getBytes());
			String auth = Base64.getEncoder().encodeToString((userName+":"+passWord).getBytes());
			auth = "Basic "+auth;
			httppost.setHeader(HTTP.CONTENT_TYPE, "application/json;charset=UTF-8");
			httppost.setHeader(HttpHeaders.AUTHORIZATION, auth);
			StringEntity stringEntity = new StringEntity(body, "UTF-8");
			httppost.getRequestLine();
			httppost.setEntity(stringEntity);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public HttpPoster(String uri, List<? extends NameValuePair> values) {
		httppost = new HttpPost(uri);
		try {
			httppost.setEntity(new UrlEncodedFormEntity(values, HTTP.UTF_8));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}

	public String execute() throws ClientProtocolException, IOException {
		// TODO: Better exception handling/retries here
		if (response == null) {
			HttpClient httpClient = HttpClientSingleton.getInstance();
			HttpResponse serverresponse = null;
			serverresponse = httpClient.execute(httppost);
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
