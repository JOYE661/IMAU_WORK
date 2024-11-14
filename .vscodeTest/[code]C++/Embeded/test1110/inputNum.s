	.file	"inputNum.c"
	.section	.rodata
.LC0:
	.string	"plz enter num for %d \n"
.LC1:
	.string	"%d"
	.text
	.globl	readNums
	.type	readNums, @function
readNums:
.LFB0:
	.cfi_startproc
	pushl	%ebp
	.cfi_def_cfa_offset 8
	.cfi_offset 5, -8
	movl	%esp, %ebp
	.cfi_def_cfa_register 5
	subl	$40, %esp
	movl	$.LC0, %eax
	movl	12(%ebp), %edx
	movl	%edx, 4(%esp)
	movl	%eax, (%esp)
	call	printf
	movl	$0, -12(%ebp)
	jmp	.L2
.L3:
	movl	-12(%ebp), %eax
	sall	$2, %eax
	movl	%eax, %edx
	addl	8(%ebp), %edx
	movl	$.LC1, %eax
	movl	%edx, 4(%esp)
	movl	%eax, (%esp)
	call	__isoc99_scanf
	addl	$1, -12(%ebp)
.L2:
	movl	-12(%ebp), %eax
	cmpl	12(%ebp), %eax
	jl	.L3
	leave
	.cfi_restore 5
	.cfi_def_cfa 4, 4
	ret
	.cfi_endproc
.LFE0:
	.size	readNums, .-readNums
	.ident	"GCC: (Ubuntu/Linaro 4.6.3-1ubuntu5) 4.6.3"
	.section	.note.GNU-stack,"",@progbits
