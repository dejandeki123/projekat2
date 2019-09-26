INSERT INTO Korisnik(id, korisnickoime,lozinka,ime,prezime,uloga,kontakttelefon,email,adresa) VALUES (1, 'dejan','123','Pera','Peric','ADMINISTRATOR',065443321,'mika@gmail.com','Vojvode Putnika 3');
INSERT INTO Korisnik(id, korisnickoime,lozinka,ime,prezime,uloga,kontakttelefon,email,adresa) VALUES (2, 'ivana','123','Mika','Mikic','KUPAC',065443322 ,'mika@gmail.com','Vojvode Putnika 3');
INSERT INTO Korisnik(id, korisnickoime,lozinka,ime,prezime,uloga,kontakttelefon,email,adresa) VALUES (3, 'nesa','123','Anta','Antic','KUPAC',065443323,'anta@gmail.com','Vojvode Putnika 3');
INSERT INTO Korisnik(id, korisnickoime,lozinka,ime,prezime,uloga,kontakttelefon,email,adresa) VALUES (4, 'mika','123','Laza','Lazic','KUPAC',065443324,'laza@gmail.com','Vojvode Putnika 3');

INSERT INTO Artikal(id,naziv,opisartikla,cena,kolicina,kategorija,napopustu,omiljeniartikal) VALUES (1,'Orlovi rano lete','zanimljivo',1400,3,'domacaKnjizevnost',false,true);
INSERT INTO Artikal(id,naziv,opisartikla,cena,kolicina,kategorija,napopustu,omiljeniartikal) VALUES (2,'Hajduci','poucno',1500,3,'domacaKnjizevnost',true,true);
INSERT INTO Artikal(id,naziv,opisartikla,cena,kolicina,kategorija,napopustu,omiljeniartikal) VALUES (3,'Bela griva','inspirativno',1600,3,'stranaKnjizevnost',false,true);
INSERT INTO Artikal(id,naziv,opisartikla,cena,kolicina,kategorija,napopustu,omiljeniartikal) VALUES (4,'Molijer','dosadno',1700,3,'stranaKnjizevnost',true,false);
INSERT INTO Artikal(id,naziv,opisartikla,cena,kolicina,kategorija,napopustu,omiljeniartikal) VALUES (5,'Tvrdica','strucno',1450,3,'stranaKnjizevnost',false,true);
INSERT INTO Artikal(id,naziv,opisartikla,cena,kolicina,kategorija,napopustu,omiljeniartikal) VALUES (6,'Pokondirena tikva','obrazovno',1390,3,'domacaKnjizevnost',true,false);
INSERT INTO Artikal(id,naziv,opisartikla,cena,kolicina,kategorija,napopustu,omiljeniartikal) VALUES (7,'Sesir profesora Vujica','skolsko',2000,3,'domacaKnjizevnost',false,true);
INSERT INTO Artikal(id,naziv,opisartikla,cena,kolicina,kategorija,napopustu,omiljeniartikal) VALUES (8,'Hamlet','srednjevekovno',3400,3,'stranaKnjizevnost',true,false);

INSERT INTO Korpa(id,datum_porudzbine,status) VALUES (1,'12.1.2019',1);
INSERT INTO Korpa(id,datum_porudzbine,status) VALUES (2,'12.1.2019',0);