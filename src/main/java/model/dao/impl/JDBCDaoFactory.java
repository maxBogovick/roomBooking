package model.dao.impl;

import model.dao.DaoFactory;
import model.dao.RoomDao;
import model.dao.UserDao;
import org.apache.log4j.Logger;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class JDBCDaoFactory extends DaoFactory {

    private DataSource dataSource = ConnectionPoolHolder.getDataSource();

    @Override
    public UserDao createUserDao() {
        return new JDBCUserDao();
    }

    @Override
    public RoomDao createRoomDao() {
        return new JDBCRoomDao(getConnection());
    }
//    @Override RoomDao createRoleDao() {
//        return new JDBCRoleDao(getConnection());
//    }

    private Connection getConnection(){
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}