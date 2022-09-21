use this for your mysql to locally test

READ DIS, MADE CHANGES TO DB

create table products(upc char(12) NOT NULL, prod_name varchar(50) NOT NULL, brand varchar(50) NOT NULL, prod_desc varchar(100) NOT NULL, category varchar(50) NOT NULL, price_per_unit float NOT
NULL, image_url varchar(2048), available_stock int NOT NULL, reserved_stock int NOT NULL, shipped_stock
int NOT NULL, PRIMARY KEY(UPC));



insert into products values("036000291452", "Chicken", "Microsoft", "It tastes good", "food", 4.20, "some image url", 10, 20, 5);
