-- USER 유저
insert into users(user_name, user_type, profile_image, is_deleted, created_at, last_modified_at)
values ('나든', 'HOST', 'http://nathan-face', false, '2022-01-01 00:00:01', '2022-01-01 00:00:01');

insert into users(user_name, user_type, profile_image, is_deleted, created_at, last_modified_at)
values ('복희', 'CUSTOMER', 'http://forky-face', false, '2020-07-07 00:00:01', '2020-07-07 00:00:01');

insert into users(user_name, user_type, profile_image, is_deleted, created_at, last_modified_at)
values ('제의', 'CUSTOMER', 'http://jay-face', false, '2020-09-12 00:00:01', '2021-09-07 00:00:01');

insert into users(user_name, user_type, profile_image, is_deleted, created_at, last_modified_at)
values ('스탉흐', 'SUPER_HOST', 'http://stark-face', false, '2020-03-07 00:00:01', '2021-10-07 00:00:01');

-- REGION 지역
insert into region(region_name, region_image, coordinate)
values ('SEOUL', 'http://seoul', ST_GeomFromText('POINT(126.978 37.5665)'));
insert into region(region_name, region_image, coordinate)
values ('GWANGJU', 'http://seoul', ST_GeomFromText('POINT(126.8526 35.1595)'));
insert into region(region_name, region_image, coordinate)
values ('UIJEONGBU', 'http://seoul', ST_GeomFromText('POINT(127.0337 37.7381)'));
insert into region(region_name, region_image, coordinate)
values ('SUWON', 'http://seoul', ST_GeomFromText('POINT(127.0286 37.2636)'));
insert into region(region_name, region_image, coordinate)
values ('DAEGU', 'http://seoul', ST_GeomFromText('POINT(128.6014 35.8714)'));
insert into region(region_name, region_image, coordinate)
values ('ULJIN', 'http://seoul', ST_GeomFromText('POINT(129.4004 36.9931)'));
insert into region(region_name, region_image, coordinate)
values ('DAEJUN', 'http://seoul', ST_GeomFromText('POINT(126.7660 36.3504)'));
insert into region(region_name, region_image, coordinate)
values ('BUCHEON', 'http://seoul', ST_GeomFromText('POINT(126.9780 37.5665)'));

-- EVENT 이벤트
insert into event(event_name, event_image, is_deleted, created_at, last_modified_at)
values ('봄에 가기 좋은 숙소',
        'https://user-images.githubusercontent.com/79504043/169987721-839ddb22-7aff-49f2-bad0-76ffc0f8f249.png', false,
        '2022-06-04 16:37:00', '2022-06-04 16:37:00');
insert into event(event_name, event_image, is_deleted, created_at, last_modified_at)
values ('여름에 가기 좋은 숙소',
        'https://user-images.githubusercontent.com/79504043/169987721-839ddb22-7aff-49f2-bad0-76ffc0f8f249.png', false,
        '2022-06-04 16:37:00', '2022-06-04 16:37:00');
insert into event(event_name, event_image, is_deleted, created_at, last_modified_at)
values ('가을에 가기 좋은 숙소',
        'https://user-images.githubusercontent.com/79504043/169987721-839ddb22-7aff-49f2-bad0-76ffc0f8f249.png', false,
        '2022-06-04 16:37:00', '2022-06-04 16:37:00');
insert into event(event_name, event_image, is_deleted, created_at, last_modified_at)
values ('겨울에 가기 좋은 숙소',
        'https://user-images.githubusercontent.com/79504043/169987721-839ddb22-7aff-49f2-bad0-76ffc0f8f249.png', false,
        '2022-06-04 16:37:00', '2022-06-04 16:37:00');

-- ACCOMMODATION 숙소
insert into accommodation(accommodation_name, accommodation_description, accommodation_type,
                          price, main_image, cleaning_fee, service_fee, accommodation_tax,
                          country, city, first_address, second_address, zipcode, coordinate,
                          maximum_guest_number, room_count, bed_count, bathroom_count,
                          check_in_time, check_out_time, user_id, region_id, is_deleted, created_at, last_modified_at, discount_policy)
