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

/**
 * 管理端查询指定ID的订单
 */
@WebServlet("/mFindOrderByIdServlet")
public class MFindOrderByIdServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String oid = request.getParameter("oid");
        GoodsService service = new GoodsServiceImpl();
        Orders orders = service.findOrderById(Integer.parseInt(oid));
        request.setAttribute("orders",orders);
        request.getRequestDispatcher("/MupdateOrder.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
