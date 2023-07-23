package br.com.quintinno.sistemagerenciadorecommerceapi.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.quintinno.sistemagerenciadorecommerceapi.model.PedidoModel;
import br.com.quintinno.sistemagerenciadorecommerceapi.repository.PedidoRepository;

@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	public PedidoModel createOne(PedidoModel pedidoModel) {
		return this.pedidoRepository.save(pedidoModel);
	}
	
	public List<PedidoModel> searchAll() {
		return this.pedidoRepository.findAll();
	}
	
	public PedidoModel searchOne(Long codigoPedido) {
		return this.pedidoRepository.findById(codigoPedido).orElseThrow(() ->
			new NoSuchElementException("Pedido Não Encontrado!"));
	}
	
	public PedidoModel updateOne(PedidoModel pedidoModel) {
		return this.pedidoRepository.save(pedidoModel);
	}
	
	public void removeOne(Long codigoPedido) {
		this.pedidoRepository.deleteById(codigoPedido);
	}

}
