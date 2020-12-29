package testProgetto;

import com.esame.Progetto_POO.model.Domain;
import com.esame.Progetto_POO.service.Stats;

import java.util.Vector;
import junit.framework.*;

public class StatsTest extends TestCase {
	
	private Stats s1;
	private Vector<Domain> d1;
	
	public StatsTest(String name){ super(name); } 
	public static Test suite(){
		TestSuite suite = new TestSuite();
		suite.addTest(new StatsTest("test1"));
		return suite;
	}
	
	public void setUp(){ 
		
		d1=new Vector<Domain>();
		d1.add(new Domain("google.com","2008-01-01T12:43:54.261181", "2020-07-12T12:43:54.261181", "US", false));
		d1.add(new Domain("facebook.org","2010-01-01T12:43:54.261181", "2020-08-02T12:43:54.261181", "IT", false));
		d1.add(new Domain("youtube.it","2015-01-01T12:43:54.261181", "2005-01-02T12:43:54.261181", "FR", true));
		d1.add(new Domain("yahoo.com","2012-01-01T12:43:54.261181", "2020-04-02T12:43:54.261181", "IT", true));
		d1.add(new Domain("yahoo.com",null, "2020-04-02T12:43:54.261181", null,true));
		s1 = new Stats(d1);
		
	}
	
	public void tearDown(){}
	
	public void test1(){ 
		System.out.println(s1.toString());
		assertEquals(s1.quantity(),5);
		assertEquals(s1.quantityOfAlive(),2);
	}
	
	
	
}
