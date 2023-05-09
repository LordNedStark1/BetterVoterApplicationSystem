package africa.semicolon.dtos.requests;

import africa.semicolon.models.Address;
import africa.semicolon.models.Gender;
import africa.semicolon.models.UserInformation;
import lombok.Data;

@Data
public class VoterRegistrationRequest {
    private String userName;
    private String password;

    private String name;
    private String city;
    private String houseNumber;
    private String state;

    private String localGovernmentArea;

    private Integer age;
    private String gender;
}
