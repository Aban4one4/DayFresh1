--创建数据库
create database freshs default character set utf8 collate utf_8bin;

--切换库

user freshs

drop table if exists adminInfo;

--如果不存在则创建

--管理员信息表
create table if not exists adminInfo(
   aid int primary key auto_increment,
   aname varchar(100) not null unique,
   pwd varchar(100) not null,
   tel varchar(15) unique
)ENGINE=InnoDB default charset=utf8 collate=utf8_bin;

alter table menberInfo auto_increment=1001;
--修改自增列的起始值

insert into adminInfo values(0,'ly',password('666'),'15274099687');
insert into adminInfo values(0,'lxy',password('666'),'15274099671');

--会员信息表
  create table if not exists menberInfo(
  mno int primary key auto_increment,
  nickName varchar(100) not null unique,
  realName varchar(100),
  pwd varchar(100) not null,
  tel varchar(15) not null unique,
  email varchar(100) not null unique,
  photo varchar(100),
  regDate datetime,
  status int 
)ENGINE=InnoDB default charset=utf8 collate=utf8_bin;


--商品类型表

create table if not exists goodsType(
   tno int primary key auto_increment,
   tname varchar(100) not null,
   status int 
)ENGINE=InnoDB default charset=utf8 collate=utf8_bin;

insert into goodsType values(0,'新鲜水果',1),(0,'海鲜水产',1),(0,'猪肉羊肉',1),(0,'禽类蛋品',1),(0,'新鲜蔬菜',1),(0,'速冻食品',1);

--商品信息表
create table if not exists goodsInfo(
   gno int primary key auto_increment,
   gname varchar(100) not null,
   tno int ,
   price decimal(8,2),
   balance int ,
   pics varchar(1000),
   unit varchar(50),
   qperied varchar(50),
   weight varchar(50),
   descr text,
    constraint FK_goodsInfo_tno foreign key(tno) references goodsType(tno)
)ENGINE=InnoDB default charset=utf8 collate=utf8_bin;

--购物车表
create table if not exists cartInfo(
    cno int primary key auto_increment,
    mno int,
    gno int,
    num int,
    constraint FK_cartInfo_mno foreign key(mno) references menberInfo(mno),
    constraint FK_cartInfo_gno foreign key(gno) references goodsInfo(gno)
)ENGINE=InnoDB default charset=utf8 collate=utf8_bin;

--地址表
create table if not exists addrInfo(
    ano varchar(100) primary key,
    mno int,
    name varchar(100) not null,
    tel  varchar(15) not null,
    province varchar(100)not null,
    city varchar(100) not null,
    area varchar(100) not null,
    addr varchar(100) not null,
    flag int,
    status int ,
    constraint FK_addrInfo_mno foreign key(mno) references menberInfo(mno)
)ENGINE=InnoDB default charset=utf8 collate=utf8_bin;

--购物车表
create table if not exists cartInfo(
    cno int primary key auto_increment,
    mno int,
    gno int,
    num int,
    constraint FK_cartInfo_mno foreign key(mno) references menberInfo(mno),
    constraint FK_cartInfo_gno foreign key(gno) references goodsInfo(gno)
)ENGINE=InnoDB default charset=utf8 collate=utf8_bin;



--订单表

create table if not exists orderInfo(
    ono varchar(100) primary key ,
    odate datetime,
    ano varchar(100),
    sdate datetime,
    rdate datetime,
    status int,
    price decimal(10,2),
    invoice int,
    constraint FK_orderInfo_ano foreign key(ano) references addrInfo(ano)
)ENGINE=InnoDB default charset=utf8 collate=utf8_bin;

--订单详细表

create table if not exists orderItemInfo(
    ino int primary key,
    ono varchar(100),
    gno int,
    nums int,
    price decimal(10,2),
    status int,
    constraint FK_orderItemInfo_gno foreign key(gno) references goodsInfo(gno),
    constraint FK_orderItemInfo_ono foreign key(ono) references orderInfo(ono)
)ENGINE=InnoDB default charset=utf8 collate=utf8_bin;
