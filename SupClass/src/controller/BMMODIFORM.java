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

/**
 * Servlet implementation class BMMODIFORM
 */
@WebServlet("/BMmodiForm")
public class BMMODIFORM extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public BMMODIFORM() {
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
		
		int bNum = Integer.parseInt(request.getParameter("bNum")) ;
		
		BoardService bSvc = new BoardService();
		BoardDTO board = new BoardDTO();
		
		board = bSvc.boardView(bNum);
		
		request.setAttribute("modify", board);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("BM_Modify.jsp");
		dispatcher.forward(request, response);
		
	}

}
