Feature: PDP

  @PDP
  Scenario: PDP header/footer
    Given I am on a Product Details Page
    When I scroll to the top of the page or scroll to the bottom of the page
    Then I want to see the standard Masthead including mega nav and Footer and be able to use it to perform a search or navigate to another page
      | Excel         | Location                                           | Sheet  |
      | ddt_data.xlsx | src/main/java/resources/externalData/ddt_data.xlsx | PDP |

  @PDP
  Scenario: PDP recommendation containers
    Given I am on a Product Details Page
    When I scroll down the page past the about this product and or ratings and reviews section
    Then I want to see a product carousel that contains other recommended products The carousel should contain products related to the product I am viewing and I should be able to scroll through those products and view the product image brand product name price and any applicable promo information
      | Excel         | Location                                           | Sheet  |
      | ddt_data.xlsx | src/main/java/resources/externalData/ddt_data.xlsx | PDP |

  @PDP
  Scenario: PDP Derm Experience
    Given I am on a PDP for a Derm product
    When I look under the Offers for this product panel
    Then I see a message to Get expert advice from the specialist team and there are two CTAs Ask a Question and Call 1 855 437 6243
      | Excel         | Location                                           | Sheet  |
      | ddt_data.xlsx | src/main/java/resources/externalData/ddt_data.xlsx | PDP |

  @PDP
  Scenario: PDP Schedule 3 Experience
    Given I am on a PDP for a Schedule 3 product
    When I click on Add to Bag
    Then I see a modal prompting me to talk to a pharmacist by calling a phone number or proceed with adding to bag
      | Excel         | Location                                           | Sheet  |
      | ddt_data.xlsx | src/main/java/resources/externalData/ddt_data.xlsx | PDP |

  @PDP
  Scenario: To verify that clicking on the brand name the user is redirected to Brand PLP
    Given I am viewing the Pdp Page
    When I click on the brand name
    Then user is directed to the Brand PLP
      | Excel         | Location                                           | Sheet  |
      | ddt_data.xlsx | src/main/java/resources/externalData/ddt_data.xlsx | PDP |

  @PDP
  Scenario: To verify that clicking on the Review link, user is anchored to the reviews section
    Given I am viewing the Pdp Page
    When I click on The Review click
    Then I should be anchored to the review section
      | Excel         | Location                                           | Sheet  |
      | ddt_data.xlsx | src/main/java/resources/externalData/ddt_data.xlsx | PDP |

  @PDP
  Scenario: To verify that clicking on the magnifier icon the zoomed image is displayed
    Given I am viewing the Pdp Page
    When I click on the magnifier Icon
    Then the zoomed image should be displayed with Close button on the top right corner which when clicked closes the zoomed image
      | Excel         | Location                                           | Sheet  |
      | ddt_data.xlsx | src/main/java/resources/externalData/ddt_data.xlsx | PDP |

  @PDP
  Scenario: To verify that clicking on write a review link, the review form is displayed
    Given I am viewing the Pdp Page
    When I click on Write a review link
    Then the Review form should be opened
      | Excel         | Location                                           | Sheet  |
      | ddt_data.xlsx | src/main/java/resources/externalData/ddt_data.xlsx | PDP |

  @PDP
  Scenario: To verify that qty cannot be decreased less than 1
    Given that I am viewing the Pdp Page And the quantity is 1
    When I click on the - CTA to decrease qty
    Then the Decrease CTA should be greyed out And I should not be able to decrease quantity below 1
      | Excel         | Location                                           | Sheet  |
      | ddt_data.xlsx | src/main/java/resources/externalData/ddt_data.xlsx | PDP |

  @PDP
  Scenario: To verify that qty cannot be increased more than 6
    Given I am viewing the Pdp Page
    When I click on quantity increase CTA
    Then I should be able to increase quantity till 6 And after 6 message should be displayed about quantity limit
      | Excel         | Location                                           | Sheet  |
      | ddt_data.xlsx | src/main/java/resources/externalData/ddt_data.xlsx | PDP |

  @PDP
  Scenario: colour swatch display
    Given that I am viewing item PDP which has multiple color swatches
    When the page is loaded
    Then all the color swatches should be displayed
    And the selected color should be highlighted
    And the selected color name should be displayed as selected in the dropdown
      | Excel         | Location                                           | Sheet  |
      | ddt_data.xlsx | src/main/java/resources/externalData/ddt_data.xlsx | PDP |

  @PDP
  Scenario: Image change after selecting colour
    Given that I am viewing item PDP which has multiple colour swatches
    When I click on a colour swatch
    Then Image image of the selected colour should be displayed
      | Excel         | Location                                           | Sheet  |
      | ddt_data.xlsx | src/main/java/resources/externalData/ddt_data.xlsx | PDP |

  @PDP
  Scenario: selecting color swatch, same color should be displayed in dropdown
    Given that I am viewing item PDP which has multiple color swatches
    When I click on a color swatch
    Then The selected color should be highlighted
    And same color should be displayed in the dropdown as selected
      | Excel         | Location                                           | Sheet  |
      | ddt_data.xlsx | src/main/java/resources/externalData/ddt_data.xlsx | PDP |

  @PDP
  Scenario: colour dropdown display
    Given that I am viewing item PDP which has multiple color swatches
    When I open the color dropdown
    Then all the colours should be displayed in the ascending order of the colour number
    And selected colour should have a tick mark against it
    And sold out colour should have sold out text against it
      | Excel         | Location                                           | Sheet  |
      | ddt_data.xlsx | src/main/java/resources/externalData/ddt_data.xlsx | PDP |

  @PDP
  Scenario: Selecting color from dropdown
    Given that I am viewing item PDP which has multiple color swatches
    When I open the color dropdown
    And I select a color from the dropdown
    Then The color should be selected in the pallet displayed above
    And The image also should be changed
      | Excel         | Location                                           | Sheet  |
      | ddt_data.xlsx | src/main/java/resources/externalData/ddt_data.xlsx | PDP |

  @PDP
  Scenario: Sold out color swatch
    Given that I am viewing item PDP which has multiple color swatches
    When  the page is loaded
    Then  The sold out color should be crossed out in the color pallet displayed
      | Excel         | Location                                           | Sheet  |
      | ddt_data.xlsx | src/main/java/resources/externalData/ddt_data.xlsx | PDP |

  @PDP
  Scenario: Sold out color swatch message
    Given that I am viewing item PDP which has multiple color swatches
    When I click on the sold out color swatch
    Then the sold out message should be displayed
    And the increase decrease quantity button should be disabled
    And Add to Bag button should be disabled
      | Excel         | Location                                           | Sheet  |
      | ddt_data.xlsx | src/main/java/resources/externalData/ddt_data.xlsx | PDP |

  @PDP
  Scenario: To verify that for items having only one size the size is displayed correctly on the PDP
    Given that I am viewing item PDP which has single size
    When the page is loaded
    Then The size should be displayed correctly above the quantity section
      | Excel         | Location                                           | Sheet  |
      | ddt_data.xlsx | src/main/java/resources/externalData/ddt_data.xlsx | PDP |

  @PDP
  Scenario: To verify that for items having multiple sizes the sizes are displayed correctly
    Given that I am viewing item PDP which has multiple sizes
    When the page is loaded
    Then The sizes should be displayed correctly above the quantity section
      | Excel         | Location                                           | Sheet  |
      | ddt_data.xlsx | src/main/java/resources/externalData/ddt_data.xlsx | PDP |

  @PDP
  Scenario: To verify that for items having multiple sizes when the size is selected the price should be displayed correctly
    Given that I am viewing item PDP which has multiple sizes
    When I select the size
    Then the selected size should be displayed correctly
    And price as per the selected size should be displayed
      | Excel         | Location                                           | Sheet  |
      | ddt_data.xlsx | src/main/java/resources/externalData/ddt_data.xlsx | PDP |

  @PDP
  Scenario: To verify that the details of the offers applicable for the product is mentioned in the Offers for the product section
    Given That I am viewing item PDP which has multiple offers applicable
    When the page is loaded
    Then In the Offers for the product section, the description regarding offers should be displayed Different Offers should be tested
      | Excel         | Location                                           | Sheet  |
      | ddt_data.xlsx | src/main/java/resources/externalData/ddt_data.xlsx | PDP |

  @PDP
  Scenario: To verify that clicking on items in the recommended section, the PDP is displayed.
    Given That I am viewing item PDP
    When I click on item displayed in the recommended section
    Then The item PDP should be displayed
      | Excel         | Location                                           | Sheet  |
      | ddt_data.xlsx | src/main/java/resources/externalData/ddt_data.xlsx | PDP |

  @PDP
  Scenario: To verify that for items having Free shipping, the text is displayed in between the price and PCO text
    Given I am viewing item PDP for which free shipping is provided
    When The page is loaded
    Then The Free shipping text should be displayed between the price and PCO text
      | Excel         | Location                                           | Sheet  |
      | ddt_data.xlsx | src/main/java/resources/externalData/ddt_data.xlsx | PDP |

  @PDP
  Scenario: To verify that when a rating (Ex 5 star) is selected, the total count is updated
    Given That I am viewing item PDP
    When I click on the 5 star rating in review section
    Then The filter bar of 5 star is displayed
    And Reviews which has rating of 5 star should be displayed
    And Total count of reviews should be updated
      | Excel         | Location                                           | Sheet  |
      | ddt_data.xlsx | src/main/java/resources/externalData/ddt_data.xlsx | PDP |

  @PDP
  Scenario: To verify that when a rating is selected, selecting another rating the previous applied rating is deselected and new rating is selected
    Given I am viewing an item PDP which has multiple reviews of different ratings
    And  one rating Ex 5 star rating is applied
    When I click on any other rating Example 4 start rating
    Then Previous applied rating 5 star should be removed
    And New selected rating 4 star ratings should be displayed
      | Excel         | Location                                           | Sheet  |
      | ddt_data.xlsx | src/main/java/resources/externalData/ddt_data.xlsx | PDP |

  @PDP
  Scenario: To verify that selecting each sort options in the rating options, the reviews are displayed as per the selected sort
    Given I am viewing PDP which has multiple reviews of different ratings
    When I click all the options
    Then The Reviews should be displayed as per the selected sort option
      | Excel         | Location                                           | Sheet  |
      | ddt_data.xlsx | src/main/java/resources/externalData/ddt_data.xlsx | PDP |

  @PDP
  Scenario: To verify that when item PDP does not have any reviews, the review section is empty and Write the first review link should be displayed
    Given that I am Viewing PDP which does not have any Review
    When the page is loaded
    Then in the review section link Write the first review should be displayed and link should be clickable
      | Excel         | Location                                           | Sheet  |
      | ddt_data.xlsx | src/main/java/resources/externalData/ddt_data.xlsx | PDP |

  @PDP
  Scenario: To verify that proper message is displayed for out of stock PDP
    Given that I am Viewing PDP of an out of stock item
    When the page loaded
    Then the out of stock message should be displayed
    And sold out text should be displayed next to the size
    And Add to bag CTA should be disabled
    And increase decrease qty buttons should be greyed out
      | Excel         | Location                                           | Sheet  |
      | ddt_data.xlsx | src/main/java/resources/externalData/ddt_data.xlsx | PDP |

  @PDP
  Scenario: To verify that images provided in the Review section are displayed below the recommended section
    Given That I am viewing item PDP
    When the page loaded
    Then the item images provided in customer reviews are displayed below the recommended section
      | Excel         | Location                                           | Sheet  |
      | ddt_data.xlsx | src/main/java/resources/externalData/ddt_data.xlsx | PDP |

  @PDP
  Scenario: To verify that clicking on the image provided in the Review section, a modal is displayed along with the review comment
    Given That I am viewing item PDP
    When I click on item image displayed in the Review section
    Then the review modal is displayed with the review comments.
      | Excel         | Location                                           | Sheet  |
      | ddt_data.xlsx | src/main/java/resources/externalData/ddt_data.xlsx | PDP |

  @PDP
  Scenario: To verify that when max qty items are added to bag, clicking on Add to cart the proper message is displayed
    Given that for a particular product I have 6 qty in my cart
    When I click on Add to bag from PDP
    Then the error is displayed of max limit
    And product should not be added to cart
      | Excel         | Location                                           | Sheet  |
      | ddt_data.xlsx | src/main/java/resources/externalData/ddt_data.xlsx | PDP |

  @DoNotRun
  Scenario: PDP breadcrumb
    Given  I am viewing a PDP page
    When  The page is loaded
    Then they see breadcrumb links at the top left, including from Left to right: