package africa.semicolon.services;

import africa.semicolon.dtos.requests.VoterRegistrationRequest;
import africa.semicolon.dtos.response.DeleteVoterResponse;
import africa.semicolon.dtos.response.VoterRegistrationResponse;
import africa.semicolon.exceptions.VoterRegistrationException;
import africa.semicolon.mappers.ModelMapper;
import africa.semicolon.models.Voter;
import africa.semicolon.repositories.BvasVotersRepository;
import africa.semicolon.repositories.VoterRepository;

import java.util.List;


public class BvasVoterService implements VoterServiceInterface{
    private final VoterRepository voterRepository = new BvasVotersRepository();

    public VoterRegistrationResponse voterRegistration (VoterRegistrationRequest voterRegistrationRequest) throws VoterRegistrationException {
        Voter voter = ModelMapper.mapVoterRequestToVoter(voterRegistrationRequest);

        Voter savedVoter = voterRepository.save(voter);

        if (savedVoter == null) throw new VoterRegistrationException("Voter Registration failed");

        VoterRegistrationResponse voterRegistrationResponse = ModelMapper.mapVoterRequestToVoter(voter);

        return voterRegistrationResponse;
    }

    @Override
    public Voter getUserById(String id) {
        return voterRepository.findById(id);
    }

    @Override
    public List<Voter> getAllVoters() {
        return voterRepository.findAll();
    }

    @Override
    public DeleteVoterResponse deleteVoter(String voterId) {
         voterRepository.deleteById(voterId);

         return DeleteVoterResponse.builder().message("Voter Deleted").build();
    }

}
