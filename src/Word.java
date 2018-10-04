public class Word {
    private String word_target ;
    private String word_explain;

    Word() {
    }

    //Hàm tạo và lấy từ mới
    public String getWord_target() {
        return word_target;
    }

    public void setWord_target(String word_target) {
        this.word_target = word_target;
    }

    //Hàm tạo và lấy nghĩa của từ
    public String getWord_explain() {
        return word_explain;
    }

    public void setWord_explain(String word_explain) {
        this.word_explain = word_explain;
    }
}
