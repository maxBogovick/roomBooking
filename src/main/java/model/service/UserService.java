package model.service;

import model.dao.DaoFactory;
import model.dao.UserDao;
import model.entity.User;

public interface UserService {

//    DaoFactory daoFactory = DaoFactory.getInstance();
    public User login(String name);
//    {
//        UserDao userDao = daoFactory.createUserDao();
//
//            User user = userDao.findByName(name);
//            return user;
//
//    }
}
