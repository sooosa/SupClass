package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dto.BoardDTO;

public class BMDAO {

	private static BMDAO dao;
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;

	public static BMDAO getInstance() {
		if (dao == null) {
			dao = new BMDAO();
		}
		return dao;
	}

	public void setConnection(Connection con) {
		this.con = con;
	}
	//게시작성메소드boardWrite()
	public int boardWrite(BoardDTO board) {
		
		int result =0;
		
		String sql="INSERT INTO MBOARD VALUES(MB_SEQ.NEXTVAL,?,?,?,SYSDATE,0,?)";
		
		try {
			pstmt =con.prepareStatement(sql);
			pstmt.setString(1, board.getbId());
			pstmt.setString(2, board.getbTitle());
			pstmt.setString(3, board.getbContent());
			pstmt.setString(4, board.getbFile());
			
			result=pstmt.executeUpdate();
			
		} catch (SQLException se) {
			se.printStackTrace();
		}
		
		return result;
	}
	//게시만 목록 메소드  ArrayList<BoardDTO> boardList()
	public ArrayList<BoardDTO> boardList() {
		ArrayList<BoardDTO> boardlist = new ArrayList<BoardDTO>();
		
		String sql = "SELECT * FROM MBOARD ORDER BY BNUM DESC";//최근 작성 하게 위로
		
		BoardDTO board = null;
		
		try {
			pstmt= con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				board = new BoardDTO();
				board.setbNum(rs.getInt(1)); //숫자는 getint()로
				board.setbId(rs.getString(2));
				board.setbTitle(rs.getString(3));
				board.setbContent(rs.getString(4));
				board.setbDate(rs.getDate(5)); //날짜는 getDate()로 
				board.setbHits(rs.getInt(6));
				board.setbFile(rs.getString(7));
				
				boardlist.add(board);//하나의글에  모든내용을 추가는하는 의미이다
				
			}
			
		} catch (SQLException se) {
			se.printStackTrace();
		}
		
		return boardlist;
	}
	//글정보기BoardDTO boardView()메소드
	public BoardDTO boardView(int bNum) {
		 BoardDTO board =null;
		 
		 String sql ="SELECT * FROM MBOARD WHERE BNUM=?";
		
		 try {
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1,bNum);//setInt로
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) { //db에대한 정보를 다가지고 온다
				board = new BoardDTO();
				board.setbNum(rs.getInt(1));
				board.setbId(rs.getString(2));
				board.setbTitle(rs.getString(3));
				board.setbContent(rs.getString(4));
				board.setbDate(rs.getDate(5));
				board.setbHits(rs.getInt(6));
				board.setbFile(rs.getString(7));
			}
			
			
			
		} catch (SQLException se) {
			se.printStackTrace();
		}
		
		
		return board;
	}
	//조회수 증가 메소드 public int boardHits(int bNum) {}
	public int boardHits(int bNum) {
		int result =0;
		String sql ="UPDATE MBOARD SET BHITS=BHITS+1 WHERE BNUM=?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, bNum);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException se) {
			se.printStackTrace();
		}
		
		return result;
	}
	//글삭제 메소드  public int boardDelete(int bNum){}
	public int boardDelete(int bNum) {
		
		int result =0;
		//dao=>db로이동
		String sql = "DELETE FROM MBOARD WHERE BNUM=?"; //안됐을때에는 String sql"";쓴게 맞는지 확인 하기위해 DB에서 확인하기  
		
		try {
			//db=>dao로이동
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, bNum);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException se) {
			se.printStackTrace();
		}
		
		return result;
	}

	
	//글수정 메소드 public int boardModify(BoardDTO board){}
	public int boardModify(BoardDTO board) {
		int result =0;
		//dao에서 DB로Parameter값
		String sql="UPDATE MBOARD SET BTITLE=?, BCONTENT=?, BFILE=? WHERE BNUM=?";
		
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, board.getbTitle());
			pstmt.setString(2, board.getbContent());
			pstmt.setString(3, board.getbFile());
			pstmt.setInt(4,board.getbNum());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException se) {
			se.printStackTrace();
		}
		//DB에서dao로return값
		return  result;
	}

}
