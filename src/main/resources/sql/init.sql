DROP DATABASE IF EXISTS logistics;
CREATE DATABASE logistics;

\connect logistics;

-- Создание таблицы "Customers"
CREATE TABLE t_customers (
    id SERIAL NOT NULL,
    customer_name VARCHAR(100) NOT NULL,
    customer_phone VARCHAR(20) NOT NULL,
    password VARCHAR(256) NOT NULL,
    PRIMARY KEY (id)
);

-- Создание таблицы "Warehouses"
CREATE TABLE t_warehouses (
    id SERIAL NOT NULL,
    warehouse_name VARCHAR(100) NOT NULL,
    warehouse_address VARCHAR(100) NOT NULL,
    PRIMARY KEY (id)
);

-- Создание таблицы "Products"
CREATE TABLE t_products (
    id SERIAL NOT NULL,
    product_name VARCHAR(100) NOT NULL,
    start_date DATE NOT NULL,
    expiration_date DATE NOT NULL,
    quantity INTEGER NOT NULL,
    warehouse_id  INTEGER NOT NULL,
    customers_id INTEGER NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (warehouse_id) REFERENCES t_warehouses(id),
    FOREIGN KEY (customers_id) REFERENCES t_customers(id)
);

-- Создание таблицы "News"
CREATE TABLE t_news (
    id SERIAL NOT NULL,
    news_title VARCHAR(100) NOT NULL,
    news_content TEXT NOT NULL,
    news_date DATE NOT NULL,
    image_path VARCHAR (255) NOT NULL,
    PRIMARY KEY (id)
);

-- Создание таблицы "Orders"
CREATE TABLE t_orders (
    id SERIAL NOT NULL,
    customer_id INTEGER NOT NULL,
    start_location VARCHAR(100),
    end_location VARCHAR(100) NOT NULL,
    order_date DATE NOT NULL,
    order_status VARCHAR(50) NOT NULL,
    quantity INTEGER NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (customer_id) REFERENCES t_customers (id)
);


-------------------Данные логистической компании------------------
INSERT INTO t_warehouses(warehouse_name, warehouse_address) VALUES ('ALMATY LOGISTICS', 'площадь Республики, 2/2, Алматы')


INSERT INTO t_news (news_title, news_content, news_date, image_path)
VALUES ('Расширение складских помещений', 'Наша логистическая компания с радостью объявляет о расширении наших складских помещений. Благодаря увеличенной вместимости мы сможем разместить больше товаров и обеспечить более быструю и эффективную обработку заказов для наших клиентов. Это расширение является подтверждением нашего стремления к удовлетворению растущих потребностей наших клиентов и обеспечению бесперебойной логистики.',
		NOW(), 'https://orlando1464.hocoos.com/_ipx/f_webp,q_90/https://img2.hocoos.com/cache/img-pack/1324/w-1900/h-720/ww-1900/wh-720/img-pack/1324/pexels-cottonbro-4046148.jpg');

INSERT INTO t_news (news_title, news_content, news_date, image_path)
VALUES ('Введение экологически чистых транспортных средств для доставки',
		'В рамках нашей постоянной работы по снижению углеродного следа, мы с гордостью представляем парк экологически чистых транспортных средств для доставки. Эти транспортные средства работают на электричестве или гибридной технологии, что значительно снижает выбросы и способствует устойчивому транспорту. Принятие этих экологически чистых транспортных средств является нашим вкладом в более зеленое будущее и предоставлением экологически осознанных логистических решений нашим клиентам',
		NOW(), 'https://orlando1464.hocoos.com/_ipx/f_webp,q_90/https://img2.hocoos.com/cache/img-pack/1324/w-1900/h-720/ww-1900/wh-720/img-pack/1324/pexels-laura-tancredi-7078717.jpg');

INSERT INTO t_news (news_title, news_content, news_date, image_path)
VALUES ('Новое партнерство для международных перевозок',
		'Мы с радостью объявляем о нашем новом партнерстве с глобальным поставщиком услуг по международным перевозкам, расширяя наши возможности для международных перевозок. Это сотрудничество позволит нам проникнуть на новые рынки, улучшить нашу сеть перевозок и предложить конкурентные тарифы для международных отправлений. С данной партнерской программой мы стремимся предоставить комплексные логистические решения для бизнесов, желающих расширить свою деятельность на международном уровне.',
		NOW(), 'https://orlando1464.hocoos.com/_ipx/f_webp,q_90/https://img2.hocoos.com/cache/img-pack/1324/w-1900/h-720/ww-1900/wh-720/img-pack/1324/pexels-cottonbro-7437499.jpg');






