package africa.semicolon.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class Address {
    private String houseNumber;
    private String postalCode;
    private String street;
    private String town;
    private String city;
    private String state;
    private String localGovernmentArea;
}
