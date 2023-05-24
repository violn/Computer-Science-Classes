#Title: Load Store Program
#Desc: A program that asks for three values, adds the first two, subtracts the last one from the sum, and then prints the values
#Author: Tumaini Donedison
#Date: 02/19/23

.data							# The data used in my program
 prompt1: .asciiz "Please enter the first number: "	# Prompts to be printed
 prompt2: .asciiz "Please enter the second number: "
 prompt3: .asciiz "Please enter the third number: "
 result: .asciiz "Result: "                         	# Result string for my final output
 
 val1: .word 0 						# The values used to stor the user inputs
 val2: .word 0
 val3: .word 0

.text				# The code that gets read and executed
 .globl main
main:
 la $a0, prompt1		# Load the address of my first prompt and save it to $a0
 li $v0, 4			# Print the prompt
 syscall
 
 li $v0, 5			# Get the user input and store it to $v0
 syscall
 
 sw $v0, val1			# Save the user input to val1

 la $a0, prompt2		# Repeat the previous instructions with prompt2 and val2
 li $v0, 4
 syscall
 
 li $v0, 5
 syscall
 
 sw $v0, val2
 
 la $a0, prompt3		# Repeat the previous instructions with prompt3 and val3
 li $v0, 4
 syscall
 
 li $v0, 5
 syscall
 
 sw $v0, val3
 
 lw $s0, val1			# Load the value stored at val1 and save it to $s0
 lw $s1, val2			# Load the value stored at val2 and save it to $s1
 lw $s2, val3			# Load the value stored at val3 and save it to $s2
 
 add $s3, $s0, $s1		# Add the value of $s0 and $s1 and save it to $s3
 sub $s3, $s3, $s2		# Subtract the value of $s3 by $s2 and save it $s3
 
 la $a0, result			# Get our result string and print save it to $a0
 li $v0, 4			# Print the string
 syscall
 
 move $a0, $s0			# Move the value of $s0 to $a0
 li $v0, 1			# Print $a0
 syscall
 
  li $a0, ' '			# Assign the space character to $a0
 li $v0, 11			# Print the space
 syscall
 
 li $a0, '+'			# Assign the space character to $a0
 li $v0, 11			# Print the space
 syscall
 
 li $a0, ' '			# Assign the space character to $a0
 li $v0, 11			# Print the space
 syscall
 
 move $a0, $s1			# Repeat the previous instructions with $s1 and a minus sign
 li $v0, 1
 syscall
 
  li $a0, ' '
 li $v0, 11
 syscall
 
 li $a0, '-'
 li $v0, 11
 syscall
 
 li $a0, ' '
 li $v0, 11
 syscall
 
 move $a0, $s2			# Repeat the previous instructions with $s2 and an equal sign
 li $v0, 1
 syscall
 
  li $a0, ' '
 li $v0, 11
 syscall
 
 li $a0, '='
 li $v0, 11
 syscall
 
 li $a0, ' '
 li $v0, 11
 syscall
 
 move $a0, $s3			# Set the value of $s3 to $a0
 li $v0, 1			# Print $a0
 syscall
 
 li $a0, '\n'			# Set give $a0 the value of newline
 li $v0, 11			# Print the newline
 syscall
 
 li $v0, 10			# Exit the program
 syscall
