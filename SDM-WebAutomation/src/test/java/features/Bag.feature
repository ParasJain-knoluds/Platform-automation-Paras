Feature: BAG
@Bag
  Scenario Outline: bag page - items display TC-69
    Given I am on the bag page sheetname "<SheetName>" and rownumber <RowNumber>
    When I have added products to my bag
    Then my added products load on the page
    Examples:
      | SheetName | RowNumber |
      | Search    | 0         |

  @Bag
  Scenario: bag page - no items display TC-70
  Given I am on the bag page empty
  When I have not added products to my bag
  Then I am presented with the message that my bag is currently empty and option to keep shopping

  @Bag
  Scenario Outline: bag page - remove the only item TC-72
    Given I am on the bag page sheetname "<SheetName>" and rownumber <RowNumber>
    When I remove the item
    Then my bag should be empty
    Examples:
      | SheetName | RowNumber |
      | Search    | 0         |

  @Bag
  Scenario Outline: Bag page - add samples TC-73
    Given I am on the bag page sheetname "<SheetName>" and rownumber <RowNumber>
    When  I have a qualifying product from the beauty category
    Then I can select up to 3 samples to be shipped alongside my order for free
    Examples:
      | SheetName | RowNumber |
      | Search    | 0         |

  @Bag
  Scenario Outline: Bag page - samples (Unqualified) TC-74
    Given I am on the bag page sheetname "<SheetName>" and rownumber <RowNumber>
    When I remove all qualifying product from the beauty category
    Then I no longer see samples in my bag
    Examples:
      | SheetName | RowNumber |
      | Search    | 0         |

  @Bag
  Scenario Outline: bag page - order summary calculations TC-75
    Given I am on the bag page sheetname "<SheetName>" and rownumber <RowNumber>
    When I have added products to my bag and I have not signed in
    Then I am presented the summary calculations of my order but not the tax value
    Examples:
      | SheetName | RowNumber |
      | Search    | 0         |

  @Bag
  Scenario Outline: bag page - order summary calculations TC-76
    Given I am on the bag page sheetname "<SheetName>" and rownumber <RowNumber>
    When I have added products to my bag and I have signed in with an account that has made it through checkout journey before
    Then I am presented the summary calculations of my order including the tax value
    Examples:
      | SheetName | RowNumber |
      | Search    | 0         |
  @Bag
  Scenario Outline: bag page - order summary calculationsunder50 TC-77
    Given I am on the bag page under50 sheetname "<SheetName>" and rownumber <RowNumber>
    When  I have added products to my bag and my order is under fifty
    Then I am presented the summary calculations of my order and the shipping costs is shownas $eight
    Examples:
      | SheetName | RowNumber |
      | Search    | 0         |
  @Bag
  Scenario Outline: bag page - order summary calculations TC-78
    Given I am on the bag page sheetname "<SheetName>" and rownumber <RowNumber>
    When I have added products to my bag
    Then I am presented the summary calculations of my order and the shipping costs is shown as Free
    Examples:
      | SheetName | RowNumber |
      | Search    | 0         |
  @Bag
    Scenario Outline:bag page - quantity adjustment TC-80
     Given I am on the bag page sheetname "<SheetName>" and rownumber <RowNumber>
     When I select the plus and minus buttons
     Then  I am able to modify the quantity to a maximum of six quantities per product and then the plus button is greyed out
      Examples:
        | SheetName | RowNumber |
        | Search    | 0         |

      @Bag
  Scenario Outline: bag page - quantity adjustment TC-81
    Given I am on the bag page with a CHANEL product
    When I select the plus and minus buttons threetimes
    Then I am able to modify the quantity to a maximum ofthree quantities per product and then the plus button is greyed out
    Examples:
      | SheetName | RowNumber |
      | Search    | 0         |

  @Bag
  Scenario Outline: adding item after reaching max quantity TC-82
    Given  have the max quantity of the item in my bag sheetname "<SheetName>" and rownumber <RowNumber>
    When   I try to add more from PDP or PLP
    Then   I am not able to do so and I get an error message
    Examples:
      | SheetName | RowNumber |
      | Search    | 0         |
  @Bag
  Scenario Outline: adding item after reaching max quantity (chanel) TC-83
    Given I am on the bag page with a CHANEL product
    When I try to add more from PDP or PLP for chanel
    Then I am not able to do so and I get an error message
    Examples:
      | SheetName | RowNumber |

  @Bag
  Scenario Outline: Adding OOS item TC-85
    Given I am on a PDP page looking at a product and that product is in stock and I leave that page open and I return and that product is now out of stock sheetname "<SheetName>" and rownumber <RowNumber>
    When I add that product to my bag
    Then I should know that the product is no longer available and I should not be able to add it to my bag
    Examples:
      | SheetName | RowNumber |
      | Search    | 0         |

  @Bag
  Scenario Outline: bag page - promo code entry (multiple types & error scenarios here) TC-86
    Given I am on the bag page sheetname "<SheetName>" and rownumber <RowNumber>
    When I enter a promo code that applies to the item(s) in the bag
    Then the appropriate discount will be applied to the order and displayed in the order summary calculation
    Examples:
      | SheetName | RowNumber |
      | Search    | 0         |

  @Bag
  Scenario Outline: bag page - promo code entry (multiple types & error scenarios here) TC-87
    Given I am on the bag page sheetname "<SheetName>" and rownumber <RowNumber>
    When I enter an invalid promo code
    Then an error message will be displayed
    Examples:
      | SheetName | RowNumber |
      | Search    | 0         |
  #  Web: "Please enter a valid promo code."
  #  App: "Promo code invalid"

  @Bag
  Scenario Outline: bag page - promo code entry (multiple types & error scenarios here) TC-88
    Given I am on the bag page sheetname "<SheetName>" and rownumber <RowNumber>
    When I enter a one-time promo code that has already been used
    Then an error message will be displayed This promo code has already been used and cannot be applied again.
    Examples:
      | SheetName | RowNumber |
      | Search    | 0         |

  @Bag
  Scenario Outline: bag page - promo code entry (multiple types & error scenarios here) TC-89
    Given that I am on the bag page and I have only non-beauty products in my bags sheetname "<SheetName>" and rownumber <RowNumber>
    When I enter a promo code that only applies to Beauty products
    Then an error message will be displayed mentioning that it's for the wrong category or fineline
    Examples:
      | SheetName | RowNumber |
      | Search    | 0         |

  @Bag
  Scenario Outline: bag page - application of free shipping promo TC-90
    Given I am on the bag page sheetname "<SheetName>" and rownumber <RowNumber>
    When I enter a code that includes free shipping
    Then The shipping cost in the summary calculation will changed to Free, regardless of the value of the bag.
    Examples:
      | SheetName | RowNumber |
      | Search    | 0         |

  @Bag
  Scenario Outline: bag page - PCO tile states TC-92
    Given I am on the bag page sheetname "<SheetName>" and rownumber <RowNumber>
    When I am signed in with an account with PCO and have items in my bag
    Then the PCO tile will display with the message
    Examples:
      | SheetName | RowNumber |
      | Search    | 0         |

    # Web: "Points available with this order"
    # App: "Points earned"

  @Bag
  Scenario Outline: bag page - PCO tile states TC-93
    Given I am on the bag page sheetname "<SheetName>" and rownumber <RowNumber>
    When I am signed in but don't have a PCO account and have items in my bag
    Then the PCO tile will display with the message Points you could earn today! as well as offering the options to sign up
    Examples:
      | SheetName | RowNumber |
      | Search    | 0         |


    #Unable to activate Employee Discount Program
