
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
- Modulus | %

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

# Config With Comments
Dont fancy command line interfaces? Config is now implemented with json, here is a commented version
```json
{
  "printHelp": false, // Will print help then exit
  "mode": "U", // Switch Modes
  // U is universal, and will follow all the comlpexer toggles for fully custom setup
  // D is duckgroup mode, and will not use lettered functions
  // N is numselli mode, and will enable all complexers
  "doCopy": false, // Automatically copies the expression to your clipboard
  "deep": false, // Executes the Complexers on every integer twice (Doubles output size)
  "color": true, // Makes the output Razor Chroma RGB
  "useDivide": true, // Toggles the divide Complexer
  "useRoot": true, // Toggles the sqrt() Complexer
  "usePower": true, // Toggles the power Complexer
  "useModDividend": true, // Toggles the Modulus Complexer
  "show.progress": false, // Shows the current integer evaluation of the expression
  "verbose.all": false, // Enables all the verbose
  "verbose.processes": true, // Toggles verbose for main processes
  "verbose.complexers": false, // Toggles verbose for the complexers
  "verbose.increasers": false, // Toggles verbose for the increasers
  "verbose.utils": false, // Toggles verbose for the utils
  "verbose.eval": false, // Toggles verbose for the eval function
  "verbose.loops": false, // Toggles verbose for the loops itterations
  "verbose.errors": true // Toggles verbose errors
}
```
When the config generates automatically it will generate in a random order, here is the ordered version if you prefer to have it readable
```json
{ 
  "printHelp": false,
  "mode": "U",
  "doCopy": false,
  "deep": false,
  "color": true,
  "useDivide": true,
  "useRoot": true, 
  "usePower": true,
  "useModDividend": true,
  "show.progress": false,
  "verbose.all": false,
  "verbose.processes": true,
  "verbose.complexers": false,
  "verbose.increasers": false,
  "verbose.utils": false,
  "verbose.eval": false,
  "verbose.loops": false,
  "verbose.errors": true
}
```
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

