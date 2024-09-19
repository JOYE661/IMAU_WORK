#include <stdio.h>
#include <stdlib.h>
#include <fcntl.h>
#include <unistd.h>
#include <string.h>

#define DEVICE_FILE "/dev/char"

int main()
{
    int fd;
    char write_buffer[] = "Hello, world!";
    char read_buffer[50];

    // Open the device file
    fd = open(DEVICE_FILE, O_RDWR);
    if (fd == -1) {
        perror("Failed to open the device file");
        return 1;
    }

    // Write to the device
    write(fd, write_buffer, strlen(write_buffer));

    // Read from the device
    lseek(fd, 0, SEEK_SET);  // Set the file offset to the beginning
    read(fd, read_buffer, 5);
    printf("Read from device: %s\n", read_buffer);

    // Close the device file
    close(fd);

    return 0;
}
