package work.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import work.model.dto.Member;

public class MemberDao {
	// FactoryDao 객체 생성
	private FactoryDao factory = FactoryDao.getInstance();
	
	// Connection 반환 메서드 구현 : getConnection() : Connection
	public Connection getConnection() {
		return factory.getConnection();
	}
	
	// 전체회원조회
	public ArrayList<Member> selectList() {
		ArrayList<Member> list = new ArrayList<Member>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "select * from members";
		
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			String memberId = null;
			String memberPw = null;
			String memberName = null;
			String mobile = null;
			String email = null;
			String entryDate = null;
			char grade = '\u0000';
			int mileage = 0;
			String manager = null;
			Member dto = null;
			
			while(rs.next()) {
				memberId = rs.getString("memberId");
				memberPw = rs.getString("memberPw");
				memberName = rs.getString("memberName");
				mobile = rs.getString("gender");
				email = rs.getString("birthDateyy");
				entryDate = rs.getString("birthDatemm");
				//String grade = rs.getString("grade");
				grade = rs.getString("grade").charAt(0);
				mileage = rs.getInt("mileage");
				manager = rs.getString("manager");
				
				dto = new Member(memberId, memberPw, memberName, gender, birthDateyy, birthDatemm, birthDatedd, email1, email2, phone, address, entryDate, mileage);
				list.add(dto);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Error(전체회원조회오류) : " + e.getMessage());
		} finally {
			factory.close(rs, stmt, conn);
		}
		
		return list;
	}
	
	// 내정보조회(아이디) : Member
	public Member selectOne(String memberId) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "select * from members where member_id=?";
		
		try {
			conn = getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, memberId);
			rs = stmt.executeQuery();
			
			String memberPw = null;
			String memberName = null;
			String mobile = null;
			String email = null;
			String entryDate = null;
			char grade = '\u0000';
			int mileage = 0;
			String manager = null;
			
			while(rs.next()) {
				memberId = rs.getString("member_id");
				memberPw = rs.getString("member_pw");
				memberName = rs.getString("member_name");
				mobile = rs.getString("mobile");
				email = rs.getString("email");
				entryDate = rs.getString("entry_date");
				grade = rs.getString("grade").charAt(0);
				mileage = rs.getInt("mileage");
				manager = rs.getString("manager");
				
				return new Member(memberId, memberPw, memberName, mobile, email, entryDate, grade, mileage, manager);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Error(전체회원조회오류) : " + e.getMessage());
		} finally {
			factory.close(rs, stmt, conn);
		}
		
