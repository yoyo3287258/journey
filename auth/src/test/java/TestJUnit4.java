import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/* <p>Copyright@ Journey Platform(2012) All right reserved.</p>
 *	 
 * @author liulinkun
 * <p>Datetime:2012-12-11</p>
 */

public class TestJUnit4 extends TestJUnit4Farther{

	@BeforeClass
	public static void beforeClassChild() {
		System.out.println("beforeClass child");
	}
	
	@AfterClass
	public static void afterClassChild() {
		System.out.println("afterClass child");
	}
	
	@Before
	public void setUp1() {
		System.out.println("before1");
	}
	
	@Test
	public void test1() {
		System.out.println("in test1!");
	}
	
	@After
	public void end1() {
		System.out.println("after1");
	}
	
	@Before
	public void setUp2() {
		System.out.println("before2");
	}
	
	@Test
	public void test2() {
		System.out.println("in test2!");
	}
	
	@After
	public void end2() {
		System.out.println("after2");
	}
}
