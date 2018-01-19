package Tests;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;

import com.AF.ConfigCaller.Propertycaller;
import com.AF.Drivers.Drivers;

import com.AF.RunnerClasses.MyRunner;
import com.AF.webtestBase.webtestBase;


@RunWith(MyRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DemoTests {
	private webtestBase testing = new webtestBase();
	
	@Before
	public void init() throws IOException{
		Propertycaller data = new Propertycaller();
		Drivers.Initialize(data.getenvironment(), data.getapartmentsurl());
	}
	
	@After
	public void Cleanup(){
		Drivers.close();
	}
	
	//@Test
	public void inputTest(){
		testing.inputtest1();
	}
	
	@Test
	public void selectApt(){
		testing.firstapartmenttest();
	}
	
	@Test
	public void menuOptions(){
		testing.secondapartmenttest();
	}
	
	@Test
	public void Add_a_Listing(){
		testing.addalistingtest();
	}
	
}
