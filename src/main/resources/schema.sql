
CREATE TABLE IF NOT EXISTS Person (
    name VARCHAR(255),
    surname VARCHAR(255),
    age INT,
    phone_number VARCHAR(20),
    city_of_living VARCHAR(255),
    PRIMARY KEY (name, surname, age)
);
