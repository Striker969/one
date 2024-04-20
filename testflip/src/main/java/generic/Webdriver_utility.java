package generic;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

//import gen_utilities.Javautility;

public class Webdriver_utility {

		public void maximizewin(WebDriver driver) {
			driver.manage().window().maximize();
		}
		public void minimizewin(WebDriver driver) {
			driver.manage().window().minimize();
		}
		public void waittillpageload(WebDriver driver,int sec) {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(sec));
		}
		public void launchbrowser(WebDriver driver,String url) {
			driver.get(url);
		}
		
		
		//explicitwait
		public WebDriverWait webdriverwaitobj(WebDriver driver,int sec) {
			WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(sec));
			return wait;
		}
		public void wait_tillvisibilityof(WebDriver driver,int sec,WebElement element) {
			webdriverwaitobj(driver, sec).until(ExpectedConditions.visibilityOf(element));
		}
		public void wait_tilleletobeclickable(WebDriver driver,int sec, WebElement element) {
			webdriverwaitobj(driver, sec).until(ExpectedConditions.elementToBeClickable(element));
		}
		public void wait_tillyougettitle(WebDriver driver,int sec, String title) {
			webdriverwaitobj(driver, sec).until(ExpectedConditions.titleContains(title));
		}
		
		
		//dropdown
		public Select dropdown(WebElement element) {
			Select sel=new Select(element);
			return sel;
		}
		public void forvisibletext(WebElement element,String text) {
			dropdown(element).selectByVisibleText(text);
		}
		public void forvalue(String text,WebElement element) {
			dropdown(element).selectByValue(text);
		}
		public void forIndex(int ind,WebElement element) {
			dropdown(element).selectByIndex(ind);
		}
		
		
		//actions
		public Actions todoactions(WebDriver driver) {
			Actions act=new Actions(driver);
			return act;
		}
		public void tomousehover(WebDriver driver, WebElement element) {
			todoactions(driver).moveToElement(element).perform();
		}
		public void todoubletap(WebDriver driver, WebElement element) {
			todoactions(driver).doubleClick(element).perform();
		}
		public void todragand_drop(WebDriver driver, WebElement src, WebElement dst) {
			todoactions(driver).dragAndDrop(src,dst).perform();
		}
		public void torightclick(WebDriver driver, WebElement element) {
			todoactions(driver).contextClick(element).perform();
		}
		public void tosendthedata(WebDriver driver, WebElement element, String keys) {
			todoactions(driver).sendKeys(element, keys).perform();
		}
		
		
//		robotclass
		public void robotpress() throws AWTException {
			Robot ro=new Robot();
			ro.keyPress(KeyEvent.VK_ENTER);
		}
		public void robotrelease() throws AWTException {
			Robot ro=new Robot();
			ro.keyRelease(KeyEvent.VK_ENTER);
		}
		
		
		//alert
		public void acceptalert(WebDriver driver) {
			driver.switchTo().alert().accept();
		}
		public void dismissalert(WebDriver driver) {
			driver.switchTo().alert().dismiss();
		}
		
		
		//switch to window
		public void switchtowindow(WebDriver driver, String expwindow) {
			Set<String> str=driver.getWindowHandles();
			Iterator<String> it=str.iterator();
			while(it.hasNext()) {
				String win=it.next();
				String currenttitle=driver.switchTo().window(win).getTitle();
				if(currenttitle.contains(expwindow)) {
					break;
				}
			}
		}
		
		
		//frame
		public void handleframewithindex(WebDriver driver,int index) {
			driver.switchTo().frame(index);
		}
		public void handleframewithnameorid(WebDriver driver,int nameorid) {
			driver.switchTo().frame(nameorid);
		}
		
		
		//screenshot
//		public static String getscreenshot(WebDriver driver, String screenshotname) throws IOException {
//			TakesScreenshot take=(TakesScreenshot)driver;
//			Javautility jutil=new Javautility();
			
//			java.io.File src=take.getScreenshotAs(OutputType.FILE);
//			String path ="./Screenshot/"+screenshotname+jutil.getsysdateformat()+".png";
//			java.io.File dest=new java.io.File(path);
//			String srcpath=dest.getAbsolutePath();
//			FileUtils.copyFile(src, dest);
//			return srcpath;
//		}
		
		
		//javascriptexecutor
		public JavascriptExecutor jsexecutor(WebDriver driver) {
			JavascriptExecutor js=(JavascriptExecutor)driver;
			return js;
		}
		public void launchusingjs(WebDriver driver,String url) {
			jsexecutor(driver).executeScript("window.location=arguments[0]",url);
		}
		public void gototop(WebDriver driver) {
			jsexecutor(driver).executeScript("window.scrollBy(0,-document.body.scrollHeight)");
		}
		public void gotobottom(WebDriver driver) {
			jsexecutor(driver).executeScript("window.scrollBy(0,document.body.scrollHeight)");
		}
		public void scrolltillelement(WebDriver driver,WebElement element) {
			jsexecutor(driver).executeScript("arguments[0].scrollIntoView()",element);
		}
		public void clickusingjs(WebDriver driver,WebElement ele) {
			jsexecutor(driver).executeScript("arguments[0].click()",ele);
		}
		public void sendkeysusingjs(WebDriver driver,WebElement ele, String pass) {
			jsexecutor(driver).executeScript("arguments[0].value=argument[1]",ele,pass);
		}
		public void scrolltillpixel(WebDriver driver) {
			jsexecutor(driver).executeScript("window.scrollBy(0,800)");
		}
		public void scrolltillelement2(WebDriver driver, WebElement ele) {
			int x=ele.getLocation().getX();
			int y=ele.getLocation().getY();
			jsexecutor(driver).executeScript("window.scrollBy("+x+","+y+")");
		}
	}

