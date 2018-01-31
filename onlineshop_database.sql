CREATE TABLE category(Id int PRIMARY KEY AUTO_INCREMENT, name VARCHAR(30), description VARCHAR(200), image_url VARCHAR(50), active BOOLEAN default true);


CREATE TABLE account (
	id int primary key auto_increment,
	first_name VARCHAR(50),
	last_name VARCHAR(50),
	role VARCHAR(50),
	active BOOLEAN default true,
	email VARCHAR(100),
	password VARCHAR(60),
	contact_number VARCHAR(15)
);


CREATE TABLE product (
	id int primary key auto_increment,
	code VARCHAR(20),
	name VARCHAR(50),
	brand VARCHAR(50),
	description VARCHAR(255),
	unit_price DECIMAL(10,2),
	quantity INT,
	active BOOLEAN default true,
	category_id INT,
	supplier_id INT,
	purchases INT DEFAULT 0,
	views INT DEFAULT 0,
 	FOREIGN KEY (category_id) REFERENCES category (id) on delete cascade,
	FOREIGN KEY (supplier_id) REFERENCES account(id)
);	

-- the address table to store user's billing and shipping addresses
CREATE TABLE address (
	id int primary key auto_increment,
	account_id int,
	street VARCHAR(100),
	city VARCHAR(30),
	country VARCHAR(20),
	postal_code VARCHAR(10),
	is_billing BOOLEAN,
	is_shipping BOOLEAN,
	FOREIGN KEY (account_id ) REFERENCES account(id)
);

-- the cart table to store user's cart top-level details
CREATE TABLE cart (
	id int primary key auto_increment,
	account_id int,
	grand_total DECIMAL(10,2),
	cart_lines int,
	CONSTRAINT fk_cart_user_id FOREIGN KEY (account_id ) REFERENCES account(id)
);
-- the cart line table to store the cart details

CREATE TABLE cart_line (
id int primary key auto_increment,
	cart_id int,
	total DECIMAL(10,2),
	product_id int,
	product_count int,
	buying_price DECIMAL(10,2),
	is_available boolean,
	CONSTRAINT fk_cartline_product_id FOREIGN KEY (product_id ) REFERENCES product (id)
);


-- the order detail table to store the order

CREATE TABLE order_detail (
id int primary key auto_increment,
	account_id int,
	order_total DECIMAL(10,2),
	order_count int,
	shipping_id int,
	billing_id int,
	order_date date,
	CONSTRAINT fk_order_detail_user_id FOREIGN KEY (account_id) REFERENCES account(id),
	CONSTRAINT fk_order_detail_shipping_id FOREIGN KEY (shipping_id) REFERENCES address (id),
	CONSTRAINT fk_order_detail_billing_id FOREIGN KEY (billing_id) REFERENCES address (id)
);

-- the order item table to store order items

CREATE TABLE order_item (
id int primary key auto_increment,
	order_id int,
	total DECIMAL(10,2),
	product_id int,
	product_count int,
	buying_price DECIMAL(10,2),
	CONSTRAINT fk_order_item_product_id FOREIGN KEY (product_id) REFERENCES product (id),
	CONSTRAINT fk_order_item_order_id FOREIGN KEY (order_id) REFERENCES order_detail (id)
);


-- adding three categories
INSERT INTO category (name, description,image_url,active) VALUES ('Smartphones', 'This is description for Smartphones category!', 'CAT_1.png', true);
INSERT INTO category (name, description,image_url,active) VALUES ('Headphones', 'This is description for Headphones category!', 'CAT_2.png', true);
INSERT INTO category (name, description,image_url,active) VALUES ('Accesories', 'This is description for Accesories category!', 'CAT_3.png', true);
-- adding three users 
INSERT INTO account
(first_name, last_name, role, active, password, email, contact_number) 
VALUES ('Michal', 'Skrzypek', 'ADMIN', true, '$2a$06$ORtBskA2g5Wg0HDgRE5ZsOQNDHUZSdpJqJ2.PGXv0mKyEvLnKP7SW', 'mskrzypek97@gmail.com', '668229833');
INSERT INTO account
(first_name, last_name, role, active, password, email, contact_number) 
VALUES ('John', 'Johnson', 'SUPPLIER', true, '$2a$06$bzYMivkRjSxTK2LPD8W4te6jjJa795OwJR1Of5n95myFsu3hgUnm6', 'jj@gmail.com', '444555666');
INSERT INTO account
(first_name, last_name, role, active, password, email, contact_number) 
VALUES ('Mark', 'James', 'SUPPLIER', true, '$2a$06$i1dLNlXj2uY.UBIb9kUcAOxCigGHUZRKBtpRlmNtL5xtgD6bcVNOK', 'mj@gmail.com', '777888999');
INSERT INTO account
(first_name, last_name, role, active, password, email, contact_number) 
VALUES ('Kyle', 'Carter', 'USER', true, '$2a$06$4mvvyO0h7vnUiKV57IW3oudNEaKPpH1xVSdbie1k6Ni2jfjwwminq', 'kc@gmail.com', '111222333');

-- adding five products
INSERT INTO product (code, name, brand, description, unit_price, quantity, active, category_id, supplier_id, purchases, views)
VALUES ('PRDABC123DEFX', 'iPhone 6S', 'Apple', 'Space Grey 32GB ', 300, 10, true, 1, 2, 0, 0 );
INSERT INTO product (code, name, brand, description, unit_price, quantity, active, category_id, supplier_id, purchases, views)
VALUES ('PRDDEF123DEFX', 'Samsung S7', 'Samsung', 'Silver 16GB', 250, 5, true, 1, 3, 0, 0 );
INSERT INTO product (code, name, brand, description, unit_price, quantity, active, category_id, supplier_id, purchases, views)
VALUES ('PRDPQR123WGTX', 'Google Pixel', 'Google', 'Black 128GB', 350, 4, true, 1, 2, 0, 0 );
INSERT INTO product (code, name, brand, description, unit_price, quantity, active, category_id, supplier_id, purchases, views)
VALUES ('PRDMNO123PQRX', 'Sennheiser HD 201', 'Sennheiser', 'Silver/Black ', 25, 3, true, 2, 2, 0, 0 );
INSERT INTO product (code, name, brand, description, unit_price, quantity, active, category_id, supplier_id, purchases, views)
VALUES ('PRDABCXYZDEFX', 'AKG N60', 'AKG', 'Black. Detachable cable with universal remote.', 200, 5, true, 2, 3, 0, 0 );
INSERT INTO product (code, name, brand, description, unit_price, quantity, active, category_id, supplier_id, purchases, views)
VALUES ('PRD123XYZDEFX', 'Sony Xperia X', 'Sony', 'Black. Some descriptio for Sony Xperia X.', 230, 0, true, 2, 3, 0, 0 );
-- adding a supplier correspondece address
INSERT INTO address( account_id, street, city, country, postal_code, is_billing, is_shipping) 
VALUES (4, '103 Darsey Road', 'New York', 'USA', '111111', true, false );
-- adding a cart for testing 
INSERT INTO cart (account_id, grand_total, cart_lines) VALUES (4, 0, 0);