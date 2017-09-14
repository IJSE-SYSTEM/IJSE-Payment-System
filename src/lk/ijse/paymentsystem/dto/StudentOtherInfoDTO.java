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
public class StudentOtherInfoDTO extends SuperDTO{
    private String sid;
    private String dataEntryBy;
    private int iqTest;
    private String comments;
    private boolean birthCertificate;
    private boolean photos;
    private boolean nic;
    private boolean academicCertificates;
    private boolean sportsCertificates;
    private boolean professionalCertificates;

    public StudentOtherInfoDTO() {
    }

    public StudentOtherInfoDTO(String dataEntryBy, int iqTest, String comments, boolean birthCertificate, boolean photos, boolean nic, boolean academicCertificates, boolean sportsCertificates, boolean professionalCertificates) {
        this.dataEntryBy = dataEntryBy;
        this.iqTest = iqTest;
        this.comments = comments;
        this.birthCertificate = birthCertificate;
        this.photos = photos;
        this.nic = nic;
        this.academicCertificates = academicCertificates;
        this.sportsCertificates = sportsCertificates;
        this.professionalCertificates = professionalCertificates;
    }

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
     * @return the dataEntryBy
     */
    public String getDataEntryBy() {
        return dataEntryBy;
    }

    /**
     * @param dataEntryBy the dataEntryBy to set
     */
    public void setDataEntryBy(String dataEntryBy) {
        this.dataEntryBy = dataEntryBy;
    }

    /**
     * @return the iqTest
     */
    public int getIqTest() {
        return iqTest;
    }

    /**
     * @param iqTest the iqTest to set
     */
    public void setIqTest(int iqTest) {
        this.iqTest = iqTest;
    }

    /**
     * @return the comments
     */
    public String getComments() {
        return comments;
    }

    /**
     * @param comments the comments to set
     */
    public void setComments(String comments) {
        this.comments = comments;
    }

    /**
     * @return the birthCertificate
     */
    public boolean isBirthCertificate() {
        return birthCertificate;
    }

    /**
     * @param birthCertificate the birthCertificate to set
     */
    public void setBirthCertificate(boolean birthCertificate) {
        this.birthCertificate = birthCertificate;
    }

    /**
     * @return the photos
     */
    public boolean isPhotos() {
        return photos;
    }

    /**
     * @param photos the photos to set
     */
    public void setPhotos(boolean photos) {
        this.photos = photos;
    }

    /**
     * @return the nic
     */
    public boolean isNic() {
        return nic;
    }

    /**
     * @param nic the nic to set
     */
    public void setNic(boolean nic) {
        this.nic = nic;
    }

    /**
     * @return the academicCertificates
     */
    public boolean isAcademicCertificates() {
        return academicCertificates;
    }

    /**
     * @param academicCertificates the academicCertificates to set
     */
    public void setAcademicCertificates(boolean academicCertificates) {
        this.academicCertificates = academicCertificates;
    }

    /**
     * @return the sportsCertificates
     */
    public boolean isSportsCertificates() {
        return sportsCertificates;
    }

    /**
     * @param sportsCertificates the sportsCertificates to set
     */
    public void setSportsCertificates(boolean sportsCertificates) {
        this.sportsCertificates = sportsCertificates;
    }

    /**
     * @return the professionalCertificates
     */
    public boolean isProfessionalCertificates() {
        return professionalCertificates;
    }

    /**
     * @param professionalCertificates the professionalCertificates to set
     */
    public void setProfessionalCertificates(boolean professionalCertificates) {
        this.professionalCertificates = professionalCertificates;
    }
    
    
}
