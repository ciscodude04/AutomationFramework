package Tests;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.AF.ConfigCaller.Propertycaller;
import com.AF.Drivers.Drivers;
import com.AF.webtestBase.webtestBase;

public class DemoTests {
	private webtestBase testing = new webtestBase();
	
	@Before
	public void init() throws IOException{
		Propertycaller data = new Propertycaller();
		Drivers.Initialize(data.getenvironment(), data.getqatestSite());
	}
	
	@After
	public void Cleanup(){
		Drivers.close();
	}
	
	@Test
	public void inputTest(){
		testing.inputtest1();
	}
}
