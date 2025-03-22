## Project Setup

1. Download code from `master` branch.
2. To build the project you need to add `openweathermapApiKey` field in your global `gradle.properties` file, e.g. `openweathermapApiKey=123456789`.<br>
   You can get your own OpenWeather API key from https://home.openweather.co.uk/api_keys, they have free plan for starters.

## Project structure
1. This is a multi-module project. There are few types of modules:
   - "app" - container for core settings, like manifest or navigation
   - "feature" - containers for screens and logic, one feature can have many few screens, e.g. feature "weather forecast" can have screen for searching city and another screen for weather details of the city
   - "network"- resposible for downloading data from servers
   - "store" - responsible for saving data to local memory, e.g. database on device
   - "common" - containers for util functions and objects, which can be used in whole app, e.g. UI components

## App Structure

The project contains following screens:

|                     Search place screen: you can search here for any place on Earth                     |                   Place forecast screen: check weather conditions for selected place                    |
|:-------------------------------------------------------------------------------------------------------:|:-------------------------------------------------------------------------------------------------------:|
| <img src="https://github.com/user-attachments/assets/a25c9f8a-4f2b-4f90-b398-1d97ad2c839c" width="300"> | <img src="https://github.com/user-attachments/assets/80bcdb39-403e-499d-8f2f-4dc65b1fdf10" width="300"> |
