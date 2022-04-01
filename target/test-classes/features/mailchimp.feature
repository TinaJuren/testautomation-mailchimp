Feature: Sign Up
  As a user I want to sign up to mailchimp

  Scenario Outline: Test the mailchimp sign up form using various inputs
    Given I have started <browser> browser
    And I have entered an email in the Email field <email>
    And I have entered a username in the Username field <username>
    And I have entered a password in the Password filed <password>
    When I click the Sign Up button
    Then I get a confirmation- or an error message depending on the validity of the user information <username> <email>
    Examples:
      | browser | email                         | username       | password      |
      | "firefox" | "tina.juren+hello10@gmail.com" | "kalleanka00" | "SignUp&1234" |
      | "firefox" | "tina.juren+hello10@gmail.com" | "jjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjj00" | "SignUp&1234" |
      | "firefox" | "tina.juren+hello100@gmail.com" | "tina" | "SignUp&1234" |
      | "firefox" | "" | "kalleanka00" | "SignUp&1234" |
      | "chrome" | "tina.juren+hello10@gmail.com" | "kalleanka00" | "SignUp&1234" |
      | "chrome" | "tina.juren+hello10@gmail.com" | "jjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjj00" | "SignUp&1234" |
      | "chrome" | "tina.juren+hello100@gmail.com" | "tina" | "SignUp&1234" |
      | "chrome" | "" | "kalleanka00" | "SignUp&1234" |

