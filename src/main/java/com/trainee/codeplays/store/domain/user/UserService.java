package com.trainee.codeplays.store.domain.user;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    public boolean isUserMinor(Long id){
        return true;
    }
}
