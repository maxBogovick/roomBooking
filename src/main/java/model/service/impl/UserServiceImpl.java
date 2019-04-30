package model.service.impl;

import model.dao.DaoFactory;
import model.dao.UserDao;
import model.entity.User;
import model.service.RoomService;
import model.service.UserService;

public class UserServiceImpl implements UserService {
//    private final DaoFactory daoFactory;
    private final UserDao userDao;

    public UserServiceImpl(final DaoFactory daoFactory) {
//        this.daoFactory = daoFactory;
        this.userDao = daoFactory.createUserDao();
    }

    public User login(String name){
//        UserDao userDao = daoFactory.createUserDao();
        User user = userDao.findByName(name);
        return user;

    }
}
