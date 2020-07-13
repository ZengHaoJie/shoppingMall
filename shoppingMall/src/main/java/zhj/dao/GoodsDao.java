package zhj.dao;

import zhj.domain.Car;
import zhj.domain.Goods;
import zhj.domain.Orders;

import java.util.List;

public interface GoodsDao {
    //查询所有商品
    List<Goods> findAll();

    //根据商品类型查询商品
    List<Goods> findByTye(String type);

    //根据名称搜索商品
    List<Goods> findByName(String search);

    //根据商品ID查询商品
    Goods findById(int id);

    //加入购物车
    void addCar(int uid, int gid);

    //更新指定用户购物车指定商品的商品数量
    void updateCount(int uid, int gid, int count);

    //查询指定用户购物车指定商品的商品数量
    int findCount(int uid, int gid);

    //更新指定商品的库存量
    void subCount(int count, int gid);

    //查询指定商品的库存量
    int findGoodsCount(int gid);

    //查询指定用户的购物车
    List<Car> findCarById(int uid);

    //删除指定用户购物车的指定商品
    void deleteCar(int uid, int gid);

    //查询指定用户的订单
    List<Orders> findOrder(int uid);

    //添加订单
    void addOrder(Orders order);

    //删除订单
    void deleteOrder(String oid);

    //查询所有订单
    List<Orders> findAllOrder();

    //根据订单ID查询订单
    Orders findOrderById(int oid);

    //更新订单
    void updateOrder(Orders orders);

    //删除商品
    void deleteGoods(int gid);

    //添加商品
    void addGoods(Goods goods);

    //更新商品
    void updateGoods(Goods goods);
}
