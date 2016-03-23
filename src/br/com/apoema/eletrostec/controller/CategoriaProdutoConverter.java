package br.com.apoema.eletrostec.controller;

import org.springframework.core.convert.converter.Converter;

import br.com.apoema.eletrostec.model.CategoriaProduto;
import br.com.apoema.eletrostec.dao.CategoriaProdutoDao;

public class CategoriaProdutoConverter implements Converter<String, CategoriaProduto> {

	public CategoriaProduto convert(String id) {

		CategoriaProdutoDao dao = new CategoriaProdutoDao();
		return dao.buscarPorId(Integer.valueOf(id));
	}
}