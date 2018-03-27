@temp:	dw 0
main$:
	ldc 1
	push ; x
	ldc 0
	push ; i

	ldc 0
	str -2
@L000:
	ldr -2
	push
	ldc 10
	scmp
	addc 1
	jz @L001
	ldc 0
	ja *+2
@L001:
	ldc 1
	jz @L002
	ldr -1
	addc 1
	str -1
	ldr -2
	addc 1
	str -2
	ja @L000
@L002:
	dloc 2
	halt
	end main$
