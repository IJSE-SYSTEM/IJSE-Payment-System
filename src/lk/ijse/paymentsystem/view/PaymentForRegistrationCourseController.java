/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.paymentsystem.view;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import lk.ijse.paymentsystem.dto.CourseDTO;

/**
 *
 * @author midda
 */
public class PaymentForRegistrationCourseController {
    private  CourseDTO course;
    
    public PaymentForRegistrationCourseController(CourseDTO cdto) {
         this.course = cdto;
    }
    
    public DefaultTreeModel setPaymentScheme(){
        int semester=course.getNo_of_Semesters();
        DefaultMutableTreeNode trNde=new DefaultMutableTreeNode(new String("Full Payment"));
        for (int i=0; i<semester; i++) {
            DefaultMutableTreeNode trNdeSemester=new DefaultMutableTreeNode(new String("Semester "+(i+1)));
//            DefaultMutableTreeNode trNdeHalf1=
//            DefaultMutableTreeNode trNdeHalf2=
            trNdeSemester.add(new DefaultMutableTreeNode(new String("1st Half")));
            trNdeSemester.add(new DefaultMutableTreeNode(new String("2nd Half")));
            trNde.add(trNdeSemester);
        }
        return new DefaultTreeModel(trNde);
    }
    
}
