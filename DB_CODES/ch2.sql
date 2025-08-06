-- 기본값(DEFAULT) 설정
create table ex_order(
	order_no int default 0,
    order_date datetime default current_timestamp
);

-- 날짜 문자열은 'YYYY-MM-DD' 형식으로 입력하거나 STR_TO_DATE 사용
insert into ex_order
values (1, '2024-02-29');

select * from ex_order;

-- 기본값 사용: ORDER_DATE는 자동으로 현재 시간 입력
insert into ex_order (order_no)
values(11);

-- 기본값 사용: order_no는 0으로, 날짜는 현재 시간
insert into ex_order (order_date)
values (current_timestamp());

-- 데이터 삭제 방법
delete from ex_order; -- 데이터만 삭제 (where 절 생략 시 전체 삭제)
truncate table ex_order; -- 모든 행 삭제 + auto_increment 초기화
drop table ex_order; -- 테이블 자체 삭제

-- auto_increment: 숫자 값을 자동으로 증가시켜주는 기능
-- 주로 기본키 (pk) 열에 고유 번호를 부여할 때 사용

create table ex9(
	col1 int auto_increment primary key,
    col2 varchar(10)
);

insert into ex9 (col2) values ('A');

select * from ex9;

select last_insert_id(); -- 현재 id값 반환