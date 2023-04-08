# Практикум SDET: API тест PokeAPO
    1.ID: API-POKEAPI №1     

    Пути:
        •Тест класс: src/test/java/cases/TestAPI.java
        •Дессериализация ответа: src/test/java/apiData
        •Методы запроса: src/test/java/utils/ResponseToPokeApi.java
        •Кастомный Step для аннотаций: src/test/java/utils/CustomLogStep.java
        •Обработка URL next, для получения limit: src/test/java/apiData/PokemonRoot.java
        •Воркфлоу для github actions: .github/workflows/maven.yml
        •Директория для отчетов Allur: target/allure-results
    
    Зависимости, версии:
        •JVM - 11
        •allure - 2.17.2
        •aspectj - 1.9.6
        •junit4 - 2.17.1
        •rest-assured:5.3.0
        •lombok:1.18.26
        •jackson-databind:2.14.1
    
    
    1.ID: API-POKEAPI №1   
    
        Заголовок: Проверка наличия ability run-away и разницы в weight
        Предусловия: Сформированный шаблон запроса
        Шаги:
            •	Отправить запрос https://pokeapi.co/api/v2/pokemon/rattata и десериализовать ответ.
            •	Отправить запрос https://pokeapi.co/api/v2/pokemon/pidgeotto и десериализовать ответ.
        Ожидаемый результат:
            •       У rattata в одном из элементов адреса rattata[abilities], присутствует [ability][name] равное “run-away”.
            •	У pidgeotto  в rattata[abilities], отсутствует  [ability][name] равное “run-away”.
            •	Выполняется условие rattata[weight] меньше pidgeotto[weight]
        Постусловия:
            •	Успешное завершение теста.

    2.ID: API-POKEAPI №2

        Заголовок: Проверить пагинацию запроса и наличие name в элементах списка покемонов
        Предусловия: Сформированный шаблон запроса
        Шаги:
            •	Отправить запрос https://pokeapi.co/api/v2/pokemon/ и десериализовать ответ.
        Ожидаемый результат:
            •	Длина элемента pokemon[results] равна значению limit в адресе pokemon[next]
            •	Каждый элемент pokemon[results] имеет [name]. [name] не является пустым значением.
        Постусловия:
            •	Успешное завершение теста.



