package br.com.quintinno.sistemagerenciadorecommerceapi;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.quintinno.sistemagerenciadorecommerceapi.model.CategoriaProdutoModel;
import br.com.quintinno.sistemagerenciadorecommerceapi.model.ProdutoModel;
import br.com.quintinno.sistemagerenciadorecommerceapi.service.CategoriaProdutoService;
import br.com.quintinno.sistemagerenciadorecommerceapi.service.ProdutoService;

@SpringBootApplication
public class Application implements CommandLineRunner {
	
	@Autowired
	private CategoriaProdutoService categoriaProdutoService;
	
	@Autowired
	private ProdutoService produtoService;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		CategoriaProdutoModel categoriaProdutoModel1 = new CategoriaProdutoModel("Informática");
		CategoriaProdutoModel categoriaProdutoModel2 = new CategoriaProdutoModel("Utilidades Domésticas");
		CategoriaProdutoModel categoriaProdutoModel3 = new CategoriaProdutoModel("Pneus");
		
			this.categoriaProdutoService.createOne(categoriaProdutoModel1);
			this.categoriaProdutoService.createOne(categoriaProdutoModel2);
			this.categoriaProdutoService.createOne(categoriaProdutoModel3);
			
		ProdutoModel produtoModel1 = new ProdutoModel("Notebook Gamer Acer NITRO 5 AN515-45-R91A AMD Ryzen 5 8GB 512GB SSD Tela 15,6 Full HD Windows 11", BigDecimal.valueOf(3800.99));
		ProdutoModel produtoModel2 = new ProdutoModel("Kit 4 Pneus Aro 15 WESTLAKE 205 65R15 SL369 CR65758", BigDecimal.valueOf(1211.34));
		ProdutoModel produtoModel3 = new ProdutoModel("Mouse Sem Fio Movitec Plug and Play OMw-02 Preto/Azul Petróleo", BigDecimal.valueOf(33.92));
		
			categoriaProdutoModel1.getProdutoModelList().add(produtoModel1);
			categoriaProdutoModel3.getProdutoModelList().add(produtoModel2);
			categoriaProdutoModel1.getProdutoModelList().add(produtoModel3);
			
			produtoModel1.getCategoriaProdutoModelList().add(categoriaProdutoModel1);
			produtoModel2.getCategoriaProdutoModelList().add(categoriaProdutoModel2);
			produtoModel3.getCategoriaProdutoModelList().add(categoriaProdutoModel1);
			
			this.produtoService.createOne(produtoModel1);
			this.produtoService.createOne(produtoModel2);
			this.produtoService.createOne(produtoModel3);
			
	}

}
