package model.dao.impl;

import model.dao.RoomDao;
import model.dao.mapper.RoomMapper;
import model.dao.mapper.UserMapper;
import model.entity.Room;
import model.entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class JDBCRoomDao implements RoomDao {
    private Connection connection;

    public JDBCRoomDao() {
    }

    public JDBCRoomDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public boolean create(Room entity) throws SQLException {
        try(Connection connection = ConnectionPoolHolder.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement("INSERT INTO rooms(roomType, capacity, cost, quota) VALUES (?,?,?,?)")){

            statement.setString(1, entity.getRoomType());
            statement.setInt(2, entity.getCapacity());
            statement.setInt(3, entity.getCost());
            statement.setInt(4, entity.getQuota());

            statement.execute();
            return true;

        }catch (SQLException | RuntimeException ex){
            System.out.println(ex);
            throw new RuntimeException();
        }
    }

    @Override
    public Room findById(int id) {
        return null;
    }
    @Override
    public List<Room> findAll() {
        Map<Integer, Room> rooms = new HashMap<>();
        Map<Integer, User> users = new HashMap<>();

        final String query = "" +
                " select r.idRoom as idroom, r.roomType as roomType, r.capacity as capacity, " +
                " r.cost as cost, r.quota as quota, r.order_ID_order as orderId from rooms r";// +

        try (Statement st = connection.createStatement()) {
            ResultSet rs = st.executeQuery(query);

            UserMapper userMapper = new UserMapper();
            RoomMapper roomMapper = new RoomMapper();

            while (rs.next()) {
                Room room = roomMapper
                        .extractFromResultSet(rs);
                /*User user = userMapper
                        .extractFromResultSet(rs);*/
                room = roomMapper
                        .makeUnique(rooms, room);
//                user = userMapper
//                        .makeUnique(users, user);
//                room.getUsers().add(user);
            }
            return new ArrayList<>(rooms.values());
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }



    @Override
    public void update(Room entity) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void close()  {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
