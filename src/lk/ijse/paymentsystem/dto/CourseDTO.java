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

    public CourseDTO() {
    }
    
   public CourseDTO(String code){
       this.code=code;
   }

    public CourseDTO(String code, String name) {
        this.code = code;
        this.name = name;
    }
    
    

    @Override
    public String toString() {
        return getCode()+"-"+getName();
    }

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
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
    
   
}

