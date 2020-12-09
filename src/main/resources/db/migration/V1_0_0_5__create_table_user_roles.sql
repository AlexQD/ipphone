create table users
(
	id bigserial
	    primary key,
	username varchar(255) not null,
	password varchar(255),
	email varchar(100)
);

create unique index users_email_uindex
	on users (email);

create unique index users_username_uindex
	on users (username);


create table roles
(
	id bigserial
	    primary key,
	name varchar(255)
);

create unique index roles_id_uindex
	on roles (id);


