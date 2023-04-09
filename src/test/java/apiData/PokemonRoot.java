package apiData;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class PokemonRoot {
    private List<PokemonRootResultsWrapper> results;
}

