import java.io.*;
import java.util.Locale;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("输入选项：\n1.求3*5，5*6，6*8矩阵相乘，请输入  1  \n2.求任意二维矩阵的乘积，请输入 2\n"+
                        "3.生成随机二维矩阵 3 name\n4.导入序列化二维矩阵 4 name\n5.退出 5");
        String read;
        while(!((read=sc.nextLine()).contains("5"))){
            process(read);
            System.out.println("输入选项：\n1.求3*5，5*6，6*8矩阵相乘，请输入  1  \n2.求任意二维矩阵的乘积，请输入 2\n"+
                    "3.生成随机二维矩阵 3 name\n4.导入序列化二维矩阵 4 name\n5.退出 5");
        }
    }

    public static void process(String read){
        if(read.contains("1")){
            twoDimensionalMatrix a=new twoDimensionalMatrix(3,5);
            a.initializetwoDimensionalMatrix();
            twoDimensionalMatrix b=new twoDimensionalMatrix(5,6);
            b.initializetwoDimensionalMatrix();
            twoDimensionalMatrix c=new twoDimensionalMatrix(6,8);
            c.initializetwoDimensionalMatrix();
            System.out.print(a.printMatrix());
            System.out.print("      ×      ");
            System.out.print(b.printMatrix());
            System.out.print("      ×      ");
            System.out.print(c.printMatrix());
            System.out.print("    ||   ");
            System.out.print(a.MultiplyTwoDimensionalMatrix(b).MultiplyTwoDimensionalMatrix(c).printMatrix());
        }
        else if(read.contains("2")){
            twoDimensionalMatrix a=new twoDimensionalMatrix((int)(Math.random()*10),(int)(Math.random()*10));
            twoDimensionalMatrix b=new twoDimensionalMatrix((int)(Math.random()*10),(int)(Math.random()*10));
            a.initializetwoDimensionalMatrix();b.initializetwoDimensionalMatrix();
            System.out.print(a.printMatrix());
            System.out.print("      ×      ");
            System.out.print(b.printMatrix());
            twoDimensionalMatrix c=a.MultiplyTwoDimensionalMatrix(b);
            if(null==c){
                System.out.println("这两个矩阵不满足相乘条件");
            }
            else{
                System.out.println("    ||   ");
                System.out.println(c.printMatrix());
            }
        }
        else if(read.contains("3")){
            twoDimensionalMatrix a=new twoDimensionalMatrix((int)(Math.random()*10),(int)(Math.random()*10));
            a.initializetwoDimensionalMatrix();
            System.out.println(a.printMatrix());
            Scanner sc=new Scanner(System.in);
            System.out.print("随机二维矩阵已经生成，是否导出为序列化文件?Y/N\n");
            String read1;
            String name=read.split(" ")[1];
            if((read1=sc.nextLine()).toUpperCase().contains("Y")) {
                try{
                ObjectOutputStream obs=new ObjectOutputStream(new FileOutputStream(name+".txt"));
                obs.writeObject(a);
                    System.out.println(name+"对象序列化成功！");
            } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
        else if(read.contains("4")){
            try {
                String name=read.split(" ")[1];
                ObjectInputStream obis = new ObjectInputStream(new FileInputStream(name+".txt"));
                twoDimensionalMatrix d = (twoDimensionalMatrix) obis.readObject();
                System.out.println("该对象的元素为"+d.printMatrix());
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

}