		return null;
	}

	// 등급별 전체회원 조회
	public ArrayList<Member> selectList(String grade) {
		ArrayList<Member> list = new ArrayList<Member>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "select * from members where grade=?";
		
		try {
			conn = getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, grade);
			rs = stmt.executeQuery();
			
			String memberId = null;
			String memberPw = null;
			String memberName = null;
			String mobile = null;
			String email = null;
			String entryDate = null;
			int mileage = 0;
			String manager = null;
			Member dto = null;
			
			while(rs.next()) {
				memberId = rs.getString("member_id");
				memberPw = rs.getString("member_pw");
				memberName = rs.getString("member_name");
				mobile = rs.getString("mobile");
				email = rs.getString("email");
				entryDate = rs.getString("entry_date");
				mileage = rs.getInt("mileage");
				manager = rs.getString("manager");
				
				dto = new Member(memberId, memberPw, memberName, mobile, email, entryDate, grade.charAt(0), mileage, manager);
				list.add(dto);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Error(등급별 전체회원조회오류) : " + e.getMessage());
		} finally {
			factory.close(rs, stmt, conn);
		}
		
		return list;
	}

	// 회원 등록
	public int insert(Member dto) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "insert into members values(?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		try {
			conn = getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, dto.getMemberId());
			stmt.setString(2, dto.getMemberPw());
			stmt.setString(3, dto.getMemberName());
			stmt.setString(4, dto.getGender());
			stmt.setString(5, dto.getBirthDate());
			stmt.setString(6, dto.getEntryDate());
			stmt.setString(7, dto.getGrade()+"");
			stmt.setInt(8, dto.getMileage());
			stmt.setString(9, dto.getManager());
			
			return stmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Error(회원등록 오류) : " + e.getMessage());
		} finally {
			factory.close(rs, stmt, conn);
		}
		
		return 0;
	}
	
	/* 내정보 전체변경
	-- 내정보변경
	-- 사용자 변경가능한 속성
	-- 암호, 이름, 연락처, 이메일
	update members set
	member_pw=?, member_name=?, mobile=?, email=?
	where member_id=?
	
	-- 관리자 회원의정보 변경
	-- 암호, 이름, 연락처, 이메일, 가입일, 등급, 마일리지, 담당
	
	*/
	public int update(Member dto) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		//String sql = "insert into members values(?, ?, ?, ?, ?, ?, ?, ?, ?)";
		StringBuilder sql = new StringBuilder();
		sql.append("update members set ");
		sql.append("member_pw=?, member_name=?, mobile=?, email=? ");
		sql.append("where member_id=?");
		
		try {
			conn = getConnection();
			stmt = conn.prepareStatement(sql.toString());
			stmt.setString(1, dto.getMemberPw());
			stmt.setString(2, dto.getMemberName());
			stmt.setString(3, dto.getMobile());
			stmt.setString(4, dto.getEmail());
			stmt.setString(5, dto.getMemberId());
			
			return stmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Error(회원 내정보 변경 오류) : " + e.getMessage());
		} finally {
			factory.close(rs, stmt, conn);
		}
		
		return 0;
	}
	
	// 회원 탈퇴
	public int delete(String memberId) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "delete members where member_id=?";
		
		try {
			conn = getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, memberId);
			
			return stmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Error(회원탈퇴 오류) : " + e.getMessage());
		} finally {
			factory.close(rs, stmt, conn);
		}
		
		return 0;
	}
	
	// 로그인
	public String loginCheck(String memberId, String memberPw) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "select grade from members where member_id=? and member_pw=?";
		
		try {
			conn = getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, memberId);
			stmt.setString(2, memberPw);
			rs = stmt.executeQuery();
			if(rs.next()) {
				return rs.getString("grade");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Error(로그인오류) : " + e.getMessage());
		} finally {
			factory.close(rs, stmt, conn);
		}
		
		return null;
	}
	
	// 관리자 : 회원 전체정보 변경
	public int updateAll(Member dto) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		//String sql = "insert into members values(?, ?, ?, ?, ?, ?, ?, ?, ?)";
		StringBuilder sql = new StringBuilder();
		sql.append("update members set ");
		sql.append("member_pw=?, member_name=?, mobile=?, email=?, ");
		sql.append("entry_date=?, grade=?, mileage=?, manager=? ");
		sql.append("where member_id=?");
		
		try {
			conn = getConnection();
			stmt = conn.prepareStatement(sql.toString());
			stmt.setString(1, dto.getMemberPw());
			stmt.setString(2, dto.getMemberName());
			stmt.setString(3, dto.getMobile());
			stmt.setString(4, dto.getEmail());
			stmt.setString(5, dto.getEntryDate());
			stmt.setString(6, new Character(dto.getGrade()).toString());
			stmt.setInt(7, dto.getMileage());
			stmt.setString(8, dto.getManager());
			stmt.setString(9, dto.getMemberId());
			
			return stmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Error(회원 내정보 변경 오류) : " + e.getMessage());
		} finally {
			factory.close(rs, stmt, conn);
		}
		
		return 0;
	}
	
	// 아이디 찾기
	public String selectMemberId(String memberName, String mobile) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		StringBuilder sql = new StringBuilder();
		sql.append("select member_id from members ");
		sql.append("where member_name=? and mobile=?");
		
		try {
			conn = getConnection();
			stmt = conn.prepareStatement(sql.toString());
			stmt.setString(1, memberName);
			stmt.setString(2, mobile);
			rs = stmt.executeQuery();
			
			if(rs.next()) {
				return rs.getString("member_id");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Error(회원 아이디찾기 오류) : " + e.getMessage());
		} finally {
			factory.close(rs, stmt, conn);
		}
		
		return null;
	}
	
	/*
	 * 암호찾기
	 * 1. 사용자 검색
	 * 2. 임시암호 발급
	 * 3. 임시암호로 기존 암호 변경
	 * 4. 임시암호 반환
	 */
	public String selectMemberPw(String memberId, String memberName, String mobile) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		StringBuilder sql = new StringBuilder();
		sql.append("select member_id from members ");
		sql.append("where member_id=? and member_name=? and mobile=?");
		
		try {
			conn = getConnection();
			stmt = conn.prepareStatement(sql.toString());
			stmt.setString(1, memberId);
			stmt.setString(2, memberName);
			stmt.setString(2, mobile);
			rs = stmt.executeQuery();
			
			if(rs.next()) {
				String tmpPw = Utility.getSecureString(6);
				System.out.println("\n## 임시발급암호 : " + tmpPw);
				
				sql = new StringBuilder();
				sql.append("update members set ");
				sql.append("member_pw=?");
				sql.append("where member_id=?");
				stmt = conn.prepareStatement(sql.toString());
				stmt.setString(1, tmpPw);
				stmt.setString(2, memberId);
				int rows = stmt.executeUpdate();
				if (rows == 1) {
					return tmpPw;
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Error(회원 아이디찾기 오류) : " + e.getMessage());
		} finally {
			factory.close(rs, stmt, conn);
		}
		
		return null;
	}
	
	// 암호변경
	public int updatePassword(String memberId, String memberPw, String newMemberPw) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		StringBuilder sql = new StringBuilder();
		sql.append("update members set ");
		sql.append("member_pw=? ");
		sql.append("where member_id=? and member_pw=?");
		
		try {
			conn = getConnection();
			stmt = conn.prepareStatement(sql.toString());
			stmt.setString(1, newMemberPw);
			stmt.setString(2, memberId);
			stmt.setString(3, memberPw);
			
			return stmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Error(회원 내정보 변경 오류) : " + e.getMessage());
		} finally {
			factory.close(rs, stmt, conn);
		}
		
		return 0;
	}
	
	
	// 로그인
	// 관리자 : 회원등급변경
	// 관리자 : 회원마일리지 변경
	// ...
	
}