#  Scenario: EDP - Add to cart1 (TC-593)
#    Given   I am an SDM employee and I added my location id to my account and activated my Employee Discount Program
#    When    I add an item to my cart
#    Then    If the items current price doesnot have any promotions available, then the discount price shown on the cart should be MAX

   #Unable to activate Employee Discount Program
#  Scenario: EDP - Add to cart2  (TC-593)
#    Given   I am an SDM employee and I added my location id to my account and activated my Employee Discount Program
#    When    I add an item to my cart
#    Then    If the items current price has a promotion, then discount price shown on the cart should be MIN

    #Unable to activate Employee Discount Program
#  Scenario: EDP - Add employee discount to an existing cart (TC-594)
#    Given   I have a cart with the following items: item a with a wholesale price of $5, regular price of $10, and no deal, item b with 50% off sale, item c with a $1 off sale on the $10 regular price and $5 wholesale price, voucher d
#    When    I activate my employee discount from my account and go to view my cart
#    Then    Then I see item a now has 30% off, item b still has 50%, item c has 30%, and my voucher d will be removed unless it also applies to the employees.

    #Unable to activate Employee Discount Program
#  Scenario: EDP - Remove employee discount from an existing cart (TC-595)
#    Given   I have my employee discount activated and I created a cart and added a voucher that
#    When    I deactivate my employee discount from my account and go to view my cart
#    Then    My employee discount is removed, and I should see the items with the current price that the general public pays and my voucher is removed unless it also applies to the general public

   #Unable to activate Employee Discount Program
