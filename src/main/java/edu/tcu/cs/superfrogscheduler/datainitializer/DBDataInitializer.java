package edu.tcu.cs.superfrogscheduler.datainitializer;

import edu.tcu.cs.superfrogscheduler.dao.ClientDao;
import edu.tcu.cs.superfrogscheduler.dao.RequestDao;
import edu.tcu.cs.superfrogscheduler.dao.SuperfrogDao;
import edu.tcu.cs.superfrogscheduler.domain.Client;
import edu.tcu.cs.superfrogscheduler.domain.Request;
import edu.tcu.cs.superfrogscheduler.domain.Superfrog;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DBDataInitializer implements CommandLineRunner {

    private RequestDao requestDao;
    private SuperfrogDao superfrogDao;
    private ClientDao clientDao;

    public DBDataInitializer(RequestDao requestDao, SuperfrogDao superfrogDao, ClientDao clientDao){
        this.requestDao = requestDao;
        this.superfrogDao = superfrogDao;
        this.clientDao = clientDao;
    }

    @Override
    public void run(String... args) throws Exception{
        Request r1 = new Request();
        r1.setId("12345678923124");
        r1.setFirstname("Bingyang");
        r1.setLastname("wei");
        r1.setCity("fort worth");
        r1.setDescription("For computer science celebration");

        Request r2 = new Request();
        r2.setId("123456789235153");
        r2.setDescription("For computer science celebration");

        Request r3 = new Request();
        r3.setId("12345678923456");
        r3.setDescription("For computer science celebration");

        Request r4 = new Request();
        r4.setId("12345674258923");
        r4.setDescription("For computer science celebration");
        requestDao.save(r1);
        requestDao.save(r2);
        requestDao.save(r3);
        requestDao.save(r4);

        List<Request> rl = new ArrayList<Request>();
        rl.add(r1);
        rl.add(r2);
        rl.add(r3);

        Superfrog s1 = new Superfrog();
        s1.setId(1);
        s1.setName("firat");
        s1.setRequests(rl);
        r1.setOwnerFrog(s1);

        Superfrog s2 = new Superfrog();
        s2.setId(2);
        s2.setName("aparijta");


        Client c1 = new Client();
        c1.setUsername("firat");
        c1.setPassword("123456");
        c1.setRoles("admin");
        c1.isEnabled();

        clientDao.save(c1);
        superfrogDao.save(s1);
        superfrogDao.save(s2);

    }
}
