package zhj.web.manager;

import zhj.service.GoodsService;
import zhj.service.impl.GoodsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 管理员删除商品
 */
@WebServlet("/mDelGoodsServlet")
public class MDelGoodsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String gid = request.getParameter("gid");
        GoodsService service = new GoodsServiceImpl();
        service.deleteGoods(Integer.parseInt(gid));
        response.sendRedirect("/mFindAllGoodsServlet");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
