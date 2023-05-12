INSERT INTO ROLE (name)
VALUES ('ADMIN'), ('USER');

INSERT INTO USER (username, password, role_id)
VALUES ('admin', '$2a$12$Q5wsJdsLVM1QsRR2Y2V6ROQE51OHPs7qPAVI7M0kkgb/QoZJHZ8rq', 1);

-- ADMIN PASSWORD admin1
