#include <linux/init.h>
#include <linux/module.h>
//#include <linux/kernel.h>
MODULE_LICENSE("Dual BSD/GPL");
static int __init hello_init(void)
{
    printk(KERN_ALERT "hello\n");
    return 0;
}

static void __exit hello_exit(void)
{
    printk(KERN_ALERT "bye\n");
}

module_init(hello_init);
module_exit(hello_exit);

//MODULE_LICENSE("GPL");
//MODULE_AUTHOR("Your Name");
//MODULE_DESCRIPTION("Sample Character Device Driver");
