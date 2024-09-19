OBJ=main.o mj.o zc.o
cc=gcc
circle:$(OBJ)
	$(CC) $(^) -o $@
main.o:main.c mj.h zc.h
mj.o:mj.c mj.h
zc.o:zc.c zc.h
clean:
	rm circle $(OBJ)
