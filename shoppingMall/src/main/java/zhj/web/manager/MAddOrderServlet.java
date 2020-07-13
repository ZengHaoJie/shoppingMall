package zhj.web.manager;

import org.apache.commons.beanutils.BeanUtils;
import zhj.domain.Orders;
import zhj.service.GoodsService;
import zhj.service.impl.GoodsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * 管理员添加订单
 */
@WebServlet("/mAddOrderServlet")
public class MAddOrderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map map = request.getParameterMap();
        Orders orders = new Orders();
        try {
            BeanUtils.populate(orders,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        GoodsService service = new GoodsServiceImpl();
        service.MaddOrder(orders);
        response.sendRedirect("/mFindAllOrderServlet");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
