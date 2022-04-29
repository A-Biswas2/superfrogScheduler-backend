package edu.tcu.cs.superfrogscheduler.controller;
import edu.tcu.cs.superfrogscheduler.domain.Client;
import edu.tcu.cs.superfrogscheduler.domain.Result;
import edu.tcu.cs.superfrogscheduler.domain.StatusCode;
import edu.tcu.cs.superfrogscheduler.service.ClientService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class ClientController {
    private ClientService service;

    public ClientController(ClientService service) {
        this.service = service;
    }

    @GetMapping
    public Result findAll() {
        return new Result(true, StatusCode.SUCCESS, "Find All Success", service.findAll());
    }

    @GetMapping("/{id}")
    public Result findById(@PathVariable Integer id) {
        return new Result(true, StatusCode.SUCCESS, "Find One Success", service.findById(id));
    }

    @PostMapping
    public Result save(@RequestBody Client user) {
        service.save(user);
        return new Result(true, StatusCode.SUCCESS, "Save Success");
    }

    @PutMapping("/{id}")
    public Result update(@RequestBody Client user, @PathVariable Integer id) {
        service.update(id, user);
        return new Result(true, StatusCode.SUCCESS, "Update Success");
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        service.deleteById(id);
        return new Result(true, StatusCode.SUCCESS, "Delete Success");
    }
}
