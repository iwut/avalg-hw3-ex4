import java.io.BufferedWriter;


        import java.io.BufferedWriter;
        import java.io.File;
        import java.io.FileWriter;
        import java.io.IOException;
        import java.util.ArrayList;
        import java.util.Random;


public class Main {

    public static void main(String[] args) {

        int digitsLength = 1000000;

        double[] probabilities1 = {(1.0/10.0), (1.0/10.0), (1.0/10.0), (1.0/10.0), (1.0/10.0), (1.0/10.0), (1.0/10.0), (1.0/10.0), (1.0/10.0), (1.0/10.0)};
        double[] probabilities2 = {(1.0/2.0), (1.0/18.0), (1.0/18.0), (1.0/18.0), (1.0/18.0), (1.0/18.0), (1.0/18.0), (1.0/18.0), (1.0/18.0), (1.0/18.0)};
        double[] probabilities3 = {(3.0/20.0), (3.0/20.0), (3.0/20.0), (3.0/20.0), (3.0/20.0), (1.0/20.0), (1.0/20.0), (1.0/20.0), (1.0/20.0), (1.0/20.0)};

        doStuff(probabilities1, digitsLength);
        doStuff(probabilities2, digitsLength);
        doStuff(probabilities3, digitsLength);
    }

    public static void doStuff(double[] probabilities, int digitsLength) {
        Random r = new Random(System.currentTimeMillis());

        StringBuilder stringBuilder = new StringBuilder(" ");

            double prob = 0;
        for(int x = 0; x<10; x++){
            prob = probabilities[x];


            for (int i = 0; i < prob*digitsLength; i++) {
                stringBuilder.insert((int)(r.nextDouble()*stringBuilder.length()), "" + x);
            }

        }

        String b1str = stringBuilder.toString().replaceAll(" ", "");




        try{
            writeToFile("/users/galgazur/Desktop/file1.txt", b1str);

        }catch(Exception e){

        }

    }

    public static void writeToFile(String path, String text) throws IOException{
        File file = new File(path);

        if (!file.exists()) {
            file.createNewFile();
        }

        FileWriter fw = new FileWriter(file.getAbsoluteFile());
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(text);
        bw.close();


        System.out.println("File generation complete.");
    }

}