package zhj.service;

import zhj.domain.User;

import java.util.List;

public interface UserService {
    //用户登录
    User login(String username,String password);

    //保存用户
    void saveUser(User user);

    //根据用户名查询用户是否存在
    boolean findByName(String username);

    //更新用户
    void updateUser(User user);

    //查询所有用户
    List<User> findAllUser();

    //根据用户id删除用户
    void deleteUser(String uid);

    //根据用户ID查询用户
    User findById(String uid);
}
