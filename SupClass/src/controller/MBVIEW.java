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

/**
 * Servlet implementation class MBVIEW
 */
@WebServlet("/MBview")
public class MBVIEW extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public MBVIEW() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//한글 깨짐방지
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		//jsp에서 보낸 mId 받기!
		String mId = request.getParameter("mId");//넘겨주기위해서
		
		MemberDTO member = new MemberDTO();
		MemberService mSvc = new MemberService();
		
		member = mSvc.memberView(mId);//Parameter값으로 넣어준다
		
		request.setAttribute("member", member);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("MB_View.jsp");
		dispatcher.forward(request, response);
		
	}


}
