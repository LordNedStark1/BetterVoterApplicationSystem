package africa.semicolon.repositories;

import africa.semicolon.models.Party;
import africa.semicolon.utils.AppUtils;

import java.util.ArrayList;
import java.util.List;

public class BvasPartyRepository implements PartyRepository{
    List<Party> parties = new ArrayList<>();

    @Override
    public Party findById(String id) {
        for (Party party :parties)
            if (party.getId().equals(id)) return party;
        return null;
    }

    @Override
    public List<Party> findAll() {
        return parties;
    }
    public Party findByName(String name) {
        return parties.get(0);
    }
    @Override
    public Party save(Party party) {
        party.setId(AppUtils.generateId());
        parties.add(party);
        return party;
    }

    @Override
    public void deleteById(String id) {
        Party party = findById(id);
        parties.remove(party);
    }
}
