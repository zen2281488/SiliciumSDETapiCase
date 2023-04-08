package cases;

import apiData.Pokemon;
import apiData.PokemonRoot;
import io.qameta.allure.Issue;
import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import utils.CustomLogStep;
import utils.ResponseToPokeApi;

import java.util.Objects;

public class TestAPI {


    @Test
    @Issue("API-POKEAPI-001")
    @DisplayName("Проверка наличия у Rattata способности run-away, а у Pidgeotto её отсутствия, а так же того что weight Rattata меньше чем у Pidgeotto.")
    public void testPokeApi001() {
        Pokemon rattataData = ResponseToPokeApi.getRattataData();
        Pokemon pidgeottoData = ResponseToPokeApi.getPidgeottoData();
        CustomLogStep.logStep("Начинается проверка наличия у Rattata способности Run-away.");
        Assert.assertTrue(
                rattataData
                        .getAbilities()
                        .stream()
                        .anyMatch(x -> Objects.equals(x.getAbility().getName(), "run-away")));
        CustomLogStep.logStep("Начинается проверка на отсутствие у Pidgeotto способности Run-away.");
        Assert.assertFalse(
                pidgeottoData
                        .getAbilities()
                        .stream()
                        .anyMatch(x -> Objects.equals(x.getAbility().getName(), "run-away")));
        CustomLogStep.logStep("Начинается проверка условия: Weight Pidgeotto больше чем у Rattata.");
        Assert.assertTrue(
                rattataData.getWeight() < pidgeottoData.getWeight());

    }


    @Test
    @Issue("API-POKEAPI-002")
    @DisplayName("Проверка пагинации. Проверка наличия Имен в коллекции results")
    public void testPokeApi002() throws Exception {
        PokemonRoot pokemonRootResponse = ResponseToPokeApi.getPokemonRootData();
        CustomLogStep.logStep("Начинается проверка условия: число limit равно длине коллекции results");
        Assert.assertEquals(PokemonRoot.getLimit(pokemonRootResponse.getNext()), pokemonRootResponse.getResults().size());
        CustomLogStep.logStep("Начинается проверка наличия в коллекции results, name покемонов.");
        Assert.assertTrue(pokemonRootResponse.getResults().stream().allMatch(x -> Objects.nonNull(x.getName())));

    }

    @After
    @Step("Тест завершен.")
    public void after() {
    }
}