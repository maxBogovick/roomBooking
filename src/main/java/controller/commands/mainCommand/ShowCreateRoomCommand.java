package controller.commands.mainCommand;

import model.entity.Room;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShowCreateRoomCommand extends BaseCommand {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        final String id = request.getParameter("id");
        final Room room;
        
        if (id == null || id.trim().length() == 0) {
            room = new Room();
        } else {
            room = roomService.findById(Integer.parseInt(id)).orElseThrow(() -> new RuntimeException("room by id: " + id + " not found"));
        }
        request.setAttribute("room", room);
        return CREATE_ROOM;
    }

}
