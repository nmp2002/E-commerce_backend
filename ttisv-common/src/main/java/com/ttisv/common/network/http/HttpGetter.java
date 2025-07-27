package com.ttisv.common.network.http;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URI;

public class HttpGetter {
	// This class handles the simple getting of a url resource and returning the
	// result
	// Since it's a pain to write out all the IOUtils stuff all the time.

	private String response = null;
	private HttpGet httpget = null;

	public HttpGetter(URI uri) {
		httpget = new HttpGet(uri);
	}

	public HttpGetter(String uri) {
		httpget = new HttpGet(uri);
	}

	public String execute() throws ClientProtocolException, IOException {
		// TODO: Better exception handling/retries here, although just bumping it up
		// seems to work
		if (response == null) {
			HttpClient httpClient = HttpClientSingleton.getInstance();
			HttpResponse serverresponse = null;
			httpget.setHeader(HTTP.CONTENT_TYPE, "application/json;charset=UTF-8");
			httpget.setHeader(HttpHeaders.AUTHORIZATION, "Bearer " + CallAPI.FINALTOKEN);
			serverresponse = httpClient.execute(httpget);

			HttpEntity entity = serverresponse.getEntity();

			response = EntityUtils.toString(entity, "UTF-8");
		}
		return response;
	}

}
