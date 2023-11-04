
# Countroll - Description

Countroll is designed to make using counting bots a bit more interesting. It turns integers into complex, unreadable 
mathematical expressions, perfect for showing off your mathematical knowledge to you friends!
Countroll uses the following operators to make your integer as complex as possible

- Addition | +
- Subtraction | +
- Multiplication | *
- Division | /
- Square Root | sqrt()
- Exponentiation | ^

## Compatibility

Countroll is currently only compatible with [Numselli's counting bot](https://counting.numselli.xyz/), although I hope to be able to support more counting bots soon!

## Usage

1. Compile the Java program from the source, or download a Precompiled Jar
2. Execute it through the command-line `java -jar Countroll-<version>.jar [args]`
3. Enter a target integer. (Whole number ie: 1, 16, 4096)
4. Copy the outputed expression and use it wherever you'd like!

## Arguments

There are multiple command line arguments you can use for ease of use

| Argument  | Alias(es) | Description                                       |
|-----------|-----------|---------------------------------------------------|
| --copy    | -c        | Automatically copies the output to your clipboard |
| --verbose | -v        | Enables verbose output for debugging              |
| --color   | -rgb      | Enables colored output for debug/it looks cool    |
| --deep    | -d        | Will run the Complexers on the Increaser values   |
| --help    | --h, -h   | Shows a message like this table                   |

# Compiling
Make sure you have Java 17 or higher installed on your system!
1. Clone the repo `$ git clone https://github.com/thetrouper/Countroll/`
2. Change directory to the repo `$ cd Countroll`
3. Build with gradle `$ ./gradlew build`
4. Build will be output to `/Countroll/build/libs`

