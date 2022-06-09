-- USER 유저
insert into users(user_name, user_type, profile_image, is_deleted, created_at, last_modified_at)
values ('나든', 'HOST', 'https://user-images.githubusercontent.com/57708971/172747451-021fa091-430d-43f0-bb6d-5babdf40ae2d.png', false, '2022-01-01 00:00:01', '2022-01-01 00:00:01');

insert into users(user_name, user_type, profile_image, is_deleted, created_at, last_modified_at)
values ('복희', 'CUSTOMER', 'https://user-images.githubusercontent.com/57708971/172747451-021fa091-430d-43f0-bb6d-5babdf40ae2d.png', false, '2020-07-07 00:00:01', '2020-07-07 00:00:01');

insert into users(user_name, user_type, profile_image, is_deleted, created_at, last_modified_at)
values ('제의', 'CUSTOMER', 'https://user-images.githubusercontent.com/57708971/172747451-021fa091-430d-43f0-bb6d-5babdf40ae2d.png', false, '2020-09-12 00:00:01', '2021-09-07 00:00:01');

insert into users(user_name, user_type, profile_image, is_deleted, created_at, last_modified_at)
values ('스탉흐', 'SUPER_HOST', 'https://user-images.githubusercontent.com/57708971/172747451-021fa091-430d-43f0-bb6d-5babdf40ae2d.png', false, '2020-03-07 00:00:01', '2021-10-07 00:00:01');

-- REGION 지역
insert into region(region_name, region_image, coordinate)
values ('SEOUL', 'https://user-images.githubusercontent.com/57708971/172747377-d9149944-4926-4fc3-9011-9196b7f48a1f.png', ST_GeomFromText('POINT(126.978 37.5665)'));
insert into region(region_name, region_image, coordinate)
values ('GWANGJU', 'https://user-images.githubusercontent.com/57708971/172747377-d9149944-4926-4fc3-9011-9196b7f48a1f.png', ST_GeomFromText('POINT(126.8526 35.1595)'));
insert into region(region_name, region_image, coordinate)
values ('UIJEONGBU', 'https://user-images.githubusercontent.com/57708971/172747377-d9149944-4926-4fc3-9011-9196b7f48a1f.png', ST_GeomFromText('POINT(127.0337 37.7381)'));
insert into region(region_name, region_image, coordinate)
values ('SUWON', 'https://user-images.githubusercontent.com/57708971/172747377-d9149944-4926-4fc3-9011-9196b7f48a1f.png', ST_GeomFromText('POINT(127.0286 37.2636)'));
insert into region(region_name, region_image, coordinate)
values ('DAEGU', 'https://user-images.githubusercontent.com/57708971/172747377-d9149944-4926-4fc3-9011-9196b7f48a1f.png', ST_GeomFromText('POINT(128.6014 35.8714)'));
insert into region(region_name, region_image, coordinate)
values ('ULJIN', 'https://user-images.githubusercontent.com/57708971/172747377-d9149944-4926-4fc3-9011-9196b7f48a1f.png', ST_GeomFromText('POINT(129.4004 36.9931)'));
insert into region(region_name, region_image, coordinate)
values ('DAEJUN', 'https://user-images.githubusercontent.com/57708971/172747377-d9149944-4926-4fc3-9011-9196b7f48a1f.png', ST_GeomFromText('POINT(126.7660 36.3504)'));
insert into region(region_name, region_image, coordinate)
values ('BUCHEON', 'https://user-images.githubusercontent.com/57708971/172747377-d9149944-4926-4fc3-9011-9196b7f48a1f.png', ST_GeomFromText('POINT(126.9780 37.5665)'));

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
values ('나단의 게스트하우스', '나단이 살아요', 'HOTEL', 10000, 'https://user-images.githubusercontent.com/57708971/171983097-bb00919f-9737-4b84-b050-19f314379147.png', 0.02, 0.02, 0.02, 'SOUTH_KOREA', 'SEOUL', '동대문구 회기로 196 회기역사',
        '외대앞', '12345',ST_GeomFromText('POINT(18 -63)'),
        3, 2, 1, 1, 14, 12, 1, 1, false, '2022-01-01 00:00:01', '2022-01-01 00:00:01', 'WEEKLY');
