CREATE TABLE `users_store`
(
  `id` INTEGER AUTO_INCREMENT PRIMARY KEY,
  `username` VARCHAR(32),
  `password` VARCHAR(256),
  `email` varchar(32) UNIQUE NOT NULL,
  `age` INTEGER,
  `gender` VARCHAR(3),
  `address` VARCHAR(128),
  `comment` VARCHAR(2048),
  `agree` INTEGER,
  `role` VARCHAR(8),
  `created_at` varchar(64),
  `lastvisit_at` varchar(64)
);

CREATE TABLE `products`
(
  `id` INTEGER AUTO_INCREMENT PRIMARY KEY,
  `name` VARCHAR(64) NOT NULL,
  `description` VARCHAR(2048),
  `price` INTEGER,
  `category` INTEGER,
  `image` VARCHAR(32)
);

INSERT INTO products (name, category, price, image) VALUES
('Blackberry Key2', 1, 450, '1-1.jpg'),
('Nokia 5310XM XpressMusic 2', 1, 40, '2-1.jpg'),
('Apple iPhone 7 (32GB) - Gold', 1, 700, '3-1.jpg'),
('Nikon COOLPIX P1000 Digital Point & Shoot Camera', 2, 970, '1-2.jpg'),
('Canon PowerShot Elph 180 Camera 16GB Card', 2, 145, '2-2.jpg'),
('Canon IXUS 185/ELPH 180 20MP Digital Camera', 2, 85, '2-2.jpg'),
('ASUS VivoBook F510UA 15.6” Full HD Nanoedge Laptop', 3, 310, '1-3.jpg'),
('Acer Aspire 15.6in i5 8GB Ram 256GB SSD', 3, 500, '2-3.jpg'),
('Lenovo ThinkPad X230 Notebook i5 8G', 3, 720, '3-3.jpg');

UPDATE products
SET
description = 'FDD-LTE Dual Sim, 128GB, BBB100-6 Model, PRD 63828-007 Android 8.1 (Oreo), Qualcomm SDM660 Snapdragon 660, Octa-core (4x2.2 GHz Kryo 260 & 4x1.8 GHz Kryo 260) Primary Camera Dual: 12MP (f/1.8, 1/2.3, 1.28µm, dual-pixel PDAF) + 12MP (f/2.6, 1.0µm, PDAF), 2160p@30fps, 1080p@30fps, Secondary Camera 8MP (f/2.0, 1.12µm), 1080p'
WHERE id = 1;

UPDATE products
SET
description = 'The metal frame and back cover provides higher hardness, scratch-resistance. Uses fine cutting and polishing to create ultra elegant edge. Adopts advanced GSM network technology. Fine workmanship offers a stylish appearance. Small, lightweight and portable, gift for your loved one'
WHERE id = 2;

UPDATE products
SET
description = '4.7-Inch Retina HD display IP67 water and dust resistant (maximum depth of 1 meter up to 30 minutes) 12MP camera and 4K video 7MP FaceTime HD Camera with Retina flash Touch ID for secure authentication and Apple Pay Note: This iPhone is carrier locked; customers must have had their locked device activated on Simple Mobile service for no fewer than 12 months, redeemed air time cards in no fewer than 12 months'
WHERE id = 3;

UPDATE products
SET
description = 'KIT INCLUDES: Nikon COOLPIX P1000 Digital Camera, AN-DC3 Strap, UC-E21 USB Cable, EN-EL20a Rechargeable Li-Ion Battery, EH-73P AC Adapter/Charger, LC-77 Snap-On Lens Cap, HB-CP1 Lens Hood, Lowepro Camera Case, SanDisk 32GB Extreme PRO SD Memory Card, 77mm Filter Kit, ProOptics Cleaning Kit, Multi Card Reader, Memory Card Wallet, PC Software Package'
WHERE id = 4;

UPDATE products
SET
description = 'KIT INCLUDES 5 PRODUCTS All BRAND NEW Items with all Manufacturer-supplied Accessories, Full USA Warranties: Canon PowerShot Elph 180 Digital Camera (Red), Transcend 16GB SDHC Card, Spare NB-11L/H Battery, Lowepro Newport 10 Camera Case, PD Flexible Table Mini Tripod'
WHERE id = 5;

UPDATE products
SET
description = 'Sleek, user-friendly compact camera Equipped with many creative features, Powerful zooming function Compact and easy to carry along'
WHERE id = 6;

UPDATE products
SET
description = 'Powerful 8th Generation Intel Core i5-8250U 1.6GHz (Turbo up to 3.4GHz) processor 14.2 Wide, 0.8 Thin and portable footprint with 0.3 Nano edge bezel for a stunning 80% screen-to-body ratio 15.6 Anti-glare full HD display with ASUS splendid software enhancement 8GB DDR4 RAM and 1TB HDD Ergonomic chiclet keyboard with fingerprint sensor, Windows 10 Home Comprehensive connections including USB 3.1 Type-C (Gen1), USB 3.0, USB 2.0, and HDMI; Lightning-fast 802.11AC Wi-Fi keeps you connected through any congestion or interference'
WHERE id = 7;

UPDATE products
SET
description = 'This Certified Refurbished product is certified factory refurbished, shows limited or no wear, and includes all original accessories plus a 90-day warranty. Storage allows for plenty storage of many applications, media, and more. Multitasking is easy with 8GB of Ram. Equipped with a blazing fast Intel Core i5 i5-8265U 1.60GHz Processor'
WHERE id = 8;

UPDATE products
SET
description = 'Intel Core i5 2.6GHz Processor 8GB DDR3 - 500Gig SATA Hard Drive 12.5in HD LED Display (1366x768) Microsoft Windows 10 Professional (64-Bit)'
WHERE id = 9;
