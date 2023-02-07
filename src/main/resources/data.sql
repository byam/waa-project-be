-- PROPERTY
INSERT INTO PROPERTY (id, name)
VALUES (11, 'property1'),
       (12, 'property2');


-- USERS

INSERT INTO users (id, email, name, password)
VALUES (1, 'admin@gmail.om', 'Admin', '$2a$12$IKEQb00u5QpZMx4v5zMweu.3wrq0pS7XLCHO4yHZ.BW/yvWu1feo2'); --123
INSERT INTO users (id, email, name, password)
VALUES (2, 'owner@gmail.com', 'Owner', '$2a$12$IKEQb00u5QpZMx4v5zMweu.3wrq0pS7XLCHO4yHZ.BW/yvWu1feo2'); --123
INSERT INTO users (id, email, name, password)
VALUES (3, 'customer@gmail.com', 'Customer', '$2a$12$IKEQb00u5QpZMx4v5zMweu.3wrq0pS7XLCHO4yHZ.BW/yvWu1feo2');
--123

-- ROLES
INSERT INTO roles (id, role)
VALUES (1, 'ADMIN');
INSERT INTO roles (id, role)
VALUES (2, 'OWNER');
INSERT INTO roles (id, role)
VALUES (3, 'CUSTOMER');


INSERT INTO users_roles (user_id, roles_id)
VALUES (1, 1);
INSERT INTO users_roles (user_id, roles_id)
VALUES (2, 2);
INSERT INTO users_roles (user_id, roles_id)
VALUES (3, 3);