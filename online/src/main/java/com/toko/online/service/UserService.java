package com.toko.online.service;

import com.toko.online.model.entity.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private User user = new User();

    public User getUser() {
        user.setIdCard(001);
        user.setName("Marco");
        user.setAddress("Desa Tengkapak");
        user.setItem(3);
        return this.user;
    }
}
