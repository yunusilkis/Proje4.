package proje.proje;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static Utlity.BaseDriver.BekleKapat;
import static Utlity.BaseDriver.driver;



    public class Case2 extends BaseDriverr {

        @Test
        public void Case2(){

            driver.get("https://itera-qa.azurewebsites.net/%22");
                    WebElement login = driver.findElement(By.cssSelector("[href='/Login']"));
            login.click();
            WebElement username = driver.findElement(By.xpath("//input[@id='Username']"));
            username.sendKeys("İsmetT123");
            WebElement password = driver.findElement(By.xpath("//input[@id='Password']"));
            password.sendKeys("1234");
            WebElement buton = driver.findElement(By.xpath("//input[@name='login']"));
            buton.click();
            WebElement label = driver.findElement(By.cssSelector("[class='alert-danger']"));
            Assert.assertFalse("TEST FAILED",label.getText().equals("Wrong username or password"));
            BekleKapat();


        }
    }


