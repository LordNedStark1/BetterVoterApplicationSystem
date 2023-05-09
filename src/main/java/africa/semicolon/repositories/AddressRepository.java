package africa.semicolon.repositories;

import africa.semicolon.models.Address;

import java.util.List;

public interface AddressRepository {
    Address findById(String id);
    List<Address> findAll();
    Address save (Address address);
    void deleteById(String id);
}
