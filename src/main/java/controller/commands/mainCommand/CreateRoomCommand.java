package controller.commands.mainCommand;

import controller.commands.mainCommand.util.StringUtil;
import model.entity.Room;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class CreateRoomCommand extends BaseCommand {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
//        String typeFromRequest = request.getParameter("type");
//        int capacityFromRequest = Integer.parseInt(request.getParameter("capacity"));
//        int costFromRequest = Integer.parseInt(request.getParameter("cost"));
//        int quotaFromRequest = Integer.parseInt(request.getParameter("quota"));
        boolean isNewRoom = false;
        Room room = new Room();
        if (StringUtil.isEmpty(request.getParameter("roomId"))) {
            isNewRoom = true;
        } else {
            room.setRoomID(Integer.parseInt(request.getParameter("roomId")));
        }
        if (!StringUtil.isEmpty(request.getParameter("orderId"))) {
            room.setOrderId(Integer.parseInt(request.getParameter("orderId")));
        }
        room.setRoomType(request.getParameter("type"));
        room.setCapacity(Integer.parseInt(request.getParameter("capacity")));
        room.setCost(Integer.parseInt(request.getParameter("cost")));
        room.setQuota(Integer.parseInt(request.getParameter("quota")));

        try {
            if (isNewRoom) {
                roomService.create(room);
            } else {
                roomService.update(room);
            }
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
        request.setAttribute("rooms", roomService.getAllRooms());

        return ADMIN_HOME_JSP;
    }

}
