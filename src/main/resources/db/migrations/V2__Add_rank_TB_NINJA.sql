-- V2: Migrations para adicionar a coluna de RANK na tabela ninja

ALTER TABLE tb_ninja
ADD COLUMN rank VARCHAR(255);