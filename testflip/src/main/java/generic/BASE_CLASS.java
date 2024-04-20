package generic;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

//import gen_utilities.DB_data;
//import gen_utilities.Excel_data;
//import gen_utilities.Javautility;
//import gen_utilities.Property_data;
//import gen_utilities.Webdriver_utility;
//import leadwave.pom.repository.Homepage;
//import leadwave.pom.repository.LoginPage;

	public class BASE_CLASS {

		public static WebDriver sdriver;
//		public Excel_data y=new Excel_data();
//		public WebDriver sdriver;

		
//		public DB_data base=new DB_data();
//		public Excel_data excel=new Excel_data();
//		public Javautility javas=new Javautility();
		public Property_data prop=new Property_data();
		public Webdriver_utility web=new Webdriver_utility();
		public WebDriver driver;
//		public Javautility jav=new Javautility();

		
	//@BeforeSuite
//		public void connect_toDB() throws SQLException {
//			base.connection();
//			Reporter.log("connected to db");
//		}
//		@Parameters("browser")
		
		@BeforeClass(alwaysRun = true)
		public void launchbrowser() throws IOException {

			// to fetch the data from property file
//				String browse3=prop.readdatafrompropfile("browser");
			
//	        	String urls=prop.readdatafrompropfile("url");
			
			
			// to pass a value in cmd prompt using maven paramater
			String browse3 = System.getProperty("chrome");
			String URL =System.getProperty("url");
			if(browse3.contains("firefox")) {
				driver=new FirefoxDriver();
				Reporter.log("this is firefox");
			}
			else if(browse3.contains("chrome")) {
				driver=new ChromeDriver();
				Reporter.log("this is chrome");
			}
			else if (browse3.contains("edge")) {
				driver=new EdgeDriver();
				Reporter.log("this is edge");
			}
			
			sdriver=driver;
			web.maximizewin(driver);
			driver.get(URL);
			web.waittillpageload(driver, 20);
//			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
		}
		
//		@BeforeMethod(alwaysRun = true)
//		public void loginintoapp() throws IOException {
//			String username=prop.readdatafrompropfile("username");
//			String pwd=prop.readdatafrompropfile("password");
//			LoginPage lp=new LoginPage(driver);
//			lp.logintoApp(username, pwd);
//			Reporter.log("logged in");
//		}
		
//		@AfterMethod(alwaysRun = true)
//		public void logoutfromapp() throws InterruptedException {
////			Homepage hp=new Homepage(driver);
//			hp.clicksignouts();
//			Reporter.log("logged out");

//		}
		@AfterClass(alwaysRun = true)
		public void closebrowser() {
			driver.quit();
			Reporter.log("browser has been closed");

		}
//		@AfterSuite
//		public void closedb() throws SQLException {
//			base.closecon();
//			Reporter.log("DB is shut down");
//		}
	}

