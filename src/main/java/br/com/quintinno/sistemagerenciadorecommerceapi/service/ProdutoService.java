package br.com.quintinno.sistemagerenciadorecommerceapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.quintinno.sistemagerenciadorecommerceapi.model.ProdutoModel;
import br.com.quintinno.sistemagerenciadorecommerceapi.repository.ProdutoRepository;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	public ProdutoModel createOne(ProdutoModel produtoModel) {
		return this.produtoRepository.save(produtoModel);
	}
	
	public List<ProdutoModel> searchAll() {
		return this.produtoRepository.findAll();
	}
	
	public ProdutoModel searchOne(Long codigoCategoriaProduto) {
		return this.produtoRepository.findById(codigoCategoriaProduto).orElseThrow();
	}
	
	public ProdutoModel updateOne(ProdutoModel produtoModel) {
			produtoModel.setNome(produtoModel.getNome());
		return this.produtoRepository.save(produtoModel);
	}
	
	public void removeOne(Long codigoCategoriaProduto) {
		this.produtoRepository.deleteById(codigoCategoriaProduto);
	}

}
