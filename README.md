## Project Setup

1. Download code from `master` branch.
2. To build the project you need to add `openweathermapApiKey` field in your global `gradle.properties` file, e.g. `openweathermapApiKey=123456789`.<br>
   You can get your own OpenWeather API key from https://home.openweather.co.uk/api_keys, they have free plan for starters.

## Project structure
This is a multi-module project. There are few types of modules:
   - "app" - container for core settings, like manifest or navigation
   - "feature" - containers for screens and logic, one feature can have many few screens, e.g. feature "weather forecast" can have screen for searching city and another screen for weather details of the city
   - "network" - responsible for contacting with servers
   - "store" - responsible for saving data to local memory, e.g. database on device
   - "common" - containers for util functions and objects, which can be used in whole app, e.g. UI components

## App Structure

The project contains following screens:

|                     Search place screen: you can search here for any place on Earth                     |                   Place forecast screen: check weather conditions for selected place                    |
|:-------------------------------------------------------------------------------------------------------:|:-------------------------------------------------------------------------------------------------------:|
| <img src="https://github.com/user-attachments/assets/2cdbcc17-8a2c-4302-b957-69ee7c179cf5" width="300"> | <img src="https://github.com/user-attachments/assets/e786b9a9-46ce-431b-a24b-546758e9b836" width="300"> |

|                                     Hourly forecast in bottom sheet                                     |
|:-------------------------------------------------------------------------------------------------------:|
| <img src="https://github.com/user-attachments/assets/2be541e9-09c8-4d42-b577-7a456facd2d7" width="300"> |
