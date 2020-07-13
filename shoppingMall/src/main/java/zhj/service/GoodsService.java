package zhj.service;

import zhj.domain.Goods;
import zhj.domain.Orders;

import java.util.List;
import java.util.Map;

public interface GoodsService {
    //查询所有商品
    List<Goods> findAll();

    //根据商品类型查询商品
    List<Goods> findByType(String type);

    //根据名称搜索商品
    List<Goods> findByName(String search);

    //根据商品ID查询商品
    Goods findById(String id);

    //加入购物车
    void addCar(int uid, int gid);

    //根据用户ID查询指定用户的购物车和商品数量
    Map<Goods, Integer> findCarById(int uid);

    //删除指定用户购物车的指定商品
    void deleteCar(int uid, int gid);

    //更新指定用户购物车的指定商品
    void updateCar(int uid, String gid, String count);

    //根据用户ID查询指定用户的订单和商品
    Map<Orders,Goods> findOrder(int uid);

    //用户购买生成订单
    Boolean addOrder(Orders order);

    //删除指定订单ID的订单
    void deleteOrder(String oid);

    //查询所有订单
    List<Orders> findAllOrder();

    //管理员添加订单
    void MaddOrder(Orders orders);

    //根据订单ID查询订单
    Orders findOrderById(int oid);

    //更新订单
    void updateOrder(Orders orders);

    //根据商品ID删除商品
    void deleteGoods(int gid);

    //添加商品
    void addGoods(Goods goods);

    //更新商品
    void updateGoods(Goods goods);
}
