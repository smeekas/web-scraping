import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
import java.net.URL;

public class Scrap {
    public static void main(String[] args) throws IOException {
        try {
            String uri="https://www.google.com/search?q=haikyu&sxsrf=ALeKk01ZbhGF1183dCY2M4F3R3rPDm3OiQ:1624022182573&source=lnms&tbm=isch&sa=X&ved=2ahUKEwiqn7KKoqHxAhVJ7HMBHTCIAx4Q_AUoAXoECAEQAw&biw=1536&bih=722";
            Document doc = Jsoup.connect(uri).get();
            Elements ee= doc.getElementsByTag("img");
            Elements ee2= doc.getElementsByClass("rg_i Q4LuWd");
            System.out.println(ee2.size());
                for(int i=0;i<ee2.size();i++) {
                    String tmp = null;
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
                    System.out.println(tmp);


                    URL url = new URL(tmp);
                    InputStream in = new BufferedInputStream(url.openStream());
                    OutputStream out = new BufferedOutputStream(new FileOutputStream("C:\\Users\\LENOVO\\Desktop\\images\\"+i+".jpg"));

                    for (int j; (j = in.read()) != -1; ) {
                        out.write(j);
                    }
                    in.close();
                    out.close();
                }
//            FileWriter fw = new FileWriter(output);
//            fw.write(trs.toString());

        }catch(Exception e){
            System.out.println(e);
        }


//
    }
}
