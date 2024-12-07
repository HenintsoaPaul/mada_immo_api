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
