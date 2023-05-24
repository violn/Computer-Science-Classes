#Title: The First MIPS Program V3
#Desc:  The first MIPS Program written in class and formatted nicely
#	Let's show input and output
#Author: Tumaini Donedison
#Date: 02/07/23

# int main()
# {
#	int x;
#	prinf("Enter a number and I will add three to it ");
# 	scanf("%d", &x);
#	x = 3 + x;
#	// The value for x was kept in $t0
# 	printf("Here is your results\n%d\n", x);
# 	exit();
# }

.data 			# This tells the assembler that everything that follows is data
			# Don't need to store anything into RAM
			# We need Strings now
 
 prompt: .asciiz "Enter a number and I will add three to it: "
 result: .asciiz "Here is your result: "
 
.text 			#This tells the assembler that everything that follows is code
 .globl main
main:  			# This is the starting point
 la $a0, prompt 	# Load the address of our string in RAM into the register $a0
 li $v0, 4		# Print the String
 syscall
 
 li $v0, 5		# The code to request the system to read an integer
 syscall
 
 move $t0, $v0		# Move the value entered to $t0
 li $t1, 3
 add $t0, $t0, $t1	# Add 3 to $t0 and store the result to $t0
 
 la $a0, result		# Load up the result String and print it
 li $v0, 4
 syscall
 
 move $a0, $t0
 li $v0, 1
 syscall
 
 li $a0, '\n'		# Print a return character so it looks good!
 li $v0, 11
 syscall
 
 li $v0, 10		# Exits the program
 syscall
