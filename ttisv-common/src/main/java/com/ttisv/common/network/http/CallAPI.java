package com.ttisv.common.network.http;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;

import javax.net.ssl.SSLContext;

import org.apache.commons.net.io.Util;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContexts;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ttisv.common.HubException;
import com.ttisv.common.dto.AuthApiDTO;
import com.ttisv.common.dto.AuthApiResDataDTO;
import com.ttisv.common.utils.StringUtils;
import com.ttisv.common.utils.Utils;

public class CallAPI {
	private static CallAPI instance = null;
	private static final int CONNECTION_TIMEOUT_MS = 15000;
	private static final int CONNECTION_TIMEOUT_MS_TSAT = 35000;
	private static final int CONNECTION_TIMEOUT_QUERY = 3000;
	private static final int CONNECTION_TIMEOUT_CORE = 7000;
	private static final int LATENT_CONNECTION_TIMEOUT_MS = 6000000;
	// private static final String AUTH_API =
	// "https://ssa-api-test.toyotavn.com.vn/api/TokenAuth/Authenticate";
	// public static final String API_TMS = "https://ssa-api.toyotavn.com.vn";
	public static final String API_TMS = "https://tmv-api.toyotavn.com.vn";
	// private static final String AUTH_API =
	// "https://ssa-api.toyotavn.com.vn/api/TokenAuth/Authenticate";
	private static final String AUTH_API = "https://tmv-api.toyotavn.com.vn/api/TokenAuth/Authenticate";

	// public static final String API_TMS = "http://ssa-api-test.toyotavn.com.vn";
	// private static final String AUTH_API =
	// "http://ssa-api-test.toyotavn.com.vn/api/TokenAuth/Authenticate";
	public static String FINALTOKEN = "";
	private static String ABP_TENANTID = "1005";
	Gson gson = new GsonBuilder().setPrettyPrinting().create();

	public static CallAPI getInstance() {
		if (instance == null) {
			System.setProperty("http.maxConnections", "500");
			instance = new CallAPI();
		}
		if (StringUtils.isNullOrEmpty(FINALTOKEN) || Utils.isJWTExpired(FINALTOKEN))
			callInitAPIPostAuth();
		return instance;
	}

	public String httpPosterExecute(String completeUrl, String body) throws ClientProtocolException, IOException {
		HttpPoster sendPoster = new HttpPoster(completeUrl, body);
		return sendPoster.execute();
	}

	public String httpGetExecute(String completeUrl) throws ClientProtocolException, IOException {
		HttpGetter sendGet = new HttpGetter(completeUrl);
		return sendGet.execute();
	}

	public String httpPosterExecute(String completeUrl, String body, String token)
			throws ClientProtocolException, IOException {
		HttpPoster sendPoster = new HttpPoster(completeUrl, body);
		return sendPoster.execute();
	}

	public String callAPIPost(String completeUrl, String body) throws HubException, IOException {
		CloseableHttpClient client = HttpClientBuilder.create().build();
		RequestConfig config = RequestConfig.custom().setConnectTimeout(CONNECTION_TIMEOUT_MS)
				.setConnectionRequestTimeout(CONNECTION_TIMEOUT_MS).setSocketTimeout(CONNECTION_TIMEOUT_MS).build();
		HttpPost httppost = new HttpPost(completeUrl);
		httppost.setHeader(HTTP.CONTENT_TYPE, "application/json;charset=UTF-8");
		httppost.setHeader(HttpHeaders.AUTHORIZATION, "Bearer " + CallAPI.FINALTOKEN);
		httppost.setConfig(config);
		StringEntity stringEntity = new StringEntity(body, "UTF-8");
		httppost.getRequestLine();
		httppost.setEntity(stringEntity);
		CloseableHttpResponse response = client.execute(httppost);
		if (response.getStatusLine().getStatusCode() >= 300) {
			throw new HubException(String.valueOf(response.getStatusLine().getStatusCode()),
					String.format("failure - received a %d for %s.", response.getStatusLine().getStatusCode(),
							httppost.getURI().toString()));
		}

		HttpEntity entity = response.getEntity();

		return EntityUtils.toString(entity, "UTF-8");
	}

