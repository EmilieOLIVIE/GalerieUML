-- Initialisation spécifiques pour un jeu de test
INSERT INTO Galerie(id, nom, adresse) VALUES (1, 'Saatchi', 'King\''s Road, Londres');

INSERT INTO EXPOSITION(id, debut, intitule, duree, organisateur_id) 
VALUES (1, NOW(), 'L\''art brut contemporain', 10, 1);

INSERT INTO PERSONNE(dtype, id, nom, adresse, biographie) VALUES ('Artiste', 1, 'Basquiat', 'Cimetière Père Lachaise', 'Peintre New Yorkais');
INSERT INTO PERSONNE(dtype, id, nom, adresse) VALUES ('Personne', 2, 'Olivie', 'Chemin du rêve');
INSERT INTO PERSONNE(dtype, id, nom, adresse) VALUES ('Personne', 3, 'Bastide', 'ISIS Castres');

INSERT INTO TABLEAU(id, titre, support, auteur_id)
VALUES (1, 'New York Streets', 'Huile sur toile', 1);

INSERT INTO EXPOSITION_OEUVRES(accrochages_id, oeuvres_id) VALUES (1, 1);

INSERT INTO TRANSACTION(id, prix_vente, vendu_le, client_id, lieu_de_vente_id, oeuvre_id)
VALUES (1, 150, '01/01/2010', 3, 1, 1);