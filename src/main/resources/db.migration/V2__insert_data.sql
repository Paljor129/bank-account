insert into client (id, last_name, first_name, sex, date_of_birth, address, postal_code, town, email, password, phone, registration_date)
values (1, 'toto', 'toto', 0, '1990-01-01', '1 place du commerce', '93330', 'Neuilly-sur-Marne', 'toto@gmail.com', 'toto', '0736738363', '2023-04-23 09:00:00'),
       (2, 'tata', 'tata', 0, '1980-01-01', '1 place du commerce', '93330', 'Neuilly-sur-Marne', 'tata@gmail.com', 'tata', '0736738363', '2023-04-23 09:00:00'),
       (3, 'test', 'test', 0, '1980-01-01', '1 place du commerce', '93330', 'Neuilly-sur-Marne', 'test@gmail.com', 'test', '0736738363', '2023-04-23 09:00:00');

insert into role (id, label, description, client_id)
values (1, 'ROLE_USER', 'Role user', 3),
       (2, 'ROLE_USER', 'Role user', 1),
       (3, 'ROLE_USER', 'Role user', 2);

insert into account (id, account_number, balance, is_active, open_date, client_id)
values (1, '00039938393', 100, true, '2023-04-23 12:00:00', 3),
       (2, '00098383748', 200, true, '2023-04-23 12:00:00', 1),
       (3, '00083974823', 300, true, '2023-04-23 12:00:00', 2);

insert into transaction (id, amount, service_name, transaction_date, transaction_type_code, account_id)
values (1, 20, 'SG agence Neuilly Plaisance', '2023-04-23 15:00:00', 'ATM', 3),
       (2, 10, 'Carrefour', '2023-04-24 15:00:00', 'Physical Card', 1),
       (3, 100, 'Cdiscount', '2023-04-24 15:00:00', 'Online', 2),
       (4, 20, 'SG agence Neuilly Plaisance', '2023-04-23 15:00:00', 'ATM', 1),
       (5, 50, 'Carrefour', '2023-04-24 15:00:00', 'Physical Card', 2),
       (6, 100, 'Cdiscount', '2023-04-24 15:00:00', 'Online', 3);