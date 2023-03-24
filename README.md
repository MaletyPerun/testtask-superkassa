### Тестовое задание на чтение JSON файла и с БД

---

### ТЗ:
Предварительные условия:
Предзаполненная таблица в базе данных postgres. Имя пользователя и название таблицы должно точно соответствовать указанным.

    dropdb --if-exists sk_example_db
    dropuser --if-exists sk_example_user
    createuser sk_example_user -P
    createdb -O sk_example_user sk_example_db
    psql -U sk_example_user -d sk_example_db <<EOF
    CREATE TABLE sk_example_table (id SERIAL, obj JSONB NOT NULL, PRIMARY KEY(id));
    INSERT INTO sk_example_table (obj) VALUES ('{"current":0}'::JSONB);
    EOF

Условие задачи:
Spring приложение с обработкой POST запроса по урлу /modify

Запрос удовлетворяет JSON схеме:

    {
        "id": <number>,
        "add": <number>
    }

Ответ удовлетворяет JSON схеме:

    {
        "current": <number>
    }

В процессе обработки необходимо атомарно увеличить на величину add значение поля current столбца obj строки идентифицируемой id в таблице sk_example_table, и вернуть полученое значение через API.

В случае невозможности провести операцию, вернуть http статус 418.

---

Применен MVC-паттерн проектирования. Используется БД Postgres, REST API с одним POST-методом.  

При разработке использовалась ОС MacOS:
macOS Big Sur, версия 11.7.2
Intel Core i5 1,3 GHz
RAM 4 Gb

--- 

Для запуска программы необходимо скачать проект, в папке проекта через консоль выполнить команды:

- для Unix: `./mvnw clean install`
- для Windows: `mvnw.cmd clean install`
- далее:
  `java -jar target/testtask-superkassa-0.0.1-SNAPSHOT.jar`

--- 

API:

#### получить обновленное значение
`curl --location --request POST 'http://localhost:8080/modify' \
--header 'Content-Type: application/json' \
--data-raw '{
"id": <number>,
"add": <number>
}'`
