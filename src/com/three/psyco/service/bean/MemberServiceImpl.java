package com.three.psyco.service.bean;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.DataOutputStream;
import java.io.File;
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
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.three.psyco.model.dao.MemberDAOImpl;
import com.three.psyco.model.dto.MemberDTO;
import com.three.psyco.model.dto.MemberShopDTO;

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
		int count = memberDAO.existUserCheck(email);
		return count;
	}
	
	@Override
	public void psycoLogin(HashMap<String, String> MemberProfile) {
		String email = MemberProfile.get("email");
		MemberDTO dto = memberDAO.getMemberProfile(email);
		
		ServletRequestAttributes servletRequestAttribute = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		HttpSession httpSession = servletRequestAttribute.getRequest().getSession();
		httpSession.setAttribute("memId", dto.getMember_Id());
		httpSession.setAttribute("memNum", dto.getMember_Num());
	}
	
	@Override
	public MemberDTO setInfoFromNaver(HashMap<String, String> MemberProfile) {
		MemberDTO dto = new MemberDTO();
		dto.setName(MemberProfile.get("name"));
		dto.setGender(MemberProfile.get("gender"));
		dto.setNickname(MemberProfile.get("nickname"));
		dto.setEmail(MemberProfile.get("email"));
		return dto;
	}
	
	@Override
	public int insertMember(MemberDTO dto) {
		int result = 0;
		if (dto.getLicense_number() == "") {
			dto.setLicense_number("0");
			result = memberDAO.insertMember(dto);
			result = 2;
		}else {
			result = memberDAO.insertMember(dto);
		}
		
		return result;
	}
	
	@Override
	public int loginCheck(String member_Id, String pw) {
		int count = memberDAO.loginCheck(member_Id, pw);
		if (count == 1) {
			MemberDTO dto = memberDAO.getMemberProfileFromId(member_Id);
			
			
			ServletRequestAttributes servletRequestAttribute = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
			HttpSession httpSession = servletRequestAttribute.getRequest().getSession();
			if(dto.getBusiness_license() != 0 ) {
				httpSession.setAttribute("shopCheck", dto.getBusiness_license());
			}
		
			httpSession.setAttribute("memId", member_Id);
			httpSession.setAttribute("memNum", dto.getMember_Num());
			httpSession.setAttribute("business", dto.getBusiness_license());
		}
		return count;
	}
	
	@Override
	public String licenseLookup(String license_number) throws IOException {
		String PostUrl = "https://teht.hometax.go.kr/wqAction.do?actionId=ATTABZAA001R08&screenId=UTEABAAA13&popupYn=false&realScreenId=";
		String xmlRaw = "<map id=\"ATTABZAA001R08\"><pubcUserNo/><mobYn>N</mobYn><inqrTrgtClCd>1</inqrTrgtClCd><txprDscmNo>{parameter}</txprDscmNo><dongCode>15</dongCode><psbSearch>Y</psbSearch><map id=\"userReqInfoVO\"/></map>";
		
		// 사업장이 운영중인지 알려줄 메시지를 담아줄 변수 
		String status = null;
		
		// 파싱
		try {
			
			xmlRaw = xmlRaw.replace("{parameter}", license_number);
			
			String res = sendPost(PostUrl, xmlRaw);
			System.out.println(res);
			
			DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
			Document document = documentBuilder.parse(new ByteArrayInputStream(res.getBytes()));
			
			XPathFactory xPathFactory = XPathFactory.newInstance();
			XPath xPath = xPathFactory.newXPath();
			
			status = (String)xPath.evaluate("//map/trtCntn", document, XPathConstants.STRING);
			
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (XPathExpressionException e) {
			e.printStackTrace();
		}
		
		return status;
	}
	
	private String sendPost(String targetUrl, String parameter) throws MalformedURLException, IOException {
		URL url = new URL(targetUrl);
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		
		con.setRequestMethod("POST");
		con.setRequestProperty("Content-Type", "application/xml");
		con.setRequestProperty("Accept", "application/xml");
		
		con.setDoOutput(true);// POST 파라미터 전달을 위한 설정
		
		// send post Request
		DataOutputStream wr = new DataOutputStream(con.getOutputStream());
		wr.writeBytes(parameter);
		wr.flush();
		wr.close();
		
		int responseCode = con.getResponseCode();
		System.out.println(responseCode);
		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();
		
		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
		
		return response.toString();
	}

		//멤버 정보 가져오기 -동윤-
	@Override
	public MemberDTO memberInfos(String session) throws Exception {
		MemberDTO dto=memberDAO.memberInfo(session);
		return null;
	}

	@Override
	public String getNickNames(String session) throws Exception {
		String nickname ="";
		nickname=memberDAO.getNickName(session);
		return nickname;
	}
	
	
	@Override
	public int userDelete(String member_Id, String pw) {
		
		int result = memberDAO.userDelete(member_Id, pw);
		return result;
	}
	
	@Override
	public int userTypeCheck(String member_Id) {
		MemberDTO dto = memberDAO.getMemberProfileFromId(member_Id);
		if (dto.getPw() == "0") {	// 소셜 로그인으로 가입한 아이디 일 때
			return 0;
		} else {
			return 1;
		}
	}
	
	@Override
	public MemberDTO getMemberProfileFromNum(int member_Num) {
		MemberDTO dto = memberDAO.getMemberProfileFromNum(member_Num);
		return dto;
	}
	
	@Override
	public int modifySocialUserPro(String phoneNum, String birth) {
		ServletRequestAttributes servletRequestAttribute = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		HttpSession httpSession = servletRequestAttribute.getRequest().getSession();
		
		int member_Num = (int) httpSession.getAttribute("memNum");
		String member_Id = (String) httpSession.getAttribute("memId");
		
		int result = memberDAO.modifySocialUserPro(member_Num, member_Id, phoneNum, birth);
		
		return result;
	}
	
	@Override
	public int modifyNormalUserPro(MemberDTO dto) {
		ServletRequestAttributes servletRequestAttribute = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		HttpSession httpSession = servletRequestAttribute.getRequest().getSession();
		
		int member_Num = (int) httpSession.getAttribute("memNum");
		String member_Id = (String) httpSession.getAttribute("memId");
		
		dto.setMember_Num(member_Num);
		int result = memberDAO.modifyNormalUserPro(dto);
		
		return result;
	}
	
	@Override
	public void insertMemberShops(MultipartHttpServletRequest request,int member_num,String status,String approve_status) throws SQLException {
		MemberShopDTO dto=new MemberShopDTO();
		String shop_name=request.getParameter("shop_name");
		String shop_phone=request.getParameter("shop_phone");
		String operating_time=request.getParameter("operating_time");
		String address=request.getParameter("address");
		String origin=request.getParameter("origin");
		String takeout=request.getParameter("takeout");
		String license_number=request.getParameter("license_number");
		MultipartFile mf = request.getFile("shop_img");
		try {
			String path=request.getRealPath("save");
			System.out.println("path ="+path);
			String orgName =mf.getOriginalFilename();
			String imgName =orgName.substring(0, orgName.lastIndexOf('.'));
			String ext = orgName.substring(orgName.lastIndexOf('.'));
			Long date=System.currentTimeMillis();
			String newName=imgName+date+ext;
			String imgPath = path+"/"+newName;
			System.out.println("--------- insertMember ----------");
			System.out.println("imgPath : " + imgPath);
			File file=new File(imgPath);
			mf.transferTo(file);
			dto.setShop_img(newName);
		}catch(Exception e) {
			e.printStackTrace();
		}
		dto.setShop_name(shop_name);
		dto.setShop_phone(shop_phone);
		dto.setOperating_time(operating_time);
		dto.setAddress(address);
		dto.setOrigin(origin);
		dto.setApprove_status(approve_status);
		dto.setMember_num(member_num);
		dto.setTakeout(takeout);
		dto.setlicense_number(license_number);
		dto.setStatus(status);
		
		
		System.out.println("-------- 정체가 뭐야 ");
		System.out.println(dto.getShop_name());
		System.out.println(dto.getShop_phone());
		System.out.println(dto.getOperating_time());
		System.out.println(dto.getAddress());
		System.out.println(dto.getOrigin());
		
		System.out.println(dto.getApprove_status());
		System.out.println(dto.getMember_num());
		System.out.println(dto.getTakeout());
		System.out.println(dto.getlicense_number());
		System.out.println(dto.getStatus());
		System.out.println("-------- 정체가 뭐야 ");
		;
		
		memberDAO.insertMemberShop(dto);
		
	}

	@Override
	public int idChk(String id) throws SQLException {
		int result = memberDAO.idChk(id);
		System.out.println("id2=="+id);
		return result;
		
	}
}
