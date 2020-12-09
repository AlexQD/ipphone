CREATE TABLE users_roles(
    user_id     bigint not null,
    role_id     int not null,
    primary key (user_id, role_id),
    foreign key (user_id) references  users(id),
    foreign key (role_id) references  roles(id)
);

insert into roles(name) values ('ROLE_USER'),('ROLE_ADMIN');

insert into users(username, password, email)
values ('admin','$2a$10$WfukGkG0BBxXLjN7UhFMT.wYI.zU8RBhToQaxBHztxtaI95Q6QOz2','admin@test.ru');

insert into users_roles(user_id, role_id) values (1,1);
insert into users_roles(user_id, role_id) values (1,2);