CREATE TABLE IF NOT EXISTS `abastecimentos` (
    `id` BIGINT AUTO_INCREMENT PRIMARY KEY,
    `data` DATE NULL,
    `litros` DECIMAL(10,2) NULL,
    `valor` DECIMAL(10,2) NULL,
    `bomba_combustivel_id` BIGINT NOT NULL,
    FOREIGN KEY (`bomba_combustivel_id`)
    REFERENCES `bombas_combustivel` (`id`)
) ENGINE=InnoDB;
