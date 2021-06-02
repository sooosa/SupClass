package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.BoardDTO;
import service.BoardService;

@WebServlet("/BMview")
public class BMVIEW extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public BMVIEW() {
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
		response.setContentType("text/html; charest=UTF-8");
		//jsp에서 보낸 bNum
		int bNum = Integer.parseInt(request.getParameter("bNum")) ;
		// int bNum =int타임을받아올시  Integer.parseInt(request.getParameter("bNum")) ;이렇게입력
		
		BoardDTO board = new BoardDTO();
		BoardService bSvc = new BoardService();
		
		board = bSvc.boardView(bNum);
		//controller=>service로
		
		request.setAttribute("board", board);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("BM_View.jsp");
		dispatcher.forward(request, response);
		
	}

}
