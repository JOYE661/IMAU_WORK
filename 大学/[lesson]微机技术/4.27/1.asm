SSTACK SEGMENT STACK
	   DW 32 DUP(?)			//����32λ�ռ�
SSTACK ENDS

CODE SEGMENT
     ASSUME CS:CODE, SS:SSTACK	//�ĸ��ν�������
START:PUSH DS
	  XOR AX, AX		
	  MOV DS, AX
	  MOV SI, 3000H		//��ʼ��ַ
	  MOV CX, 16		//ѭ������16
AA1:  MOV [SI], AL		//��00H���롡3000H
	  INC SI			//->3001H
	  INC AL			//->01H
	  LOOP AA1			//ѭ��ȡ��cx,cx--
	  MOV AX,4C00H		//�̶�ѭ����ָֹ��1
	  INT 21H		  	//�̶�ѭ����ָֹ��2
CODE  ENDS
	  END START
	  
	  //D0000��ʼ��ַ 3000ƫ�Ƶ�ַ