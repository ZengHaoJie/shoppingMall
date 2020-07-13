package zhj.dao.impl;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import zhj.dao.UserDao;
import zhj.domain.User;
import zhj.util.JDBCUtil;

import java.util.List;

public class UserDaoImpl implements UserDao {
    //创建JdbcTemplate对象来操作数据库
    private JdbcTemplate template = new JdbcTemplate(JDBCUtil.getDataSource());

    //用户登录
    @Override
    public User login(String username, String password) {
        User user = null;
        String sql = "select * from user where username = ? and password = ?";
        try {
            user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), username, password);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return user;
    }

    //保存用户
    @Override
    public void saveUser(User user) {
        String sql = "insert into user (username,password,gender,phone,address) values(?,?,?,?,?)";
        template.update(sql,user.getUsername(),user.getPassword(),user.getGender(),user.getPhone(),user.getAddress());
    }

    //根据用户名查询用户是否存在
    @Override
    public boolean findByName(String username) {
        String sql = "select count(*) from user where username = ?";
        Integer count = template.queryForObject(sql, Integer.class, username);
        if (count == 0){
            return false;
        }else {
            return true;
        }
    }

    //更新用户
    @Override
    public void updateUser(User user) {
        String sql = "update user set username = ?,password = ?,manage = ?,gender = ?,phone = ?,address = ? where uid = ?";
        template.update(sql,user.getUsername(),user.getPassword(),user.getManage(),user.getGender(),user.getPhone(),user.getAddress(),user.getUid());
    }

    //查询所有用户
    @Override
    public List<User> findAllUser() {
        List<User> users = null;
        String sql = "select * from user";
        users = template.query(sql,new BeanPropertyRowMapper<User>(User.class));
        return users;
    }

    //根据用户id删除用户
    @Override
    public void deleteUser(String uid) {
        String sql = "delete from user where uid = ?";
        template.update(sql,uid);
    }

    //根据用户ID查询用户
    @Override
    public User findById(int uid) {
        String sql = "select * from user where uid = ?";
        return template.queryForObject(sql,new BeanPropertyRowMapper<User>(User.class),uid);
    }
}
