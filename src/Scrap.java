import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.*;
import java.util.Scanner;

public class Scrap {
    public static void main(String[] args)  {

try{
    Scanner scan=new Scanner(System.in);
    System.out.print("enter topic name :");
    String topic=scan.nextLine().trim();
    topic=topic.replace(" ","_");

    System.out.print("enter abosulte path of directory :");

    String path=scan.nextLine();
    if(path.charAt(path.length()-1)!='/'){
        path=path+"/";
    }

    String uri="https://en.wikipedia.org/wiki/"+topic;
    Document doc=Jsoup.connect(uri).get();
    Elements ee=doc.getElementsByTag("p");
    System.out.println(ee.size());
    FileWriter fw=new FileWriter(path+"op.txt");
    int len= Math.min(ee.size(), 50);
    for(int i=0;i<len;i++){
        fw.write( ee.get(i).text());

    }
    System.out.println("Done!!");

}catch(Exception e){
    System.out.println(e);
    System.out.println("try again!");
}


    }
}