insert into accommodation(accommodation_name, accommodation_description, accommodation_type,
                          price, main_image, cleaning_fee, service_fee, accommodation_tax,
                          country, city, first_address, second_address, zipcode, coordinate,
                          maximum_guest_number, room_count, bed_count, bathroom_count,
                          check_in_time, check_out_time, user_id, region_id, is_deleted, created_at, last_modified_at, discount_policy)
values ('스타크의 호텔', '토니 스타크가 살아요', 'HOTEL', 70000, 'https://user-images.githubusercontent.com/57708971/171983097-bb00919f-9737-4b84-b050-19f314379147.png', 0.02, 0.02, 0.02, 'SOUTH_KOREA', 'SEOUL', '동대문구 회기로 196 회기역사',
        '서울시립대앞', '12345',ST_GeomFromText('POINT(127.0556 37.5851)'),
        3, 2, 1, 1, 14, 12, 1, 1, false, '2022-01-01 00:00:01', '2022-01-01 00:00:01', 'WEEKLY');
insert into accommodation(accommodation_name, accommodation_description, accommodation_type,
                          price, main_image, cleaning_fee, service_fee, accommodation_tax,
                          country, city, first_address, second_address, zipcode, coordinate,
                          maximum_guest_number, room_count, bed_count, bathroom_count,
                          check_in_time, check_out_time, user_id, region_id, is_deleted, created_at, last_modified_at, discount_policy)
values ('제이의 모텔', '제이가 살아요', 'HOTEL', 30000, 'https://user-images.githubusercontent.com/57708971/171983097-bb00919f-9737-4b84-b050-19f314379147.png', 0.02, 0.02, 0.02, 'SOUTH_KOREA', 'SEOUL', '동작구 남부순환로 2089',
        '사당앞', '12345',ST_GeomFromText('POINT(126.9770 37.4799)'),
        3, 2, 1, 1, 14, 12, 1, 1, false, '2022-01-01 00:00:01', '2022-01-01 00:00:01', 'WEEKLY');
insert into accommodation(accommodation_name, accommodation_description, accommodation_type,
                          price, main_image, cleaning_fee, service_fee, accommodation_tax,
                          country, city, first_address, second_address, zipcode, coordinate,
                          maximum_guest_number, room_count, bed_count, bathroom_count,
                          check_in_time, check_out_time, user_id, region_id, is_deleted, created_at, last_modified_at, discount_policy)
values ('포키의 레지던스', '포키는 안살아요', 'HOTEL', 1000000, 'https://user-images.githubusercontent.com/57708971/171983097-bb00919f-9737-4b84-b050-19f314379147.png', 0.03, 0.03, 0.02, 'SOUTH_KOREA', 'SEOUL', '노원구 상계로 69-1',
        '노원앞', '12345',ST_GeomFromText('POINT(127.0522 37.6766)'),
        3, 2, 1, 1, 14, 12, 1, 1, false, '2022-01-01 00:00:01', '2022-01-01 00:00:01', 'WEEKLY');
insert into accommodation(accommodation_name, accommodation_description, accommodation_type,
                          price, main_image, cleaning_fee, service_fee, accommodation_tax,
                          country, city, first_address, second_address, zipcode, coordinate,
                          maximum_guest_number, room_count, bed_count, bathroom_count,
                          check_in_time, check_out_time, user_id, region_id, is_deleted, created_at, last_modified_at, discount_policy)
values ('창동 숙소', '창동 별로임', 'HOTEL', 1000000, 'https://user-images.githubusercontent.com/57708971/171983097-bb00919f-9737-4b84-b050-19f314379147.png', 0.03, 0.03, 0.02, 'SOUTH_KOREA', 'SEOUL', '노원구 도봉구 69-1',
        '창동역앞', '12345',ST_GeomFromText('POINT(127.0522 37.6766)'),
        3, 2, 1, 1, 14, 12, 1, 1, false, '2022-01-01 00:00:01', '2022-01-01 00:00:01', 'WEEKLY');
