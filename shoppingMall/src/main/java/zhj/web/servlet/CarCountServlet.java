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

/**
 * 更新购物车商品数量
 */
@WebServlet("/carCountServlet")
public class CarCountServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String count = request.getParameter("num");
        String gid = request.getParameter("gid");
        User user = (User) request.getSession().getAttribute("user");
        int uid = user.getUid();
        GoodsService service = new GoodsServiceImpl();
        service.updateCar(uid,gid,count);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
