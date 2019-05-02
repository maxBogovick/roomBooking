package controller.commands.mainCommand;

import controller.commands.Command;
import controller.commands.mainCommand.util.Util;
import model.dao.DaoFactory;
import model.dao.impl.JDBCRoomDao;
import model.entity.Room;
import model.service.RoomService;
import model.service.ServiceFactory;
import model.service.impl.RoomServiceImpl;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

public class CreateRoomCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
//        String typeFromRequest = request.getParameter("type");
//        int capacityFromRequest = Integer.parseInt(request.getParameter("capacity"));
//        int costFromRequest = Integer.parseInt(request.getParameter("cost"));
//        int quotaFromRequest = Integer.parseInt(request.getParameter("quota"));

        Room room = new Room();
        room.setRoomType(request.getParameter("type"));
        room.setCapacity(Integer.parseInt(request.getParameter("capacity")));
        room.setCost(Integer.parseInt(request.getParameter("cost")));
        room.setQuota(Integer.parseInt(request.getParameter("quota")));

        RoomService roomService = ServiceFactory.getRoomService();
        try {
            roomService.create(room);
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }

        request.setAttribute("rooms", roomService.getAllRooms());


        return ADMIN_HOME_JSP;
    }

}
