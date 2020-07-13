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
import java.util.List;
import java.util.Map;

/**
 * 查询购物车
 */
@WebServlet("/carServlet")
public class CarServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        int uid = user.getUid();
        GoodsService service = new GoodsServiceImpl();
        Map<Goods,Integer> map = service.findCarById(uid);
        if (map.size() > 0){
            request.setAttribute("map",map);
        }else{
            request.setAttribute("null_msg","暂无添加购物车");
        }
        request.getRequestDispatcher("/car.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
