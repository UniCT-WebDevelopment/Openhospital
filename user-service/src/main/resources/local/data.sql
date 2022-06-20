--cleaning structure
DROP TABLE IF EXISTS user;
DROP SEQUENCE IF EXISTS sq_user_id;
DROP INDEX IF EXISTS idx_user_id;

-- reimport data
CREATE TABLE IF NOT EXISTS user (
    id INT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    surname VARCHAR(50) NOT NULL,
    email VARCHAR(50) NOT NULL,
    password VARCHAR(512) NOT NULL,
    tax_code VARCHAR(16) NOT NULL,
    country VARCHAR(50) NOT NULL,
    city VARCHAR(50) NOT NULL,
    province VARCHAR(50) NOT NULL,
    post_code VARCHAR(5) NOT NULL,
    address VARCHAR(100) NOT NULL,
    address_number VARCHAR(10) NOT NULL,
    phone VARCHAR(20) NOT NULL,
    consent_1 BOOLEAN NOT NULL DEFAULT TRUE,
    consent_2 BOOLEAN NOT NULL DEFAULT FALSE,
    consent_3 BOOLEAN NOT NULL DEFAULT FALSE,
    insert_timestamp TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    update_timestamp TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    user_type VARCHAR(10) NOT NULL,
    enabled BOOLEAN NOT NULL DEFAULT TRUE
);
CREATE UNIQUE INDEX IF NOT EXISTS idx_user_id ON user (email);
CREATE SEQUENCE IF NOT EXISTS sq_user_id;
INSERT INTO user (id, name, surname, email, password, tax_code, country, city, province, post_code, address, address_number, phone, user_type)
        VALUES (sq_user_id.nextval, 'Giuseppe', 'Rossi', 'giuseppe.rossi@openhospital.com', '$2a$10$X.IcOdZG0wozU1HpDKSVIeDNb1CdSgTEY663nSCtaaBc7V0R3D6NO', 'GSPRSS97D02C351H', 'IT', 'Test', 'KK', '25100', 'Via di Test', '5', '+393332211555', 'USER');
INSERT INTO user (id, name, surname, email, password, tax_code, country, city, province, post_code, address, address_number, phone, user_type)
        VALUES (sq_user_id.nextval, 'Roberto', 'Rossi', 'roberto.rossi@openhospital.com', '$2a$10$uvztdowqrLIiLiIeCVpFnO3M3i3TRszxXt2Ljsmq66y78l9LzBI3S', 'RBRRSS97D02C351O', 'IT', 'Test', 'KK', '05100', 'Via di Test', '3',  '+393332211555', 'USER');
