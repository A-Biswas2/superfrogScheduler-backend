package edu.tcu.cs.superfrogscheduler.controller;
import edu.tcu.cs.superfrogscheduler.domain.Client;
import edu.tcu.cs.superfrogscheduler.domain.Result;
import edu.tcu.cs.superfrogscheduler.domain.StatusCode;
import edu.tcu.cs.superfrogscheduler.service.ClientService;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/users")
public class ClientController {
    private ClientService service;

    public ClientController(ClientService service) {
        this.service = service;
    }

    @CrossOrigin
    @GetMapping
    public Result findAll() {
        return new Result(true, StatusCode.SUCCESS, "Find All Success", service.findAll());
    }

    @CrossOrigin
    @GetMapping("/{id}")
    public Result findById(@PathVariable Integer id) {
        return new Result(true, StatusCode.SUCCESS, "Find One Success", service.findById(id));
    }

    @CrossOrigin
    @PostMapping
    public Result save(@RequestBody Client user) {
        service.save(user);
        return new Result(true, StatusCode.SUCCESS, "Save Success");
    }

    @CrossOrigin
    @PutMapping("/{id}")
    public Result update(@RequestBody Client user, @PathVariable Integer id) {
        service.update(id, user);
        return new Result(true, StatusCode.SUCCESS, "Update Success");
    }

    @CrossOrigin
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        service.deleteById(id);
        return new Result(true, StatusCode.SUCCESS, "Delete Success");
    }
}
