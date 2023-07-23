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

import br.com.quintinno.sistemagerenciadorecommerceapi.model.ClienteModel;
import br.com.quintinno.sistemagerenciadorecommerceapi.service.ClienteService;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	
	@PostMapping
	public ClienteModel createOne(@RequestBody ClienteModel clienteModel) {
		return this.clienteService.createOne(clienteModel);
	}
	
	@GetMapping
	public List<ClienteModel> searchAll() {
		return this.clienteService.searchAll();
	}
	
	@GetMapping("/{codigoCliente}")
	public ClienteModel searchOne(@PathVariable("codigoCliente") Long codigoCategoriaProduto) {
		return this.clienteService.searchOne(codigoCategoriaProduto);
	}
	
	@PutMapping("/{codigoCliente}")
	public ClienteModel updateOne(@RequestBody ClienteModel clienteModel, @PathVariable("codigoCliente") Long codigoCliente) {
			clienteModel.setCodigo(codigoCliente);
		return this.clienteService.updateOne(clienteModel);
	}
	
	@DeleteMapping("/{codigoCliente}")
	public void removeOne(@PathVariable("codigoCliente")  Long codigoCategoriaProduto) {
		this.clienteService.removeOne(codigoCategoriaProduto);
	}

}
