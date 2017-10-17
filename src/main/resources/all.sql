drop database if exists ts_lqz;
create database ts_lqz default character set utf8;
use ts_lqz;
SET FOREIGN_KEY_CHECKS=0;



create table studentinform_lqz(
stuid varchar(10) primary key,
stuname varchar(20),
stusex varchar(5),
stuage varchar(3),
stuadd varchar(50),
stutel varchar(11),
stuqq varchar(11),
stuemail varchar(30),
stuclass varchar(10),
stuprocour varchar(50)
);
create table userinform_lqz(
usertype char(1),
username varchar(10) primary key,
userpwd varchar(16)
);
insert into userinform_lqz values('0','admin','12345678');
create table teacherinform_lqz(
teaid varchar(10) primary key,
teaname varchar(20),
teasex varchar(5),
teaage varchar(3),
teatel varchar(11),
teaadd varchar(50),
teajob varchar(20),
teaqq varchar(11),
teaemail varchar(30),
teaexp varchar(50)
);
create table teacourinfom_lqz(
couid varchar(10) primary key,
couname varchar(20),
coustytime varchar(10),
couscore varchar(2),
coustatime varchar(20),
couteaname varchar(20),
couteaid varchar(10) references teacherinform_lqz(teaid)
);
create table courinform_lqz(
  stuid varchar(10) references studentinform_lqz(stuid),
  stucouid varchar(10)  references teacourinfom_lqz(couid),
  stucouname varchar(20),
  stustytime varchar(10),
  stuscore varchar(2),
  stustatime varchar(20),
  teaname varchar(20),
  teaid varchar(10)
);

