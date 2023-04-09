package apiData;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data

public class Pokemon {
    private List<AbilityWrapper> abilities;
    private Integer weight;

}


