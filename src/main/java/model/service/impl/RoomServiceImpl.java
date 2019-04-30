package model.service.impl;

import model.dao.DaoFactory;
import model.dao.RoomDao;
import model.entity.Room;
import model.service.RoomService;

import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

public class RoomServiceImpl implements RoomService {
    private final RoomDao roomDao;

    public RoomServiceImpl(final DaoFactory daoFactory) {
        this.roomDao = daoFactory.createRoomDao();
    }

    @Override
    public List<Room> getAllRooms(){
        return roomDao.findAll();
    }

    @Override
    public void create(final Room room) {
        if (Objects.isNull(room)) throw new IllegalArgumentException("Room must be a set");
        try {
            roomDao.create(room);
        } catch (SQLException e) {
            //save error message into log
            throw new RuntimeException(e);
        }
    }
}
