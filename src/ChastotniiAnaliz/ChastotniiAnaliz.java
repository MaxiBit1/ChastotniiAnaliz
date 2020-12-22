package ChastotniiAnaliz;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class ChastotniiAnaliz {
    private static String alphavite="абвгдежзийклмнопрстуфхцчшщъыьэюя";
    private static char[] Alphavet=alphavite.toCharArray();
    private static String titleWords = "АБВГДЕЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ";
    private static char[] Title=titleWords.toCharArray();
    private static String punct=".,?!—; ";
    private static char[] punctuation = punct.toCharArray();
    private static String numbers="1234567890";
    private static char[] numbersArray=numbers.toCharArray();
    private static LinkedList<Character> EnglishW = new LinkedList<>();
    private static Map<Character,Character> ChezarMap=new HashMap<>();
    private static Map<Character,Character> chezarBig=new HashMap<>();
    private static Map<Character,Integer> word=new HashMap<>();
    private static Map<Character,Integer> word1=new HashMap<>();
    private static Map<Character,Integer> wordBig=new HashMap<>();
    private static Map<Character,Integer> wordBig1=new HashMap<>();
    private static String result="";
    private static String str;

    public ChastotniiAnaliz(String str){this.str=str;}

    public String Shifrovanie(String str1){
        String englishWords= "abcdefghijklmnopqrstuvwxyABCDEFGHIJKLMNOPQRSTUVWXY";
        char[] NewAplabeth = ShifrChezara.Preobrasovanie(5);
        char[] EnglishWor=englishWords.toCharArray();
        char[] str2=str1.toCharArray();
        char[] NewString=new char[str1.length()];
        char[] NewTitle = ShifrChezara.PreobrasovanieBig(5);
        int a=0;
        int i=0;
        int b=0;
        int r=0;
        int j=0;
        int w=0;
        while(r<EnglishWor.length){
            char bukv = EnglishWor[r];
            EnglishW.add(bukv);
            r++;
        }
        while(a<Alphavet.length){
            ChezarMap.put(Alphavet[a],NewAplabeth[i]);
            a++;
            i++;
        }
        while(j< Title.length){
            chezarBig.put(Title[j],NewTitle[w]);
            j++;
            w++;
        }
        for(int c=0;c< str2.length;c++) {
            for (Map.Entry<Character, Character> item : ChezarMap.entrySet()) {
                if (str2[c]==item.getKey()) {
                    NewString[b] = item.getValue();
                    b++;
                    break;
                }
            }
            for (Map.Entry<Character, Character> plus : chezarBig.entrySet()) {
                if (str2[c]==plus.getKey()) {
                    NewString[b] = plus.getValue();
                    b++;
                    break;
                }
            }
            for (char l:EnglishW) {
                if (str2[c]==l) {
                    NewString[b] = str2[c];
                    b++;
                    break;
                }
            }
            for (int t=0;t< punctuation.length;t++){
                if(str2[c]==punctuation[t]) {
                    NewString[b] = str2[c];
                    b++;
                    break;
                }
            }
            for (int t=0;t< numbersArray.length;t++){
                if(str2[c]==numbersArray[t]) {
                    NewString[b] = str2[c];
                    b++;
                    break;
                }
            }
        }
        result=String.valueOf(NewString);
        return result;
    }

    public void Podchet(Map <Character,Integer> word, char[] Alphavet,String str){
        int Count=0;
        int a=0;
        while (a<Alphavet.length){
            word.put(Alphavet[a],Count);
            a++;
        }
        char[] Words=str.toCharArray();
        for(int j=0;j<Words.length;j++){
            for(Map.Entry<Character, Integer>  map:word.entrySet()){
                if(Words[j]==map.getKey()){
                    if(word.get(map.getKey())!=0){
                        Count=word.get(map.getKey());
                    }
                    Count+=1;
                    word.put(map.getKey(),Count);
                    break;
                }
            }
            Count=0;
        }
        for(Map.Entry<Character, Integer>  map2:word.entrySet()){
            System.out.println("Key: "+map2.getKey()+" Value: "+map2.getValue());
        }
    }

    public char[] Tablicha(Map<Character,Integer> word){
        char[] arrayKeys=new char[word.size()];
        char Temp;
        int b=0;
        while(b<arrayKeys.length){
            for(Map.Entry<Character,Integer> map: word.entrySet()){
                arrayKeys[b]= map.getKey();
                b++;
            }
        }
        for (int i = 1; i < arrayKeys.length; i++) {
            for (int j = 0; j < arrayKeys.length-1; j++) {
                if (word.get(arrayKeys[i]) > word.get(arrayKeys[j])) {
                    Temp = arrayKeys[i];
                    arrayKeys[i] = arrayKeys[j];
                    arrayKeys[j] = Temp;
                }
            }
        }
        return arrayKeys;
    }

    public String obratnoePreobrazovanie() {
        String str2;
        char[] OldString = new char[result.length()];
        int b = 0;
        int i = 0;
        int range;
        System.out.println("---------------------------Podshet---------------------------");
        Podchet(word,Alphavet,str);
        System.out.println("---------------------------PodshetBig------------------------");
        Podchet(wordBig,Title,str);
        System.out.println("---------------------------PodshetShifr----------------------");
        Podchet(word1,Alphavet,result);
        System.out.println("---------------------------PodshetShifrBig-------------------");
        Podchet(wordBig1,Title,result);
        char[] arrayKeys=Tablicha(word);
        char[] arrayKeys1=Tablicha(word1);
        char[] arrayKeysBig=Tablicha(wordBig);
        char[] arrayKeysBig1=Tablicha(wordBig1);
        while (b < result.length()) {
            range = b + 1;
            String strint = result.substring(b, range);
            char[] strint1 = strint.toCharArray();
            for (Map.Entry<Character, Integer> map2 : word1.entrySet()) {
                if (strint1[0] == map2.getKey()) {
                    for (int a=0;a<arrayKeys1.length;a++){
                        if(map2.getKey()==arrayKeys1[a]){
                            for (int j=0;j<arrayKeys.length;j++){
                                if(a==j){
                                    OldString[i] = arrayKeys[j];
                                    i++;
                                    break;
                                }
                            }
                        }
                    }
                    break;
                }
            }
            for (char l : EnglishW) {
                if (strint1[0] == l) {
                    OldString[i] = strint1[0];
                    i++;
                    break;
                }
            }
            for (int t = 0; t < punctuation.length; t++) {
                if (strint1[0] == punctuation[t]) {
                    OldString[i] = strint1[0];
                    i++;
                    break;
                }
            }
            for (Map.Entry<Character, Integer> map2 : wordBig1.entrySet()) {
                if (strint1[0] == map2.getKey()) {
                    for (int a=0;a<arrayKeysBig1.length;a++){
                        if(map2.getKey()==arrayKeysBig1[a]){
                            for (int j=0;j<arrayKeysBig.length;j++){
                                if(a==j){
                                    OldString[i] = arrayKeysBig[j];
                                    i++;
                                    break;
                                }
                            }
                        }
                    }
                    break;
                }
            }
            for (int t=0;t< numbersArray.length;t++){
                if (strint1[0] == numbersArray[t]) {
                    OldString[i] = strint1[0];
                    i++;
                    break;
                }
            }
            b++;
        }
        str2=String.valueOf(OldString);
        System.out.println("Преобразованный текст: "+str2);
        return str2;
    }
}