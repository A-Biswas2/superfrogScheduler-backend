package edu.tcu.cs.superfrogscheduler.domain;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Superfrog implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    private boolean inactive;
    private String name;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "ownerFrog")
    @JsonIgnore
    private List<Request> requests = new ArrayList<>();

    public boolean isInactive() {
        return inactive;
    }

    public void setInactive(boolean inactive) {
        this.inactive = inactive;
    }

    public List<Request> getRequests() {
        return requests;
    }




    public Superfrog(){

    }

    public List<Request> getArtifacts() {
        return requests;
    }

    public void setRequests(List<Request> requests) {
        this.requests = requests;
    }


    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }


    public void addRequest(Request request){
        // set request owner
        request.setOwnerFrog(this);
        // add this request to this wizard
        this.requests.add(request);
    }
    public void removeRequest(Request request){
        // remove request owner
        request.setOwnerFrog(null);
        // remove this request from request
        this.requests.remove(request);
    }

}
