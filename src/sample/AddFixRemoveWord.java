package sample;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class AddFixRemoveWord {
    private String patch;

    public AddFixRemoveWord(String patch) {
        this.patch = patch;
    }

    public void AddWordAction(ArrayList<String> list)
    {
        String newWord = "@"+list.get(0)+" /"+list.get(1)+"/\n*"+list.get(2)+"\n";
        for(int i=3;i<list.size();i++)
        {
            newWord+="-"+list.get(i)+"\n";
        }
        try
        {
            FileOutputStream fos = new FileOutputStream(patch,true);
            OutputStreamWriter osw = new OutputStreamWriter(fos,"UTF-8");
            BufferedWriter bw = new BufferedWriter(osw);
            bw.write(newWord);
            bw.close();
            osw.close();
            fos.close();
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }

    public void FixOrRemoveWordAction(String wordNeedFixing,String fixedWord) {
        Scanner scan;
        File tempFile = new File("tempFile.txt");
        File oldFile = new File(patch);
        String line;
        try {
            FileOutputStream fos = new FileOutputStream(tempFile);
            OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
            BufferedWriter bw = new BufferedWriter(osw);
            scan = new Scanner(new File(patch));
            while (scan.hasNextLine()) {
                line = scan.nextLine();
                if (line.length() == 0)
                    continue;
                else {
                    if (line.charAt(0) == '@') {

                        if (line.trim().contains(wordNeedFixing)) {
                            bw.write(fixedWord);
                            bw.newLine();
                            line=scan.nextLine();
                            while (line.charAt(0) != '@')
                            {
                                if(scan.hasNextLine())
                                    line=scan.nextLine();
                                else
                                    break;
                                if(line.length()==0)
                                    continue;
                            }

                        }
                        else {
                            bw.write(line);
                            bw.newLine();
                        }
                    }
                    else {
                        bw.write(line);
                        bw.newLine();
                    }
                }
            }
                bw.close();
                osw.close();
                fos.close();
                scan.close();
                oldFile.delete();
                File dump = new File(patch);
                tempFile.renameTo(dump);
        }
        catch(Exception ex)
            {
                ex.printStackTrace();
            }
    }
}
