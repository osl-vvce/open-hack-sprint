<<<<<<< HEAD
#include <stdio.h>


/** 
 * Function declarations for calculator
 */
float add(float num1, float num2);
float sub(float num1, float num2);
float mult(float num1, float num2);
float div(float num1, float num2);
float modulus(int n1, int n2);


int main()
{
    char op;
    float num1, num2, result=0.0f,diff=0;
    int n1,n2;

    /* Print welcome message */
    printf("WELCOME TO SIMPLE CALCULATOR\n");
    printf("----------------------------\n");
    printf("Enter [number 1] [+ - * / %] [number 2]\n");

    /* Input two number and operator from user */
    
    scanf("%f %c %f", &num1, &op, &num2);

    switch(op)
    {
        case '+': 
            result = add(num1, num2);
            break;

        case '-': 
            result = sub(num1, num2);
            break;

        case '*': 
            result = mult(num1, num2);
            break;

        case '/': 
            result = div(num1, num2);
            break;
        case '%':
            n1=(int)num1;
            diff=num1-n1
            n2=(int)num2;
            result = modulus(num1, num2);
            break;

        default: 
            printf("Invalid operator");
    }

    /* Print the result */
    printf("%.2f %c %.2f = %.2f", num1, op, num2, result+diff);

    return 0;
}


/**
 * Function to add two numbers
 */
float add(float num1, float num2)
{
    return num1 + num2;
}

/**
 * Function to subtract two numbers
 */
float sub(float num1, float num2)
{
    return num1 - num2;
}

/**
 * Function to multiply two numbers
 */
float mult(float num1, float num2)
{
    return num1 * num2;
}

/**
 * Function to divide two numbers
 */
float div(float num1, float num2)
{
    return num1 / num2;
}

float modulus(int n1, int n2)
{
    return n1%n2;
}
=======
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
>>>>>>> 47448c2555d8277732a15bfbec82a0e351f00b37
