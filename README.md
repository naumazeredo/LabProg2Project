# Lab Prog 2 Project

## Instalação das Ferramentas

### NetBeans

Download do NetBeans 8.0.2 (Java EE): https://netbeans.org/downloads/

### Banco de Dados (MySQL)

- MySQL: http://www.tutorialspoint.com/mysql/mysql-installation.htm
- MySQL Connector/J: [Ubuntu](https://help.ubuntu.com/community/JDBCAndMySQL),
  [Windows](https://dev.mysql.com/downloads/connector/j/)

## Configuração do projeto

### Configuração do MySQL

- Criar usuário com nome _root_ (padrão) e senha em branco.
  Durante a instalação o MySQL server vai pedir senha. Só deixar em branco.

- Criar banco de dados com nome _labprog2_.
  ```
  mysql> create database labprog2;
  ```

- Criar tabelas _eventos_, _localizacoes_ e _tiposevento_
  ```
  mysql> use labprog2;
  mysql> create table tiposevento (
    -> id int not null auto_increment,
    -> nome varchar(255) not null,
    -> duracao int not null,
    -> primary key (id));
  mysql> create table localizacoes (
    -> id int not null auto_increment,
    -> local varchar(255) not null,
    -> regiao int not null,
    -> primary key (id));
  mysql> create table eventos (
    -> id int not null auto_increment,
    -> nome varchar(255) not null,
    -> localid int not null,
    -> tipoid int not null,
    -> data varchar(20) not null,
    -> primary key (id),
    -> foreign key (localid) references localizacoes(id),
    -> foreign key (tipoid) references tiposevento(id));
  ```

### Configuração do NetBeans

Tem que ter o driver do MySQL (direito do mouse em Libraries, clicar em
Add Library e escolher o MySQL JDBC Driver). Se não vier com o NetBeans,
tem que baixar (não sei como é pra fazer isso).
