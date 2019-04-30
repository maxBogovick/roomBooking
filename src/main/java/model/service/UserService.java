package model.service;

import model.dao.DaoFactory;
import model.dao.UserDao;
import model.entity.User;

public interface UserService {

    User login(String name);

    void singUp(User user);
}
