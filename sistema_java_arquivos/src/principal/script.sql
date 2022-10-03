/**
 * Author:  Gelvazio Camargo
 * Created: 14 de set. de 2022
 */

create table public.tbpessoa(
pescodigo serial not null,
pesnome varchar (200) not null,
pesendereco varchar (200) not null,
pescpf varchar (20) not null,
constraint pk_tbpessoa primary key (pescodigo)
);

