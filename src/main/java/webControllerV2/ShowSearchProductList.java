package webControllerV2;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductDAO;
import vo.ProductVO;

public class ShowSearchProductList implements Action{
	private ProductDAO prodDao = ProductDAO.getInstance();

	@Override
	public MyView execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String keyword = request.getParameter("keyword");
		List<ProductVO> list = prodDao.getProductListByKeyWord(keyword);
		request.setAttribute("list", list);
		return new MyView("search_product_list");
	}
	
	

}
