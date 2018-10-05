import java.io.File;
import java.util.Scanner;

public class DictionaryManagement {
    public Dictionary dictionary_ = new Dictionary();
    /*
    Hàm thêm từ vào dictionary
     */
    public void insertFromCommandline() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Số lượng từ vựng: ");
        int n;                  //Số lượn từ vựng
        n = scan.nextInt();
        scan.nextLine();        //Để bỏ qua lệnh enter sau khi nhập n
        /*
        chạy for từ 1->n để nhập Word
         */
        for (int i = 0; i < n; ++i) {
            System.out.print("English: ");
            String word = scan.nextLine();
            System.out.print("Vietnamese: ");
            String explain = scan.nextLine();
            Word tmp = new Word(word, explain);
            dictionary_.word_.add(tmp);
        }
    }

    /*
    Hàm nhập từ bằng file
    */
    public void insertFromFile(){
        File file_input = new File("dictionaries.txt");     // khai bao file
        try {                                                        // tu search cai khoi lenh try catch nhe;

            Scanner scanFile = new Scanner(file_input);

            while (scanFile.hasNext()) {                            // trong khi con dong de doc
                String str;
                str = scanFile.nextLine();                          // nhap tu file vao string
                String[] word = str.split("\t");
                /*
                phuong thuc split dung de tach mot chuoi String ngan cach nhau boi dau tab "\t"
                o trong file tren 1 dong no co 1 dau tab nen no se tach thanh 2 cai string va tu
                dong luu vao trong mang [] word, word gio co 2 phan tu gom word[0] = english
                va word[1] = vietnamese
                 */
                Word temp = new Word(word[0], word[1]);
                dictionary_.word_.add(temp);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void dictionaryLookup(){

    }
}
