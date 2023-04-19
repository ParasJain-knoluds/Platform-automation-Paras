Feature: CLP

  @CLP
  Scenario: CLP Banner Offers
    Given I am viewing the CLP Beauty or Holiday Home
    When  the page loads
    Then  I can see the Hero Banner of rotating offers on top of page

  @CLP
  Scenario: CLP Category Nav
    Given I am viewing the CLP
    When  the page loads
    Then  I can see the shop by category links

  @CLP
  Scenario: CLP Recommended for you
    Given  I am viewing the CLP
    When   the page loads
    Then   I can see the recommended for you carousel

  @CLP
  Scenario: CLP New and Trending
    Given  I am viewing the CLP
    When   the page loads
    Then   I can see the New & Trending carousel

  @CLP
  Scenario: CLP Current Events
    Given  I am viewing the CLP
    When   the page loads
    Then   I can see the carousel for current events

  @CLP
  Scenario: CLP Current Features
    Given  I am viewing the CLP
    When   the page loads
    Then   I can view the current features, each with a shop now button

  @CLP
  Scenario: CLP Current Features Button
    Given  I am viewing the CLP, specifically the features carousel
    When   clicking the shop now button
    Then   Takes me to resulting PLP

  @CLP
  Scenario: CLP Promotional Carousel
    Given  I am viewing the CLP
    When   the page loads
    Then   I can view the promotional carousel (Quo Beauty Kit 101)