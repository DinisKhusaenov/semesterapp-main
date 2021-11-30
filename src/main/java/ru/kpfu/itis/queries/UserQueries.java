package ru.kpfu.itis.queries;

public class UserQueries {
    // language=SQL
    public static final String SQL_SELECT = "SELECT * FROM users;";

    // language=SQL
    public static final String SQL_SELECT_BY_ID = "SELECT * FROM users WHERE id = ?;";

    // language=SQL
    public static final String SQL_SELECT_BY_EMAIL = "SELECT * FROM users WHERE email = ?;";


    // language=SQL
    public static final String SQL_INSERT = "INSERT INTO users (first_name, last_name, email, hash_password) VALUES (?, ?, ?, ?);";

    //language=SQL
    public static final String SQL_UPDATE_DEPUTIESID_BY_ID = "UPDATE users SET deputies_id = ? WHERE id = ?";

    // language=SQL
    public static final String SQL_UPDATE_BY_ID = "UPDATE users SET first_name = ?, last_name = ?, email = ?, deputies_id = ? WHERE id = ?;";

    // language=SQL
    public static final String SQL_UPDATE_BY_EMAIL = "UPDATE users SET first_name = ?, last_name = ?, email = ? WHERE email = ?;";

    // language=SQL
    public static final String SQL_DELETE_BY_ID = "DELETE FROM  users WHERE id = ?;";

    // language=SQL
    public static final String SQL_DELETE_BY_EMAIL = "DELETE FROM users WHERE email = ?;";
}
