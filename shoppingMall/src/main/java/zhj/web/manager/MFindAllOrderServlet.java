package zhj.web.manager;

import zhj.domain.Orders;
import zhj.service.GoodsService;
import zhj.service.impl.GoodsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 管理端查询所有订单
 */
@WebServlet("/mFindAllOrderServlet")
public class MFindAllOrderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        GoodsService service = new GoodsServiceImpl();
        List<Orders> orders = service.findAllOrder();
        request.setAttribute("orders",orders);
        request.getRequestDispatcher("/MOrderIndex.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
