package africa.semicolon.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class UserInformation {
    private String id;
    private String firstName;
    private String lastName;
    private String password;

}
