package ru.kpfu.itis.queries;

public class DeputyQueries {

    // language=SQL
    public static final String SQL_SELECT = "SELECT * FROM deputies;";

    // language=SQL
    public static final String SQL_SELECT_BY_ID = "SELECT * FROM deputies WHERE id = ?;";

    // language=SQL
    public static final String SQL_SELECT_BY_FIRST_NAME = "SELECT * FROM deputies WHERE name = ?;";

    // language=SQL
    public static final String SQL_INSERT = "INSERT INTO deputies (name, photo, date_from, date_to, rooms_number, adults_number, child_number, price) VALUES (?, ?, ?, ?, ?, ?, ?, ?);";

    // language=SQL
    public static final String SQL_UPDATE_BY_ID = "UPDATE deputies SET name = ?, photo = ?, date_from = ?, date_to = ?, rooms_number = ?, adults_number = ?, child_number = ?, price = ? WHERE id = ?;";

    // language=SQL
    public static final String SQL_DELETE_BY_ID = "DELETE FROM deputies WHERE id = ?;";
}
