Feature: Quick View

  @QuickView
  Scenario: QV product brand
    Given I open up the quick view
      | Excel         | Location                                           | Sheet     |
      | ddt_data.xlsx | src/main/java/resources/externalData/ddt_data.xlsx | QuickView   |
    When I inspect the quick view
    Then I can see the product brand

  @QuickView
  Scenario: QV product name
    Given I open up the quick view
      | Excel         | Location                                           | Sheet     |
      | ddt_data.xlsx | src/main/java/resources/externalData/ddt_data.xlsx | QuickView   |
    When I inspect the quick view
    Then I can see the product name

  @QuickView
  Scenario: QV quantity
    Given I open up the quick view
      | Excel         | Location                                           | Sheet     |
      | ddt_data.xlsx | src/main/java/resources/externalData/ddt_data.xlsx | QuickView   |
    When I inspect the quick view
    Then I can see the quantity

  @QuickView
  Scenario: QV rating
    Given I open up the quick view
      | Excel         | Location                                           | Sheet     |
      | ddt_data.xlsx | src/main/java/resources/externalData/ddt_data.xlsx | QuickView   |
    When I inspect the quick view
    Then I can see the rating option

  @QuickView
  Scenario: QV PM Offer - sale price
    Given I open up the quick view
      | Excel         | Location                                           | Sheet     |
      | ddt_data.xlsx | src/main/java/resources/externalData/ddt_data.xlsx | QuickView   |
    When I inspect the quick view
    Then I can see the offer sale price

  @QuickView
  Scenario: QV PO Offer - offers
    Given I open up the quick view
      | Excel         | Location                                           | Sheet     |
      | ddt_data.xlsx | src/main/java/resources/externalData/ddt_data.xlsx | QuickView   |
    When I inspect the quick view
    Then I can see the PC optimum offers

  @QuickView
  Scenario: QV PO Offer - purchase
    Given I open up the quick view
      | Excel         | Location                                           | Sheet     |
      | ddt_data.xlsx | src/main/java/resources/externalData/ddt_data.xlsx | QuickView   |
    When I inspect the quick view
    Then I can see the PC optimum amount for purchase

  @QuickView
  Scenario: QV indicates size/colour of item
    Given I open up the quick view
      | Excel         | Location                                           | Sheet     |
      | ddt_data.xlsx | src/main/java/resources/externalData/ddt_data.xlsx | QuickView   |
    When I inspect the quick view
    Then Indicates the size or colour if applicable

  @QuickView1
  Scenario: QV product details
    Given I open up the quick view
      | Excel         | Location                                           | Sheet     |
      | ddt_data.xlsx | src/main/java/resources/externalData/ddt_data.xlsx | QuickView   |
    When I click Show Product Details
    Then Takes me to the correct PDP

  @QuickView
  Scenario: QV Favourite
    Given I open up the quick view
      | Excel         | Location                                           | Sheet     |
      | ddt_data.xlsx | src/main/java/resources/externalData/ddt_data.xlsx | QuickView   |
    When I inspect the quick view
    Then I can see the Favourite button

  @QuickView
  Scenario: QV product image
    Given I open up the quick view
      | Excel         | Location                                           | Sheet     |
      | ddt_data.xlsx | src/main/java/resources/externalData/ddt_data.xlsx | QuickView   |
    When I inspect the quick view
    Then I can see the product image and under the image I should see show product details which on accessing takes me to PDP