package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Category;
import model.Product;
import model.Provider;

public class CategoriaDao implements ICategoriaDao{

	@Override
	public List<Category> listar() {

		List<Category> categorias = new ArrayList<Category>();
		
		try{
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("Laboratorio");
			EntityManager em = emf.createEntityManager();
			
			TypedQuery<Category> tq = em.createNamedQuery("Category.findAll",Category.class);
			categorias = tq.getResultList();
			
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		return categorias;
		
	}

	@Override
	public boolean agregar(Category categoria) {
		try {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("Laboratorio");
			EntityManager em = emf.createEntityManager();
			
			EntityTransaction et = em.getTransaction();
			et.begin();
			em.persist(categoria);
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
			
			Category categoria = em.find(Category.class, id);
			
			et.begin();
			em.remove(categoria);
			et.commit();
			
			return true;
		} catch (Exception e) {
			System.out.print(e.getMessage());
			return false;
		}
	}

	@Override
	public Category Buscar(int id) {
		
		List<Category> categorias = new ArrayList<Category>();
		Category c = null;
		
		try{
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("Laboratorio");
			EntityManager em = emf.createEntityManager();
			
			TypedQuery<Category> tq = em.createNamedQuery("Category.findId",Category.class);
			tq.setParameter("id", id);
			categorias = tq.getResultList();
			System.out.println(categorias.get(0).getName());
			c = categorias.get(0);
			
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		return c;
	}

}
