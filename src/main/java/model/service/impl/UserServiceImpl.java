package model.service.impl;

import model.dao.DaoFactory;
import model.dao.UserDao;
import model.entity.User;
import model.exeption.ServiceException;
import model.service.RoomService;
import model.service.UserService;
import model.service.impl.util.Validation;
import model.util.Constants;

import java.sql.SQLException;

public class UserServiceImpl implements UserService {
    private final UserDao userDao;

    public UserServiceImpl(final DaoFactory daoFactory) {
        this.userDao = daoFactory.createUserDao();
    }

    public User login(String name){
        User user = userDao.findByName(name);
        return user;
    }

    public void singUp(final User user) {
        try {
            userDao.create(user);
        } catch (SQLException e) {
            //save error message into log
            throw new RuntimeException(e);
        }
    }

    public User registrationUser(String nickname, String password, String email) throws ServiceException {
        if (Validation.isValidParam(nickname) && Validation.isValidParam(password) && Validation.isValidParam(email)) {

            User user = new User();

            user.setLogin(nickname);
            String passWithHash = Constants.getPwdHash(password);
            user.setPassword(passWithHash);
            user.setEmail(email);
            user.setRole(2);

            singUp(user);

            return user;
        } else {
            throw new ServiceException("format exception");
        }
    }
}
