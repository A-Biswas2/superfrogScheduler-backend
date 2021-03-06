package edu.tcu.cs.superfrogscheduler.controller;
import edu.tcu.cs.superfrogscheduler.domain.Request;
import edu.tcu.cs.superfrogscheduler.domain.Result;
import edu.tcu.cs.superfrogscheduler.domain.StatusCode;
import edu.tcu.cs.superfrogscheduler.service.RequestService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/requests")
public class RequestController {

    private RequestService requestService;

    public RequestController(RequestService requestService){
        this.requestService = requestService;
    }

    @CrossOrigin
    @GetMapping
    public Result findAll(){
        List<Request> all = requestService.findAll();
        Result result = new Result(true, StatusCode.SUCCESS, "Find all success", all);
        return result;
    }

    @CrossOrigin
    @GetMapping("/{requestId}")
    public Result findById(@PathVariable String requestId){
        return new Result(true, StatusCode.SUCCESS, "find one success", requestId);
    }

    @CrossOrigin
    @PostMapping
    public Result save(@RequestBody Request newRequest) {
        requestService.save(newRequest);
        return new Result(true, StatusCode.SUCCESS, "Save Success");
    }

    @CrossOrigin
    @PutMapping("/{requestId}")
    public Result update(@PathVariable String requestId, @RequestBody Request updated) {
        requestService.update(requestId, updated);
        return new Result(true, StatusCode.SUCCESS, "Update Success");
    }

    @CrossOrigin
    @DeleteMapping("/{requestId}")
    public Result delete(@PathVariable String requestId) {
        requestService.delete(requestId);
        return new Result(true, StatusCode.SUCCESS, "Delete Success");
    }
}




