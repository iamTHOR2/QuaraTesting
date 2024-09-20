# Quora Search Automation Case Study

## Problem Statement

Automate the search in Quora and verify the results.

## Suggested Site

Quora Profile

## Detailed Description

1. **Launch the Browser**
   - Open the Quora site using the given URL.

2. **Search for the Topic "Testing"**
   - Enter "Testing" in the search bar.
   - Select the first option that appears in the search suggestion.

3. **Verify Search Results**
   - Check if the text "Results for testing" is displayed on the result page.

4. **Sign In Process**
   - Click on the "Sign In" link.
   - In the prompt, click on the "Sign up with email" link.
   - Verify if the "Sign Up" button is disabled.

5. **Invalid Email Verification**
   - Enter an invalid email in the Email field (e.g., abc@abc).
   - Verify and capture the respective error message shown.

6. **Close the Browser**

## Key Automation Scope

- **Multi-Browser Support**
  - Ensure the automation works on more than one browser (e.g., Chrome, Firefox).

- **Exception Handling**
  - Handle any exceptions that may occur during the automation process.

- **Title Verification**
  - Verify if the title of the result page matches the search topic.

- **Multiple Windows Handling**
  - Handle scenarios where multiple windows or tabs are opened.

- **Screen Capture**
  - Capture screenshots at various stages of the automation for verification purposes.

## Prerequisites

- Install the necessary automation tools (e.g., Selenium WebDriver).
- Set up the environment for multi-browser testing.

## Steps to Run the Automation

1. **Set Up Environment**
   - Install Selenium WebDriver.
   - Configure the WebDriver for the browsers you intend to test (e.g., ChromeDriver, GeckoDriver for Firefox).

2. **Write the Automation Script**
   - Use a programming language like Java.
   - Implement the steps outlined in the Detailed Description section.

3. **Run the Script**
   - Execute the script in your development environment.
   - Ensure all steps are completed successfully.

4. **Verify Results**
   - Check the captured screenshots and logs to verify the automation results.