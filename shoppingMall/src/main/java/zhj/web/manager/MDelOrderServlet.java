package zhj.web.manager;

import zhj.service.GoodsService;
import zhj.service.impl.GoodsServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 管理员删除订单
 */
@WebServlet("/mDelOrderServlet")
public class MDelOrderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String oid = request.getParameter("oid");
        GoodsService service = new GoodsServiceImpl();
        service.deleteOrder(oid);
        response.sendRedirect("/mFindAllOrderServlet");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
