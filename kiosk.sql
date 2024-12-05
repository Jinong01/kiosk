create database  KoreaIT_teamWork1;

use KoreaIT_teamWork1;
create table category (id int primary key auto_increment comment '분류아이디',
	name varchar(30) not null comment '분류이름' , 
	status int comment '주문상태 1:판매중 0:No' ) comment '분류';

create table dish (id int primary key auto_increment comment '음식아이디' ,
	name varchar(30) not null comment '음식이름' ,
	category_id int not null , 
	price int not null,
	temperature varchar(30) comment '온도' ,
	shot varchar(30) comment '샷' , 
	status int comment '주문상태 1:판매중 0:No',
	foreign key (category_id) references category(id)) comment '음식' ;

create table dish_flavor (
    id int not null primary key auto_increment comment '취향',
    name varchar(20) not null comment '메뉴이름',
    temperature varchar(20) comment '온도',
    shot varchar(20) comment '샷',
    dish_id int not null comment '메뉴 아이디',
    foreign key (dish_id) references dish(id)
	)comment '메뉴 and 취향';
create table order_detail (
    id int not null auto_increment primary key comment '주문 명세 아이디',
    name varchar(20) not null comment '주문',
    order_id int not null comment '주문 아이디',
    dish_id int not null comment '메뉴 아이디',
    number int not null comment '갯수',
    price double not null comment '가격',
    foreign key (order_id) references orders(id),
    foreign key (dish_id) references dish(id)
)comment '주문 명세';
create table orders(
    id int not null primary key auto_increment comment '주문 아이디',
    user_id int not null comment '사용자 아이디',
    status int not null comment '주문상태 : 1.결제 대기 2.완료 3.취소됨 4.환불',
    order_time datetime not null comment '주문 시간',
    pay_method int comment '결재 수단 : 1.형금 2.신용 카드 3.삼성 4.카카오톡',
    pay_status int comment '결재 상태: 1.yes 0.no',
    end_time datetime comment '주문 종료시간',
    amount double comment '가격',
    cancel_reason varchar(30) comment '취소 이유',
    rejection_reason varchar(30) comment '거절 이유',
    cancel_time datetime default null comment '취소시간',
    point double comment '포인트',
    foreign key (user_id) references user(id)
)comment '주문';
create table shopping_cart(
    id int not null auto_increment primary key comment '장바구니 아이디',
    user_id int comment '사용자 아이디',
    dish_id int default null comment '메뉴 아이디',
    amount double not null comment '가격',
    number int default 0 comment '갯수',
    type varchar(10) comment '상태 : 1.포장 2.식사',
    create_time datetime null comment '장바구니 생성시간',
    foreign key (user_id) references user(id),
    foreign key (dish_id) references dish(id)
)comment '장바구니';
create table user (
    id int not null primary key auto_increment comment '사용자 아이디',
    name varchar(30)  comment '사용자 이름',
    phone_number varchar(11) not null comment '휴대폰 번호',
    point double comment '포인트',
    type int  comment '사용자 타입 : 1.회원 2.보통'
)comment '사용자';

insert into category (name) values ('커피');
insert into category (name) values ('티');
insert into category (name) values ('에이드');
insert into category (name) values ('디저트');

insert into dish (name , price, category_id) values ('아메리카노' , 1800, 1);
insert into dish (name , price, category_id) values ('카페라떼' , 2000,  1);
insert into dish (name , price , category_id) values ('카페모카' , 2000 ,1);
insert into dish (name , price , category_id) values ('카라멜 마키야또' , 2500 ,1);

insert into dish (name , price , category_id) values ('레몬티',2500,2);
insert into dish (name , price , category_id) values ('캐모마일티',3000,2);
insert into dish (name , price , category_id) values ('허브티',2800,2);
insert into dish (name , price , category_id) values ('유자티',3200,2);

insert into dish (name , price , category_id) values ('레몬에이드',2500,3);
insert into dish (name , price , category_id) values ('청포도에이드',2800,3);
insert into dish (name , price , category_id) values ('오렌지에이드',3000,3);
insert into dish (name , price , category_id) values ('딸기에이드',2500,3);

insert into dish (name , price , category_id) values ('와플',3000,4);
insert into dish (name , price , category_id) values ('소금빵',2000,4);
insert into dish (name , price , category_id) values ('초코케이크',4000,4);
insert into dish (name , price , category_id) values ('치즈케이크',4000,4);

#-----------------------------------실험용 코드-----------------------------------------------------------------
delete from shopping_cart where id>0; 
drop table shopping_cart;
drop table dish_flavor;
drop table user;
drop database KoreaIT_teamWork1;

select * from shopping_cart;
select * from dish_flavor;
select * from dish;
select * from category;
select * from user;

select cast((d.price * s.number)as double) from dish d,shopping_cart s where  d.id  = s.dish_id;
UPDATE shopping_cart s JOIN dish d ON s.dish_id = d.id
SET s.amount = CAST((d.price * s.number) AS DOUBLE) where s.id>0;
select d.name ,d.temperature , d.shot , s.number,s.amount from dish_flavor d , shopping_cart s where d.id = s.dish_id;
select d.name , s.number,s.amount from dish d , shopping_cart s where d.id = s.dish_id;
select name , temperature , shot , amount , number from dish_flavor natural join shopping_cart;