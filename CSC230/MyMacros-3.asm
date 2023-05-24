# MyMacros.asm
# A collection of every macro I will be using for asm programming
# Created by Tumaini and Sayyed
# Started 5/1/23 finished 5/4/23
# Edited on 5/9/23

# Macro: exit
# This macro is used to exit a program
.macro exit
 li $v0, 10      # Load syscall code for exit (10) into $v0
 syscall         # Execute the exit syscall
.end_macro

# This macro allocates memory of specified size
# Parameters:
# %a: The number of bytes to allocate
# %v: The register to store the resulting base address
.macro malloc (%a) (%v)
 li $a0, %a      # Move the number of bytes to allocate into $a0
 li $v0, 9       # Load syscall code for memory allocation (9) into $v0
 syscall         # Execute the memory allocation syscall
 move %v, $v0    # Move the resulting address to the specified register (%v)
.end_macro

# This macro loads the value stored in a memory address into a register
# %v: The memory address to get the value from
# %r: The register to store the value
.macro getValue (%v) (%r)
 la %r, %v       # Load address of the memory location into the specified register %r
 lw %r, 0(%r)    # Load the word at the memory address into the register
.end_macro


# This macro pauses the program for a specified number of milliseconds
# %t: The number of milliseconds to sleep
.macro sleep (%t)
 move $a0, %t    # Move the number of milliseconds to sleep into $a0
 li $v0, 32      # Load syscall code for sleep (32) into $v0
 syscall         # Execute the sleep syscall
.end_macro
