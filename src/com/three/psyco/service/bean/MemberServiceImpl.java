package com.three.psyco.service.bean;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.three.psyco.model.dao.MemberDAOImpl;

@Service
public class MemberServiceImpl implements MemberService {
	
	private final MemberDAOImpl memberDAO;
	@Autowired
	public MemberServiceImpl(MemberDAOImpl memberDAO) {
		this.memberDAO = memberDAO;
	}

	@Override
	public String naverLogin() throws UnsupportedEncodingException {
		
		String clientId = "F7h_WYupw99KssCsaxPS";
		String redirectURI = URLEncoder.encode("http://localhost:8080/psyco/member/naverCallback.com", "UTF-8");
		SecureRandom random = new SecureRandom();
		String state = new BigInteger(130, random).toString();
		String apiURL = "https://nid.naver.com/oauth2.0/authorize?response_type=code";
		apiURL += "&client_id=" + clientId;
		apiURL += "&redirect_url=" + redirectURI;
		apiURL += "&state=" + state;
		
		ServletRequestAttributes servletRequestAttribute = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		HttpSession httpSession = servletRequestAttribute.getRequest().getSession();
		httpSession.setAttribute("state", state);
		
		return apiURL;
	}
	
	@Override
	public StringBuffer callBack() throws UnsupportedEncodingException {
		String clientId = "F7h_WYupw99KssCsaxPS";
		String clientSecret = "AZWV4HS6zb";
		
		ServletRequestAttributes servletRequestAttribute = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		HttpServletRequest request = servletRequestAttribute.getRequest();
		String code = request.getParameter("code");
		String state = request.getParameter("state");
		String redirectURI = URLEncoder.encode("http://localhost:8080/psyco/member/naverCallback.com", "UTF-8");
		String apiURL;
		apiURL = "https://nid.naver.com/oauth2.0/token?grant_type=authorization_code&";
		apiURL += "client_id=" + clientId;
		apiURL += "&client_secret=" + clientSecret;
		apiURL += "&redirect_uri=" + redirectURI;
		apiURL += "&code=" + code;
		apiURL += "&state=" + state;
		String access_token = "";
		System.out.println("access_token=" + access_token);
		String refresh_token = "";
		System.out.println("refresh_token=" + refresh_token);
		
		System.out.println("apiURL=" + apiURL);
		// JSON 타입으로 res에 네이버 측이 전달한 정보가 담겨 있음. 이것은 JSON 타입으로 담겨있으므로 우리가 JSON을 확인 할 수 있도록 형변환해서 사용해야 함.
		StringBuffer res = new StringBuffer();
		
		try {
			URL url = new URL(apiURL);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			int responseCode = con.getResponseCode();
			BufferedReader br;
			System.out.println("responseCode=" + responseCode);
			if (responseCode == 200) { // 정상 호출
				br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			} else { // 에러 발생
				br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}
			
			String inputLine;
			res = new StringBuffer();
			while ((inputLine = br.readLine()) != null) {
				res.append(inputLine);
			}
			br.close();
			if (responseCode == 200) {
				System.out.println(res.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}
	
	@Override
	public HashMap<String, String> MemberProfile(StringBuffer res) throws ParseException {
		JSONParser jSONParser = new JSONParser();
		Object obj = jSONParser.parse(res.toString());
		JSONObject jsonobj = (JSONObject) obj;
		String access_token = (String) jsonobj.get("access_token");
		String refresh_token = (String) jsonobj.get("refresh_token");
		
		String token = access_token;
		String header = "Bearer " + token;
		
		String apiURL = "https://openapi.naver.com/v1/nid/me";
		
		Map<String, String> requestHeaders = new HashMap<String, String>();
		requestHeaders.put("Authorization", header);
		String responseBody = get(apiURL, requestHeaders);
		
		System.out.println(responseBody);
		
		obj = jSONParser.parse(responseBody);
		jsonobj = (JSONObject) obj;
		JSONObject jsonobj2 = (JSONObject) jsonobj.get("response");
		Iterator<String> it = jsonobj2.keySet().iterator();
		
		HashMap<String, String> hMap = new HashMap<String, String>();
		
		while (it.hasNext()) {
			String key = it.next();
			String value = (String) jsonobj2.get(key);
			hMap.put(key, value);
		}
		
		return hMap;
	}
	
	private static String get(String apiURL, Map<String, String> requestHeaders) {
		HttpURLConnection con = connect(apiURL);
		try {
			con.setRequestMethod("GET");
			for (Map.Entry<String, String> header: requestHeaders.entrySet()) {
				con.setRequestProperty(header.getKey(), header.getValue());
			}
			
			int responseCode = con.getResponseCode();
			if (responseCode == HttpURLConnection.HTTP_OK) { // 정상 호출
				return readBody(con.getInputStream());
			} else {
				return readBody(con.getErrorStream());
			}
			
		} catch (IOException e) {
			throw new RuntimeException("API 요청과 응답 실패", e);
		} finally {
			con.disconnect();
		}
	}
	
	private static HttpURLConnection connect(String apiURL) {
		try {
			URL url = new URL(apiURL);
			return (HttpURLConnection) url.openConnection();
		} catch (MalformedURLException e) {
			throw new RuntimeException("API URL이 잘못되었습니다. : " + apiURL, e);
		} catch (IOException e) {
			throw new RuntimeException("연결이 실패했습니다. : " + apiURL, e);
		}
	}
	
	private static String readBody(InputStream body) {
		InputStreamReader streamReader = new InputStreamReader(body);
		
		try (BufferedReader lineReader = new BufferedReader(streamReader)) {
			StringBuilder responseBody = new StringBuilder();
			
			String line;
			while ((line = lineReader.readLine()) != null) {
				responseBody.append(line);
			}
			
			return responseBody.toString();
			
		} catch (IOException e) {
			throw new RuntimeException("API 응답을 읽는데 실패했습니다.");
		}
	}
	
	@Override
	public int existUserCheck(HashMap<String, String> MemberProfile) {
		String email = MemberProfile.get("email");
		System.out.println(email);
		int count = memberDAO.existUserCheck(email);
		System.out.println(count);
		
		return 0;
	}
}
