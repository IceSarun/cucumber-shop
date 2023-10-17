#b6410406878
#Sarunpawat Phosoi

Feature: Buy products
    As a customer
    I want to buy products

    Background:
        Given the store is ready to service customers
        And a product "Bread" with price 20.50 and stock of 5 exists
        And a product "Jam" with price 80.00 and stock of 10 exists

    Scenario: Buy one product
        When I buy "Bread" with quantity 2
        Then total should be 41.00
        And a "Bread" in stock is 3 exists

    Scenario: Buy multiple products
        When I buy "Bread" with quantity 2
        And I buy "Jam" with quantity 1
        Then total should be 121.00
        And a "Bread" in stock is 3 exists
        And a "Jam" in stock is 9 exists

    Scenario: Add product
        When I add "Snack" with price 15.00 in stock and stock of 20 exists
        And a product "Snack" with price 15.00 and stock of 20 exists

    Scenario: Buy one new product
        Given the store is ready to service customers
        And a product "Bread" with price 20.50 and stock of 5 exists
        And a product "Jam" with price 80.00 and stock of 10 exists
        And I add "Snack" with price 15.00 in stock and stock of 20 exists
        When I buy "Snack" with quantity 20
        Then total should be 300.00
        And a "Snack" in stock is 0 exists