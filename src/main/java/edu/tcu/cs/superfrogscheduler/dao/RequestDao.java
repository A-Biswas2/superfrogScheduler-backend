package edu.tcu.cs.superfrogscheduler.dao;

import edu.tcu.cs.superfrogscheduler.domain.Request;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequestDao extends JpaRepository<Request, String> {
}
