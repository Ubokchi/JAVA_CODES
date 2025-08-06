-- USERS 테이블 생성
CREATE TABLE users (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50),
    email VARCHAR(100)
);

-- PRODUCTS 테이블 생성
CREATE TABLE products (
    product_id INT AUTO_INCREMENT PRIMARY KEY,
    product_name VARCHAR(100),
    price DECIMAL(10, 2)
);

-- ORDERS 테이블 생성
CREATE TABLE orders (
    order_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT,
    product_id INT,
    quantity INT,
    order_date DATE,
    FOREIGN KEY (user_id) REFERENCES users(user_id),
    FOREIGN KEY (product_id) REFERENCES products(product_id)
);

-- USERS 데이터 (24명)
INSERT INTO users (name, email) VALUES
('김철수', 'chulsoo@example.com'),
('이영희', 'younghee@example.com'),
('박민수', 'minsoo@example.com'),
('최지우', 'jiwoo@example.com'),
('정다은', 'daeun@example.com'),
('한서준', 'seojun@example.com'),
('윤아름', 'areum@example.com'),
('오세훈', 'sehun@example.com'),
('장예린', 'yerin@example.com'),
('배지훈', 'jihun@example.com'),
('유하늘', 'haneul@example.com'),
('문소연', 'soyeon@example.com'),
('홍유진', 'yujin@example.com'),
('강다현', 'dahyun@example.com'),
('서지민', 'jimin@example.com'),
('노진우', 'jinwoo@example.com'),
('백수연', 'suyeon@example.com'),
('하도윤', 'doyoon@example.com'),
('조은비', 'eunbi@example.com'),
('남시우', 'siwoo@example.com'),
('전하린', 'harin@example.com'),
('임채영', 'chaeyoung@example.com'),
('신윤호', 'yunho@example.com'),
('권예지', 'yeji@example.com');

-- PRODUCTS 데이터 (10개)
INSERT INTO products (product_name, price) VALUES
('노트북', 1200000.00),
('스마트폰', 800000.00),
('키보드', 50000.00),
('마우스', 25000.00),
('모니터', 300000.00),
('프린터', 200000.00),
('태블릿', 600000.00),
('USB 드라이브', 15000.00),
('외장하드', 100000.00),
('헤드셋', 75000.00);

-- ORDERS 데이터 (예시 24개)
INSERT INTO orders (user_id, product_id, quantity, order_date) VALUES
(1, 1, 1, '2025-08-01'),
(1, 2, 2, '2025-08-02'),
(2, 3, 1, '2025-08-02'),
(3, 4, 3, '2025-08-03'),
(4, 5, 1, '2025-08-03'),
(5, 6, 2, '2025-08-04'),
(6, 7, 1, '2025-08-04'),
(7, 8, 4, '2025-08-05'),
(8, 9, 1, '2025-08-05'),
(9, 10, 1, '2025-08-06'),
(10, 1, 1, '2025-08-06'),
(11, 2, 2, '2025-08-07'),
(12, 3, 1, '2025-08-07'),
(13, 4, 1, '2025-08-08'),
(14, 5, 2, '2025-08-08'),
(15, 6, 1, '2025-08-09'),
(16, 7, 2, '2025-08-09'),
(17, 8, 3, '2025-08-10'),
(18, 9, 1, '2025-08-10'),
(19, 10, 1, '2025-08-11'),
(20, 1, 1, '2025-08-11'),
(21, 2, 1, '2025-08-12'),
(22, 3, 2, '2025-08-12'),
(23, 4, 1, '2025-08-13');

select * from users;
select * from products;
select * from orders;

-- 제품 종류 수
select count(*) as 제품_총_개수 from products;
-- as 문자열: 기존 컬럼 명을 별명으로 변경

-- 제품 중 가장 비싼 물건의 가격
select max(price) as 최고가격 from products;

-- 제품 중 가장 싼 물건의 가격
select min(price) as 최저_가격 from products;

-- 전체 제품 가격 합계
select sum(price) as 제품_가격_합계 from products;

-- 평균 제품 가격
select avg(price) as 평슌_제품_가격 from products;

-- 중복 없는 구매 사용자 수
select count(distinct user_id) as 주문한_사용자_수 from orders;

-- CONCAT 예시
SELECT CONCAT(name, '님의 이메일은 ', email) AS 소개문
FROM users
LIMIT 3;

-- LOWER 예시
SELECT name, LOWER(email) AS 이메일_소문자
FROM users
LIMIT 3;

-- TRIM 예시
SELECT CONCAT('---', TRIM('   김철수   '), '---') AS 트림_결과;

-- SUBSTRING 예시
SELECT name, SUBSTRING(email, 1, 5) AS 이메일_앞_5글자
FROM users
LIMIT 3;

-- REPLACE 예시
SELECT email, REPLACE(email, 'example.com', 'gmail.com') AS 이메일_도메인변경
FROM users
LIMIT 3;

-- 도메인 소문자 변환 + '@' 이후 문자열 추출
SELECT email, LOWER(SUBSTRING(email, LOCATE('@', email) + 1)) AS 도메인_소문자
FROM users
LIMIT 3;


-- 오늘 날짜 출력
SELECT CURDATE() AS 오늘날짜;

-- 현재 날짜 및 시간 출력
SELECT NOW() AS 현재시간;

-- 특정 날짜 더하기 (5일 후)
SELECT DATE_ADD('2025-08-01', INTERVAL 5 DAY) AS 날짜_5일후;

-- 특정 날짜 빼기 (7일 전)
SELECT DATE_SUB('2025-08-10', INTERVAL 7 DAY) AS 날짜_7일전;

-- 날짜 차이 구하기 (며칠 차이인지)
SELECT DATEDIFF('2025-08-10', '2025-08-01') AS 날짜차이_일수;

-- 연도, 월, 일 추출
SELECT
    YEAR('2025-08-05') AS 연도,
    MONTH('2025-08-05') AS 월,
    DAY('2025-08-05') AS 일;

-- 주문일이 이번 달인 주문 조회
SELECT * FROM orders
WHERE YEAR(order_date) = YEAR(CURDATE())
  AND MONTH(order_date) = MONTH(CURDATE());

-- 이번 달 첫째 날과 마지막 날 구하기
SELECT
    DATE_FORMAT(CURDATE() ,'%Y-%m-01') AS 이번달_첫째날,
    LAST_DAY(CURDATE()) AS 이번달_마지막날;

-- 주문 날짜가 이번 주(월~일) 안에 있는 주문 조회 (요일 기준 ISO, 월요일 시작)
SELECT * FROM orders
WHERE YEARWEEK(order_date, 1) = YEARWEEK(CURDATE(), 1);



