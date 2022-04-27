package edu.tcu.cs.superfrogscheduler.service;

import edu.tcu.cs.superfrogscheduler.dao.RequestDao;
import edu.tcu.cs.superfrogscheduler.dao.SuperfrogDao;
import edu.tcu.cs.superfrogscheduler.domain.Request;
import edu.tcu.cs.superfrogscheduler.domain.Superfrog;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class SuperFrogService {

    private SuperfrogDao frogDao;
    private RequestDao requestDao;

    public SuperFrogService(SuperfrogDao frogDao, RequestDao requestDao){
        this.frogDao = frogDao;
        this.requestDao = requestDao;
    }

    public List<Superfrog> findAll() {
        return frogDao.findAll();
    }

    public void save(Superfrog superfrog) {
         frogDao.save(superfrog);
    }

    public void deleteById(Integer superfrogId) {
        frogDao.deleteById(superfrogId);
    }

    public void update(Integer frogId, Superfrog superfrog) {
        superfrog.setId(frogId);
        frogDao.save(superfrog);
    }

    public void assignRequest(Integer superfrogId, String requestId) {
        // find this request by id from DB
        Request requestToBeAssigned = requestDao.findById(requestId).get();
        Superfrog superfrog = frogDao.findById(superfrogId).get();

        if(requestToBeAssigned.getOwnerFrog() != null){
            requestToBeAssigned.getOwnerFrog().removeRequest(requestToBeAssigned);
        }
        superfrog.addRequest(requestToBeAssigned);
    }
}
