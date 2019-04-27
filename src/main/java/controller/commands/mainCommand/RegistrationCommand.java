package controller.commands.mainCommand;

import controller.commands.Command;
import model.dao.impl.JDBCUserDao;
import model.entity.User;
import model.entity.types.Role;
import model.service.UserService;
import model.util.Constants;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

public class RegistrationCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String nameFromRequest = request.getParameter("name");
        String passFromRequest = request.getParameter("pass");
        String emailFromRequest = request.getParameter("email");

        User user = new User();
        user.setLogin(nameFromRequest);
        String passWithHash = Constants.getPwdHash(passFromRequest);
        user.setPassword(passWithHash);
        user.setEmail(emailFromRequest);
        user.setRole(2);

        JDBCUserDao jdbcUserDao = new JDBCUserDao();
        try {
            jdbcUserDao.create(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return HOME;
    }
}
