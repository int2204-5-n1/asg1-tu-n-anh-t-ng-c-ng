import java.util.Set;

public class DictionaryCommandline {

    DictionaryManagement dic_manage_ = new DictionaryManagement();

    /*
    Hàm in ra dictionary
     */
    public void showAllWords(){
        System.out.println("No\t| English\t| Vietnamese");

        Set<String> set = dic_manage_.dictionary_.word_.keySet();
        int i = 1;
        for (String key : set) {
            System.out.println(i + "\t| " + key + "\t| " + dic_manage_.dictionary_.word_.get(key));
            ++i;
        }

    }

    public void dictionaryBasic(){
        dic_manage_.insertFromFile();
        showAllWords();
    }

    public void dictionaryAdvanced(){
        dic_manage_.insertFromFile();
        showAllWords();
        dic_manage_.dictionaryLookup();
    }

    public void dictionarySearcher(){}
}
