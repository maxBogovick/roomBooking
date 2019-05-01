package controller.commands.mainCommand;

import controller.commands.Command;
import model.dao.DaoFactory;
import model.dao.impl.JDBCUserDao;
import model.entity.User;
import model.entity.types.Role;
import model.service.UserService;
import model.service.impl.UserServiceImpl;
import model.util.Constants;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

public class RegistrationCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
//        String nameFromRequest = request.getParameter("name");
//        String passFromRequest = request.getParameter("pass");
//        String emailFromRequest = request.getParameter("email");

        User user = new User();
        user.setLogin(request.getParameter("name"));
        String passWithHash = Constants.getPwdHash(request.getParameter("pass"));
        user.setPassword(passWithHash);
        user.setEmail(request.getParameter("email"));
        user.setRole(2);


        UserService userService = new UserServiceImpl(DaoFactory.getInstance());
        try {
            userService.create(user);
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }

//
//        JDBCUserDao jdbcUserDao = new JDBCUserDao();
//        try {
//            jdbcUserDao.create(user);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
        return HOME;
    }
}
