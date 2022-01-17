# DesafioPubFuture
Para rodar o projeto é necessario ter os seguintes aplicativos: 
Apache NetBeans IDE versão 12.6, MySQL Workbench versão 8.0 CE e SQL server.
Após baixar os aplicativos é necessario criar um banco de dados o qual tem o seguinte código.
                         
                         create database financas;
                         use financas;

                         create table contas(
                         id int not null primary key auto_increment,
                         saldo float not null,
                         tipoContas varchar(40) not null,
                         instituicaoFinanceira varchar(40) not null
                         );

                         create table despesas(
                       	 id int not null primary key auto_increment,
                         valor float not null,
                         dataPagamento date not null,
                         dataPagamentoEsperado date not null,
                         tipoDespesa varchar(40) not null,
                         conta_id int not null,
	                 foreign key conta_id(conta_id) references contas(id)
                         );

                         create table receitas(
                       	 id int not null primary key auto_increment,
                         valor float not null,
                         dataRecebimento date not null,
                         dataRecebimentoEsperado date not null,
                         descricao varchar(40),
                         conta_id int not null,
                         foreign key conta_id(conta_id) references contas(id)
                         );
Feito os passos a cima basta abrir o aplicativo Apache NetBeans em seguida,
apertar o botão Run Project que estara com o nome do meu projeto(Projeto Proway).
