INSERT INTO produto (nome, descricao, preco) VALUES ('Notebook', 'Notebook Dell Inspiron 15', 2999.90);
INSERT INTO produto (nome, descricao, preco) VALUES ('Smartphone', 'Smartphone Samsung Galaxy S21', 3999.99);
INSERT INTO produto (nome, descricao, preco) VALUES ('Tablet', 'Tablet Apple iPad Pro', 4999.00);
INSERT INTO produto (nome, descricao, preco) VALUES ('Monitor', 'Monitor LG UltraWide 34"', 1799.99);
INSERT INTO produto (nome, descricao, preco) VALUES ('Teclado', 'Teclado Mecânico Corsair', 499.99);
INSERT INTO produto (nome, descricao, preco) VALUES ('Mouse', 'Mouse Logitech MX Master 3', 349.99);
INSERT INTO produto (nome, descricao, preco) VALUES ('Impressora', 'Impressora HP LaserJet', 899.90);
INSERT INTO produto (nome, descricao, preco) VALUES ('Fone de Ouvido', 'Fone de Ouvido Sony WH-1000XM4', 1299.99);
INSERT INTO produto (nome, descricao, preco) VALUES ('Câmera', 'Câmera Canon EOS R5', 19999.00);
INSERT INTO produto (nome, descricao, preco) VALUES ( 'Console', 'Console Sony PlayStation 5', 4999.99);

INSERT INTO categoria(nome, categoria_pai_id) VALUES ('Eletrônicos', NULL);
INSERT INTO categoria(nome, categoria_pai_id) VALUES ('Informática', 1);
INSERT INTO categoria(nome, categoria_pai_id) VALUES ('Periféricos', 1);
INSERT INTO categoria(nome, categoria_pai_id) VALUES ('Acessórios', 1);

INSERT INTO cliente(nome, sexo) VALUES ('Maria', 'FEMININO');
INSERT INTO cliente(nome, sexo) VALUES ('João', 'MASCULINO');
INSERT INTO cliente(nome, sexo) VALUES ('Ana', 'FEMININO');

INSERT INTO pedido (data_pedido, data_conclusao, status, total, cliente_id) VALUES ('2022-01-01T10:00:00Z', '2022-01-02T15:30:00Z', 'AGUARDANDO', 15998.88, 1);

INSERT INTO item_pedido (pedido_id, produto_id, preco_produto, quantidade) VALUES (1, 1, 2999.90, 1);
INSERT INTO item_pedido (pedido_id, produto_id, preco_produto, quantidade) VALUES (1, 2, 3999.99, 2);
INSERT INTO item_pedido (pedido_id, produto_id, preco_produto, quantidade) VALUES (1, 3, 4999.00, 1);
