# Made by Tumaini Donedison on 4/12/2023
# Fun with the Heap and Interrupts. Way Cool
# Let's allocate neniry and fill it with Random Numbers
# For Fun
# Then let's get exceptional

# What if we wan tto ask the user how many random #'s they want and then
# generate those random #'s in an Array...

.include "MyMacros.asm"

.data
 prompt: .asciiz "How many #'s do you want "
 result: .asciiz "Here's your random #'s: "
 numbers: .asciiz "Number: "
 average: .asciiz "Average: "
 max: .asciiz "Max: "
 min: .asciiz "Min: "
 empty: .asciiz "The array is empty so there are no maxes, mins, averages, or numbers."
 one1: .asciiz "The only number of the array is "
 one2: .asciiz " so it's the max, min, average, and only number."

.text
 .globl main
main:
 jal getRandomNumbers
 
 move $a0, $v0		# Move the size of our array into $a0
 move $a1, $v1		# Move the base address of our array into $a1
 beqz $a0, EndZero	# Checks if the array is empty
 beq $a0, 1, EndOne	# Checks if the array only has one element
 jal printRandomNumbers
 jal getAverage
 jal getMax
 jal getMin
 done
 
 # getRandomNumbers
 # Recieves no parameters
 # Return the size of the array in $v0
 # Returns the base address of the array in $v1
 
getRandomNumbers:
 # Prolog t
 # Alloate room on the stack
 # And store our values
 
 addi $sp, $sp, -20	# Allocate room on the stakc for 5 words
 sw $ra 0($sp)		# Store our values
 sw $s0 4($sp)
 sw $s1 8($sp)
 sw $s2 12($sp)
 sw $s3 16($sp)
 
 printString prompt
 readInt $t0 		# Size of the array is in $to
 
 # Save my integer value to the heap...
 # Allocate Memory is a Syscall
 
 malloc $t0, $s0
 sw $t0, 0($s0)		# Store the size of our array in the heap
 
 # Then I want to allocate memory in the heap for the array
 
 malloc $t0, $s1
 
 # Then I want a for loop that populates
 
 li $t0, 0		# Use $t0 as our i
 lw $t1, 0($s0)		# Load our size of array into $t1
 move $s3, $s1		# Move the base address of our array into $s3 so we can Math
 
 For:
 # Test
 
 slt $t3, $t0, $t1	# As long as $t0 < $t1, keep going
 beq $t3, $zero, End_For
 
 # Logic
 
 li $a0, 42
 li $a1, 100
 li $v0, 42
 syscall
 			# Random number should be in $v0
 sw $a0, 0($s3)		# Move random number to our base
 
 # Update
 
 addi $t0, $t0, 1
 addi $s3, $s3, 4
 b For
 
 End_For:
 # Epilog - Setup return values 
 lw $v0, 0($s0)		# Load our size of array into $t1
 move $v1, $s1		# Load our base address into $v1
 
 lw $ra 0($sp)
 lw $s0 4($sp)
 lw $s1 8($sp)
 lw $s2 12($sp)
 lw $s3 16($sp)
 addi $sp, $sp, 20
 jr $ra
 
 # printRandomNumbers
 # Passed the number of random numbers in $a0
 # Passed the base address of the array to $a1
 # Uses a pointer to iterate through the array and print each element
 # also print the average, Min, Max
 # Returns nothing
 
printRandomNumbers:
 # Prolog
 # In the prolog always move your arguments somewhere safe
 # because they are easy
 
 move $t0, $a0
 move $t1, $a1
 
 addi $sp, $sp, -12	# Allocate room on the stack for 3 words
 sw $ra 0($sp)		# Store our values
 sw $a0 4($sp)
 sw $a1 8($sp)
 #Logic
 printString numbers
 
For_Print:
 beq $t3, $t0, End_Print 	# Check if $t3 is the same as our array size
 
 lw $t4, 0($t1)			# Load the element of the array of the array to $t4
 
 printInt $t4			# Print the element
 
 li $a0, ' '			# Put a space as a seperator
 li $v0, 11
 syscall
 
 addi $t1, $t1, 4		# Move on to the next array element
 addi $t3, $t3, 1		# Increment the counter
 
 b For_Print
 
 #Epilog
 
