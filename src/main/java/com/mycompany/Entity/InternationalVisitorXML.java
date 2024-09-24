package com.mycompany.Entity;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "InternationalVisitors")
@XmlAccessorType(XmlAccessType.FIELD)
public class InternationalVisitorXML {
    private List<InternationalVisitor> InternationalVisitor;
    
    public List<InternationalVisitor> getInternationalVisitor(){
        return InternationalVisitor;
    }
    
    public void setInternationalVisitor(List<InternationalVisitor> visitor){
        this.InternationalVisitor = visitor;
    }
}
