package africa.semicolon.services;

import africa.semicolon.dtos.requests.VoterRegistrationRequest;
import africa.semicolon.dtos.response.VoterRegistrationResponse;
import africa.semicolon.exceptions.VoterRegistrationException;
import africa.semicolon.models.Voter;
import africa.semicolon.repositories.BvasVotersRepository;
import africa.semicolon.repositories.VoterRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BvasServiceTest {
    private final VoterServiceInterface voterServiceInterface = new BvasVoterService();
    private final VoterRepository voterRepository = new BvasVotersRepository();
    private VoterRegistrationRequest voterRegistrationRequest ;
    @BeforeEach
    void setUp(){
        voterRegistrationRequest = mapper();


    }
    private VoterRegistrationRequest mapper() {
        VoterRegistrationRequest voterRegistrationRequest = new VoterRegistrationRequest();
        voterRegistrationRequest.setAge(24);
        voterRegistrationRequest.setCity("sample");
        voterRegistrationRequest.setFirstName("Sherrif");
        voterRegistrationRequest.setGender("male");
        voterRegistrationRequest.setLocalGovernmentArea("sabo");
        voterRegistrationRequest.setHouseNumber("1234");
        voterRegistrationRequest.setPassword("Password1@");

        return voterRegistrationRequest;
    }


    @Test
    void testVoterCanRegister(){
        VoterRegistrationResponse voterRegistrationResponse = null;
        try {
            voterRegistrationResponse = voterServiceInterface.voterRegistration(voterRegistrationRequest);
            assertNotNull(voterRegistrationResponse);
            assertNotNull(voterRegistrationResponse.getVoterIdentificationNumber());
        } catch (VoterRegistrationException e) {
            throw new RuntimeException(e);
        }

    }
    @Test
    void getAllVoters() throws VoterRegistrationException {

        var response =  voterServiceInterface.voterRegistration(voterRegistrationRequest);
        assertNotNull(response);

        List<Voter> voters = voterServiceInterface.getAllVoters();
        assertEquals(1, voters.size());
    }
    @Test
    void testFindUserById() throws VoterRegistrationException {
        var registrationResponse = voterServiceInterface.voterRegistration(voterRegistrationRequest);
        var voters = voterServiceInterface.getAllVoters();
        Voter lastRegisteredVoter = voters.get(voters.size() - 1);
        Voter foundVoter = voterServiceInterface.getUserById(lastRegisteredVoter.getId());
        assertNotNull(foundVoter);
        assertEquals(voterRegistrationRequest.getFirstName() , foundVoter.getUserInformation().getFirstName());
    }
    @Test
    void deleteVoterTest() throws VoterRegistrationException {
        voterServiceInterface.voterRegistration(voterRegistrationRequest);
        var voters = voterServiceInterface.getAllVoters();
        assertEquals(1, voters.size());

        Voter lastRegisteredVoter = voters.get(voters.size() - 1);
        Voter foundVoter = voterServiceInterface.getUserById(lastRegisteredVoter.getId());
        var response = voterServiceInterface.deleteVoter(foundVoter.getId());
        Voter deletedVoter = voterServiceInterface.getUserById(lastRegisteredVoter.getId());

        assertEquals("Voter Deleted", response.getMessage());

        assertNull(deletedVoter );
        assertEquals(0, voterServiceInterface.getAllVoters().size());

    }
}
