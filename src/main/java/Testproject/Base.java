package Testproject;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Base {


    public  WebDriver driver;
public Properties prop;
    public WebDriver initializeDriver() throws IOException {

        Properties prop=new Properties();

        FileInputStream fis= new FileInputStream("C:\\Users\\User\\Projects\\Work\\src\\main\\java\\Testproject\\prop.properties");
        prop.load(fis);
        this.prop=prop;
        String browser=prop.getProperty("browser");



        System.out.println(browser);
        if(browser.equals("Chrome"))
        {
            System.setProperty("webdriver.chrome.driver","C:\\Users\\User\\Projects\\Work\\chromedriver.exe");
                    WebDriver driver=new ChromeDriver();
this.driver=driver;
        }
        else
        {
            System.out.println("properties not working");
        }


        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

        return driver;


    }
    public  String name;
public String csvdata() throws IOException, CsvValidationException {

        String CSV_File="C:\\Users\\User\\Projects\\Work\\TestData.csv";
    CSVReader reader=new CSVReader(new FileReader(CSV_File));
    String[] cell;

    while((cell =reader.readNext())!=null)
    {
        for(int i=0;i<cell.length;i++)
        {
            String name=cell[i];
            this.name=name;
        }
    }

    return name;


}

}


