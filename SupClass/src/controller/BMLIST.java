package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.BoardDTO;
import service.BoardService;

/**
 * Servlet implementation class BMLIST
 */
@WebServlet("/BMlist")
public class BMLIST extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public BMLIST() {
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
		
		ArrayList<BoardDTO> boardlist = new ArrayList<BoardDTO>();
		
		BoardService bSvc = new BoardService();
		
		boardlist = bSvc.boardList();//파라미터값이아무것도 없으면 데이터를져가지않는다.
		
		request.setAttribute("boardlist", boardlist);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("BM_LIST.jsp");//네이밍헷갈리지 않도록주의
		
		dispatcher.forward(request, response);
		
	}

}
