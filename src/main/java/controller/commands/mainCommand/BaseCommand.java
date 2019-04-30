package controller.commands.mainCommand;

import controller.commands.Command;
import model.service.RoomService;
import model.service.ServiceFactory;

public abstract class BaseCommand implements Command {
    
    protected final RoomService roomService = ServiceFactory.getRoomService();
}
