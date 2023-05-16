package africa.semicolon.services;

import africa.semicolon.dtos.requests.CreateElectionRequest;
import africa.semicolon.dtos.response.CreateElectionResponse;

public interface ElectionService {
    CreateElectionResponse create(CreateElectionRequest createElectionRequest);
}
