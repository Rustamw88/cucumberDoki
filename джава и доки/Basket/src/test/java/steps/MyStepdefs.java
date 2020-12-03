package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MyStepdefs extends TestBase{

    @Before
    public void basket() {
        start();

    }

    @After
    public void basketClear() {
        finish();

    }

    @Given("I go to main page")
    public void iGoToMainPage() {
        driver.get(SITE_URL);
    }

    @When("I enter data in the input field")
    public void iEnterDataInTheInputField() {
        driver.findElement(By.name("search")).sendKeys("lenovo ideapad 5 15are05\n");
    }

    @And("I put the product in the basket")
    public void iPutTheProductInTheBasket() {
        driver.findElement(By.xpath("//div[@class=\"a2j0 a3x5\"][1]")).click();
    }

    @Then("I check that the item is in the cart")
    public void iCheckThatTheItemIsInTheCart() {
        WebElement element = driver.findElement(By.xpath("//a[@href=\"/cart\"]/span[text()='1']"));
        System.out.println(element.getText());

        if(element.getText().equals("1")) {
            System.out.println("Товар добавлен в корзину");
        } else if(element.getText().equals("0")) {
            System.out.println("Корзина пустая");
        }
    }

    @Then("I am deleting an item from the cart and I confirm the deletion of the item")
    public void iAmDeletingAnItemFromTheCartAndIConfirmTheDeletionOfTheItem() {
        driver.findElement(By.xpath("//a[@href=\"/cart\"]")).click();
        for(String tab : driver.getWindowHandles()) {
            driver.switchTo().window(tab);
        }
        driver.findElement(By.xpath("//span[@class=\"a7w\"][2]")).click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.xpath(" //div[contains(text(),'Удалить')]")).click();
    }

    @Then("I check that the item has been removed from the cart")
    public void iCheckThatTheItemHasBeenRemovedFromTheCart() {
        WebElement element2 = driver.findElement(By.xpath("//a[@href=\"/cart\"]/span[text()='0']"));
        System.out.println(element2.getText());

        if(element2.getText().equals("0")) {
            System.out.println("Корзина пустая, товар удален.");
        } else if(element2.getText().equals("1")) {
            System.out.println("Товар не удален.");
        }
    }
}
