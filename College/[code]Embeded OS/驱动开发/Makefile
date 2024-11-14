DEVICE = my_device        
ifneq ($(KERNELRELEASE),)
obj-m	:= my_device.o
else
	KERNELDIR ?= /lib/modules/$(shell uname -r)/build
	PWD := $(shell pwd)
default:
	$(MAKE) -C $(KERNELDIR) M=$(PWD) modules
endif
clean:
	rm -rf *.o *.ko *.mod* *.order Module.symvers
