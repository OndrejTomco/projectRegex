import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {

        String fileName = "rawText.txt";

        String line = null;

        try {
            FileReader fileReader =
                    new FileReader(fileName);

            BufferedReader bufferedReader =
                    new BufferedReader(fileReader);

            File file1 = new File("SPZ.txt");
            FileWriter fw1 = new FileWriter(file1);

            File file2 = new File("RC.txt");
            FileWriter fw2 = new FileWriter(file2);

            File file3 = new File("MAC.txt");
            FileWriter fw3 = new FileWriter(file3);

            while((line = bufferedReader.readLine()) != null) {
                int i;
                String[] words = line.split(" ");

                for(i=0;i<words.length;i++){
                    String patternSpz = "^(B(A|B|C|J|L|N|R|S|Y)|CA|D(K|S|T)|G(A|L)|H(C|E)|IL|K(A|I|E|K|M|N|S)|L(E|C|M|V)|M(A|I|L|T|Y)|N(I|O|M|R|Z)|P(B|D|E|O|K|N|P|T|U|V)|R(A|K|S|V)|S(A|B|C|E|I|K|L|O|N|P|V)|T(A|C|N|O|R|S|T|V)|V(K|T)|Z(A|C|H|I|M|V))([ ]{0,1})([0-9]{3})([A-Z]{2})$";
                    Pattern spz = Pattern.compile(patternSpz);
                    Matcher m1 = spz.matcher(words[i]);

                    String patternRC = "^([0-9]{2})(01|02|03|04|05|06|07|08|09|10|11|12|51|52|53|54|55|56|57|58|59|60|61|62)(([0]{1}[1-9]{1})|([1-2]{1}[0-9]{1})|([3]{1}[0-1]{1}))/([0-9]{3,4})$";
                    Pattern rc = Pattern.compile(patternRC);
                    Matcher m2 = rc.matcher(words[i]);

                    String patternMac = "([0-9A-F]{2}[:-]){5}([0-9A-F]{2})";
                    Pattern mac = Pattern.compile(patternMac);
                    Matcher m3 = mac.matcher(words[i]);

                    if (m1.find()){

                        fw1.write(words[i] + String.format("%n"));

                    }

                    if (m2.find()){

                        fw2.write(words[i] + String.format("%n"));

                    }

                    if (m3.find()){
                        fw3.write(words[i] + String.format("%n"));

                    }
                }


                i++;


            }

            fw1.flush();
            fw1.close();
            fw2.flush();
            fw2.close();
            fw3.flush();
            fw3.close();

            bufferedReader.close();
        } catch(IOException ex) {
            System.out.println(
                    "Error reading file '"
                            + fileName + "'");
        }
    }

}