package africa.semicolon.services;

import africa.semicolon.dtos.requests.VoterRegistrationRequest;
import africa.semicolon.dtos.response.DeleteVoterResponse;
import africa.semicolon.dtos.response.VoterRegistrationResponse;
import africa.semicolon.exceptions.VoterRegistrationException;
import africa.semicolon.models.Voter;

import java.util.List;

public interface VoterServiceInterface {
    public VoterRegistrationResponse voterRegistration (VoterRegistrationRequest voterRegistrationRequest) throws VoterRegistrationException;

    Voter getUserById(String s);

    List<Voter> getAllVoters();

    DeleteVoterResponse deleteVoter(String voterId);
}