insert into accommodation(accommodation_name, accommodation_description, accommodation_type,
                          price, main_image, cleaning_fee, service_fee, accommodation_tax,
                          country, city, first_address, second_address, zipcode, coordinate,
                          maximum_guest_number, room_count, bed_count, bathroom_count,
                          check_in_time, check_out_time, user_id, region_id, is_deleted, created_at, last_modified_at, discount_policy)
values ('코드스쿼드', '애매한 위치', 'GUEST_HOUSE', 1000000, 'https://user-images.githubusercontent.com/57708971/171983097-bb00919f-9737-4b84-b050-19f314379147.png', 0.03, 0.03, 0.02, 'SOUTH_KOREA', 'SEOUL', '서초구 양재',
        '400억짜리 건물', '12345',ST_GeomFromText('POINT(127.0522 37.6766)'),
        3, 2, 1, 1, 14, 12, 1, 1, false, '2022-01-01 00:00:01', '2022-01-01 00:00:01', 'WEEKLY');
insert into accommodation(accommodation_name, accommodation_description, accommodation_type,
                          price, main_image, cleaning_fee, service_fee, accommodation_tax,
                          country, city, first_address, second_address, zipcode, coordinate,
                          maximum_guest_number, room_count, bed_count, bathroom_count,
                          check_in_time, check_out_time, user_id, region_id, is_deleted, created_at, last_modified_at, discount_policy)
values ('강남역', '따뜻해요', 'GUEST_HOUSE', 1000000, 'https://user-images.githubusercontent.com/57708971/171983097-bb00919f-9737-4b84-b050-19f314379147.png', 0.03, 0.03, 0.02, 'SOUTH_KOREA', 'SEOUL', '강남',
        '강남역앞', '12345',ST_GeomFromText('POINT(127.0522 37.6766)'),
        3, 2, 1, 1, 14, 12, 1, 1, false, '2022-01-01 00:00:01', '2022-01-01 00:00:01', 'WEEKLY');
insert into accommodation(accommodation_name, accommodation_description, accommodation_type,
                          price, main_image, cleaning_fee, service_fee, accommodation_tax,
                          country, city, first_address, second_address, zipcode, coordinate,
                          maximum_guest_number, room_count, bed_count, bathroom_count,
                          check_in_time, check_out_time, user_id, region_id, is_deleted, created_at, last_modified_at, discount_policy)
values ('수유역 호텔', '따뜻해요', 'GUEST_HOUSE', 1000000, 'https://user-images.githubusercontent.com/57708971/171983097-bb00919f-9737-4b84-b050-19f314379147.png', 0.03, 0.03, 0.02, 'SOUTH_KOREA', 'SEOUL', '강북구 도봉로 338',
        '수유역앞', '12345',ST_GeomFromText('POINT(127.01985895225 37.636542897005)'),
        3, 2, 1, 1, 14, 12, 1, 1, false, '2022-01-01 00:00:01', '2022-01-01 00:00:01', 'WEEKLY');
insert into accommodation(accommodation_name, accommodation_description, accommodation_type,
                          price, main_image, cleaning_fee, service_fee, accommodation_tax,
                          country, city, first_address, second_address, zipcode, coordinate,
                          maximum_guest_number, room_count, bed_count, bathroom_count,
                          check_in_time, check_out_time, user_id, region_id, is_deleted, created_at, last_modified_at, discount_policy)
values ('미아역 호텔', '따뜻해요', 'HOTEL', 1000000, 'https://user-images.githubusercontent.com/57708971/171983097-bb00919f-9737-4b84-b050-19f314379147.png', 0.03, 0.03, 0.02, 'SOUTH_KOREA', 'SEOUL', '강북구 도봉로 198',
        '미아역앞', '12345',ST_GeomFromText('POINT(127.02616877682 37.626342321009)'),
        3, 2, 1, 1, 14, 12, 1, 1, false, '2022-01-01 00:00:01', '2022-01-01 00:00:01', 'WEEKLY');
