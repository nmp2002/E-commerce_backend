package com.ttisv.common.network.http;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

public class HttpClientSingleton {
	// This allows us to keep track of a single instance of HttpClient, so the
	// cookies get collected in it.
	private static HttpClient instance = null;

	private HttpClientSingleton() {
	}

	public static HttpClient getInstance() {
		if (instance == null) {
			instance = new DefaultHttpClient();
			HttpParams httpParams = instance.getParams();
			HttpConnectionParams.setConnectionTimeout(httpParams, 50000);
			HttpConnectionParams.setSoTimeout(httpParams, 50000);
		}
		return instance;
	}
}
