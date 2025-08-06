-- JOIN 연습
-- JOIN: 두 개 이상의 테이블을 연결하여 관련 데이터를 하나의 결과로 출력할 때 사용
-- 		 외래 키 (Foreign key)를 통해 연결

-- INNER JOIN: 두 테이블에 모두 존재하는 행만 반환
-- 주문별 사용자 이름과 제품명, 수량, 주문일 조회
select u.name, p.product_name, o.quantity, o.order_date from orders o
inner join users u on o.user_id = u.user_id
inner join products p on o.product_id = p.product_id;

-- LEFT JOIN: 왼쪽 테이블의 모든 행
-- 			+ 오른쪽 테이블에서 일치하는 행 (없으면 NULL)
select o.order_id, u.name, o.order_date
from orders o
left join users u on u.users_id = o.users_id;

-- RIGHT JOIN: 오른쪽 테이블의 모든 행 
-- 			 + 왼쪽 테이블에서 일치하는 행 (없으면 NULL)
select u.user_id, u.name, o.order_id
from users u
right join orders o on u.user_id = o.user_id;

select * from orders order by order_date desc;

select * from orders order by order_date desc
limit 10 offset 0;
-- limit 10: 정렬된 데이터를 10개만 출력
-- offset 0: 분할 데이터의 첫 페이지 (1 ~ 10번 데이터)

select * from orders order by order_date desc
limit 10 offset 10;
-- limit 10: 정렬된 데이터를 10개만 출력
-- offset 10: 분할 데이터의 2 페이지 (11 ~ 20번 데이터)