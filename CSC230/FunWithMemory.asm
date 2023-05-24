# Fun With Memory.asm
# Let's mess around with creatting anf manipulationg data

.data 			# This means everything moving forward goes into data
 var1: .byte 0x0a
 var2: .half 0x0b
 var3: .word 0x0c
 var4: .word 0x00
 var5: .word 0x0d
 
 list1: .byte 1, 2, 3, 4, 5
 list2: .word 10, 11, 12, 13, 14
 list3: .space 10 	# Allocates 10 bytes of memory doesn't need to be initialized
 
 var6: .byte 0x20 	# Let's find our data
 
 str1: .asciiz "Enter a string up to 20 characters: "
 str2: .asciiz "Panda"
 str3: .asciiz "Cheese"
 
 userStr: .space 21 	# Going to allocate 21 spaces for the user string
 deadData: .word 86

.text 			# Code
 .globl main
 main:
 
 			# Let's load two bytes together
 lw $t0, var3
 lw $t1, var4
 add $t0, $t1, $t0
 sw $t0, var5
 
 			# Lest's ask the user for a stirng and echo it back
 
 la $a0, str1 		# strings start at an adress.
 li $v0, 4 		# Let's print the string
 syscall
 
 la $a0, userStr 	# Load the address of the buffer we created to hold the string
 li $a1, 21		# The maximum length of the string
 li $v0, 8
 syscall
 
 la $a0, userStr
 li $v0, 4
 syscall
 
 # String heapStr
 # printf("How big is your string?")
 # scanf("%d, len);
 # heapsStr = new String(x);
 # heapStr = stdin.nextLine();
 
.data			# Back to data
 prompt2: .asciiz "How big will your string be? "
 prompt3: .asciiz "Enter your string: "
 len: .word 0		# This will hold the length of the string
 heapStr: .word 0	# This will hold the address of the String

.text
 la $a0, prompt2
 li $v0, 4
 syscall
 
 li $v0, 5 		# Read an integer
 syscall
 
 sw $v0, len		# Save the length of the variable len
 move $a0, $v0
 li $v0, 9
 syscall
 
 sw $v0, heapStr	# Store the address of our string location in RAM
 
 la $a0, prompt3
 li $v0, 4
 syscall
 
 lw $a0, heapStr	# Load our string buffer from memory and into the register $ao
 lw $a1, len		# Load our user inputted length from memory and store it into register $a1
 li $v0, 8		# Get a user input and store it into our heapStr
 syscall
 
 lw $a0, heapStr	# Echo's it back
 li $v0, 4
 syscall
 
 li $v0, 10
 syscall
