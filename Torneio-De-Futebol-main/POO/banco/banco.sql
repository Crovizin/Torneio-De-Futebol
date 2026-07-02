-- ==========================================
-- BANCO DE DADOS DO TORNEIO
-- ==========================================

DROP DATABASE IF EXISTS torneio;

CREATE DATABASE torneio;

USE torneio;

CREATE TABLE time(
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL UNIQUE,
    pais VARCHAR(50) NOT NULL,
    ranking INT NOT NULL,
    curiosidade TEXT,
    resumo TEXT,
    chance_titulo DECIMAL(5,2)
);

INSERT INTO time(nome,pais,ranking,curiosidade,resumo,chance_titulo) VALUES
('Mixto','Brasil',1,'Clube tradicional de Mato Grosso.','Um dos clubes mais tradicionais do Mato Grosso.',2.5),

('Paysandu','Brasil',2,'Conhecido como Papão da Curuzu.','Clube tradicional do Pará.',4.0),

('Flamengo','Brasil',3,'Maior torcida do Brasil.','Um dos clubes mais vencedores da América do Sul.',18.0),

('Real Madrid','Espanha',4,'Maior campeão da Champions League.','Considerado um dos maiores clubes do mundo.',22.0),

('Chapada FC','Brasil',5,'Representante da Chapada dos Guimarães.','Equipe regional utilizada no torneio.',1.0),

('Fenerbahce','Turquia',6,'Grande rival do Galatasaray.','Um dos maiores clubes da Turquia.',7.0),

('Al-Nasrr','Arábia Saudita',7,'Clube que ganhou destaque recentemente.','Equipe tradicional da Arábia Saudita.',8.0),

('Inter Miami','Estados Unidos',8,'Popularizou-se mundialmente nos últimos anos.','Clube da MLS.',10.0),

('Votuporanguense','Brasil',9,'Equipe do interior paulista.','Tradicional clube paulista.',1.5),

('Milan','Itália',10,'Sete títulos da Champions League.','Gigante do futebol italiano.',15.0),

('Aguia de Maraba','Brasil',11,'Clube paraense.','Representante do estado do Pará.',1.0),

('Bodo/Glimt','Noruega',12,'Clube destaque da Noruega.','Equipe que cresceu muito no futebol europeu.',6.0),

('Clube Brugge','Bélgica',13,'Maior campeão belga.','Clube tradicional da Bélgica.',6.0),

('Cuiaba','Brasil',14,'Representante mato-grossense na Série A.','Equipe em crescimento no futebol brasileiro.',5.0),

('Barcelona','Espanha',15,'Casa de grandes craques da história.','Um dos maiores clubes do planeta.',20.0),

('PSV','Holanda',16,'Tradicional clube holandês.','Grande revelador de jogadores.',8.0),

('Ajax','Holanda',17,'Maior formador de talentos da Holanda.','Clube histórico europeu.',10.0),

('Napoli','Itália',18,'Clube eternizado por Maradona.','Equipe do sul da Itália.',11.0),

('Juventus','Itália',19,'Maior campeão italiano.','Gigante de Turim.',14.0),

('Manchester City','Inglaterra',20,'Atual potência do futebol inglês.','Um dos favoritos ao título.',23.0),

('Tottenham','Inglaterra',21,'Clube londrino tradicional.','Equipe competitiva da Premier League.',9.0),

('Liverpool','Inglaterra',22,'Seis vezes campeão europeu.','Um dos maiores clubes do mundo.',19.0),

('Caceres','Brasil',23,'Representante do Mato Grosso.','Equipe regional.',1.0),

('Madureira','Brasil',24,'Tradicional clube carioca.','Equipe do Rio de Janeiro.',1.5),

('Bangu','Brasil',25,'Um dos clubes mais antigos do Rio.','Tradicional equipe carioca.',1.5),

('Volta Redonda','Brasil',26,'Clube do interior fluminense.','Equipe competitiva do Rio.',2.0),

('Inter de Milao','Itália',27,'Atual gigante italiano.','Tradicional clube de Milão.',16.0),

('PSG','França',28,'Maior investimento do futebol francês.','Principal clube da França.',17.0),

('Bayern de Munique','Alemanha',29,'Maior campeão alemão.','Potência europeia.',21.0),

('Borussia Dortmund','Alemanha',30,'Conhecido pelo Muro Amarelo.','Clube tradicional alemão.',12.0),

('Arsenal','Inglaterra',31,'Tradicional clube de Londres.','Equipe histórica da Premier League.',15.0),

('Libolo','Angola',32,'Tradicional equipe angolana.','Representante do futebol africano.',1.0);