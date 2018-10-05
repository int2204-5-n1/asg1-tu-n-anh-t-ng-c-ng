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
        int n;                  //Số lượng từ vựng
        n = scan.nextInt();
        scan.nextLine();        //Để bỏ qua lệnh enter sau khi nhập n
        /*
        chạy for từ 1->n để nhập Word
         */
        for (int i = 0; i < n; ++i) {
            System.out.println("English: ");
            String word = scan.nextLine();
            System.out.println("Vietnamese: ");
            String explain = scan.nextLine();
            Word tmp = new Word(word, explain);
            dictionary_.word_.add(tmp);
        }
        scan.close();
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
                scanFile.close();
            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    /*
    Tìm kiếm nhị phân tìm kiếm từ khóa w
     */

    public int search(String w){
        int dau = 0;
        int cuoi = dictionary_.word_.size()-1;
        int giua ;

        while(dau<=cuoi){

            giua = dau + (cuoi - dau)/2;

            if(dictionary_.word_.get(giua).getWord_target().compareToIgnoreCase(w)==0) return giua;
            else {
                if(dictionary_.word_.get(giua).getWord_target().compareToIgnoreCase(w)<0){
                    dau = giua + 1;
                }
                else if(dictionary_.word_.get(giua).getWord_target().compareToIgnoreCase(w)>0){
                    cuoi = giua - 1;
                }
            }
        }
        return -1;
    }

    /*
    Viết hàm sắp xếp và thay đổi dictionaryLookup thành tìm kiếm nhị phân (Làm sau)
     */
    public void dictionaryLookup(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Tra cứu từ: ");
        String word_find = scan.nextLine();

        for(int i=0;i<dictionary_.word_.size();++i){
            if(dictionary_.word_.get(i).getWord_target().equalsIgnoreCase(word_find)){
                System.out.print("Nghĩa của từ: " + dictionary_.word_.get(i).getWord_explain() +"\n");
                break;
            }
        }
    }


    /*
    Hàm thêm từ
     */
    public void addWord(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Thêm từ: ");
        String word = scan.nextLine();
        System.out.println("Nghĩa của từ:");
        String explain = scan.nextLine();
        Word newWord = new Word(word,explain);
        dictionary_.word_.add(newWord);
    }

    /*
    Hàm xóa từ
     */
    public void removeWord(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Xóa từ:");
        String w_r = scan.nextLine();
        if (search(w_r)==-1) {
            System.out.println("Không tồn tại từ này");
            return;
        }
        int index = search(w_r);
        dictionary_.word_.remove(index);

    }

    /*
    Hàm sửa từ
     */
    public void editWord(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Nhập từ cần sửa:");
        String word_need_edit = scan.nextLine();
        if (search(word_need_edit)==-1){
            System.out.println("Không tồn tại từ này");
            return;
        }
        int index = search(word_need_edit);
        System.out.println("Sửa từ đó thành:");
        String word_edit = scan.nextLine();
        System.out.println("Nghĩa tiếng Việt:");
        String explain = scan.nextLine();
        Word tmp = new Word(word_edit,explain);
        dictionary_.word_.add(tmp);
    }


}
