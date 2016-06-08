class Item
{
int id;
String pname;
double price;
Item(int i,String name,double p)
{
id=i;
pname=name;
price=p;
}
public String toString()
{
return id+"  "+pname+"  "+price;
}
public static void main(String[] args)
{
Item p1=new Item(1,"fruit",30d);
System.out.println(p1);
Item p2=new Item(2,"computer",200000.0d);
boolean t=p1.equals(p2);
System.out.println(p2);
Item p3=p1;
System.out.println(p3);
}
}