package edu.web.ajax;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


@WebServlet("/info.do")
public class InfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public InfoServlet() {
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Java 객체를 JSON 배열 형태로 변경
		// * json 라이브러리 다운로드
		
		String userid = "test";
		String password = "1234";
		String email = "test@test.com";
		
		// JSON Array 객체 생성
		JSONArray jsonArray = new JSONArray();
		
		for(int i = 0; i < 4; i++) {
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("userid", userid);
			jsonObject.put("password", password);
			jsonObject.put("email", email);
			jsonArray.add(jsonObject);
		}
		
		// json 객체 전송
		response.getWriter().append(jsonArray.toString());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
