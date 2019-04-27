package controller.commands.mainCommand;

import controller.commands.Command;
import controller.commands.mainCommand.util.Util;
import model.entity.User;
import model.entity.types.Role;
import model.service.ServiceFactory;
import model.service.UserService;
import model.service.impl.UserServiceImpl;
import model.util.Constants;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserCommand implements Command {
    private static final Logger logger = Logger.getLogger(UserCommand.class);
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        UserService userService = ServiceFactory.getUserService();
        String nameFromRequest = request.getParameter("name");
        String passFromRequest = request.getParameter("pass");
        logger.info("Attempt to log in user: " + nameFromRequest);

        User user = userService.login(nameFromRequest);
        String password = user.getPassword();

        if (Constants.getPwdHash(passFromRequest).equals(password)) {
            request.getSession(true).setAttribute("User", user);
            logger.info("Successfully logged in user: " + user.getLogin());
            if (Role.ADMIN.getRole() == user.getRole())  {
                return "redirect:/" + Util.ADMIN_ROOM_LIST.getPath();
                }
            return "redirect:/" + Util.ROOM_LIST.getPath();
        }
        return SIGN_IN_JSP;
    }
}
