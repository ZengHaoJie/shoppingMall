package zhj.web.servlet;

import zhj.domain.Goods;
import zhj.service.GoodsService;
import zhj.service.impl.GoodsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 商品详情
 */
@WebServlet("/goodsInfoServlet")
public class GoodsInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        GoodsService service = new GoodsServiceImpl();
        Goods item = service.findById(id);
        request.setAttribute("item",item);
        request.getRequestDispatcher("/info.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
