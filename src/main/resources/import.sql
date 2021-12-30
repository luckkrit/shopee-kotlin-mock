insert into categories(id, title)
values (1, 'electronics');
insert into categories(id, title)
values (2, 'jewelery');
insert into categories(id, title)
values (3, 'men''s clothing');
insert into categories(id, title)
values (4, 'women''s clothing');
ALTER SEQUENCE category_seq RESTART WITH 5 INCREMENT BY 1 NO CACHE;
insert into product_ratings(id, rate, count)
values (1, 3.9, 120);
insert into product_ratings(id, rate, count)
values (2, 4.1, 259);
insert into product_ratings(id, rate, count)
values (3, 4.7, 500);
insert into product_ratings(id, rate, count)
values (4, 2.1, 430);
insert into product_ratings(id, rate, count)
values (5, 4.6, 400);
insert into product_ratings(id, rate, count)
values (6, 3.9, 70);
insert into product_ratings(id, rate, count)
values (7, 3, 400);
insert into product_ratings(id, rate, count)
values (8, 1.9, 100);
insert into product_ratings(id, rate, count)
values (9, 3.3, 203);
insert into product_ratings(id, rate, count)
values (10, 2.9, 470);
insert into product_ratings(id, rate, count)
values (11, 4.8, 319);
insert into product_ratings(id, rate, count)
values (12, 4.8, 400);
insert into product_ratings(id, rate, count)
values (13, 2.9, 250);
insert into product_ratings(id, rate, count)
values (14, 2.2, 140);
insert into product_ratings(id, rate, count)
values (15, 2.6, 235);
insert into product_ratings(id, rate, count)
values (16, 2.9, 340);
insert into product_ratings(id, rate, count)
values (17, 3.8, 679);
insert into product_ratings(id, rate, count)
values (18, 4.7, 130);
insert into product_ratings(id, rate, count)
values (19, 4.5, 146);
insert into product_ratings(id, rate, count)
values (20, 3.6, 145);
ALTER SEQUENCE product_rating_seq RESTART WITH 21 INCREMENT BY 1 NO CACHE;
insert into products(id, title, price, description, category_id, image, product_rating_id)
values (1, 'Fjallraven - Foldsack No. 1 Backpack, Fits 15 Laptops', 109.95,
        'Your perfect pack for everyday use and walks in the forest. Stash your laptop (up to 15 inches) in the padded sleeve, your everyday',
        3, 'https://fakestoreapi.com/img/81fPKd-2AYL._AC_SL1500_.jpg', 1);
insert into products(id, title, price, description, category_id, image, product_rating_id)
values (2, 'Mens Casual Premium Slim Fit T-Shirts ', 22.3,
        'Slim-fitting style, contrast raglan long sleeve, three-button henley placket, light weight & soft fabric for breathable and comfortable wearing. And Solid stitched shirts with round neck made for durability and a great fit for casual fashion wear and diehard baseball fans. The Henley style round neckline includes a three-button placket.',
        3, 'https://fakestoreapi.com/img/71-3HjGNDUL._AC_SY879._SX._UX._SY._UY_.jpg', 2);
insert into products(id, title, price, description, category_id, image, product_rating_id)
values (3, 'Mens Cotton Jacket', 55,
        'great outerwear jackets for Spring/Autumn/Winter, suitable for many occasions, such as working, hiking, camping, mountain/rock climbing, cycling, traveling or other outdoors. Good gift choice for you or your family member. A warm hearted love to Father, husband or son in this thanksgiving or Christmas Day.',
        3, 'https://fakestoreapi.com/img/71li-ujtlUL._AC_UX679_.jpg', 3);
insert into products(id, title, price, description, category_id, image, product_rating_id)
values (4, 'Mens Casual Slim Fit', 15.99,
        'The color could be slightly different between on the screen and in practice. / Please note that body builds vary by person, therefore, detailed size information should be reviewed below on the product description.',
        3, 'https://fakestoreapi.com/img/71YXzeOuslL._AC_UY879_.jpg', 4);
insert into products(id, title, price, description, category_id, image, product_rating_id)
values (5, 'John Hardy Women''s Legends Naga Gold & Silver Dragon Station Chain Bracelet', 695,
        'From our Legends Collection, the Naga was inspired by the mythical water dragon that protects the ocean''s pearl. Wear facing inward to be bestowed with love and abundance, or outward for protection.',
        2, 'https://fakestoreapi.com/img/71pWzhdJNwL._AC_UL640_QL65_ML3_.jpg', 5);
