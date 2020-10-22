package 网络通信;

import org.junit.Test;

import java.io.*;
import java.net.*;

/**
 * @author: create by zhl
 * @version: v1.0
 * @description: 网络通信
 * @date:2020/10/22
 */
public class NetTest {

    /**
     * 网络
     *C:\Windows\System32\drivers\etc\hosts 更改ip为指定域名的文件
     * DNS域名服务解析器
     *
     * 端口号：正在计算机运行的进程
     * 要求：不同的进程有不同的端口号
     * 范围：被规定为一个16位的整数0-65535
     *
     * 端口号和ip地址的组合得出一个网络套接字：socket；
     */
    @Test
    public void test01(){
        try {
            InetAddress inetAddress=InetAddress.getByName("192.168.11.12");
            System.out.println(inetAddress);

            InetAddress byName = InetAddress.getByName("www.jd.com");
            System.out.println(byName);

            //获取本机
            InetAddress localHost = InetAddress.getLocalHost();
            System.out.println(localHost);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

    }
    /**
     * TCP协议：
     * 1、使用tcp协议前，须建立tcp连接，形成传输数据通道
     * 2、传输前，采用三次握手方式，点对点通讯是可靠的
     * 三次握手 服务端发送报文->客服端，客服端收到报文->发送给服务端报文->服务端收到报文，再次发送报文->服务端
     * 3、在连接中可进行大量数据传输
     * 4、传输完毕，需要释放建立的连接，效率低
     *像打电话
     * UDP协议：
     * 1、将数据、源、目的封装成数据包，不需要建立连接
     * 2、每个数据报的大小限制在64k内
     * 3、发送对方是否准备好，接受方收到也不确认，故是不可靠的
     * 4、可以广播发送
     * 5、发送数据时无需释放资源，开销小，速度快。
     *发送短信，播放视频
     */

    /**
     * 网络数据传输利用socket
     * client:
     * 1、创建socket对象
     * 2、获取一个输出流，
     * 3、写出输出数据
     *
     * server:
     * 1、创建服务端的serverSocket
     * 2、调用acsept()接受客服端的数据
     * 3、创建流读取数据
     * 4、利用ByteArrayOutputStream来把读取的数据存放过来，防止中文乱码、
     *       一个汉字占3个字节
     */
    @Test
    public void client(){

        Socket socket=null;
        OutputStream outputStream =null;
        try {
            InetAddress ip = InetAddress.getByName("127.0.0.1");
            socket=new Socket(ip,8005);
            outputStream = socket.getOutputStream();

            outputStream.write("123".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(outputStream !=null){
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(socket!=null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }


    }

    @Test
    public void server(){
        ByteArrayOutputStream byteArrayOutputStream= null;
        ServerSocket ss=null;
        Socket socket=null;
        InputStream fis=null;
        try {
            ss = new ServerSocket(8005);
            socket = ss.accept();
            fis = socket.getInputStream();
            byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bytes=new byte[5];
            int data;

            while ((data=fis.read(bytes))!=-1){
                byteArrayOutputStream.write(bytes,0,data);


            }
            System.out.println(socket.getInetAddress().getHostName()+":" +byteArrayOutputStream.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (byteArrayOutputStream!=null){
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(fis!=null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(socket !=null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(ss !=null){
                try {
                    ss.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 使用socket传输图片
     *
     *
     *
     */
    @Test
    public void client01() throws Exception{

        Socket socket = new Socket(InetAddress.getByName("127.0.0.1"), 9090);
        OutputStream inputStream = socket.getOutputStream();
        FileInputStream fileInputStream=new FileInputStream("E:\\Java_Basics\\src\\kobe.jpg");
        BufferedInputStream buf=new BufferedInputStream(fileInputStream);
        byte[] bytes=new byte[1024];
        int data;
        while ((data=buf.read(bytes))!=-1){
            inputStream.write(bytes,0,data);
        }
        buf.close();
        fileInputStream.close();
        inputStream.close();
        socket.close();


    }
    @Test
    public void server01() throws Exception{
        ServerSocket ss = new ServerSocket(9090);
        Socket accept = ss.accept();
        InputStream inputStream = accept.getInputStream();
        FileOutputStream fos=new FileOutputStream("E:\\Java_Basics\\src\\kobe1.jpg");
        BufferedOutputStream bufferedOutputStream=new BufferedOutputStream(fos);
        byte[] bytes= new byte[1024];
        int data;
        while ((data=inputStream.read(bytes))!=-1){
            bufferedOutputStream.write(bytes,0,data);
        }

        bufferedOutputStream.close();
        fos.close();
        accept.close();
        ss.close();



    }

    /**
     * 使用socket传输图片
     * 客服端收到反馈
     *
     * TCP传输协议：
     * 接受时用的 serverSocket().accept(); 在利用流来读写数据 加上一个ByteArrayOutputStream();
     * 把字节存入这个流中防止中文乱码
     *
     *在服务端写入数据时，因为close()是一个阻塞式的方法，客服端无法接受消息
     *
     */
    @Test
    public void client02() throws Exception{

        Socket socket = new Socket(InetAddress.getByName("127.0.0.1"), 9090);
        OutputStream outputStream = socket.getOutputStream();
        FileInputStream fileInputStream=new FileInputStream("E:\\Java_Basics\\src\\kobe1.jpg");
        BufferedInputStream buf=new BufferedInputStream(fileInputStream);
        byte[] bytes=new byte[1024];
        int data;
        while ((data=buf.read(bytes))!=-1){
            outputStream.write(bytes,0,data);
        }
        //服务端无法知道客服端传输图片说明时候完成，所以在客服端需要在图片写入完后手动关闭这个out

        socket.shutdownOutput();
        InputStream inputStream = socket.getInputStream();

        ByteArrayOutputStream byteArrayOutputStream=new ByteArrayOutputStream();
        byte[] bytes1=new byte[10];
        int data1;
        while ((data1=inputStream.read(bytes1)) != -1){
            byteArrayOutputStream.write(bytes1,0,data1);
        }
        System.out.println(byteArrayOutputStream.toString());
        buf.close();
        fileInputStream.close();
        inputStream.close();
        socket.close();


    }
    @Test
    public void server02() throws Exception{
        ServerSocket ss = new ServerSocket(9090);
        Socket socket = ss.accept();
        InputStream inputStream = socket.getInputStream();
        FileOutputStream fos=new FileOutputStream("E:\\Java_Basics\\src\\kobe2.jpg");
        BufferedOutputStream bufferedOutputStream=new BufferedOutputStream(fos);
        byte[] bytes= new byte[1024];
        int data;
        while ((data=inputStream.read(bytes))!=-1){
            bufferedOutputStream.write(bytes,0,data);
        }

        OutputStream outputStream = socket.getOutputStream();

        outputStream.write("我已经收到发的图片，很有纪念价值！！！".getBytes());

        outputStream.close();
        bufferedOutputStream.close();
        fos.close();
        socket.close();
        ss.close();



    }
    /**
     * UDP的网络通信协议：
     *
     * 用的socket是DatagramSocket() 接受和发送都是这样的
     *  DatagramPacket来封装数据的 send()和receive()发送接受消息
     *  DatagramPacket 获取数据方法 getData()、长度getLength();
     *
     */

    @Test
    public void send() throws  Exception{
        DatagramSocket socket=new DatagramSocket();
        String byt="hello";
        byte[] bytes = byt.getBytes();
        InetAddress localHost = InetAddress.getLocalHost();
        DatagramPacket datagramPacket=new DatagramPacket(bytes,0,bytes.length,localHost,9090);
        socket.send(datagramPacket);
        socket.close();


    }

    @Test
    public void res() throws Exception{
        DatagramSocket socket=new DatagramSocket(9090);
        byte[] bytes=new byte[100];
        DatagramPacket packet=new DatagramPacket(bytes,0,100);
        socket.receive(packet);

        System.out.println(new String(packet.getData(),0,packet.getLength()));
        socket.close();

    }

}
