package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import model.Buy;
import model.Member;
import model.Product4;
import model.Productinfo;

public class BuyDao 
{
	public Productinfo select(Product4 pro)
	{
		Connection conn=DBConnection.getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		String sql="select pimg,pname,price,pcontent,pcode from PRODUCT4 where pcode=?";
		
		try
		{
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,pro.getPcode());
			rs=pstmt.executeQuery();
			if(rs.next())
			{
				Productinfo p=new Productinfo();
				p.setPimg(rs.getString("pimg"));
				p.setPname(rs.getString("pname"));
				p.setPrice(rs.getString("price"));
				p.setPcontent(rs.getString("pcontent"));
				p.setPcode(rs.getString("pcode"));
				return p;
			}
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			DBConnection.close(conn, pstmt, rs);
		}
		return null;
	}
	
	public boolean delete(Buy buy,Member mem)
	{
		Connection conn=DBConnection.getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		String sql="delete from buy4 where pnum=? and id=?";
		
		try
		{
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,buy.getPnum());
			pstmt.setString(2,mem.getId());
			rs=pstmt.executeQuery();
			return true;
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			DBConnection.close(conn, pstmt, rs);
		}
		return false;
	}
	
	public int insert(Member mem,Product4 pro)
	{
		String i="0";
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/ MM / dd ");
		String datestr = sdf.format(cal.getTime());
		sdf = new SimpleDateFormat("mm:ss");
		String intStr = sdf.format(cal.getTime());
		intStr+=pro.getPcode()+i;
		intStr=intStr.replaceAll("[^0-9]", "");
		
		
		
		Connection conn=DBConnection.getConnection();
		PreparedStatement pstmt=null;
		String sql="insert into buy4"
		+"(id,pnum,pdate,pcode)"
		+"values(?,?,?,?)";
		try
		{
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, mem.getId());
			pstmt.setString(2,intStr);
			pstmt.setString(3, datestr);
			pstmt.setString(4, pro.getPcode());
			return pstmt.executeUpdate();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			
			DBConnection.close(conn, pstmt, null);
		}
		return 0;
	}
	
	public List<Buy> list(String id)
	{
		Connection conn=DBConnection.getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		List<Buy> list=new ArrayList<Buy>();
		String sql="select b.pnum,b.pdate,p.pname,p.price,p.pcontent,p.pimg,p.pcode "
				+ "from buy4 b join product4 p on(b.PCODE=p.PCODE) "
				+ "where b.id=?";
		
		try
		{
			rs=null;
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			while(rs.next())
			{
				Buy b=new Buy();
				b.setPnum(rs.getString("pnum"));
				b.setPdate(rs.getString("pdate"));
				b.setPname(rs.getString("pname"));
				b.setPrice(rs.getString("price"));
				b.setPcontent(rs.getString("pcontent"));
				b.setPimg(rs.getString("pimg"));
				b.setPcode(rs.getString("pcode"));
				b.setId(id);
				list.add(b);
			}
			return list;
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			DBConnection.close(conn, pstmt, rs);
		}
		return null;
	}
}
