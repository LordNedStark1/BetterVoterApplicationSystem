package africa.semicolon.repositories;

import africa.semicolon.models.Address;
import africa.semicolon.models.Admin;

import java.util.List;

public interface AdminRepository {
    Admin findById(String id);
    List<Admin> findAll();
    Admin save (Admin admin);
    void deleteById(String id);
}
