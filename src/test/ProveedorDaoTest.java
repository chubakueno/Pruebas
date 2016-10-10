package test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import javax.persistence.RollbackException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

import dao.Dao;
import model.Provider;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProveedorDaoTest {

	public Dao<Provider> proveedorDao = new Dao<>(Provider.class);
	public static Provider proveedor;
	
	public ProveedorDaoTest(){
		
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
        	proveedor = new Provider();
        	proveedor.setName("UPC Provider");        	
        	proveedorDao.agregar(proveedor);
        	
        	assertTrue(proveedor.getIdProvider()>0);
    	} catch (Exception e) {
        	e.printStackTrace();
        	fail("Ocurrio un error "+ e.getMessage());
    	}
	}


	@org.junit.Test
	public void b_testActualizar() throws Exception {
    	System.out.println("actualizar");
    	try {
        	proveedor.setName("U Provider");
         	proveedorDao.actualizar(proveedor);
        	assertTrue(proveedor.getName().equals("U Provider"));
    	} catch (Exception e) {
        	e.printStackTrace();
        	fail("Ocurrio un error "+ e.getMessage());
    	}
	}

	@org.junit.Test
	public void c_testEliminar() throws Exception {
    	System.out.println("eliminar");
    	try {
    		proveedorDao.eliminar(proveedor.getIdProvider());
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
        	Provider proveedorBuscado = proveedorDao.Buscar(1);
        	assertNotNull(proveedorBuscado);
    	} catch (Exception e) {
        	e.printStackTrace();
        	fail("Ocurrio un error: "+e.getMessage());
    	}
	}

	
	@org.junit.Test
	public void e_testListar() throws Exception {
    	System.out.println("listar");
   	try {
   			
        	assertTrue(proveedorDao.listar().size()>0);
    	} catch (Exception e) {
        	e.printStackTrace();
        	fail("Ocurrio un error: "+e.getMessage());
    	}
	}
	@org.junit.Test
	public void f_testInsertarEmpty(){
    	System.out.println("insertarEmpty");
        proveedor = new Provider();   
        try{
        	proveedorDao.agregar(proveedor);
        }catch(Exception e){
        	assertTrue(e.getClass()==RollbackException.class);
        }
    }
}
