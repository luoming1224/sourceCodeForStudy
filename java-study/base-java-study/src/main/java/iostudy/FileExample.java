package iostudy;

import java.io.File;

public class FileExample {

    public static void main(String[] args) {
        File file = new File("/home/a1/IdeaProjects/exercise/java-study/base-java-study/src/main/java");
        if (file.exists()) {
            System.out.println("file exists!");
        }
        System.out.println("length: " + file.length());
        System.out.println("isDirectory: " + file.isDirectory());

        String[] fileNames = file.list();
        for (String fileName : fileNames ){
            System.out.println(fileName);
        }
    }
}
