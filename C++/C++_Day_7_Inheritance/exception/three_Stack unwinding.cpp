#include<iostream>
using namespace std;
class MyClass
{
public:
	~MyClass()
	{
		cout<<endl<<"in MyClass dest\n";
	}
};
int sqr(int k)
{
	if(k<=0)
	{
		char message[] = "only positive value is allowed";
		throw message; //throwing an exception to the caller
	}
	else
	{
		return k*k;
	}
}
int main()
{
	//MyClass m1; //dest will be called at the end in any case
	int num,res=0;
	cout<<endl<<"enter a number to calculate square\n";
	cin>>num;
	try
	{
		MyClass m1;
		res=sqr(num);// if an exception is thrown then first
					//	MyClass dest will be called
		cout<<endl<<"function is called\n";// will not execute
	}
	catch(char *ptr)
	{
		cout<<endl<<"Error is\t"<<ptr<<endl;
	}
	cout<<endl<<"Result is \t"<<res<<endl;
}