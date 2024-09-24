package com.mycompany.controller;

import com.mycompany.Entity.InternationalVisitor;
import com.mycompany.func.InternationalVisitorFunc;
import com.mycompany.project.Home;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class InternationalVisitorController {
    private InternationalVisitorFunc visitorFunc;
    private Home home;

    public InternationalVisitorController(Home home) {
        this.home = home;
        visitorFunc = new InternationalVisitorFunc();
        
        home.addAddVisitorListener(new AddVisitorListener());
        home.addUpdateVisitorListener(new UpdateVisitorListener());
        home.addDeleteVisitorListener(new DeleteVisitorListener());
        home.addClearListener(new ClearVisitorListener());
        home.addListVisitorSelectionListener(new ListVisitorSelectionListener());
//        home.addDetailsListener(new DetailsVisitorListener());
    }
    
    public void showVisitorView() {
        List<InternationalVisitor> visitorList = visitorFunc.getListVisitor();
        home.setVisible(true);
        home.showListVisitor(visitorList);
        home.showStatisticTable(visitorList);
    }
    
    class AddVisitorListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            InternationalVisitor visitor = (InternationalVisitor) home.getVisitorInfo();
            if (visitor != null) {
                visitorFunc.add(visitor);
                home.showVisitor(visitor);
                home.showListVisitor(visitorFunc.getListVisitor());
                home.showStatisticTable(visitorFunc.getListVisitor());
                home.showMessage("Added Successfuly!");
            }
        }
    }
    
    class UpdateVisitorListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            InternationalVisitor visitor = home.getVisitorInfo();
            if (visitor != null) {
                visitorFunc.edit(visitor);
                home.showVisitor(visitor);
                home.showListVisitor(visitorFunc.getListVisitor());
                home.showStatisticTable(visitorFunc.getListVisitor());
                home.showMessage("Updated Successfully!");
            }
        }
    }

    class DeleteVisitorListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            InternationalVisitor visitor = home.getVisitorInfo();
            if (visitor != null) {
                visitorFunc.delete(visitor);
                home.clearVisitorInfo();
                home.showListVisitor(visitorFunc.getListVisitor());
                home.showStatisticTable(visitorFunc.getListVisitor());
                home.showMessage("Deleted Successfully!");
            }
        }
    }
  
    class ClearVisitorListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            home.clearVisitorInfo();
        }
    }
    
//    class DetailsVisitorListener implements ActionListener {
//        public void actionPerformed(ActionEvent e){
//            InternationalVisitor visitor = home.getVisitorInfo();
//            if (visitor != null){
//                InternationalVisitor visitorDetail = visitorFunc.getVisitorFullInfor(visitor);
//                String name = visitorDetail.getFullName();
//                String ppNumb = visitorDetail.getPassportNumber();
//                String dob = visitorDetail.getDateOfBirth();
//                String nation = visitorDetail.getNationality();
//                String entryTi = visitorDetail.getEntryTime();
//                String entryGa = visitorDetail.getEntryGate();
//                String entryLo = visitorDetail.getEntryLocation();
//                String entryRe = ""+visitorDetail.getEntryReason();
//                String stayDays = ""+ visitorDetail.getMaxStayDays();
//                String exTi = ""+visitorDetail.getExitTime();
//                String exLo = ""+visitorDetail.getExitLocation();
//                
//                String message = """
//                 Name: %s
//                 Passport Number: %s
//                 Date of Birth: %s
//                 Nationality: %s
//                 Entry Time: %s
//                 Entry Gate: %s
//                 Entry Location: %s
//                 Entry Reason: %s
//                 Maximum Stay Days: %s
//                 Exit Time: %s
//                 Exit Location: %s
//                 """.formatted(name, ppNumb, dob, nation, entryTi, entryGa, entryLo, entryRe, stayDays, exTi, exLo);
//
//                String path;
//                if (visitorDetail.over7Days()){
//                    path = "/alarm.png";
//                }else {
//                    path = "/siren.png";
//                }
//                ImageIcon icon = new ImageIcon(getClass().getResource(path));
//                JOptionPane.showMessageDialog(home, "Hieu", "Title", JOptionPane.INFORMATION_MESSAGE, icon);
//            }
//        }
//    }
    class ListVisitorSelectionListener implements ListSelectionListener {
        public void valueChanged(ListSelectionEvent e) {
            home.fillVisitorFromSelectedRow();
        }
    }
}
