package africa.semicolon.services;

import africa.semicolon.dtos.requests.VoterRegistrationRequest;
import africa.semicolon.dtos.response.VoterRegistrationResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class BvasServiceTest {
    private final VoterServiceInterface voterServiceInterface = new BvasVoterService();
    @BeforeEach
    void setUp(){

    }

    private VoterRegistrationRequest mapper() {
        VoterRegistrationRequest voterRegistrationRequest = new VoterRegistrationRequest();
        voterRegistrationRequest.setAge(24);
        voterRegistrationRequest.setCity("sample");
        voterRegistrationRequest.setName("Sherrif");
        voterRegistrationRequest.setGender("male");
        voterRegistrationRequest.setLocalGovernmentArea("sabo");
        voterRegistrationRequest.setHouseNumber("1234");
        voterRegistrationRequest.setPassword("Password1@");

        return voterRegistrationRequest;
    }

    @Test
    void testVoterCanRegister(){
        VoterRegistrationRequest voterRegistrationRequest = mapper();
        VoterRegistrationResponse voterRegistrationResponse = voterServiceInterface.voterRegistration(voterRegistrationRequest);
        assertNotNull(voterRegistrationResponse.getVoterIdentificationNumber());

    }
}
