package edu.tcu.cs.superfrogscheduler.controller;
import edu.tcu.cs.superfrogscheduler.domain.Result;
import edu.tcu.cs.superfrogscheduler.domain.StatusCode;
import edu.tcu.cs.superfrogscheduler.domain.Superfrog;
import edu.tcu.cs.superfrogscheduler.service.SuperFrogService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin
@RequestMapping("/superfrogs")
public class SuperFrogController {

    private SuperFrogService service;

    public SuperFrogController(SuperFrogService service){
        this.service = service;
    }

    @CrossOrigin
    @GetMapping
    public Result findAll(){
        List<Superfrog> all = service.findAll();
        Result result = new Result(true, StatusCode.SUCCESS, "Find all success", all);
        return result;
    }

    @CrossOrigin
    @GetMapping("/{superfrogId}")
    public Result findById(@PathVariable String superfrogId){
        return new Result(true, StatusCode.SUCCESS, "find one success", superfrogId);
    }

    @CrossOrigin
    @PostMapping
    public Result save(@RequestBody Superfrog superfrog){
        service.save(superfrog);
        return new Result(true, StatusCode.SUCCESS, "save success");
    }

    @CrossOrigin
    @PutMapping("/{superfrogId}")
    public Result update(@PathVariable Integer superfrogId, @RequestBody Superfrog superfrog){
        superfrog.setId(superfrogId);
        service.update(superfrogId, superfrog);
        return new Result(true, StatusCode.SUCCESS, "update successful");
    }

    @CrossOrigin
    @DeleteMapping("/{superfrogId}")
    public Result deleteById(@PathVariable Integer superfrogId, @RequestBody Superfrog superfrog){
        service.deleteById(superfrogId);
        return new Result(true, StatusCode.SUCCESS, "update successful");
    }

    @CrossOrigin
    @PutMapping("/{superfrogId}/{requestId}")
    public Result assignRequest(@PathVariable Integer superfrogId, @PathVariable String requestId){
        service.assignRequest(superfrogId, requestId);
        return new Result(true, StatusCode.SUCCESS, "request Assignment Success");
    }

}




