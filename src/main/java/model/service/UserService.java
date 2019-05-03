package model.service;

import model.dao.DaoFactory;
import model.dao.UserDao;
import model.entity.User;
import model.exeption.ServiceException;

public interface UserService {

    User login(String name);

    void singUp(User user);

    User registrationUser(String nickname, String password, String email) throws ServiceException;
}
