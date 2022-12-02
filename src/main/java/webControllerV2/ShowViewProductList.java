package webControllerV2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductDAO;
import util.CookieUtil;
import vo.ProductVO;


public class ShowViewProductList implements Action{
	private ProductDAO prodDao = ProductDAO.getInstance();

	@Override
	public MyView execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String value = CookieUtil.getCookie(request, response, "viewProds");
		List<ProductVO> list = new ArrayList<>();
		if(value!= null) {
			String[] arr =  value.split("-");
			for(int i =arr.length-1;i>=0;i--) {
				System.out.println(arr[i]);
				ProductVO vo = prodDao.getProduct(Integer.parseInt(arr[i]));
				if(vo != null)
				list.add(vo);
			}
		}
		request.setAttribute("prods", list);
		return new MyView("view_product_list");
	}

	
	
	

}
