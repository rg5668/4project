package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import model.Basket;
import model.Buy;
import model.Member;
import model.Product4;
import model.Productinfo;

public class BasketDao 
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
	
	public boolean delete(Member mem,int[] basket)
	{
		Connection conn=DBConnection.getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		String sql="delete from basket4 where bcount=?";
		
		try
		{
			for(int i=0;i<basket.length;i++)
			{
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1,basket[i]);
			rs=pstmt.executeQuery();
			}
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
	
	public int insert(Member mem,int[] basket)
	{
		Connection conn=DBConnection.getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql1="insert into buy4"
		+"(id,pnum,pdate,pcode)"
		+"values(?,?,?,?)";
		String sql2="select pcode from basket4 where bcount=?";
		try
		{
			
			
			for(int i=0;i<basket.length;i++)
			{
				pstmt=conn.prepareStatement(sql2);
				pstmt.setInt(1, basket[i]);
				rs=pstmt.executeQuery();
				while(rs.next())
				{
					Calendar cal = Calendar.getInstance();
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy/ MM / dd ");
					String datestr = sdf.format(cal.getTime());
					sdf = new SimpleDateFormat("mm:ss");
					String intStr = sdf.format(cal.getTime());
					intStr+=rs.getString("pcode")+i;
					intStr=intStr.replaceAll("[^0-9]", "");
					
					pstmt=conn.prepareStatement(sql1);
					pstmt.setString(1, mem.getId());
					pstmt.setString(2, intStr);
					pstmt.setString(3, datestr);
					pstmt.setString(4, rs.getString("pcode"));
					pstmt.executeUpdate();
				}
			}
			return 1;
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			
			DBConnection.close(conn, pstmt, rs);
		}
		return 0;
	}
	
	public int insert(Member mem,Product4 pro)
	{
		Connection conn=DBConnection.getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql1="insert into basket4"
		+"(id,pcode,bcount)"
		+"values(?,?,?)";
		String sql2="select basketseq.nextval from dual";
		int num=0;
		try
		{
			pstmt=conn.prepareStatement(sql2);
			rs=pstmt.executeQuery();
			if(rs.next())
				num=rs.getInt(1);
		
			pstmt=conn.prepareStatement(sql1);
			pstmt.setString(1, mem.getId());
			pstmt.setString(2, pro.getPcode());
			pstmt.setInt(3, num);
			return pstmt.executeUpdate();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			
			DBConnection.close(conn, pstmt, rs);
		}
		return 0;
	}
	
	public List<Basket> list(String id)
	{
		Connection conn=DBConnection.getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		List<Basket> list=new ArrayList<Basket>();
		String sql="select b.bcount,p.pname,p.pcode,p.price,p.pimg "
				+ "from basket4 b join product4 p on(b.PCODE=p.PCODE) "
				+ "where b.id=?";
		
		try
		{
			rs=null;
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			while(rs.next())
			{
				Basket b=new Basket();
				b.setPname(rs.getString("pname"));
				b.setPcode(rs.getString("pcode"));
				b.setPrice(rs.getString("price"));
				b.setBcount(rs.getInt("bcount"));
				b.setPimg(rs.getString("pimg"));
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
