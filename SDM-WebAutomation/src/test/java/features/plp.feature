Feature: PLP

  @PLP
  Scenario: product tile - product brand
    Given I am viewing a product tile-brand on PLP
      | Excel         | Location                                           | Sheet |
      | ddt_data.xlsx | src/main/java/resources/externalData/ddt_data.xlsx | PLP   |
    When The page is loaded - brand
    Then Product brand displayed in full

  @PLP
  Scenario: product tile - product name
    Given I am viewing a product tile-name on PLP
      | Excel         | Location                                           | Sheet |
      | ddt_data.xlsx | src/main/java/resources/externalData/ddt_data.xlsx | PLP   |
    When The page is loaded - name
    Then Product name displayed in full

  @PLP
  Scenario: product tile - color display
    Given  Product tile of a product that has multiple colour assortment
      | Excel         | Location                                           | Sheet |
      | ddt_data.xlsx | src/main/java/resources/externalData/ddt_data.xlsx | PLP   |
    When The page is loaded - color display
    Then They see the number of color variations listed in the product tile info

  @PLP
  Scenario:product tile - product rating
    Given  Given a user is viewing a product tile of a product
      | Excel         | Location                                           | Sheet |
      | ddt_data.xlsx | src/main/java/resources/externalData/ddt_data.xlsx | PLP   |
    When When the page is loaded - user rating
    Then Then they see the star rating and number of reviews

  @PLP
  Scenario: product tile - product size
    Given  Product tile of a product that has multiple size assortment
      | Excel         | Location                                           | Sheet |
      | ddt_data.xlsx | src/main/java/resources/externalData/ddt_data.xlsx | PLP   |
    When The page is loaded - product size
    Then They see the number of size variations listed in the product tile info

  @PLP
  Scenario: product tile - pricing display regular price
    Given I am viewing a product tile on a PLP for a regularly priced product
      | Excel         | Location                                           | Sheet |
      | ddt_data.xlsx | src/main/java/resources/externalData/ddt_data.xlsx | PLP   |
    When The page is loaded - regular price
    Then The product's regular price is displayed in black font

  @PLP
  Scenario: product tile - pricing display size/color pricing
    Given  I am viewing a product tile on a PLP for a product with size assortment
      | Excel         | Location                                           | Sheet |
      | ddt_data.xlsx | src/main/java/resources/externalData/ddt_data.xlsx | PLP   |
    When The page is loaded - regular price range
    Then Then the product's regular price range is displayed in black font

  @PLP
  Scenario: product tile - pricing display discount/clearance
    Given  I am viewing a product tile on a PLP for a discounted or clearance product
      | Excel         | Location                                           | Sheet |
      | ddt_data.xlsx | src/main/java/resources/externalData/ddt_data.xlsx | PLP   |
    When The page is loaded - discounted product
    Then The product's discounted price is displayed in red font
    And The product's regular price is displayed with strikethrough styling in grey font
    And Clearance and Sale labels differ

  @PLP
  Scenario: product tile - pricing display P01 promotion
    Given I am viewing a product tile on a PLP for a product with item level PC Optimum promotion
      | Excel         | Location                                           | Sheet |
      | ddt_data.xlsx | src/main/java/resources/externalData/ddt_data.xlsx | PLP   |
    And Promotion does not require quantity purchase
    When the page is loaded - P01
    Then The applicable PC Optimum bonus point is displayed in red font

  @PLP
  Scenario: product tile - pricing display P05 promotion
    Given I am viewing a product tile on a PLP for a product with item level PC Optimum promotion
      | Excel         | Location                                           | Sheet |
      | ddt_data.xlsx | src/main/java/resources/externalData/ddt_data.xlsx | PLP   |
    When the page is loaded - P05
    Then Then PC Optimum Offer text is displayed in red font

  @PLP
  Scenario: product tile - pricing display P08 promotion
    Given I am viewing a product tile on a PLP for a product with item level PC Optimum points multiplier promotion P08
      | Excel         | Location                                           | Sheet |
      | ddt_data.xlsx | src/main/java/resources/externalData/ddt_data.xlsx | PLP   |
    When The page is loaded - P08
    Then Then "10x the points" text is displayed in red font

  @PLP
  Scenario: product tile - quick view
    Given I hover over a product time I can see the quick view button
      | Excel         | Location                                           | Sheet |
      | ddt_data.xlsx | src/main/java/resources/externalData/ddt_data.xlsx | PLP   |
    When I click on the quick view button
    Then The quick view modal opens

  @PLP
  Scenario: product tile - quick view with variants
    Given Given I hover over a product WITH VARIANTS, I can see the quick view button
      | Excel         | Location                                           | Sheet |
      | ddt_data.xlsx | src/main/java/resources/externalData/ddt_data.xlsx | PLP   |
    When I click on the quick view button
    Then Then I can click on the drop down and select my desired variant

  @PLP
  Scenario: product tile - pricing display free gift
    Given I am viewing a product tile on a PLP for a product with Gift with Purchase
      | Excel         | Location                                           | Sheet |
      | ddt_data.xlsx | src/main/java/resources/externalData/ddt_data.xlsx | PLP   |
    When The page is loaded - Gift with Purchase
    Then Gift with Purchase text is displayed in red font


  @PLP
  Scenario: Breadcrumb nav
    Given Given I am viewing the PLP
      | Excel         | Location                                           | Sheet |
      | ddt_data.xlsx | src/main/java/resources/externalData/ddt_data.xlsx | PLP   |
    When When the page is loaded breadCrump
    Then I can see the correct breadcrumb path that I have chosen to get to the PLP that I am viewing

  @PLP
  Scenario: PLP product grid load- category not exist
    Given A user is viewing a PLP for a category does not exist
      | Excel         | Location                                           | Sheet |
      | ddt_data.xlsx | src/main/java/resources/externalData/ddt_data.xlsx | PLP   |
    When The page is loaded - 404
    Then Then they see a 404 page

  @PLP
  Scenario: PLP product grid load
    Given A user is viewing a PLP Page
      | Excel         | Location                                           | Sheet |
      | ddt_data.xlsx | src/main/java/resources/externalData/ddt_data.xlsx | PLP   |
    When The page is loaded - grid
    Then Then they see products that belong in the category or assortment load in a grid

  @PLP
  Scenario: PLP load more with less products
    Given A user is viewing a PLP that contains 36 products or less
      | Excel         | Location                                           | Sheet |
      | ddt_data.xlsx | src/main/java/resources/externalData/ddt_data.xlsx | PLP   |
    When They scroll to the bottom of the PLP - 36 products or less
    Then They see You've viewed [number of products visible on the page] of [number of products available on the page]


  @PLP
  Scenario: PLP load more with more products
    Given A user is viewing a PLP that contains 36 products or more
      | Excel         | Location                                           | Sheet |
      | ddt_data.xlsx | src/main/java/resources/externalData/ddt_data.xlsx | PLP   |
    When They scroll to the bottom of the PLP - 36 or more products
    Then They see Pagination buttons
    And User should be on first page with red asterisk color
    And All the pagination buttons should be clickable
    And If pagination count more than three then an arrow should be displayed

  @PLP
  Scenario: PLP load more without pagination
    Given A user is viewing a PLP that contains less then 36 products
      | Excel         | Location                                           | Sheet |
      | ddt_data.xlsx | src/main/java/resources/externalData/ddt_data.xlsx | PLP   |
    When They scroll to the bottom of the PLP - less then 36
    Then They should not see pagination buttons

  @PLP
  Scenario: PLP load more of 2nd pagination with red asterisk colour
    Given A user is viewing a PLP and has scrolled to the bottom of the PLP
      | Excel         | Location                                           | Sheet |
      | ddt_data.xlsx | src/main/java/resources/externalData/ddt_data.xlsx | PLP   |
    When They click the next pagination button
    Then They see the next 36 products that belong on the 2nd pagination with red asterisk color

  @PLP
  Scenario: PLP Filter - display search bar
    Given A user is viewing PLP left side filter
      | Excel         | Location                                           | Sheet |
      | ddt_data.xlsx | src/main/java/resources/externalData/ddt_data.xlsx | PLP   |
    When They go to Brand type filter
    Then User should see a search bar on top to search the brands

  @PLP
  Scenario: PLP Filter search brands
    Given I am on the PLP with Brand type filter search bar
      | Excel         | Location                                           | Sheet |
      | ddt_data.xlsx | src/main/java/resources/externalData/ddt_data.xlsx | PLP   |
    When I enter characters in the brands search bar
      | Excel         | Location                                           | Sheet |
      | ddt_data.xlsx | src/main/java/resources/externalData/ddt_data.xlsx | PLP   |
    Then Brand name filters should be displayed that match the characters typed
      | Excel         | Location                                           | Sheet |
      | ddt_data.xlsx | src/main/java/resources/externalData/ddt_data.xlsx | PLP   |


  @PLP
  Scenario: PLP- Apply Filters
    Given I am on the PLP with left side filter
      | Excel         | Location                                           | Sheet |
      | ddt_data.xlsx | src/main/java/resources/externalData/ddt_data.xlsx | PLP   |
    When I select some filters
      | Excel         | Location                                           | Sheet |
      | ddt_data.xlsx | src/main/java/resources/externalData/ddt_data.xlsx | PLP   |
    Then All the selected filters should be applied on PLP
      | Excel         | Location                                           | Sheet |
      | ddt_data.xlsx | src/main/java/resources/externalData/ddt_data.xlsx | PLP   |
    And Correct count should be displayed on top right
    And All the applied filters should be displayed on top as chip with cross button
      | Excel         | Location                                           | Sheet |
      | ddt_data.xlsx | src/main/java/resources/externalData/ddt_data.xlsx | PLP   |

  @PLP
  Scenario: PLP - Clear All filters
    Given I am on the PLP with Applied filters
      | Excel         | Location                                           | Sheet |
      | ddt_data.xlsx | src/main/java/resources/externalData/ddt_data.xlsx | PLP   |
    When I click on Clear all
    Then The applied filters  should be removed and result should be updated accordingly on PLP

  @PLP
  Scenario: PLP- Applied Filter chips remove
    Given I am on the PLP with some applied filters
      | Excel         | Location                                           | Sheet |
      | ddt_data.xlsx | src/main/java/resources/externalData/ddt_data.xlsx | PLP   |
    When I click on applied filter chip cross button
    Then That filter chip should be removed and the result on PLP should be updated accordingly

  @PLP
  Scenario: PLP- Applied Filter chips
    Given I am on the PLP with some applied filters
      | Excel         | Location                                           | Sheet |
      | ddt_data.xlsx | src/main/java/resources/externalData/ddt_data.xlsx | PLP   |
    When click on any Product PDP or Cart and come back to PLP
    Then Then on the PLP applied filters should remains