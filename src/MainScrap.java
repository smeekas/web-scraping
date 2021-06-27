import java.util.Scanner;

public class MainScrap {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        System.out.println("1 for image scraping and 2 for wikipedia scraping");
        System.out.print("your choice : ");
        int choice=scan.nextInt();
        if(choice>2 && choice<1){
            System.out.println("try again.");
            return;
        }
        if(choice==1){
            ImageScraper img=new ImageScraper();
            img.scrap();
        }else{
            WikiScraper wiki=new WikiScraper();
            wiki.scrap();
        }

    }
}
