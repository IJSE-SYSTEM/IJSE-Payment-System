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
public class CourseDetailsDTO extends CourseDTO{
    private String courseID;
    private int no_of_Semesters;
    private double courseFee;
    private double discount;
    private double discount2Sem;
    private double discount1Sem;
    private LocalDate dateModified;

    public CourseDetailsDTO() {
        
    }

    public CourseDetailsDTO(String courseID, int no_of_Semesters, double courseFee, double discount, double discount2Sem, double discount1Sem, LocalDate dateModified) {
        this.courseID = courseID;
        this.no_of_Semesters = no_of_Semesters;
        this.courseFee = courseFee;
        this.discount = discount;
        this.discount2Sem = discount2Sem;
        this.discount1Sem = discount1Sem;
        this.dateModified = dateModified;
    }

    public CourseDetailsDTO(String code, String name, String courseID, int no_of_Semesters, double courseFee, double discount, double discount2Sem, double discount1Sem, LocalDate dateModified) {
        super(code, name);
        this.courseID = courseID;
        this.no_of_Semesters = no_of_Semesters;
        this.courseFee = courseFee;
        this.discount = discount;
        this.discount2Sem = discount2Sem;
        this.discount1Sem = discount1Sem;
        this.dateModified = dateModified;
    }

    /**
     * @return the courseID
     */
    public String getCourseID() {
        return courseID;
    }

    /**
     * @param courseID the courseID to set
     */
    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }

    /**
     * @return the no_of_Semesters
     */
    public int getNo_of_Semesters() {
        return no_of_Semesters;
    }

    /**
     * @param no_of_Semesters the no_of_Semesters to set
     */
    public void setNo_of_Semesters(int no_of_Semesters) {
        this.no_of_Semesters = no_of_Semesters;
    }

    /**
     * @return the courseFee
     */
    public double getCourseFee() {
        return courseFee;
    }

    /**
     * @param courseFee the courseFee to set
     */
    public void setCourseFee(double courseFee) {
        this.courseFee = courseFee;
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
     * @return the discount2Sem
     */
    public double getDiscount2Sem() {
        return discount2Sem;
    }

    /**
     * @param discount2Sem the discount2Sem to set
     */
    public void setDiscount2Sem(double discount2Sem) {
        this.discount2Sem = discount2Sem;
    }

    /**
     * @return the discount1Sem
     */
    public double getDiscount1Sem() {
        return discount1Sem;
    }

    /**
     * @param discount1Sem the discount1Sem to set
     */
    public void setDiscount1Sem(double discount1Sem) {
        this.discount1Sem = discount1Sem;
    }

    /**
     * @return the dateModified
     */
    public LocalDate getDateModified() {
        return dateModified;
    }

    /**
     * @param dateModified the dateModified to set
     */
    public void setDateModified(LocalDate dateModified) {
        this.dateModified = dateModified;
    }
    
    
}