End_Print:
 printNewLine			# Print a newline
 lw $ra 0($sp)			# Restore our values in our stack
 lw $a0 4($sp)
 lw $a1 8($sp)
 addi $sp, $sp, 12		# Move the stack back up
 
 jr $ra
 
 getAverage:
 # Prolog
 
 move $t0, $a0
 move $t1, $a1
 
 addi $sp, $sp, -12	# Allocate room on the stack for 3 words
 sw $ra 0($sp)		# Store our values
 sw $a0 4($sp)
 sw $a1 8($sp)
 sub $t3, $t3, $t3	# Reset $t3 back to zero
 #Logic
  
For_Average:
 beq $t3, $t0, End_Average	# Breaks the loop if $t3 is equal to our array size
 
 lw $t4, 0($t1)			# Load our array element at the $t3 index into $t4
 
 add $t5, $t4, $t5		# Add the array element to our sum	
 addi $t1, $t1, 4		# Move to the next array element
 addi $t3, $t3, 1		# Increment our counter by one
 
 b For_Average
 
 #Epilog
 
End_Average:
 div $t5, $t0			# Divide our sum with the array size
 mflo $t5			# Get the LO for our quotient
 printString average		# Print our average string
 printInt $t5			# Print the quotient
 
 lw $ra 0($sp)
 lw $a0 4($sp)
 lw $a1 8($sp)
 addi $sp, $sp, 12
 
 jr $ra
 
getMax:
 # Prolog
 
 move $t0, $a0
 move $t1, $a1
 
 addi $sp, $sp, -12	# Allocate room on the stack for 3 words
 sw $ra 0($sp)		# Store our values
 sw $a0 4($sp)
 sw $a1 8($sp)
 sub $t3, $t3, $t3	# Reset $t3 back to zero
 #Logic
 
 lw $t4, 0($t1)		# Get the first number of the array and set it as the max
 addi $t1, $t1, 4	# Increment our array index and counter
 addi $t3, $t3, 1
 
For_Max:
 beq $t3, $t0, End_Max		# Breaks the loop if $t3 is equal to our array size
 
 lw $t5, 0($t1)			# Load our array element at the $t3 index into $t5
 slt $t6, $t5, $t4		# Check if $t5 is less than $t4
 beqz $t6, Greater_Than	# If it isn't then branch to Greater_Than to set it as the max number
 
Continue_Max:
 addi $t1, $t1, 4		# Move to the next array element
 addi $t3, $t3, 1		# Increment our counter by one
 
 b For_Max
 
Greater_Than:
 move $t4, $t5
 b Continue_Max
 #Epilog
 
End_Max:
 printNewLine	
 printString max		# Print our max string
 printInt $t4			# Print the max number
 
 lw $ra 0($sp)			# Restore our values
 lw $a0 4($sp)
 lw $a1 8($sp)
 addi $sp, $sp, 12
 
 jr $ra
 
getMin:
 # Prolog
 
 move $t0, $a0
 move $t1, $a1
 
 addi $sp, $sp, -12		# Allocate room on the stack for 3 words
 sw $ra 0($sp)			# Store our values
 sw $a0 4($sp)
 sw $a1 8($sp)
 sub $t3, $t3, $t3		# Reset $t3 back to zero
 #Logic
 
 lw $t4, 0($t1)			# Get the first number of the array and set it as the max
 addi $t1, $t1, 4		# Increment our array index and counter
 addi $t3, $t3, 1
 
For_Min:
 beq $t3, $t0, End_Min		# Breaks the loop if $t3 is equal to our array size
 
 lw $t5, 0($t1)			# Load our array element at the $t3 index into $t5
 sgt $t6, $t5, $t4		# Check if $t5 is less than $t4
 beqz $t6, Less_Than		# If it isn't then branch to Greater_Than to set it as the max number
 
Continue_Min:
 addi $t1, $t1, 4		# Move to the next array element
 addi $t3, $t3, 1		# Increment our counter by one
 
 b For_Min
 
Less_Than:
 move $t4, $t5
 b Continue_Min
 #Epilog
 
End_Min:
 printNewLine	
 printString min		# Print our max string
 printInt $t4			# Print the max number
 
 lw $ra 0($sp)			# Restore our values
 lw $a0 4($sp)
 lw $a1 8($sp)
 addi $sp, $sp, 12
 
 jr $ra
 
EndZero:
 printString empty

EndOne:
 printString one1
 move $t1, $a1
 lw $t2, 0($t1)
 printInt $t2
 printString one2
 


