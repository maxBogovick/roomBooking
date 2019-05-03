package model.dao;

import model.dao.impl.JDBCDaoFactory;

import java.sql.Connection;

public abstract class DaoFactory {
    private static DaoFactory daoFactory;

    public abstract UserDao createUserDao();
    public abstract RoomDao createRoomDao();
//    public abstract RoleDao createRoleDao();


    public static DaoFactory getInstance(){
        if( daoFactory == null ){
            synchronized (DaoFactory.class){
                if(daoFactory==null){
                    daoFactory = new JDBCDaoFactory();
                }
            }
        }
        return daoFactory;
    }
}
