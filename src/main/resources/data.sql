INSERT INTO ROLE (name)
VALUES ('ADMIN'), ('USER');

INSERT INTO USER (username, password, role_id)
VALUES
    ('admin', '$2a$12$Q5wsJdsLVM1QsRR2Y2V6ROQE51OHPs7qPAVI7M0kkgb/QoZJHZ8rq', 1),
    ('user', '$2a$12$PSQgen0phXxkWxT.FMMjvOUhof5YRQuyWqZLOjMXs9lvWW0xNfhS2', 2);

-- ADMIN PASSWORD admin1
-- USER PASSWORD user1

INSERT INTO product (name, product, valid_from, student, income)
VALUES
    ('Seb Account Max', 'ACCOUNT', 17, true, 0),
    ('Seb Card Mini', 'CARD', 25, false, 1),
    ('Seb Card Max', 'CARD', 30, false, 2);


