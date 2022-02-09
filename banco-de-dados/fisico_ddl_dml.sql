CREATE DATABASE viladev;

CREATE TABLE resident_adm(
	id SERIAL PRIMARY KEY,
	email VARCHAR(255) NOT NULL UNIQUE,
	password VARCHAR(255) NOT NULL,
	is_admin Integer DEFAULT 0
);

CREATE TABLE resident(
	id SERIAL PRIMARY KEY,
	name VARCHAR(255) NOT NULL,
	lastname VARCHAR(255) NOT NULL,
	birthday DATE NOT NULL,
	income DECIMAL DEFAULT '0.00',
	cpf VARCHAR(255) UNIQUE DEFAULT '0',
	resident_adm_id Integer NOT NULL UNIQUE,
	FOREIGN KEY (resident_adm_id) REFERENCES resident_adm(id)
);

INSERT INTO resident_adm (email, password, is_admin) VALUES ('eduardo.telmann@gmail.com', '123456', 1);

INSERT INTO resident (name, lastname, birthday, income, cpf, resident_adm_id) VALUES ('Eduardo', 'Telmann', '1992-06-06', 10000.00, '123.456.789-10', 1);



/*ONE LINE TO EXEC

CREATE TABLE resident_adm(id SERIAL PRIMARY KEY, email VARCHAR(255) NOT NULL UNIQUE, password VARCHAR(255) NOT NULL, is_admin Integer DEFAULT 0);
CREATE TABLE resident(id SERIAL PRIMARY KEY, name VARCHAR(255) NOT NULL, lastname VARCHAR(255) NOT NULL, birthday DATE NOT NULL, income DECIMAL DEFAULT '0.00', cpf VARCHAR(255) UNIQUE DEFAULT '0', resident_adm_id Integer NOT NULL UNIQUE, FOREIGN KEY (resident_adm_id) REFERENCES resident_adm(id));

*/