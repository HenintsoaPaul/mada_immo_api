CREATE TABLE admin
(
    id_admin SERIAL,
    nom      VARCHAR(50) NOT NULL,
    login    VARCHAR(50) NOT NULL,
    mdp      VARCHAR(50) NOT NULL,
    PRIMARY KEY (id_admin)
);

CREATE TABLE proprio
(
    id_proprio SERIAL,
    nom        VARCHAR(50) NOT NULL,
    num_tel    VARCHAR(50) NOT NULL,
    PRIMARY KEY (id_proprio)
);

CREATE TABLE client
(
    id_client SERIAL,
    nom       VARCHAR(50) NOT NULL,
    email     VARCHAR(50) NOT NULL,
    PRIMARY KEY (id_client)
);

CREATE TABLE type_bien
(
    id_type_bien SERIAL,
    nom          VARCHAR(50)    NOT NULL,
    commission   NUMERIC(15, 2) NOT NULL,
    PRIMARY KEY (id_type_bien)
);

CREATE TABLE region
(
    id_region SERIAL,
    nom       VARCHAR(50) NOT NULL,
    PRIMARY KEY (id_region)
);

CREATE TABLE bien
(
    id_bien       SERIAL,
    nom           VARCHAR(50)    NOT NULL,
    description   TEXT           NOT NULL,
    loyer_mensuel NUMERIC(15, 2) NOT NULL,
    photos        TEXT,
    id_type_bien  INTEGER        NOT NULL,
    id_proprio    INTEGER        NOT NULL,
    id_region     INTEGER        NOT NULL,
    PRIMARY KEY (id_bien),
    FOREIGN KEY (id_type_bien) REFERENCES type_bien (id_type_bien),
    FOREIGN KEY (id_proprio) REFERENCES proprio (id_proprio),
    FOREIGN KEY (id_region) REFERENCES region (id_region)
);

CREATE TABLE location
(
    id_location SERIAL,
    date_debut  DATE    NOT NULL,
    duree       INTEGER NOT NULL,
    id_bien     INTEGER NOT NULL,
    id_client   INTEGER NOT NULL,
    PRIMARY KEY (id_location),
    FOREIGN KEY (id_bien) REFERENCES bien (id_bien),
    FOREIGN KEY (id_client) REFERENCES client (id_client)
);

CREATE TABLE location_fille
(
    id_location_fille SERIAL,
    date_location     DATE           NOT NULL,
    id_location_mere  INTEGER        NOT NULL,
    PRIMARY KEY (id_location_fille),
    FOREIGN KEY (id_location_mere) REFERENCES location (id_location)
);
