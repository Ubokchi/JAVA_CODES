package web.ch20.filter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import java.io.IOException;
import java.util.Date;

@WebFilter("/TestFilter")
public class TestFilter extends HttpFilter implements Filter {
    // * Filter의 목적
	// - 서버의 리소스에 접근하기 전에 클라이언트의 요청/응답을 인터셉트 하는 기능
	// - 클라이언트와 서버 간의 요청/응답을 조작
	
	// * Filter의 유형
	// - 인증
	// - 데이터 압축
	// - 암호화
	// - 로그/감시
	// - 이미지 변환
	// - 언어 인코딩
	
	// * Filter 사용법
	// - web.xml 파일에 필터 태그 추가
	
    public TestFilter() {
    	System.out.println("TestFilter 생성자");
    }

	
	public void destroy() {
		
	}

	// doFilter() : 필터를 사용할 때마다 호출
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// 클라이언트로부터 IP 얻기
		String ipAddress = request.getRemoteAddr();
		request.setCharacterEncoding("UTF-8");
		
		// 현재 시간과 IP 주소 출력
		System.out.println("IP : " + ipAddress
				+ ", + Time : " + new Date().toString());
		System.out.println("너는 누구냐?: " + request.getParameter("name"));
		
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
