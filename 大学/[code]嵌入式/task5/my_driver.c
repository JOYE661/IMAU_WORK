#include <linux/module.h>
#include <linux/fs.h>
#include <linux/uaccess.h>
#include <linux/init.h>

#define DEVICE_NAME "char"
#define BUFFER_SIZE 100

static char device_buffer[BUFFER_SIZE];

static int char_open(struct inode *inode, struct file *file)
{
    printk(KERN_INFO "Device open success!\n");
    return 0;
}

static int char_release(struct inode *inode, struct file *file)
{
    printk(KERN_INFO "Device release successed\n");
    return 0;
}

static ssize_t char_write(struct file *file, const char __user *buffer, size_t count, loff_t *offset)
{
    if (count > BUFFER_SIZE)
        count = BUFFER_SIZE;
    
    if (copy_from_user(device_buffer, buffer, count))
        return -EFAULT;

    return count;
}

static ssize_t char_read(struct file *file, char __user *buffer, size_t count, loff_t *offset)
{
    if (count > BUFFER_SIZE)
        count = BUFFER_SIZE;
    
    if (copy_to_user(buffer, device_buffer, count))
        return -EFAULT;

    return count;
}

static struct file_operations fops = {
    .owner = THIS_MODULE,
    .open = char_open,
    .release = char_release,
    .read = char_read,
    .write = char_write,
};

static int __init char_init(void)
{
    int ret = register_chrdev(0, DEVICE_NAME, &fops);
    if (ret < 0) {
        printk(KERN_ALERT "Failed to register a char device\n");
        return ret;
    }
    printk(KERN_INFO "char device registered with major number %d\n", ret);
    return 0;
}

static void __exit char_exit(void)
{
    unregister_chrdev(0, DEVICE_NAME);
    printk(KERN_INFO "char device unregistered\n");
}

module_init(char_init);
module_exit(char_exit);
MODULE_LICENSE("GPL");
