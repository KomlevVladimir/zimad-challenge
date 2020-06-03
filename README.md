## Чеклист тестирования функции Create a new task

1. #### Создание задачи в проект inbox с валидными данными полей:
   - <b>content</b> – строка, содержащая буквы, цифры, пробелы, спец. символы
   - <b>project_id</b> – 0
   - <b>section_id</b> – 0
   - <b>parent</b> – 0
   - <b>order</b> – число типа Integer
   - <b>label_ids</b> – пустой массив
   - <b>priority</b> – от 1 до 4 включительно
   
2. #### Проверка поля content. Создание задачи с валидными данными, поле content:
   - пустая строка
   - пробел или несколько пробелов
   - строка с кол-вом символов более, чем максимально допустимое
   - обязательное поле content отсутствует в теле запроса
   - значение отличное от строки, например, число
   - создаем две задачи с одинаковыми значениями поля content
   - на разных языках
   
3. #### Проверка поля project_id. Создание задачи с валидными данными, поле project_id следующие значения:
   - id существующего, заранее созданного проекта
   - id не существующего проекта
   - id существующего проекта, но удаленного
   - необязательное поле project_id отсутствует в теле запроса
   - id отличное от числа, например, строка
   - id существующего, заранее созданного проекта, но отрицательное значение
   
4. #### Проверка поля section_id. Создание задачи, поле section_id следующие значения:
   - id существующей, заранее созданного раздела
   - id несуществующего раздела
   - значение project_id cуществующего заранее созданного проекта, а значение section_id – значение существующего раздела, но созданного в другом проекте
   - id удаленного раздела
   - необязательно поле section_id отсутствует
   - отрицательно значение
   - id отличное от числа, например, строка

5. #### Проверка поля parent. Создание задачи, поле parent следующие значения:
   - id существующей заранее созданной задачи
   - id несуществующей задачи
   - id удаленной задачи
   - необязательное поле отсутствует
   - отрицательное значение
   - id существующей заранее созданной задачи, project_id другого проекта, где нет этой задачи
   - id существующей заранее созданной задачи, section_id другого проекта, где нет этой задачи
   - id отличное от числа, например, строка
   
6. #### Проверка поля order. Cоздание задачи, поле order следующие значения:
   - положительное целое число в диапазоне типа Integer
   - положительное целое число за пределами типа Integer
   - отрицательно число
   - число с плавающей точкой
   - создание двух задач с одинаковым значением order в одном разделе или проекте
   - необязательное поле отсутствует
   - 0
   
7. #### Проверка поля label_ids. Создание задачи со значениями поля label_ids:
   - массив существующих заранее созданных меток
   - массив не существующих меток
   - массив с одной существующей и одной не существующей меткой
   - массив значений, отличных от Integer
   - массив состоящий из id удаленной метки
   - пустой массив
   - необязательное поле отсутствует
   
8. #### Проверка поля priority. Создание задачи со значениями поля priority:
   - 1
   - 4
   - 0
   - 5
   - необязательное поле отсутствует
   
9. #### Проверка поля due_string. Создание задачи со значениями поля  due_string:
   - строка, содержащая буквы, цифры, пробелы, спец. Символы
   - пустая строка
   - пробел или несколько пробелов
   - строка с кол-вом символов более, чем максимально допустимое
   - валидное значение due_string, но в теле запроса передаем также валидное значение поля due_date
   -  валидное значение due_string, но в теле запроса передаем также валидное значение поля due_datetime
   - необязательное поле отсутствует
   - строка не на английском языке, в теле запроса передаем due_lang валидный буквенный код этого языка
   - строка не на английском языке, в теле запроса due_lang не передаем
   - строка не на английском языке, в теле запроса передаем значение due_lang буквенный код, не соответствующий языку
   - строка на неподдерживаемых языках
   - значение, отличное от строки
   
10. #### Проверка поля due_date.  Создание задачи со значениями поля due_date:
   - будущая дата в формате YYYY-MM-DD
   - будущая дата в формате, отличном от YYYY-MM-DD
   - прошлая дата в формате YYYY-MM-DD
   - будущая дата в формате YYYY-MM-DD,  но в теле запроса передаем также валидное значение поля due_datetime
   - необязательное поле отсутствует
   -  будущая дату в формате YYYY-MM-DD,  но в теле запроса передаем также валидное значение поля due_string
   - пустая строка
   
11. #### Проверка поля due_datetime.  Создание задачи со значениями поля due_datetime:
   - будущая дата в формате RFC3339
   - прошлая дата в формате RFC3339
   - дата в будущем, отличная от формата RFC3339
   - необязательное поле отсутствует
   - будущая дата в формате RFC3339, но в теле запроса передаем также валидное значение поля due_string
   - будущая дата в формате RFC3339, но в теле запроса передаем также валидное значение поля due_date
   - пустая строка
   
12. #### Проверка поля due_lang. Создание задачи со значениями поля  due_lang:
   - необязательное поле отсутствует
   - валидное значение, но поле due_string отсутствует
   
13. #### Проверка well formed json. Отправляем запросы с невалидным форматом json в теле, например, убираем зяпятые, вместо { ставим [, изменяем значения ключей полей и тд.

14. #### Проверяем регистронезависимость ключей полей тела запроса.

15. #### Изменяем последовательность полей в теле запроса.

16. #### Создание задачи с валидными данными, но в заголовки передаем невалидный токен авторизации.

17. #### Создание двух задач, в запрос передаем заголовки с ключем X-Request-Id и одинаковыми значениями

18. ####Создание двух задач, в запрос передаем заголовки с ключем X-Request-Id и разными значениями

19. #### Пробуем создавать задачу, не передавая никаких заголовков

20. #### Проверяем, что все ключи и значения заголовков регистронезависимые

## При тестировании необходимо валидировать:
   - код ответа
   - тело ответа
   - заголовки ответа
   - бизнес логику (задача успешно создаётся именно с теми данными, которые передаём в запрос)
   - обработка ошибок и понятные сообщения об ошибках
