# Практикум SDET: API тест PokeAPI
    1.ID: API-POKEAPI №1     

    Пути:
        •Тест класс: src/test/java/cases/TestAPI.java
        •Дессериализация ответа: src/test/java/apiData
        •Методы запроса: src/test/java/utils/ResponseToPokeApi.java
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
    
        Заголовок: Проверка наличия ability run-away у покемона Rattata
        Предусловия: Сформированный шаблон запроса
        Шаги:
            •	Отправить запрос https://pokeapi.co/api/v2/pokemon/rattata и десериализовать ответ.
            •	Отправить запрос https://pokeapi.co/api/v2/pokemon/pidgeotto и десериализовать ответ.
        Ожидаемый результат:
            •       У rattata в одном из элементов адреса rattata[abilities], присутствует [ability][name] равное “run-away”.
        Постусловия:
            •	Успешное завершение теста.

    2.ID: API-POKEAPI №2

        Заголовок: Проверка отсутствия ability run-away у покемона Pidgeotto
        Предусловия: Сформированный шаблон запроса
        Шаги:
            •	Отправить запрос https://pokeapi.co/api/v2/pokemon/pidgeotto и десериализовать ответ.
        Ожидаемый результат:
            •	У pidgeotto  в pidgeotto[abilities], отсутствует  [ability][name] равное “run-away”.
        Постусловия:
            •	Успешное завершение теста.

    3.ID: API-POKEAPI №3   
    
        Заголовок: Сравнение Weight покемонов rattata и pidgeotto
        Предусловия: Сформированный шаблон запроса
        Шаги:
            •	Отправить запрос https://pokeapi.co/api/v2/pokemon/rattata и десериализовать ответ.
            •	Отправить запрос https://pokeapi.co/api/v2/pokemon/pidgeotto и десериализовать ответ.
        Ожидаемый результат:
            •	Выполняется условие rattata[weight] меньше pidgeotto[weight]
        Постусловия:
            •	Успешное завершение теста.

    4.ID: API-POKEAPI №4

        Заголовок: Проверка пагинации коллекции pokemon
        Предусловия: Сформированный шаблон запроса
        Шаги:
            •	Отправить запрос https://pokeapi.co/api/v2/pokemon/ и десериализовать ответ.
        Ожидаемый результат:
            •	Длина элемента pokemon[results] равна заданному значению limit
        Постусловия:
            •	Успешное завершение теста.

    5.ID: API-POKEAPI №5   
    
        Заголовок: Проверка наличия name в коллекции results
        Предусловия: Сформированный шаблон запроса
        Шаги:
            •	Отправить запрос https://pokeapi.co/api/v2/pokemon/ и десериализовать ответ.
        Ожидаемый результат:
            •	Каждый элемент pokemon[results] имеет [name]. [name] не является пустым значением.
        Постусловия:
            •	Успешное завершение теста.




