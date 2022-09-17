package io.saga.securityapp.firstSecurityApp.services;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

/**
 * @author Sagadat Kuandykov
 */
@Service
public class AdminService {
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void doAdminDelegate(){
        System.out.println("Only for Administrator");
    }
}
