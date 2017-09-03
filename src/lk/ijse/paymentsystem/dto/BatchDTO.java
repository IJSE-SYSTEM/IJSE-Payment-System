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
public class BatchDTO extends SuperDTO{
    private String batchID;
    private String courseCode;
    private String batchNo;
    private LocalDate startDate;
    private String Branch;

    public BatchDTO() {
    }

    public BatchDTO(String batchID, String courseCode, String batchNo, LocalDate startDate, String Branch) {
        this.batchID = batchID;
        this.courseCode = courseCode;
        this.batchNo = batchNo;
        this.startDate = startDate;
        this.Branch = Branch;
    }

    
    /**
     * @return the batchID
     */
    public String getBatchID() {
        return batchID;
    }

    /**
     * @param batchID the batchID to set
     */
    public void setBatchID(String batchID) {
        this.batchID = batchID;
    }

    /**
     * @return the courseCode
     */
    public String getCourseCode() {
        return courseCode;
    }

    /**
     * @param courseCode the courseCode to set
     */
    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    /**
     * @return the batchNo
     */
    public String getBatchNo() {
        return batchNo;
    }

    /**
     * @param batchNo the batchNo to set
     */
    public void setBatchNo(String batchNo) {
        this.batchNo = batchNo;
    }

    /**
     * @return the startDate
     */
    public LocalDate getStartDate() {
        return startDate;
    }

    /**
     * @param startDate the startDate to set
     */
    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    /**
     * @return the Branch
     */
    public String getBranch() {
        return Branch;
    }

    /**
     * @param Branch the Branch to set
     */
    public void setBranch(String Branch) {
        this.Branch = Branch;
    }
}


/*
batchID VARCHAR(10),
code VARCHAR(10),
batchNo INT(3),
startDate DATE,
branch VARCHAR(20),

*/