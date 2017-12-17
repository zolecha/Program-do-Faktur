create database faktura;
use faktura;


create table sprzedawca(
id_s int primary key auto_increment,
nazwa_s varchar(50) not null,
adres_s varchar(150) not null,
miejscowosc_s varchar(40) not null,
kod_pocztowy_s varchar(6) not null,
nip_s varchar(10) unique not null,
regon_s varchar(9) not null,
rachunek_s varchar(26) not null,
login varchar(35) unique not null,
haslo varchar(35)
);

create table kontrahent(
id_k int primary key auto_increment,
nip_k varchar(10),
nazwa_k varchar(50) not null,
adres_k varchar(150) not null,
miejscowosc_k varchar(40) not null,
kod_pocztowy_k varchar(6) not null,
id_s int,
foreign key (id_s) references sprzedawca(id_s)
);

SELECT * FROM kontrahent;

create table faktura(
id_f int primary key auto_increment,
id_s int not null,
id_k int,
nr_f varchar(10) not null unique,
data_wystawienia date,
miejsce_wystawienia varchar(50) not null,
towar text not null,
ilosc int not null,
jm varchar(10) not null,
cena_j decimal(10,2) not null,
netto decimal(10,2) not null,
s_vat varchar(5) not null, 
vat decimal(10,2),
brutto decimal(10,2) not null,
t_platnosci date not null,
forma_platnosci varchar(20) not null,
foreign key (id_s) references sprzedawca(id_s),
foreign key (id_k) references kontrahent(id_k)
);

insert into sprzedawca values(null, 'sprzedawca', 'sprzedawca', 'sprzedawca', '00-000', 'sprzedawca', 'sprzedawc', 'sprzedawca', 'sprzedawca', 'sprzedawca');
insert into kontrahent values(NULL, '7010231645', 'kontrahent', 'kontrahent','kontrahent','00-000',1);
insert into faktura values(null, 1, 1, 'nr','2017-12-26', 'wawa', 'towar', 1, 'szt.', 20.00, 20.00, 0.00, 0.00, 20.00, '2017-12-29', 'gotówka');


