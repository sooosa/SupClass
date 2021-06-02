package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dto.MemberDTO;
import service.MemberService;

/**
 * Servlet implementation class MBMODIFY 
 */
@WebServlet("/MBmodify")
public class MBMODIFY extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public MBMODIFY() {
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
		// request영역 : request대신에 multi를 작성한다.
	    // 파일저장경로 설정 : savePath
		// 파일크기 설정 :  size
		// 문자인코딩 설정 : UTF-8
		// 파일이름이 중복될 경우 숫자를 붙여서 이름 재설정 : new DefaultFileRenamePolicy()
		
		// mId, mPw, mName, mBirth, mGender, mEmail, mFile
		String mId 		= multi.getParameter("mId");
		String mPw 		= multi.getParameter("mPw");
		String mName 	= multi.getParameter("mName");
		String mBirth 	= multi.getParameter("mBirth");
		String mGender	= multi.getParameter("mGender");
		String mEmail 	= multi.getParameter("mEmail");
		String mFile 	= multi.getFilesystemName((String)multi.getFileNames().nextElement());
		
		
		// MemberDTO타입의 객체 member생성
		MemberDTO member = new MemberDTO();
		
		// 데이터를 객체에 저장할 때는 setter를 사용
		member.setmId(mId);
		member.setmPw(mPw);
		member.setmName(mName);
		member.setmBirth(mBirth);
		member.setmGender(mGender);
		member.setmEmail(mEmail);
		member.setmFile(mFile);
		
		MemberService mSvc = new MemberService();
		
		int result = mSvc.memberModify(member);
		
		if(result>0) {
			response.sendRedirect("MBview?mId="+mId);
		}else {
			response.sendRedirect("MBlist");
		}
		
	}//잘확인!!! 가입이랑수정하는거는 거의 비슷하다고 보면 된다.

}
