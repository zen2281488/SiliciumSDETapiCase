# Практикум SDET: задание API
    1.ID: API-POKEAPI №1     

    Заголовок: Проверка наличия ability run-away и разницы в weight
    Предусловия: Сформированный шаблон запроса
    Шаги:
        •	Отправить запрос https://pokeapi.co/api/v2/pokemon/rattata и сохранить результат
        •	Отправить запрос https://pokeapi.co/api/v2/pokemon/pidgeotto и сохранить результат
    Ожидаемый результат:
        •	В результате запроса,у rattata и pidgeotto  в одном из элементов адреса rattata[abilities], присутствует [ability][name] равное “run-away”. А у pidgeotto, по тому же адресу среди всех элементов rattata[abilities]  эта [ability][name] отсутствует
        •	Выполняется условие rattata[weight] меньше pidgeotto[weight]
    Постусловия:
        •	Очистить результаты запроса.
    Статус:
        •	Success

    2.ID: API-POKEAPI №2

    Заголовок: Проверить пагинацию запроса и наличие name в элементах списка покемонов
    Предусловия: Сформированный шаблон запроса
    Шаги:
        •	Отправить запрос https://pokeapi.co/api/v2/pokemon/ и сохранить результат
    Ожидаемый результат:
        •	pokemon[count] больше длины элемента pokemon[results]
        •	Длина элемента pokemon[results] равна значению limit в адресе pokemon[next]
        •	Каждый элемент pokemon[results] имеет [name]. [name] не является пустым значением.
    Постусловия:
        •	Очистить результаты запроса.
    Статус:
        •	Success



