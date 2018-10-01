# StackVM
Simple virtual stack machine implementation

This is a machine I create for teaching purposes. It is quite simple and capable
of simulate basic arithmetic operations, boolean operations, basic IO (read and write a byte).

The machine state contains a memory that is veiwed as cells, each of which can store a single value (an integer, an boolean,
of a float value). Improper applications of operators to incompatible operands will cause the program to be aborted by an 
exception. The state also contains the stack and input/output streams. 

# Building
The project was written in java and the "parser" was creaed using jFlex. The makefile included is meant to be used in a linux/unix environment. It requeries that the commands java, javac and jar are installed in a place they can be found.
This project was build under Java 1.8.
If everything is installed correctly you just need to enter the StackMachine directory and type `make`. To run
the machine just type `java -cp . stackMachine.Main FileName` where file name is the name of the source file. 
To create a jar file, just type `make dist` and a jar file named stackVM.jar will be create.

# Input File Format

The instructions are divided in 5 categories. All instructions must have their operands on the stack. Each 
instruction can be preceding of a label followed by a colon.


## Arithmetical instructions
There are two sets of instructions, one for integers, ending with 'i' and one for floats, eding with 'f'. All operands are retrived form the stack in their left to rigth order. For example if the top of the stack contains x and y, respectively then `divi x y` will computate x/y. The operands are always poped out of the stack and the result is pushed into the stack.

 * addi: Addition instruction  for integers
 * subi: Subtraction instruction for integers
 * multi: Multiplication instruction for integers
 * divi: Division instruction for integers
 * addf: Addition instruction  for floats 
 * subf: Subtraction instruction  for floats
 * multf: Multiplication instruction  for floats
 * divf: Division instruction  for floats

## Logical instructions
Aside from "not", all logical instrctions have two operands that mus be on the stack.
The operands are always poped out of the stack and the result is pushed into the stack.

 * and : Logical And (Operands must be boolean)
 * or  : Logical Or (Operands must be boolean)
 * not : Logical And (the operand must be boolean)
 * lt : Numerical less that (Operands must be integer or float) 
 * gt : Numerical greater than (Operands must be integer or float)
 * eq : Numerical equals (Operands must be integer or float)

## Memory instructions
The memory can be viwed as an contiguos array of memory cells.  Each cell can store any value regardless of its size.
In order to make explanations simples, we refer to a value witih the i-esimal position of the memory  by m[i].
* load : The addres to be read form must be on the top of the stack. Pop the memory addres *i* out of the stack, and push m[i]. 
* push : Pushes a literal value (Boolean literal, integer leteral or char literal) onto the stack. Char literal are converted to their corresponding ASCII code and treated as integers. For convinience labels can also be pushe into the stack and ther are also converted to integers corresponding to the address they denote.
* store : The addres to be write on and the value must be on the top of the stack. Pop the memory addres *i* out of the stack, and the write the top of the stack to m[i]. Notice that the value writen to the memory is keept on the stack.
* pop: Removes the top of the stack.
* dup: Duplicate the top of the stack.

## Control Instructions
Any instruction can be preceded by a label, followed by colon (:) 

* jump   <ADD>: unconditional jump (ADD is the target label)
* jumpt  <ADD>: Like jump, but only jumps if the top of the stack contains is the boolean True
* jumps  : Jump to the instruction whose addres is on top of the stack. 
* jumpst : If the top of the stack contais jump to the instruction whose addres is on top of the stack. 
* pc : Pushes the current value of pc onto the stack. 
* halt : Causes the machine to stop.

## IO

getch: Read one character from the input and push into the stack.
putch: Treats the top of the stack as an integer, convert that value to a byte and write the corresponding character 
to the output.

