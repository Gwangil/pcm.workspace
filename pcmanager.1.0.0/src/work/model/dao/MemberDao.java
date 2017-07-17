package work.model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import work.model.dto.Member;


/**
 * JSP_MEMBER 테이블과 연관된 DAO로
 * 회원 데이터를 처리하는 클래스이다.
 * <br><br>
 * Data Access Object - 테이블 당 한개의 DAO를 작성한다.
 */
public class MemberDao {
	
	private FactoryDao factory = FactoryDao.getInstance();

	public Connection getConnection() {
		return factory.getConnection();
	}

	public Date stringToDate(Member member)
	{
		String year = member.getBirthyy();
		String month = member.getBirthmm();
		String day = member.getBirthdd();
		
		Date birthday  = null;
		
		if(year != null && month != null && day != null)
			birthday = Date.valueOf(year+"-"+month+"-"+day);
		
		return birthday;
		
	} // end stringToDate()
	
	
	/**
	 * 회원정보를 JSP_MEMBER 테이블에 저장하는 메서드
	 * @param member 가입할 회원정보를 담고있는 TO
	 * @throws SQLException
	 */
	public void insertMember(Member member) throws SQLException
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			// 커넥션을 가져온다.
			conn = getConnection();
			
			// 자동 커밋을 false로 한다.
			conn.setAutoCommit(false);
			
