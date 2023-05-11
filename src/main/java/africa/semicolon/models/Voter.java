package africa.semicolon.models;

import lombok.AllArgsConstructor;
import lombok.Builder;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class Voter {
    private String id;
    private UserInformation userInformation;
    private String voterIdentificationNumber;
    private Address address;
    private Integer age;
    private Gender gender;
}
