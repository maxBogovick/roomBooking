package model.service;

import model.dao.DaoFactory;
import model.dao.RoomDao;
import model.entity.Room;

import java.util.List;
import java.util.Optional;

public interface RoomService {

    List<Room> getAllRooms();

    void create(Room room);
    
    void update(Room room);
    
    Optional<Room> findById(int id);
}
