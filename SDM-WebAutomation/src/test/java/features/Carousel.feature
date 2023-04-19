Feature: Carousel

  @Carousel
  Scenario: Product tile - image and hover
    Given   a user is viewing a PLP page
    When    they hover over a product tile
    Then    nothing is overlaid on product image

  @Carousel
  Scenario: Product tile - favourite
    Given   a user is viewing the shop landing page
    When    the page gets loaded
    Then    they DO NOT see a favourite button on the product tile for the main page

  @Carousel
  Scenario: Product tile - favourite 2
    Given   a user is viewing any category landing page (e.g. Makeup)
    When    the page load
    Then    they see a favourite button on the product tile

  @Carousel
  Scenario: product tile - badging
    Given   i am viewing a product tile on PLP
    When    the page gets load
    Then    the badge text with the highest priority for this product is displayed above the product name.

  @Carousel
  Scenario: product tile - product brand
    Given   i am viewing a product tile on PLP
    When    the page gets load
    Then    product brand is displayed in full

  @Carousel
  Scenario: product tile - product name
    Given   i am viewing a product tile on PLP
    When    the page gets load
    Then    product name is displayed in full

  @Carousel
  Scenario: product tile - swatch display/selection
    Given   a user is viewing a product tile of a product that has multiple colour assortment
    When    the page gets load
    Then    they DO NOT see the number of colour variations listed in the product tile info

  @Carousel
  Scenario: product tile - product size/selection
    Given   a user is viewing a product tile of a product that has multiple size assortment
    When    the page gets load
    Then    they DO NOT see the number of size variations listed in the product tile info

  @Carousel
  Scenario: product tile - pricing display
    Given   i am viewing a product tile on a PLP for a regularly priced product
    When    the page is loaded - carousel
    Then    the product's regular price is displayed in black font

  @Carousel
  Scenario: product tile - pricing display discount/clearance
    Given   i am viewing a product tile on a PLP for a product with size assortment
    When    the page is loaded - carousel
    Then    the product's regular price range is displayed in black font

  @Carousel
  Scenario: product tile - pricing display PM promotion
    Given   i am viewing a product tile on a PLP for a discounted or clearance product
    When    the page is loaded - carousel
    Then    the product's discounted price is displayed in red font AND is followed by the product's regular price is displayed with strikethrough styling in grey font

  @Carousel
  Scenario: product tile - pricing display P0 promotion
    Given   i am viewing a product tile on a PLP for a product with item level PC Optimum promotion AND promotion does not require quantity purchase
    When    the page is loaded - carousel
    Then    the applicable PC Optimum bonus point is displayed 3000 in red font

  @Carousel
  Scenario: product tile - pricing display PM & P0 promotion
    Given   i am viewing a product tile on a PLP for a product with item level PC Optimum promotion AND promotion requires quantity purchase
    When    the page is loaded - carousel
    Then    PC Optimum Offer text is displayed in red font

  @Carousel
  Scenario: product tile - quick view
    Given   i am viewing a product tile on a PLP for a product with a item level multiplier PC Optimum promotion (e.g. get 10x points on purchase of this product)
    When    the page is loaded - carousel
    Then    Nx the points text is displayed in red font

  @Carousel
  Scenario: product tile - pricing display free gift
    Given   i am viewing a product tile on a PLP for a product with Gift with Purchase
    When    the page is loaded - carousel
    Then    Gift with Purchase text is displayed in red font - carousel
