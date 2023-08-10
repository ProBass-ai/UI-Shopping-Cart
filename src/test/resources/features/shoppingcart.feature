@shopping-cart
Feature: WEB - Shopping Cart Feature
    Background:
      Given the user is on the landing page

    Scenario Outline: Validate a user may filter clothes by size
      When the user items filters by "<size>"
      Then the number if items found is "<quantity>"

      Examples:
        | size | quantity |
        | XS   | 1        |