insert into accommodation(accommodation_name, accommodation_description, accommodation_type,
                          price, main_image, cleaning_fee, service_fee, accommodation_tax,
                          country, city, first_address, second_address, zipcode, coordinate,
                          maximum_guest_number, room_count, bed_count, bathroom_count,
                          check_in_time, check_out_time, user_id, region_id, is_deleted, created_at, last_modified_at, discount_policy)
values ('미아사거리역 호텔', '따뜻해요', 'HOTEL', 1000000, 'https://user-images.githubusercontent.com/57708971/171983097-bb00919f-9737-4b84-b050-19f314379147.png', 0.03, 0.03, 0.02, 'SOUTH_KOREA', 'SEOUL', '강북구 도봉로 50',
        '미아사거리역앞', '12345',ST_GeomFromText('POINT(127.03007331307 37.613480184886)'),
        3, 2, 1, 1, 14, 12, 1, 1, false, '2022-01-01 00:00:01', '2022-01-01 00:00:01', 'WEEKLY');
insert into accommodation(accommodation_name, accommodation_description, accommodation_type,
                          price, main_image, cleaning_fee, service_fee, accommodation_tax,
                          country, city, first_address, second_address, zipcode, coordinate,
                          maximum_guest_number, room_count, bed_count, bathroom_count,
                          check_in_time, check_out_time, user_id, region_id, is_deleted, created_at, last_modified_at, discount_policy)
values ('길음역 호텔', '따뜻해요', 'HOTEL', 1000000, 'https://user-images.githubusercontent.com/57708971/171983097-bb00919f-9737-4b84-b050-19f314379147.png', 0.03, 0.03, 0.02, 'SOUTH_KOREA', 'SEOUL', '성북구 동소문로 248',
        '길음역앞', '12345',ST_GeomFromText('POINT(127.02410194028 37.6033068916)'),
        3, 2, 1, 1, 14, 12, 1, 1, false, '2022-01-01 00:00:01', '2022-01-01 00:00:01', 'WEEKLY');
insert into accommodation(accommodation_name, accommodation_description, accommodation_type,
                          price, main_image, cleaning_fee, service_fee, accommodation_tax,
                          country, city, first_address, second_address, zipcode, coordinate,
                          maximum_guest_number, room_count, bed_count, bathroom_count,
                          check_in_time, check_out_time, user_id, region_id, is_deleted, created_at, last_modified_at, discount_policy)
values ('성신여대입구역 호텔', '따뜻해요', 'HOTEL', 1000000, 'https://user-images.githubusercontent.com/57708971/171983097-bb00919f-9737-4b84-b050-19f314379147.png', 0.03, 0.03, 0.02, 'SOUTH_KOREA', 'SEOUL', '성북구 동소문로 102',
        '성신여대입구역앞', '12345',ST_GeomFromText('POINT(127.0165538237 37.592624162659)'),
        3, 2, 1, 1, 14, 12, 1, 1, false, '2022-01-01 00:00:01', '2022-01-01 00:00:01', 'WEEKLY');
insert into accommodation(accommodation_name, accommodation_description, accommodation_type,
                          price, main_image, cleaning_fee, service_fee, accommodation_tax,
                          country, city, first_address, second_address, zipcode, coordinate,
                          maximum_guest_number, room_count, bed_count, bathroom_count,
                          check_in_time, check_out_time, user_id, region_id, is_deleted, created_at, last_modified_at, discount_policy)
values ('한성대입구역 게스트하우스', '따뜻해요', 'GUEST_HOUSE', 1000000, 'https://user-images.githubusercontent.com/57708971/171983097-bb00919f-9737-4b84-b050-19f314379147.png', 0.03, 0.03, 0.02, 'SOUTH_KOREA', 'SEOUL', '성북구 삼선교로 1',
        '한성대입구역앞', '12345',ST_GeomFromText('POINT(127.00770064691 37.587501457103)'),
        3, 2, 1, 1, 14, 12, 1, 1, false, '2022-01-01 00:00:01', '2022-01-01 00:00:01', 'WEEKLY');
