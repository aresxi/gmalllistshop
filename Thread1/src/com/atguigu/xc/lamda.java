package com.atguigu.xc;
@FunctionalInterface
 interface Foo{
    public int add(int x, int y);
    // public int div(int x, int y);
     static int mul(int x, int y){
        return x*y;
    }
     static int div2(int x, int y){
        return x/y;
    }
    default  int add1(int x,int y){
         return  x+y;
    }
    default  int add2(int x,int y){
        return  x+y;
    }

 }
public class lamda {
    public static void main(String[]args){
//lambda表达式一句话介绍,先写小括号，写死右箭头，落地大括号 ()->{}
        System.out.println();
        Foo foo= (x,y) -> {
            System.out.println("这是一个函数式接口");
            return x+y; };
        System.out.println(foo.add(4,5));
        System.out.println(Foo.mul(5,6));
    }
}
