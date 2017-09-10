/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.paymentsystem.dto;

import java.time.LocalDate;

/**
 *
 * @author simo-ds
 */
public class RegistrationDTO extends SuperDTO{
    private String RID;
    private String SID;
    private String batchId;
    private LocalDate registrationDate;
    private String transferredToBatch;
    private String newRegistrationID;

    public RegistrationDTO(String RID, String SID, String batchId, LocalDate registrationDate, String transferredToBatch, String newRegistrationID) {
        this.RID = RID;
        this.SID = SID;
        this.batchId = batchId;
        this.registrationDate = registrationDate;
        this.transferredToBatch = transferredToBatch;
        this.newRegistrationID = newRegistrationID;
    }

    public RegistrationDTO() {
    }

    /**
     * @return the RID
     */
    public String getRID() {
        return RID;
    }

    /**
     * @param RID the RID to set
     */
    public void setRID(String RID) {
        this.RID = RID;
    }

    /**
     * @return the SID
     */
    public String getSID() {
        return SID;
    }

    /**
     * @param SID the SID to set
     */
    public void setSID(String SID) {
        this.SID = SID;
    }

    /**
     * @return the batchId
     */
    public String getBatchId() {
        return batchId;
    }

    /**
     * @param batchId the batchId to set
     */
    public void setBatchId(String batchId) {
        this.batchId = batchId;
    }

    /**
     * @return the registrationDate
     */
    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    /**
     * @param registrationDate the registrationDate to set
     */
    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }

    /**
     * @return the transferredToBatch
     */
    public String getTransferredToBatch() {
        return transferredToBatch;
    }

    /**
     * @param transferredToBatch the transferredToBatch to set
     */
    public void setTransferredToBatch(String transferredToBatch) {
        this.transferredToBatch = transferredToBatch;
    }

    /**
     * @return the newRegistrationID
     */
    public String getNewRegistrationID() {
        return newRegistrationID;
    }

    /**
     * @param newRegistrationID the newRegistrationID to set
     */
    public void setNewRegistrationID(String newRegistrationID) {
        this.newRegistrationID = newRegistrationID;
    }

    
}
