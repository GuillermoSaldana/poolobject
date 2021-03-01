/**
 * 
 */
package ubu.gii.dass.test.c01;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Guillermo Saldaña Suárez
 * @author Jesus González Alonso
 */
public class ReusablePoolTest {

	ReusablePool pool, pool2;
	Reusable r1,r2, aux;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		//Inicializamos nuestro objeto de tipo ReusablePool.
		pool = ReusablePool.getInstance();
		
		//Inicializamos nuestros objetos de tipo Reusable.
	    r1 = pool.acquireReusable();
	    r2 = pool.acquireReusable();
	    
	    pool.releaseReusable(r1);
	    pool.releaseReusable(r2);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		pool = null;
		r1 = null;
		r2 = null;
		aux = null;
	}

	/**
	 * Test method for {@link ubu.gii.dass.c01.ReusablePool#getInstance()}.
	 */
	@Test
	public void testGetInstance() {
		// Comprobamos que la instancia de pool2 no ha sido incializada y que por lo
		// tanto es null.
		assertNull(pool2);

		// Comprobamos que la instancia de pool ha sido incializada y que por lo tanto
		// es DISTINTO de null.
		assertNotNull(pool);
	}

	/**
	 * Test method for {@link ubu.gii.dass.c01.ReusablePool#acquireReusable()}.
	 */
	@Test
	public void testAcquireReusable() {
		//Extraemos r2 ya que es el ultimo objeto añadido a pool.
		try {
			assertEquals(r2, pool.acquireReusable());
		} catch (NotFreeInstanceException e) {
			e.printStackTrace();
		}
		
		/* Utilizamos la variable auxiliar aux para comprobar con el método util(), que el elemento extraido de pool
		sea igual que r1.*/
		try {
			aux = pool.acquireReusable();
			assertEquals(r1.util(), aux.util());
		} catch (NotFreeInstanceException e) {
			e.printStackTrace();
		}
		
		
		// Salta la excepción al no qeudar objetos tipo Reusable libres.
		try {
			pool.acquireReusable();
		} catch (NotFreeInstanceException ex) {
			assertTrue(true);
			try {
				pool.releaseReusable(r1);
				pool.releaseReusable(r2);
			} catch (DuplicatedInstanceException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Test method for {@link ubu.gii.dass.c01.ReusablePool#releaseReusable(ubu.gii.dass.c01.Reusable)}.
	 */
	@Test
	public void testReleaseReusable() {
		// Al añadir r1 salta la excepción porque ya existe esta en nuestro objeto pool.
		try {
			pool.releaseReusable(r1);
		}catch (DuplicatedInstanceException ex) {
			assertTrue(true);
		}
		
		//Retiramos el último objeto de tipo Reusable de pool.  
		try {
			assertEquals(r2, pool.acquireReusable());
		} catch (NotFreeInstanceException e) {
			e.printStackTrace();
		}
		
		//Añadimos r2 el cual lo habíamos extraido anteriormente.
		try {
			pool.releaseReusable(r2);
			assertTrue(true);
		}catch (DuplicatedInstanceException e) {
			e.printStackTrace();
		}
	}

}
