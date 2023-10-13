package br.com.alura.loja.dao;

import br.com.alura.loja.model.Produto;

import javax.persistence.EntityManager;

public class ProdutoDao {

    private EntityManager em;

    public ProdutoDao(EntityManager em) {
        this.em = em;
    }

    public void cadastradar(Produto produto) {
        this.em.persist(produto);
    }
}
