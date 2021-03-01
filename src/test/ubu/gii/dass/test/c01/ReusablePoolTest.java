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
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link ubu.gii.dass.c01.ReusablePool#acquireReusable()}.
	 */
	@Test
	public void testAcquireReusable() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link ubu.gii.dass.c01.ReusablePool#releaseReusable(ubu.gii.dass.c01.Reusable)}.
	 */
	@Test
	public void testReleaseReusable() {
		fail("Not yet implemented");
	}

}
