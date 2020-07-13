package zhj.service.impl;

import zhj.dao.GoodsDao;
import zhj.dao.impl.GoodsDaoImpl;
import zhj.domain.Car;
import zhj.domain.Goods;
import zhj.domain.Orders;
import zhj.service.GoodsService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GoodsServiceImpl implements GoodsService {
    private GoodsDao goodsDao = new GoodsDaoImpl();

    //查询所有商品
    @Override
    public List<Goods> findAll() {
        return goodsDao.findAll();
    }

    //根据商品类型查询商品
    @Override
    public List<Goods> findByType(String type) {
        return goodsDao.findByTye(type);
    }

    //根据名称搜索商品
    @Override
    public List<Goods> findByName(String search) {
        return goodsDao.findByName(search);
    }

    //根据商品ID查询商品
    @Override
    public Goods findById(String id) {
        return goodsDao.findById(Integer.parseInt(id));
    }

    //加入购物车
    @Override
    public void addCar(int uid, int gid) {
        int count = goodsDao.findCount(uid, gid);
        if (count == 0){
            goodsDao.addCar(uid, gid);
        }else {
            count = count + 1;
            goodsDao.updateCount(uid,gid,count);
        }
    }

    //根据用户ID查询指定用户的购物车和商品数量
    @Override
    public Map<Goods, Integer> findCarById(int uid) {
        Map<Goods,Integer> map = new HashMap<>();
        List<Car> list = goodsDao.findCarById(uid);
        if (list.size() > 0){
            for (Car car : list) {
                int gid = car.getGid();
                Goods goods = goodsDao.findById(gid);
                map.put(goods,car.getCount());
            }
        }
        return map;
    }

    //删除指定用户购物车的指定商品
    @Override
    public void deleteCar(int uid, int gid) {
        goodsDao.deleteCar(uid,gid);
    }

    //更新指定用户购物车的指定商品
    @Override
    public void updateCar(int uid, String gid, String count) {
        goodsDao.updateCount(uid,Integer.parseInt(gid),Integer.parseInt(count));
    }

    //根据用户ID查询指定用户的订单和商品
    @Override
    public Map<Orders,Goods> findOrder(int uid) {
        Map<Orders,Goods> map = new HashMap<>();
        List<Orders> orders = goodsDao.findOrder(uid);
        for (Orders order : orders) {
            Goods goods = goodsDao.findById(order.getGid());
            map.put(order,goods);
        }
        return map;
    }

    //用户购买生成订单
    @Override
    public Boolean addOrder(Orders order) {
        int goodsCount = goodsDao.findGoodsCount(order.getGid());
        int num = order.getNum();
        if (goodsCount >= num){
            goodsDao.addOrder(order);
            goodsDao.subCount(goodsCount-num,order.getGid());
            goodsDao.deleteCar(order.getUid(),order.getGid());
            return true;
        }else {
            return false;
        }
    }

    //删除指定订单ID的订单
    @Override
    public void deleteOrder(String oid) {
        goodsDao.deleteOrder(oid);
    }

    //查询所有订单
    @Override
    public List<Orders> findAllOrder() {
        return goodsDao.findAllOrder();
    }

    //管理员添加订单
    @Override
    public void MaddOrder(Orders orders) {
        int gid = orders.getGid();
        Goods goods = goodsDao.findById(gid);
        double price = goods.getPrice();
        int num = orders.getNum();
        double money = num * price;
        orders.setMoney(money);
        goodsDao.addOrder(orders);
    }

    //根据订单ID查询订单
    @Override
    public Orders findOrderById(int oid) {
        return goodsDao.findOrderById(oid);
    }

    //更新订单
    @Override
    public void updateOrder(Orders orders) {
        int gid = orders.getGid();
        Goods goods = goodsDao.findById(gid);
        double price = goods.getPrice();
        int num = orders.getNum();
        double money = num * price;
        orders.setMoney(money);
        goodsDao.updateOrder(orders);
    }

    //根据商品ID删除商品
    @Override
    public void deleteGoods(int gid) {
        goodsDao.deleteGoods(gid);
    }

    //添加商品
    @Override
    public void addGoods(Goods goods) {
        goodsDao.addGoods(goods);
    }

    //更新商品
    @Override
    public void updateGoods(Goods goods) {
        goodsDao.updateGoods(goods);
    }
}
