package mainPackage;

import java.io.*;
import java.util.Scanner;

public class BugFixer
{
    static String readDir = "D:\\Project\\Bug fixer\\src\\Datasets", writeDir="D:\\Project\\Bug fixer\\src\\results";

    public static void main(String[] args)
    {
        processFolder(readDir, writeDir);
    }

    public static void processFolder(String readDir, String writeDir)
    {
        try {
            //while()
            File file = new File(readDir);
            File[] files = file.listFiles();
            int counter=1;

            for(File f:files)
            {
                if(f.isDirectory())
                    processSingleFile(readDir,writeDir,f.getName());
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void processSingleFile(String readDestination, String writeDestination, String folderName) throws IOException {
        File file;
        FileReader fr;
        BufferedReader br;

        //System.out.println(folderName);

        File folder = new File(readDestination+"\\"+folderName+"\\Solutions");
        int numberOfFiles = (int)folder.listFiles().length;

        //System.out.println(numberOfFiles);

        for(int i=1;i<=numberOfFiles;i++)
        {
            file = new File(readDestination + "\\"+ folderName+"\\Solutions\\" + i+".txt");
            //System.out.println(file.getAbsolutePath());
            fr = new FileReader(file);
            br = new BufferedReader(fr);

            int lineNumber;

            lineNumber = Integer.parseInt(br.readLine());

            file = new File(readDestination + "\\" + folderName+ "\\Tasks\\" + i+".txt");
            fr = new FileReader(file);
            br = new BufferedReader(fr);

            String correctLine = br.readLine();

            File outFol1 = new File(writeDestination + "\\bugged\\" + folderName );
            if(!outFol1.exists())outFol1.mkdir();

            File output1 = new File(writeDestination + "\\bugged\\" + folderName + "\\" + i+".txt");
            FileWriter fw1 = new FileWriter(output1);
            BufferedWriter bw1 = new BufferedWriter(fw1);

            File outFol2 = new File(writeDestination + "\\solutions\\" + folderName );
            if(!outFol2.exists())outFol2.mkdir();

            File output2 = new File(writeDestination + "\\solutions\\" + folderName + "\\" +i+ ".txt");
            FileWriter fw2 = new FileWriter(output2);
            BufferedWriter bw2 = new BufferedWriter(fw2);

            String currentLine;

            br.readLine();

            int count = 3;

            while((currentLine = br.readLine())!=null)
            {
                bw1.write(currentLine+"\n");
                if(count==lineNumber+2)
                {
                    bw2.write(correctLine+"\n");
                }
                else bw2.write(currentLine+"\n");

                count++;
            }

            bw1.flush();
            bw2.flush();

            br.close();
            bw1.close();
            bw2.close();
        }

    }
}
