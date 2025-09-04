<%@page import="org.apache.commons.fileupload.FileItem"%>
<%@page import="java.util.List"%>
<%@page import="org.apache.commons.fileupload.servlet.ServletFileUpload"%>
<%@page import="java.io.File"%>
<%@page import="org.apache.commons.fileupload.disk.DiskFileItemFactory"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8"); // 한글 인코딩
	String realPath = "";
	String savePath = "images";
	String type = "utf-8";
	int maxSize = 10 * 1024 * 1024;
	
	ServletContext context = request.getServletContext();
	
	// 실제 경로 확인
	realPath = context.getRealPath(savePath);
	
	out.println(realPath);
	out.print("<hr>");
	
	DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
	diskFileItemFactory.setRepository(new File(realPath));
	diskFileItemFactory.setSizeThreshold(maxSize);
	diskFileItemFactory.setDefaultCharset(type);
	
	// 업로드 핸들러
	ServletFileUpload fileUpload
		 = new ServletFileUpload(diskFileItemFactory);
	
	// request 정보를 가져와서 upload 형태에 맞게 작성
	List<FileItem> items = fileUpload.parseRequest(request);
%>