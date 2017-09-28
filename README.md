# Bit Helper
A command line utility program for some common bit operations I've needed.


# Sample Usage

## XOR Table

Command executed:

`bithelper -xt -rs 0 -re 10 -bs 5 -st 1 -m 3600854380`

Results:

```
Hex      | Integer     | Unsigned    | Binary                          
--------------------------------------------------------------------------------
d6a0ad6c |  -694112916 |  3600854380 | 11010110101000001010110101101100
d6a0ad4c |  -694112948 |  3600854348 | 11010110101000001010110101001100
d6a0ad2c |  -694112980 |  3600854316 | 11010110101000001010110100101100
d6a0ad0c |  -694113012 |  3600854284 | 11010110101000001010110100001100
d6a0adec |  -694112788 |  3600854508 | 11010110101000001010110111101100
d6a0adcc |  -694112820 |  3600854476 | 11010110101000001010110111001100
d6a0adac |  -694112852 |  3600854444 | 11010110101000001010110110101100
d6a0ad8c |  -694112884 |  3600854412 | 11010110101000001010110110001100
d6a0ac6c |  -694113172 |  3600854124 | 11010110101000001010110001101100
d6a0ac4c |  -694113204 |  3600854092 | 11010110101000001010110001001100
--------------------------------------------------------------------------------
```

Use case:

Some programs (like ARCEngine) like to "encrypt" memory values by XOR-ing them with a random value (set on proccess startup) and storing them at an offset to save memory. Besides changing the binary and nop-ing the XOR-ing behaviour, this command can make searching for values easier.
