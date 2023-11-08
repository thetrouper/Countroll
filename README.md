
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

Countroll is currently compatible with the following bots, please open an issue if you find another bot that is compatible or one that isn't compatible!
- [Numselli's counting bot](https://counting.numselli.xyz/)
- [DuckGroup's Counting bot](https://countingbot.com/)

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
| --mode    | -m        | Changes the mode of the bot                       |

## Modes:
You can change the bot's mode with the --mode option
- `--mode=numselli` or `-m=n` Uses Square Root
- `--mode=duckgroup` or `-m=d` Does not use Square Root
- `--mode=TEST` or `-m=t` testing mode (evaluates a given expression)

DuckGroup does not support square roots, which is why they are seperate

# Compiling
Make sure you have Java 17 or higher installed on your system!
1. Clone the repo `$ git clone https://github.com/thetrouper/Countroll/`
2. Change directory to the repo `$ cd Countroll`
3. Build with gradle `$ ./gradlew build`
4. Build will be output to `/Countroll/build/libs`

# Config With Comments

```json
{ // The config is in json, there are no comments allowed in the countroll.json
  "doCopy": false, // Automaticaly copying to clipboard
  "deep": false, // Deep obfuscation, doubling output size
  "verbose.errors": true, // Error printing
  "color": true, // Razor Chroma RGB xpressions are outputed
  "useRoot": true, // Uses sqrt() function
  "verbose.complexers": false, // Shows what the complexers are doing
  "show.progress": false, // Shows the current eval as the expression is building
  "useDivide": true, // Toggles the divide complexer
  "verbose.eval": false, // Shows what the eval function is doing
  "verbose.processes": true, // Shows non looping verbose
  "printHelp": false, // Prints a help message then exits
  "mode": "U", // Switch modes
  // U is universal, and will follow all the comlpexer toggles for fully custom setup
  // D is duckgroup mode, and will not use lettered functions
  // N is numselli mode, and will enable all complexers
  "verbose.all": false, // Shows all the verbose
  "usePower": true, // Toggles power complexer
  "useModDividend": true, // Toggles moduRootDividend complexer (doesnt use letters)
  "verbose.utils": false, // Shows what the Utils are doing
  "verbose.increasers": false, // Shows what the increasers are doing
  "verbose.loops": false // Shows what the loops are doing
}
```

# Up Next
Development will continue with the addition of bitwise operations AND (&) and OR (|)
- Both bots support these operators, and it will be in both modes

