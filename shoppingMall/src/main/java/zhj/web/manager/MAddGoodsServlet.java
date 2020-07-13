package zhj.web.manager;

import org.apache.commons.beanutils.BeanUtils;
import zhj.domain.Goods;
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
 * 管理员添加商品
 */
@WebServlet("/mAddGoodsServlet")
public class MAddGoodsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        Map map = request.getParameterMap();
        Goods goods = new Goods();
        try {
            BeanUtils.populate(goods,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        GoodsService service = new GoodsServiceImpl();
        service.addGoods(goods);
        response.sendRedirect("/mFindAllGoodsServlet");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
