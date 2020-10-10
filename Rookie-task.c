// Simple calculator program in C

#include <stdio.h>
int main()
{
  int a,b,res,ch;
  printf("Enter the value of a & b\n");
  scanf("%d %d", &a, &b);
  printf("a = %d and b = %d\n", a,b);
  printf("Enter your choice\n 1:add\n 2:Sub\n 3:Multi\n 4:div\n 5:mod\n");
  scanf("%d",&ch);
  switch(ch) 
  {  
    case 1: res=a+b;
    break;
    case 2: res=a-b;
    break;
    case 3: res=a*b;
    break;
    case 4: res=a/b;
    break;
    case 5: res=a%b;
    break;
    default: printf("Invalid choice\n");
  }
  printf("res = %d\n", res);
  return 0;
}
