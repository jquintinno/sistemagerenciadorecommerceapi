# Sistema de Gerenciamento de E-commerce (API)

  --- Comandos XAMP (MySQL)

     sudo /opt/lampp/lampp start
     sudo /opt/lampp/lampp stop
     http://localhost/phpmyadmin/
     
   --- Funcionalidades 
   
   		- Funcionalidade Gerenciador de Pessoas (FUNGERPES)
   		- Funcionalidade Gerenciador de Produtos (FUNGERPRO)
   		- Funcionalidade Gerenciador de Compras (FUNGERCOM)
   		
   --- Demandas
   
   		- SISGERECO22072023200644
   			- Feature: Implementar configuração de banco de dados MySQL
   
   		- SISGERECO22072023212622
   			- Feature: Implementar mapeamento Gerenciador de Produtos (FUNGERPRO)
   			
   		- SISGERECO23072023122458
   			- Feature: Implementar mapeamento Gerenciador de Pessoas (FUNGERPES)
   			
   		- SISGERECO23072023182948
   			- Feature: Implementar mapeamento Gerenciador de Compras (FUNGERCOM)
   			
   	--- Tabelas
   	
	   	create table tb_categoria_produto (
	        codigo bigint not null auto_increment,
	        nome varchar(255),
	        primary key (codigo)
	    ) engine=InnoDB;
	    
	    create table tb_produto (
	        preco decimal(38,2),
	        codigo bigint not null auto_increment,
	        id_categoria_produto bigint,
	        nome varchar(255),
	        primary key (codigo)
	    ) engine=InnoDB;
	    
	    create table tb_produto_categoria_produto (
	        id_categoria_produto bigint not null,
	        id_produto bigint not null,
	        primary key (id_categoria_produto, id_produto)
	    ) engine=InnoDB;
	    
		create table tb_estado (
	        codigo bigint not null auto_increment,
	        nome varchar(255),
	        primary key (codigo)
	    ) engine=InnoDB;
	    
	    create table tb_cidade (
	        codigo bigint not null auto_increment,
	        id_estado bigint,
	        nome varchar(255),
	        primary key (codigo)
	    ) engine=InnoDB;
	    
	    
	    
	    
