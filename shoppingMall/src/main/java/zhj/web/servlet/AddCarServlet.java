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
 * 添加购物车
 */
@WebServlet("/addCarServlet")
public class AddCarServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String gid = request.getParameter("id");
        User user = (User) request.getSession().getAttribute("user");
        int uid = user.getUid();
        GoodsService service = new GoodsServiceImpl();
        service.addCar(uid, Integer.parseInt(gid));
        request.setAttribute("car_msg","添加购物车成功");
        Goods item = service.findById(gid);
        request.setAttribute("item",item);
        request.getRequestDispatcher("/info.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