insert into products(id, title, price, description, category_id, image, product_rating_id)
values (6, 'Solid Gold Petite Micropave ', 168,
        'Satisfaction Guaranteed. Return or exchange any order within 30 days.Designed and sold by Hafeez Center in the United States. Satisfaction Guaranteed. Return or exchange any order within 30 days.',
        2, 'https://fakestoreapi.com/img/61sbMiUnoGL._AC_UL640_QL65_ML3_.jpg', 6);
insert into products(id, title, price, description, category_id, image, product_rating_id)
values (7, 'White Gold Plated Princess', 9.99,
        'Classic Created Wedding Engagement Solitaire Diamond Promise Ring for Her. Gifts to spoil your love more for Engagement, Wedding, Anniversary, Valentine''s Day...',
        2, 'https://fakestoreapi.com/img/71YAIFU48IL._AC_UL640_QL65_ML3_.jpg', 7);
insert into products(id, title, price, description, category_id, image, product_rating_id)
values (8, 'Pierced Owl Rose Gold Plated Stainless Steel Double', 10.99,
        'Rose Gold Plated Double Flared Tunnel Plug Earrings. Made of 316L Stainless Steel', 2,
        'https://fakestoreapi.com/img/51UDEzMJVpL._AC_UL640_QL65_ML3_.jpg', 8);
insert into products(id, title, price, description, category_id, image, product_rating_id)
values (9, 'WD 2TB Elements Portable External Hard Drive - USB 3.0 ', 64,
        'USB 3.0 and USB 2.0 Compatibility Fast data transfers Improve PC Performance High Capacity; Compatibility Formatted NTFS for Windows 10, Windows 8.1, Windows 7; Reformatting may be required for other operating systems; Compatibility may vary depending on user’s hardware configuration and operating system',
        1, 'https://fakestoreapi.com/img/61IBBVJvSDL._AC_SY879_.jpg', 9);
insert into products(id, title, price, description, category_id, image, product_rating_id)
values (10, 'SanDisk SSD PLUS 1TB Internal SSD - SATA III 6 Gb/s', 109,
        'Easy upgrade for faster boot up, shutdown, application load and response (As compared to 5400 RPM SATA 2.5” hard drive; Based on published specifications and internal benchmarking tests using PCMark vantage scores) Boosts burst write performance, making it ideal for typical PC workloads The perfect balance of performance and reliability Read/write speeds of up to 535MB/s/450MB/s (Based on internal testing; Performance may vary depending upon drive capacity, host device, OS and application.)',
        1, 'https://fakestoreapi.com/img/61U7T1koQqL._AC_SX679_.jpg', 10);
insert into products(id, title, price, description, category_id, image, product_rating_id)
values (11, 'Silicon Power 256GB SSD 3D NAND A55 SLC Cache Performance Boost SATA III 2.5', 109,
        '3D NAND flash are applied to deliver high transfer speeds Remarkable transfer speeds that enable faster bootup and improved overall system performance. The advanced SLC Cache Technology allows performance boost and longer lifespan 7mm slim design suitable for Ultrabooks and Ultra-slim notebooks. Supports TRIM command, Garbage Collection technology, RAID, and ECC (Error Checking & Correction) to provide the optimized performance and enhanced reliability.',
        1, 'https://fakestoreapi.com/img/71kWymZ+c+L._AC_SX679_.jpg', 11);
insert into products(id, title, price, description, category_id, image, product_rating_id)
values (12, 'WD 4TB Gaming Drive Works with Playstation 4 Portable External Hard Drive', 114,
        'Expand your PS4 gaming experience, Play anywhere Fast and easy, setup Sleek design with high capacity, 3-year manufacturer''s limited warranty',
        1, 'https://fakestoreapi.com/img/61mtL65D4cL._AC_SX679_.jpg', 12);
insert into products(id, title, price, description, category_id, image, product_rating_id)
values (13, 'Acer SB220Q bi 21.5 inches Full HD (1920 x 1080) IPS Ultra-Thin', 599,
        '21. 5 inches Full HD (1920 x 1080) widescreen IPS display And Radeon free Sync technology. No compatibility for VESA Mount Refresh Rate: 75Hz - Using HDMI port Zero-frame design | ultra-thin | 4ms response time | IPS panel Aspect ratio - 16: 9. Color Supported - 16. 7 million colors. Brightness - 250 nit Tilt angle -5 degree to 15 degree. Horizontal viewing angle-178 degree. Vertical viewing angle-178 degree 75 hertz',
        1, 'https://fakestoreapi.com/img/81QpkIctqPL._AC_SX679_.jpg', 13);
