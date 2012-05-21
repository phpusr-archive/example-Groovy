/**
 * 
 * @author Sergey Doronin
 * Date: 21.05.12
 * Time: 14:50
 */

/**
 * Groovy SQL
 */

//Подключение к базе данных и запрос SELECT(необходимо подключить драйвер JDBC для MySQL или другой базы):

import groovy.sql.Sql
import groovy.sql.DataSet

class User { def username; def age;}

Sql connect() {
    return Sql.newInstance("jdbc:hsqldb:hsql://localhost/testdatabase", "sa", "", "org.hsqldb.jdbcDriver")
}

void createTable(Sql sql) {
    sql.execute("drop table users if exists")
    // создаем таблицу
    sql.execute('''create table users (
        id identity primary key,
        username varchar(255),
        age int
    )''')
}

/* Performing a simple query */
//Вставка новой записи:
void insert(Sql sql) {
    def age = 25
    def name = "Adam"
    sql.execute("insert into users (username, age) values (${name}, ${age})")
    // or
    sql.executeInsert("insert into users (username, age) values (${name}, ${age})")
}

//Выборка первой записи из результата запроса:
void selectFirst(Sql sql) {
    def rowFirst = sql.firstRow('select username, age from users')
    println "Row First: Name = ${rowFirst.username} and Age = ${rowFirst.age}"
}

//Выборка последней записи из результата запроса:
void selectLast(Sql sql) {
    def rowLast = new User()
    sql.eachRow("select * from users"){ row -> rowLast.username = row.username; rowLast.age = row.age; }
    if (rowLast != null) {
        println "Row Last: Name = ${rowLast.username} and Age = ${rowLast.age}"
    }
}

//Выборка всех записей:
void selectAll(Sql sql) {
    println "------------------"
    sql.eachRow("select * from users"){ row -> println "$row.id: $row.username $row.age" }
    println "------------------"
}

//Удаление записи:
void delete(Sql sql) {
    int id = 2
    sql.execute('delete from users where id = ?' , [id])
}

//Обновление записи:
void update(Sql sql) {
    def newUsername = 'New Name'
    int rowsAffected = sql.executeUpdate('update users set username = ? where id=3', [newUsername])
    println "updated: ${rowsAffected}"
}

/* Doing more complex queries */
void usingDataSet(Sql sql) {
    DataSet users
    // таблица users должна быть создана
    users = sql.dataSet("USERS")
    users.add(username: "James", age: 55) //вставка новой записи в таблицу

    DataSet findedUsers = users.findAll() // получение всех записей и их вывод
    findedUsers.each{ println it.username}
}

/* Other Tips */
//Добавление записей в транзакции:
void insertInTransac(Sql sql) {
    DataSet users

    // таблица users должна быть создана
    users = sql.dataSet("USERS")

    sql.withTransaction {
        users.add(username: "Alec", age: 25)
        users.add(username: "Alec 2", age: 25)
    }
}

//Блочное добавление записей:
void blocksAdd(Sql sql) {
    def updateCounts = sql.withBatch('insert into users(username, age) values (?, ?)') { ps ->
        ps.addBatch("New Name", 22)      // varargs style
        ps.addBatch(["New Name", 18])     // list
        ps.addBatch(["New Name", 31])
    }

    println "Update counts: $updateCounts"
}

Sql sql = connect()
//createTable(sql)
insert(sql)
selectFirst(sql)
selectAll(sql)
delete(sql)
update(sql)
selectAll(sql)

usingDataSet(sql);
insertInTransac(sql)
selectAll(sql)
blocksAdd(sql)
selectAll(sql)

selectLast(sql)
