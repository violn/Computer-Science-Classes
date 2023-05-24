# Created by Tumaini and Sayyed
# Started 5/1/23 finished 5/4/23
# Edited on 5/9/23
# Known issues:
# Holding a key input for too long will crash Mars
# Lower end hardware could experience strange bugs not seen on my machine
# Sometimes, the game will freeze when eating an apple
# This has a low repro rate and thus the bug hasn't been pinpointed and fixed

#Description: This is the final projhect implmneettaion of the snake game, in Assembly. The code is organized in the following ways: 

# The methods implemented: 

# main: The main entry point of the program that sets up initial values and calls subroutines to start the game.
# wipe: This subroutine clears the screen by setting all pixels to black, borders set to yellow.
# spawnApple: Spawns an apple at a fixed position in the middle of the screen.
# spawnRanApple: Spawns an apple at a random position on the screen, ensuring that it does not collide with any existing elements.
# spawnSnake: Spawns the snake at a random position on the screen, ensuring that it does not collide with any existing elements.
# waitInput: Waits for a user input to move the snake in a specific direction (up, down, left, or right).
# update: Handles the main game loop, checking for snake collisions, updating the snake's position, and detecting apple consumption.
# moveDown, moveUp, moveLeft, moveRight: Subroutines that handle moving the snake in specific directions based on user input.


# Teammate Roles:

# Tumaini :

	# Programmed the code structure itself, including the macros, and implemented the functionality of the game itself
	# Conrtibuted to the comments of the Code itself
	# Contributed to the Macros

# Sayyed:
	# Conrtibuted to the entriety of debugging the code, including the game logic
	# Conrtibuted to formatting of the code and the formatting of each inviudal method for better readablity
	# Contributed to making new suggestions oif the functionality of the code itself
	# Created an entire snake version game himself, but chose to follow teammates code as it was simpler to comprehend

.include "MyMacros.asm"
.eqv BASE_ADDRESS 0x10040000 	# The address of the first pixel in the bitmap
.eqv END_ADDRESS 0x10044000	# The address of the last pixel in the bitmap
.eqv RED 0x00FF0000		# Color
.eqv GREEN 0x0000FF00
.eqv WHITE 0xFFFFFFFF
.eqv BLACK 0x00000000
.eqv YELLOW 0X00FFFF00

.text
 malloc 16384 $t0		# Heap memory for our bitmap display, 
 				# This is given the register of $t0 as it's never used Since the base address of 0x010040000 is known
 				# Could be improved by using $s4 to hold the bitmap and check occupation								
 malloc 4096 $s3		# Snake members array
 malloc 4096 $s4	    	# Occupation array

main:

 li $s0, 0			# Last key pressed
 li $s1, 0			# Direction to move in
 li $s2, 0x0 			# Apple position address
 addi $s5, $s3, 4		# Ending address for snake
 sw $zero, 4($s3)		# Removes the second element of the array to properly do movement
 li $s6, 0			# Checks if the snake has grown in the last cycle
 li $s7, 500			# Address for sleep time
 jal wipe			# Subroutine that wipes eveything one screen except the borders
 jal spawnSnake			# Subroutine that spawns the snake
 jal spawnApple			# Subroutine that spawns our apple
 b waitInput			# A subroutine that loops infinitely until the players enters an input

exit:
 exit 				# Exits the program
 				
wipe:
 la $t0, BASE_ADDRESS
 la $t1, END_ADDRESS
 la $t2, BLACK
 la $t3, YELLOW
 addi $t4, $t0, 252		# Address for the pixel directly underneath the first pixel
 addi $t5, $t1, -252 		# Address for the first pixel on the last row of the bitmap
 		
wipeLoop:
 beq $t1, $t0, exitWipe		# Ends the loop if we're past the bitmap
 sgt $t6, $t0, $t4		# Checks if we're past the first row
 beqz $t6, drawBorder		# If not then draw a border pixel at that address
 slt $t6, $t0, $t5		# Do the same if we're on the last row
 beqz $t6, drawBorder
 li $t8, 256			# Check if the address if address is divisble by 256 (on the left side edges)
 div $t0, $t8
 mfhi $t6
 beqz $t6, drawBorder		# If it is draw a border pixel at that address
 addi $t7, $t0, 4		# Adds 4 to the address and check if the sum is divisible by 256 (on the right side edges)
 div $t7, $t8
 mfhi $t6
 beqz $t6, drawBorder		# If it is then draw a border pixel
 sw $t2, 0($t0)			# Draw a black pixel
 sw $t0, 0($s4)			# Add this to the occupation array
 addi $t0, $t0, 4		# Go to the next address
 b wipeLoop 			# Loop
 			
drawBorder:
 sw $t3, 0($t0)			# Draw the border pixel and go to the next address on our bitmap
 addi $t0, $t0, 4
 b wipeLoop
 
exitWipe:
 jr $ra				# Exit the loop
 
spawnApple:
 li $s2, 0x10042080		# Spawn the initial apple at the middle address
 la $t1, WHITE
 sw $t1, 0($s2)
 jr $ra
 
