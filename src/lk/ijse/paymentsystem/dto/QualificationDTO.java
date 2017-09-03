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
public class QualificationDTO {
    
    private String qualification;
    private String awardingInstitute;
    private String dateOfAward;
    private String specialization;

    public QualificationDTO() {
    }

    public QualificationDTO(String qualification, String awardingInstitute, String dateOfAward, String specialization) {
        this.qualification = qualification;
        this.awardingInstitute = awardingInstitute;
        this.dateOfAward = dateOfAward;
        this.specialization = specialization;
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
    public String getDateOfAward() {
        return dateOfAward;
    }

    /**
     * @param dateOfAward the dateOfAward to set
     */
    public void setDateOfAward(String dateOfAward) {
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
