import ChastotniiAnaliz.ChastotniiAnaliz;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws IOException {
        ChastotniiAnaliz ch=new ChastotniiAnaliz(readingProgram("D:\\Download\\voina_i_mir.txt"));
        String str1=ch.Shifrovanie(readingProgram("D:\\Download\\ChapterVoina_i_Mir.txt"));
        System.out.println(str1);
        ch.obratnoePreobrazovanie();
    }
    private static String readingProgram(String path) throws IOException{
        String value="";
        FileReader fileReader=new FileReader(path);
        Scanner SC=new Scanner(fileReader);
        while (SC.hasNext()){
            value+=SC.nextLine();
        }
        SC.close();
        fileReader.close();
        return value;
    }
}
