package test;
import static org.junit.Assert.*;

import java.util.List;

import org.junit.*;
import org.junit.runners.MethodSorters;
import dao.Dao;
import model.Product;
import model.Provider;
import model.Category;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProductoDaoTest {

	public Dao<Product> productoDao = new Dao<>(Product.class);
	public static Product producto;
	
	Dao<Provider> proveedorDao = new Dao<>(Provider.class);
	List<model.Provider> proveedores = proveedorDao.listar();
	
	Dao<Category> categoriaDao = new Dao<>(Category.class);
	List<Category> categorias = categoriaDao.listar();
	
	public ProductoDaoTest() {
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
        	producto = new Product();
        	producto.setDescription("Hot dog");
        	producto.setMount(15);
        	producto.setCategory(categorias.get(1));
        	producto.setProvider(proveedores.get(1));
        	productoDao.agregar(producto);
        	
        	assertTrue(producto.getIdProduct()>0);
    	} catch (Exception e) {
        	e.printStackTrace();
        	fail("Ocurrio un error "+ e.getMessage());
    	}
	}


	@org.junit.Test
	public void b_testActualizar() throws Exception {
    	System.out.println("actualizar");
    	try {
        	producto.setDescription("Leche");
         	productoDao.actualizar(producto);
        	assertTrue(producto.getDescription().equals("Leche"));
    	} catch (Exception e) {
        	e.printStackTrace();
        	fail("Ocurrio un error "+ e.getMessage());
    	}
	}

	@org.junit.Test
	public void c_testEliminar() throws Exception {
    	System.out.println("eliminar");
    	try {
        	productoDao.eliminar(producto.getIdProduct());
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
        	Product productoBuscado = productoDao.Buscar(1);
        	assertNotNull(productoBuscado);
    	} catch (Exception e) {
        	e.printStackTrace();
        	fail("Ocurrio un error: "+e.getMessage());
    	}
	}

	
	@org.junit.Test
	public void e_testListar() throws Exception {
    	System.out.println("listar");
   	try {
   			
        	assertTrue(productoDao.listar().size()>0);
    	} catch (Exception e) {
        	e.printStackTrace();
        	fail("Ocurrio un error: "+e.getMessage());
    	}
	}
	
	
}
