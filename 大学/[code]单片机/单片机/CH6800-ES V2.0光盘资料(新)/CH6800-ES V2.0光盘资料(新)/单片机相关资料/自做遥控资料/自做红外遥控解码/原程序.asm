;@ by yangzhenshang
;@ email:yangzhenshang@hotmail.com
;@ 2003.7.20

keydata equ 30h  

org 00h
main:
mov keydata,#0	
	mov tmod ,#09h
     	mov  r7,#0
	mov  r6,#0
	jb p3.2,$
again:
	mov tl0,#0
	mov th0,#0	
	setb tr0
	jnb p3.2,$
	jb p3.2,$
	clr tr0	
	mov a,th0
	clr c
	subb a,#12
	jc again
	mov a,#14
	clr c
	subb a,th0
        jc again   ;seaching start bit:  3.6ms
nextbit:
	mov tl0,#0
	mov th0,#0
	setb tr0
	jnb p3.2,$
	jb p3.2,$ 
	clr tr0
	mov a,th0
	clr c
	subb a,#8
	jc next  ;;;;;;;;;;if <2.2ms
	mov a,#10
	clr c
	subb a,th0
	jc again ;;;;;;;if >2.7ms
	mov a,keydata
	setb c          ;bit  = 1
	rrc a
	mov keydata,a
	inc r7
	cjne r7,#8,nextbit
	inc r6
	cjne r6,#2,last8
	sjmp seach
last8:
	mov keydata+1,a
	mov r7,#0
	sjmp nextbit	
next:   
	mov a,th0
	swap a
	mov r1,a
	anl tl0,#0f0h
	mov a,tl0
	clr c
	rrc a
	rrc a
	rrc a
	rrc a
	add a,r1
	mov r1,a
	subb a,#30
	jc nextbit ; if <0.84ms
	mov a,r1
	clr c
	cjne a,#64,continue
continue:
	jnc nextbit ;  if >1.11ms
	mov a,keydata
	clr c          ;bit  = 0
	rrc a
	mov keydata,a
	inc r7
	cjne r7,#8,nextbit
	inc r6
	cjne r6,#2,last_8
	sjmp seach
last_8: 
	mov keydata+1,a
	mov r7,#0
	sjmp nextbit
seach:	
	mov r0,#-2  ;pointer
	mov r1,#-1  ;counter	
seach1:
        inc r0
seach2:	inc r0
	inc r1
	cjne r1,#29,compare
	sjmp exit0
compare:
 	mov a,r0
	mov dptr,#keycode
	movc a,@a+dptr
	cjne a,keydata,seach1
	inc r0
	mov a,r0
	mov dptr,#keycode
	movc a,@a+dptr
	cjne a,keydata+1,seach2
	mov p1,r1         ;output to p1
send:	
	mov tmod,#20h     ;   timer 1,mode 2
	mov tl1,#0fdh
	mov th1,#0fdh
	mov scon,#01010000b;9600,8,1,0
	setb tr1
loop_s:
	mov sbuf,r1    ;send to the serial port of computer
	jnb ti,$
	clr ti
exit0:	
ljmp main

keycode:
db 11111000b,00000000b,    11111100b,00000000b,    11111001b,11000000b
db 11111100b,11000000b,    11111010b,00000000b,    11111010b,00100000b
db 11111010b,01000000b,    11111010b,01100000b,    11111010b,10000000b
db 11111010b,10100000b,    11111010b,11000000b,    11111010b,11100000b
db 11111011b,00000000b,    11111011b,00100000b,    11111011b,01000000b
db 11111011b,01100000b,    11111111b,01100000b,    11111111b,10100000b
db 10001100b,10001110b,    10001101b,11101110b,    10001100b,10101110b
db 10001101b,11001110b,    11111000b,11100000b,    11111100b,10000000b
db 11111100b,01000000b,    11111001b,10100000b,    11111100b,10100000b
db 11111100b,01100000b 
end