values ('나단의 게스트하우스', '나단이 살아요', 'HOTEL', 10000, 'http://main_image', 0.02, 0.02, 0.02, 'SOUTH_KOREA', 'SEOUL', '동대문구 회기로 196 회기역사',
        '외대앞', '12345',ST_GeomFromText('POINT(18 -63)'),
        3, 2, 1, 1, 14, 12, 1, 1, false, '2022-01-01 00:00:01', '2022-01-01 00:00:01', 'WEEKLY');
insert into accommodation(accommodation_name, accommodation_description, accommodation_type,
                          price, main_image, cleaning_fee, service_fee, accommodation_tax,
                          country, city, first_address, second_address, zipcode, coordinate,
                          maximum_guest_number, room_count, bed_count, bathroom_count,
                          check_in_time, check_out_time, user_id, region_id, is_deleted, created_at, last_modified_at, discount_policy)
values ('스타크의 호텔', '토니 스타크가 살아요', 'HOTEL', 70000, 'http://main_image', 0.02, 0.02, 0.02, 'SOUTH_KOREA', 'SEOUL', '동대문구 회기로 196 회기역사',
        '서울시립대앞', '12345',ST_GeomFromText('POINT(127.0556 37.5851)'),
        3, 2, 1, 1, 14, 12, 1, 1, false, '2022-01-01 00:00:01', '2022-01-01 00:00:01', 'WEEKLY');
insert into accommodation(accommodation_name, accommodation_description, accommodation_type,
                          price, main_image, cleaning_fee, service_fee, accommodation_tax,
                          country, city, first_address, second_address, zipcode, coordinate,
                          maximum_guest_number, room_count, bed_count, bathroom_count,
                          check_in_time, check_out_time, user_id, region_id, is_deleted, created_at, last_modified_at, discount_policy)
values ('제이의 모텔', '제이가 살아요', 'HOTEL', 30000, 'http://main_image', 0.02, 0.02, 0.02, 'SOUTH_KOREA', 'SEOUL', '동작구 남부순환로 2089',
        '사당앞', '12345',ST_GeomFromText('POINT(126.9770 37.4799)'),
        3, 2, 1, 1, 14, 12, 1, 1, false, '2022-01-01 00:00:01', '2022-01-01 00:00:01', 'WEEKLY');
insert into accommodation(accommodation_name, accommodation_description, accommodation_type,
                          price, main_image, cleaning_fee, service_fee, accommodation_tax,
                          country, city, first_address, second_address, zipcode, coordinate,
                          maximum_guest_number, room_count, bed_count, bathroom_count,
                          check_in_time, check_out_time, user_id, region_id, is_deleted, created_at, last_modified_at, discount_policy)
values ('포키의 레지던스', '포키는 안살아요', 'HOTEL', 1000000, 'http://main_image', 0.03, 0.03, 0.02, 'SOUTH_KOREA', 'SEOUL', '노원구 상계로 69-1',
        '노원앞', '12345',ST_GeomFromText('POINT(127.0522 37.6766)'),
        3, 2, 1, 1, 14, 12, 1, 1, false, '2022-01-01 00:00:01', '2022-01-01 00:00:01', 'WEEKLY');

-- ACCOMMODATION IMAGE 숙소 이미지
insert into accommodation_image(accommodation_id,url, is_deleted, created_at, last_modified_at)
values(1, 'https://user-images.githubusercontent.com/57708971/171983097-bb00919f-9737-4b84-b050-19f314379147.png',
       false, '2022-06-04 00:00:01', '2022-06-04 00:00:01');
insert into accommodation_image(accommodation_id,url, is_deleted, created_at, last_modified_at)
values(1, 'https://user-images.githubusercontent.com/57708971/171983178-4f65a1b8-f9d1-437b-8104-c638262ed9c5.png',
       false, '2022-06-04 00:00:01', '2022-06-04 00:00:01');

insert into accommodation_image(accommodation_id,url, is_deleted, created_at, last_modified_at)
values(2, 'https://user-images.githubusercontent.com/57708971/171983097-bb00919f-9737-4b84-b050-19f314379147.png',
       false, '2022-06-04 00:00:01', '2022-06-04 00:00:01');
