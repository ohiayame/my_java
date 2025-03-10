package oop.lab;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class FileLoader{
    private String filePath;
    private String fileContent = "";

    // 생성자 (Parameter Constructor)
    FileLoader(String filePath){
        this.filePath = filePath;
        loadFile();
    }

    // 파일을 읽어서 내용 저장
    private void loadFile(){
        try(BufferedReader br = new BufferedReader(new FileReader(filePath))){
            String line;
            while ((line = br.readLine()) != null){
                fileContent += line + "\n";
            }
            System.out.println("file load completed");
        }catch (IOException e){
            System.out.println("file load failed:" + e.getMessage());
        }
    }
    // 출력
    void printFileContent(){
        System.out.println("file:\n" + fileContent);
    }

}

public class lab1_310 {
    public static void main(String[] args) {
        FileLoader fileLoader = new FileLoader("sample.txt");
    //  FileLoader fileLoader = new FileLoader(); Default constructor는 정의 되지 않았기 때문에 에러
        fileLoader.printFileContent();
    }
}
