package ru.kpfu.itis.queries;

public class NewsQueries {

    // language=SQL
    public static final String SQL_SELECT = "SELECT * FROM news;";

    // language=SQL
    public static final String SQL_SELECT_BY_ID = "SELECT * FROM news WHERE id = ?;";

    // language=SQL
    public static final String SQL_SELECT_BY_TAG =
            "WITH _title_tag_id AS (\n" +
                    "    SELECT nh.id, nh.title, nh.description, nh.photo, nt.tag_id\n" +
                    "    FROM news nh\n" +
                    "             LEFT JOIN news_tag nt on nh.id = nt.news_id)\n" +
                    "SELECT _title_tag_id.id, _title_tag_id.title, _title_tag_id.description, _title_tag_id.photo\n" +
                    "FROM _title_tag_id\n" +
                    "         INNER JOIN tag_news th ON th.id = _title_tag_id.tag_id\n" +
                    "WHERE name = ?;";

    // language=SQL
    public static final String SQL_INSERT = "INSERT INTO news (title, description, photo) VALUES (?, ?, ?);";

    // language=SQL
    public static final String SQL_UPDATE_BY_ID = "UPDATE news SET title = ?, description = ?, photo = ? WHERE id = ?;";

    // language=SQL
    public static final String SQL_DELETE_BY_ID = "DELETE FROM news WHERE id = ?;";
}