insert into products(id, title, price, description, category_id, image, product_rating_id)
values (14, 'Samsung 49-Inch CHG90 144Hz Curved Gaming Monitor (LC49HG90DMNXZA) – Super Ultrawide Screen QLED ', 999.99,
        '49 INCH SUPER ULTRAWIDE 32:9 CURVED GAMING MONITOR with dual 27 inch screen side by side QUANTUM DOT (QLED) TECHNOLOGY, HDR support and factory calibration provides stunningly realistic and accurate color and contrast 144HZ HIGH REFRESH RATE and 1ms ultra fast response time work to eliminate motion blur, ghosting, and reduce input lag',
        1, 'https://fakestoreapi.com/img/81Zt42ioCgL._AC_SX679_.jpg', 14);
insert into products(id, title, price, description, category_id, image, product_rating_id)
values (15, 'BIYLACLESEN Women''s 3-in-1 Snowboard Jacket Winter Coats', 56.99,
        'Note:The Jackets is US standard size, Please choose size as your usual wear Material: 100% Polyester; Detachable Liner Fabric: Warm Fleece. Detachable Functional Liner: Skin Friendly, Lightweigt and Warm.Stand Collar Liner jacket, keep you warm in cold weather. Zippered Pockets: 2 Zippered Hand Pockets, 2 Zippered Pockets on Chest (enough to keep cards or keys)and 1 Hidden Pocket Inside.Zippered Hand Pockets and Hidden Pocket keep your things secure. Humanized Design: Adjustable and Detachable Hood and Adjustable cuff to prevent the wind and water,for a comfortable fit. 3 in 1 Detachable Design provide more convenience, you can separate the coat and inner as needed, or wear it together. It is suitable for different season and help you adapt to different climates',
        4, 'https://fakestoreapi.com/img/51Y5NI-I5jL._AC_UX679_.jpg', 15);
insert into products(id, title, price, description, category_id, image, product_rating_id)
values (16, 'Lock and Love Women''s Removable Hooded Faux Leather Moto Biker Jacket', 29.95,
        '100% POLYURETHANE(shell) 100% POLYESTER(lining) 75% POLYESTER 25% COTTON (SWEATER), Faux leather material for style and comfort / 2 pockets of front, 2-For-One Hooded denim style faux leather jacket, Button detail on waist / Detail stitching at sides, HAND WASH ONLY / DO NOT BLEACH / LINE DRY / DO NOT IRON',
        4, 'https://fakestoreapi.com/img/81XH0e8fefL._AC_UY879_.jpg', 16);
insert into products(id, title, price, description, category_id, image, product_rating_id)
values (17, 'Rain Jacket Women Windbreaker Striped Climbing Raincoats', 39.99,
        'Lightweight perfet for trip or casual wear---Long sleeve with hooded, adjustable drawstring waist design. Button and zipper front closure raincoat, fully stripes Lined and The Raincoat has 2 side pockets are a good size to hold all kinds of things, it covers the hips, and the hood is generous but doesn''t overdo it.Attached Cotton Lined Hood with Adjustable Drawstrings give it a real styled look.',
        4, 'https://fakestoreapi.com/img/71HblAHs5xL._AC_UY879_-2.jpg', 17);
insert into products(id, title, price, description, category_id, image, product_rating_id)
values (18, 'MBJ Women''s Solid Short Sleeve Boat Neck V ', 9.85,
        '95% RAYON 5% SPANDEX, Made in USA or Imported, Do Not Bleach, Lightweight fabric with great stretch for comfort, Ribbed on sleeves and neckline / Double stitching on bottom hem',
        4, 'https://fakestoreapi.com/img/71z3kpMAYsL._AC_UY879_.jpg', 18);
insert into products(id, title, price, description, category_id, image, product_rating_id)
values (19, 'Opna Women''s Short Sleeve Moisture', 7.95,
        '100% Polyester, Machine wash, 100% cationic polyester interlock, Machine Wash & Pre Shrunk for a Great Fit, Lightweight, roomy and highly breathable with moisture wicking fabric which helps to keep moisture away, Soft Lightweight Fabric with comfortable V-neck collar and a slimmer fit, delivers a sleek, more feminine silhouette and Added Comfort',
        4, 'https://fakestoreapi.com/img/51eg55uWmdL._AC_UX679_.jpg', 19);