insert into accommodation(accommodation_name, accommodation_description, accommodation_type,
                          price, main_image, cleaning_fee, service_fee, accommodation_tax,
                          country, city, first_address, second_address, zipcode, coordinate,
                          maximum_guest_number, room_count, bed_count, bathroom_count,
                          check_in_time, check_out_time, user_id, region_id, is_deleted, created_at, last_modified_at, discount_policy)
values ('혜화 모텔', '따뜻해요', 'MOTEL', 1000000, 'https://user-images.githubusercontent.com/57708971/171983097-bb00919f-9737-4b84-b050-19f314379147.png', 0.03, 0.03, 0.02, 'SOUTH_KOREA', 'SEOUL', '종로구 동숭동 96-5',
        '혜화역앞', '12345',ST_GeomFromText('POINT(127.00231863276 37.581192525984)'),
        3, 2, 1, 1, 14, 12, 1, 1, false, '2022-01-01 00:00:01', '2022-01-01 00:00:01', 'WEEKLY');
insert into accommodation(accommodation_name, accommodation_description, accommodation_type,
                          price, main_image, cleaning_fee, service_fee, accommodation_tax,
                          country, city, first_address, second_address, zipcode, coordinate,
                          maximum_guest_number, room_count, bed_count, bathroom_count,
                          check_in_time, check_out_time, user_id, region_id, is_deleted, created_at, last_modified_at, discount_policy)
values ('동대문 호텔', '따뜻해요', 'HOTEL', 1000000, 'https://user-images.githubusercontent.com/57708971/171983097-bb00919f-9737-4b84-b050-19f314379147.png', 0.03, 0.03, 0.02, 'SOUTH_KOREA', 'SEOUL', '종로구 종로 302',
        '동대문역앞', '12345',ST_GeomFromText('POINT(127.01135704708 37.571653360897)'),
        3, 2, 1, 1, 14, 12, 1, 1, false, '2022-01-01 00:00:01', '2022-01-01 00:00:01', 'WEEKLY');
insert into accommodation(accommodation_name, accommodation_description, accommodation_type,
                          price, main_image, cleaning_fee, service_fee, accommodation_tax,
                          country, city, first_address, second_address, zipcode, coordinate,
                          maximum_guest_number, room_count, bed_count, bathroom_count,
                          check_in_time, check_out_time, user_id, region_id, is_deleted, created_at, last_modified_at, discount_policy)
values ('동역사 게스트하우스', '따뜻해요', 'GUEST_HOUSE', 1000000, 'https://user-images.githubusercontent.com/57708971/171983097-bb00919f-9737-4b84-b050-19f314379147.png', 0.03, 0.03, 0.02, 'SOUTH_KOREA', 'SEOUL', '중구 을지로 279',
        '강남역앞', '12345',ST_GeomFromText('POINT(127.00915456269 37.56562586624)'),
        3, 2, 1, 1, 14, 12, 1, 1, false, '2022-01-01 00:00:01', '2022-01-01 00:00:01', 'WEEKLY');
insert into accommodation(accommodation_name, accommodation_description, accommodation_type,
                          price, main_image, cleaning_fee, service_fee, accommodation_tax,
                          country, city, first_address, second_address, zipcode, coordinate,
                          maximum_guest_number, room_count, bed_count, bathroom_count,
                          check_in_time, check_out_time, user_id, region_id, is_deleted, created_at, last_modified_at, discount_policy)
