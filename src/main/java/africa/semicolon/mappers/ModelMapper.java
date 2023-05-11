package africa.semicolon.mappers;

import africa.semicolon.dtos.requests.VoterRegistrationRequest;
import africa.semicolon.dtos.response.VoterRegistrationResponse;
import africa.semicolon.models.Address;
import africa.semicolon.models.Gender;
import africa.semicolon.models.UserInformation;
import africa.semicolon.models.Voter;
import africa.semicolon.utils.IdGenerator;

public class ModelMapper {
    public static VoterRegistrationResponse mapVoterRequestToVoter(Voter voter){
      VoterRegistrationResponse voterRegistrationResponse  = new VoterRegistrationResponse();
        voterRegistrationResponse.setMessage("Registration Successful. Your Vote Counts");
        voterRegistrationResponse.setVoterIdentificationNumber(voter.getVoterIdentificationNumber());

        return voterRegistrationResponse;
    }
    public static Voter mapVoterRequestToVoter(VoterRegistrationRequest voterRegistrationRequest){
        Voter voter = new Voter();
        voter.setAge(voterRegistrationRequest.getAge());

        Gender gender = Gender.valueOf(voterRegistrationRequest.getGender().toUpperCase());
        voter.setGender(gender);

        Address address = mapAddress(voterRegistrationRequest);

        voter.setAddress(address);

        UserInformation userInformation = mapUSerInformation(voterRegistrationRequest);

        voter.setUserInformation(userInformation);

        String vin = IdGenerator.generateVoterIdentificationNumber();
        voter.setVoterIdentificationNumber(vin);


        return voter;
    }

    private static UserInformation mapUSerInformation(VoterRegistrationRequest voterRegistrationRequest) {
        UserInformation userInformation = new UserInformation();
        userInformation.setFirstName(voterRegistrationRequest.getFirstName());
        userInformation.setLastName(voterRegistrationRequest.getLastName());
        userInformation.setPassword(voterRegistrationRequest.getPassword());
        return userInformation;
    }

    private static Address mapAddress(VoterRegistrationRequest voterRegistrationRequest) {
        return Address.builder().street(voterRegistrationRequest.getStreet())
                .localGovernmentArea(voterRegistrationRequest.getLocalGovernmentArea())
                .city(voterRegistrationRequest.getCity())
                .state(voterRegistrationRequest.getState())
                .postalCode(voterRegistrationRequest.getPostalCode())
                .town(voterRegistrationRequest.getTown())
                .houseNumber(voterRegistrationRequest.getHouseNumber())
                .build();
    }

}
