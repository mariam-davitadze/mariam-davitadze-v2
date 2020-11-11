import org.apache.log4j.Logger;

import java.io.File;
import java.util.Scanner;


class LengthLogger extends Thread {
    @Override
    public void run() {
        super.run();
        while (true) {
            File file = new File("/home/mariam/Desktop/");
            System.out.println(file.listFiles().length);

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class Main {
    final static Logger logger = Logger.getLogger(Main.class);

    public static void fileFinder(File[] filesList, String inputedWord){
        for (File fileItem : filesList) {
            if (fileItem.getName().toLowerCase().startsWith(inputedWord.toLowerCase()))
                logger.info("მოიძებნა : " + fileItem.getName());
        }
        askForInput();
    }

    public static void askForInput(){
        System.out.println("შემოიტანე საძიებო სიტყვა: ");

        Scanner inputed = new Scanner(System.in);
        String inputedWord = inputed.nextLine();

        System.out.println("შემოტანილი სიტყვაა: " + inputedWord);

        File file = new File("/home/mariam/Desktop/");

        File[] files = file.listFiles();
        fileFinder(files, inputedWord);
    }

    public static void main(String[] args) {
        LengthLogger lengthLogger = new LengthLogger();
        lengthLogger.start();

        askForInput();
    }
}