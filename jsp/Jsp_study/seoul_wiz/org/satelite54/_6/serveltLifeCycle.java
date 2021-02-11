package org.satelite54._6;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class serveltLifeCycle
 */
@WebServlet("/LifeCycle")
public class serveltLifeCycle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public serveltLifeCycle() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {//���� ���۽� ����
		System.out.println("init");
	}

	@PostConstruct
	public void PostConstruct() { // ���� ��ó�� ��ó��
		System.out.println("PostConstruct");
	}
	
	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {// �ڿ��� ���� �� ��
		System.out.println("destroy");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doGet");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost");
	}
	
	@PreDestroy
	public void destoryPreDestory() { // Destory �޼ҵ� ȣ���Ŀ� ȣ��
		System.out.println("PreDestory");
	}
}
