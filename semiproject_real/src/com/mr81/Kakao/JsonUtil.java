package com.mr81.Kakao;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonUtil {

	public JsonUtil() {
		// TODO Auto-generated constructor stub
	}

	public static KakaoDTO getinform(String json) {
		KakaoDTO dto = new KakaoDTO();
		JSONParser jp = new JSONParser();
		JSONObject jsonObj2;
		JSONObject jsonObj;

		try {
			jsonObj = (JSONObject) jp.parse(json);
			String email = (String) jsonObj.get("email");
			String profile = jsonObj.get("profile").toString();
			jsonObj2 = (JSONObject) jp.parse(profile);
			String nicknam = (String) jsonObj2.get("nickname");

			dto.setNick(nicknam);
			dto.setId(email);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return dto;
	}




}
