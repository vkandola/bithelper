# Bit Helper
A command line utility program for some common bit operations I've needed.

# Current functionality
- Generating XOR table with 4 representations. Supports bit shifted range iteration and bounds.
- (WIP) Generating Hex/Bit quiz questions for practice with fundamentals.

# Usage

```
usage: bithelper
<quizzes>
 -qb         Begin a binary quiz game.
 -qh         Begin a hex quiz game.
<tables>
 -xt         Generate a XOR table
 -bs <arg>   Number of places to bit shift the iterated values.
 -m <arg>    Inputted XOR mask to use.
 -re <arg>   Ending range for iterated values.
 -rs <arg>   Starting range for iterated values.
 -st <arg>   Step size for range iteration.
```

## Sample of XOR Table

Command executed:

`bithelper -xt -rs 0 -re 10 -bs 5 -st 1 -m 3600854380`

Results:

```
Hex        | Integer     | Unsigned    | Binary
--------------------------------------------------------------------------------
0xD6A0AD6C |  -694112916 |  3600854380 | 11010110101000001010110101101100
0xD6A0AD4C |  -694112948 |  3600854348 | 11010110101000001010110101001100
0xD6A0AD2C |  -694112980 |  3600854316 | 11010110101000001010110100101100
0xD6A0AD0C |  -694113012 |  3600854284 | 11010110101000001010110100001100
0xD6A0ADEC |  -694112788 |  3600854508 | 11010110101000001010110111101100
0xD6A0ADCC |  -694112820 |  3600854476 | 11010110101000001010110111001100
0xD6A0ADAC |  -694112852 |  3600854444 | 11010110101000001010110110101100
0xD6A0AD8C |  -694112884 |  3600854412 | 11010110101000001010110110001100
0xD6A0AC6C |  -694113172 |  3600854124 | 11010110101000001010110001101100
0xD6A0AC4C |  -694113204 |  3600854092 | 11010110101000001010110001001100
--------------------------------------------------------------------------------
```

Use case:

Some programs (like ARCEngine) like to "encrypt" memory values by XOR-ing them with a random value (set on proccess startup) and storing them at an offset to save memory. Besides changing the binary and nop-ing the XOR-ing behaviour, this command can make searching for values easier.
