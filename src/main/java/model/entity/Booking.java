package model.entity;

import java.util.ArrayList;
import java.util.List;

public class Booking {
    private int id;
    private int totalCost;
    private String roomType;
    private int clientId;
    private User client;

    private List<Room> rooms = new ArrayList<>();

    public Booking(Integer id, int totalCost, String roomType, int clientId, User client) {
        this.id = id;
        this.totalCost = totalCost;
        this.roomType = roomType;
        this.clientId = clientId;
        this.client = client;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getTotalCost() {
        return totalCost;
    }
    public void setTotalCost(int totalCost) {
        this.totalCost = totalCost;
    }
    public String getRoomType() {
        return roomType;
    }
    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }
    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public User getClient() {
        return client;
    }

    public void setClient(User client) {
        this.client = client;
    }

    public List<Room> getRooms() {
        return rooms;
    }
    public void settRooms(List<Room> rooms) {
        this.rooms = rooms;
    }
}
