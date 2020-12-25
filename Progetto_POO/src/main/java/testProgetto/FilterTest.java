package testProgetto;

import com.esame.Progetto_POO.model.Domain;
import com.esame.Progetto_POO.service.Filter;

import java.util.Vector;
import junit.framework.*;

public class FilterTest extends TestCase{
	
	private Filter f1;
	private Vector<Domain> d1;
	private Vector<Domain> d2;
	
	public FilterTest(String name){ super(name); } 
	public static Test suite(){
		TestSuite suite = new TestSuite();
		suite.addTest(new FilterTest("testFiltri1"));
		return suite;
	}
	
	public void setUp(){ 
		
		d1=new Vector<Domain>();
		d2=new Vector<Domain>();
		d1.add(new Domain("google.com","2008-01-01T12:43:54.261181", "2020-07-12T12:43:54.261181", "US", false));
		d1.add(new Domain("facebook.org","2010-01-01T12:43:54.261181", "2020-08-02T12:43:54.261181", "IT", false));
		d1.add(new Domain("youtube.it","2015-01-01T12:43:54.261181", "2005-01-02T12:43:54.261181", "FR", true));
		d1.add(new Domain("yahoo.com","2012-01-01T12:43:54.261181", "2020-04-02T12:43:54.261181", "IT", true));
		f1 = new Filter(d1);
		f1 = new Filter(f1.filterByAlive(false));
		f1 = new Filter(f1.filterByNations("IT"));
		f1 = new Filter(f1.filterByType("com"));
		d2.add(new Domain("yahoo.com","2012-01-01T12:43:54.261181", "2020-04-02T12:43:54.261181", "IT", true));
		
	}
	
	public void tearDown(){}
	
	public void testFiltri1(){ 
		System.out.println(f1.getDomains().toString());
		System.out.println(d2.toString());
		assertEquals(f1.getDomains().toString(), d2.toString());
	}
	
	
	
}
