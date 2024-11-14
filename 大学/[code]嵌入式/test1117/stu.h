#ifndef _STU_H_
#define _STU_H_
typedef struct{
    int sno;
    char name[50];
    int grade;
}stu;
void sort_grade(stu s[]);
void display(stu s[]);
#endif
