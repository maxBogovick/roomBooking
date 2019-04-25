package model.service.impl;

import model.dao.DaoFactory;
import model.dao.UserDao;
import model.entity.User;

public class UserServiceImpl {
    DaoFactory daoFactory = DaoFactory.getInstance();
    public User login(String name) {
        UserDao userDao = daoFactory.createUserDao();

        User user = userDao.findByName(name);
        return user;
    }
}
