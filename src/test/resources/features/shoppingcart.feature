@shopping-cart
Feature: WEB - Shopping Cart Feature

    Scenario Outline: Validate a user may filter clothes by size
      Given the user is on the landing page
      When the user items filters by "<size>"
      Then the number if items found is "<quantity>"

      Examples:
        | size | quantity |
        | XS   | 1        |
        | S    | 2        |
        | M    | 1        |
        | ML   | 2        |

    Scenario Outline: Validate a user may add items to the cart
      Given the user is on the landing page
      When a user adds item "<item name>" to the cart

      Examples:
        | item name            |
        | Black Batman T-shirt |


