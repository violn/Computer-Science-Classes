#Title: The First MIPS Program V3
#Desc:  The first MIPS Program written in class and formatted nicely
#	Let's show input and output
#Author: Tumaini Donedison
#Date: 02/07/23

# int main()
# {
#	int x;
#	int y;
#	int sum;
#	printf("Enter your first number: ");
#	scanf("%d", &x);
#	printf("Enter your second number: ");
#	scanf("%d", &y);
#	sum = x + y;
# 	printf("The sum of your numbers are: %d\n", x);
# 	return 0;
# }

.data 			# This tells the assembler that everything that follows is data
			# Don't need to store anything into RAM
			# We need Strings now
 
 prompt1: .asciiz "Enter your first number: "
 prompt2: .asciiz "Enter your second number: "
 result: .asciiz "The sum of your numbers are: "
 
.text 			#This tells the assembler that everything that follows is code
 .globl main
main:  			# This is the starting point
 la $a0, prompt1	# Load the address of our string in RAM into the register $a0
 li $v0, 4		# Print the String
 syscall
 
 li $v0, 5		# The code to request the system to read the first integer
 syscall
 
 move $s0, $v0		# Move the value entered to $s0
 
 la $a0, prompt2	# Loads the second prompt to register $a0
 li $v0, 4		# Prints the second prompt string
 syscall
 
 li $v0, 5		# The code to request the system to read the second integer
 syscall
 
 move $s1, $v0		# Moves the value in $v0 to $s1
 
 add $s2, $s1, $s0	# Add the two entered numbers and store them in $s2
 
 la $a0, result		# Loads the results string to register $a0
 li $v0, 4		# Prints the result string
 syscall
 
 move $a0, $s2		# Moves the value of $s2 to $a0
 li $v0, 1		# Prints the sum of the two entered numbers
 syscall
 
 li $a0, '\n'		# Print a return character so it looks good!
 li $v0, 11
 syscall
 
 li $v0, 10		# Exits the program
 syscall
