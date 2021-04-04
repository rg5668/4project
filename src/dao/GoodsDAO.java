package dao;

public class GoodsDAO {
	public List<GoodsDTO> GoodsList(String item) {
		List<GoodsDTO> goodsList = new ArrayList<GoodsDTO>();
		//item에 따라 쿼리구문이 달라진다. 불변성때문에 String대신 따라서 StringBuffer를 사용
		StringBuffer SQL = new StringBuffer();

		try {
			getCon();
			SQL.append("select * from itwill_goods"); //item가 null인경우

			if(item.equals("all")){
			}else if(item.equals("best")){
				SQL.append(" where best=?");
			}else{
				SQL.append(" where category=?");
			}

			//아래 세가지 방법으로 StringBuffer를 string으로 나타낼수있다
			pstmt = con.prepareStatement(SQL.toString());
			//pstmt = con.prepareStatement(SQL+"");
			//pstmt = con.prepareStatement(String.valueOf(SQL)); //object에 담아서 거기서 string으로 꺼낸다

			if(item.equals("all")){
			}else if(item.equals("best")){
				pstmt.setInt(1, 1); //DB테이블안의 best값이 1인 요소만 출력
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
			System.out.println("DAO : 상품목록 모두 저장완료! "+goodsList);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeDB();
		}
		return goodsList;	
	}
}
