package com.mycompany.func;

import com.mycompany.Entity.InternationalVisitor;
import com.mycompany.Entity.InternationalVisitorXML;
import java.util.ArrayList;
import java.util.List;
import com.mycompany.utils.FileUtils;

public class InternationalVisitorFunc {
    private static final String VISITOR_FILE_NAME = "InternationalVisitor.xml";
    private List<InternationalVisitor> listVisitor;
    
    public InternationalVisitorFunc(){
        this.listVisitor = readListVisitors();
    }
    public void writeListVisitors(List<InternationalVisitor> visitors) {
        InternationalVisitorXML visitorXML = new InternationalVisitorXML();
        visitorXML.setInternationalVisitor(visitors);
        FileUtils.writeXMLtoFile(VISITOR_FILE_NAME, visitorXML);
    }
    
    public List<InternationalVisitor> readListVisitors() {
        List<InternationalVisitor> list = new ArrayList<InternationalVisitor>();
        InternationalVisitorXML visitorXML = (InternationalVisitorXML) FileUtils.readXMLFile(
                VISITOR_FILE_NAME, InternationalVisitorXML.class);
        if (visitorXML != null) {
            list = visitorXML.getInternationalVisitor();
        }
        return list;
    }
    
    public void add(InternationalVisitor visitor) {
        listVisitor.add(visitor);
        writeListVisitors(listVisitor);
    }
    
    public void edit(InternationalVisitor visitor) {
        int size = listVisitor.size();
        for (int i = 0; i < size; i++) {
            if (listVisitor.get(i).getPassportNumber().equals(visitor.getPassportNumber())) {
                listVisitor.get(i).setFullName(visitor.getFullName());
                listVisitor.get(i).setDateOfBirth(visitor.getDateOfBirth());
                listVisitor.get(i).setNationality(visitor.getNationality());
                listVisitor.get(i).setEntryTime(visitor.getEntryTime());
                listVisitor.get(i).setExitTime(visitor.getExitTime());
                listVisitor.get(i).setMaxStayDays(visitor.getMaxStayDays());
                listVisitor.get(i).setExitLocation(visitor.getExitLocation());
                listVisitor.get(i).setEntryGate(visitor.getEntryGate());
                listVisitor.get(i).setEntryReason(visitor.getEntryReason());
                listVisitor.get(i).setEntryLocation(visitor.getEntryLocation());
                writeListVisitors(listVisitor);
                break;
            }
        }
    }
    
    public boolean delete(InternationalVisitor visitor) {
        boolean isFound = false;
        int size = listVisitor.size();
        for (int i = 0; i < size; i++) {
            if (listVisitor.get(i).getPassportNumber().equals(visitor.getPassportNumber())) {
                visitor = listVisitor.get(i);
                isFound = true;
                break;
            }
        }
        if (isFound) {
            listVisitor.remove(visitor);
            writeListVisitors(listVisitor);
            return true;
        }
        return false;
    }
    
    public List<InternationalVisitor> getListVisitor() {
        return listVisitor;
    }

    public void setListStudents(List<InternationalVisitor> listVisitor) {
        this.listVisitor = listVisitor;
    }
    public InternationalVisitor getVisitorFullInfor(InternationalVisitor visitor){
        int size = listVisitor.size();
        InternationalVisitor vs = new InternationalVisitor();
        for(int i = 0; i < size; i++){
            if (listVisitor.get(i).getPassportNumber().equals(visitor.getPassportNumber())){
                vs = listVisitor.get(i);
                break;
            }
        }
        return vs;
    }
}