	public String callAPIPostQuery(String completeUrl, String body) throws ClientProtocolException, IOException {
		CloseableHttpClient client = HttpClientBuilder.create().build();
		RequestConfig config = RequestConfig.custom().setConnectTimeout(CONNECTION_TIMEOUT_QUERY)
				.setConnectionRequestTimeout(CONNECTION_TIMEOUT_QUERY).setSocketTimeout(CONNECTION_TIMEOUT_QUERY)
				.build();
		HttpPost httppost = new HttpPost(completeUrl);
		httppost.setHeader(HTTP.CONTENT_TYPE, "application/json;charset=UTF-8");
		httppost.setHeader(HttpHeaders.AUTHORIZATION, "Bearer " + CallAPI.FINALTOKEN);
		httppost.setConfig(config);
		StringEntity stringEntity = new StringEntity(body, "UTF-8");
		httppost.getRequestLine();
		httppost.setEntity(stringEntity);
		CloseableHttpResponse response = client.execute(httppost);
		if (response.getStatusLine().getStatusCode() >= 300) {
			throw new IOException(String.format("failure - received a %d for %s.",
					response.getStatusLine().getStatusCode(), httppost.getURI().toString()));
		}
		HttpEntity entity = response.getEntity();
		return EntityUtils.toString(entity, "UTF-8");
	}

	public String callAPIPosts1(String completeUrl, String body) throws ClientProtocolException, IOException {
		CloseableHttpClient client = HttpClientBuilder.create().build();
		RequestConfig config = RequestConfig.custom().setConnectTimeout(CONNECTION_TIMEOUT_MS)
				.setConnectionRequestTimeout(CONNECTION_TIMEOUT_MS).setSocketTimeout(CONNECTION_TIMEOUT_MS).build();
		HttpPost httppost = new HttpPost(completeUrl);
		httppost.setHeader(HTTP.CONTENT_TYPE, "application/json;charset=UTF-8");
		httppost.setHeader(HttpHeaders.AUTHORIZATION, "Bearer " + CallAPI.FINALTOKEN);
		httppost.setConfig(config);
		StringEntity stringEntity = new StringEntity(body, "UTF-8");
		httppost.getRequestLine();
		httppost.setEntity(stringEntity);
		System.setProperty("javax.net.ssl.trustStore", "/u01/IBM/APIGateway.jks");
		System.setProperty("javax.net.ssl.trustStorePassword", "12345678");
		CloseableHttpResponse response = client.execute(httppost);
		if (response.getStatusLine().getStatusCode() >= 300) {
			throw new IOException(String.format("failure - received a %d for %s.",
					response.getStatusLine().getStatusCode(), httppost.getURI().toString()));
		}
		HttpEntity entity = response.getEntity();
		return EntityUtils.toString(entity, "UTF-8");
	}

	public String callAPIPostHttps(String completeUrl, String body) throws ClientProtocolException, IOException,
			KeyManagementException, NoSuchAlgorithmException, KeyStoreException {
		CloseableHttpClient client = buildHttpClient();
		// ------------------------------------------------
		SSLConnectionSocketFactory scsf = new SSLConnectionSocketFactory(
				SSLContexts.custom().loadTrustMaterial(null, new TrustSelfSignedStrategy()).build(),
				NoopHostnameVerifier.INSTANCE);
		client = HttpClients.custom().setSSLSocketFactory(scsf).build();
		// ------------------------------------------------
		HttpPost httppost = new HttpPost(completeUrl);
		httppost.setHeader(HTTP.CONTENT_TYPE, "application/json;charset=UTF-8");
		httppost.setHeader(HttpHeaders.AUTHORIZATION, "Bearer " + CallAPI.FINALTOKEN);
		httppost.setHeader("X-IBM-Client-Id", "82b4d176956e47717d8cc798341133b4");
		StringEntity stringEntity = new StringEntity(body, "UTF-8");
		httppost.getRequestLine();
		httppost.setEntity(stringEntity);
		CloseableHttpResponse response = client.execute(httppost);
		if (response.getStatusLine().getStatusCode() >= 300) {
			throw new IOException(String.format("failure - received a %d for %s.",
					response.getStatusLine().getStatusCode(), httppost.getURI().toString()));
		}
		HttpEntity entity = response.getEntity();
		return EntityUtils.toString(entity, "UTF-8");
	}

