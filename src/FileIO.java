import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileIO {
    public static List<String> readFile(String path) throws IOException {
        FileReader fileReader=null;
        BufferedReader bufferedReader=null;
        List<String> strs=new ArrayList<>();
        try{
            fileReader=new FileReader(path);
            bufferedReader=new BufferedReader(fileReader);
            try{
                String read=null;
                while((read=bufferedReader.readLine())!=null){
                    strs.add(read);
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            if(bufferedReader!=null){
                bufferedReader.close();
            }
            if(fileReader!=null){
                fileReader.close();
            }
        }
        return strs;
    }

    public static void writeFile(String path,List<String> strs) throws IOException {
        FileWriter fileWriter=new FileWriter(path);
        BufferedWriter writer=new BufferedWriter(fileWriter);
        for(String s:strs){
            writer.write(s);
            writer.newLine();
        }
    }
}
