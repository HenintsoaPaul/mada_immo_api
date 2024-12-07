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

-- Trigger
CREATE OR REPLACE FUNCTION insert_location_fille()
    RETURNS TRIGGER AS
$$
BEGIN
    INSERT INTO location_fille (date_location,
                                id_location_mere)
    SELECT NEW.date_debut + generate_series(0, NEW.duree - 1) * INTERVAL '1 month',
           NEW.id_location;

    RETURN NEW;
END;
$$ LANGUAGE plpgsql;


CREATE OR REPLACE TRIGGER trg_insert_location_fille
    AFTER INSERT
    ON location
    FOR EACH ROW
EXECUTE FUNCTION insert_location_fille();

-- View
CREATE OR REPLACE VIEW gain_mensuel
AS SELECT to_char(date_trunc('month', lf.date_location), 'Mon yyyy') AS month_year,
          SUM(loyer_mensuel * (commission / 100))                    AS gain
   FROM location_fille lf
            JOIN (location l
       JOIN (type_bien tb JOIN bien b ON b.id_type_bien = tb.id_type_bien) btb
                  ON l.id_bien = btb.id_bien) mere ON mere.id_location = lf.id_location_mere
   GROUP BY date_trunc('month', lf.date_location)
   ORDER BY date_trunc('month', lf.date_location);

-- data
INSERT INTO admin (id_admin, nom, login, mdp)
VALUES (1, 'Dupont', 'admin', 'password123'),
       (2, 'Durand', 'superadmin', 'motdepasse'),
       (3, 'Martin', 'gestionnaire', 'secret123');

INSERT INTO proprio (id_proprio, nom, num_tel)
VALUES (1, 'Monsieur Jean Dupont', '+33 6 12 34 56 78'),
       (2, 'Madame Marie Durand', '+33 7 89 01 23 45'),
       (3, 'Monsieur Pierre Martin', '+33 5 67 90 12 34');

INSERT INTO client (id_client, nom, email)
VALUES (1, 'Léa Gauthier', 'lea.gauthier@example.com'),
       (2, 'Olivier Bernard', 'olivier.bernard@gmail.com'),
       (3, 'Sophie Rousseau', 'sophie.rousseau@outlook.fr');

INSERT INTO type_bien (nom, commission)
VALUES ('Appartement', 5.00),
       ('Maison individuelle', 10.00),
       ('Studio', 15.00);

INSERT INTO region (nom)
VALUES ('Sambava'),
       ('Antalaha'),
       ('Vohemar');

INSERT INTO bien (nom, description, loyer_mensuel, photos, id_type_bien, id_proprio, id_region)
VALUES ('trano1', 'fufu', 200000, '../..', 1, 1, 1),
       ('trano21', 'ohoh', 1000000, '../..', 2, 2, 1);

INSERT INTO location (date_debut, duree, id_bien, id_client)
VALUES ('2024-01-31', 2, 1, 1),
       ('2024-01-31', 2, 2, 2);
