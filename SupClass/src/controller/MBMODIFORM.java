package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.MemberDTO;
import service.MemberService;


@WebServlet("/MBmodiForm")
public class MBMODIFORM extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public MBMODIFORM() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcss(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcss(request, response);
	}

	protected void doProcss(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charest=UTF-8");
		
		String mId = request.getParameter("mId");
		
		//DB에서 mId의 회원정보를 불러올예정
		MemberService mSvc = new MemberService();
		MemberDTO member =new MemberDTO();
		
		//이미만들어준 memberview()메소드를 호출한다.
		member = mSvc.memberView(mId);
		
		// member라는 정보를 "modify"라는 이름으로 사용하겠다(jsp)
		request.setAttribute("modify", member);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("MB_Modify.jsp");
		dispatcher.forward(request, response);
		
	}
}
