import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.*;
import java.net.URL;
import java.util.Scanner;

public class ImageScraper {
   public void scrap(){
                try {
                    Scanner scan=new Scanner(System.in);
                    System.out.print("enter topic name :");
                    String topic=scan.nextLine().trim();
                    System.out.print("enter abosulte path of directory :");

                    String path=scan.nextLine();
//                    System.out.println(path);
                    if(path.charAt(path.length()-1)!='/'){
                        path=path+"/";
                    }
                    topic=topic.replace(" ","+");
//                    System.out.println(topic);
            String uri="https://www.google.com/search?q="+topic+"&sxsrf=ALeKk01ZbhGF1183dCY2M4F3R3rPDm3OiQ:1624022182573&source=lnms&tbm=isch&sa=X&ved=2ahUKEwiqn7KKoqHxAhVJ7HMBHTCIAx4Q_AUoAXoECAEQAw&biw=4000&bih=2000";

            Document doc = Jsoup.connect(uri).get();
            Elements ee2= doc.getElementsByTag("img");
//            Elements ee2= doc.getElementsByClass("rg_i Q4LuWd");
//            System.out.println(ee2.size());
                for(int i=0;i<ee2.size();i++) {
                    String tmp;
                    if(ee2.get(i).hasAttr("data-src")){
                         tmp = ee2.get(i).attr("data-src");
                    }else if(ee2.get(i).hasAttr("src")){
                        tmp=ee2.get(i).attr("src");

                    }else {
                        continue;
                    }
                    if(!tmp.startsWith("http")){
                        continue;
                    }
//                    System.out.println(ee2.get(i));
//                    System.out.println(tmp);


                    URL url = new URL(tmp);
                    InputStream in = new BufferedInputStream(url.openStream());
                    System.out.println("downloading "+i+".jpg");
                    OutputStream out = new BufferedOutputStream(new FileOutputStream(path+i+".jpg"));

                    for (int j; (j = in.read()) != -1; ) {
                        out.write(j);
                    }
                    in.close();
                    out.close();
                }
                    System.out.println("Downloaded!!");
//            FileWriter fw = new FileWriter(output);
//            fw.write(trs.toString());

        }catch(Exception e){
            System.out.println(e);
                    System.out.println("try again!");
        }
    }
}
