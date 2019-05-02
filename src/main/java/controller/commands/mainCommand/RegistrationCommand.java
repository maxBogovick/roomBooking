package controller.commands.mainCommand;

import controller.commands.Command;
import model.service.ServiceFactory;
import model.service.UserService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegistrationCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String nameFromRequest = request.getParameter("name");
        String passFromRequest = request.getParameter("pass");
        String emailFromRequest = request.getParameter("email");


        UserService userService = ServiceFactory.getUserService();
        try {
            userService.registrationUser(nameFromRequest, passFromRequest, emailFromRequest);
            request.setAttribute("successful", true);
        } catch (RuntimeException e) {
            request.setAttribute("error", true);
        }

        return HOME;
    }
}
