package edu.tcu.cs.superfrogscheduler.domain;
import com.fasterxml.jackson.annotation.JsonIgnore;
import net.bytebuddy.implementation.bind.annotation.Super;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Entity
public class Request implements Serializable{
    @Id
    private String id;
    private String description;
    private String clientName;
    @ManyToOne
    @JsonIgnore
    private Superfrog ownerFrog;

    public Request() {

    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
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

    public Superfrog getOwnerFrog() {
        return ownerFrog;
    }

    public void setOwnerFrog(Superfrog ownerFrog) {
        this.ownerFrog = ownerFrog;
    }

}
