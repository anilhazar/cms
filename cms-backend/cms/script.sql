USE cms;
create table branch
(
    id   bigint auto_increment
        primary key,
    name varchar(255) null
);

create table employee
(
    id         bigint auto_increment
        primary key,
    age        int          null,
    birth_date datetime(6)  null,
    first_name varchar(255) null,
    gender     char         null,
    last_name  varchar(255) null,
    branch_id  bigint       null,
    constraint FKcvhlsx8tao1rxt7mpxrot61jt
        foreign key (branch_id) references branch (id)
);

create table leaves
(
    id          bigint auto_increment
        primary key,
    end_date    datetime(6)  null,
    reason      varchar(255) null,
    start_date  datetime(6)  null,
    employee_id bigint       null,
    constraint FKoyaicpcjhq2kad5vgtlexcjjo
        foreign key (employee_id) references employee (id)
);

create table project
(
    id        bigint auto_increment
        primary key,
    name      varchar(255) null,
    branch_id bigint       null,
    constraint FKiysrpckv8iw454brxy5tin6gg
        foreign key (branch_id) references branch (id)
);

create table project_employee
(
    id          bigint auto_increment
        primary key,
    hour        int    null,
    employee_id bigint null,
    project_id  bigint null,
    constraint FK1907nkisp2dlsswuycpnakiv8
        foreign key (project_id) references project (id),
    constraint FKn5yqs0xm3rmsg62n84ccyk4k0
        foreign key (employee_id) references employee (id)
);

