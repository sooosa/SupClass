package service;

import java.sql.Connection;
import java.util.ArrayList;

import dao.MBDAO;
import dto.MemberDTO;

import static dao.MBDAO.*;
import static db.JdbcUtil.*;


public class MemberService {
	// service에서 처리할 내용
	// con, commit, rollback, close등등
	
	//회원가입 메소드 memberJoin()
	public int memberJoin(MemberDTO member) {
		// 서비스로 넘어올때 복붙하기
		MBDAO dao = getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		
		// dao로 정보를이동 작업을해준다
		int result = dao.memberJoin(member);
		//MBDAO에서 memberJoin메소드를 호출(실행)=> return값을 받아와라!
		if(result>0) {
			commit(con);
		} else {
			rollback(con);
		}
		//DB접속해제
		close(con);
		
		return result;
	}
	
		//로그인 메소드 memberLogin()
	
	public String memberLogin(String mId, String mPw) {
		System.out.println("2.controller에서 service");
		System.out.println("2.넘어온데이터 (파라미터)");
		System.out.println("mPw:"+mPw);
		System.out.println("mPw:"+mPw);
		// 서비스로 넘어올때 복붙하기
		MBDAO dao = getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		
		// dao로 정보를이동 작업을해준다
		String loginId = dao.memberLogin(mId,mPw); 
		//MBDAO에서 memberLogin메소드를 호출(실행)=> return값을 받아와라!
		
		
		
		
		System.out.println("6.DAO에서service로");
		System.out.println("6.받아온데이터 (리턴값)");
		//System.out.println("loginId:"+dao.memberLogin(mId,mPw));
        System.out.println("loginId:"+loginId);
		
		//DB접속해제
		close(con);
		
		
		
		return loginId;
	}
	
	//회원목록 메소드memberLIst()
	public ArrayList<MemberDTO> memberList() { //데이터를 가지고 가지 않았다.
		MBDAO dao = getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		
		
		ArrayList<MemberDTO> memberlist =null;
		memberlist = dao.memberList();
		//6.DAO에서service로
		
		//DB접속해제
		close(con);
		
		return memberlist;
	}
	//상세보기 메소드 memberView()
	public MemberDTO memberView(String mId) {
		MBDAO dao = getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		
		MemberDTO member = dao.memberView(mId);
		
		close(con);
		
		return member;
	}
	// 회원 삭제 메소드 memberDelete()
	public int memberDelete(String mId) {
		//System.out.println("2.controller에서 service");
		MBDAO dao = getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		
		int result = dao.memberDelete(mId);//memberDAO로이동
		
		if(result>0) {
			commit(con);
		}else {
			rollback(con);
		}
			close(con);
		
		//"6.DAO에서service로
		return result;
	}
	
	//
	public int memberModify(MemberDTO member) {
		//System.out.println("2.controller에서 service");
		MBDAO dao = getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		
		 int result = dao.memberModify(member);
		 
		 if(result>0) {//result 결과를닿는다
			 commit(con);
		 }else {
			 rollback(con);
		 }
		 close(con);
		 
		//"6.DAO에서service로
		return result;
	}

	
	

}







