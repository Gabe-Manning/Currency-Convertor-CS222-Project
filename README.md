Authors:
- Gabe Manning
- Christian Johnson
- Joseph Sobiech
- Cameron Hosler

Project Summary:
- This project uses the ExchangeRatesAPI to perform tasks with currency conversion rates. The ConsoleMain class runs the 
Menu class, which then displays information and prompts for user input. The user can then choose to perform multiple 
functions with the program, such as inputting two currencies and getting their current exchange rates, printing all 
current exchange rates compared to the Euro, getting the historical data of a currency on a specific date compared to 
the present, converting a starting monetary amount in one currency into a monetary amount of another currency, 
viewing a current top X ranking of the strongest/weakest currencies compared to the euro, or viewing the current global
ranking of a currency. There are errors that check for valid connection status, empty input, and supported inputs 
(currency, dollar amounts, dates, etc). This program uses input from the console and is run using Gradle.

Needed build/run instructions:
- This program uses Gradle and accordingly must be run through Gradle.
- To run tests, you need to make sure to mark the "Java" folder under the test module as "test resources root".
- To run the program you must have a config.properties file in a resources folder under "main" in "src". In this 
file you must have a variable called apiKey that is equal to one of the current in use apiKeys in the team project 
document. If you use a key that is at use capacity the program will throw a 429 error and you must another key.

Warnings/Errors/Suppressions:
- If converting to a currency with a starting amount and the ending monetary value is larger than one billion, then the
program will round the monetary amount to the nearest integer value when outputting to the console.
- There are suppressed warnings involving if statements being converted to switch statements in the Menu class.
- There are suppressed warnings involving URL deprecation. They are irrelevant and the URL works just fine.
- When you first attempt to rank currencies after booting up the program it sometimes does not print out the ranking 
the first time through. You may need to run that command twice to get the output you want. We don't know why it does 
this, and it works as intended on subsequent uses.
- If the API adds additional currencies to the data, the ranking functions do not work since they are hard-coded. They 
still will work if the API removes them, just not when they add new ones. We couldn't figure out a way to parse through
the JSON data for just the abbreviations, but are looking to find a solution.
- Tests must be run using Gradle, not with IntelliJ, otherwise they do not run. Has something to do with directories.