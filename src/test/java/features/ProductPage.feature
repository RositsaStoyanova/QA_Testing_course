Feature: product features
  In order to be on shop page
  As a client
  I want to add items to the cart

  Scenario Outline: Add products to the cart
    Given the logged client is on the products page
    And the client add the following items to the cart:
      | Item 1   | Item 2   |
      | <Item 1> | <Item 2> |
    When the client navigates to the Checkout Page
    Then all items are successfully added

    Examples:
      | Item 1                  | Item 2                   |
      | Sauce Labs Backpack     | Sauce Labs Fleece Jacket |
      | Sauce Labs Bolt T-Shirt | Sauce Labs Onesie        |

  Scenario Outline: Sort the products on shop page
    Given the logged client is on the products page
    When the client selects "<Sorting>" sorting
    Then the client navigates to the Checkout Page

    Examples:
      | Sorting             |
      | Name (Z to A)       |
      | Price (low to high) |

