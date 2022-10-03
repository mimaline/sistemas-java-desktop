/**
 * Author:  Gelvazio Camargo
 * Created: 14 de set. de 2022
 */

-- criando tabelas do banco de dados...

create table public.tbpessoa( 
    pescodigo serial not null,
    pesnome varchar(200) not null,
    pesendereco varchar(200) not null,
    pescpf varchar(20) not null,
    CONSTRAINT pk_tbpessoa 
    PRIMARY KEY (pescodigo)
);

create table public.tbproduto( 
    procodigo serial not null,
    prodescricao varchar(200) not null,
    propreco numeric (10,2) not null,
    CONSTRAINT pk_tbproduto PRIMARY KEY (procodigo)
);

-- INSERTS pessoa--

INSERT INTO public.tbpessoa
(pescodigo, pesnome, pesendereco, pescpf)
VALUES(1, 'João da Silva', 'Estrada São João', '020.496.940-91');
INSERT INTO public.tbpessoa
(pescodigo, pesnome, pesendereco, pescpf)
VALUES(2, 'Mirian Rodrigues', 'Valada São Paulo', '692.680.010-39');
INSERT INTO public.tbpessoa
(pescodigo, pesnome, pesendereco, pescpf)
VALUES(3, 'Joaquim Fonseca', 'Rua dos Pioneiros', '075.036.870-53');
INSERT INTO public.tbpessoa
(pescodigo, pesnome, pesendereco, pescpf)
VALUES(4, 'Jeniffer dos Santos', 'Rua das Cruzes', '835.280.180-54');
INSERT INTO public.tbpessoa
(pescodigo, pesnome, pesendereco, pescpf)
VALUES(5, 'Manoel Ferreira', 'Estrada São Juan', '550.511.250-18');
INSERT INTO public.tbpessoa
(pescodigo, pesnome, pesendereco, pescpf)
VALUES(6, 'Fillipe Guilherme', 'Rua das Ituporangas', '256.932.040-49');
INSERT INTO public.tbpessoa
(pescodigo, pesnome, pesendereco, pescpf)
VALUES(7, 'Gustavo da Silva', 'Rua dos Joelhos', '075.036.870-53');
INSERT INTO public.tbpessoa
(pescodigo, pesnome, pesendereco, pescpf)
VALUES(8, 'Ferdinando Bull', 'Rua dos Chifres', '931.275.100-04');

-- inserts produtos --
insert INTO tbproduto (prodescricao, propreco)
values ('Arroz', 10.00 );
insert INTO tbproduto (prodescricao, propreco)
values ('Feijão', 8.00 );
insert INTO tbproduto (prodescricao, propreco)
values ('Bolacha', 10.00 );
insert INTO tbproduto (prodescricao, propreco)
values ('Polenta', 15.00 );
insert INTO tbproduto (prodescricao, propreco)
values ('Macarrão', 10.00 );
insert INTO tbproduto (prodescricao, propreco)
values ('Sal', 7.00 );
insert INTO tbproduto (prodescricao, propreco)
values ('Açúcar', 10.00 );

