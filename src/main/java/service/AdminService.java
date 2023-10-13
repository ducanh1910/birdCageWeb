package service;

import dto.AdminDto;
import model.Admin;

import java.util.List;

public interface AdminService {

    Admin save(AdminDto adminDto);

    Admin findByUsername(String username);

    interface Address {
        List<model.Address> findAll();
    }
}
