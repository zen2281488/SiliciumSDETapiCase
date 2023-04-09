package cases;

import io.qameta.allure.Epic;
import io.qameta.allure.Issue;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import utils.ConfProperties;
import utils.ResponseToPokeApi;

import java.util.Objects;

import static java.lang.Integer.parseInt;

public class TestAPI {

    @Epic("АПИ тесты коллекции конкретных покемонов.")
    @Test
    @Issue("API-POKEAPI-001")
    @DisplayName("Проверка наличия у Rattata способности Run-away.")
    public void testPokeApi001() {
        Assert
                .assertTrue(
                        ResponseToPokeApi
                                .getRattataData()
                                .getAbilities()
                                .stream()
                                .anyMatch(x -> Objects.equals(x.getAbility().getName(), "run-away")));

    }

    @Epic("АПИ тесты коллекции конкретных покемонов.")
    @Test
    @Issue("API-POKEAPI-002")
    @DisplayName("Проверка отсутствия у Pidgeotto способности Run-away.")
    public void testPokeApi002() {
        Assert
                .assertFalse(
                        ResponseToPokeApi
                                .getPidgeottoData()
                                .getAbilities()
                                .stream()
                                .anyMatch(x -> Objects.equals(x.getAbility().getName(), "run-away")));
    }

    @Epic("АПИ тесты коллекции конкретных покемонов.")
    @Test
    @Issue("API-POKEAPI-003")
    @DisplayName("Проверка условия: rattata[weight] меньше pidgeotto[weight].")
    public void testPokeApi003() {
        Assert
                .assertTrue(
                        ResponseToPokeApi.getRattataData().getWeight() < ResponseToPokeApi.getPidgeottoData().getWeight()
                );
    }

    @Epic("Апи тесты общей коллекции покемонов.")
    @Test
    @Issue("API-POKEAPI-004")
    @DisplayName("Проверка пагинации коллекции.")
    public void testPokeApi004() {
        Assert.
                assertEquals(
                        parseInt(ConfProperties.getProperty("limit")), ResponseToPokeApi.getPokemonRootData().getResults().size());
    }

    @Epic("Апи тесты общей коллекции покемонов.")
    @Test
    @Issue("API-POKEAPI-005")
    @DisplayName("Проверка наличия Имен в коллекции results")
    public void testPokeApi005() {
        Assert
                .assertTrue(
                        ResponseToPokeApi.getPokemonRootData().getResults().stream().allMatch(x -> Objects.nonNull(x.getName())));
    }

}