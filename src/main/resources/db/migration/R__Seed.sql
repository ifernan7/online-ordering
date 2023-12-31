INSERT INTO online_ordering_db.users (email, password) VALUES
    ('user1@example.com', 'password'),
    ('user2@example.com', 'password'),
    ('user3@example.com', 'password'),
    ('user4@example.com', 'password'),
    ('user5@example.com', 'password'),
    ('user6@example.com', 'password'),
    ('user7@example.com', 'password'),
    ('user8@example.com', 'password'),
    ('user9@example.com', 'password'),
    ('user10@example.com', 'password');

INSERT INTO online_ordering_db.warehouses (name, city) VALUES
    ('Zenith Storage Hub', 'San Francisco'),
    ('Mystic Warehousing', 'Seattle'),
    ('Infinity Depot', 'Las Vegas'),
    ('Solar Warehouse Oasis', 'Phoenix'),
    ('Galactic Logistics Center', 'Denver');

INSERT INTO products (name, description, price) VALUES
    ('Hammer', 'Durable steel hammer for construction work.', 19.99),
    ('Drill', 'Cordless power drill with multiple attachments.', 79.95),
    ('Laptop', 'High-performance laptop with a fast processor.', 899.99),
    ('Coffee Maker', 'Automatic coffee maker with timer and brew options.', 49.99),
    ('Headphones', 'Over-ear headphones with noise-canceling technology.', 129.99),
    ('Television', '4K Ultra HD Smart TV with streaming apps.', 499.95),
    ('Toaster', 'Stainless steel toaster with wide slots for bagels.', 34.99),
    ('Vacuum Cleaner', 'Bagless vacuum cleaner with HEPA filter.', 149.95),
    ('Refrigerator', 'Energy-efficient refrigerator with adjustable shelves.', 699.99),
    ('Microwave Oven', 'Compact microwave oven with digital controls.', 79.95),
    ('Digital Camera', 'Mirrorless digital camera with interchangeable lenses.', 599.99),
    ('Smartphone', 'High-end smartphone with a large AMOLED screen.', 799.95),
    ('Tablet', 'Tablet with a high-resolution display and long battery life.', 299.99),
    ('Blender', 'Countertop blender for smoothies and shakes.', 49.95),
    ('Treadmill', 'Motorized treadmill with adjustable incline.', 599.99),
    ('Bicycle', 'Mountain bike with front suspension for off-road riding.', 349.99),
    ('Gaming Console', 'Next-gen gaming console with immersive graphics.', 399.95),
    ('Dishwasher', 'Built-in dishwasher with multiple wash cycles.', 449.99),
    ('Air Purifier', 'HEPA air purifier for cleaner indoor air.', 129.95),
    ('Coffee Table', 'Modern coffee table with storage compartments.', 149.99),
    ('Desk Chair', 'Ergonomic office chair with lumbar support.', 129.95),
    ('Bookshelf', 'Wooden bookshelf with adjustable shelves.', 79.99),
    ('Bed Frame', 'Queen-size bed frame with upholstered headboard.', 299.95),
    ('Sofa', 'Contemporary sofa with removable cushions.', 599.99),
    ('Couch', 'Sectional couch with reclining seats and cup holders.', 899.95),
    ('Dining Table', 'Extendable dining table with a glossy finish.', 349.99),
    ('Chair Set', 'Set of four dining chairs with padded seats.', 199.95),
    ('Washing Machine', 'Front-loading washing machine with various cycles.', 499.99),
    ('Dryer', 'Electric dryer with sensor drying technology.', 399.95),
    ('Carpet Cleaner', 'Carpet and upholstery cleaner with heat and suction.', 179.99),
    ('Iron', 'Steam iron with adjustable temperature settings.', 29.95),
    ('Toothbrush', 'Electric toothbrush with multiple brushing modes.', 69.99),
    ('Coffee Beans', 'Freshly roasted Arabica coffee beans (1 lb).', 12.99),
    ('Tea Set', 'Porcelain tea set with teapot and cups.', 39.99),
    ('Kitchen Knife Set', 'High-quality knife set with wooden block.', 49.95),
    ('Exercise Mat', 'Non-slip yoga and exercise mat (6mm thick).', 19.99),
    ('Guitar', 'Acoustic guitar with spruce top and mahogany back.', 249.95),
    ('Bass Guitar', 'Electric bass guitar with active pickups.', 299.99),
    ('Drum Kit', '5-piece drum kit with cymbals and hardware.', 599.99),
    ('Saxophone', 'Alto saxophone with gold lacquer finish.', 499.95),
    ('Violin', 'Student violin outfit with bow and case.', 149.99),
    ('Tennis Racket', 'Professional-grade tennis racket with grip.', 89.99),
    ('Basketball', 'Official-size basketball for indoor and outdoor use.', 24.95),
    ('Soccer Ball', 'FIFA-approved soccer ball for matches.', 39.95),
    ('Running Shoes', 'Running shoes with cushioning and support.', 69.99),
    ('Backpack', 'Durable backpack with multiple compartments.', 49.99);

INSERT INTO online_ordering_db.order_status (id, status)
VALUES
    (1,'Pending'),
    (2, 'Processing'),
    (3, 'Shipped'),
    (4, 'Delivered');

INSERT INTO online_ordering_db.orders (user_id, create_date, status_id)
VALUES
    (1, '2023-09-20', 1),
    (2, '2023-09-21', 2),
    (3, '2023-09-22', 1);

INSERT INTO online_ordering_db.order_products (order_id, product_id, quantity)
VALUES
    (1, 1, 1),
    (2, 2, 1),
    (3, 3, 1);