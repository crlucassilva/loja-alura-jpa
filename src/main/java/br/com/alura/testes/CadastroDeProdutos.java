package br.com.alura.testes;

import br.com.alura.loja.dao.ProdutoDao;
import br.com.alura.loja.model.Produto;
import br.com.alura.loja.util.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;

public class CadastroDeProdutos {

    public static void main(String[] args) {
        Produto celular = new Produto();
        celular.setNome("Xiaomi Redmi");
        celular.setDescricao("Muito legal");
        celular.setPreco(new BigDecimal("800"));

        EntityManager em = JPAUtil.getEntityManeger();
        ProdutoDao dao = new ProdutoDao(em);

        em.getTransaction().begin();
        dao.cadastradar(celular);
        em.getTransaction().commit();
        em.close();
    }
}
