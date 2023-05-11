package africa.semicolon.repositories;


import africa.semicolon.models.Party;
import africa.semicolon.models.UserInformation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class BvasPartyRepositoryTest {
    private final BvasPartyRepository repository = new BvasPartyRepository();
    private Party party;

    private Party savedParty;
    @BeforeEach
    void setUp(){
        party = createParty();
        savedParty = repository.save(party);
    }

    private Party createParty() {
        Party party = Party.builder().userInformation(createUserInformation()).build();
        return party;
    }

    private UserInformation createUserInformation() {
        UserInformation userInformation1 = UserInformation.builder().firstName("jibowu party").build();
        return userInformation1;
    }

    @Test
    void testSaveMethod(){
        Party party1 = repository.save(createParty());
        assertNotNull(party);

        assertEquals("jibowu party", party1.getUserInformation().getFirstName());
    }

    @Test
    void testFindById(){
        Party party1 = repository.save(party);
        assertEquals(party, repository.findById(party1.getId()));
    }
    @Test
    void testSaveMultipleParty(){
        Party secondParty = repository.save(createParty());
        Party thirdParty = repository.save(createParty());
        assertNotNull(secondParty);
        assertNotNull(thirdParty);
        assertEquals(3, repository.findAll().size());
    }
    @Test
    void deleteVoterById(){
        Party secondParty = repository.save(createParty());
        assertEquals(BigInteger.valueOf(2).intValue(), repository.findAll().size());
        repository.deleteById(party.getId());
        assertEquals(1, repository.findAll().size());


    }
}
