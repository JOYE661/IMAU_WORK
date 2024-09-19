#include<linux/init.h>
#include<linux/module.h>
#include<linux/kernel.h>
#include<linux/slab.h>
#include<linux/fs.h>
#include<linux/errno.h>
#include<linux/types.h>
#include<linux/proc_fs.h>
#include<linux/fcntl.h>
#include<linux/poll.h>
#include<asm/system.h>
static int charMajor = 0;
static char drv_buffer[100];
static int char_open(struct inode *inode,struct file *fip){
    printk("Device open success!\n");
    return 0;
}

static int char_release(struct inode *inode,struct file *fip){
    printk("Device release successed\n");
    return 0;
}

static ssize_t char_write(struct file *fip,const char __user *buffer,size_t count,loff_t *offset){
    if(count>100)
        count=100;
    copy_from_user(drv_buffer,buffer,count);
    return count;
}
static ssize_t char_read(struct file *fip,char __user *buffer,size_t count,loff_t *offset){
    if(count>100)
        count=100;
    copy_to_user(buffer,drv_buffer,count);
    return count;
}
static struct file_operations char_fops={
    owner:  THIS_MODULE,
    write:  char_write,
    read:   char_read,
    open:   char_open,
    release:char_release,
};


static int __init char_init(void){
    int ret = register_chrdev(0,"char",&char_fops);
    if(ret<0){
        printk("can't get major number\n");
        return ret;
    }
    charMajor = ret;
    return 0;
}

static void __exit char_exit(void){
    unregister_chrdev(charMajor,"char");
    printk("Exit device successfully!\n");
    return;
}


module_init(char_init);
module_exit(char_exit);
MODULE_LICENSE("GPL");
MODULE_AUTHOR("ZHANG");
