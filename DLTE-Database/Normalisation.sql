--Before normalization

create table Normalisation(username varchar(255), upi varchar(20), mobile_number number(13), email varchar(255), wallet_type varchar(10), recharged_date date, recharged_provider varchar(255), recharged_to varchar(255), recharged_amount number);

Table created.


--First normal form

create table Normalisation_first_norm(username varchar(255) primary key, upi varchar(20), mobile_number number(13), email varchar(255), wallet_type varchar(10), recharged_date date, recharged_provider varchar(255), recharged_to varchar(255), recharged_amount number);
Table NORMALISATION_FIRST_NORM created.

--Second normal form

create table Normalisation_second_form(username varchar(255) primary key, upi varchar(20), mobile_number number(13), email varchar(255));

Table NORMALISATION_SECOND_FORM created.

---recharge
create table Normalisation_recharge(wallet_type varchar(10), recharged_date date, recharged_provider varchar(255), recharged_to varchar(255), recharged_amount number);
Table NORMALISATION_RECHARGE created.


--Third normal form


create table Noemalisation_third_norm(username varchar(255) primary key, upi varchar(20), mobile_number number(13), email varchar(255), wallet_type varchar(10));
Table NOEMALISATION_THIRD_NORM created.



alter table Normalisation_recharge add primary key (wallet_type);
alter table Noemalisation_third_norm add FOREIGN key(wallet_type) references Normalisation_recharge(wallet_type);
