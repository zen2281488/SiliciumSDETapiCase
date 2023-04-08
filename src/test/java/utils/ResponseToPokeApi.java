package utils;

import apiData.Pokemon;
import apiData.PokemonRoot;
import io.qameta.allure.Step;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;

public class ResponseToPokeApi {
    private static final ThreadLocal<Pokemon> rattata = new ThreadLocal<>();
    private static final ThreadLocal<Pokemon> pidgeotto = new ThreadLocal<>();
    private static final ThreadLocal<PokemonRoot> pokemonRoot = new ThreadLocal<>();

    static {
        RestAssured.filters(new AllureRestAssured());
        RestAssured.baseURI = "https://pokeapi.co/api/v2/";
    }

    @Step("Запрос данных о покемоне Rattata.")
    public static Pokemon getRattataData() {
        rattata.set(
                given()
                        .contentType(ContentType.JSON)
                        .when()
                        .get("pokemon/rattata")
                        .then()
                        .statusCode(200)
                        .extract()
                        .as(Pokemon.class));

        return rattata.get();
    }

    @Step("Запрос данных о покемоне Pidgeotto.")
    public static Pokemon getPidgeottoData() {
        pidgeotto.set(
                given()
                        .contentType(ContentType.JSON)
                        .when()
                        .get("pokemon/pidgeotto")
                        .then()
                        .statusCode(200)
                        .extract()
                        .as(Pokemon.class));
        return pidgeotto.get();
    }

    @Step("Запрос данных коллекции покемонов.")
    public static PokemonRoot getPokemonRootData() {
        pokemonRoot.set(
                given()
                        .contentType(ContentType.JSON)
                        .when()
                        .get("pokemon")
                        .then()
                        .statusCode(200)
                        .extract()
                        .as(PokemonRoot.class));
        return pokemonRoot.get();
    }
}