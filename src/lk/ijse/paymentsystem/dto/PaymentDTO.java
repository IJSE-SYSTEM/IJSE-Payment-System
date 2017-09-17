/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.paymentsystem.dto;

import java.time.LocalDate;

/**
 *
 * @author midda
 */
public class PaymentDTO extends SuperDTO{
    private String payID;
    private String regID;
    private int semester;
    private int sem_half;
    private LocalDate date;
    private double amount;
    private double discount;
    private double amount_recieved;

    public PaymentDTO(String payID, String regID, int semester, int sem_half, LocalDate date, double amount, double discount, double amount_recieved) {
        this.payID = payID;
        this.regID = regID;
        this.semester = semester;
        this.sem_half = sem_half;
        this.date = date;
        this.amount = amount;
        this.discount = discount;
        this.amount_recieved = amount_recieved;
    }

    public PaymentDTO() {
    }

    /**
     * @return the payID
     */
    public String getPayID() {
        return payID;
    }

    /**
     * @param payID the payID to set
     */
    public void setPayID(String payID) {
        this.payID = payID;
    }

    /**
     * @return the regID
     */
    public String getRegID() {
        return regID;
    }

    /**
     * @param regID the regID to set
     */
    public void setRegID(String regID) {
        this.regID = regID;
    }

    /**
     * @return the semester
     */
    public int getSemester() {
        return semester;
    }

    /**
     * @param semester the semester to set
     */
    public void setSemester(int semester) {
        this.semester = semester;
    }

    /**
     * @return the sem_half
     */
    public int getSem_half() {
        return sem_half;
    }

    /**
     * @param sem_half the sem_half to set
     */
    public void setSem_half(int sem_half) {
        this.sem_half = sem_half;
    }
    
    /**
     * @return the date
     */
    public LocalDate getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(LocalDate date) {
        this.date = date;
    }

    /**
     * @return the amount
     */
    public double getAmount() {
        return amount;
    }

    /**
     * @param amount the amount to set
     */
    public void setAmount(double amount) {
        this.amount = amount;
    }

    /**
     * @return the discount
     */
    public double getDiscount() {
        return discount;
    }

    /**
     * @param discount the discount to set
     */
    public void setDiscount(double discount) {
        this.discount = discount;
    }

    /**
     * @return the amount_recieved
     */
    public double getAmount_recieved() {
        return amount_recieved;
    }

    /**
     * @param amount_recieved the amount_recieved to set
     */
    public void setAmount_recieved(double amount_recieved) {
        this.amount_recieved = amount_recieved;
    }
    
    
}
