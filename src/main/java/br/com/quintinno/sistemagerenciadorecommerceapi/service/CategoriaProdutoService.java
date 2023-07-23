package br.com.quintinno.sistemagerenciadorecommerceapi.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.quintinno.sistemagerenciadorecommerceapi.model.CategoriaProdutoModel;
import br.com.quintinno.sistemagerenciadorecommerceapi.repository.CategoriaProdutoRepository;

@Service
public class CategoriaProdutoService {
	
	@Autowired
	private CategoriaProdutoRepository categoriaProdutoRepository;
	
	public CategoriaProdutoModel createOne(CategoriaProdutoModel categoriaProdutoModel) {
		return this.categoriaProdutoRepository.save(categoriaProdutoModel);
	}
	
	public List<CategoriaProdutoModel> searchAll() {
		return this.categoriaProdutoRepository.findAll();
	}
	
	public CategoriaProdutoModel searchOne(Long codigoCategoriaProduto) {
		return this.categoriaProdutoRepository.findById(codigoCategoriaProduto).orElseThrow( () -> 
			new NoSuchElementException("Categoria Não Encontrada!"));
	}
	
	public CategoriaProdutoModel updateOne(CategoriaProdutoModel categoriaProdutoModel) {
			categoriaProdutoModel.setNome(categoriaProdutoModel.getNome());
		return this.categoriaProdutoRepository.save(categoriaProdutoModel);
	}
	
	public void removeOne(Long codigoCategoriaProduto) {
		this.categoriaProdutoRepository.deleteById(codigoCategoriaProduto);
	}

}
