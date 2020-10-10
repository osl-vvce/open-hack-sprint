//C program to design a simple calculator.
 
#include <stdio.h> 
 
int main()
{
    int n1,n2; //initialising integer variables to store input values
    float result; //initialising float vairable (result) to store the result of opration.
    char ch;     //to store operator choice
    
    printf("Enter first number: "); //prints the message between the double quotes
    scanf("%d",&n1);                //stores value of the first number in n1
    printf("Enter second number: ");
    scanf("%d",&n2);                //stores value of the second number in n2
     
    printf("Choose operation to perform (+ ,- , *, /, % ): "); 
    scanf(" %c",&ch);               //stores the entered character in variable ch
     
    result=0;  // variable result initialised with zero to avoid storing of garbage value
    switch(ch) //checks the enterd character  
    {
        case '+':          //if + is entered, program switches to addition operation
            result=n1+n2; //result for addition is temporarily stored in result
            break;       // exits the program after the operation is performed
             
        case '-':          //if - is entered, program switches to subtraction operation
            result=n1-n2; //result for subtraction
            break;
         
        case '*':          //if * is entered, program switches to multiplication operation  
            result=n1*n2; //result for multiplication
            break;
             
        case '/':             //if / is entered, program switches to division operation 
            result=(float)n1/(float)n2;//result for division
            break;
             
        case '%':           //if % is entered, program switches to addition operation 
            result= (n1)%(n2);//result for modulus operation
            break;
            default: //if all the above conditions do no match, a default statement is printed 
            printf("Invalid operation!\n"); //default statement
    }
 
    printf("Result: %d %c %d = %f\n",n1,ch,n2,result); //final result of operation is printed on the console
    return 0;
}
