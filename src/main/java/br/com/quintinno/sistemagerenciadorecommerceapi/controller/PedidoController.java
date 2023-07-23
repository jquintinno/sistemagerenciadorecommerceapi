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

import br.com.quintinno.sistemagerenciadorecommerceapi.model.PedidoModel;
import br.com.quintinno.sistemagerenciadorecommerceapi.service.PedidoService;

@RestController
@RequestMapping("/pedido")
public class PedidoController {
	
	@Autowired
	private PedidoService pedidoService;
	
	@PostMapping
	public PedidoModel createOne(@RequestBody PedidoModel pedidoModel) {
		return this.pedidoService.createOne(pedidoModel);
	}
	
	@GetMapping
	public List<PedidoModel> searchAll() {
		return this.pedidoService.searchAll();
	}
	
	@GetMapping("/{codigoPedido}")
	public PedidoModel searchOne(@PathVariable("codigoPedido") Long codigoCategoriaProduto) {
		return this.pedidoService.searchOne(codigoCategoriaProduto);
	}
	
	@PutMapping("/{codigoPedido}")
	public PedidoModel updateOne(@RequestBody PedidoModel pedidoModel, @PathVariable("codigoPedido") Long codigoProduto) {
			pedidoModel.setCodigo(codigoProduto);
		return this.pedidoService.updateOne(pedidoModel);
	}
	
	@DeleteMapping("/{codigoPedido}")
	public void removeOne(@PathVariable("codigoPedido")  Long codigoCategoriaProduto) {
		this.pedidoService.removeOne(codigoCategoriaProduto);
	}

}
