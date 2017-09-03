/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.paymentsystem.dto;

/**
 *
 * @author simo-ds
 */
public class GuardianDTO {
    private String SID;
    private String GuardianName;
    private String telNo1;
    private String telNo2;
    private String email;
    private String designation;
    private String workPlace;
    private String addressLine1;
    private String addressLine2;
    private String addressLine3;

    public GuardianDTO() {
    }

    public GuardianDTO(String SID, String GuardianName, String telNo1, String telNo2, String email, String designation, String workPlace, String addressLine1, String addressLine2, String addressLine3) {
        this.SID = SID;
        this.GuardianName = GuardianName;
        this.telNo1 = telNo1;
        this.telNo2 = telNo2;
        this.email = email;
        this.designation = designation;
        this.workPlace = workPlace;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.addressLine3 = addressLine3;
    }
    
    public GuardianDTO(String GuardianName, String telNo1, String telNo2, String email, String designation, String workPlace, String addressLine1, String addressLine2, String addressLine3) {
        this.SID = SID;
        this.GuardianName = GuardianName;
        this.telNo1 = telNo1;
        this.telNo2 = telNo2;
        this.email = email;
        this.designation = designation;
        this.workPlace = workPlace;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.addressLine3 = addressLine3;
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
     * @return the GuardianName
     */
    public String getGuardianName() {
        return GuardianName;
    }

    /**
     * @param GuardianName the GuardianName to set
     */
    public void setGuardianName(String GuardianName) {
        this.GuardianName = GuardianName;
    }

    /**
     * @return the telNo1
     */
    public String getTelNo1() {
        return telNo1;
    }

    /**
     * @param telNo1 the telNo1 to set
     */
    public void setTelNo1(String telNo1) {
        this.telNo1 = telNo1;
    }

    /**
     * @return the telNo2
     */
    public String getTelNo2() {
        return telNo2;
    }

    /**
     * @param telNo2 the telNo2 to set
     */
    public void setTelNo2(String telNo2) {
        this.telNo2 = telNo2;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the designation
     */
    public String getDesignation() {
        return designation;
    }

    /**
     * @param designation the designation to set
     */
    public void setDesignation(String designation) {
        this.designation = designation;
    }

    /**
     * @return the workPlace
     */
    public String getWorkPlace() {
        return workPlace;
    }

    /**
     * @param workPlace the workPlace to set
     */
    public void setWorkPlace(String workPlace) {
        this.workPlace = workPlace;
    }

    /**
     * @return the addressLine1
     */
    public String getAddressLine1() {
        return addressLine1;
    }

    /**
     * @param addressLine1 the addressLine1 to set
     */
    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    /**
     * @return the addressLine2
     */
    public String getAddressLine2() {
        return addressLine2;
    }

    /**
     * @param addressLine2 the addressLine2 to set
     */
    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    /**
     * @return the addressLine3
     */
    public String getAddressLine3() {
        return addressLine3;
    }

    /**
     * @param addressLine3 the addressLine3 to set
     */
    public void setAddressLine3(String addressLine3) {
        this.addressLine3 = addressLine3;
    }

}