values ('충무로 게스트하우스', '따뜻해요', 'GUEST_HOUSE', 1000000, 'https://user-images.githubusercontent.com/57708971/171983097-bb00919f-9737-4b84-b050-19f314379147.png', 0.03, 0.03, 0.02, 'SOUTH_KOREA', 'SEOUL', '중구 퇴계로 199',
        '충무로역앞', '12345',ST_GeomFromText('POINT(126.9917422787 37.56057261162)'),
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
insert into accommodation_image(accommodation_id,url, is_deleted, created_at, last_modified_at)
values(5, 'https://user-images.githubusercontent.com/57708971/171983097-bb00919f-9737-4b84-b050-19f314379147.png',
       false, '2022-06-04 00:00:01', '2022-06-04 00:00:01');
insert into accommodation_image(accommodation_id,url, is_deleted, created_at, last_modified_at)
values(5, 'https://user-images.githubusercontent.com/57708971/171983178-4f65a1b8-f9d1-437b-8104-c638262ed9c5.png',
       false, '2022-06-04 00:00:01', '2022-06-04 00:00:01');
insert into accommodation_image(accommodation_id,url, is_deleted, created_at, last_modified_at)
values(6, 'https://user-images.githubusercontent.com/57708971/171983097-bb00919f-9737-4b84-b050-19f314379147.png',
       false, '2022-06-04 00:00:01', '2022-06-04 00:00:01');
insert into accommodation_image(accommodation_id,url, is_deleted, created_at, last_modified_at)
values(6, 'https://user-images.githubusercontent.com/57708971/171983178-4f65a1b8-f9d1-437b-8104-c638262ed9c5.png',
       false, '2022-06-04 00:00:01', '2022-06-04 00:00:01');
insert into accommodation_image(accommodation_id,url, is_deleted, created_at, last_modified_at)
values(7, 'https://user-images.githubusercontent.com/57708971/171983097-bb00919f-9737-4b84-b050-19f314379147.png',
       false, '2022-06-04 00:00:01', '2022-06-04 00:00:01');
insert into accommodation_image(accommodation_id,url, is_deleted, created_at, last_modified_at)
values(7, 'https://user-images.githubusercontent.com/57708971/171983178-4f65a1b8-f9d1-437b-8104-c638262ed9c5.png',
       false, '2022-06-04 00:00:01', '2022-06-04 00:00:01');
insert into accommodation_image(accommodation_id,url, is_deleted, created_at, last_modified_at)
values(8, 'https://user-images.githubusercontent.com/57708971/171983097-bb00919f-9737-4b84-b050-19f314379147.png',
       false, '2022-06-04 00:00:01', '2022-06-04 00:00:01');
insert into accommodation_image(accommodation_id,url, is_deleted, created_at, last_modified_at)
values(8, 'https://user-images.githubusercontent.com/57708971/171983178-4f65a1b8-f9d1-437b-8104-c638262ed9c5.png',
       false, '2022-06-04 00:00:01', '2022-06-04 00:00:01');
insert into accommodation_image(accommodation_id,url, is_deleted, created_at, last_modified_at)
values(9, 'https://user-images.githubusercontent.com/57708971/171983097-bb00919f-9737-4b84-b050-19f314379147.png',
       false, '2022-06-04 00:00:01', '2022-06-04 00:00:01');
insert into accommodation_image(accommodation_id,url, is_deleted, created_at, last_modified_at)
values(9, 'https://user-images.githubusercontent.com/57708971/171983178-4f65a1b8-f9d1-437b-8104-c638262ed9c5.png',
       false, '2022-06-04 00:00:01', '2022-06-04 00:00:01');
insert into accommodation_image(accommodation_id,url, is_deleted, created_at, last_modified_at)
values(10, 'https://user-images.githubusercontent.com/57708971/171983097-bb00919f-9737-4b84-b050-19f314379147.png',
       false, '2022-06-04 00:00:01', '2022-06-04 00:00:01');
insert into accommodation_image(accommodation_id,url, is_deleted, created_at, last_modified_at)
values(10, 'https://user-images.githubusercontent.com/57708971/171983178-4f65a1b8-f9d1-437b-8104-c638262ed9c5.png',
       false, '2022-06-04 00:00:01', '2022-06-04 00:00:01');
insert into accommodation_image(accommodation_id,url, is_deleted, created_at, last_modified_at)
values(11, 'https://user-images.githubusercontent.com/57708971/171983097-bb00919f-9737-4b84-b050-19f314379147.png',
       false, '2022-06-04 00:00:01', '2022-06-04 00:00:01');
insert into accommodation_image(accommodation_id,url, is_deleted, created_at, last_modified_at)
values(11, 'https://user-images.githubusercontent.com/57708971/171983178-4f65a1b8-f9d1-437b-8104-c638262ed9c5.png',
       false, '2022-06-04 00:00:01', '2022-06-04 00:00:01');
insert into accommodation_image(accommodation_id,url, is_deleted, created_at, last_modified_at)
values(12, 'https://user-images.githubusercontent.com/57708971/171983097-bb00919f-9737-4b84-b050-19f314379147.png',
       false, '2022-06-04 00:00:01', '2022-06-04 00:00:01');
insert into accommodation_image(accommodation_id,url, is_deleted, created_at, last_modified_at)
values(12, 'https://user-images.githubusercontent.com/57708971/171983178-4f65a1b8-f9d1-437b-8104-c638262ed9c5.png',
       false, '2022-06-04 00:00:01', '2022-06-04 00:00:01');
insert into accommodation_image(accommodation_id,url, is_deleted, created_at, last_modified_at)
values(13, 'https://user-images.githubusercontent.com/57708971/171983097-bb00919f-9737-4b84-b050-19f314379147.png',
       false, '2022-06-04 00:00:01', '2022-06-04 00:00:01');
insert into accommodation_image(accommodation_id,url, is_deleted, created_at, last_modified_at)
values(13, 'https://user-images.githubusercontent.com/57708971/171983178-4f65a1b8-f9d1-437b-8104-c638262ed9c5.png',
       false, '2022-06-04 00:00:01', '2022-06-04 00:00:01');
insert into accommodation_image(accommodation_id,url, is_deleted, created_at, last_modified_at)
values(14, 'https://user-images.githubusercontent.com/57708971/171983097-bb00919f-9737-4b84-b050-19f314379147.png',
       false, '2022-06-04 00:00:01', '2022-06-04 00:00:01');
insert into accommodation_image(accommodation_id,url, is_deleted, created_at, last_modified_at)
values(14, 'https://user-images.githubusercontent.com/57708971/171983178-4f65a1b8-f9d1-437b-8104-c638262ed9c5.png',
       false, '2022-06-04 00:00:01', '2022-06-04 00:00:01');
insert into accommodation_image(accommodation_id,url, is_deleted, created_at, last_modified_at)
values(15, 'https://user-images.githubusercontent.com/57708971/171983097-bb00919f-9737-4b84-b050-19f314379147.png',
       false, '2022-06-04 00:00:01', '2022-06-04 00:00:01');
insert into accommodation_image(accommodation_id,url, is_deleted, created_at, last_modified_at)
values(15, 'https://user-images.githubusercontent.com/57708971/171983178-4f65a1b8-f9d1-437b-8104-c638262ed9c5.png',
       false, '2022-06-04 00:00:01', '2022-06-04 00:00:01');
insert into accommodation_image(accommodation_id,url, is_deleted, created_at, last_modified_at)
values(16, 'https://user-images.githubusercontent.com/57708971/171983097-bb00919f-9737-4b84-b050-19f314379147.png',
       false, '2022-06-04 00:00:01', '2022-06-04 00:00:01');
insert into accommodation_image(accommodation_id,url, is_deleted, created_at, last_modified_at)
values(16, 'https://user-images.githubusercontent.com/57708971/171983178-4f65a1b8-f9d1-437b-8104-c638262ed9c5.png',
       false, '2022-06-04 00:00:01', '2022-06-04 00:00:01');
insert into accommodation_image(accommodation_id,url, is_deleted, created_at, last_modified_at)
values(17, 'https://user-images.githubusercontent.com/57708971/171983097-bb00919f-9737-4b84-b050-19f314379147.png',
       false, '2022-06-04 00:00:01', '2022-06-04 00:00:01');
insert into accommodation_image(accommodation_id,url, is_deleted, created_at, last_modified_at)
values(17, 'https://user-images.githubusercontent.com/57708971/171983178-4f65a1b8-f9d1-437b-8104-c638262ed9c5.png',
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
