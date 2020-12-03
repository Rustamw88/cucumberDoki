Feature: Checking the basket

  Scenario: I want to test website
    Given I go to main page
    When I enter data in the input field
    And I put the product in the basket
    Then I check that the item is in the cart
    Then I am deleting an item from the cart and I confirm the deletion of the item
    Then I check that the item has been removed from the cart