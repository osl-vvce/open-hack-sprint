#include <stdio.h>
 
int main()
{
    int a,b;
    int result;
    char ch;   
    printf("Enter first number: ");
    scanf("%d",&a);
    printf("Enter second number: ");
    scanf("%d",&b);
     
    printf("Choose operation to perform : ");
    scanf(" %c",&ch);
     
    result=0;
    switch(ch)    
    {
        case '+':
            result=a+b;
            break;
             
        case '-':
            result=a-b;
            break;
         
        case '*':
            result=a*b;
            break;
             
        case '/':
            if(b!=0){
            result=a/b;
            }
            else
            printf("Number cannot be divided by zero!\n");
            break;
             
        case '%':
            result=a%b;
            break;
        default:
            printf("Invalid operation.\n");
    }
    if(b!=0){
    printf("Result: %d %c %d = %d\n",a,ch,b,result);
    }
    return 0;
}
