package test;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import javax.persistence.RollbackException;

import org.junit.*;
import org.junit.runners.MethodSorters;

import dao.Dao;
import model.Category;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CategoriaDaoTest {

	public Dao<Category> categoriaDao = new Dao<>(Category.class);
	public static Category categoria;
	
	public CategoriaDaoTest(){
		
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
	public void a_testInsertar() throws Exception {
    	System.out.println("insertar");
    	try {
        	categoria = new Category();
        	categoria.setName("Carnes");        	
        	categoriaDao.agregar(categoria);
        	
        	assertTrue(categoria.getIdCategory()>0);
    	} catch (Exception e) {
        	e.printStackTrace();
        	fail("Ocurrio un error "+ e.getMessage());
    	}
	}


	@org.junit.Test
	public void b_testActualizar() throws Exception {
    	System.out.println("actualizar");
    	try {
        	categoria.setName("Lacteos");
         	categoriaDao.actualizar(categoria);
        	assertTrue(categoria.getName().equals("Lacteos"));
    	} catch (Exception e) {
        	e.printStackTrace();
        	fail("Ocurrio un error "+ e.getMessage());
    	}
	}

	@org.junit.Test
	public void c_testEliminar() throws Exception {
    	System.out.println("eliminar");
    	try {
        	categoriaDao.eliminar(categoria.getIdCategory());
        	assertTrue(true);
    	} catch (Exception e) {
        	e.printStackTrace();
        	fail("Ocurrio un error "+ e.getMessage());
    	}
	}


	@org.junit.Test
	public void d_testBuscar() throws Exception {
    	System.out.println("Buscar");
    	try {
        	Category categoriaBuscada = categoriaDao.Buscar(1);
        	assertNotNull(categoriaBuscada);
    	} catch (Exception e) {
        	e.printStackTrace();
        	fail("Ocurrio un error: "+e.getMessage());
    	}
	}

	
	@org.junit.Test
	public void e_testListar() throws Exception {
    	System.out.println("listar");
   	try {
   			
        	assertTrue(categoriaDao.listar().size()>0);
    	} catch (Exception e) {
        	e.printStackTrace();
        	fail("Ocurrio un error: "+e.getMessage());
    	}
	}
	
	@org.junit.Test
	public void f_testInsertarEmpty(){
    	System.out.println("insertarEmpty");
        categoria = new Category();   
        try{
        	categoriaDao.agregar(categoria);
        }catch(Exception e){
        	assertTrue(e.getClass()==RollbackException.class);
        }
    }
}
