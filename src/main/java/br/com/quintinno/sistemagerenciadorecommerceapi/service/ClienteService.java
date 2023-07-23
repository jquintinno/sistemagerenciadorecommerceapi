package br.com.quintinno.sistemagerenciadorecommerceapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.quintinno.sistemagerenciadorecommerceapi.model.ClienteModel;
import br.com.quintinno.sistemagerenciadorecommerceapi.repository.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	public ClienteModel createOne(ClienteModel clienteModel) {
		return this.clienteRepository.save(clienteModel);
	}
	
	public List<ClienteModel> searchAll() {
		return this.clienteRepository.findAll();
	}
	
	public ClienteModel searchOne(Long codigoCategoriaProduto) {
		return this.clienteRepository.findById(codigoCategoriaProduto).orElseThrow();
	}
	
	public ClienteModel updateOne(ClienteModel clienteModel) {
			clienteModel.setNome(clienteModel.getNome());
		return this.clienteRepository.save(clienteModel);
	}
	
	public void removeOne(Long codigoCategoriaProduto) {
		this.clienteRepository.deleteById(codigoCategoriaProduto);
	}

}
