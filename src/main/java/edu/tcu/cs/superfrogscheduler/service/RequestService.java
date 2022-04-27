package edu.tcu.cs.superfrogscheduler.service;

import edu.tcu.cs.superfrogscheduler.dao.RequestDao;
import edu.tcu.cs.superfrogscheduler.domain.Request;
import edu.tcu.cs.superfrogscheduler.domain.Superfrog;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class RequestService {

    private RequestDao requestDao;

    public RequestService(RequestDao requestDao){
        this.requestDao = requestDao;
    }

    public List<Request> findAll(){
        return requestDao.findAll();
    }

    public Request findById(String requestId){
        return requestDao.findById(requestId).get();
    }

    public void update(String requestId, Request updatedRequest) {
        updatedRequest.setId(requestId);
        requestDao.save(updatedRequest);
    }

    public void save(Request request) {
        requestDao.save(request);
    }



    public void delete(String requestId) {
        requestDao.deleteById(requestId);
    }

}


