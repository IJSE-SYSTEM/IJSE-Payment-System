/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.paymentsystem.dto;

import java.util.ArrayList;

/**
 *
 * @author simo-ds
 */
public class StudentDTO extends SuperDTO{
    private String SID;
    private String initialStudentName;
    private String studentName;
    private String addressLine1;
    private String addressLine2;
    private String addressLine3;
    private String telHome;
    private String mobile;
    private String email;
    private String dob;
    private String gender;
    private String nic;
    private double regFee;
    private String school;
    private String grade;
    private String university;
    
    private GuardianDTO guardian;
    private ArrayList<QualificationDTO> qualifications;
    private StudentOtherInfoDTO infoDTO;
    

    public StudentDTO() {
    }

    public StudentDTO(String SID, String initialStudentName, String studentName, String addressLine1, String addressLine2, String addressLine3, String telHome, String mobile, String email, String dob, String gender, String nic, double regFee, String school, String grade, String university) {
        this(initialStudentName,studentName,addressLine1,addressLine2,addressLine3,telHome,mobile,email,dob,gender,nic,school,university);
        this.SID = SID;
        this.regFee = regFee;
    }
    
//    this has no regFee Parameter
    public StudentDTO(String initialStudentName, String studentName, String addressLine1, String addressLine2, String addressLine3, String telHome, String mobile, String email, String dob, String gender, String nic, String school, String university) {
        this.initialStudentName = initialStudentName;
        this.studentName = studentName;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.addressLine3 = addressLine3;
        this.telHome = telHome;
        this.mobile = mobile;
        this.email = email;
        this.dob = dob;
        this.gender = gender;
        this.nic = nic;
        this.school = school;
        this.university = university;
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
     * @return the initialStudentName
     */
    public String getInitialStudentName() {
        return initialStudentName;
    }

    /**
     * @param initialStudentName the initialStudentName to set
     */
    public void setInitialStudentName(String initialStudentName) {
        this.initialStudentName = initialStudentName;
    }

    /**
     * @return the studentName
     */
    public String getStudentName() {
        return studentName;
    }

    /**
     * @param studentName the studentName to set
     */
    public void setStudentName(String studentName) {
        this.studentName = studentName;
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

    /**
     * @return the telHome
     */
    public String getTelHome() {
        return telHome;
    }

    /**
     * @param telHome the telHome to set
     */
    public void setTelHome(String telHome) {
        this.telHome = telHome;
    }

    /**
     * @return the mobile
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * @param mobile the mobile to set
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
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
     * @return the dob
     */
    public String getDob() {
        return dob;
    }

    /**
     * @param dob the dob to set
     */
    public void setDob(String dob) {
        this.dob = dob;
    }

    /**
     * @return the gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * @param gender the gender to set
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * @return the nic
     */
    public String getNic() {
        return nic;
    }

    /**
     * @param nic the nic to set
     */
    public void setNic(String nic) {
        this.nic = nic;
    }

    /**
     * @return the school
     */
    public String getSchool() {
        return school;
    }

    /**
     * @param school the school to set
     */
    public void setSchool(String school) {
        this.school = school;
    }

    /**
     * @return the grade
     */
    public String getGrade() {
        return grade;
    }

    /**
     * @param grade the grade to set
     */
    public void setGrade(String grade) {
        this.grade = grade;
    }

    /**
     * @return the university
     */
    public String getUniversity() {
        return university;
    }

    /**
     * @param university the university to set
     */
    public void setUniversity(String university) {
        this.university = university;
    }

    /**
     * @return the guardian
     */
    public GuardianDTO getGuardian() {
        return guardian;
    }

    /**
     * @param guardian the guardian to set
     */
    public void setGuardian(GuardianDTO guardian) {
        this.guardian = guardian;
    }

    /**
     * @return the qualifications
     */
    public ArrayList<QualificationDTO> getQualifications() {
        return qualifications;
    }

    /**
     * @param qualifications the qualifications to set
     */
    public void setQualifications(ArrayList<QualificationDTO> qualifications) {
        this.qualifications = qualifications;
    }

    /**
     * @return the infoDTO
     */
    public StudentOtherInfoDTO getInfoDTO() {
        return infoDTO;
    }

    /**
     * @param infoDTO the infoDTO to set
     */
    public void setInfoDTO(StudentOtherInfoDTO infoDTO) {
        this.infoDTO = infoDTO;
    }

    /**
     * @return the regFee
     */
    public double getRegFee() {
        return regFee;
    }

    /**
     * @param regFee the regFee to set
     */
    public void setRegFee(double regFee) {
        this.regFee = regFee;
    }

}
