package br.com.quintinno.sistemagerenciadorecommerceapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.quintinno.sistemagerenciadorecommerceapi.model.ProdutoModel;
import br.com.quintinno.sistemagerenciadorecommerceapi.service.ProdutoService;

@RestController
@RequestMapping("/produto")
public class ProdutoController {
	
	@Autowired
	private ProdutoService produtoService;
	
	@PostMapping
	public ProdutoModel createOne(@RequestBody ProdutoModel produtoModel) {
		return this.produtoService.createOne(produtoModel);
	}
	
	@GetMapping
	public List<ProdutoModel> searchAll() {
		return this.produtoService.searchAll();
	}
	
	@GetMapping("/{codigoProduto}")
	public ProdutoModel searchOne(@PathVariable("codigoProduto") Long codigoCategoriaProduto) {
		return this.produtoService.searchOne(codigoCategoriaProduto);
	}
	
	@PutMapping("/{codigoProduto}")
	public ProdutoModel updateOne(@RequestBody ProdutoModel produtoModel, @PathVariable("codigoProduto") Long codigoProduto) {
			produtoModel.setCodigo(codigoProduto);
		return this.produtoService.updateOne(produtoModel);
	}
	
	@DeleteMapping("/{codigoProduto}")
	public void removeOne(@PathVariable("codigoProduto")  Long codigoCategoriaProduto) {
		this.produtoService.removeOne(codigoCategoriaProduto);
	}

}
