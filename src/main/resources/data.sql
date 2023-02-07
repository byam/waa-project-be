-- -- USERS

INSERT INTO users (email, name, password)
VALUES ('admin@gmail.com', 'Admin', '$2a$12$IKEQb00u5QpZMx4v5zMweu.3wrq0pS7XLCHO4yHZ.BW/yvWu1feo2'); --123
INSERT INTO users (email, name, password)
VALUES ('owner@gmail.com', 'Owner', '$2a$12$IKEQb00u5QpZMx4v5zMweu.3wrq0pS7XLCHO4yHZ.BW/yvWu1feo2'); --123
INSERT INTO users (email, name, password)
VALUES ('customer@gmail.com', 'Customer', '$2a$12$IKEQb00u5QpZMx4v5zMweu.3wrq0pS7XLCHO4yHZ.BW/yvWu1feo2');
--123

-- -- ROLES
INSERT INTO roles (role)
VALUES ('ADMIN');
INSERT INTO roles (role)
VALUES ('OWNER');
INSERT INTO roles (role)
VALUES ('CUSTOMER');


INSERT INTO users_roles (user_id, roles_id)
VALUES (1, 1);
INSERT INTO users_roles (user_id, roles_id)
VALUES (2, 2);
INSERT INTO users_roles (user_id, roles_id)
VALUES (3, 3);