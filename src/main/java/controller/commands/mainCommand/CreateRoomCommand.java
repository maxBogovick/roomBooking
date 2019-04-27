package controller.commands.mainCommand;

import controller.commands.Command;
import model.dao.impl.JDBCRoomDao;
import model.entity.Room;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

public class CreateRoomCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String typeFromRequest = request.getParameter("type");
        int capacityFromRequest = Integer.parseInt(request.getParameter("capacity"));
        int costFromRequest = Integer.parseInt(request.getParameter("cost"));
        int quotaFromRequest = Integer.parseInt(request.getParameter("quota"));

        Room room = new Room();
        room.setRoomType(typeFromRequest);
        room.setCapacity(capacityFromRequest);
        room.setCost(costFromRequest);
        room.setQuota(quotaFromRequest);

        JDBCRoomDao jdbcRoomDao = new JDBCRoomDao();
        try {
            jdbcRoomDao.create(room);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ADMIN_HOME_JSP;
    }

}
