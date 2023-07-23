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

import br.com.quintinno.sistemagerenciadorecommerceapi.model.CategoriaProdutoModel;
import br.com.quintinno.sistemagerenciadorecommerceapi.service.CategoriaProdutoService;

@RestController
@RequestMapping("/categoria-produto")
public class CategoriaProdutoController {
	
	@Autowired
	private CategoriaProdutoService categoriaProdutoService;
	
	@PostMapping
	public CategoriaProdutoModel createOne(@RequestBody CategoriaProdutoModel categoriaProdutoModel) {
		return this.categoriaProdutoService.createOne(categoriaProdutoModel);
	}
	
	@GetMapping
	public List<CategoriaProdutoModel> searchAll() {
		return this.categoriaProdutoService.searchAll();
	}
	
	@GetMapping("/{codigoCategoriaProduto}")
	public CategoriaProdutoModel searchOne(@PathVariable("codigoCategoriaProduto") Long codigoCategoriaProduto) {
		return this.categoriaProdutoService.searchOne(codigoCategoriaProduto);
	}
	
	@PutMapping("/{codigoCategoriaProduto}")
	public CategoriaProdutoModel updateOne(@RequestBody CategoriaProdutoModel categoriaProdutoModel, @PathVariable("codigoCategoriaProduto") Long codigoCategoriaProduto) {
		categoriaProdutoModel.setCodigo(codigoCategoriaProduto);
		return this.categoriaProdutoService.updateOne(categoriaProdutoModel);
	}
	
	@DeleteMapping("/{codigoCategoriaProduto}")
	public void removeOne(@PathVariable("codigoCategoriaProduto")  Long codigoCategoriaProduto) {
		this.categoriaProdutoService.removeOne(codigoCategoriaProduto);
	}

}
