-- USERS

INSERT INTO users (email, name, password)
VALUES ('admin@gmail.com', 'Admin', '$2a$12$IKEQb00u5QpZMx4v5zMweu.3wrq0pS7XLCHO4yHZ.BW/yvWu1feo2'); --123
INSERT INTO users (email, name, password)
VALUES ('owner@gmail.com', 'Owner', '$2a$12$IKEQb00u5QpZMx4v5zMweu.3wrq0pS7XLCHO4yHZ.BW/yvWu1feo2'); --123
INSERT INTO users (email, name, password)
VALUES ('customer@gmail.com', 'Customer', '$2a$12$IKEQb00u5QpZMx4v5zMweu.3wrq0pS7XLCHO4yHZ.BW/yvWu1feo2');
--123

-- PROPERTY
INSERT INTO properties (title, description, price, address, city, state, zip_code, listing_type, property_type,
                        property_status, owner_id)
VALUES ('Property 1', 'Awesome', 50000, '1000N', 'fairfield', 'iowa', '52557', 'SALE', 'CONDO', 'UNAVAILABLE', 2);

INSERT INTO properties (title, description, price, address, city, state, zip_code, listing_type, property_type,
                        property_status, owner_id)
VALUES ('Property 2', 'Very Good', 90000, '1000N', 'fairfield', 'iowa', '52557', 'RENT', 'HOUSE', 'AVAILABLE', 2);

INSERT INTO properties (title, description, price, address, city, state, zip_code, listing_type, property_type,
                        property_status, owner_id)
VALUES ('Property 3', 'Excellent', 100000, '1000N', 'fairfield', 'iowa', '52557', 'RENT', 'APARTMENT', 'AVAILABLE', 2);

INSERT INTO properties (title, description, price, address, city, state, zip_code, listing_type, property_type,
                        property_status, owner_id)
VALUES ('Property 4', 'Nice', 200000, '1000N', 'fairfield', 'iowa', '52557', 'RENT', 'APARTMENT', 'PENDING', 2);

INSERT INTO properties (title, description, price, address, city, state, zip_code, listing_type, property_type,
                        property_status, owner_id)
VALUES ('Property 5', 'Beautiful', 200000, '1000N', 'fairfield', 'iowa', '52557', 'RENT', 'APARTMENT', 'CONTINGENT', 2);

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