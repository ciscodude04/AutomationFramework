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

public class Tests {

	private webtestBase login = new webtestBase();

	@Before
	public void init() throws IOException {
		Propertycaller data = new Propertycaller();
		Drivers.Initialize(data.getenvironment(), data.getedwardsurl());
	}

	@After
	public void Cleanup() throws InterruptedException {
		Drivers.close();
	}


	@Test
	public void Login_to_Existing_Account() {
		login.logintoexistingaccount();
	}
	
	@Test
	public void EdwardSiteTest(){
		login.newedwardstest();
	}
	
	@Test
	public void newtest(){
		//Do something
	}
}
