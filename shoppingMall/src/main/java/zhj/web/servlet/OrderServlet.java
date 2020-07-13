package zhj.web.servlet;

import zhj.domain.Goods;
import zhj.domain.Orders;
import zhj.domain.User;
import zhj.service.GoodsService;
import zhj.service.impl.GoodsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * 获取用户的订单页
 */
@WebServlet("/orderServlet")
public class OrderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        int uid = user.getUid();
        GoodsService service = new GoodsServiceImpl();
        Map<Orders, Goods> orderMap = service.findOrder(uid);
        request.setAttribute("orderMap",orderMap);
        request.getRequestDispatcher("/order.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
