Authors:
Gabe Manning
Christian Johnson
Joseph Sobiech
Cameron Hosler

Project Summary:
This project uses the ExchangeRatesAPI to calculate and show currency conversion rates.
The Main class runs the Menu class, which then displays and prompts for user input.
The user can then choose to perform multiple functions with the program, such as inputting
two currencies and getting their current exchange rates, printing all current exchange rates
compared to the Euro, getting the historical data of a currency on a specific date compared to the present,
or converting a starting monetary amount in one currency into a monetary amount of another currency. 
There are errors that check for valid connection status, empty input, and supported inputs 
(currency, dollar amounts, dates, etc.). This program uses input from the console and is run using Gradle.

Needed build/run instructions:
This program uses Gradle and accordingly must be run through Gradle.

Warnings/Errors:
Warning involving if statement in Menu class is irrelevant (we don't need to make it a switch).
Tests must be run using Gradle, not with IntelliJ, otherwise they do not run. Has something to do with directories.