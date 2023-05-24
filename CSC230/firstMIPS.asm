#Title: The First MIPS Program
#Desc:  The first MIPS Program written in class and formatted nicely
#Author: Tumaini Donedison
#Date: 02/07/23

# int x = 2;
# int y = 3;
# int main()
# {
#	x = x + y;
# 	exit();
# }

.data 			# This tells the assembler that everything that follows is data
 x: .word 2 		# int x = 2
 y: .word 3 		# int y = 3
 
.text 			#This tells the assembler that everything that follows is code
 .globl main
main:  			# This is the starting point
 lw $t0 x 		# Move x into the register $t0
 lw $t1 y 		# Move y into the register $t1
 
 add $t0, $t1, $t1 	# Add $t0 and $t1 and store the results back into $t0
 
 li $v0, 10 		# Load up a code to tell the program we're done.
 syscall
