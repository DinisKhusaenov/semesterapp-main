CREATE TABLE users
(
    id            BIGSERIAL PRIMARY KEY,
    first_name    VARCHAR(30),
    last_name     VARCHAR(30),
    email         VARCHAR(30),
    hash_password VARCHAR(100),
    deputies_id   INTEGER
);



CREATE TABLE deputies
(
    id         BIGSERIAL PRIMARY KEY,
    first_name VARCHAR(30),
    last_name  VARCHAR(30),
    age        INTEGER,
    photo      VARCHAR(500),
    vote       REAL,
    fraction   VARCHAR(50),
    title      VARCHAR (500)
);

INSERT into deputies
values
       (1, 'Хизри', 'Абакаров', 63, '/static/img/deputy/deputy-1.jpg', 3.1, 'Единая Россия',
        'Комитет Государственной Думы по малому и среднему предпринимательству (член комитета)'),
       (2, 'Михаил', 'Авдеев', 34, '/static/img/deputy/deputy-2.jpg', 5.3, 'КПРФ',
        'Комитет Государственной Думы по малому и среднему предпринимательству (член комитета)'),
       (3, 'Сардана', 'Авксентьева', 36, '/static/img/deputy/deputy-3.jpg', 7.2, 'Новые Люди',
        'Комитет Государственной Думы по малому и среднему предпринимательству (член комитета)'),
       (4, 'Бекхан', 'Агаев', 24, '/static/img/deputy/deputy-4.jpg', 2.3, 'Единая Россия',
        'Комитет Государственной Думы по малому и среднему предпринимательству (член комитета)'),
       (5, 'Рахим', 'Азимов', 34, '/static/img/deputy/deputy-5.jpg', 10.3, 'Единая Россия',
        'Комитет Государственной Думы по малому и среднему предпринимательству (член комитета)'),
       (6, 'Эльвира', 'Аиткулова', 39, '/static/img/deputy/deputy-6.jpg', 11.3, 'КПРФ',
        'Комитет Государственной Думы по малому и среднему предпринимательству (член комитета)');

CREATE TABLE tag_news
(
    id   BIGSERIAL PRIMARY KEY,
    name VARCHAR(30)
);

INSERT into tag_news
VALUES (1, 'Вбросы'),
       (2, 'ЦИК'),
       (3, 'События'),
       (4, 'Голосование'),
       (5, 'Праздники'),
       (6, 'Новости'),
       (7, 'Без рубрики');

CREATE TABLE news
(
   id          BIGSERIAL PRIMARY KEY,
   title       VARCHAR(100),
   description VARCHAR(500),
   photo       VARCHAR(500)
);

INSERT INTO news
values (1, 'В Харькове проходят выборы мэра', '..........', '/static/img/blog/news-1.jpg'),
       (2, 'В Северной Македонии началось голосование во втором..', '..........', '/static/img/blog/news-2.jpg'),
       (3, 'В Узбекистане завершилось голосование на выборах президента', '..........', '/static/img/blog/news-3.jpg');

CREATE TABLE news_tag
(
    news_id BIGINT REFERENCES news (id),
    tag_id  BIGINT REFERENCES tag_news (id),
    CONSTRAINT news_tag_pkey PRIMARY KEY (news_id, tag_id)
);

INSERT INTO news_tag
VALUES (1, 3),
       (1, 4),
       (2, 2),
       (2, 3),
       (2, 6),
       (3, 1),
       (3, 2),
       (3, 6);

CREATE TABLE auth (
    id bigserial primary key,
    user_id bigint,
    cookie_value varchar(255),
    foreign key (user_id) references users(id)
)