insert into accommodation_image(accommodation_id,url, is_deleted, created_at, last_modified_at)
values(2, 'https://user-images.githubusercontent.com/57708971/171983178-4f65a1b8-f9d1-437b-8104-c638262ed9c5.png',
       false, '2022-06-04 00:00:01', '2022-06-04 00:00:01');

insert into accommodation_image(accommodation_id,url, is_deleted, created_at, last_modified_at)
values(3, 'https://user-images.githubusercontent.com/57708971/171983097-bb00919f-9737-4b84-b050-19f314379147.png',
       false, '2022-06-04 00:00:01', '2022-06-04 00:00:01');
insert into accommodation_image(accommodation_id,url, is_deleted, created_at, last_modified_at)
values(3, 'https://user-images.githubusercontent.com/57708971/171983178-4f65a1b8-f9d1-437b-8104-c638262ed9c5.png',
       false, '2022-06-04 00:00:01', '2022-06-04 00:00:01');

insert into accommodation_image(accommodation_id,url, is_deleted, created_at, last_modified_at)
values(4, 'https://user-images.githubusercontent.com/57708971/171983097-bb00919f-9737-4b84-b050-19f314379147.png',
       false, '2022-06-04 00:00:01', '2022-06-04 00:00:01');
insert into accommodation_image(accommodation_id,url, is_deleted, created_at, last_modified_at)
values(4, 'https://user-images.githubusercontent.com/57708971/171983178-4f65a1b8-f9d1-437b-8104-c638262ed9c5.png',
       false, '2022-06-04 00:00:01', '2022-06-04 00:00:01');

-- FAVORITE 유저의 위시리스트
insert into favorite(accommodation_id, user_id) values (1, 1);
insert into favorite(accommodation_id, user_id) values (2, 1);
insert into favorite(accommodation_id, user_id) values (3, 1);
insert into favorite(accommodation_id, user_id) values (4, 1);

insert into favorite(accommodation_id, user_id) values (1, 2);
insert into favorite(accommodation_id, user_id) values (2, 2);
insert into favorite(accommodation_id, user_id) values (3, 2);

insert into favorite(accommodation_id, user_id) values (1, 3);
insert into favorite(accommodation_id, user_id) values (3, 3);
insert into favorite(accommodation_id, user_id) values (4, 3);

-- REVIEW 리뷰
insert into review(created_at, last_modified_at, is_deleted, content, star_rating, accommodation_id, user_id)
values ('2022-01-01 00:10:01', '2022-01-01 00:10:01', false, '숙소 정말 엉망이네요;; 최악입니다!', 2.7, 2, 2);

insert into review(created_at, last_modified_at, is_deleted, content, star_rating, accommodation_id, user_id)
values ('2022-01-01 00:10:01', '2022-01-01 00:10:01', false, '악플보고 망설였는데, 너무 괜찮았습니다. 도대체 어떤 삶을 살아오신건지;;', 4.7, 2, 3);

insert into review(created_at, last_modified_at, is_deleted, content, star_rating, accommodation_id, user_id)
values ('2022-01-01 00:10:01', '2022-01-01 00:10:01', false, '개 별 로.', 0.7, 1, 2);

insert into review(created_at, last_modified_at, is_deleted, content, star_rating, accommodation_id, user_id)
values ('2022-01-01 00:10:01', '2022-01-01 00:10:01', false, '코브스 선정 최악의 숙소 1위', 1.7, 1, 3);


-- reservation 예약
insert into reservation(created_at, is_deleted, last_modified_at, check_in_date, check_out_date, accommodation_id, user_id, guest_count, total_price)
values('2022-01-01 00:10:01',false,'2022-01-01 00:10:01', '2022-05-24', '2022-05-26', 1, 4, 3, 12345678);

insert into reservation(created_at, is_deleted, last_modified_at, check_in_date, check_out_date, accommodation_id, user_id, guest_count, total_price)
values('2022-01-01 00:10:01',false,'2022-01-01 00:10:01', '2022-06-10', '2022-06-11', 2, 4, 2, 34567891);

insert into reservation(created_at, is_deleted, last_modified_at, check_in_date, check_out_date, accommodation_id, user_id, guest_count, total_price)
values('2022-01-01 00:10:01',false,'2022-01-01 00:10:01', '2022-05-22', '2022-05-23', 3, 4, 4, 83567891);
