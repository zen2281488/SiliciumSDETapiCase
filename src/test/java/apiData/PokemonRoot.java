package apiData;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.qameta.allure.Step;
import lombok.Data;

import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class PokemonRoot {
    private List<PokemonRootResultsWrapper> results;
    private String next;

    @Step("Получение числа limit из url next")
    public static int getLimit(String urlString) throws Exception {
        Map<String, String> params = new HashMap<>();
        for (String param : new URL(urlString).getQuery().split("&")) {
            String[] keyValue = param.split("=");
            params.put(keyValue[0], keyValue.length > 1 ? keyValue[1] : "");
        }
        if (params.containsKey("limit")) {
            return Integer.parseInt(params.get("limit"));
        } else {
            return -1;
        }
    }


}

