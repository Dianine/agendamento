CREATE TABLE agenda(
id serial PRIMARY KEY,
descricao varchar(255),
horario timestamp,
data_criacao timestamp,
cliente_id integer,
CONSTRAINT fk_agenda_cliente FOREIGN KEY (cliente_id) REFERENCES cliente(id)
);