spawnRanApple:
 li $t0, 4			# Needed for dividing by 4
 li $a0, 52			# Get a random number between 0 and 4095 (amount of different positions on the bitmap)
 li $a1, 4095
 li $v0, 42
 syscall
 mult $a0, $t0			# Multiply that number 4 and add it to the base address so we can get a random address
 mflo $t0
 mfhi $t1
 add $t0, $t1, $t0
 la $t1, RED
 add $t2, $t0, BASE_ADDRESS
 lw $t3, 0($t2)			# Checks if the color stored there is black
 beqz $t3, placeRanApple	# If it is then draw a new apple there
 move $t4, $t2
 			
ranAppleLeftLoop:		# Go down each address from the random address we got and check if they're empty
				# This is to ensure that we eventually get a position to put the apple in
 beq $t2, BASE_ADDRESS, ranAppleRight # If our current address is the base address then go the right loop
 addi $t2, $t2, -4		# Go left one pixel
 lw $t3, 0($t2)			# Check if that pixel is empty
 beqz $t3, placeRanApple	# If it is then place an apple there	
 b ranAppleLeftLoop 		# If not then loop
 		
ranAppleRight:			# Does the same thing as the left loop, but to the right
 move $t2, $t4			# Move the original random position back to $t2

ranAppleRightLoop:
 beq $t2, END_ADDRESS, exit	# If we get to the last pixel of the bitmap then end the game as all pixel have been filled
 addi $t2, $t2, 4
 lw $t3, 0($t2)
 beqz $t3, placeRanApple
 b ranAppleLeftLoop 
 
placeRanApple:			# Places the apple if we find an empty position
 sw $t1, 0($t2)
 move $s2, $t2
 addi $s7, $s7, -20		# Decrement the sleep by 20 to increase the snake's speed
 b update			# Go to the update subroutine
 
spawnSnake:			# Subroutine to spawn the snake the player controls
 li $t0, 4			
 li $a0, 52			# Get a random number between 0 and 4095
 li $a1, 4095
 li $v0, 42
 syscall
 mult $a0, $t0			# Multiply the random number we got with 4 and then add the product to the base address
 mflo $t0
 mfhi $t1
 add $t0, $t1, $t0
 add $t2, $t0, BASE_ADDRESS
 lw $t3, 0($t2)			# Check if the address we got is empty
 beqz $t3, placeSnake		# If it is then place a snake there
 b spawnSnake			# If not then find another address
 
placeSnake:			# Place a green pixel signifying a snake and set it's address as occupied
 la $t0, GREEN
 sw $t0, 0($t2)
 sw $t2, 0($s3)
 jr $ra				# Return

waitInput:
 lui $t0, 0xFFFF		# Address of key inputs
 lw $t1, 0($t0)			# Get the value stored in the address of the key input
 andi $t1, $t1, 0x0001
 beq $t1, $zero, waitInput	# If that value is zero then nothing was input and we check again
 lw $s0, 4($t0)			# Get the key that was input
 beq $s0, 'k', moveDown		# Move in the direction of the given key
 beq $s0, 'i', moveUp
 beq $s0, 'j', moveLeft
 beq $s0, 'l', moveRight
 b waitInput			# If the key entered isn't any of the valid keys then check again for another input
 
update:
  sleep $s7           		# Sleep for the duration stored in $s7 (in milliseconds)
 la $t0, BASE_ADDRESS 		# Load the base address of the screen into $t0
 la $t1, END_ADDRESS  		# Load the end address of the screen into $t1
 addi $t0, $t0, 252   		# Add 252 to the base address, offset for the border
 addi $t1, $t1, -252  		# Subtract 252 from the end address, offset for the border
 lw $t2, 0($s3)       		# Load the value at address stored in $s3 (snake's position) into $t2
 sgt $t3, $t2, $t0    		# Set $t3 to 1 if the snake's position is greater than the updated base address (checking for border collision)
 beqz $t3, main       		# If $t3 is 0, meaning no collision, jump back to main
 slt $t3, $t2, $t1    		# Set $t3 to 1 if the snake's position is less than the updated end address (checking for border collision)
 beqz $t3, main       		# If $t3 is 0, meaning no collision, jump back to main
 li $t0, 256          		# Load 256 into $t0
 div $t2, $t0         		# Divide snake's position ($t2) by 256
 mfhi $t1             		# Move the remainder of the division into $t1
 beqz $t1, main      		# If remainder is 0, meaning collision with border, jump back to main
 addi $t3, $t2, 4     		# Add 4 to the snake's position, checking the next cell
 div $t3, $t0         		# Divide the updated position by 256
 mfhi $t1             		# Move the remainder of the division into $t1
 beqz $t1, main       		# If remainder is 0, meaning collision with border, jump back to main
 addi $t3, $s3, 4     		# Add 4 to the address stored in $s3 (snake's position), checking the next segment of the snake
 bnez $s6, continueUpdate 	# If $s6 is not 0 (the snake has more than just the head), jump to continueUpdate


