; hello.mas
;
; Displays "Hello,world!" on the
; console
;

msg:	dw "Hello, world!"

start:	ldc msg
		sout
		exit 0
		end start