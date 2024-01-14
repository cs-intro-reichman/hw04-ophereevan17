public class StringOps {
    ////////////////////////////////////////////////////////////
    //////                                               ///////
    //////              Reminder:                        ///////
    //////        allowed methods                        ///////
    //////                                               ///////
    //////        1.charAt(int index)                    ///////
    //////        2.length()                             ///////
    //////        3.substring(int start)                 ///////
    //////        4.substring(int start,int ends)        ///////
    //////        5.indexOf(String str)                  ///////
    //////                                               ///////
    //////        The rest are not allowed !             ///////
    //////        if you want to use a different         ///////
    //////        method, and you can implement          ///////
    //////        it using material from the course      ///////
    //////        you need to implement a version of     ///////
    //////        the function by yourself.              ///////
    //////                                               ///////
    //////        see example for substring              ///////
    //////        in Recitation 3 question 5             ///////
    //////                                               ///////
    ////////////////////////////////////////////////////////////
    public static void main(String[] args) {
        String string = "Hello World";
        System.out.println(capVowelsLowRest(string));
        System.out.println(capVowelsLowRest(string));
    }

    public static String capVowelsLowRest (String string)
    {
        String str = "";
        char ch;
        for(int i = 0; i < string.length(); i++)
        {
            ch = string.charAt(i);
            if((ch >= 65) && (ch <= 90))
            {
                if(ch != 'A' && ch != 'E' && ch != 'I' && ch != 'O' && ch!= 'U') ch = (char)(ch + 32); //if char isnt uppercase vowel to change to lowercase
            }
            else
            {
                if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') ch = (char)(ch - 32); //if char is lowercase vowel to change to uppercase
            }
            str = str + ch;
        }
        return str;
    }

    public static String camelCase (String string)
    {
        String string2 = "";
        char ch;
        int i = 0;
        boolean flag = false;
        while((i < string.length()) && (flag == false))
        {
            ch = string.charAt(i);
            if(ch != 32) //runs for everything that isnt a space
            {
                if((ch >= 65) && (ch <= 90)) //if uppercase letter
                {
                    ch = (char)(ch + 32); //change to lowercase
                }
                string2 = string2 + ch;
                if((i + 1) < string.length())
                {
                    if((ch != 32) && (string.charAt(i + 1) == 32)) flag = true; //first word has ended
                }
            }
            i++;
        }
        while(i < string.length())
        {
           ch = string.charAt(i);
           if(ch != 32)
           {
                if(string.charAt(i - 1) == 32) //i is letter place, check if there was a space before i (new word).
                {
                    if((ch >= 97) && (ch <= 122))
                    {
                        ch = (char)(ch - 32);
                    }
                }
                else
                {
                    if((ch >= 65) && (ch <= 90))
                    {
                        ch = (char)(ch + 32);
                    }
                }
                string2 = string2 + ch;
           }
           i++;
        }
        return string2;

    }
    public static int[] allIndexOf (String string, char chr)
    {
        int count = 0;
        for(int i = 0; i < string.length(); i++)
        {
            if(string.charAt(i) == chr) count++; //number of places in new array
        }
        int[] array = new int[count]; //builds array
        int f = 0;

        for(int j = 0; j < string.length(); j++)
        {
            if(string.charAt(j) == chr) 
            {
                array[f] = j; //plugs j (place of chr) into new array
                f++;
            }
        }
        return array;
    }
}