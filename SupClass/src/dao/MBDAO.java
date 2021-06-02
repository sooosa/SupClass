package dao;

import java.sql.*;
import java.util.ArrayList;

import static db.JdbcUtil.*;
import dto.MemberDTO;

public class MBDAO {

	private static MBDAO dao;
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;

	public static MBDAO getInstance() {
		if (dao == null) {
			dao = new MBDAO();
		}
		return dao;
	}

	public void setConnection(Connection con) {
		this.con = con;
	}

	// 회원가입 메소드 memberJoin() , 파라미터 : member == 1
	public int memberJoin(MemberDTO member) {

		int result = 0;
		// 동시에 만족하는값을 만들어 준다.
		String sql = "INSERT INTO BMEMBER VALUES(?,?,?,?,?,?,?)";

		try {// pstmt : sqldeveloper 담는다고생각
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, member.getmId()); // 첫번째 물음표값에 mId값을 넣어준다. (회원가입 창에서 입력한데이터 아이디)
			pstmt.setString(2, member.getmPw()); // 두번째 물음표값에 mPw값을 넣어준다. (회원가입 창에서 입력한데이터 비밀번호)
			pstmt.setString(3, member.getmName()); // 세번째 물음표값에 mName값을 넣어준다. (회원가입 창에서 입력한데이터 이름)
			pstmt.setString(4, member.getmBirth()); // 네번째 물음표값에 mBirth값을 넣어준다. (회원가입 창에서 입력한데이터 생년월일)
			pstmt.setString(5, member.getmGender()); // 다섯번째 물음표값에 mGender값을 넣어준다. (회원가입 창에서 입력한데이터 성별)
			pstmt.setString(6, member.getmEmail()); // 여섯번째 물음표값에 mEmail값을 넣어준다. (회원가입 창에서 입력한데이터 이메일)
			pstmt.setString(7, member.getmFile()); // 일곱번째 물음표값에mFile값을 넣어준다. (회원가입 창에서 입력한데이터 파일)
													// (jsp에서 입력받아서 controller-service를 거쳐 받아온 데이터)

			result = pstmt.executeUpdate(); // 1

			// pstmt.executeUpdate() :: 삽입(INSERT), 삭제(DELETE), 수정(UPDATE)
			// int result에 저장

			// pstmt.executeQuery() :: 조회(SELECT)
			// ResultSet rs에 저장

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);// 접속해제
		}

		return result;
	}

	// 로그인 메소드memberLogin()
	public String memberLogin(String mId, String mPw) {

		System.out.println("3. service에서dao로");
		System.out.println("3.넘어온데이터 (파라미터)");
		System.out.println("mPw:" + mPw);
		System.out.println("mPw:" + mPw);

		String loginId = null;

		// 동시에 만족하는값을 만들어 준다.
		String sql = "SELECT*FROM BMEMBER WHERE MID=? AND MPW=?";
		// 데이터베이스 sql에 단순히 타이핑한것이라고해준거라고 생각

		try {// pstmt : sqldeveloper 담는다고생각
			System.out.println("4.dao에서DB로");
			System.out.println("4.넘어온데이터 (파라미터)");
			System.out.println("mPw:" + mPw);
			System.out.println("mPw:" + mPw);

			pstmt = con.prepareStatement(sql);

			// ? 안에 데이터를 넣어주는 과정
			pstmt.setString(1, mId); // 첫번째 물음표값에 mId값을 넣어준다. (로그인 창에서 입력한데이터 아이디)
			pstmt.setString(2, mPw); // (jsp에서 입력받아서 controller-service를 거쳐 받아온 데이터)
										// 두번째 물음표값에 mPw값을 넣어준다. (로그인 창에서 입력한데이터 패스워드)

			// SELECT 짝꿍 : rs(result),pstmt.executeQuery()
			// pstmt.executeQuery()가 실제로 실행을 한다는 명령어
			// rs는 실행된 결과를 담는곳이다.
			rs = pstmt.executeQuery();

			// 실행한 데이터 베이스의 값이 1개 존재한다면
			if (rs.next()) {
				loginId = rs.getString(1);
				// 데이터 결과중 첫번째 컬럼값

				// loginId = rs.getString("MID")
				// 데이터 결과중 컬럼이름이 MID인값
			}
			// else일 경우 : lognId = null값이된다.;

			// 데이터가 여러개 일때 while문을사용(rs.next()){ }

		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			close(pstmt);// 접속해제
		}

		System.out.println("5.DB에서DAO로");
		System.out.println("5.받아온데이터 (리턴값)");
		System.out.println("loginId:" + loginId);

		return loginId;
	}

	// 회원목록메소드 memberList()
	public ArrayList<MemberDTO> memberList() {
		//Service=>dao로이동
		
		ArrayList<MemberDTO> memberlist = new ArrayList<MemberDTO>();

		String sql = "SELECT * FROM BMEMBER";
		// 한명에 정보를 담을 MemberDTO타입의 객체 member생성
		MemberDTO member = null;

		try {
			//dao=>DB로이동
			pstmt = con.prepareStatement(sql);
			// SELECT짝꿍
			rs = pstmt.executeQuery();

			// rs가나오면
			// 결과가0개 또는 한개일때(PK, UNIQUE 컬럼검색가능) if(rs.next()){},
			// 결과가0개 또는 여러개일때 (PK, UNIQUE 컬럼가능)while(rs.next()){}
			while (rs.next()) {// 반복문이기 때문에 계속 반복한다.
				member = new MemberDTO();
				// (jsp에서 입력받아서 controller-service를 거쳐 받아온 데이터)
				member.setmId(rs.getString(1));
				member.setmPw(rs.getString(2));
				member.setmName(rs.getString(3));
				member.setmBirth(rs.getString(4));
				member.setmGender(rs.getString(5));
				member.setmEmail(rs.getString(6));
				member.setmFile(rs.getString(7));

				memberlist.add(member);
			}

		} catch (SQLException se) {
			se.printStackTrace();
		}
		//5.DB에서DAO로
		return memberlist; // ser
	}

	// 회원 상세보기 메소드 memberView()
	public MemberDTO memberView(String mId) {

		MemberDTO member = null;

		String sql = "SELECT * FROM BMEMBER WHERE MID=?";

		try {
			// System.out.println("4.dao에서DB로");
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mId);
			// SELECT짝꿍
			rs = pstmt.executeQuery();

			while (rs.next()) {
				member = new MemberDTO();
				member.setmId(rs.getString(1));// member대한설정
				member.setmPw(rs.getString(2));
				member.setmName(rs.getString(3));
				member.setmBirth(rs.getString(4));
				member.setmGender(rs.getString(5));
				member.setmEmail(rs.getString(6));
				member.setmFile(rs.getString(7));
			}

		} catch (SQLException se) {
			se.printStackTrace();
		}
		// 5.DB에서DAO로
		return member;
	}

	// 회원삭제 메소드 memberDelete()
	public int memberDelete(String mId) {

		int result = 0;

		String sql = "DELETE FROM BMEMBER WHERE MID=?";

		try {
			// System.out.println("4.dao에서DB로");
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mId);
			// SELECT짝꿍
			result = pstmt.executeUpdate();// DB로이동

		} catch (SQLException se) {
			se.printStackTrace();
		}

		// 5.DB에서DAO로
		return result;
	}

	public int memberModify(MemberDTO member) {
		int result = 0;

		String sql = "UPDATE BMEMBER SET MPW=?, MNAME=?, MBIRTH=?, MGENDER=?, MEMAIL=?, MFILE=? WHERE MID=?";
		try {
			// System.out.println("4.dao에서DB로");
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, member.getmPw());
			pstmt.setString(2, member.getmName());
			pstmt.setString(3, member.getmBirth());
			pstmt.setString(4, member.getmGender());
			pstmt.setString(5, member.getmEmail());
			pstmt.setString(6, member.getmFile());
			pstmt.setString(7, member.getmId());

			result = pstmt.executeUpdate(); // 1

		} catch (SQLException se) {
			se.printStackTrace();
		}
		// 5.DB에서DAO로
		return result;
	}

}
