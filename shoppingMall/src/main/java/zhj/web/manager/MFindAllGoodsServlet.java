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
import java.util.List;

/**
 * 管理端查询所有商品
 */
@WebServlet("/mFindAllGoodsServlet")
public class MFindAllGoodsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        GoodsService service = new GoodsServiceImpl();
        List<Goods> goods = service.findAll();
        request.setAttribute("goods",goods);
        request.getRequestDispatcher("/MGoodsIndex.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
