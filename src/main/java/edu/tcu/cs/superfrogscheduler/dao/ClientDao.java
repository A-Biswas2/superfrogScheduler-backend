package edu.tcu.cs.superfrogscheduler.dao;
import edu.tcu.cs.superfrogscheduler.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientDao extends JpaRepository<Client, Integer> {
    Client findByUsername(String username);
}
