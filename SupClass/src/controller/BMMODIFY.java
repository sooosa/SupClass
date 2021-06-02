package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dto.BoardDTO;
import service.BoardService;

/**
 * Servlet implementation class BMMODIFY
 */
@WebServlet("/BMmodify")
public class BMMODIFY extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public BMMODIFY() {
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
		
		
		int size = 10 * 1024 * 1024; // 업로드 할 파일 크기 : 10MB
		String savePath = "D:/JAVAWorkspace/JavaClass/SupClass/WebContent/fileUpload";  //파일저장위치
		
		MultipartRequest multi = new MultipartRequest( request, savePath, size, "UTF-8", new DefaultFileRenamePolicy());
		
		//jsp에서 controller로Parameter값
		int bNum = Integer.parseInt(multi.getParameter("bNum"));
		String bTitle     =multi.getParameter("bNum");
		String bContent   =multi.getParameter("bContent");
		String bFile      =multi.getFilesystemName((String)multi.getFileNames().nextElement());
		
		
		BoardDTO board = new BoardDTO();
		board.setbNum(bNum);
		board.setbTitle(bTitle);
		board.setbContent(bContent);
		board.setbFile (bFile);
		
		//controller에서 service로Parameter
		BoardService bSvc = new BoardService();
		
		int result = bSvc.boardModify(board);
		//service에서 controller로 return값
		
		if(result>0) {
			response.sendRedirect("BMview?bNum="+bNum);//뛰어쓰기하면안됌
			//controller에서 jsp로 세션값
		}else {
			response.sendRedirect("index.jsp");
		}
		
		
	}


}
