package africa.semicolon.dtos.requests;

import africa.semicolon.models.Party;
import lombok.Data;

import java.util.List;

@Data
public class CreateElectionRequest {
    private String electionDate;
    private String electionCategory;
    private List<String> parties;
    private List<String> state;
    private List<String> localGovernment;
}
