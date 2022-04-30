package edu.tcu.cs.superfrogscheduler.domain;
import com.fasterxml.jackson.annotation.JsonIgnore;
import net.bytebuddy.implementation.bind.annotation.Super;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Request implements Serializable{
    @Id
    private String id;
    private String firstname;
    private String lastname;
    private String startdate;
    private String endDate;
    private String location;
    private String city;
    private String state;
    private String zip;
    private String description;
    private boolean finished;

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    private boolean pending = true;
    @ManyToOne
    @JsonIgnore
    private Superfrog ownerFrog;

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getStartdate() {
        return startdate;
    }

    public void setStartdate(String startdate) {
        this.startdate = startdate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public boolean isPending() {
        return pending;
    }

    public Request() {

    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPending(boolean pending) {
        this.pending = pending;
    }

    public void getPending(boolean pending){
        this.pending = pending;
    }

    public Superfrog getOwnerFrog() {
        return ownerFrog;
    }

    public void setOwnerFrog(Superfrog ownerFrog) {
        this.ownerFrog = ownerFrog;
    }

}
