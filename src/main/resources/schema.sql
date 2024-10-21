CREATE TABLE IF NOT EXISTS tutorial(
    id INT NOT NULL AUTO_INCREMENT,
    title VARCHAR(100),
    published BOOLEAN,
    description VARCHAR(100),
    PRIMARY KEY(id)
);
