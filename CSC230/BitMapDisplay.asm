# BitMapDisplay.asm
# Let's draw pixels. Pixel Art!!! Shocked!

.include "MyMacros.asm"

.eqv BASE_ADDRESS 0x10010000 	# The base address of our display
.eqv RED 0x00FF0000
.eqv GREEN 0X0000FF00
.eqv BLUE 0x000000FF

.data
 
.text
li $s0, BASE_ADDRESS 		# Bitmap Display is a one dimesnsional array. That Wraps
				# We use a base address and an offset to write to it
 li $t5, RED
 li $t6, GREEN
 li $t7, BLUE
 
 sw $t5, 0($s0)
 sw $t6, 4($s0)
 sw $t7, 8($s0)
 sw $t7, 128($s0)

 li $t0, 0
 li $t1, 10
 addi $s1, $s0, 680
 
# Test

 for:
  slt $t2, $t0, $t1
  beq $t2, $zero, right
  
# Logic
  
  sw $t5, 0($s1)		# Write to pixel addressed by $s1
  
# Update

  addi $t0, $t0, 1		# this is i++
  addi $s1, $s1, 4 		# We can't change the offset, but we can change the base
  b for				# Branch back to the start of the for loop
 
right:				# Direct copy of the previous for loop that's now being used to print the right eyebrow
 li $t0, 0
 li $t1, 10
 addi $s1, $s1, 4		# Skips a pixel to show seperation
 
 rightloop:
  slt $t2, $t0, $t1
  beq $t2, $zero, endfor
  
  sw $t5, 0($s1)

  addi $t0, $t0, 1
  addi $s1, $s1, 4 
  b rightloop
  
endfor: 
 done
