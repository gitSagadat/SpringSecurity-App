package io.saga.securityapp.firstSecurityApp.util;


import io.saga.securityapp.firstSecurityApp.models.Person;
import io.saga.securityapp.firstSecurityApp.services.PersonDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * @author Sagadat Kuandykov
 */
@Component
public class PersonValidator implements Validator {
    private final PersonDetailsService personDetailsService;
    @Autowired
    public PersonValidator(PersonDetailsService personDetailsService) {
        this.personDetailsService = personDetailsService;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return Person.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Person person = (Person) o;
        try{
        personDetailsService.loadUserByUsername(person.getUsername());
        } catch (UsernameNotFoundException ignored){
            return;
        }
        errors.rejectValue("username","User name is already exist");
    }
}
