INSERT INTO client (first_name, last_name, account_number, email, phone)
VALUES
('Никита', 'Хамлов','546546',  'ola_amigo@mail.ru', '87071344566'),
('Ашот', 'Хамзатов','123122', 'salam_poz@gmail.com', '87779929922');

INSERT INTO operation_category(name, description)
VALUES
('Онай оплата', 'проезд'),
('Оплата за кредит', 'Ежемесячный платеж кредита');


INSERT INTO accounts (client_uid, create_date, end_date, status)
VALUES
((select uid from client where account_number = '546546'), '2000-01-25', '2005-01-25', null);
INSERT INTO accounts (client_uid, create_date, end_date, status)
VALUES
((select uid from client where account_number = '123122'), '1999-05-17', '2004-05-17', null);


INSERT INTO operation (operation_category_uid, account_uid, sum, date, currency, limit_sum, limit_exceed)
VALUES
((select uid from operation_category where name = 'Онай оплата'),
 (select uid from accounts where client_uid = (select uid from client where account_number = '546546')),
 32000, '2002-09-02', 'USD', 3000, true),
((select uid from operation_category where name = 'Оплата за кредит'),
 (select uid from accounts where client_uid = (select uid from client where account_number = '123122')),
 1200,  '2003-01-08', 'USD', 10200, false);

INSERT INTO limits (account_uid, operation_category_uid, sum, remainder, currency,  date)
VALUES
((select uid from accounts where client_uid = (select uid from client where account_number = '546546')),
 (select uid from operation_category where name = 'Онай оплата'),
 3000, -29000, 'USD', '2002-09-02'),
((select uid from accounts where client_uid = (select uid from client where account_number = '123122')),
 (select uid from operation_category where name = 'Оплата за кредит'),
 10200, 9000, 'USD', '2003-01-08');



