package model.entity;

import java.util.Objects;

public class Room {
    private int id;
    private String roomType;
    private int capacity;
    private int cost;
    private int quota;
    private int orderId;
    private Booking booking;

    public Room() {}

    public Room(int id, String roomType, int capacity, int cost, int quota) {
        this.id = id;
        this.roomType = roomType;
        this.capacity = capacity;
        this.cost = cost;
        this.quota = quota;
    }

    public int getRoomID() {
        return id;
    }

    public void setRoomID(int id_room) {
        this.id = id_room;
    }

    public String getRoomType() {
        return roomType;
    }
    public void setRoomType(String room_type) {
        this.roomType = room_type;
    }

    public int getCapacity() {
        return capacity;
    }
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    public int getCost() {
        return cost;
    }
    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getQuota() {
        return quota;
    }
    public void setQuota(int quota) {
        this.quota = quota;
    }
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room that = (Room) o;
        return roomType.equals(that.roomType);
//                capacity.equals(that.capacity) &&
//                cost.equals(that.cost);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roomType, capacity, cost);
    }

    @Override
    public String toString() {
        return "\nRoom{" +
                "id=" + id +
                ", room type='" + roomType + '\'' +
                ", capacity='" + capacity + '\'' +
                ", cost='" + cost + '\'' +
                ", quota=" + quota +
                '}';
    }

}

