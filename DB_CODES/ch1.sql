-- 한 줄 주석
/* 여러 줄 주석 */

create table ex1(
	col1 INT,	-- 정수
    col2 VARCHAR(100), -- 문자열
    col3 DATETIME -- 날짜 + 시간
);

insert into ex1 values(
	100,
    'Hello',
    now()
);

-- 잘못된 데이터 타입 등록 예시
insert into ex1 values(
	'abcd',
    200,
    now()
);

create table ex2 (
	col1 varchar(3),
    col2 varchar(6)
);

-- varchar(3) 최대 3자까지 문자열 저장 가능
insert into ex2 values('abc', 'abc');

-- 'abcd'는 4글자이므로 col1에 저장 불가
insert into ex2 values('abcd', 'abcd');

insert into ex2 values('한글날', '한글날');

show create table ex2;

-- varchar(n): n은 문자 길이를 의미
-- * 현재 mysql은 utf8mb4로 charset되어 있어서
-- n이 영어, 한글, 이모지 모두 1글자로 취급

-- * 제약 조건: 테이블 칼럼에 조건을 설정하여, 데이터 등록 시 제약을 거는 방법
create table ex3 (
	col1 varchar(10) not null,
	col2 varchar(20) unique
);
    
insert into ex3 values ('AA', 'BB');
    
-- 중복 UNIQUE 위반
insert into ex3 values ('aa', 'BB');
    
-- ex3 테이블의 col2 에 'CC' 데이터 등록
-- col1 에는 null이 등록됨
insert into ex3 (col2) values ('CC');
-- NOT NULL 위반
    
-- * 기본키 (PRIMARY kEY)
-- NOT NULL과 UNIQUE를 동시에 적용하는 제약 조건
-- 테이블에서 각 행을 유일하게 식별할 수 있는 칼럼
    
create table ex4 (
	col1 varchar(10) primary key,
	col2 varchar(10)
);
    
insert into ex4 values ('AB', 'CD');
    
-- PRIMARY KEY 중복 오류
insert into ex4 values ('AB', 'EF');
    
-- NOT NULL 위반
insert into ex4 (col2) values ('ABC');
    
-- 제약 조건 이름 지정
create table ex5(
	col1 varchar(10),
	col2 varchar(10),
	constraint pk_ex5 primary key(col1)
);

create table ex6 (
	col1 varchar(10),
    constraint un_ex6 unique (col1)
);

create table ex7 (
	age int check (age >= 0),
    gender varchar(10),
    constraint check_gender check(gender in('남', '여'))
);

insert into ex7 values (12, '남자');

-- alter table: 테이블의 상태를 변경
alter table ex7 add constraint un_ex7 unique (age);

create table ex8 (
	col1 int,
    col2 varchar(10)
);

-- 컬럼명 변경
alter table ex8 rename column col1 to age;
show columns from ex8;

-- 데이터 타입 변경
alter table ex8 modify col2 int;

-- 컬럼 추가
alter table ex8 add col3 datetime;

-- 컬럼 삭제
alter table ex8 drop column col3;