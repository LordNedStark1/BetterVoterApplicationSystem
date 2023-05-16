package africa.semicolon.repositories;

import africa.semicolon.models.Address;
import africa.semicolon.models.Party;

import java.util.List;

public interface PartyRepository {
    Party findById(String id);
    List<Party> findAll();
    Party findByName(String name);
    Party save (Party party);
    void deleteById(String id);

}
