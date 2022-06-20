--cleaning structure
--DROP TABLE IF EXISTS product;
--DROP SEQUENCE IF EXISTS sq_product_id;
--DROP TABLE IF EXISTS userdata;
--DROP SEQUENCE IF EXISTS sq_userdata_id;
--DROP TABLE IF EXISTS purchase;
--DROP SEQUENCE IF EXISTS sq_purchase_id;

-- reimport data
CREATE TABLE IF NOT EXISTS purchase (
    id INT PRIMARY KEY,
    price NUMERIC(10, 2) NOT NULL,
    pnr VARCHAR(10),
    eticket_id INT,
    fatt_id INT,
    note VARCHAR(2000),
    payment_method VARCHAR(20) NOT NULL,
    status VARCHAR(2) NOT NULL,
    insert_timestamp TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    update_timestamp TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);
CREATE SEQUENCE IF NOT EXISTS sq_purchase_id;


CREATE TABLE IF NOT EXISTS userdata (
    id INT PRIMARY KEY,
    purchase_id INT NOT NULL,
    user_id INT NOT NULL,
    name VARCHAR(50) NOT NULL,
    surname VARCHAR(50) NOT NULL,
    tax_code VARCHAR(16) NOT NULL,
    country VARCHAR(50) NOT NULL,
    city VARCHAR(50) NOT NULL,
    province VARCHAR(50) NOT NULL,
    post_code VARCHAR(5) NOT NULL,
    address VARCHAR(50) NOT NULL,
    address_number VARCHAR(50) NOT NULL,
    email VARCHAR(50) NOT NULL,
    phone VARCHAR(50) NOT NULL,
    consent_1 BOOLEAN NOT NULL DEFAULT TRUE,
    consent_2 BOOLEAN NOT NULL DEFAULT FALSE,
    consent_3 BOOLEAN NOT NULL DEFAULT FALSE,
    insert_timestamp TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    update_timestamp TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (purchase_id) REFERENCES purchase(id)
);
CREATE SEQUENCE IF NOT EXISTS sq_userdata_id;


CREATE TABLE IF NOT EXISTS product (
    id INT PRIMARY KEY,
    purchase_id INT NOT NULL,
    product_type VARCHAR(10) NOT NULL,
    product_code VARCHAR(10) NOT NULL,
    product_description VARCHAR(100) NOT NULL,
    product_info VARCHAR(100),
    check_in TIMESTAMP,
    price NUMERIC(10, 2) NOT NULL,
    proposal_id INT NOT NULL,
    reservation_id INT,
    insert_timestamp TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    update_timestamp TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (purchase_id) REFERENCES purchase(id)
);
CREATE SEQUENCE IF NOT EXISTS sq_product_id;