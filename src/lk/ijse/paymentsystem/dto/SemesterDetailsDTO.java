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
public class SemesterDetailsDTO extends SuperDTO{
    private String code;
    private int semester;
    private String moduleInfo;
    private String certificationLevel;

    /**
     * @return the code
     */
    public String getCode() {
        return code;
    }

    /**
     * @param code the code to set
     */
    public void setCode(String code) {
        this.code = code;
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
     * @return the moduleInfo
     */
    public String getModuleInfo() {
        return moduleInfo;
    }

    /**
     * @param moduleInfo the moduleInfo to set
     */
    public void setModuleInfo(String moduleInfo) {
        this.moduleInfo = moduleInfo;
    }

    /**
     * @return the certificationLevel
     */
    public String getCertificationLevel() {
        return certificationLevel;
    }

    /**
     * @param certificationLevel the certificationLevel to set
     */
    public void setCertificationLevel(String certificationLevel) {
        this.certificationLevel = certificationLevel;
    }
    
    
}
