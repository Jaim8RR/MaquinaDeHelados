# MaquinaDeHelados
Maquina de helados para 1º de programacion.
create table helado(
	posicion text primary key,
	nombre text not null,
	precio numeric not null,
	tipo text not null,
	cantidad integer not null
);

create table venta(
	fecha_hora text not null,
	posicion text not null,
	nombre text not null,
	precio numeric not null,
	tipo text not null,
	cantidad integer not null
);

insert into helado values ('00','ChocoBomba',1.1,'tarrina',5);
insert into helado values ('01','FresaGuapi',0.8,'palo',5);
insert into helado values ('02','LimónCanela',1.5,'cucurucho',5);
insert into helado values ('10','FrigLemon',1.8,'tarrina',5);
insert into helado values ('11','PiñaHelada',1,'palo',5);
insert into helado values ('12','MoraGuay',1.2,'cucurucho',5);
insert into helado values ('20','ChocoLoco',1.5,'tarrina',5);
insert into helado values ('21','TuttiFrutti',1.1,'palo',5);
insert into helado values ('22','Mentazul',1.1,'cucurucho',5);

public static void cargarDriver() {
try {
Class.forName("org.sqlite.JDBC");
} catch (Exception e) {
System.exit(1);
}
}
