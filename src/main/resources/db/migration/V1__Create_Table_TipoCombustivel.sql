CREATE TABLE `tipos_combustivel` (
    `id` BIGINT AUTO_INCREMENT PRIMARY KEY,
    `nome` VARCHAR(100) NULL,
    `preco_litro` DECIMAL(10,2) NULL
) ENGINE=InnoDB;