			// 쿼리 생성한다.
			// 가입일의 경우 자동으로 세팅되게 하기 위해 sysdate를 사용
			StringBuffer sql = new StringBuffer();
			sql.append("insert into MEMBERS values");
			sql.append("(?, ?, ?, ?, ?, ?, ?, ?, sysdate)");		
			stringToDate(member);
			/* 
			 * StringBuffer에 담긴 값을 얻으려면 toString()메서드를
			 * 이용해야 한다.
			 */
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPassword());
			pstmt.setString(3, member.getName());
			pstmt.setString(4, member.getGender());
			pstmt.setDate(5, stringToDate(member));
			pstmt.setString(6, member.getMail1()+"@"+member.getMail2());
			pstmt.setString(7, member.getPhone());
			pstmt.setString(8, member.getAddress());
			pstmt.setInt(9,member.getMileage());
			
			// 쿼리 실행
			pstmt.executeUpdate();
			// 완료시 커밋
			conn.commit(); 
			
		} catch (SQLException sqle) {
			// 오류시 롤백
			conn.rollback(); 
			throw new RuntimeException(sqle.getMessage());
		} finally {
			// Connection, PreparedStatement를 닫는다.
			try{
				if ( pstmt != null ){ pstmt.close(); pstmt=null; }
				if ( conn != null ){ conn.close(); conn=null;	}
			}catch(Exception e){
				throw new RuntimeException(e.getMessage());
			}
		}
	} // end insertMember()
	
	
	/**
	 * 아이디를 이용해 현재 회원정보를 가져온다.
	 * @param id 회원 아이디
	 * @return MemberBean
	 */
	public Member getUserInfo(String id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Member member = null;

		try {
			// 쿼리
			StringBuffer query = new StringBuffer();
			query.append("SELECT * FROM members WHERE MEMBER_ID=?");
			conn = getConnection();
			System.out.println(conn);
			pstmt = conn.prepareStatement(query.toString());
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if (rs.next()) // 회원정보를 DTO에 담는다.
			{
				// DB의 생년월일정보 -> 년, 월, 일로 문자열 자른다.
				String birthday = rs.getDate("BIRTHDATE").toString();
				String year = birthday.substring(0, 4);
				String month = birthday.substring(5, 7);
				String day = birthday.substring(8, 10);
				
				// 이메일을 @ 기준으로 자른다.
				String mail = rs.getString("EMAIL");
				int idx = mail.indexOf("@"); 
				String mail1 = mail.substring(0, idx);
				String mail2 = mail.substring(idx+1);
				
				// 자바빈에 정보를 담는다.
				member = new Member();
				member.setId(rs.getString("MEMBER_ID"));
				member.setPassword(rs.getString("MEMBER_PW"));
				member.setName(rs.getString("MEMBER_NAME"));
				member.setGender(rs.getString("GENDER"));
				member.setBirthyy(year);
				member.setBirthmm(month);
				member.setBirthdd(day);
				member.setMail1(mail1);
				member.setMail2(mail2);
				member.setPhone(rs.getString("PHONE"));
				member.setAddress(rs.getString("ADDRESS"));
				member.setReg(rs.getTimestamp("ENTRYDATE"));
				member.setMileage(rs.getInt("MILEAGE"));
			}

			return member;

		} catch (SQLException e) {
			System.out.println("error : " + e.getMessage());
		} finally {
			// Connection, PreparedStatement를 닫는다.
			try{
				if ( pstmt != null ){ pstmt.close(); pstmt=null; }
				if ( conn != null ){ conn.close(); conn=null;	}
			}catch(Exception e){
				throw new RuntimeException(e.getMessage());
			}
		}return null;
	}	// end getUserInfo
	
	
	/**
	 * 회원정보를 수정한다.
	 * @param member 수정할 회원정보를 담고있는 TO
	 * @throws SQLException
	 */
	public void updateMember(Member member) throws SQLException{
		
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {

			StringBuffer query = new StringBuffer();
			query.append("UPDATE MEMBERS SET");
			query.append(" MEMBER_PW=?, EMAIL=?, PHONE=?, ADDRESS=?");
			query.append(" WHERE MEMBER_ID=?");

			conn = getConnection();
			pstmt = conn.prepareStatement(query.toString());

			// 자동 커밋을 false로 한다.
			conn.setAutoCommit(false);
			
			pstmt.setString(1, member.getPassword());
			pstmt.setString(2, member.getMail1()+"@"+member.getMail2());
			pstmt.setString(3, member.getPhone());
			pstmt.setString(4, member.getAddress());
			pstmt.setString(5, member.getId());

			pstmt.executeUpdate();
			// 완료시 커밋
			conn.commit(); 
						
		} catch (Exception sqle) {
			conn.rollback(); // 오류시 롤백
			throw new RuntimeException(sqle.getMessage());
		} finally {
			try{
				if ( pstmt != null ){ pstmt.close(); pstmt=null; }
				if ( conn != null ){ conn.close(); conn=null;	}
			}catch(Exception e){
				throw new RuntimeException(e.getMessage());
			}
		}
	} // end updateMember
	
	
	/**
	 * 회원정보를 삭제한다.
	 * @param id 회원정보 삭제 시 필요한 아이디
	 * @param pw 회원정보 삭제 시 필요한 비밀번호
	 * @return x : deleteMember() 수행 후 결과값
	 */
	@SuppressWarnings("resource")
	public int deleteMember(String id, String pw) 
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String dbpw = ""; // DB상의 비밀번호를 담아둘 변수
		int x = -1;

		try {
			// 비밀번호 조회
			StringBuffer query1 = new StringBuffer();
			query1.append("SELECT MEMBER_PW FROM MEMBERS WHERE MEMBER_ID=?");

			// 회원 삭제
			StringBuffer query2 = new StringBuffer();
			query2.append("DELETE FROM MEMBERS WHERE MEMBER_ID=?");

			conn = getConnection();

			// 자동 커밋을 false로 한다.
			conn.setAutoCommit(false);
			
			// 1. 아이디에 해당하는 비밀번호를 조회한다.
			pstmt = conn.prepareStatement(query1.toString());
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			if (rs.next()) 
			{
				dbpw = rs.getString("MEMBER_PW");
				if (dbpw.equals(pw)) // 입력된 비밀번호와 DB비번 비교
				{
					// 같을경우 회원삭제 진행
					pstmt = conn.prepareStatement(query2.toString());
					pstmt.setString(1, id);
					pstmt.executeUpdate();
					conn.commit(); 
					x = 1; // 삭제 성공
				} else {
					x = 0; // 비밀번호 비교결과 - 다름
				}
			}

			return x;

		} catch (Exception sqle) {
			try {
				conn.rollback(); // 오류시 롤백
			} catch (SQLException e) {
				e.printStackTrace();
			}
			throw new RuntimeException(sqle.getMessage());
		} finally {
			try{
				if ( pstmt != null ){ pstmt.close(); pstmt=null; }
				if ( conn != null ){ conn.close(); conn=null;	}
			}catch(Exception e){
				throw new RuntimeException(e.getMessage());
			}
		}
	} // end deleteMember
	

	/**
	 * 로그인시 아이디, 비밀번호 체크 메서드
	 * @param id 로그인할 아이디
	 * @param pw 비밀번호
	 * @return x : loginCheck() 수행 후 결과값 
	 */
	public int loginCheck(String id, String pw) 
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String dbPW = ""; // db에서 꺼낸 비밀번호를 담을 변수
		int x = -1;

		try {
			// 쿼리 - 먼저 입력된 아이디로 DB에서 비밀번호를 조회한다.
			StringBuffer query = new StringBuffer();
			query.append("SELECT MEMBER_PW FROM MEMBERS WHERE MEMBER_ID=?");

			conn =  getConnection();
			pstmt = conn.prepareStatement(query.toString());
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			if (rs.next()) // 입려된 아이디에 해당하는 비번 있을경우
			{
				dbPW = rs.getString("MEMBER_PW"); // 비번을 변수에 넣는다.

				if (dbPW.equals(pw)) 
					x = 1; // 넘겨받은 비번과 꺼내온 비번 비교. 같으면 인증성공
				else 				 
					x = 0; // DB의 비밀번호와 입력받은 비밀번호 다름, 인증실패
				
			} else {
				x = -1; // 해당 아이디가 없을 경우
			}

			return x;

		} catch (Exception sqle) {
			throw new RuntimeException(sqle.getMessage());
		} finally {
			try{
				if ( pstmt != null ){ pstmt.close(); pstmt=null; }
				if ( conn != null ){ conn.close(); conn=null;	}
			}catch(Exception e){
				throw new RuntimeException(e.getMessage());
			}
		}
	} // end loginCheck()	
}

