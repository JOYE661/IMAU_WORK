DEVICE = my_driver        
ifneq ($(KERNELRELEASE),)
obj-m	:= my_driver.o
else
	KERNELDIR ?= /lib/modules/$(shell uname -r)/build
	PWD := $(shell pwd)
default:
	$(MAKE) -C $(KERNELDIR) M=$(PWD) modules
endif
clean:
	rm -rf *.o *.ko *.mod* *.order Module.symvers
