Feature: Navigation

                     #Cannot be automated due to Security Check
#  Scenario: Contact Us form
#    Given I am on the Contact Us form
#    When I submit the Form
#    Then  I get confirmation of submission for the form.Please test for 404, PLP, PDP, CLP

  @Navigation
  Scenario: PLP product grid load
    Given A user is viewing a PLP
    When The page is loaded - Navigation
    Then They see products that belong in the category assortment load in a grid

  @Navigation
  Scenario: PLP item count
    Given A user is viewing a PLP
    When The page is loaded - Navigation
    Then They see Showing [number of products visible on page] of [total products in category] products near the top of the page

  @Navigation
  Scenario: PLP pagination
    Given  A user is viewing a PLP
    When   The page is loaded - Navigation
    Then   at the end of the page they are seeing Pagination option. Triggering Page should lead the user to respective page

  @Navigation
  Scenario: PLP breadcrumb
    Given  A User is on a PLP
    When   The page loads
    Then   User should be able to click on the PLP Breadcrumbs and access the previous page

  @Navigation
  Scenario: PLP sorting
    Given  I am on a PLP
    When   I click on the Sort By dropdown
    Then   I see Recommended, Price: low to high, Price: high to low, Newest

  @Navigation
  Scenario: PLP sorting 1
    Given  I am viewing the Sort By dropdown
    When   I select Recommended
    Then   I see products on PLP sorted in Recommended

  @Navigation
  Scenario: PLP sorting 2
    Given  I am viewing the Sort By dropdown
    When   I select Price: low to high
    Then   I see products on PLP sorted by price from low to high

  @Navigation
  Scenario: PLP sorting 3
    Given  I am viewing the Sort By dropdown
    When   I select Price: high to low
    Then   I see products on PLP sorted by price from high to low

  @Navigation
  Scenario: PLP sorting 4
    Given  I am viewing the Sort By dropdown
    When   I select Newest
    Then   I see products on PLP sorted by newest

  @Navigation
  Scenario: PLP filtering
    Given  I am on a PLP
    When   I look at my available filters
    Then   I see filters based on the product type (price, in stock, ratings, brands, promotions, preferences, etc.)

  @Navigation
  Scenario: PLP Contenful Banner
    Given  I am on a collections PLP
    When   The page is loaded for CLP
    Then   I should see a contentful banner at the top of the PLP

  @Navigation
  Scenario: 404 page
    Given  navigating to a page with Error 404
    When   The page is loaded for 404
    Then   Sorry the page you are looking for cannot be found should be shown

                                    #Out of scope
#  Scenario: Server Error
#    Given  navigating to a page with Error 300
#    When   The page is loaded
#    Then   Sorry the page you are looking for cannot be found should be shown
                                    #Out of scope
#  Scenario: Hamburger Menu
#    Given  you are on any navigation page
#    When   hamburger menu is selected
#    Then   it shows the hamburger menu
                                   #Out of scope
#  Scenario: Hamburger Menu Dismissal
#    Given  You are on any navigation page
#    When   hamburger menu is closed, the menu closes properly
#    Then   Menu closes properly
                                   #Out of scope
#  Scenario: Hamburger Menu
#    Given  You are viewing the hamburger menu
#    When   The correct tiles show
#    Then   Tiles take you to proper routes

  @Navigation
  Scenario: Shoppers-Logo
    Given  I am on any page
    When   I click on the Shopers drug Mart logo
    Then   it navigates to the home page

  @Navigation
  Scenario: Navigation
    Given  I am browsing the site
    When   I arrive at a CLP page
    Then   I should see all the ancestor categories as a breadcrumb trail (e.g. a CLP for the category ‘baguettes’ has the category breadcrumbs: home>food>bakery>bread at the top of the page)

  @Navigation
  Scenario: Navigation 1
    Given  I am viewing the navigation
    When   I choose a category
    Then   I should arrive at a CLP PLP containing relevant products belonging to the chosen category

  @Navigation
  Scenario: Navigation 2
    Given  I am on any page with a collections carousel e.g. Home page
    When   I view the carousel
    Then   It should contain products from the collection

  @Navigation
  Scenario: Navigation 3
    Given  I have clicked tapped show all on a collection carousel
    When   I arrive on the collection page
    Then   I should be able to view all products in the collection

  @Navigation
  Scenario: Navigation 4
    Given  I have clicked on a collections page
    When   I am viewing the page
    Then   I should see products that exist within that collection (as defined by business users)

  @Navigation
  Scenario: Navigation 5
    Given  I have clicked tapped show all on a collection carousel
    When   I arrive on the collection page
    Then   I should be able to filter and sort the products based on their facets

  @Navigation
  Scenario: Navigation 6
    Given  an item is listed online
    When   There is an Offer on a product i.e. Sale, Clearance, Mass PCO, or Gift with purchase (GWP) or Purchase with purchase (PWP)
    Then   I should be able to see it in the Offers section and I should also be able to see the product in it's Category section