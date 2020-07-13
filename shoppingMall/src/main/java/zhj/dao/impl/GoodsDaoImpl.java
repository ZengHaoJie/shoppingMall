package zhj.dao.impl;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import zhj.dao.GoodsDao;
import zhj.domain.Car;
import zhj.domain.Goods;
import zhj.domain.Orders;
import zhj.util.JDBCUtil;

import java.util.List;

public class GoodsDaoImpl implements GoodsDao {
    //创建JdbcTemplate对象来操作数据库
    private JdbcTemplate template = new JdbcTemplate(JDBCUtil.getDataSource());

    //查询所有商品
    @Override
    public List<Goods> findAll() {
        String sql = "select * from goods";
        return template.query(sql,new BeanPropertyRowMapper<Goods>(Goods.class));
    }

    //根据商品类型查询商品
    @Override
    public List<Goods> findByTye(String type) {
        String sql = "select * from goods where type = ?";
        return template.query(sql,new BeanPropertyRowMapper<Goods>(Goods.class),type);
    }

    //根据名称搜索商品
    @Override
    public List<Goods> findByName(String search) {
        String sql = "select * from goods where gname like ?";
        search = "%" + search + "%";
        return template.query(sql,new BeanPropertyRowMapper<Goods>(Goods.class),search);
    }

    //根据商品ID查询商品
    @Override
    public Goods findById(int id) {
        String sql = "select * from goods where gid = ?";
        return template.queryForObject(sql,new BeanPropertyRowMapper<Goods>(Goods.class),id);
    }

    //加入购物车
    @Override
    public void addCar(int uid, int gid) {
        String sql = "insert into car (uid,count,gid) values(?,1,?)";
        template.update(sql,uid,gid);
    }

    //更新指定用户购物车指定商品的商品数量
    @Override
    public void updateCount(int uid, int gid, int count) {
        String sql = "update car set count = ? where uid = ? and gid = ?";
        template.update(sql,count,uid,gid);
    }

    //查询指定用户购物车指定商品的商品数量
    @Override
    public int findCount(int uid, int gid) {
        int num = 0;
        String sql = "select count from car where uid = ? and gid = ?";
        try {
            num = template.queryForObject(sql,Integer.class,uid,gid);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return num;
    }

    //更新指定商品的库存量
    @Override
    public void subCount(int count, int gid) {
        String sql = "update goods set count = ? where gid = ?";
        template.update(sql,count,gid);
    }

    //查询指定商品的库存量
    @Override
    public int findGoodsCount(int gid) {
        String sql = "select count from goods where gid = ?";
        return template.queryForObject(sql,Integer.class,gid);
    }

    //查询指定用户的购物车
    @Override
    public List<Car> findCarById(int uid) {
        String sql = "select * from car where uid = ?";
        return template.query(sql,new BeanPropertyRowMapper<Car>(Car.class),uid);
    }

    //删除指定用户购物车的指定商品
    @Override
    public void deleteCar(int uid, int gid) {
        String sql = "delete from car where uid = ? and gid = ?";
        template.update(sql,uid,gid);
    }

    //查询指定用户的订单
    @Override
    public List<Orders> findOrder(int uid) {
        String sql = "select * from orders where uid = ?";
        return template.query(sql,new BeanPropertyRowMapper<Orders>(Orders.class),uid);
    }

    //添加订单
    @Override
    public void addOrder(Orders order) {
        String sql = "insert into orders(uid,gid,num,money) values(?,?,?,?)";
        template.update(sql,order.getUid(),order.getGid(),order.getNum(),order.getMoney());
    }

    //删除订单
    @Override
    public void deleteOrder(String oid) {
        String sql = "delete from orders where oid = ?";
        template.update(sql,oid);
    }

    //查询所有订单
    @Override
    public List<Orders> findAllOrder() {
        String sql = "select * from orders";
        return template.query(sql,new BeanPropertyRowMapper<Orders>(Orders.class));
    }

    //根据订单ID查询订单
    @Override
    public Orders findOrderById(int oid) {
        String sql = "select * from orders where oid = ?";
        return template.queryForObject(sql,new BeanPropertyRowMapper<Orders>(Orders.class),oid);
    }

    //更新订单
    @Override
    public void updateOrder(Orders orders) {
        String sql = "update orders set uid = ?,gid = ?,num = ?,money = ? where oid = ?";
        template.update(sql,orders.getUid(),orders.getGid(),orders.getNum(),orders.getMoney(),orders.getOid());
    }

    //删除商品
    @Override
    public void deleteGoods(int gid) {
        String sql = "delete from goods where gid = ?";
        template.update(sql,gid);
    }

    //添加商品
    @Override
    public void addGoods(Goods goods) {
        String sql = "insert into goods(gname,price,type,count) values(?,?,?,?)";
        template.update(sql,goods.getGname(),goods.getPrice(),goods.getType(),goods.getCount());
    }

    //更新商品
    @Override
    public void updateGoods(Goods goods) {
        String sql = "update goods set gname = ?,price = ?,type = ?,count = ? where gid = ?";
        template.update(sql,goods.getGname(),goods.getPrice(),goods.getType(),goods.getCount(),goods.getGid());
    }

}
