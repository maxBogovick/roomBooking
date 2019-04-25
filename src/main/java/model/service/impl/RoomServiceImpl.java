package model.service.impl;

import model.dao.DaoFactory;
import model.dao.RoomDao;
import model.entity.Room;
import model.service.RoomService;

import java.util.List;

public class RoomServiceImpl implements RoomService {
    DaoFactory daoFactory = DaoFactory.getInstance();

    public List<Room> getAllRooms(){
        try (RoomDao dao = daoFactory.createRoomDao()) {
            return dao.findAll();
        }
    }
}
