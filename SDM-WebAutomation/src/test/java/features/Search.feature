Feature: Search


  @Search
  Scenario: Search results - Brand redirects
    Given I search a specific brand or badge (thoughtful choices)
      | Excel         | Location                                           | Sheet       |
      | ddt_data.xlsx | src/main/java/resources/externalData/ddt_data.xlsx | SearchM1   |
    When I hit enter
    Then It should take me to the specific brand PLP I searched
      | Excel         | Location                                           | Sheet     |
      | ddt_data.xlsx | src/main/java/resources/externalData/ddt_data.xlsx | SearchM1    |

  @Search
  Scenario: Search by category/colour - in stock
    Given a search query is made
      | Excel         | Location                                           | Sheet       |
      | ddt_data.xlsx | src/main/java/resources/externalData/ddt_data.xlsx | SearchM1   |
    When the query is specific to a category or colour
    Then correct product matching the term should be displayed
      | Excel         | Location                                           | Sheet     |
      | ddt_data.xlsx | src/main/java/resources/externalData/ddt_data.xlsx | SearchM1    |

  @Search
  Scenario: Search by category/colour - OOS
    Given a search query is made - oos and stock
      | Excel         | Location                                           | Sheet       |
      | ddt_data.xlsx | src/main/java/resources/externalData/ddt_data.xlsx | SearchM1   |
    When the variant for the query is out of stock
    And Other variants of the product are in stock
    Then the relevant variant should be displayed with an OOS badge
      | Excel         | Location                                           | Sheet     |
      | ddt_data.xlsx | src/main/java/resources/externalData/ddt_data.xlsx | SearchM1    |

  @Search
  Scenario: Search keywords - special character
    Given a search query is made - special character
      | Excel         | Location                                           | Sheet       |
      | ddt_data.xlsx | src/main/java/resources/externalData/ddt_data.xlsx | SearchM1   |
    When When the keyword has a special character
    Then the correct products matching the search term should be displayed
      | Excel         | Location                                           | Sheet     |
      | ddt_data.xlsx | src/main/java/resources/externalData/ddt_data.xlsx | SearchM1    |


  @Search1
  Scenario: Search results - not found
    Given Given I search a term not found
      | Excel         | Location                                           | Sheet       |
      | ddt_data.xlsx | src/main/java/resources/externalData/ddt_data.xlsx | SearchM1   |
    When I hit enter
    Then It should take me to a blank plp breadcrumbed as Shop: [search term] informing me that 0 results are found
      | Excel         | Location                                           | Sheet       |
      | ddt_data.xlsx | src/main/java/resources/externalData/ddt_data.xlsx | SearchM1   |