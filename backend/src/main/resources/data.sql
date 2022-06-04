
insert into users(user_name, user_type, profile_image, is_deleted, created_at, last_modified_at)
values ('나든', 'HOST', 'http://nathan-face', false, '2022-01-01 00:00:01', '2022-01-01 00:00:01');


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


insert into accommodation(accommodation_name, accommodation_description, accommodation_type,
                          price, main_image, cleaning_fee, service_fee, accommodation_tax,
                          country, city, first_address, second_address, zipcode, coordinate,
                          maximum_guest_number, room_count, bed_count, bathroom_count,
                          check_in_time, check_out_time, user_id, region_id, is_deleted, created_at, last_modified_at)
values ('나단의 게스트하우스', '나단이 살아요', 'HOTEL', 10000, 'http://main_image', 2.0, 2.0, 2.0, 'SOUTH_KOREA', 'SEOUL', '동대문구 회기로 196 회기역사',
        '외대앞', '12345',ST_GeomFromText('POINT(18 -63)'),
        3, 2, 1, 1, 14, 12, 1, 1, false, '2022-01-01 00:00:01', '2022-01-01 00:00:01');
insert into accommodation(accommodation_name, accommodation_description, accommodation_type,
                          price, main_image, cleaning_fee, service_fee, accommodation_tax,
                          country, city, first_address, second_address, zipcode, coordinate,
                          maximum_guest_number, room_count, bed_count, bathroom_count,
                          check_in_time, check_out_time, user_id, region_id, is_deleted, created_at, last_modified_at)
values ('스타크의 호텔', '토니 스타크가 살아요', 'HOTEL', 70000, 'http://main_image', 2.0, 2.0, 2.0, 'SOUTH_KOREA', 'SEOUL', '동대문구 회기로 196 회기역사',
        '서울시립대앞', '12345',ST_GeomFromText('POINT(127.0556 37.5851)'),
        3, 2, 1, 1, 14, 12, 1, 1, false, '2022-01-01 00:00:01', '2022-01-01 00:00:01');
insert into accommodation(accommodation_name, accommodation_description, accommodation_type,
                          price, main_image, cleaning_fee, service_fee, accommodation_tax,
                          country, city, first_address, second_address, zipcode, coordinate,
                          maximum_guest_number, room_count, bed_count, bathroom_count,
                          check_in_time, check_out_time, user_id, region_id, is_deleted, created_at, last_modified_at)
values ('제이의 모텔', '제이가 살아요', 'HOTEL', 30000, 'http://main_image', 2.0, 2.0, 2.0, 'SOUTH_KOREA', 'SEOUL', '동작구 남부순환로 2089',
        '사당앞', '12345',ST_GeomFromText('POINT(126.9770 37.4799)'),
        3, 2, 1, 1, 14, 12, 1, 1, false, '2022-01-01 00:00:01', '2022-01-01 00:00:01');
insert into accommodation(accommodation_name, accommodation_description, accommodation_type,
                          price, main_image, cleaning_fee, service_fee, accommodation_tax,
                          country, city, first_address, second_address, zipcode, coordinate,
                          maximum_guest_number, room_count, bed_count, bathroom_count,
                          check_in_time, check_out_time, user_id, region_id, is_deleted, created_at, last_modified_at)
values ('포키의 레지던스', '포키는 안살아요', 'HOTEL', 1000000, 'http://main_image', 2.0, 2.0, 2.0, 'SOUTH_KOREA', 'SEOUL', '노원구 상계로 69-1',
        '노원앞', '12345',ST_GeomFromText('POINT(127.0522 37.6766)'),
        3, 2, 1, 1, 14, 12, 1, 1, false, '2022-01-01 00:00:01', '2022-01-01 00:00:01');

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


