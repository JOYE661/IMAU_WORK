SSTACK SEGMENT STACK
	   DW 32 DUP(?)			//开辟32位空间
SSTACK ENDS

CODE SEGMENT
     ASSUME CS:CODE, SS:SSTACK	//四个段建立连接
START:PUSH DS
	  XOR AX, AX		
	  MOV DS, AX
	  MOV SI, 3500H		//起始地址
	  MOV CX, 8			//循环次数16
AA1:  MOV [SI], AL		//把00H送入　3000H
	  INC SI			//->3001H
	  INC AL			//->01H
	  LOOP AA1			//循环取决cx,cx--
	  MOV SI, 3500H
	  MOV DI, 3600H
	  MOV AX,4C00H		//固定循环终止指令1
	  INT 21H		  	//固定循环终止指令2
	  
AA2:  MOV AL, [SI]
	  MOV [DI], AL
	  INC SI
	  INC DI
	  LOOP AA2
	  MOV AX,4C00H		//固定循环终止指令1
	  INT 21H		  	//固定循环终止指令2
	  
CODE  ENDS
	  END START
	  
	  //D0000起始地址 3000偏移地址