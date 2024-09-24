package com.mycompany.Entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "InternationalVisitor")
@XmlAccessorType(XmlAccessType.FIELD)
public class InternationalVisitor implements Serializable{
    private String passportNumber;
    private String fullName;
    private String dateOfBirth;
    private String nationality;
    private String entryTime;
    private String entryGate;
    private String entryLocation;
    private String entryReason;
    private int maxStayDays;
    private String exitTime;
    private String exitLocation;

    public InternationalVisitor(){
    }
    public InternationalVisitor(String passportNumber, String fullName, String dateOfBirth, String nationality, String entryTime, String entryGate, String entryLocation, String entryReason, int maxStayDays, String exitTime, String exitLocation) {
        this.passportNumber = passportNumber;
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
        this.nationality = nationality;
        this.entryTime = entryTime;
        this.entryGate = entryGate;
        this.entryLocation = entryLocation;
        this.entryReason = entryReason;
        this.maxStayDays = maxStayDays;
        this.exitTime = exitTime;
        this.exitLocation = exitLocation;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    

    public String getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(String entryTime) {
        this.entryTime = entryTime;
    }

    public String getEntryGate() {
        return entryGate;
    }

    public void setEntryGate(String entryGate) {
        this.entryGate = entryGate;
    }

    public String getEntryLocation() {
        return entryLocation;
    }

    public void setEntryLocation(String entryLocation) {
        this.entryLocation = entryLocation;
    }

    public String getEntryReason() {
        return entryReason;
    }

    public void setEntryReason(String entryReason) {
        this.entryReason = entryReason;
    }

    public int getMaxStayDays() {
        return maxStayDays;
    }

    public void setMaxStayDays(int maxStayDays) {
        this.maxStayDays = maxStayDays;
    }

    public String getExitTime() {
        return exitTime;
    }

    public void setExitTime(String exitTime) {
        this.exitTime = exitTime;
    }

    public String getExitLocation() {
        return exitLocation;
    }

    public void setExitLocation(String exitLocation) {
        this.exitLocation = exitLocation;
    }
    
    public boolean hasExited() {
        return exitTime != null && !exitTime.isEmpty();
    }

    // Check if the visitor has overstayed
    public boolean hasOverstayed() {
        LocalDate entryDate = LocalDate.parse(entryTime, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        LocalDate dueDate = entryDate.plusDays(maxStayDays);
        return LocalDate.now().isAfter(dueDate);
    }
    
    public boolean over7Days() {
        if (!hasOverstayed()) {
            return false;
        } else {
            long daysOverstayed = ChronoUnit.DAYS.between(LocalDate.parse(entryTime, DateTimeFormatter.ofPattern("dd/MM/yyyy")).plusDays(maxStayDays), LocalDate.now());
            return daysOverstayed > 7;
        }
    }
}
