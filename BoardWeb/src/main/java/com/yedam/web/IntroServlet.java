package com.yedam.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/intro")
public class IntroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public IntroServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print("<h1>이 페이지는 엄청난 페이지입니다</h1>");
		out.print("소개를 들으면 놀라실 걸요?<br>");
		out.print("제가 한 번 소개해볼까요?<br>");
		out.print("말까요?<br>");
		out.print("궁금하시죠? 궁금하면 500원~");
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
