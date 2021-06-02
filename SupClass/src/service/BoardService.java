package service;

import java.sql.Connection;
import java.util.ArrayList;

import static dao.BMDAO.*;
import static db.JdbcUtil.*;

import dao.BMDAO;
import dto.BoardDTO;

public class BoardService {

	//게시글작성 메소드 boardWrite()
	public int boardWrite(BoardDTO board) {
		BMDAO dao = getInstance();
		Connection con =getConnection();
		dao.setConnection(con);
		
		int result = dao.boardWrite(board);
		
		if(result>0) {
			commit(con);
		} else {
			rollback(con);
		}
		//DB접속해제
		close(con);
		
		return result;
	}
	//게시글 목록메소드 public ArrayList<BoardDTO> boardList()
	public ArrayList<BoardDTO> boardList() {
		
		BMDAO dao = getInstance();
		Connection con =getConnection();
		dao.setConnection(con);
		
		ArrayList<BoardDTO> boardlist = null;
		 boardlist = dao.boardList();//Service=>DAO로이동
		
		 close(con);//DB접속해제
		 
		return boardlist;
	}
	//게시글보는 메소드  boardView(int bNum)
	public BoardDTO boardView(int bNum) {
		BMDAO dao = getInstance();
		Connection con =getConnection();
		dao.setConnection(con);
	
		int result = dao.boardHits(bNum);
		
		BoardDTO board = dao.boardView(bNum);

		if(result>0) {
			commit(con);
		}else {
			rollback(con);
		} //메소드 실행시킨후 조회 커밋하거나 롤백하는게 전부이다.
		
		close(con);
		
		return board;
	}
	// 게시글 삭제 메소드 public int boardDelete(int bNum)
	public int boardDelete(int bNum) {
		BMDAO dao = getInstance();
		Connection con =getConnection();
		dao.setConnection(con);
		//service에서dao로 Parameter값
		int result = dao.boardDelete(bNum);
		
		if(result>0) {
			commit(con); //삭제 성공시
		}else {
			rollback(con); //삭제 실패시
		}
			close(con);
		//dao=>service로이동
		return result;
	}
	//게시글 수정 메소드 boardModify(BoardDTO board)
	public int boardModify(BoardDTO board) {
		
		BMDAO dao = getInstance();
		Connection con =getConnection();
		dao.setConnection(con);
		
		//service에서 dao로Parameter값
		int result = dao.boardModify(board);
		
		if(result>0) {
			commit(con);
		}else {
			rollback(con);
		}
			close(con);
		//dao에서 service로return값
		return result;
	}

	


}
