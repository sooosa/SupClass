package dto;

import java.sql.Date;

// Object(객체) : 1.필드 2.메소드 3.생성자
public class MemberDTO {
	// (1)필드 : 항목 or 컬럼
	private String mId;		// 아이디
	private String mPw;		// 패스워드
	private String mName;	// 이름
	private String mBirth;	// 생년월일
	private String mGender;	// 성별
	private String mEmail;	// 이메일
	private String mFile;	// 사진
	
	// (2)메소드
	// getter,setter,toString
	public String getmId() {
		return mId;
	}
	public void setmId(String mId) {
		this.mId = mId;
	}
	public String getmPw() {
		return mPw;
	}
	public void setmPw(String mPw) {
		this.mPw = mPw;
	}
	public String getmName() {
		return mName;
	}
	public void setmName(String mName) {
		this.mName = mName;
	}
	public String getmBirth() {
		return mBirth;
	}
	public void setmBirth(String mBirth) {
		this.mBirth = mBirth;
	}
	public String getmGender() {
		return mGender;
	}
	public void setmGender(String mGender) {
		this.mGender = mGender;
	}
	public String getmEmail() {
		return mEmail;
	}
	public void setmEmail(String mEmail) {
		this.mEmail = mEmail;
	}
	public String getmFile() {
		return mFile;
	}
	public void setmFile(String mFile) {
		this.mFile = mFile;
	}
	
	// toString() : 출력을 도와줌
	@Override
	public String toString() {
		return "MemberDTO [mId=" + mId + ", mPw=" + mPw + ", mName=" + mName + ", mBirth=" + mBirth + ", mGender="
				+ mGender + ", mEmail=" + mEmail + ", mFile=" + mFile + "]";
	}
	
	
	// (3)생성자
	// 기본생성자, 매개변수(파라미터)가 모두 포함된 생성자
	public MemberDTO() {
		super();
	}
	
	public MemberDTO(String mId, String mPw, String mName, String mBirth, String mGender, String mEmail, String mFile) {
		super();
		this.mId = mId;
		this.mPw = mPw;
		this.mName = mName;
		this.mBirth = mBirth;
		this.mGender = mGender;
		this.mEmail = mEmail;
		this.mFile = mFile;
	}
	
	
	
	
	
	


}
