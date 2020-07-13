package zhj.web.servlet;

import zhj.domain.Goods;
import zhj.domain.User;
import zhj.service.GoodsService;
import zhj.service.impl.GoodsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * 用户购买商品
 */
@WebServlet("/buyServlet")
public class BuyServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String gid = request.getParameter("id");
        String count = request.getParameter("count");
        GoodsService service = new GoodsServiceImpl();
        Goods item = service.findById(gid);
        request.setAttribute("item",item);
        request.setAttribute("count",count);
        request.getRequestDispatcher("/buy.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
