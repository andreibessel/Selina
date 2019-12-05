package Testproject ;



import com.opencsv.exceptions.CsvValidationException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

@Test()
public class runTest extends Base {
   // dataProvider = "getData"
    //Objects
    public By data1=By.id("id-name-here");

   // String description,String username,String password

        public void HomePage() throws IOException, InterruptedException, CsvValidationException {

            By searchbox=By.cssSelector("div[class='Select-control']");
            By optionNumberTwo=By.cssSelector("div[id='react-select-2--option-2']");
            By dateBoxOne=By.xpath("//div[@class='sc-elJkPf jMrnPy input sc-dNLxif gfikIx'][1]");
           By currentDate=By.cssSelector("td[class*='today']");
            By january=By.cssSelector("td[aria-label*='January']");
          By searchboxTwo=By.cssSelector("label[for='checkOut-9']");
            By icreaseAdult=By.cssSelector("button[aria-label*='increase']");
            By confirmButton=By.xpath("//button[@class='sc-btzYZH eJpoVB sc-EHOje gEZJMM']");





      driver=initializeDriver();
System.out.println("Acces to URL--"+prop.getProperty("url"));
       driver.get(prop.getProperty("url"));

        System.out.println("Acces to Title--"+driver.getTitle());
            Assert.assertTrue(!driver.getTitle().isEmpty());

WebElement search1= (WebElement) driver.findElement(searchbox);
search1.click();
//send keys action
           Actions  Builder =new Actions(driver);
           String searchFor =csvdata();
           Action sendkeysaction = Builder.sendKeys(searchFor)
                   .build();
            sendkeysaction.perform();

            driver.findElement(optionNumberTwo).click();
//date box
WebElement date=driver.findElement(dateBoxOne);
            date.click();

         //  random dateselector
            System.out.println("Today is--"+driver.findElement(currentDate).getText());

            String randonselect= new randomizer().random();
System.out.println("Random Date selected--"+randonselect);
 List<WebElement> dateselect=driver.findElements(january);
for(int i=0; i<=30;i++)
{
   String daydate=dateselect.get(i).getText();
   if(daydate.contains(randonselect))
   {
       driver.findElements(january).get(i).click();
       break;
   }
}
            //date box2
            WebElement date2=driver.findElement(searchboxTwo);
            date2.click();
            String randomselect2=new randomizer().randomday2();
            System.out.println("Second Random Selected Date--"+randomselect2);
            List<WebElement> dateselect2=driver.findElements(january);
            for(int p=0; p<=30;p++)
            {
                String daydate2=dateselect2.get(p).getText();
                if(daydate2.contains(randomselect2))
                {
                    driver.findElements(january).get(p).click();
                    break;
                }
            }

WebElement gests=driver.findElement(icreaseAdult);
gests.click();
WebElement confirm=driver.findElement(confirmButton);
confirm.click();


    }
/*@DataProvider
    public Object[][] getData()
{
    Object[][] data = new Object[2][3];
    data[0][0] = "description";
    data[0][1] = "username1";
    data[0][2] = "password";
    data[1][0] = "Description";
    data[1][1] = "username2";
    data[1][2] = "password2";
    return data;

}*/


public WebElement data1()
{
    return driver.findElement(data1);
}
@AfterTest
    public void driverquit() throws InterruptedException {

    Thread.sleep(10000);
    driver.quit();

}
}
