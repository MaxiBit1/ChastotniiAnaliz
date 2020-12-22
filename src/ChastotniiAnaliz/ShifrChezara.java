package ChastotniiAnaliz;

public class ShifrChezara {
    public static char[] Preobrasovanie(int a){
        char[] result;
        String alphavite="абвгдежзийклмнопрстуфхцчшщъыьэюя";
        String alphaviteEnd=alphavite.substring(0,a);
        String aphaviteStart=alphavite.substring(a);
        String NewAlphavite=aphaviteStart+alphaviteEnd;
        result=NewAlphavite.toCharArray();
        return result;
    }

    public static char[] PreobrasovanieBig(int a){
        char[] result;
        String alphavite="АБВГДЕЖЗИЙКЛМНОПРСТКФХЦЧШЩЪЫЬЭЮЯ";
        String alphaviteEnd=alphavite.substring(0,a);
        String aphaviteStart=alphavite.substring(a);
        String NewAlphavite=aphaviteStart+alphaviteEnd;
        result=NewAlphavite.toCharArray();
        return result;
    }
}
