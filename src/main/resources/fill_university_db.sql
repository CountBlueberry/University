use university;

insert into lectors(name,salary,degree)
values ("Oliver Smith",600,"ASSISTANT");
insert into lectors(name,salary,degree)
values ("Jack Jones",400,"ASSISTANT");
insert into lectors(name,salary,degree)
values ("Harry Davies",750,"ASSOCIATE_PROFESSOR");
insert into lectors(name,salary,degree)
values ("Connor Davis",660,"ASSISTANT");
insert into lectors(name,salary,degree)
values ("Callum Rodriguez",430,"ASSOCIATE_PROFESSOR");
insert into lectors(name,salary,degree)
values ("Jessica Smith",500,"PROFESSOR");
insert into lectors(name,salary,degree)
values ("Sophie Wilson",580,"PROFESSOR");

insert into departments(name,head_of_department_id)
values ("Software enginire",3);
insert into departments(name,head_of_department_id)
values ("Web sites",5);

insert into departments_lectors(lector_id,department_id)
values (1,1);
insert into departments_lectors(lector_id,department_id)
values (1,2);
insert into departments_lectors(lector_id,department_id)
values (2,2);
insert into departments_lectors(lector_id,department_id)
values (3,1);
insert into departments_lectors(lector_id,department_id)
values (4,1);
insert into departments_lectors(lector_id,department_id)
values (5,2);
insert into departments_lectors(lector_id,department_id)
values (6,2);
insert into departments_lectors(lector_id,department_id)
values (7,1);
insert into departments_lectors(lector_id,department_id)
values (7,2);
