package br.com.alura.loja.dao;

import br.com.alura.loja.model.Categoria;

import javax.persistence.EntityManager;

public class CategoriaDao {

    private EntityManager em;

    public CategoriaDao(EntityManager em) {
        this.em = em;
    }

    public void cadastradar(Categoria categoria) {
        this.em.persist(categoria);
    }
}
