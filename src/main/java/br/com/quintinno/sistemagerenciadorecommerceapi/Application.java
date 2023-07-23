package br.com.quintinno.sistemagerenciadorecommerceapi;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.quintinno.sistemagerenciadorecommerceapi.model.CategoriaProdutoModel;
import br.com.quintinno.sistemagerenciadorecommerceapi.model.CidadeModel;
import br.com.quintinno.sistemagerenciadorecommerceapi.model.ClienteModel;
import br.com.quintinno.sistemagerenciadorecommerceapi.model.EnderecoModel;
import br.com.quintinno.sistemagerenciadorecommerceapi.model.EstadoModel;
import br.com.quintinno.sistemagerenciadorecommerceapi.model.ProdutoModel;
import br.com.quintinno.sistemagerenciadorecommerceapi.repository.ClienteRepository;
import br.com.quintinno.sistemagerenciadorecommerceapi.repository.EstadoRepository;
import br.com.quintinno.sistemagerenciadorecommerceapi.service.CategoriaProdutoService;
import br.com.quintinno.sistemagerenciadorecommerceapi.service.ProdutoService;

@SpringBootApplication
public class Application implements CommandLineRunner {
	
	@Autowired
	private CategoriaProdutoService categoriaProdutoService;
	
	@Autowired
	private ProdutoService produtoService;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;

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
			
			EstadoModel estadoModel1 = new EstadoModel("Distrito Federal", "DF");
			EstadoModel estadoModel2 = new EstadoModel("Goias", "GO");
			
			CidadeModel cidadeModel1 = new CidadeModel("Ceilândia", estadoModel1);
			CidadeModel cidadeModel2 = new CidadeModel("Samambaia", estadoModel1);
			CidadeModel cidadeModel3 = new CidadeModel("Taguatinga", estadoModel1);
			CidadeModel cidadeModel4 = new CidadeModel("Goiânia", estadoModel2);
			CidadeModel cidadeModel5 = new CidadeModel("Aparecida de Goiânia", estadoModel2);
			CidadeModel cidadeModel6 = new CidadeModel("Anápolis", estadoModel2);
			
				estadoModel1.getCidadeModelList().add(cidadeModel1);
				estadoModel1.getCidadeModelList().add(cidadeModel2);
				estadoModel1.getCidadeModelList().add(cidadeModel3);
				
				estadoModel2.getCidadeModelList().add(cidadeModel4);
				estadoModel2.getCidadeModelList().add(cidadeModel5);
				estadoModel2.getCidadeModelList().add(cidadeModel6);
			
				this.estadoRepository.save(estadoModel1);
				this.estadoRepository.save(estadoModel2);
				
			ClienteModel clienteModel1 = new ClienteModel("Mousbler Gowas Sayra Bowou", "mousbler.bowou@hotmail.com.br", "56926210020", 1);
				clienteModel1.getTelefoneList().add("(61) 3533-9341");
				clienteModel1.getTelefoneList().add("(61) 99854-8378");
				
			EnderecoModel enderecoModel1 = new EnderecoModel("Quadra", "611", "Conjunto 4 Lote 14", "Samamabaia Norte", "72.331-604", clienteModel1, cidadeModel2);
			EnderecoModel enderecoModel2 = new EnderecoModel("Quadra", "8", "QNL 8 Bloco F", "Taguatinga Norte (Taguatinga)", "72155-816", clienteModel1, cidadeModel3);
			
				clienteModel1.getEnderecoModelList().add(enderecoModel1);
				clienteModel1.getEnderecoModelList().add(enderecoModel2);
				
				clienteRepository.save(clienteModel1);
			
	}

}
