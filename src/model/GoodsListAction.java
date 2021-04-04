package model;

import javax.swing.Action;

public abstract class GoodsListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) 
			throws Exception {
		System.out.println("M : GoodsListAction�� execute() ȣ��");
		//�ѱ�ó��
		request.setCharacterEncoding("UTF-8");
		
		//ī�װ����� ������ ����� ���� ī�װ��Ķ���Ͱ�����
		String item = request.getParameter("item");
		System.out.println("ī�װ� : "+item);
		if(item == null){
			item = "all";
		}
		
		//GoodsDAO��ü ���� �� getGoodsList()����
		GoodsDAO gdao = new GoodsDAO();
		//List<GoodsDTO> goodsList = gdao.GoodsListAll(); //��ü��ǰ ��������
		List<GoodsDTO> goodsList = gdao.GoodsList(item); //ī�װ��� ��ü��ǰ��������
				
		//��ϵ� ��ǰ ��� ���� ��������
		System.out.println("M : "+goodsList);
		
		//requset������ ����
		request.setAttribute("goodsList", goodsList);
		
		//goods_list.jsp �������̵�(�����������̵�)
		ActionForward forward = new ActionForward();
		forward.setPath("./goods/goods_list.jsp");
		forward.setRedirect(false);		
		return forward;
	}

}
