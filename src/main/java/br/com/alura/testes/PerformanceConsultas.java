package br.com.alura.testes;

import br.com.alura.loja.dao.CategoriaDao;
import br.com.alura.loja.dao.ClienteDao;
import br.com.alura.loja.dao.PedidoDao;
import br.com.alura.loja.dao.ProdutoDao;
import br.com.alura.loja.model.*;
import br.com.alura.loja.util.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;

public class PerformanceConsultas {

    public static void main(String[] args) {
        popularBancoDeDados();
        EntityManager em = JPAUtil.getEntityManeger();
        PedidoDao pedidoDao = new PedidoDao(em);
        Pedido pedido = pedidoDao.buscarPedidoComCliente(1l);
        em.close();

        System.out.println(pedido.getCliente().getNome());
    }

    private static void popularBancoDeDados() {
        Categoria celulares = new Categoria("CELULARES");
        Categoria videogames = new Categoria("VIDEOGAMES");
        Categoria informatica = new Categoria("INFORMATICA");

        Produto celular = new Produto("Xiaomi Redmi", "Muito legal", new BigDecimal("800"), celulares);
        Produto videogame = new Produto("PS5", "Playstation 5", new BigDecimal("4000"), videogames);
        Produto macbook = new Produto("Macbook", "Macbook pro", new BigDecimal("4500"), informatica);

        Cliente cliente = new Cliente("Rodrigo", "123456");

        Pedido pedido = new Pedido(cliente);
        pedido.adicionarItem(new ItemPedido(10, pedido, celular));
        pedido.adicionarItem(new ItemPedido(40, pedido, videogame));

        Pedido pedido2 = new Pedido(cliente);
        pedido2.adicionarItem(new ItemPedido(2, pedido2, macbook));

        EntityManager em = JPAUtil.getEntityManeger();
        ProdutoDao produtoDao = new ProdutoDao(em);
        ClienteDao clienteDao = new ClienteDao(em);
        CategoriaDao categoriaDao = new CategoriaDao(em);
        PedidoDao pedidoDao = new PedidoDao(em);

        em.getTransaction().begin();

        categoriaDao.cadastradar(celulares);
        categoriaDao.cadastradar(videogames);
        categoriaDao.cadastradar(informatica);

        produtoDao.cadastradar(celular);
        produtoDao.cadastradar(videogame);
        produtoDao.cadastradar(macbook);

        clienteDao.cadastradar(cliente);
        pedidoDao.cadastradar(pedido);
        pedidoDao.cadastradar(pedido2);

        em.getTransaction().commit();
        em.close();
    }
}
