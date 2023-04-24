insert into client (last_name, first_name, sex, date_of_birth, address, postal_code, town, email, password, phone, registration_date)
values ('toto', 'toto', 0, '1990-01-01', '1 place du commerce', '93330', 'Neuilly-sur-Marne', 'toto@gmail.com', 'toto', '0736738363', '2023-04-23 09:00:00'),
       ('tata', 'tata', 0, '1980-01-01', '1 place du commerce', '93330', 'Neuilly-sur-Marne', 'tata@gmail.com', 'tata', '0736738363', '2023-04-23 09:00:00'),
       ('test', 'test', 0, '1980-01-01', '1 place du commerce', '93330', 'Neuilly-sur-Marne', 'test@gmail.com', 'test', '0736738363', '2023-04-23 09:00:00');

insert into role (label, description, client_id)
values ('ROLE_USER', 'Role user', 3),
       ('ROLE_USER', 'Role user', 1),
       ('ROLE_USER', 'Role user', 2);

insert into account (account_number, balance, is_active, open_date, client_id)
values ('00039938393', 100, true, '2023-04-23 12:00:00', 3),
       ('00098383748', 200, true, '2023-04-23 12:00:00', 1),
       ('00083974823', 300, true, '2023-04-23 12:00:00', 2);

insert into transaction (amount, service_name, transaction_date, transaction_type_code, account_id)
values (20, 'SG agence Neuilly Plaisance', '2023-04-23 15:00:00', 'ATM', 3),
       (10, 'Carrefour', '2023-04-24 15:00:00', 'Physical Card', 1),
       (100, 'Cdiscount', '2023-04-24 15:00:00', 'Online', 2),
       (20, 'SG agence Neuilly Plaisance', '2023-04-23 15:00:00', 'ATM', 1),
       (50, 'Carrefour', '2023-04-24 15:00:00', 'Physical Card', 2),
       (100, 'Cdiscount', '2023-04-24 15:00:00', 'Online', 3);