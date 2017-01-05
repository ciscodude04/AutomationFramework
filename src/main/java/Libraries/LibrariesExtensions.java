package Libraries;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import org.apache.commons.lang3.RandomStringUtils;
//import org.apache.commons.validator.UrlValidator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.AF.ConfigCaller.Propertycaller;

public class LibrariesExtensions extends WebDriverLibrary {

	public static int getRandomInt(int min, int max) {
		Random random = new Random();
		int randomNum = random.nextInt((max - min) + 2) + min;
		return randomNum;
	}

	public static void datacollection(String container, String child, String elementtoclick) {
		try {
			Propertycaller data = new Propertycaller();
			WebElement elementcontainer = driver().findElement(By.cssSelector(container));
			List<WebElement> dataelements = elementcontainer.findElements(By.cssSelector(child));
			int datasize = dataelements.size();
			//System.out.println(datasize);
			String[] elements = new String[dataelements.size()];
			int j = 0;
			for(WebElement e : dataelements){
				elements[j] = e.getText();
				//System.out.println(e.getText());
				if(elements[j].contains(elementtoclick.toUpperCase())){
					e.click();
					break;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void datacollectionLower(String container, String child, String elementtoclick) {
		try {
			Propertycaller data = new Propertycaller();
			WebElement elementcontainer = driver().findElement(By.cssSelector(container));
			List<WebElement> dataelements = elementcontainer.findElements(By.cssSelector(child));
			int datasize = dataelements.size();
			String[] elements = new String[dataelements.size()];
			int j = 0;
			for(WebElement e : dataelements){
				elements[j] = e.getText();
				System.out.println(e.getText());
				if(elements[j].contains(elementtoclick)){
					e.click();
					break;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void randomdatacollection(String container, String child) {
		try {
			Propertycaller data = new Propertycaller();
			WebElement elementcontainer = driver().findElement(By.cssSelector(container));
			List<WebElement> dataelements = elementcontainer.findElements(By.cssSelector(child));
			int datasize = dataelements.size();
			String[] elements = new String[dataelements.size()];
			int j = 0;
			int  k = getRandomInt(j,  elements.length);
			for(WebElement e : dataelements){
				elements[k] = e.getText();
				//System.out.println(e.getText());
					e.click();
					break;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void lendercollection(String container, String child, String appStatus) throws IOException {
		Propertycaller data = new Propertycaller();
		WebElement containerS = driver().findElement(By.cssSelector(container));
		List<WebElement> allheaders = containerS.findElements(By.cssSelector(child));
		int lenders = allheaders.size();
		System.out.println(lenders + " lender(s) on lender panel detected");
		String[] links = new String[allheaders.size()];
		int j = 0;
		for (WebElement e : allheaders) {
			links[j] = e.getText();
			System.out.println("Lender: " + links[j].toString());
			if (links[j].contains("Road Loans")) {
				PostResponse.roadloansPost(data.getroadloansendpoint(), data.getroadloansrequest());
			} else if (links[j].contains("Mercedes-Benz Financial Services")) {
				PostResponse.postResponse(data.CurrentIntegrationServers() + data.simulatecreditresponseendpoint(),
						data.getmbfspostRequest(), appStatus);
			} else if (links[j].contains("Westlake")) {
				System.out.println("Will do something here with Westlake");
				LibrariesExtensions.writetoRecorder("WestLake: Approved");
			} else if (links[j].contains("LightStream")) {
				System.out.println("Will do something here as well with LighsStream");
				LibrariesExtensions.writetoRecorder("Lightstream: Approved");
			} else if (links[j].contains("First Investors Financial Services")) {
				PostResponse.firstInvestorsResponse(data.getrouteonedecisionendpoint(),data.getfirstinvestorsdecision(), appStatus);
				LibrariesExtensions.writetoRecorder("First Investors Financial Services: Approved");
				//System.out.println("Will do something here SOOON!");
			} else if (links[j].contains("Will there be another Lender?")) {
				System.out.println("Do something here to sim app");
			}
			j++;
		}
	}

	public static void gatheralldata(String queue) throws IOException {
		Propertycaller data = new Propertycaller();
		WebElement IDcontainer = driver().findElement(By.cssSelector(data.getidcontainer()));
		List<WebElement> ids = IDcontainer.findElements(By.cssSelector(data.getlinkcss()));
		int numberofmessages = ids.size();
		System.out.println(numberofmessages + " Messages---------\n");
		String[] linkrefs = new String[ids.size()];
		int j = 0;
		for (WebElement e : ids) {
			linkrefs[j] = e.getAttribute("href");
			j++;
		}
		int k = 0;
		for (String t : linkrefs) {
			// System.out.println("Link #: " + (k++));
			driver().navigate().to(t);
			String priority = getinnertextXpath(data.getpriority());// Priority
			String mqTimestamp = getinnertextXpath(data.gettimestamp());// Timestamp
			String type = getinnertextXpath(data.getType()); // Type
			String message = getinnertextclassName(data.getmessage());// Message
			if (message.isEmpty()) {
				recordactiveMQ(queue, "No data present", "", "", "", (k));
			} else
				recordactiveMQ(queue, message, mqTimestamp, priority, type, (k));
		}
	}

	public static String catchthestatus(String queue, int column) {
		String pendingMessages = getinnertextXpath("//*[@id=\"queues\"]/tbody/tr[" + column + "]/td[2]");
		String consumers = getinnertextXpath("//*[@id=\"queues\"]/tbody/tr[" + column + "]/td[3]");
		String mequeued = getinnertextXpath("//*[@id=\"queues\"]/tbody/tr[" + column + "]/td[4]");
		String medqueued = getinnertextXpath("//*[@id=\"queues\"]/tbody/tr[" + column + "]/td[5]");
		String datafields = getinnertextXpath("Pending Messages:" + pendingMessages + "   Consumers: " + consumers
				+ "   Messages queued: " + mequeued + "   Messages Dequeued: " + medqueued);
		System.out.println("Pending Messages:" + pendingMessages + "   Consumers: " + consumers + "   Messages queued: "
				+ mequeued + "   Messages Dequeued: " + medqueued);
		recordactiveMQ(queue, datafields);
		return datafields;
	}

	public static void verifyserviceorder(String service) {
		for (int i = 1; i < 17; i++) {
			String xpath = "//*[@id='queues']/tbody/tr[" + i + "]/td[1]/a";
			String currentservice = getinnertextXpath(xpath);
			if (currentservice.contains(service)) {
				System.out.println("Current service: " + i + " :" + currentservice);
				catchthestatus(service, i);
				clickbyxpath(xpath);
			}
			if (!iselementPresent(By.xpath(xpath))) {
				break;
			}

		}
	}

	public static void WritetoFile(String Email, String env) {
		try {
			String content = Email + " / " + Timestamp();
			File file = new File("src/main/resources/CreatedAccounts" + env + ".txt");
			if (!file.exists()) {
				try {
					file.createNewFile();
				} catch (IOException e) {
					System.out.println("Created new file...");
				}
			}
			FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(content);
			bw.newLine();
			bw.flush();
			bw.close();

		} catch (IOException e) {
			System.out.println("COULD NOT LOG TO FILE");
		}
	}

	public static void writebuildVersion(String data) {
		try {
			Propertycaller env = new Propertycaller();

			String content = "Build Version: " + data + " / " + Timestamp() + "\n";
			File file = new File("src/main/resources/BuildVersion_" + env.getenvironment() + ".txt");
			if (!file.exists()) {
				try {
					file.createNewFile();
				} catch (IOException e) {
					System.out.println("Created new file...");
				}
			}
			FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(content);
			bw.newLine();
			bw.flush();
			bw.close();

		} catch (IOException e) {
			System.out.println("COULD NOT LOG TO FILE");
		}
	}

	public static void writetoRecorder(String data) {
		try {
			Propertycaller env = new Propertycaller();

			String content = data;
			File file = new File("src/main/resources/ApplicationData_" + env.getenvironment() + ".txt");
			if (!file.exists()) {
				try {
					file.createNewFile();
				} catch (IOException e) {
					System.out.println("Created new file...");
				}
			}
			FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(content);
			bw.newLine();
			bw.flush();
			bw.close();

		} catch (IOException e) {
			System.out.println("COULD NOT LOG TO FILE");
		}
	}

	public static void recordactiveMQ(String textfile, String message, String timestamp, String priority, String type,
			int messages) {
		try {
			String content = "ID #: " + messages + "\nTimestamp: " + timestamp + "\n " + "Message: " + message + "\n"
					+ "Priority: " + priority + "\n" + "Type: " + type + "\n ----------End Session---------------\n";
			File file = new File("src/main/resources/" + textfile + ".txt");
			if (!file.exists()) {
				try {
					file.createNewFile();
				} catch (IOException e) {
					System.out.println("Created new file...");
				}
			}
			FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(content);
			bw.newLine();
			bw.flush();
			bw.close();

		} catch (IOException e) {
			System.out.println("COULD NOT LOG TO FILE");
		}
	}

	public static void recordactiveMQ(String textfile, String datafields) {

		try {
			String content = "New Test\n" + Timestamp() + "\n" + datafields;

			File file = new File("src/main/resources/" + textfile + ".txt");
			if (!file.exists()) {
				try {
					file.createNewFile();
				} catch (IOException e) {
					System.out.println("Created new file...");
				}
			}
			FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(content);
			bw.newLine();
			bw.flush();
			bw.close();

		} catch (IOException e) {
			System.out.println("COULD NOT LOG TO FILE");
		}
	}

	public static String getRandomString(int Length, boolean numbers, boolean chars) {
		String randomstring = RandomStringUtils.random(Length, numbers, chars);
		return randomstring;
	}

	public static int randomnumberGenerator(int min, int max) {
		if (min > max) {
			throw new IllegalArgumentException("Max must be greater than min");
		}
		Random r = new Random();
		return r.nextInt(max - min + 1) + min;
	}

	public static double doublerandomnumberGenerator(double min, double max) {
		if (min > max) {
			throw new IllegalArgumentException("Max must be greater than min");
		}
		Random r = new Random();
		return r.nextInt((int) (max - min + 1)) + min;
	}

	public static String randInt(int min, int max) {
		if (min > max) {
			throw new IllegalArgumentException("Max must be greater than min");
		}
		Random rand = new Random();
		int randomNum = rand.nextInt((max - min) + 1) + min;
		String b = Integer.toString(randomNum);
		return b;
	}

	static String shuffleArray(String[] myarray) {
		Random rnd = ThreadLocalRandom.current();
		for (int i = myarray.length - 1; i > 0; i--) {
			int index = rnd.nextInt(i + 1);
			String a = myarray[index];
			myarray[index] = myarray[i];
			myarray[i] = a;
		}
		return null;
	}

	public String randomDealership() {
		String Myarray[] = { "Mazda of", "Honda of", "Ford of", "Fletcher Jones", "Acura of", "BMW of", "Buick of",
				"Aston Martin of", "Audi of", "Cadillac of", "Chevrolet of", "Chrysler of", "Dodge of", "FIAT of",
				"GMC of", "Hyundai of", "Infinity of", "Jaguar of", "Jeep of", "Kia of", "Lamborghini of",
				"Land Rover of", "Lexus of", "Lincoln of", "Maserati of", "Mercedes-Benz of" };
		Random random = new Random();
		int index = random.nextInt(Myarray.length);
		String randindex = (Myarray[index]);
		LibrariesExtensions.writetoRecorder(randindex);
		return randindex;
	}
	
	public static String replaceVehicle(String vehicle, String vehiclename){
		String newvehicle = vehicle.replace("<vehicle>", vehiclename);
		return newvehicle;
	}

	public static String randomMake(String Make) {
		String myMakes[] = { "Acura", /*"Alfa Romeo"*/ "Aston Martin", "Audi", /*"Bentley",*/ "BMW", "Buick", "Cadillac",
				"Chevrolet", "Chrysler", "Dodge", "Ferrari", "FIAT", "Ford", "Genesis", "GMC", "Honda", "Hyundai",
				"Jaguar", "Jeep", "Kia", /*"Lamborghini",*/ "Land Rover", "Lexus", "Lincoln", /*"Maserati"*/ "Mazda",
				"McLaren", "Mercedes-Benz", "MINI", "Mitsubishi", "Nissan", "Porsche", "Ram", "Rolls-Royce", "Scion",
				"Smart", "Subaru", "Tesla", "Toyota", "Volkswagen", "Volvo" };
		Random random = new Random();
		int index = random.nextInt(myMakes.length);
		String randindex = (myMakes[index]);
		System.out.println("The Make: " + randindex);
		String randomMake = Make.replace("<Make>", randindex);
		LibrariesExtensions.writetoRecorder("\n------------------------NEW APP SUBMISSION-------------------------");
		LibrariesExtensions.writetoRecorder("MAKE: " + randindex);
		return randindex;
	}
	
	public static String randomMercedesModel(){
		String myModel[] = {"New Mercedes-Benz AMG GT", "New Mercedes-Benz CLA","New Mercedes-Benz GL Class", "New Mercedes Benz B-Class", "New Mercedes Benz AMG GT", "New Mercedes-Benz CLA", "New Mercedes-Benz CLS", "New Mercedes-Benz E-Class", "New Mercedes-Benz G-Class", "New Mercedes-Benz GLA" };
		Random random = new Random();
		int index = random.nextInt(myModel.length);
		String randindex = (myModel[index]);
		//String randomMake = Make.replace("<Make>", randindex);
		LibrariesExtensions.writetoRecorder("\n------------------------NEW APP SUBMISSION-------------------------");
		LibrariesExtensions.writetoRecorder("MAKE: " + randindex);
		return randindex;
	}

	public static String selectState(String stateElement, String whichState) {
		String newstate = stateElement.replace("<state>", whichState);
		// LibrariesExtensions.writetoRecorder("STATE: " + whichState);
		return newstate;
	}

	public static String selectrentOption(String rentElement, String whichOption) {
		String newrentElement = rentElement.replace("<rentOption>", whichOption);
		return newrentElement;
	}

	public static String jobStatus(String element) {
		String jobStatus[] = { "Full Time", "Self Employed", "Unemployed" };
		Random random = new Random();
		int index = random.nextInt(jobStatus.length);
		String finalStatus = (jobStatus[index]);
		String randomStatus = element.replace("<jobStatus>", finalStatus);
		return randomStatus;

	}

	public static String specificMake(String selector, String make) {
		String myMake = make;
		//String randomMake = selector.replace("<Make>", myMake);
		LibrariesExtensions.writetoRecorder("\n----------------------NEW APP SUBMISSION-------------------------");
		LibrariesExtensions.writetoRecorder("MAKE: " + myMake);
		return myMake;
	}

	public static String randomModel(String Model) {
		int randomNum = 3;// TODO: Need to come up with something better
							// getRandomInt(1, 8);
		String modelNumber = convertinttoString(randomNum);
		String randomModel = Model.replace("<Model>", modelNumber);
		return randomModel;
	}

	public static String randomYear(String Year) {
		// String myYear[] = { "2015", "2016", "2017" };
		String myYear = "2016";
		Random random = new Random();
		// int index = random.nextInt(myYear.length);
		// String randindex = (myYear[index]);
		String randomYear = Year.replace("<Year>", myYear);
		// LibrariesExtensions.writetoRecorder("YEAR: " + myYear);
		return randomYear;
	}

	public static String randomoutsideCity() {
		String myStates[] = { "Washington, DC", "Las Vegas, Nevada", "Miami, FL", "Salt Lake City, Utah", "New York",
				"Boston, MA", "Chicago, Ill", "Houston, TX", "Austin, TX" };
		Random random = new Random();
		int index = random.nextInt(myStates.length);
		String randindex = (myStates[index]);
		return randindex;
	}

	public static String randomcaliforniaCity() {
		String mycaliforniaCities[] = { "Los Angeles, CA", "San Francisco, CA", "Irvine, CA", "San Jose, CA",
				"San Diego, CA", "Sacramento, CA", "Long Beach, CA" };
		Random random = new Random();
		int index = random.nextInt(mycaliforniaCities.length);
		String randindex = (mycaliforniaCities[index]);
		return randindex;
	}

	public static boolean numbervalidator(String phoneNo, int columnIndex, int row) {
		String phoneNumberPattern = "^\\(?([0-9]{3})\\)?[-.\\s]?([0-9]{3})[-.\\s]?([0-9]{4})$";
		if (phoneNo.matches(phoneNumberPattern)) {
			// System.out.println( phoneNo + " good " +
			// phoneNo.matches(phoneNumberPattern));
			return true;
		} else {
			// System.out.println( phoneNo + " is " +
			// phoneNo.matches(phoneNumberPattern) + "<<<Pattern test");
			String comment = phoneNo + " is " + phoneNo.matches(phoneNumberPattern);
			// writeResults(columnIndex, row, false, phoneNo, comment);
			return false;
		}
	}

	public static void uppercaseVerification(String text) {
		String[] array = text.split("\\ ");
		// System.out.println(Arrays.toString(array));
		String regex = "[0-9]";
		for (String s : array) {

			if (s.isEmpty()) {
				System.out.println(text + " Invalid Whitespace");
			} else if (Character.isUpperCase(s.charAt(0))) {
				// System.out.println(s + "---" + s.charAt(0) + "------Pass");
			} else if (s.matches(regex)) {
				continue;
			} else {
				System.out.println(text + " \n" + s + "---" + s.charAt(0) + " ----Fail");
			}
		}
	}

	public static boolean isValidEmailAddress(String Email, int column, int cell) {
		String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
				+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
		java.util.regex.Pattern p = java.util.regex.Pattern.compile(EMAIL_PATTERN);
		java.util.regex.Matcher m = p.matcher(Email);
		if (m.matches() == false) {
			System.out.println(Email + "      <-- Invalid Email format. Cell " + column + ", " + cell);
			return false;
		} else
			System.out.println(Email + " <--" + m.matches() + " format.");
		return m.matches();
	}

	// public static boolean verifyUrl(String url, int column, int cell) {
	// if (url.contains("https")) {
	// System.out.println(url + " is invalid " + "cell " + column + ", " +
	// cell);
	// return false;
	// }
	// UrlValidator urlValidator = new UrlValidator();
	// return urlValidator.isValid(url);
	// }

	public static void checkfirstcharisuppercase(String character) {
		Character.isUpperCase(character.charAt(0));
	}

	public static void consecutivecharszipcodetest(String str, int column, int cell, int maxCount) {
		// zip code test
		// Credit goes to method on
		// http://stackoverflow.com/questions/19579568/most-repeating-character-in-a-string
		// System.out.println("DID YOU GET IN HERE!!");
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		char[] array = str.toCharArray();
		String regex = "^[0-9]{5}$";
		char maxChar = array[0];
		for (int i = 0, j = 0; i < str.length() - 1; i = j) {
			int count = 1;
			while (++j < str.length() && array[i] == array[j]) {
				count++;
			}
			if (count > maxCount) {
				maxCount = count;
				maxChar = array[i];
				System.out.println(maxChar + " = " + maxCount + " on " + str);
			}
			// else if(count >= maxCount){
			// if(!str.matches(regex)){
			// System.out.println(str + "zip code validation failed");
			// }
			// WritetoFile(column, array[i]);
			// System.out.println("Email validation failed on " + str + " on
			// letter " + "'" + array[i]+"' " + maxCount + " times. On cell " +
			// column + ", " + cell);
		}

	}

	public static boolean testurlConnection(String url) {
		InputStream responseInputStream = null;
		if (url.isEmpty()) {
			System.out.println("Missing URL!!");
		} else if (url.startsWith("www")) {
			System.out.println("Url needs to start with 'https' with " + url + "\n");

		} else if (!url.startsWith("www")) {
			System.out.println("Url needs to start with 'https' with " + url + "\n");
		}
		// try {
		// URL newurl = new URL(url);
		// HttpURLConnection urlConn = (HttpURLConnection)
		// newurl.openConnection();
		// urlConn.connect();
		// urlConn.getResponseCode();
		// int responsecode = urlConn.getResponseCode();
		// if (responsecode == 200) {
		// System.out.println(url + "--, response code: " + responsecode);
		// responseInputStream = urlConn.getInputStream();
		// urlConn.disconnect();
		// return true;
		// } else if (responsecode >= 200) {
		// responseInputStream = urlConn.getErrorStream();
		// }
		// } catch (IOException e) {
		// System.out.println("Error: Malformed Exception with " + url + "\n");
		//
		// } finally {
		// if (responseInputStream != null) {
		// try {
		// responseInputStream.close();
		// } catch (IOException e) {
		// e.printStackTrace();
		// }
		// }

		// }

		return false;
	}

	public static String convertinttoString(int value) {
		String newvalue = Integer.toString(value);
		return newvalue;
	}

	public static int convertstringtoInt(String value) {
		int newvalue = Integer.parseInt(value);
		return newvalue;
	}

	public static double tothepowerof(double x, double power) {
		double pow = Math.pow(x, power);
		return pow;
	}

	public static String convertdoubletoString(double value) {
		String newvalue = Double.toString(value);
		return newvalue;
	}

}
