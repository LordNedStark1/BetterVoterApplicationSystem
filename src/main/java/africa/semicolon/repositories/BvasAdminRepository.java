package africa.semicolon.repositories;

import africa.semicolon.models.Admin;
import africa.semicolon.utils.AppUtils;

import java.util.ArrayList;
import java.util.List;

public class BvasAdminRepository implements AdminRepository{
    List<Admin> admins = new ArrayList<>();
    @Override
    public Admin findById(String id) {
        for (Admin admin :admins)
            if (admin.getId().equals(id)) return admin;
        return null;
    }

    @Override
    public List<Admin> findAll() {
        return admins;
    }

    @Override
    public Admin save(Admin admin) {
        admin.setId(AppUtils.generateId());
       admins.add(admin);
        return admin;
    }

    @Override
    public void deleteById(String id) {
        Admin admin = findById(id);
        admins.remove(admin);
    }
}
