package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.MemberService;

//로그인 Servlet 
@WebServlet("/MBLogin")//복사해서 붙여넣기 그래야 헷갈리지않는다
public class MBLOGIN extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public MBLOGIN() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("1jsp에서 controllet");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		//1)jsp에서 보낸 아이디랑 패스워드 받아보자!
		//String mId, String mPw
		String mId = request.getParameter("mId");//대소문자 잘구별해서 잘못하겠으면 복사붙여넣기 
		String mPw = request.getParameter("mPw");
		
		System.out.println("1.넘어온데이터(파라미터)");
		System.out.println("mId:"+mId);
		System.out.println("mPw:"+mPw);
		
		// 2)데이터를 서비스 로 넘기기위해
		// MemberService를 임포트 하고
		// service에 서비스를 메소드를 만든다
		MemberService mSvc = new MemberService();//mSvc=>서비스에 있는 내용을 모두 가지고있다.
		
		// 로그인=> String 타입의 메소드 + mId와mPw의 정보만 가지고 간다
		String loginId = mSvc.memberLogin(mId,mPw);
		//MemberService 에서 memberLogin메소드를 호출 => return값을 받아와라!
		
		
		System.out.println("7.service에서controller로");
		System.out.println("7.받아온데이터 (리턴값)");
		//System.out.println("loginId:"+dao.memberLogin(mId,mPw));
        System.out.println("loginId:"+loginId);
		
		//System.out.println("loginId:"+loginId); 아이디가 일치할경우 아이디 에값을 가져온다,일치하지 않을경우 아무런(null)값도 받아오지 않는다.
		
		
		if(loginId!=null) { //로그인성공시
			System.out.println("8.controller에서jsp로");
			System.out.println("8.넘겨줄데이터 (세션값)");
			//session.setAttribute("loginId", loginId);
			
	        System.out.println("loginId:"+loginId);
			
	        HttpSession session =request.getSession();//HtppSession import해준다.
			session.setAttribute("loginId", loginId); //MBJOIN때는 다르게 session.setAttribute()입력
			
			
			
			response.sendRedirect("index.jsp");
		}else {  //로그인실패시
			System.out.println("8.controller에서 jsp로");
			response.sendRedirect("MB_Login.jsp");
		}
		
		
	}
}