#  Scenario: EDP - Merge Cart (TC-596)
#    Given   I created a cart without logging in and added items and a voucher to my cart
#    When    I log in to my account, which has an employee discount and a pre-existing cart with items
#    Then    I see that my cart items are merged together, my employee discount is applied on items if there is no better deal for them, and my voucher will be removed unless it also applies to the employees

  @Bag
  Scenario: bag page - PCO tile states (TC-96)
    Given I am on the bag page
    When  I am not signed in and have no items in my bag
    Then  The PCO tile will not display on the bag page

  @Bag  #Pop-up does not show up that my bag has been updated
  Scenario Outline: Bag page - merge bag notification (TC-97)
    Given I have a registered account with a pre-existing cart but I am shopping as a guest user and added items to my bag sheetname "<SheetName>" and rownumber <RowNumber>
    When  I sign in to my account on the bag page
    Then  I get a pop-up telling me my bag has been updated
    Examples:
      | SheetName | RowNumber |
      | Search    | 0         |


  @Bag
  Scenario: Bag page - Sign In TC-98
    Given That I am on the bag page
    When  I sign in after having an empty bag to an account with an empty bag
    Then  Text changes from "Sign in" to Please add items to your bag

  @Bag
  Scenario Outline: bag page - continue to checkout TC-99
    Given That I am on the bag page sheetname "<SheetName>" and rownumber <RowNumber>
    When  I have items in my bag
    Then  I will see a Checkout CTA under the order summary calculation.
    Examples:
      | SheetName | RowNumber |
      | Search    | 0         |


  @Bag
  Scenario Outline: Bag page - Gift with Purchase TC-104
    Given I am on the bag page sheetname "<SheetName>" and rownumber <RowNumber>
    When I have an item that qualify for the gift with purchase
    Then I see the free gift in my bag
    Examples:
      | SheetName | RowNumber |
      | Search    | 0         |
  @Bag
  Scenario Outline: Bag page - Gift with Purchase (Unqualified) TC-105
    Given I am on the bag page and have a GWP sheetname "<SheetName>" and rownumber <RowNumber>
    When I remove qualifying item
    Then the GWP is removed from the bag
    Examples:
      | SheetName | RowNumber |
      | Search    | 0         |

  @Bag
Scenario Outline: Bag page - Deluxe sample (TC-106)
  Given I am on the bag page sheetname "<SheetName>" and rownumber <RowNumber>
  When I spend more than the threshold and qualify for a deluxe sample
  Then I am presented with a free deluxe sample in my bag
  Examples:
    | SheetName | RowNumber |
    | Search    | 0         |

  @Bag
  Scenario: Bag page -  Shopping across devices & user states TC-107
    Given I'm an anonymous user and I have added product A to my bag from tab A and I am on tab B on the same site and I have added product B to my bag from tab B
    When  I go back to tab A and refresh the page
    Then My bag should show products A and B
    #ommit

  @Bag
  Scenario: Bag page - Merging bags TC-109
    Given I am an anonymous user and I have added item A to my bag and I also have a registered user B that already had item B in my bag from yesterday
    When I log in to device A as user B
    Then I should see my bag has items A and B in them (items from the anonymous user are synched with items from user B, that has an account)

  @Bag
  Scenario: Bag page - Merging bags TC-110
    Given I have product A in my anonymous bag and product A in my registered bag
    When I log in from the anonymous user to my registered user
    Then my bag with show the total number of product A's in my bag (added them together) and the total should not exceed the max quantity allowed for that item


