-- MEMBER 테이블 생성
create table ex_member (
	id varchar(20) primary key,
    pw varchar(20),
    email varchar(100)
);
	
-- 데이터 등록
insert into ex_member
values ('admin', 'admin1234', 'admin@test.com');

insert into ex_member
values ('guest', 'guest1234', 'guest@test.com');

-- 특정 컬럼에만 데이트를 등록할 경우 컬럼 이름을 명시
insert into ex_member (id, pw)
values ('test', 'test1234');

-- 전체 데이터 조회
select * from ex_member;

-- 특정 컬럼 조회
select id, pw from ex_member;

-- id가 'test'인 사용자 조회
select * from ex_member
where id = 'test';

-- guest 사용자의 이메일을 수정
update ex_member
set email = 'UPDATE@TEST.COM'
where id = 'guest';

-- guest 사용자 삭제
delete from ex_member
where id = 'guest';

-- STUDENT 테이블 생성
create table ex_student(
	id int auto_increment primary key,
    name varchar(20) not null,
    birthday datetime default current_timestamp,
    email varchar(100)
);

insert into ex_student(name, birthday, email)
values('Aaa', '2000-01-01', 'aaa@test.com');

-- name만 등록
insert into ex_student (name)
values('Bbb');

-- name, email 등록
insert into ex_student (name, email)
values ('Abc', 'abc@test.com');

-- name, birthday 등록
insert into ex_student (name, birthday)
values ('aaa', '2000-01-01');

select * from ex_student;

-- mysql에서 대소문자를 구문하지 않으므로
-- COLLATE utf8mb4_bin 추가하여 대소문자 구분한다.

select id, name from ex_student
order by id COLLATE utf8mb4_bin desc; -- id 기준으로 내림차순 정렬

select * from ex_student
order by birthday COLLATE utf8mb4_bin asc; -- birthday 기준으로 오름차순 정렬

-- name 기준으로 정렬
select * from ex_student
order by name COLLATE utf8mb4_bin ;

-- name이 'A'로 시작하는 데이터
select * from ex_student
where name COLLATE utf8mb4_bin like 'A%';

-- name이 'A'로 끝나는 데이터
select * from ex_student
where name COLLATE utf8mb4_bin like '%A';

-- 2000년 1월 1일 이후 출생한 학생
select * from ex_student
where birthday >= '2000-01-01';

-- name이 A로 시작하고, email이 null이 아닌 경우
select * from ex_student
where binary name like 'A%' and email is not null;

-- name이 A로 시작하거나, B로 시작하는 경우
select * from ex_student
where binary name like 'A%' or binary name like 'B%';


    
