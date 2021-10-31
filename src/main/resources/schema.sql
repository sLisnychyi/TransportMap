create table users
(
    id int primary key AUTO_INCREMENT,
    name text not null CHECK (name NOT LIKE '%[^0-9]%'),
    age int not null
);

-- alter table users add constraint unique_name_age unique (name, age);