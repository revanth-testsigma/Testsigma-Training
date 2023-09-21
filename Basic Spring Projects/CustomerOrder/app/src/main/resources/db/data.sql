Alter table orders MODIFY COLUMN payment_status Boolean NOT NULL;
insert into customer(name, email,address,password) VALUES("Rev","rev@gmail","4-34 eitur dkgjbsb","##$$&**");
insert into customer(name, email,address,password) VALUES("Ker","ker@mail","54j-23ejhwe  ejhv","#@@@@#");
insert into customer(name, email,address,password) VALUES("Su","Su@gm","45flwnk 45krgjef","2323%$");

insert into orders(customer_id, payment_status, payment_type, amount) VALUES (1, '0', 'UPI', 3354.76);
insert into orders(customer_id, payment_status, payment_type, amount) VALUES (2, '1', 'CREDIT_CARD', 33534.76);
insert into orders(customer_id, payment_status, payment_type, amount) VALUES (3, '0', 'DEBIT_CARD', 77754.76);
insert into orders(customer_id, payment_status, payment_type, amount) VALUES (3, '1', 'UPI', 7754.76);
insert into orders(customer_id, payment_status, payment_type, amount) VALUES (2, '0', 'DEBIT_CARD', 754.76);
insert into orders(customer_id, payment_status, payment_type, amount) VALUES (1, '1', 'CASH', 7.67);
