package br.com.alura.testes;

import br.com.alura.loja.dao.CategoriaDao;
import br.com.alura.loja.dao.ProdutoDao;
import br.com.alura.loja.model.Categoria;
import br.com.alura.loja.model.Produto;
import br.com.alura.loja.util.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.time.LocalDate;

public class TesteCriteria {

    public static void main(String[] args) {
        popularBancoDedados();
        EntityManager em = JPAUtil.getEntityManeger();
        ProdutoDao produtoDao = new ProdutoDao(em);
        produtoDao.buscarPorParametrosComCriteria(null, null, LocalDate.now());
    }

    private static void popularBancoDedados() {
        Categoria celulares = new Categoria("CELULARES");
        Categoria videogames = new Categoria("VIDEOGAMES");
        Categoria informatica = new Categoria("INFORMATICA");

        Produto celular = new Produto("Xiaomi Redmi", "Muito legal", new BigDecimal("800"), celulares);
        Produto videogame = new Produto("PS5", "Playstation 5", new BigDecimal("4000"), videogames);
        Produto macbook = new Produto("Macbook", "Macbook pro", new BigDecimal("4500"), informatica);

        EntityManager em = JPAUtil.getEntityManeger();
        ProdutoDao produtoDao = new ProdutoDao(em);
        CategoriaDao categoriaDao = new CategoriaDao(em);

        em.getTransaction().begin();

        categoriaDao.cadastradar(celulares);
        categoriaDao.cadastradar(videogames);
        categoriaDao.cadastradar(informatica);

        produtoDao.cadastradar(celular);
        produtoDao.cadastradar(videogame);
        produtoDao.cadastradar(macbook);

        em.getTransaction().commit();
        em.close();
    }
}
