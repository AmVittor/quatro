create database 4four;
use 4four;

create table client(
id_client int primary key auto_increment,
company_name varchar(45),
specification varchar(45),
cnpj varchar(14),
plan varchar(45)
) auto_increment = 100;

create table user(
id_user int primary key auto_increment,
name varchar(45),
login varchar(45),
password varchar(45),
permission varchar(45),
fk_client int,
foreign key (fk_client) references Client(id_client)
)auto_increment = 200;

create table server (
id_server int primary key auto_increment,
server_name varchar(45),
operational_system varchar(45),
ip varchar(45),
location varchar(45),
fk_client int,
foreign key (fk_client) references client(id_client)
)auto_increment = 300;

create table request (
id_request int primary key auto_increment,
location varchar(45),
request_date datetime,
fk_server int,
foreign key (fk_server) references server(id_server)
)auto_increment = 400;

create table unit_of_measurement(
id_unit_of_measurement int primary key auto_increment,
unit varchar(45)
)auto_increment = 500;

create table component(
id_hardware int primary key auto_increment,
item varchar(45),
size int,
temperature double,
clock double,
speed_unit varchar(45),
clock_unit varchar(45),
fk_server int,
temperature_unit double,
foreign key (fk_server) references server(id_server),
foreign key (temperature_unit) references unit_of_measurement(id_measurement)
) auto_increment = 600;

create table measurement(
id_measurement int primary key auto_increment,
measurement_usage double,
temperature double,
measurement_date datetime,
usage_unit varchar(45),
temperature_unit varchar(45),
fk_component int,
foreign key (fk_component) references component(id_component)
)auto_increment = 700;

create table alert(
id_alert int primary key auto_increment,
log varchar(1000),
alert_date datetime,
fk_measurement int,
foreign key (fk_measurement) references measurement(id_measurement)
)auto_increment = 800;


