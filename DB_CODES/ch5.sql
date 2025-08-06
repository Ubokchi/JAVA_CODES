select * from products;
select * from orders;

-- 1. 사용자별 주문 수량 총합
select user_id, sum(quantity) as 총_주문_수량
from orders
group by user_id;

-- 2. 제품별 주문 수량 총합 및 평균 주문 수량
select product_id,
	sum(quantity) as 총_주문_수량,
    avg(quantity) as 평균_주문_수량
from orders
group by product_id;

-- 3. 주문 날짜별 총 금액
select o.order_date, sum(o.quantity * p.price) as 총_매출액
from orders o
join products p on o.product_id = p.product_id
group by o.order_date
order by o.order_date;