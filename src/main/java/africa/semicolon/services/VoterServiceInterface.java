package africa.semicolon.services;

import africa.semicolon.dtos.requests.VoterRegistrationRequest;
import africa.semicolon.dtos.response.VoterRegistrationResponse;

public interface VoterServiceInterface {
    public VoterRegistrationResponse voterRegistration (VoterRegistrationRequest voterRegistrationRequest);
}
