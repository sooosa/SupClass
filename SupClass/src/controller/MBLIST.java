package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.MemberDTO;
import service.MemberService;

/**
 * Servlet implementation class MBLIST
 */
@WebServlet("/MBlist")
public class MBLIST extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public MBLIST() {
        super();
      
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

		protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			request.setCharacterEncoding("UTF-8"); 
			response.setContentType("text/html; charset=UTF-8");
			
			// Q. jsp에서 받아온데이터 말해보기 
			// A. 아무데이터도 받아오지 않았음
			
			// int result, String
			ArrayList<MemberDTO> memberlist = new ArrayList<MemberDTO>();//다import해준다 
			
			MemberService mSvc = new MemberService();
			//2.controller=>MemberService로이동
			
			memberlist = mSvc.memberList();
			///7.MemberService=>controller로이동
			System.out.println("=============memberlist 출력했을시=========");
			System.out.println(memberlist);
			
			// 1) request영역안에 memberlist를 담는다
				request.setAttribute("memberlist",memberlist);
			
			// 2) request영역안에 담긴 데이터를 가지고 MBList.jsp이동한다.
			// redirect: 데이터x
			// dispatcher : 데이터를 담아서갈수있다
			RequestDispatcher dispatcher = request.getRequestDispatcher("MB_List.jsp");
			dispatcher.forward(request, response);
			
			
			
		}

}
