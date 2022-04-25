## Description

This repository contains the UI Automation test project covering the UI quality check for the Factorial project. This project uses Cucumber framework for automating the UI and is taking the data driven approach.

## About the Project

The Factorial project aims at creating a UI that can be used by users for finding the factorials for a given input.

## Repository Contents

This project contains 5 packages and 6 main files:

1. features package containing **factorial.feature** file
2. stepsDefinition package containing **factorialStepDef.java** file
3. page package containing **basePage.java** and **factorialPage.java** file
4. cucumberHooks package containing **hooks.java** file
5. cucumberRunner package containing **cucumberRunner.java** file

## How to Use

1. Clone the repository or download the Zip folder
2. Open the folder with Eclipse IDE (having cucumber setup)

## Scenario's Covered

1. User entering different types of integer and non-integer input in the input field and checking the expected result on UI.
2. User clicking on the various links present on the page and checking its navigation and content of the opened window.
3. Verifying the window title, page title and other texts present on the page.

## Reports and Logs

The test result report will be generated inside target folder of the project.
