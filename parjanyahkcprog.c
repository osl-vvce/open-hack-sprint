/*C program to design a simple calculator with basic operations.*/
 
#include <stdio.h>
#include <conio.h>

int main()
{
    int num1,num2;
    float res;
    char ch;
     
    printf("Enter first number: ");
    scanf("%d",&num1);
    printf("Enter second number: ");
    scanf("%d",&num2);
     
    printf("Choose operation to perform (+,-,*,/,%): ");
    scanf(" %c",&ch);
     
    res=0;
    switch(ch)    
    {
        case '+':
            res=num1+num2;
            break;
             
        case '-':
            res=num1-num2;
            break;
         
        case '*':
            res=num1*num2;
            break;
             
        case '/':
            res=(float)num1/(float)num2;
            break;
             
        case '%':
            res=num1%num2;
            break;
        default:
            printf("Invalid operation.\n");
    }
 
    printf("Result: %d %c %d = %f\n",num1,ch,num2,res);
    return 0;
}
