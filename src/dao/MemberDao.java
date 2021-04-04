package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Member;

//CRUD sql ��� ���� ��ü
public class MemberDao {
	
	public int insert(Member mem) {
		Connection conn = DBConnection.getConnection();
		PreparedStatement pstmt = null;
		String sql = "insert into member4 values (?,?,?,?,?,?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mem.getId());
			pstmt.setString(2, mem.getPass());
			pstmt.setString(3, mem.getName());
			pstmt.setString(4, mem.getBirth());
			pstmt.setString(5, mem.getTel());
			pstmt.setString(6, mem.getAddress());
			pstmt.executeUpdate();
			
			return pstmt.executeUpdate();
		} catch(SQLException e)	{
			e.printStackTrace();
		} finally {
			DBConnection.close(conn, pstmt, null);
		}
		return 0;
	}
	
	
	public int update(Member mem) {
		Connection conn = DBConnection.getConnection();
		PreparedStatement pstmt = null;
		String sql = "update member4 set name=?,birth=?,tel=?"
				+ ", address=? where id=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mem.getName());
			pstmt.setString(2, mem.getBirth());
			pstmt.setString(3, mem.getTel());
			pstmt.setString(4, mem.getAddress());
			
			pstmt.setString(5, mem.getId());

			
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBConnection.close(conn, pstmt, null);
		}
		return 0;
	}
	public int updatePass(String id, String chgpass) {
		Connection conn = DBConnection.getConnection();
		PreparedStatement pstmt = null;
		String sql = "update member4 set pass=? where id=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, chgpass);
			pstmt.setString(2, id);
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBConnection.close(conn, pstmt, null);
		}
		return 0;
	}
	public int delete(String id) {
		Connection conn = DBConnection.getConnection();
		PreparedStatement pstmt = null;
		String sql = "delete from member4 where id=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConnection.close(conn, pstmt, null);
		}
		return 0;
	}
	public Member selectOne(String id) {
		Connection conn = DBConnection.getConnection();
		PreparedStatement pstmt = null; 
		ResultSet rs = null;
		String sql = "select * from member4 where id = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				Member m = new Member();
				m.setId(rs.getString("id"));
				m.setPass(rs.getString("password"));
				m.setName(rs.getString("name"));
				m.setBirth(rs.getString("birth"));
				m.setTel(rs.getString("tel"));
				m.setAddress(rs.getString("address"));
				return m;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConnection.close(conn, pstmt, rs);
		}
		System.out.println("검색실패");
		return null;
	}
	
	
	public int selectById(String id) {
			
			
			
			Connection conn = DBConnection.getConnection();
			
			ResultSet rs = null;
			String sql = "select id from member4 where id = ?";
			try {
				PreparedStatement pstmt = conn.prepareStatement(sql);
			
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1,id);
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					return 1;
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			return 0;
		}
	
}	