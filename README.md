# StackVM
Simple virtual stack machine implmentation

This is a machine I create for teaching purposes. It is quite simple and capable
of simulate basic arithmetic operations, boolean operations, basic IO (read and write a byte).

The machine state contais a memory that is veiwed as cells, each of which can store a single value (an integer, an boolean,
of a float value). Improper applications of operators to incompatible operands will cause the program to be aborted by an 
exception. The state also contains the stack and input/output streams. 

# Instructions

The instructions are divided in 5 categoreis

## Arithmetical instructions
In this category all operands are expected to be on the stack.
There are two sets of instructions, one for integers and one for floats. 

addi: Addition instruction  
subi: Subtraction instruction
multi: Multiplication instruction
divi: division instruction

addf:
subf:
multf:
divf:

## Logical instructions
Aside from "not", all have two operands that mus be on the stack. 

and : Logical And (Operands must be boolean)
or  : Logical Or (Operands must be boolean)
not : Logical And (the operand must be boolean)
lt : Numerical less that (Operands must be integer or float) 
gt : Numerical greater than (Operands must be integer or float)
eq : Numerical equals (Operands must be integer or float)

## Memory instructions
load
push
store
pop
dup

## Control Instructions
Any instruction can be preceded by a label, followed by colon (:) 

jump <ADD>: unconditional jump (ADD is the target label)
jumpt <ADD>: Like jump, but only jumps if the top of the stack contains is the boolean True
jumps
jumpst
pc
halt

## IO

getch:
putch:

