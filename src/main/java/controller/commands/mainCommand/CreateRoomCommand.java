package controller.commands.mainCommand;

import com.google.common.base.Strings;
import controller.commands.Command;
import model.dao.impl.JDBCRoomDao;
import model.entity.Room;
import model.service.RoomService;
import model.service.ServiceFactory;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

public class CreateRoomCommand extends BaseCommand {
    
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String typeFromRequest = request.getParameter("type");
        final String capacity = request.getParameter("capacity");
        // check input not null required params
        if (Strings.isNullOrEmpty(capacity)) throw new IllegalArgumentException("capacity must be a set");
        int capacityFromRequest = Integer.parseInt(capacity);
        
        int costFromRequest = Integer.parseInt(request.getParameter("cost"));
        int quotaFromRequest = Integer.parseInt(request.getParameter("quota"));

        Room room = new Room();
        room.setRoomType(typeFromRequest);
        room.setCapacity(capacityFromRequest);
        room.setCost(costFromRequest);
        room.setQuota(quotaFromRequest);
        roomService.create(room);
        return ADMIN_HOME_JSP;
    }

}
