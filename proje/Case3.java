package proje;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static proje.BaseDriverr.BaseDriver.driver;






    public class Case3 extends BaseDriverr {
        @Test
        public void Case3(){
            driver.get("https://itera-qa.azurewebsites.net/%22");
                    WebElement login = driver.findElement(By.cssSelector("[href='/Login']"));
            login.click();
            WebElement username = driver.findElement(By.xpath("//input[@id='Username']"));
            username.sendKeys("İsmetT123");
            WebElement password = driver.findElement(By.xpath("//input[@id='Password']"));
            password.sendKeys("123");
            WebElement buton = driver.findElement(By.xpath("//input[@name='login']"));
            buton.click();
            WebElement createButton = driver.findElement(By.cssSelector("[href='/Customer/Create']"));
            createButton.click();
            WebElement name = driver.findElement(By.cssSelector("[id='Name']"));
            name.sendKeys("Ahmet");
            WebElement company = driver.findElement(By.cssSelector("[id='Company']"));
            company.sendKeys("TechnoStudy");
            WebElement address = driver.findElement(By.cssSelector("[id='Address']"));
            address.sendKeys("Çorlu");
            WebElement city = driver.findElement(By.cssSelector("[id='City']"));
            city.sendKeys("Tekirdağ");
            WebElement phone = driver.findElement(By.cssSelector("[id='Phone']"));
            phone.sendKeys("0505656465");
            WebElement email = driver.findElement(By.cssSelector("[id='Email']"));
            email.sendKeys("ahmetersoz@gmail.com");
            WebElement createButton2 = driver.findElement(By.cssSelector("[value='Create']"));
            createButton2.click();

        }
    }