insert into products(id, title, price, description, category_id, image, product_rating_id)
values (20, 'DANVOUY Womens T Shirt Casual Cotton Short', 12.99,
        '95%Cotton,5%Spandex, Features: Casual, Short Sleeve, Letter Print,V-Neck,Fashion Tees, The fabric is soft and has some stretch., Occasion: Casual/Office/Beach/School/Home/Street. Season: Spring,Summer,Autumn,Winter.',
        4, 'https://fakestoreapi.com/img/61pHAEJ4NML._AC_UX679_.jpg', 20);
ALTER SEQUENCE product_seq RESTART WITH 21 INCREMENT BY 1 NO CACHE;
insert into geolocations(id, latitude, longitude)
values (1, -37.3159, 81.1496);
insert into geolocations(id, latitude, longitude)
values (2, -37.3159, 81.1496);
insert into geolocations(id, latitude, longitude)
values (3, 40.3467, -30.1310);
insert into geolocations(id, latitude, longitude)
values (4, 50.3467, -20.1310);
insert into geolocations(id, latitude, longitude)
values (5, 40.3467, -40.1310);
insert into geolocations(id, latitude, longitude)
values (6, 20.1677, -10.6789);
insert into geolocations(id, latitude, longitude)
values (7, 10.3456, 20.6419);
insert into geolocations(id, latitude, longitude)
values (8, 50.3456, 10.6419);
insert into geolocations(id, latitude, longitude)
values (9, 40.12456, 20.5419);
insert into geolocations(id, latitude, longitude)
values (10, 30.24788, -20.545419);
ALTER SEQUENCE geolocation_seq RESTART WITH 11 INCREMENT BY 1 NO CACHE;
insert into addresses(id, geolocation_id, city, street, number, zipcode)
values (1, 1, 'kilcoole', 'new road', '7682', '12926-3874');
insert into addresses(id, geolocation_id, city, street, number, zipcode)
values (2, 2, 'kilcoole', 'Lovers Ln', '7267', '12926-3874');
insert into addresses(id, geolocation_id, city, street, number, zipcode)
values (3, 3, 'Cullman', 'Frances Ct', '86', '29567-1452');
insert into addresses(id, geolocation_id, city, street, number, zipcode)
values (4, 4, 'San Antonio', 'Hunters Creek Dr', '6454', '98234-1734');
insert into addresses(id, geolocation_id, city, street, number, zipcode)
values (5, 5, 'san Antonio', 'adams St', '245', '80796-1234');
insert into addresses(id, geolocation_id, city, street, number, zipcode)
values (6, 6, 'el paso', 'prospect st', '124', '12346-0456');
insert into addresses(id, geolocation_id, city, street, number, zipcode)
values (7, 7, 'fresno', 'saddle st', '1342', '96378-0245');
insert into addresses(id, geolocation_id, city, street, number, zipcode)
values (8, 8, 'mesa', 'vally view ln', '1342', '96378-0245');
insert into addresses(id, geolocation_id, city, street, number, zipcode)
values (9, 9, 'miami', 'avondale ave', '345', '96378-0245');
insert into addresses(id, geolocation_id, city, street, number, zipcode)
values (10, 10, 'fort wayne', 'oak lawn ave', '526', '10256-4532');
ALTER SEQUENCE address_seq RESTART WITH 11 INCREMENT BY 1 NO CACHE;
insert into user_details(id, firstname, lastname, phone)
values (1, 'john', 'doe', '1-570-236-7033');
insert into user_details(id, firstname, lastname, phone)
values (2, 'david', 'morrison', '1-570-236-7033');
insert into user_details(id, firstname, lastname, phone)
values (3, 'kevin', 'ryan', '1-567-094-1345');
insert into user_details(id, firstname, lastname, phone)
values (4, 'don', 'romer', '1-765-789-6734');
insert into user_details(id, firstname, lastname, phone)
values (5, 'derek', 'powell', '1-956-001-1945');
insert into user_details(id, firstname, lastname, phone)
values (6, 'david', 'russell', '1-678-345-9856');
insert into user_details(id, firstname, lastname, phone)
values (7, 'miriam', 'snyder', '1-123-943-0563');
insert into user_details(id, firstname, lastname, phone)
values (8, 'william', 'hopkins', '1-478-001-0890');
insert into user_details(id, firstname, lastname, phone)
values (9, 'kate', 'hale', '1-678-456-1934');
insert into user_details(id, firstname, lastname, phone)
values (10, 'jimmie', 'klein', '1-104-001-4567');
ALTER SEQUENCE user_detail_seq RESTART WITH 11 INCREMENT BY 1 NO CACHE;
insert into users(id, user_detail_id, address_id, email, username, password)
values (1, 1, 1, 'john@gmail.com', 'johnd', 'm38rmF$');
insert into users(id, user_detail_id, address_id, email, username, password)
values (2, 2, 2, 'morrison@gmail.com', 'mor_2314', '83r5^_');
insert into users(id, user_detail_id, address_id, email, username, password)
values (3, 3, 3, 'kevin@gmail.com', 'kevinryan', 'kev02937@');
insert into users(id, user_detail_id, address_id, email, username, password)
values (4, 4, 4, 'don@gmail.com', 'donero', 'ewedon');
insert into users(id, user_detail_id, address_id, email, username, password)
values (5, 5, 5, 'derek@gmail.com', 'derek', 'jklg*_56');
insert into users(id, user_detail_id, address_id, email, username, password)
values (6, 6, 6, 'david_r@gmail.com', 'david_r', '3478*#54');
insert into users(id, user_detail_id, address_id, email, username, password)
values (7, 7, 7, 'miriam@gmail.com', 'snyder', 'f238&@*$');
insert into users(id, user_detail_id, address_id, email, username, password)
values (8, 8, 8, 'william@gmail.com', 'hopkins', 'William56$hj');
insert into users(id, user_detail_id, address_id, email, username, password)
values (9, 9, 9, 'kate@gmail.com', 'kate_h', 'kfejk@*_');
insert into users(id, user_detail_id, address_id, email, username, password)
values (10, 10, 10, 'jimmie@gmail.com', 'jimmie_k', 'klein*#%*');
ALTER SEQUENCE user_seq RESTART WITH 11 INCREMENT BY 1 NO CACHE;
insert into carts(id, user_id, date)
values (1, 1, '2020-03-02T00:00:02.000Z');
insert into carts(id, user_id, date)
values (2, 1, '2020-01-02T00:00:02.000Z');
insert into carts(id, user_id, date)
values (3, 2, '2020-03-01T00:00:02.000Z');
insert into carts(id, user_id, date)
values (4, 3, '2020-01-01T00:00:02.000Z');
insert into carts(id, user_id, date)
values (5, 3, '2020-03-01T00:00:02.000Z');
insert into carts(id, user_id, date)
values (6, 4, '2020-03-01T00:00:02.000Z');
insert into carts(id, user_id, date)
values (7, 8, '2020-03-01T00:00:02.000Z');
ALTER SEQUENCE cart_seq RESTART WITH 8 INCREMENT BY 1 NO CACHE;
insert into cart_products(id, cart_id, product_id, quantity)
values (1, 1, 1, 4);
insert into cart_products(id, cart_id, product_id, quantity)
values (2, 1, 2, 1);
insert into cart_products(id, cart_id, product_id, quantity)
values (3, 1, 3, 6);
insert into cart_products(id, cart_id, product_id, quantity)
values (4, 2, 2, 4);
insert into cart_products(id, cart_id, product_id, quantity)
values (5, 2, 1, 10);
insert into cart_products(id, cart_id, product_id, quantity)
values (6, 2, 5, 2);
insert into cart_products(id, cart_id, product_id, quantity)
values (7, 3, 1, 2);
insert into cart_products(id, cart_id, product_id, quantity)
values (8, 3, 9, 1);
insert into cart_products(id, cart_id, product_id, quantity)
values (9, 4, 1, 4);
insert into cart_products(id, cart_id, product_id, quantity)
values (10, 5, 7, 1);
insert into cart_products(id, cart_id, product_id, quantity)
values (11, 5, 8, 1);
insert into cart_products(id, cart_id, product_id, quantity)
values (12, 6, 10, 2);
insert into cart_products(id, cart_id, product_id, quantity)
values (13, 6, 12, 3);
insert into cart_products(id, cart_id, product_id, quantity)
values (14, 7, 18, 1);

ALTER SEQUENCE cart_product_seq RESTART WITH 15 INCREMENT BY 1 NO CACHE;