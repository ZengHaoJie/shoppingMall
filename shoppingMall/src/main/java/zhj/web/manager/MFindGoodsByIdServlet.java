package zhj.web.manager;

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
 * 管理端查询指定ID的商品
 */
@WebServlet("/mFindGoodsByIdServlet")
public class MFindGoodsByIdServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String gid = request.getParameter("gid");
        GoodsService service = new GoodsServiceImpl();
        Goods goods = service.findById(gid);
        request.setAttribute("goods",goods);
        request.getRequestDispatcher("/MupdateGoods.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
