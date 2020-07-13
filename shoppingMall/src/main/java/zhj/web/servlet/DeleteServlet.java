package zhj.web.servlet;

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
 * 用户删除购物车
 */
@WebServlet("/deleteServlet")
public class DeleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String gid = request.getParameter("id");
        User user = (User) request.getSession().getAttribute("user");
        int uid = user.getUid();
        GoodsService service = new GoodsServiceImpl();
        service.deleteCar(uid,Integer.parseInt(gid));
        request.getRequestDispatcher("/carServlet").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
