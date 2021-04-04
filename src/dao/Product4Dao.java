package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Buy;
import model.Member;
import model.Product4;
import model.Productinfo;
import model.SBoard;

public class Product4Dao {
	
	public List<Product4> list() {
		Connection conn = DBConnection.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Product4> li = new ArrayList<Product4>();
		String sql = "select * from product4";
	
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Product4 p = new Product4();
				p.setPcode(rs.getString("pcode"));
				p.setPname(rs.getString("pname"));
				p.setPrice(rs.getInt("price"));
				p.setPcount(rs.getInt("pcount"));
				p.setPimg(rs.getString("pimg"));
				p.setPcontent(rs.getString("pcontent"));
				p.setSubpcode(rs.getString("subpcode"));
				
				li.add(p);
			}
			return li;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(conn, pstmt, rs);
		}
		return null;	
	}
	
	public List<Product4> slelect(String subpcode) {
		Connection conn = DBConnection.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Product4> li = new ArrayList<Product4>();
		String sql = "  select *"
				+ " from product4 a, category4 b"
				+ " where a.subpcode = b.SUBPCODE and a.SUBPCODE = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, subpcode);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Product4 p = new Product4();
				p.setPcode(rs.getString("pcode"));
				p.setPname(rs.getString("pname"));
				p.setPrice(rs.getInt("price"));
				p.setPcount(rs.getInt("pcount"));
				p.setPimg(rs.getString("pimg"));
				p.setPcontent(rs.getString("pcontent"));
				p.setSubpcode(rs.getString("subpcode"));
				
				li.add(p);
				
			}
			return li;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(conn, pstmt, rs);
		}
		return null;	
	}
	
	public int insert(Product4 pro) {
	      Connection conn = DBConnection.getConnection();
	      PreparedStatement pstmt = null;
	      System.out.println(pro);
	      int rowCount = 0;
	      String sql = "insert into product4 (pcode,pname,price,pcount,pimg,pcontent,subpcode)"
	            + " values (?,?,?,?,?,?,?)";   

	      try {
	         pstmt = conn.prepareStatement(sql);
	         
	         pstmt.setString(1, pro.getPcode());
	         pstmt.setString(2, pro.getPname());
	         pstmt.setInt(3, pro.getPrice());
	         pstmt.setInt(4, pro.getPcount());
	         pstmt.setString(5, pro.getPimg());
	         pstmt.setString(6, pro.getPcontent());
	         pstmt.setString(7, pro.getSubpcode());
	         
	         rowCount = pstmt.executeUpdate();
	      } catch(SQLException e)   {
	         e.printStackTrace();
	      } finally {
	         DBConnection.close(conn, pstmt, null);
	      }
	      return rowCount;
	   }
	
	public Product4 selectOne(String pcode) {
		Connection conn = DBConnection.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from product4 where pcode = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pcode);
			
			rs = pstmt.executeQuery();	// *를 받아낸다.
			
			if(rs.next()) {
				Product4 p = new Product4();
				p.setPcode(rs.getString("pcode"));
				p.setPname(rs.getString("pname"));
				p.setPrice(rs.getInt("price"));
				p.setPcount(rs.getInt("pcount"));
				p.setPimg(rs.getString("pimg"));
				p.setPcontent(rs.getString("pcontent"));
				p.setSubpcode(rs.getString("subpcode"));
				return p;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConnection.close(conn, pstmt, rs);
		}
		return null;
	}
	
	public boolean update(Product4 pcode) {
		Connection conn = DBConnection.getConnection();
		PreparedStatement pstmt = null;
		
		String sql = "update product4 set pname=?, price=?,"
				+ " pcount=?, pimg=?, pcontent=?, subpcode=? where pcode=?";

		try {
			pstmt = conn.prepareStatement(sql);
			
	         pstmt.setString(1, pcode.getPname());
	         pstmt.setInt(2, pcode.getPrice());
	         pstmt.setInt(3, pcode.getPcount());
	         pstmt.setString(4, pcode.getPimg());
	         pstmt.setString(5, pcode.getPcontent());
	         pstmt.setString(6, pcode.getSubpcode());
	        
	         pstmt.setString(7, pcode.getPcode());
			
	         pstmt.executeUpdate();
				
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(conn, pstmt, null);
		}
		return false;
	}
	
	public boolean delete(Product4 pcode) {
		Connection conn = DBConnection.getConnection();
		PreparedStatement pstmt = null;
		String sql = "delete from product4 where pcode=?";
		try {
			pstmt = conn.prepareStatement(sql);
			
	        
	        
	         pstmt.setString(1, pcode.getPcode());
			
	         pstmt.executeUpdate();
				
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(conn, pstmt, null);
		}
		return false;
	}
	
	public List<Product4> select(String search) {
	      Connection conn = DBConnection.getConnection();
	      PreparedStatement pstmt = null;
	      ResultSet rs = null;
	      List<Product4> li = new ArrayList<Product4>();
	      String sql = "select *"
	            + " from product4"
	            + " where pcontent like ? or pname like ?";
	      
	      try {
	         pstmt = conn.prepareStatement(sql);
	         pstmt.setString(1, "%"+search+"%");
	         pstmt.setString(2, "%"+search+"%");
	         rs = pstmt.executeQuery();
	         
	         while(rs.next()) {
	            Product4 p = new Product4();
	            p.setPcode(rs.getString("pcode"));
	            p.setPname(rs.getString("pname"));
	            p.setPrice(rs.getInt("price"));
	            p.setPcount(rs.getInt("pcount"));
	            p.setPimg(rs.getString("pimg"));
	            p.setPcontent(rs.getString("pcontent"));
	            p.setSubpcode(rs.getString("subpcode"));
	            
	            li.add(p);
	            
	         }
	         return li;
	      } catch (Exception e) {
	         e.printStackTrace();
	      } finally {
	         DBConnection.close(conn, pstmt, rs);
	      }
	      return null;   
	   }
}
