package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import java.sql.*;

import model.Product;
import model.Provider;

public class ProveedorDao implements IProveedorDao{

	public List<Provider> listar() {

		List<Provider> proveedores = new ArrayList<Provider>();
		
		try{
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("Laboratorio");
			EntityManager em = emf.createEntityManager();
			
			TypedQuery<Provider> tq = em.createNamedQuery("Provider.findAll",Provider.class);
			proveedores = tq.getResultList();
			
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		return proveedores;
	}

	
	public boolean agregar(Provider provider) {
		try {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("Laboratorio");
			EntityManager em = emf.createEntityManager();
			
			EntityTransaction et = em.getTransaction();
			et.begin();
			em.persist(provider);
			et.commit();
			
			return true;
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.print(e.getMessage());
			
			return false;
		}
	}

	
	public boolean eliminar(int id) {
		try {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("Laboratorio");
			EntityManager em = emf.createEntityManager();
			
			EntityTransaction et = em.getTransaction();
			
			Provider proveedor = em.find(Provider.class, id);
			
			et.begin();
			em.remove(proveedor);
			et.commit();
			
			return true;
		} catch (Exception e) {
			System.out.print(e.getMessage());
			return false;
		}
	}


	@Override
	public Provider Buscar(int id) {
		List<Provider> proveedores = new ArrayList<Provider>();
		Provider p = null;
		try{
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("Laboratorio");
			EntityManager em = emf.createEntityManager();
			
			TypedQuery<Provider> tq = em.createNamedQuery("Provider.findAll",Provider.class);
			proveedores = tq.getResultList();
			p = proveedores.get(id-1);
			
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		return p;
	}


	@Override
	public boolean actualizar(Provider provider) {
		try {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("Laboratorio");
			EntityManager em = emf.createEntityManager();
			
			EntityTransaction et = em.getTransaction();
			
			et.begin();
			em.merge(provider);
			et.commit();
			
			return true;
			
		} catch (Exception e) {
			System.out.print(e.getMessage());
			return false;
		}
	}

}
