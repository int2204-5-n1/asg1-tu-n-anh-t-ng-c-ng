public class DictionaryCommandline {

    DictionaryManagement dic_manage_ = new DictionaryManagement();

    /*
    Hàm in ra dictionary
     */
    public void showAllWords(){
        System.out.println("No\t| English\t| Vietnamese");

        for(int i=0;i<dic_manage_.dictionary_.word_.size();++i){
            System.out.println(i+1 + "\t| " + dic_manage_.dictionary_.word_.get(i).getWord_target() + "\t| " + dic_manage_.dictionary_.word_.get(i).getWord_explain());

        }

    }

    public void dictionaryBasic(){
        dic_manage_ .insertFromFile();
        showAllWords();
    }
}
