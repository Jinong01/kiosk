package com.koreait.coffee.model.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Order {
    private Integer id;
    private Integer userId;
    private Integer status;
    private LocalDateTime orderTime;
    private Integer payMethod;
    private Integer payStatus;
    private LocalDate endTime;
    private Double amount;
    private String cancelReason;
    private String rejectionReason;
    private LocalDateTime cancelTime;
    private Double point;

    public Order(Integer id, Integer userId, Integer status, LocalDateTime orderTime, Integer payMethod, Integer payStatus, LocalDate endTime, Double amount, String cancelReason, String rejectionReason, LocalDateTime cancelTime, Double point) {
        this.id = id;
        this.userId = userId;
        this.status = status;
        this.orderTime = orderTime;
        this.payMethod = payMethod;
        this.payStatus = payStatus;
        this.endTime = endTime;
        this.amount = amount;
        this.cancelReason = cancelReason;
        this.rejectionReason = rejectionReason;
        this.cancelTime = cancelTime;
        this.point = point;
    }

    public Double getPoint() {
        return point;
    }

    public void setPoint(Double point) {
        this.point = point;
    }

    public Order() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public LocalDateTime getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(LocalDateTime orderTime) {
        this.orderTime = orderTime;
    }

    public Integer getPayMethod() {
        return payMethod;
    }

    public void setPayMethod(Integer payMethod) {
        this.payMethod = payMethod;
    }

    public Integer getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(Integer payStatus) {
        this.payStatus = payStatus;
    }

    public LocalDate getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDate endTime) {
        this.endTime = endTime;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getCancelReason() {
        return cancelReason;
    }

    public void setCancelReason(String cancelReason) {
        this.cancelReason = cancelReason;
    }

    public String getRejectionReason() {
        return rejectionReason;
    }

    public void setRejectionReason(String rejectionReason) {
        this.rejectionReason = rejectionReason;
    }

    public LocalDateTime getCancelTime() {
        return cancelTime;
    }

    public void setCancelTime(LocalDateTime cancelTime) {
        this.cancelTime = cancelTime;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", userId=" + userId +
                ", status=" + status +
                ", orderTime=" + orderTime +
                ", payMethod=" + payMethod +
                ", payStatus=" + payStatus +
                ", endTime=" + endTime +
                ", amount=" + amount +
                ", cancelReason='" + cancelReason + '\'' +
                ", rejectionReason='" + rejectionReason + '\'' +
                ", cancelTime=" + cancelTime +
                ", point=" + point +
                '}';
    }
}
