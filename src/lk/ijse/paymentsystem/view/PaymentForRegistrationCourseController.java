/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.paymentsystem.view;

import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import lk.ijse.paymentsystem.dto.CourseDTO;

/**
 *
 * @author midda
 */
public class PaymentForRegistrationCourseController {
    CourseDTO course;

    public PaymentForRegistrationCourseController(CourseDTO course) {
        this.course = course;
    }
    
    public DefaultMutableTreeNode setPaymentScheme(JTree tree){
        int semester=course.getNo_of_Semesters();
        DefaultMutableTreeNode trNde=new DefaultMutableTreeNode(new String("Full Payment"));
        DefaultMutableTreeNode trNdeHalf1=new DefaultMutableTreeNode(new String("1st Half"));
        DefaultMutableTreeNode trNdeHalf2=new DefaultMutableTreeNode(new String("2nd Half"));
        for (int i=0; i<semester; i++) {
            DefaultMutableTreeNode trNdeSemester=new DefaultMutableTreeNode(new String("Semester "+(i+1)));
            trNdeSemester.add(trNdeHalf1);
            trNdeSemester.add(trNdeHalf2);
            trNde.add(trNdeSemester);
        }
        return trNde;
    }
}
