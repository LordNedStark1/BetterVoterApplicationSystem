package africa.semicolon.repositories;

import africa.semicolon.models.Voter;
import africa.semicolon.utils.AppUtils;

import java.util.ArrayList;
import java.util.List;

public class BvasVotersRepository implements VoterRepository {
    private List<Voter> voters = new ArrayList<>();

    @Override
    public Voter findById(String id) {
        for (Voter voter :voters)
            if (voter.getId().equals(id)) return voter;
        return null;
    }

    @Override
    public List<Voter> findAll() {
        return voters;
    }

    @Override
    public Voter save(Voter voter) {
        voter.setId((AppUtils.generateId()));
        voters.add(voter);

         return voter;
    }

    @Override
    public void deleteById(String id) {
        Voter voter = findById(id);
        if(!(voter== null))voters.remove(voter);
    }
}
