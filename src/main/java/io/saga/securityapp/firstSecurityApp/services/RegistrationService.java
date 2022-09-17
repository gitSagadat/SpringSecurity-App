package io.saga.securityapp.firstSecurityApp.services;

import io.saga.securityapp.firstSecurityApp.models.Person;
import io.saga.securityapp.firstSecurityApp.repositories.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Sagadat Kuandykov
 */
@Service
public class RegistrationService {

    private final PeopleRepository peopleRepository;

    @Autowired
    public RegistrationService(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }
    @Transactional
    public void register(Person person){
        peopleRepository.save(person);
    }
}
