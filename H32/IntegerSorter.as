;p415.mas
;
;
;

pmt:	dw "Enter 10 integers\n"
msg:	dw "Integers from smallest to largest\n"
arr:	dw 10 dup 0
x:		dw 0
tmp:	dw 0
i:		dw 0
j:		dw 0
		

start: 	
		ldc pmt
		sout
tst:	
		ldc 10
		sub i
		jz oul
		ldc 1
		add i
		dout
		ldc ':'
		aout
		ldc ' '
		aout
		din
		push
		ldc arr
		add i
		sti
		ldc 1
		add i
		st i
		ja tst
		
oul:	
		ldc 0
		st i
tstol:	
		ldc 9
		sub i
		jz otl
inl:	
		ldc 1
		add i 
		st j	
tstil:	
		ldc 10
		sub j
		jz	iinc
if:		
		ldc arr
		add i 
		ldi 
		st tmp
		ldc arr
		add j 
		ldi
		sub tmp
		jzop jinc
		ldc arr
		add j
		ldi
		push
		ldc arr
		add i 
		sti 
		ld tmp 
		push
		ldc arr 
		add j 
		sti
jinc:	
		ldc 1
		add j
		st j
		ja tstil		
iinc:	
		ldc 1
		add i
		st i
		ja tstol
otl:	
		ldc msg 
		sout
		ldc 0
		st i
otltst:	
		ldc 10
		sub i 
		jz otlend
		ldc 1
		add i
		dout
		ldc msg 
		sout 
		ldc arr 
		ldi 
otlend:	
		exit 0
	end start