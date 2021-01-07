package testProgetto;

import com.esame.Progetto_POO.exception.NoResultException;
import com.esame.Progetto_POO.model.Domain;
import com.esame.Progetto_POO.service.Stats;
import com.esame.Progetto_POO.util.ParserJSON;
import com.esame.Progetto_POO.util.ReaderJSON;

import java.util.Vector;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

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
		
		System.out.println(Method1("game"));
	}
	private static final String searchURL="https://api.domainsdb.info/v1/domains/search?domain=";

	//@GetMapping("/{cognome}/stats")
	//(@RequestParam(name = "name", defaultValue = "World") String nome)
	public  String Method1(String cognome) {
		System.out.println(searchURL+cognome);
		Stats stats;
		try{
			stats= new Stats(ParserJSON.parseTo(ReaderJSON.readFromURL(searchURL+cognome)));
		}catch(NoResultException e) {
			e.printStackTrace();
			return "NO DOMAIN";
		}
		return stats.viewStats();
	}
	
	
}
