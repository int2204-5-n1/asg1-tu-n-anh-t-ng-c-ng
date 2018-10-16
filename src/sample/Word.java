package sample;

import java.io.*;
import java.util.ArrayList;

public class Word {

    private String patch = "";

    public
    Word(String patch) {
        this.patch = patch;
    }

    public
    Word() {
    }

    public ArrayList<String> creatWordList() {
        ArrayList<String> wordList = new ArrayList<>();

        try {
            File file = new File(patch);
            BufferedReader br = new BufferedReader(new FileReader(file));

            String line = null;
            while ((line = br.readLine()) != null) {
                if (line.length() == 0) continue;
                else {
                    if (line.charAt(0) == '@') {
                        String considerWord = "";
                        int i = 1;
                        while (i < line.length() && line.charAt(i) != '/') {
                            considerWord += line.charAt(i);
                            i++;
                        }
                        wordList.add(considerWord.trim());
                    }
                }
            }

            br.close();
        } catch (FileNotFoundException e) {
            System.out.println("Lấy từ điển có vấn đề");
        } catch (IOException e) {
            System.out.println("Lấy từ điển có vấn đề");
        }

        return wordList;
    }

    public String getWord(String name) {
        String word = "";
        try {
            File file = new File(patch);
            BufferedReader br = new BufferedReader(new FileReader(file));

            String line = null;
            boolean getWord = false;
            while ((line = br.readLine()) != null) {
                if (line.length() == 0) continue;
                else {
                    if (getWord) {
                        if (line.charAt(0) == '@') break;
                        else {
                            word += line + "\n";
                        }
                    } else {
                        if (line.charAt(0) == '@') {
                            if (line.contains(name)) {
                                getWord = true;

                            }
                        }
                    }
                }
            }

            br.close();
        } catch (FileNotFoundException e) {
            System.out.println("Tra từ điển có vấn đề");
        } catch (IOException e) {
            System.out.println("Tra từ điển có vấn đề");
        }
        return word.trim();
    }

    public String getPronounce(String name)
    {
        String Pronounce = "";
        try {
            File file = new File(patch);
            BufferedReader br = new BufferedReader(new FileReader(file));

            String line = null;
            boolean getPronounce = false;
            while ((line = br.readLine()) != null) {
                if (line.length() == 0) continue;
                else {
                    if(line.contains(name))
                    {
                        break;
                    }

                }
            }
            for (int i =line.indexOf('/') + 1 ; i < line.lastIndexOf('/');i++)
            {
                Pronounce+=line.charAt(i);
            }

            br.close();
        } catch (FileNotFoundException e) {
            System.out.println("Tra từ điển có vấn đề");
        } catch (IOException e) {
            System.out.println("Tra từ điển có vấn đề");
        }
        return Pronounce.trim();
    }
}
