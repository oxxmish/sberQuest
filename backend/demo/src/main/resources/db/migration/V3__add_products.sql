truncate table products cascade;
alter sequence if exists products_id_seq restart;

insert into products(colour, name) VALUES ('background:rgb(0, 30, 110);color:white;',	'Okko');
insert into products(colour, name) VALUES ('background:rgb(0, 53, 203);color:white;',	'СберДиск');
insert into products(colour, name) VALUES ('background:rgb(215, 78, 250);color:white;',	'СберЗвук');
insert into products(colour, name) VALUES ('background:rgb(14, 198, 66);color:white;',	'ДеливериКлаб');
insert into products(colour, name) VALUES ('background:rgb(47, 122, 119);color:white;',	'СберБокс');
insert into products(colour, name) VALUES ('background:rgb(255, 52, 94);color:white;',	'Самокат');
insert into products(colour, name) VALUES ('background:rgb(255, 113, 0);color:white;',	'Ситимобил');
insert into products(colour, name) VALUES ('background:rgb(115, 225, 84);color:white;',	'СберПрайм');
insert into products(colour, name) VALUES ('background:rgb(255, 127, 0);color:white;',	'СберМобайл');
insert into products(colour, name) VALUES ('background:rgb(129, 104, 241);color:white;', 'СберЕАптека');
insert into products(colour, name) VALUES ('background:rgb(42, 172, 112);color:white;',	'ДомКлик');
insert into products(colour, name) VALUES ('background:rgb(33, 90, 56);color:white;',	'СберЛогистика');
insert into products(colour, name) VALUES ('background:rgb(52, 150, 220);color:white;',	'РаботаРу');
insert into products(colour, name) VALUES ('background:rgb(242, 194, 0);color:white;',	'СберМаркет');
insert into products(colour, name) VALUES ('background:rgb(49, 45, 61);color:white;',	'СберПрайм+');
insert into products(colour, name) VALUES ('background:rgb(253, 25, 104);color:white;',	'СберЗдоровье');
insert into products(colour, name) VALUES ('background:rgb(25, 54, 18);color:black;',	'Полуфинал');
insert into products(colour, name) VALUES ('background:rgb(25, 54, 18);color:black;',	'Финал');
