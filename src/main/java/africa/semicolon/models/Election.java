package africa.semicolon.models;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
public class Election {
    private String id;
    private LocalDate date;
    private Category category;
    private List<String> localGovernmentArea;
    private List<String> parties;
}
