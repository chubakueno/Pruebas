package test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

import dao.Dao;
import model.User;

public class UsuarioDaoTest {

	
	public Dao<User> usuarioDao = new Dao<>(User.class);
	public User usuario;
	
	public UsuarioDaoTest(){
		
	}
	
	@BeforeClass
	public static void setUpClass() {
    	System.out.println("***INICIO DE LA CLASE***");
	}
    
	@AfterClass
	public static void tearDownClass() {
    	System.out.println("***FIN DE LA CLASE****");
	}
    
	@Before
	public void setUp() {
    	System.out.println("***INICIO DEL METODO***");
	}
    
	@After
	public void tearDown() {
    	System.out.println("**FIN DEL METODO***");
	}
	
	
	
	@org.junit.Test
	public void a_testLogear() throws Exception {
    	System.out.println("logear");
    	try {
        	usuario = new User();
        	String codigo = "admin";
        	String contrasena = "admin";
        	
        	assertTrue(usuarioDao.login(codigo, contrasena)!=null);
    	} catch (Exception e) {
        	e.printStackTrace();
        	fail("Ocurrio un error "+ e.getMessage());
    	}
	}
	
}
