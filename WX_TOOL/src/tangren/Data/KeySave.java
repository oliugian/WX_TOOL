package tangren.Data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

public class KeySave {
	

    public static void writeFileByLines(String path,String key) {
    	  try{
          File file=new File(path);
          if(!file.exists())
              file.createNewFile();
          FileOutputStream out=new FileOutputStream(file,false); //���׷�ӷ�ʽ��true        
          StringBuffer sb=new StringBuffer();
          sb.append(key);
          out.write(sb.toString().getBytes("utf-8"));//ע����Ҫת����Ӧ���ַ���
          out.close();
          }
          catch(IOException ex)
          {
              System.out.println(ex.getStackTrace());
          }
    
    }
    public static String readFileByLines(String fileName) {
        File file = new File(fileName);
        BufferedReader reader = null;
        StringBuffer sb=new StringBuffer();
        try {
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
         
            int line = 1;
            // һ�ζ���һ�У�ֱ������nullΪ�ļ�����
            while ((tempString = reader.readLine()) != null) {
              
                sb.append(tempString);
                line++;
            }
            reader.close();
        } catch (IOException e) {
        	
            e.printStackTrace();
            return "";
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
            return sb.toString();
        }
        
    }
}
