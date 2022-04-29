package edu.tcu.cs.superfrogscheduler.service;
import edu.tcu.cs.superfrogscheduler.dao.ClientDao;
import edu.tcu.cs.superfrogscheduler.domain.Client;
import edu.tcu.cs.superfrogscheduler.domain.MyUserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ClientService implements UserDetailsService {
    private ClientDao clientDao;
    private PasswordEncoder encoder;

    public ClientService(ClientDao clientDao) {
        this.clientDao = clientDao;
    }

    @Autowired
    public void setEncoder(PasswordEncoder encoder) {
        this.encoder = encoder;
    }

    public List<Client> findAll() {
        return clientDao.findAll();
    }

    public Client findById(Integer id) {
        return clientDao.findById(id).get();
    }

    public void save(Client client) {
        client.setPassword(encoder.encode(client.getPassword()));
        clientDao.save(client);
    }

    public void update(Integer id, Client user) {
        user.setId(id);
        clientDao.save(user);
    }

    public void deleteById(Integer id) {
        clientDao.deleteById(id);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Step 1, we need to find this user from DB
        Client user = clientDao.findByUsername(username);
        // Step 2, if the user does exist
        if (user == null) {
            throw new UsernameNotFoundException("username " + username + " is not found");
        }
        // Otherwise, wrap the returned user instance in a MyUserPrincipal instance
        return new MyUserPrincipal(user); // return the principal-
    }
}
