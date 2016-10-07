package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.User;

public class Dao<T>{
	Class<T> type;
	public Dao(Class<T> type) { this.type = type; }
	public static Connection obtenerConexion(){
		Connection conexion = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/mydb";
			conexion = DriverManager.getConnection(url, "root", "root");
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		return conexion;
	}
	public User login(String codigo, String contrasena) {	
		User admin = null;
		try {
			Connection con = Dao.obtenerConexion();
			Statement stmt = con.createStatement();
			String querystmt="select * from user"
					+ " where Username='"+codigo+"' and Pass='"+contrasena+"' ";
			ResultSet rs = stmt.executeQuery(querystmt);
			if(rs.next()){
				admin = new User();
				admin.setIdUser(rs.getInt("idUser"));
				admin.setUsername(rs.getString("Username"));
				admin.setPass(rs.getString("Pass"));
				admin.setRole(rs.getString("Role"));
			}
			rs.close();
			con.close();	
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		return admin;	
	}
	public boolean agregar(T categoria) {
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
	public boolean eliminar(int id) {
		try {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("Laboratorio");
			EntityManager em = emf.createEntityManager();
			
			EntityTransaction et = em.getTransaction();
			
			T proveedor = em.find(type, id);
			
			et.begin();
			em.remove(proveedor);
			et.commit();
			
			return true;
		} catch (Exception e) {
			System.out.print(e.getMessage());
			return false;
		}
	}
	public boolean actualizar(T T) {
		try {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("Laboratorio");
			EntityManager em = emf.createEntityManager();
			
			EntityTransaction et = em.getTransaction();
			
			et.begin();
			em.merge(T);
			et.commit();
			
			return true;
			
		} catch (Exception e) {
			System.out.print(e.getMessage());
			return false;
		}
	}
	public List<T> listar() {

		List<T> proveedores = new ArrayList<T>();
		
		try{
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("Laboratorio");
			EntityManager em = emf.createEntityManager();
			
			TypedQuery<T> tq = em.createNamedQuery("findAll"+type.getSimpleName(),type);
			proveedores = tq.getResultList();
			
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		return proveedores;
	}

	public T Buscar(int id) {
		List<T> proveedores = new ArrayList<T>();
		T p = null;
		try{
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("Laboratorio");
			EntityManager em = emf.createEntityManager();
			
			TypedQuery<T> tq = em.createNamedQuery("findId"+type.getSimpleName(),type);
			tq.setParameter("id", id);
			proveedores = tq.getResultList();
			p = proveedores.get(0);
			
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		return p;
	}
}
