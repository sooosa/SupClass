package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.BoardService;

/**
 * Servlet implementation class BMDELETE
 */
@WebServlet("/BMdelete")
public class BMDELETE extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public BMDELETE() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//문자 깨짐 방지 
		request.setCharacterEncoding("UTF-8"); 
		response.setContentType("text/html; charest=UTF8");
		//숫자를 controller로 보낼때 사용
		int bNum = Integer.parseInt(request.getParameter("bNum"));
		//jsp=>controller로이동
		
		BoardService bSvc =new BoardService();
		
		int result = bSvc.boardDelete(bNum);
		//controller=>Service로이동
		
		if (result>0) {
			response.sendRedirect("BMlist"); //성공시 BMlist로이동
			//controller=>jsp로이동
		}else {
			response.sendRedirect("index.jsp"); // 실패시 index.jsp로이동
		}
		
	}
}
