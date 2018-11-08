package com.sc.api.temp.model;

/**
 * what:   首页表格信息
 *
 * @author 孙超 created on 2018/11/9
 */
public class Transaction {
    private String order_no;
    private String timestamp;
    private String username;
    private String price;
    private String status;

    public Transaction() {
    }

    public Transaction(String order_no, String timestamp, String username, String price, String status) {
        this.order_no = order_no;
        this.timestamp = timestamp;
        this.username = username;
        this.price = price;
        this.status = status;
    }

    public String getOrder_no() {
        return order_no;
    }

    public Transaction setOrder_no(String order_no) {
        this.order_no = order_no;
        return this;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public Transaction setTimestamp(String timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public Transaction setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPrice() {
        return price;
    }

    public Transaction setPrice(String price) {
        this.price = price;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public Transaction setStatus(String status) {
        this.status = status;
        return this;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "order_no='" + order_no + '\'' +
                ", timestamp='" + timestamp + '\'' +
                ", username='" + username + '\'' +
                ", price='" + price + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
