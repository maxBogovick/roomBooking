package controller.commands.mainCommand;

import controller.commands.Command;
import model.dao.mapper.RoomMapper;
import model.entity.Room;
import model.service.impl.RoomServiceImpl;
import model.service.impl.UserServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RoomListCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        RoomServiceImpl roomService = new RoomServiceImpl();
        String roomTypeFromRequest = request.getParameter("type");
        String roomCapacityFromRequest = request.getParameter("capacity");

        roomService.getAllRooms();



       return ROOM_LIST_JSP;
    }
}
