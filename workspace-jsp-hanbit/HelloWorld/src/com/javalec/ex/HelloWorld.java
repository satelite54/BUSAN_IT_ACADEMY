package com.javalec.ex;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloWorld
 */
@WebServlet("/HW")
public class HelloWorld extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloWorld() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
    // HTML 클라이언트에서 WAS로 데이터 요청하는 방식은 두가지가 있다. get post 방식
    // HTML 에서 get 방식으로 호출하면 Servlet에서는 doGet 메서드 호출
    // HTML내 post 방식으로 호출하면 doPost 호출
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//URL 값으로 정보가 전송되어 보안에 약함
		System.out.println("doGet");
		
		response.setContentType("text/html; charset=euc-kr");
		PrintWriter writer = response.getWriter(); // 웹브라우저에 출력하기 위한 스트림
		
		writer.println("<html>");
		writer.println("<head>");
		writer.println("</head>");
		writer.println("<body>");
		writer.println("<h1>HelloWorld~~~</h1>");
		writer.println("</body>");
		writer.println("</html>");
		
		writer.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//header를 이용해 정보 전송되어 보안에 강함
		System.out.println("doPost");
	}
}
