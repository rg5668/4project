package model;

import javax.swing.Action;

public abstract class GoodsListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) 
			throws Exception {
		System.out.println("M : GoodsListAction의 execute() 호출");
		//한글처리
		request.setCharacterEncoding("UTF-8");
		
		//카테고리별로 데이터 출력을 위한 카테고리파라미터값저장
		String item = request.getParameter("item");
		System.out.println("카테고리 : "+item);
		if(item == null){
			item = "all";
		}
		
		//GoodsDAO객체 생성 후 getGoodsList()생성
		GoodsDAO gdao = new GoodsDAO();
		//List<GoodsDTO> goodsList = gdao.GoodsListAll(); //전체상품 가져오기
		List<GoodsDTO> goodsList = gdao.GoodsList(item); //카테고리별 전체상품가져오기
				
		//등록된 상품 목록 전부 가져오기
		System.out.println("M : "+goodsList);
		
		//requset영역에 저장
		request.setAttribute("goodsList", goodsList);
		
		//goods_list.jsp 페이지이동(뷰페이지로이동)
		ActionForward forward = new ActionForward();
		forward.setPath("./goods/goods_list.jsp");
		forward.setRedirect(false);		
		return forward;
	}

}
