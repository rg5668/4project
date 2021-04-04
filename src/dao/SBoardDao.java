package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import model.Member;
import model.SBoard;

public class SBoardDao {
	public boolean insert(SBoard board) {
		Connection conn = DBConnection.getConnection();

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int num = 0;
		String sql1 = "select serbSeq.nextval from dual";
		String sql2 = "insert into serviceboard4 (num,id,name,subject,category,content,file1,"
				+ " regdate,readcnt, ref, reflevel, refstep) "
				+ " values (?,?,?,?,?,?,?,sysdate,0,?,?,?)";
		System.out.println(sql2);

		int ref = 0, reflevel=0, refstep=0;
		try {
			pstmt = conn.prepareStatement(sql1);
			rs= pstmt.executeQuery();
			if(rs.next()) num = rs.getInt(1);
			
			if(board.getNum()>0) {
				ref = board.getRef();
				reflevel = board.getReflevel()+1;
				refstep = board.getRefstep()+1;
			} else {
				ref = num;
			}
			pstmt = conn.prepareStatement(sql2);
			pstmt.setInt(1, num);
			pstmt.setString(2, board.getId());
			pstmt.setString(3, board.getName());
			pstmt.setString(4, board.getSubject());
			pstmt.setString(5, board.getCategory());
			pstmt.setString(6, board.getContent());
			pstmt.setString(7, board.getFile1());
			pstmt.setInt(8, ref);			
			pstmt.setInt(9, reflevel);
			pstmt.setInt(10, refstep);
			pstmt.executeUpdate();
			return true;
		} catch(SQLException e)	{
			e.printStackTrace();
		} finally {
			DBConnection.close(conn, pstmt, null);
		}
		return false;
	}
	
	public void refstepadd(int ref, int refstep) {
		Connection conn = DBConnection.getConnection();
		PreparedStatement pstmt = null;
		String sql = "update serviceboard4 set refstep = refstep + 1" + 
					" where ref = ? and refstep > ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, ref);
			pstmt.setInt(2, refstep);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally { 
			DBConnection.close(conn, pstmt, null);
			}
	}	
	public int boardCount() {
		Connection conn = DBConnection.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement("select count(*) from serviceboard4");
			rs = pstmt.executeQuery();
			rs.next();
			return rs.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConnection.close(conn,pstmt,rs);
		} 
		return 0;
	}
	public List<SBoard> list(int pageNum, int limit, int boardcount) {
		Connection conn = DBConnection.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<SBoard> list = new ArrayList<SBoard>();
		int start = (pageNum-1)*limit+1;
		int end = start + limit -1;
		String sql = "select * from (select rownum rnum ,a.* "
				+ " from (select * from serviceboard4 order by ref desc , "
				+ "refstep) a ) where rnum between ? and ?";
		System.out.println(sql);
		try { 
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			System.out.println(start+":"+end);
			rs= pstmt.executeQuery();
			while(rs.next()) {
				SBoard b = new SBoard();
				b.setNum(rs.getInt("num"));
				b.setName(rs.getString("name"));
				b.setCategory(rs.getString("category"));
				b.setSubject(rs.getString("subject"));
				b.setContent(rs.getString("content"));
				b.setFile1(rs.getString("file1"));
				b.setRef(rs.getInt("ref"));
				b.setReflevel(rs.getInt("reflevel"));
				b.setRefstep(rs.getInt("refstep"));
				b.setReadcnt(rs.getInt("readcnt"));
				b.setRegdate(rs.getTimestamp("regdate"));
				list.add(b);		
			} return list;
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(conn, pstmt, rs);
		} return null;
	}
	
	
	public SBoard selectOne(int num) {
		Connection conn = DBConnection.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from serviceboard4 where num = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				SBoard b = new SBoard();
				b.setNum(rs.getInt("num"));
				b.setName(rs.getString("name"));
				b.setSubject(rs.getString("subject"));
				b.setCategory(rs.getString("category"));
				b.setContent(rs.getString("content"));
				b.setFile1(rs.getString("file1"));
				b.setRef(rs.getInt("ref"));
				b.setReflevel(rs.getInt("reflevel"));
				b.setRefstep(rs.getInt("refstep"));
				b.setReadcnt(rs.getInt("readcnt"));
				b.setRegdate(rs.getTimestamp("regdate"));
				return b;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConnection.close(conn, pstmt, rs);
		} 
		return null;
	}
	
	public void readcntadd(int num) {
		Connection conn = DBConnection.getConnection();
		PreparedStatement pstmt = null;
		String sql = "update serviceboard4 set readcnt = readcnt + 1" +" where num = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally { 
			DBConnection.close(conn, pstmt, null);
		} 
	}
	
	public boolean update(SBoard board) {
		Connection conn = DBConnection.getConnection();
		PreparedStatement pstmt = null;
		String sql = "update serviceboard4 set name=?, subject=?, category=?, content=?,"
				+ "file1=? where num=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board.getName());
			pstmt.setString(2, board.getSubject());
			pstmt.setString(3, board.getCategory());
			pstmt.setString(4, board.getContent());
			pstmt.setString(5, board.getFile1());
			pstmt.setInt(6, board.getNum());
			pstmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConnection.close(conn, pstmt, null);
		}
		return false;
	}
	
	public boolean delete(int num) {
		Connection conn = DBConnection.getConnection();
		PreparedStatement pstmt = null;
		String sql = "delete from serviceboard4 where num=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConnection.close(conn, pstmt, null);
		}
		return false;
	}
	
	
}
