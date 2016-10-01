package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.*;

public class ProductoDao implements IProductoDao{

	@Override
	public List<Product> listar() {
		List<Product> productos = new ArrayList<Product>();
		
		try{
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("Laboratorio");
			EntityManager em = emf.createEntityManager();
			
			TypedQuery<Product> tq = em.createNamedQuery("Product.findAll",Product.class);
			productos = tq.getResultList();
			
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		return productos;
	}

	@Override
	public boolean agregar(Product producto) {
		
		try {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("Laboratorio");
			EntityManager em = emf.createEntityManager();
			
			EntityTransaction et = em.getTransaction();
			et.begin();
			em.persist(producto);
			et.commit();
			
			return true;
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.print(e.getMessage());
			
			return false;
		}
	}

	@Override
	public boolean eliminar(int id) {
		try {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("Laboratorio");
			EntityManager em = emf.createEntityManager();
			
			EntityTransaction et = em.getTransaction();
			
			Product producto = em.find(Product.class, id);
			
			et.begin();
			em.remove(producto);
			et.commit();
			
			return true;
		} catch (Exception e) {
			System.out.print(e.getMessage());
			return false;
		}
	}

	@Override
	public Product Buscar(int id) {
		// TODO Auto-generated method stub
		List<Product> productos = new ArrayList<Product>();
		Product p = null;
		
		try{
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("Laboratorio");
			EntityManager em = emf.createEntityManager();
			
			TypedQuery<Product> tq = em.createNamedQuery("Product.findId",Product.class);
			tq.setParameter("id", id);
			productos = tq.getResultList();
			p = productos.get(0);
			
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		return p;
	}

	@Override
	public boolean actualizar(Product producto) {
		try {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("Laboratorio");
			EntityManager em = emf.createEntityManager();
			
			EntityTransaction et = em.getTransaction();
			
			et.begin();
			em.merge(producto);
			et.commit();
			
			return true;
			
		} catch (Exception e) {
			System.out.print(e.getMessage());
			return false;
		}
	}

	
}
