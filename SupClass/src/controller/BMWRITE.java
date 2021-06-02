package controller;

import static db.JdbcUtil.close;
import static db.JdbcUtil.commit;
import static db.JdbcUtil.rollback;

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

@WebServlet("/BMWrite")
public class BMWRITE extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public BMWRITE() {
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
		
		// 파일 업로드 관련 설정
				int size = 10 * 1024 * 1024; // 업로드 할 파일 크기 : 10MB
				String savePath = "D:/JAVAWorkspace/JavaClass/SupClass/WebContent/fileUpload";  //파일저장위치
				
				MultipartRequest multi = new MultipartRequest( request, savePath, size, "UTF-8", new DefaultFileRenamePolicy());
				// request영역 : request대신에 multi를 작성한다.
			    // 파일저장경로 설정 : savePath
				// 파일크기 설정 :  size
				// 문자인코딩 설정 : UTF-8
				// 파일이름이 중복될 경우 숫자를 붙여서 이름 재설정 : new DefaultFileRenamePolicy()
				
			//jsp에서 넘겨준 데이터 받아오기
			String bId = multi.getParameter("bId");
			String bTitle = multi.getParameter("bTitle");
			String bContent = multi.getParameter("bContent");
			String bFile = multi.getFilesystemName((String)multi.getFileNames().nextElement());
			
			// BoardDTO타입의 객체Board생성
			BoardDTO board = new BoardDTO();
			
			// 데이터를 객체에 저장할 때는 setter를 사용
			board.setbId(bId);
			board.setbTitle(bTitle);
			board.setbContent(bContent);
			board.setbFile(bFile);
			
			BoardService bSvc = new BoardService();
			
			int result = bSvc.boardWrite(board);
			//2.controller=>service로이동
			
			if(result>0) {
				response.sendRedirect("BMlist");
			} else {
				response.sendRedirect("index.jsp");
			}
			
			
	}

}