cannableLoop:			# Check if the snake head is eating any of its segments
 move $t4, $s5			# Get the ending address of the segment array
 beq $t4, $t3, continueUpdate	# If we're at the ending array then we've checked all the segments and can move on
 lw $t4, 0($t3)			# Get the address of this segment of the snake
 move $t5, $s3			# Get the address of the snake head
 lw $t5, 0($t5)
 beq $t5, $t4, main		# If the head and segment are at the same address then the snake is eating itself and we have to restart
 addi $t3, $t3, 4		# Move to the next segment of the snake
 b cannableLoop			# Loop
 
continueUpdate:			# Continued section of the update where key inputs are checked
 li $s6, 0			# Reset the snake growth check
 lui $t0, 0xFFFF		# Address of the keyboard input
 lw $t1, 0($t0)			# Get input from the address
 andi $t1, $t1, 0x0001
 beq $t1, $zero, updateMove	# If nothing was inputted then move one to the movement
 lw $s0, 4($t0)			# If something was inputted then load it to $s0
 beq $s0, 'k', moveDown		# Check the inputted key is the valid movement one
 beq $s0, 'i', moveUp
 beq $s0, 'j', moveLeft
 beq $s0, 'l', moveRight

updateMove:			# Subroutine that handles movement
 move $t0, $s3			# Moves the base snake address and ending snake address to temp registers
 move $t3, $s5
 lw $t1, 0($t0)			# Load the addresses of the first two and last two segments of the snake
 lw $t2, 4($t0)
 lw $t4, -4($t3)
 lw $t5, -8($t3)
 seq $t6, $t4, $t5		# Set $t6 to whether or not the last two addresses are equal
 la $t3, GREEN			# Set the green color to $t3
 li $t4, 0			# Load 0 to $t4 to set the color of the old snake position to black
 add $t5, $t1, $s1		# Set $t5 to the direction of the movement direction
 sw $t3, 0($t5)			# Color a green pixel to the address in $t5
 sw $t4, 0($t1)			# Color the old head address with the color black
 sw $t5, 0($t0)			# Set the new address as the head address
 addi $t0, $t0, 4		# Move to the next snake segment
 beq $t0, $s5, checkApple	# If the next address is the end address then end the movement upadate and check if an apple has been eaten
 addi $t0, $t0, -4		# Move back to the head address

moveLoop:
 addi $t0, $t0, 4		# Move to the next snake segment
 sw $t3, 0($t1)			# Move the current snake segment to the address of the old address of the snake segment in front of it
 sw $t1, 0($t0)
 lw $t5, -4($s5)
 beq $t5, $t2, endMoveLoop	# If the current or next segment is the last one then end the loop
 beq $t5, $t1, endMoveLoop
 move $t1, $t2			# Set the address of the next snake segment as the current address
 lw $t2, 4($t0)			# Load the segment after the next segment to $t2
 b moveLoop			# Loop

endMoveLoop:
 bnez $t6, checkApple		# If the two address are not equal then move on the checking if the apple is eaten
 addi $t0, $t0, 4		# Move to the next address in the snake segment
 sw $t4, 0($t2)			# Color the old address of the tail segment black
 sw $t1, 0($t0)			# Set the tail address to this new address
 b checkApple			# Move to checking whether or not the apple has been eaten
 
checkApple:
 lw $t0, 0($s3)			# Get the head address
 beq $t0, $s2, growSnake	# If the head address is the same as the apple address then go to the grow snake subroutine
 b update			# If not then update to the next game state

growSnake:
 lw $t0, -4($s5)		# Get the address of tail/head
 sw $t0, 0($s5)			# Set the tail/head address to the ending address
 addi $s5, $s5, 4 		# Move the ending address up by 4
 li $s2, 0			# Set the apple address to 0
 li $s6, 1			# Set the growth check to true
 b spawnRanApple		# Branch to spawn a new apple

moveDown:			# Movement subroutine that moves the snake down
 lw $t0, 4($s3)			# Load the snake segment after the head
 li $t1, 256			# Load $t1 to the immediate to check 
 bnez $t0, dontMove		# If there's a second segment present then do the don't move check
 li $s1, 256			# Set the new movement direction
 b updateMove			# Update the snake position

moveUp:				# Same as move down expect for the direction
 lw $t0, 4($s3)
 li $t1, -256
 bnez $t0, dontMove
 li $s1, -256
 b updateMove

moveLeft:			# Same as move down expect for the direction
 lw $t0, 4($s3)
 li $t1, -4
 bnez $t0, dontMove
 li $s1, -4
 b updateMove

moveRight:			# Same as move down expect for the direction
 lw $t0, 4($s3)
 li $t1, 4
 bnez $t0, dontMove
 li $s1, 4
 b updateMove

dontMove:			# A subroutine to prevent moving into the snake
 add $t2, $s1, $t1		# Set $t2 to the previous movement direction and the movement the player is trying to go to
 beqz $t2, updateMove		# If the $t2 is 0 then the movements cancel out the snake will keep moving in its current direction
 move $s1, $t1			# If not then update the move direction to the new one
 b updateMove			# Branch to move the snake