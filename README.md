# Parking Lot Management System

This program is a command-line tool for managing a parking lot. It allows the user to create a parking lot with a specified number of spots, park cars, and leave the parking lot. It also provides commands for searching for cars by color or registration number, and printing the status of the parking lot.

## Getting Started
To use this program, you will need a computer with a command-line interface. You will also need to have the source code of the program, which you can obtain by cloning this repository or downloading the code as a zip file.

## Running the Program
To run the program, navigate to the directory where the source code is located and enter the following command:

```
kotlin parking.kt
```
This will start the program and display the command prompt. You can then enter commands to manage the parking lot.

## Available Commands
The following commands are available:

* create n: creates a parking lot with n spots.
* status: prints the status of the parking lot, including the spot number, registration number, and color of each occupied spot.
* park reg_num color: parks a car with the specified registration number and color in the first available spot.
* leave n: removes the car from spot n.
* reg_by_color color: prints the registration numbers of all cars of the specified color, separated by commas.
* spot_by_color color: prints the spot numbers of all cars of the specified color, separated by commas.
* spot_by_reg reg_num: prints the spot number of the car with the specified registration number.
* exit: exits the program.

## Example
Here is an example of using the program:

```
> create 6
Created a parking lot with 6 spots.
> park KA-01-HH-1234 White
White car parked in spot 1.
> park KA-01-HH-9999 White
White car parked in spot 2.
> park KA-01-BB-0001 Black
Black car parked in spot 3.
> park KA-01-HH-7777 Red
Red car parked in spot 4.
> park KA-01-HH-2701 Blue
Blue car parked in spot 5.
> park KA-01-HH-3141 Black
Black car parked in spot 6.
> leave 4
Spot 4 is free.
> status
1 KA-01-HH-1234 White
2 KA-01-HH-9999 White
3 KA-01-BB-0001 Black
4
5 KA-01-HH-2701 Blue
6 KA-01-HH-3141 Black
> reg_by_color white
KA-01-HH-1234,KA-01-HH-9999
> spot_by_color white
1,2
> spot_by_reg KA-01-HH-3141
6
```
## Built With
Kotlin - Programming language used
## Author
Aleksandr Lozhkovoi
