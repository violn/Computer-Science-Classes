#Title: The Second MIPS Program
#Desc:  The second MIPS program written by me
#Author: Tumaini Donedison
#Date: 02/09/23

# int x = 5;
# int y = 2;
# int z = 3;
# int w = 4;
# int main()
# {
#	x = (x -y) + (z + w);
# 	exit();
# }

.data			# Everything below this is data
 x: .word 5
 y: .word 2
 z: .word 3
 w: .word 4
 
.text
 .globl main
main:
 lw $t0 z
 lw $t1 y
 lw $t2 x
 lw $t3 w
 
 add $t0, $t0, $t3 	# 3 + 4
 sub $t1, $t2, $t1	# 5 - 2
 add $t2, $t1, $t0	# 3 + 7
 
 li $v0, 10
 syscall
