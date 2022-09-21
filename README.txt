Use this to test locally using mysql

create table products(upc char(12) NOT NULL, prodname varchar(50) NOT NULL, brand varchar(50) NOT NULL, proddesc varchar(100) NOT NULL, category varchar(50) NOT NULL, priceperunit float NOT
NULL, imageurl varchar(2048), availablestock int NOT NULL, reservedstock int NOT NULL, shippedstock
int NOT NULL, PRIMARY KEY(UPC));



insert into products values("036000291452", "Chicken", "Microsoft", "It tastes good", "food", 4.20, "some image url", 10, 20, 5);
