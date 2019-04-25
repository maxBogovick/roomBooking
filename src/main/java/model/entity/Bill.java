package model.entity;

public class Bill {
    private Integer id;
    private User admin;
    private Booking booking;
    private Integer price;
    private boolean isConfirm;
    private Integer adminId;
    private Integer orderId;

    private Bill(Integer id, User admin, Booking booking, Integer price, boolean isConfirm, Integer adminId, Integer orderId) {
        this.id = id;
        this.admin = admin;
        this.booking = booking;
        this.price = price;
        this.isConfirm = isConfirm;
        this.adminId = adminId;
        this.orderId = orderId;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getAdmin() {
        return admin;
    }

    public void setAdmin(User admin) {
        this.admin = admin;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean getIsConfirm() {
        return isConfirm;
    }

    public void setIsConfirm(boolean isConfirm) {
        this.isConfirm = isConfirm;
    }

    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }
}
