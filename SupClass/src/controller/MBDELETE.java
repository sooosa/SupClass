package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.MemberService;


@WebServlet("/MBdelete")
public class MBDELETE extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public MBDELETE() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//문자깨짐 방지 
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String mId = request.getParameter("mId");
		//System.out.println("1.넘어온데이터(파라미터)");
		
		MemberService mSvc = new MemberService(); 
		
		int result = mSvc.memberDelete(mId);//memberService로이동
		//System.out.println("7.service에서controller로");
		
		//dao 에서 String sql ="DELETE FROM BMEMBER WHERE MID=?";
		
		if(result>0) { //성공시
			response.sendRedirect("MBlist");
			//controller, servlet으로 이동
			
			//System.out.println("8.controller에서jsp로");
		}else { // 실패시
			response.sendRedirect("index.jsp");
			//jsp페이지로 이동
		}
		
	}

}
