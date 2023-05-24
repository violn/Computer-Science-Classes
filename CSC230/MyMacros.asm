# MyMacros.asm
# A collection of every macro I will be using for asm programming

.macro printString (%s)
  la $a0, %s
  li $v0, 4
  syscall
.end_macro
 
.macro readInt(%t)
  li $v0, 5
  syscall
  move %t, $v0
.end_macro

.macro done
 li $v0, 10
 syscall
.end_macro

.macro printInt(%s)
 move $a0, %s
 li $v0, 1
 syscall
.end_macro

.macro printNewLine
 li $a0, '\n'
 li $v0, 11
 syscall
.end_macro
 