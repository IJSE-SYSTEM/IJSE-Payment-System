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
public class StudentProfessionalQualificationDTO extends SuperDTO{
    private String sid;
    private String qualification;
    private String awardingInstitute;
    private LocalDate dateOfAward;
    private String specialization;

    /**
     * @return the sid
     */
    public String getSid() {
        return sid;
    }

    /**
     * @param sid the sid to set
     */
    public void setSid(String sid) {
        this.sid = sid;
    }

    /**
     * @return the qualification
     */
    public String getQualification() {
        return qualification;
    }

    /**
     * @param qualification the qualification to set
     */
    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    /**
     * @return the awardingInstitute
     */
    public String getAwardingInstitute() {
        return awardingInstitute;
    }

    /**
     * @param awardingInstitute the awardingInstitute to set
     */
    public void setAwardingInstitute(String awardingInstitute) {
        this.awardingInstitute = awardingInstitute;
    }

    /**
     * @return the dateOfAward
     */
    public LocalDate getDateOfAward() {
        return dateOfAward;
    }

    /**
     * @param dateOfAward the dateOfAward to set
     */
    public void setDateOfAward(LocalDate dateOfAward) {
        this.dateOfAward = dateOfAward;
    }

    /**
     * @return the specialization
     */
    public String getSpecialization() {
        return specialization;
    }

    /**
     * @param specialization the specialization to set
     */
    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }
}
