import java.io.*;

/**
 * @Author xhy
 * @Date 2023/5/9 17:52
 * @description: 文件读取的类,java作业
 * @Title: readfiles
 * @Package PACKAGE_NAME
 */


/**
 * 文件交换就是change
 */
class Change{
    /**
     * 打开文件把arry数组的数据写到文件中去
     * DoubleSize的意思是Double类型的数据字节数为8
     */
    final static int DoubleSize=8;

    public void getwrite() throws IOException {
        FileOutputStream fos;
        byte arry[]={1,5,9,3,5,7,2,6,8,4};
        fos = new FileOutputStream("test文件.txt");
        for (int i=0;i<arry.length;i++){
                fos.write(arry[i]);
        }
        fos.close();
    }


    /**
     * 读取文件的信息
     * @throws IOException
     */
    public void getread() throws IOException {
        FileInputStream fis;
        fis = new FileInputStream("test文件.txt");
        int value;
        while ((value=fis.read())!=-1){
            System.out.print(value+" ");
        }
        fis.close();
    }

    /**
     * 打开文件顺序存储数据
     * @throws IOException
     */
    public void towrite() throws IOException {
        FileWriter flr;
        flr = new FileWriter(".\\filetest.txt");
        char arr[]={'存','汉','字','用','这','个','标','识'};
        for (int i=0;i<arr.length;i++){
            flr.write(arr[i]);
        }
        flr.close();
    }

    /**
     * 打开文件读取文件的数据
     * @throws IOException
     */
    public void toread() throws IOException {
        FileReader fr;
        fr = new FileReader(".\\filetest.txt");
        int value;
        while ((value = fr.read()) != -1) {
            System.out.print((char) value);
        }
        fr.close();
    }

    /**
     * 随机文件读写
     * @throws IOException
     */
    public void randomFileTest(String filename) throws IOException {
        RandomAccessFile rf = new RandomAccessFile(filename, "rw");
        for (int i = 0; i < 5; i++) {
            rf.writeDouble(i * 10.0);
        }
        rf.seek(2 * DoubleSize);
        rf.writeDouble(110.001);
        rf.seek(0);
        for (int i = 0; i < 5; i++) {
            System.out.println("Value" + i + ":" + rf.readDouble());
        }
        rf.close();
    }
}


/**
 * @author xhy
 */
public class ReadFiles {
    public static void main(String[] args)  {
        Change c = new Change();
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("文件目录创建");
            c.getwrite();
        } catch (IOException e) {
            e.printStackTrace();

        }//文件异常的处理
        try {
            System.out.println("文件目录读取");
            c.getread();
            System.out.println(" \n");
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            System.out.println("顺序访问文件的数据写入");
            c.towrite();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            System.out.println("读取文件内容");
            c.toread();
            System.out.println(" \n");
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            System.out.println("输入一个文件的名字");
            String  filename =stdin.readLine();
            c.randomFileTest(filename);
        }catch (IOException e){
            System.out.println("找不到文件:"+e);
            e.printStackTrace();
        }
    }
}