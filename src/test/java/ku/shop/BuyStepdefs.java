package ku.shop;
//b6410406878
//Sarunpawat Phosoi
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BuyStepdefs {

    private ProductCatalog catalog;
    private Order order;

    @Given("the store is ready to service customers")
    public void the_store_is_ready_to_service_customers() {
        catalog = new ProductCatalog();
        order = new Order();
    }

    @Given("a product {string} with price {float} and stock of {int} exists")
    public void a_product_exists(String name, double price, int stock) {
        catalog.addProduct(name, price, stock);
    }

    @When("I buy {string} with quantity {int}")
    public void i_buy_with_quantity(String name, int quantity) {
        Product prod = catalog.getProduct(name);
        order.addItem(prod, quantity);
    }

    @Then("total should be {float}")
    public void total_should_be(double total) {
        assertEquals(total, order.getTotal());
    }

    @Then("a {string} in stock is {int} exists")
    public void product_in_stock(String name,int quantity){
        Product prod = catalog.getProduct(name);
        assertEquals(quantity,prod.getStock());
    }

    @When("I add {string} with price {float} in stock and stock of {int} exists")
    public void add_product(String name, double price, int stock) {
        catalog.addProduct(name, price, stock);
    }
}

