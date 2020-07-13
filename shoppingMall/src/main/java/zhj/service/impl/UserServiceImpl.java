package zhj.service.impl;

import zhj.dao.UserDao;
import zhj.dao.impl.UserDaoImpl;
import zhj.domain.User;
import zhj.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDao dao = new UserDaoImpl();

    //用户登录
    @Override
    public User login(String username, String password) {
        return dao.login(username, password);
    }

    //保存用户
    @Override
    public void saveUser(User user) {
        dao.saveUser(user);
    }

    //根据用户名查询用户是否存在
    @Override
    public boolean findByName(String username) {
        return dao.findByName(username);
    }

    //更新用户
    @Override
    public void updateUser(User user) {
        dao.updateUser(user);
    }

    //查询所有用户
    @Override
    public List<User> findAllUser() {
        return dao.findAllUser();
    }

    //根据用户id删除用户
    @Override
    public void deleteUser(String uid) {
        dao.deleteUser(uid);
    }

    //根据用户ID查询用户
    @Override
    public User findById(String uid) {
        return dao.findById(Integer.parseInt(uid));
    }
}
