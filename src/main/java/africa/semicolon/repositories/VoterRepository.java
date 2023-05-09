package africa.semicolon.repositories;

import africa.semicolon.models.Address;
import africa.semicolon.models.Voter;

import java.util.List;

public interface VoterRepository {
    Voter findById(String id);
    List<Voter> findAll();
    Voter save (Voter voter);
    void deleteById(String id);
}
