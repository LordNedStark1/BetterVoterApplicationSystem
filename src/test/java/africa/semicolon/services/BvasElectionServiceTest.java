package africa.semicolon.services;

import africa.semicolon.dtos.requests.CreateElectionRequest;
import africa.semicolon.dtos.response.CreateElectionResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BvasElectionServiceTest {
    private final ElectionService electionService =new BvasElectionService();
    @BeforeEach
    void setUp(){

    }
    @Test
    void createElectionTest(){
        CreateElectionRequest createElectionRequest = new CreateElectionRequest();
        createElectionRequest.setElectionDate("2023- 02 -25");
        createElectionRequest.setElectionCategory("Gubernatorial");
        List<String> parties = getProperties("PDP", "APC", "Lp");

        createElectionRequest.setParties(parties);
        List<String> states = getProperties("Lagos", "Kogi", "Kano");

        createElectionRequest.setState(states);

        CreateElectionResponse createElectionResponse =
                electionService.create(createElectionRequest);

        assertNotNull(createElectionResponse);

    }

    private static List<String> getProperties(String ...prop) {
        List<String > properties = new ArrayList<String>();
        for (int i = 0; i < prop.length; i++) {
            properties.add(prop[i]);
        }

        return properties;
    }

}