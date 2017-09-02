/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.paymentsystem.dto;

/**
 *
 * @author midda
 */
public class CourseDTO extends SuperDTO{
    private String code;
    private String name;
    private int no_of_Semesters;
    private double courseFee;
    private double discount;
    private double discount2Sem;
    private double discount1Sem;

    public CourseDTO() {
    } 

    public CourseDTO(String code, String name, int no_of_Semesters, double courseFee, double discount, double discount2Sem, double discount1Sem) {
        this.code = code;
        this.name = name;
        this.no_of_Semesters = no_of_Semesters;
        this.courseFee = courseFee;
        this.discount = discount;
        this.discount2Sem = discount2Sem;
        this.discount1Sem = discount1Sem;
    }

    /**
     * @return the code
     */
    public String getCode() {
        return code;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the no_of_Semesters
     */
    public int getNo_of_Semesters() {
        return no_of_Semesters;
    }

    /**
     * @return the courseFee
     */
    public double getCourseFee() {
        return courseFee;
    }

    /**
     * @return the discount
     */
    public double getDiscount() {
        return discount;
    }

    /**
     * @return the discount2Sem
     */
    public double getDiscount2Sem() {
        return discount2Sem;
    }

    /**
     * @return the discount1Sem
     */
    public double getDiscount1Sem() {
        return discount1Sem;
    }

    /**
     * @param code the code to set
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @param no_of_Semesters the no_of_Semesters to set
     */
    public void setNo_of_Semesters(int no_of_Semesters) {
        this.no_of_Semesters = no_of_Semesters;
    }

    /**
     * @param courseFee the courseFee to set
     */
    public void setCourseFee(double courseFee) {
        this.courseFee = courseFee;
    }

    /**
     * @param discount the discount to set
     */
    public void setDiscount(double discount) {
        this.discount = discount;
    }

    /**
     * @param discount2Sem the discount2Sem to set
     */
    public void setDiscount2Sem(double discount2Sem) {
        this.discount2Sem = discount2Sem;
    }

    /**
     * @param discount1Sem the discount1Sem to set
     */
    public void setDiscount1Sem(double discount1Sem) {
        this.discount1Sem = discount1Sem;
    }

    @Override
    public String toString() {
        return code+"-"+name;
    }
    
   
}

