Feature: Favourite
  Scenario: product tile - swatch display/selection TC-258
    Given a user is viewing a product tile of a product that has multiple colour assortments
    When the page is Loaded
    Then they Do NOT see the number of colour variations listed in the product tile info



Scenario: Favourites Page - remove products
  Given I am on the favourites page
  When  I unfavourite an item
  Then  The item is removed from my favourite list