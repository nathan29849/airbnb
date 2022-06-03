insert into users(user_name, user_type, profile_image, is_deleted, created_at, last_modified_at)
values ('나든', 'HOST', 'http://nathan-face', false, '2022-01-01 00:00:01', '2022-01-01 00:00:01');

insert into region(region_name, region_image, coordinate)
values ('SEOUL', 'http://seoul', ST_GeomFromText('POINT(126.986 37.541)'));

insert into accommodation(accommodation_name, accommodation_description, accommodation_type,
                          price, main_image, cleaning_fee, service_fee, accommodation_tax,
                          country, city, first_address, second_address, zipcode, coordinate,
                          maximum_guest_number, room_count, bed_count, bathroom_count,
                          check_in_time, check_out_time, user_id, region_id, is_deleted, created_at, last_modified_at)
values ('나단의 게스트하우스', '나단이 살아요', 'HOTEL', 10000, 'http://main_image', 2.0, 2.0, 2.0, 'SOUTH_KOREA', 'SEOUL', '회기회기회기',
        '외대앞', '12345',ST_GeomFromText('POINT(18 -63)'),
        3, 2, 1, 1, 14, 12, 1, 1, false, '2022-01-01 00:00:01', '2022-01-01 00:00:01');
