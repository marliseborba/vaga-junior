CREATE TABLE IF NOT EXISTS `bombas_combustivel` (
    `id` BIGINT AUTO_INCREMENT PRIMARY KEY,
    `nome` VARCHAR(100) NULL,
    `tipo_combustivel_id` BIGINT NOT NULL,
    FOREIGN KEY (`tipo_combustivel_id`)
    REFERENCES `tipos_combustivel` (`id`)
) ENGINE=InnoDB;