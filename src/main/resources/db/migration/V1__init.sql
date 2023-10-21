CREATE TABLE IF NOT EXISTS doctores(
    id SERIAL,
    nombreDoc VARCHAR(255) NOT NULL,
    especialidadDoc VARCHAR(255) NOT NULL,
    telefonoDoc VARCHAR(20) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS pacientes (
    id SERIAL,
    nombrePaciente VARCHAR(255) NOT NULL,
    edadPaciente INT NOT NULL,
    doctores_id INT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (doctores_id) REFERENCES doctores(id)
);