	private static CloseableHttpClient buildHttpClient() {
		System.setProperty("https.protocols", "TLSv1.2");
		SSLContext ctx = null;
		try {
			ctx = SSLContexts.custom().useProtocol("TLSv1.2").build();
		} catch (KeyManagementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CloseableHttpClient httpClient = HttpClientBuilder.create().setSslcontext(ctx).build();
		return httpClient;
	}

	public String callAPIPostCore(String completeUrl, String body) throws ClientProtocolException, IOException {
		CloseableHttpClient client = HttpClientBuilder.create().build();
		RequestConfig config = RequestConfig.custom().setConnectTimeout(CONNECTION_TIMEOUT_CORE)
				.setConnectionRequestTimeout(CONNECTION_TIMEOUT_CORE).setSocketTimeout(CONNECTION_TIMEOUT_CORE).build();
		HttpPost httppost = new HttpPost(completeUrl);
		httppost.setHeader(HTTP.CONTENT_TYPE, "application/json;charset=UTF-8");
		httppost.setHeader(HttpHeaders.AUTHORIZATION, "Bearer " + CallAPI.FINALTOKEN);
		httppost.setConfig(config);
		StringEntity stringEntity = new StringEntity(body, "UTF-8");
		httppost.getRequestLine();
		httppost.setEntity(stringEntity);

		CloseableHttpResponse response = client.execute(httppost);
		if (response.getStatusLine().getStatusCode() >= 300) {
			throw new IOException(String.format("failure - received a %d for %s.",
					response.getStatusLine().getStatusCode(), httppost.getURI().toString()));
		}
		HttpEntity entity = response.getEntity();
		return EntityUtils.toString(entity, "UTF-8");
	}

	public void callAPIPostAuth() {
		try {
			AuthApiDTO api = new AuthApiDTO();
			api.setPassword("egNL+qPPcGuf)JrH");
			api.setUserNameOrEmailAddress("API_TI");
			String req = gson.toJson(api);
			String kq = callAPIPostAuth(AUTH_API, req);
			if (StringUtils.isNotEmpty(kq)) {
				AuthApiResDataDTO dt = gson.fromJson(kq, AuthApiResDataDTO.class);
				if (dt.isSuccess() && dt.getResult() != null) {
					CallAPI.FINALTOKEN = dt.getResult().getAccessToken();
					System.out.println(CallAPI.FINALTOKEN);
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public static void callInitAPIPostAuth() {
		try {
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			AuthApiDTO api = new AuthApiDTO();
			api.setPassword("egNL+qPPcGuf)JrH");
			api.setUserNameOrEmailAddress("API_TI");
			String req = gson.toJson(api);
			String kq = callInitAPIPostAuth(AUTH_API, req);
			if (StringUtils.isNotEmpty(kq)) {
				AuthApiResDataDTO dt = gson.fromJson(kq, AuthApiResDataDTO.class);
				if (dt.isSuccess() && dt.getResult() != null) {
					CallAPI.FINALTOKEN = dt.getResult().getAccessToken();
					System.out.println(CallAPI.FINALTOKEN);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void callAPIPostAuth1() {
		try {
			AuthApiDTO api = new AuthApiDTO();
			api.setPassword("egNL+qPPcGuf)JrH");
			api.setUserNameOrEmailAddress("API_TI");
			String req = gson.toJson(api);
			String kq = callAPIPostAuth(AUTH_API, req);
			if (StringUtils.isNotEmpty(kq)) {
				AuthApiResDataDTO dt = gson.fromJson(kq, AuthApiResDataDTO.class);
				if (dt.isSuccess() && dt.getResult() != null) {
					CallAPI.FINALTOKEN = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy54bWxzb2FwLm9yZy93cy8yMDA1LzA1L2lkZW50aXR5L2NsYWltcy9uYW1laWRlbnRpZmllciI6IjEwMDY5MyIsImh0dHA6Ly9zY2hlbWFzLnhtbHNvYXAub3JnL3dzLzIwMDUvMDUvaWRlbnRpdHkvY2xhaW1zL25hbWUiOiJBUElfVEkiLCJBc3BOZXQuSWRlbnRpdHkuU2VjdXJpdHlTdGFtcCI6IkxCS1NSVU9TRkMzUVpaV01RM1laUkREM0JERkhDUlBSIiwiaHR0cDovL3NjaGVtYXMubWljcm9zb2Z0LmNvbS93cy8yMDA4LzA2L2lkZW50aXR5L2NsYWltcy9yb2xlIjoiVXNlciIsImh0dHA6Ly93d3cuYXNwbmV0Ym9pbGVycGxhdGUuY29tL2lkZW50aXR5L2NsYWltcy90ZW5hbnRJZCI6IjEwMDUiLCJzdWIiOiIxMDA2OTMiLCJqdGkiOiI4ZTAxZGFhMC1iZDRmLTQwMjEtYjY4NS01ZGRkZDMwYTdlNWUiLCJpYXQiOjE2NzkwNjIyMjgsInRva2VuX3ZhbGlkaXR5X2tleSI6IjhjY2RlNTI3LWRjNDEtNDY5ZS04NDY3LWFhY2ZlMTg0YTU2ZSIsInVzZXJfaWRlbnRpZmllciI6IjEwMDY5M0AxMDA1IiwidG9rZW5fdHlwZSI6IjAiLCJuYmYiOjE2NzkwNjIyMjgsImV4cCI6MTY3OTEwMDAzMywiaXNzIjoidG1zcyIsImF1ZCI6InRtc3MifQ.6MqpPpdwEftUIrf4usGf8fO_BOsY2UnbDu2ku6j_83U";
					System.out.println(CallAPI.FINALTOKEN);
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public String callAPIPostAuth(String completeUrl, String body) throws ClientProtocolException, IOException {
		CloseableHttpClient client = HttpClientBuilder.create().build();
		RequestConfig config = RequestConfig.custom().setConnectTimeout(CONNECTION_TIMEOUT_CORE)
				.setConnectionRequestTimeout(CONNECTION_TIMEOUT_CORE).setSocketTimeout(CONNECTION_TIMEOUT_CORE).build();
		HttpPost httppost = new HttpPost(completeUrl);
		httppost.setHeader(HTTP.CONTENT_TYPE, "application/json;charset=UTF-8");
		httppost.setHeader(HttpHeaders.AUTHORIZATION, "Bearer " + CallAPI.FINALTOKEN);
		httppost.setHeader("Abp.TenantId", ABP_TENANTID);
		httppost.setConfig(config);
		StringEntity stringEntity = new StringEntity(body, "UTF-8");
		httppost.getRequestLine();
		httppost.setEntity(stringEntity);

		CloseableHttpResponse response = client.execute(httppost);
		if (response.getStatusLine().getStatusCode() >= 300) {
			throw new IOException(String.format("failure - received a %d for %s.",
					response.getStatusLine().getStatusCode(), httppost.getURI().toString()));
		}
		HttpEntity entity = response.getEntity();
		return EntityUtils.toString(entity, "UTF-8");
	}

	public static String callInitAPIPostAuth(String completeUrl, String body)
			throws ClientProtocolException, IOException {
		CloseableHttpClient client = HttpClientBuilder.create().build();
		RequestConfig config = RequestConfig.custom().setConnectTimeout(CONNECTION_TIMEOUT_CORE)
				.setConnectionRequestTimeout(CONNECTION_TIMEOUT_CORE).setSocketTimeout(CONNECTION_TIMEOUT_CORE).build();
		HttpPost httppost = new HttpPost(completeUrl);
		httppost.setHeader(HTTP.CONTENT_TYPE, "application/json;charset=UTF-8");
		httppost.setHeader(HttpHeaders.AUTHORIZATION, "Bearer " + CallAPI.FINALTOKEN);
		httppost.setHeader("Abp.TenantId", ABP_TENANTID);
		httppost.setConfig(config);
		StringEntity stringEntity = new StringEntity(body, "UTF-8");
		httppost.getRequestLine();
		httppost.setEntity(stringEntity);

		CloseableHttpResponse response = client.execute(httppost);
		if (response.getStatusLine().getStatusCode() >= 300) {
			throw new IOException(String.format("failure - received a %d for %s.",
					response.getStatusLine().getStatusCode(), httppost.getURI().toString()));
		}
		HttpEntity entity = response.getEntity();
		return EntityUtils.toString(entity, "UTF-8");
	}

	public String callAPILatentPost(String completeUrl, String body) throws ClientProtocolException, IOException {
		CloseableHttpClient client = HttpClientBuilder.create().build();
		RequestConfig config = RequestConfig.custom().setConnectTimeout(LATENT_CONNECTION_TIMEOUT_MS)
				.setConnectionRequestTimeout(LATENT_CONNECTION_TIMEOUT_MS)
				.setSocketTimeout(LATENT_CONNECTION_TIMEOUT_MS).build();
		HttpPost httppost = new HttpPost(completeUrl);
		try {
			httppost.setHeader(HTTP.CONTENT_TYPE, "application/json;charset=UTF-8");
			httppost.setConfig(config);
			StringEntity stringEntity = new StringEntity(body, "UTF-8");
			httppost.getRequestLine();
			httppost.setEntity(stringEntity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		CloseableHttpResponse response = client.execute(httppost);
		if (response.getStatusLine().getStatusCode() >= 300) {
			throw new IOException(String.format("failure - received a %d for %s.",
					response.getStatusLine().getStatusCode(), httppost.getURI().toString()));
		}
		HttpEntity entity = response.getEntity();
		return EntityUtils.toString(entity, "UTF-8");
	}

	public String callAPIPut(String completeUrl, String body) throws ClientProtocolException, IOException {
		CloseableHttpClient client = HttpClientBuilder.create().build();
		RequestConfig config = RequestConfig.custom().setConnectTimeout(CONNECTION_TIMEOUT_CORE)
				.setConnectionRequestTimeout(CONNECTION_TIMEOUT_CORE).setSocketTimeout(CONNECTION_TIMEOUT_CORE).build();
		HttpPut httppost = new HttpPut(completeUrl);
		try {
			httppost.setHeader(HTTP.CONTENT_TYPE, "application/json;charset=UTF-8");
			httppost.setHeader(HttpHeaders.AUTHORIZATION, "Bearer " + CallAPI.FINALTOKEN);
			httppost.setConfig(config);
			StringEntity stringEntity = new StringEntity(body, "UTF-8");
			httppost.getRequestLine();
			httppost.setEntity(stringEntity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		CloseableHttpResponse response = client.execute(httppost);
		if (response.getStatusLine().getStatusCode() >= 300) {
			throw new IOException(String.format("failure - received a %d for %s.",
					response.getStatusLine().getStatusCode(), httppost.getURI().toString()));
		}
		HttpEntity entity = response.getEntity();
		return EntityUtils.toString(entity, "UTF-8");
	}

	public String callAPIPutTraSoat(String completeUrl, String body) throws ClientProtocolException, IOException {
		CloseableHttpClient client = HttpClientBuilder.create().build();
		RequestConfig config = RequestConfig.custom().setConnectTimeout(CONNECTION_TIMEOUT_MS_TSAT)
				.setConnectionRequestTimeout(CONNECTION_TIMEOUT_MS_TSAT).setSocketTimeout(CONNECTION_TIMEOUT_MS_TSAT)
				.build();
		HttpPut httppost = new HttpPut(completeUrl);
		try {
			httppost.setHeader(HTTP.CONTENT_TYPE, "application/json;charset=UTF-8");
			httppost.setHeader(HttpHeaders.AUTHORIZATION, "Bearer " + CallAPI.FINALTOKEN);
			httppost.setConfig(config);
			StringEntity stringEntity = new StringEntity(body, "UTF-8");
			httppost.getRequestLine();
			httppost.setEntity(stringEntity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		CloseableHttpResponse response = client.execute(httppost);
		if (response.getStatusLine().getStatusCode() >= 300) {
			throw new IOException(String.format("failure - received a %d for %s.",
					response.getStatusLine().getStatusCode(), httppost.getURI().toString()));
		}
		HttpEntity entity = response.getEntity();
		return EntityUtils.toString(entity, "UTF-8");
	}

	public String callAPIPutQuery(String completeUrl, String body) throws ClientProtocolException, IOException {
		CloseableHttpClient client = HttpClientBuilder.create().build();
		RequestConfig config = RequestConfig.custom().setConnectTimeout(CONNECTION_TIMEOUT_QUERY)
				.setConnectionRequestTimeout(CONNECTION_TIMEOUT_QUERY).setSocketTimeout(CONNECTION_TIMEOUT_QUERY)
				.build();
		HttpPut httppost = new HttpPut(completeUrl);
		try {
			httppost.setHeader(HTTP.CONTENT_TYPE, "application/json;charset=UTF-8");
			httppost.setHeader(HttpHeaders.AUTHORIZATION, "Bearer " + CallAPI.FINALTOKEN);
			httppost.setConfig(config);
			StringEntity stringEntity = new StringEntity(body, "UTF-8");
			httppost.getRequestLine();
			httppost.setEntity(stringEntity);
		} catch (Exception e) {

		}
		CloseableHttpResponse response = client.execute(httppost);
		if (response.getStatusLine().getStatusCode() >= 300) {
			throw new IOException(String.format("failure - received a %d for %s.",
					response.getStatusLine().getStatusCode(), httppost.getURI().toString()));
		}
		HttpEntity entity = response.getEntity();
		return EntityUtils.toString(entity, "UTF-8");
	}

	public String callAPIGet(String completeUrl) throws ClientProtocolException, IOException {
		CloseableHttpClient client = HttpClientBuilder.create().build();
		CloseableHttpResponse response = null;
		try {
			RequestConfig config = RequestConfig.custom().setConnectTimeout(CONNECTION_TIMEOUT_MS)
					.setConnectionRequestTimeout(CONNECTION_TIMEOUT_MS).setSocketTimeout(CONNECTION_TIMEOUT_MS).build();
			HttpGet httpget = new HttpGet(completeUrl);
			httpget.setHeader(HTTP.CONTENT_TYPE, "application/json;charset=UTF-8");
			httpget.setHeader(HttpHeaders.AUTHORIZATION, "Bearer " + CallAPI.FINALTOKEN);
			httpget.setConfig(config);
			httpget.getRequestLine();
			response = client.execute(httpget);
			if (response.getStatusLine().getStatusCode() >= 300) {
				throw new IOException(String.format("failure - received a %d for %s.",
						response.getStatusLine().getStatusCode(), httpget.getURI().toString()));
			}
			HttpEntity entity = response.getEntity();
			return EntityUtils.toString(entity, "UTF-8");
		} catch (ClientProtocolException e) {
			throw e;
		} catch (IOException e) {
			throw e;
		} catch (Exception e) {
			throw e;
		} finally {
			try {
				if (response != null)
					response.close();
				if (client != null)
					client.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
}
