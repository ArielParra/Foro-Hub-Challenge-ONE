
CREATE TABLE Topicos (
    id INT AUTO_INCREMENT ,
    titulo VARCHAR(255),
    mensaje TEXT,
    fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    status VARCHAR(50),
    autor int,
    curso VARCHAR(100),
    respuestas VARCHAR(100),
    PRIMARY KEY (id)

);