package dao;

public class GoodsDAO {
	public List<GoodsDTO> GoodsList(String item) {
		List<GoodsDTO> goodsList = new ArrayList<GoodsDTO>();
		//item�� ���� ���������� �޶�����. �Һ��������� String��� ���� StringBuffer�� ���
		StringBuffer SQL = new StringBuffer();

		try {
			getCon();
			SQL.append("select * from itwill_goods"); //item�� null�ΰ��

			if(item.equals("all")){
			}else if(item.equals("best")){
				SQL.append(" where best=?");
			}else{
				SQL.append(" where category=?");
			}

			//�Ʒ� ������ ������� StringBuffer�� string���� ��Ÿ�����ִ�
			pstmt = con.prepareStatement(SQL.toString());
			//pstmt = con.prepareStatement(SQL+"");
			//pstmt = con.prepareStatement(String.valueOf(SQL)); //object�� ��Ƽ� �ű⼭ string���� ������

			if(item.equals("all")){
			}else if(item.equals("best")){
				pstmt.setInt(1, 1); //DB���̺���� best���� 1�� ��Ҹ� ���
			}else{
				pstmt.setString(1, item);
			}

			rs = pstmt.executeQuery();
			while(rs.next()){
				GoodsDTO gdto = new GoodsDTO();
				gdto.setGno(rs.getInt("gno"));
				gdto.setCategory(rs.getString("category"));
				gdto.setName(rs.getString("name"));
				gdto.setPrice(rs.getInt("price"));
				gdto.setColor(rs.getString("color"));

				gdto.setAmount(rs.getInt("amount"));
				gdto.setSize(rs.getString("size"));
				gdto.setContent(rs.getString("content"));
				gdto.setImage(rs.getString("image"));
				gdto.setBest(rs.getInt("best"));

				gdto.setDate(rs.getDate("date"));

				goodsList.add(gdto);								
			}
			System.out.println("DAO : ��ǰ��� ��� ����Ϸ�! "+goodsList);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeDB();
		}
		return goodsList;	
	}
}
