/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TreeSet;

/**
 *
 * @author sbenza
 */
class Extractor {

    static void prodigal(String filePath) {
        try {
            FileReader file = new FileReader(filePath);
            BufferedReader buff = new BufferedReader(file);

//            String bestScore = "ERROR";
            String line = buff.readLine();
            String template = "#";

            String tline[];
            String relation = "SEQ_NUMBER;CONTIG_START;CONTIG_END\n";

            while (line != null) {
                if (!line.startsWith(template)) {
                    tline = line.split("\\t");
                    relation += tline[0] + ";" + tline[3] + ";" + tline[4] + "\n";
                }

                line = buff.readLine();
            }

            String relationFile = "ERelation.txt";
            FileWriter fstream = new FileWriter(relationFile);
            BufferedWriter out = new BufferedWriter(fstream);
            out.write(relation);
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    static void prodigal_nm(String filePath) {
        try {
            FileReader file = new FileReader(filePath);
            BufferedReader buff = new BufferedReader(file);

//            String bestScore = "ERROR";
            String line = buff.readLine();
            String template = "#";

            String tline[];
            String seqList = "SEQ_NUMBER\n";
            TreeSet<String> sequencesList = new TreeSet<String>();

            while (line != null) {
                if (!line.startsWith(template)) {
                    tline = line.split("\\t");
                                    if(sequencesList.contains(tline[0])==false){

                    seqList += tline[0] + "\n";
                    sequencesList.add(tline[0]);

                                    }
                }

                line = buff.readLine();
            }
            
            
            
            String seqFile = filePath+"_seq.txt";
            FileWriter fstream = new FileWriter(seqFile);
            BufferedWriter out = new BufferedWriter(fstream);
            out.write(seqList);
            out.close();
            String relation = "PRODIGAL_SEQ\n";
            relation +=  filePath+"_seq.txt\n";

            String relationFile = "ERelation.txt";
            fstream = new FileWriter(relationFile);
            out = new BufferedWriter(fstream);
            out.write(relation);
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    static void metagene(String filePath) {
        try {
            FileReader file = new FileReader(filePath);
            BufferedReader buff = new BufferedReader(file);

            String line = buff.readLine();
            String template = "#";

            String tline[];
            String relation = "SEQ_NUMBER;CONTIG_START;CONTIG_END\n";

            while (line != null) {
                if (!line.startsWith(template) && !line.isEmpty()) {
                    tline = line.split("\\t");
                    relation += tline[0] + ";" + tline[3] + ";" + tline[4] + "\n";
                }

                line = buff.readLine();
            }

            String relationFile = "ERelation.txt";
            FileWriter fstream = new FileWriter(relationFile);
            BufferedWriter out = new BufferedWriter(fstream);
            out.write(relation);
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    static void metagene_nm(String filePath) {
        try {
            FileReader file = new FileReader(filePath);
            BufferedReader buff = new BufferedReader(file);

            String line = buff.readLine();
            String template = "#";

            String tline[];
            String seqList = "SEQ_NUMBER\n";
            TreeSet<String> sequencesList = new TreeSet<String>();

            while (line != null) {
                if (!line.startsWith(template) && !line.isEmpty()) {
                    tline = line.split("\\t");
                    if(sequencesList.contains(tline[0])==false){

                        seqList += tline[0] +  "\n";
                        sequencesList.add(tline[0]);

                                    }
                }

                line = buff.readLine();
            }

            String seqFile = filePath+"_seq.txt";
            FileWriter fstream = new FileWriter(seqFile);
            BufferedWriter out = new BufferedWriter(fstream);
            out.write(seqList);
            out.close();
            String relation = "METAGENE_SEQ\n";
            relation +=  filePath+"_seq.txt\n";

            String relationFile = "ERelation.txt";
            fstream = new FileWriter(relationFile);
            out = new BufferedWriter(fstream);
            out.write(relation);
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    static void fraggene(String filePath) {
        try {
            FileReader file = new FileReader(filePath);
            BufferedReader buff = new BufferedReader(file);

            String line = buff.readLine();
            String template = ">";

            String tline[];
            String relation = "SEQ_NUMBER;CONTIG_START;CONTIG_END\n";

            while (line != null) {
                if (line.startsWith(template)) {
                    tline = line.split("_");

                    String seq = tline[0];

                    seq = (String) seq.substring(1);
                    relation += seq + "_" + tline[1] + ";" + tline[2] + ";" + tline[3] + "\n";
                }
                line = buff.readLine();
            }

            String relationFile = "ERelation.txt";
            FileWriter fstream = new FileWriter(relationFile);
            BufferedWriter out = new BufferedWriter(fstream);
            out.write(relation);
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    static void fraggene_nm(String filePath) {
        try {
            FileReader file = new FileReader(filePath);
            BufferedReader buff = new BufferedReader(file);

            String line = buff.readLine();
            String template = ">";

            String tline[];
            String seqList = "SEQ_NUMBER\n";
            TreeSet<String> sequencesList = new TreeSet<String>();

            while (line != null) {
                if (line.startsWith(template)) {
                    tline = line.split("_");

                    String seq = tline[0];

                    seq = (String) seq.substring(1);
                if(sequencesList.contains(seq + "_" + tline[1])==false){
                    seqList += seq + "_" + tline[1]  + "\n";
                    sequencesList.add(seq + "_" + tline[1]);
                    
                    }
                }
                line = buff.readLine();
            }

            String seqFile = filePath+"_seq.txt";
            FileWriter fstream = new FileWriter(seqFile);
            BufferedWriter out = new BufferedWriter(fstream);
            out.write(seqList);
            out.close();
            
            String relation = "FRAGGENE_SEQ\n";
            relation +=  filePath+"_seq.txt\n";

            String relationFile = "ERelation.txt";
            fstream = new FileWriter(relationFile);
            out = new BufferedWriter(fstream);
            out.write(relation);
            
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
    static void blast(String filePath) {
        try {
            FileReader file = new FileReader(filePath);
            BufferedReader buff = new BufferedReader(file);

            String line = buff.readLine();

            String tline[];
            String relation = "SEQ_NUMBER;PERC_IDENTITY;CONTIG_START;CONTIG_END;EVAL\n";

            while (line != null) {
                tline = line.split("\t");
                relation += tline[0] + ";" + tline[2] + ";" + tline[8] + ";" + tline[9] + ";" + tline[10] + "\n";
                line = buff.readLine();
            }

            String relationFile = "ERelation.txt";
            FileWriter fstream = new FileWriter(relationFile);
            BufferedWriter out = new BufferedWriter(fstream);
            out.write(relation);
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    static void blast_nm(String filePath) {
        try {
            FileReader file = new FileReader(filePath);
            BufferedReader buff = new BufferedReader(file);

            String line = buff.readLine();

            String tline[];
            String seqList = "SEQ_NUMBER\n";
            TreeSet<String> sequencesList = new TreeSet<String>();

            while (line != null) {
                tline = line.split("\t");
                if(sequencesList.contains(tline[0])==false){
                    seqList += tline[0] + "\n";
                    sequencesList.add(tline[0]);
                }
                line = buff.readLine();
            }

            String seqFile = filePath+"_seq.txt";
            FileWriter fstream = new FileWriter(seqFile);
            BufferedWriter out = new BufferedWriter(fstream);
            out.write(seqList);
            out.close();
            
            String relation = "BLAST_SEQ\n";
            relation +=  filePath+"_seq.txt\n";

            String relationFile = "ERelation.txt";
            fstream = new FileWriter(relationFile);
            out = new BufferedWriter(fstream);
            out.write(relation);
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
    static void pyfasta(String filePath, String number) {
        try {
            int n = Integer.parseInt(number);
            String file = filePath;
            //String[] parts = file.split("/");
            //String name = parts[-1];
            String relation = "SPLIT_FASTA_FILE\n";
            String new_i="";
            Integer dif=0;
            String zeros="";

            for (int i = 0; i < n; i++) {
                zeros="";
                new_i= Integer.toString(i);
                dif = number.length()-new_i.length();
                for (int j =0; j<dif;j++){
                    zeros+="0";
                }
                relation += file + "." + zeros  + i + "\n";
                //System.out.printf(relation);
            }

            String relationFile = "ERelation.txt";
            FileWriter fstream = new FileWriter(relationFile);
            BufferedWriter out = new BufferedWriter(fstream);
            out.write(relation);
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    static void filtersequence(String name, String workspace) {
        try {
            String relation = "NAME;SEQ_FILE\n";
            relation += name + ";" + workspace + name + "\n";

            String relationFile = "ERelation.txt";
            FileWriter fstream = new FileWriter(relationFile);
            BufferedWriter out = new BufferedWriter(fstream);
            out.write(relation);
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void filterfile(String name) {
        try {
            String relation = "FILE_NAME\n";
            relation += name + "\n";

            String relationFile = "ERelation.txt";
            FileWriter fstream = new FileWriter(relationFile);
            BufferedWriter out = new BufferedWriter(fstream);
            out.write(relation);
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
 
    static void createfile(String filePath) {
//    static void createfile(String workspace, String id, String name, String file, String tag, String database, String host) {
        try {
            String template2 = "(";

            
            FileReader file = new FileReader(filePath);
            BufferedReader buff = new BufferedReader(file);
            String line = buff.readLine().trim();
            line = buff.readLine().trim();
            String[] parts=line.split(";");
            String fasta= parts[1].trim();
            String new_fasta= parts[1].trim();
            String name= parts[0].trim();
            String new_name= parts[0].trim();
            String sequence= parts[3].trim();
            
            String sequenceRelation="";
            String relation = "NAME;FASTA_FILE;SEQ_FILE\n";
            
            while (line != null) {
                //System.out.println(parts[1].trim());
                sequenceRelation+= sequence+"\n";
                System.out.println(line);
                line = buff.readLine();
                if (line!=null){
                parts=line.split(";");
                new_fasta= parts[1].trim();
                new_name= parts[0].trim();
                sequence= parts[3].trim();
                }
                //System.out.println(name);
                //System.out.println(new_name);

                if (!new_name.equals(name)){
                    //System.out.println(name);

                    relation+=name+";"+fasta+";"+ name+ "\n";
                    
                    
                    String sequenceFile = name;
                    FileWriter fs = new FileWriter(sequenceFile);
                    BufferedWriter out = new BufferedWriter(fs);
                    out.write(sequenceRelation);
                    out.close();
              
                    fasta=new_fasta;
                    name=new_name;
                    
                }
                
            }
            relation+=name+";"+fasta+";"+ name+ "\n";
                    
                    
            String sequenceFile = name;
            FileWriter fs = new FileWriter(sequenceFile);
            BufferedWriter outF = new BufferedWriter(fs);
            outF.write(sequenceRelation);
            outF.close();

            fasta=new_fasta;
            name=new_name;
            /*Creating ERelation.txt*/
            
            //String relationFile = "ERelation.txt";
            //FileWriter fstream = new FileWriter(relationFile);
            //BufferedWriter out = new BufferedWriter(fstream);
            //out.write(relation);
            //out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    static void fastafilter(String fastaFilePath, String fastaName) {
        try {
            String sequenceFilePath = fastaName+".txt";
            //Abre e le primeira linha do arquivo das sequencias
            FileReader file = new FileReader(sequenceFilePath);
            BufferedReader buff = new BufferedReader(file);
            String line = buff.readLine().trim();
            line = buff.readLine().trim();
            TreeSet<String> sequencesList = new TreeSet<String>();
            while (line != null) {
                line=">"+line;
                sequencesList.add(line);
                if ((line = buff.readLine()) != null) {
                continue;
                }
                else
                {
                line=null;
                }
            }
            
            //Abre e le primeira linha do arquivo das sequencias
            FileReader fastaFile = new FileReader(fastaFilePath);
            BufferedReader buffFasta = new BufferedReader(fastaFile);
            String fastaLine = buffFasta.readLine().trim();
            
            
            String fileName = "new_"+ fastaName;
            FileWriter fastafstream = new FileWriter(fileName);
            BufferedWriter fastaout = new BufferedWriter(fastafstream);

            String newFileRelation = "";
            Integer t=0;
            while (fastaLine != null) {
                if(sequencesList.contains(fastaLine)){
                    
                    sequencesList.remove(fastaLine);
                    
                    //adiciona a linha 
                    newFileRelation += fastaLine + "\n";
                    boolean name = false;
                    while (name == false) {
                        if ((fastaLine = buffFasta.readLine()) != null) {
                            if (fastaLine.startsWith(">")) {
                                name = true;
                            } else {
                                newFileRelation += fastaLine + "\n";
                            }
                        } 
                        else {
                            //acabou o arquivo fasta
                            name = true;
                        }
                    }
                    //seq adicionada, abrindo arquivo e lendo desde o inicio novamente
                    if (t++ >1000){                    
                        //System.out.println(fastaLine);
                        t=0;
                        fastaout.write(newFileRelation);
                        newFileRelation="";
                    }
                } 
                else{
                    boolean name = false;
                    while (name == false) {
                        if ((fastaLine = buffFasta.readLine()) != null) {
                            if (fastaLine.startsWith(">")) {
                                name = true;
                            } 
                            else 
                            {
                                continue;
                            }
                        }
                        else{
                             fastaLine=null; 
                             break;
                        }
                    
                    }
                }
            }
            //System.out.println("saiu");
            //System.in.read();

            //String fileName = "new_" ;
            //FileWriter fastafstream = new FileWriter(fileName);
            //BufferedWriter fastaout = new BufferedWriter(fastafstream);
            fastaout.write(newFileRelation);
            fastaout.close();
            System.out.println("Criando fasta");

            String relation = "NEW_FASTA_FILE\n";
            relation +=  fileName + "\n";
            
            String relationFile = "ERelation.txt";
            FileWriter fstream = new FileWriter(relationFile);
            BufferedWriter out = new BufferedWriter(fstream);
            out.write(relation);
            out.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
    static void fastafilter2(String fastaFilePath, String fastaName) {
        try {
            String sequenceFilePath = fastaName+".txt";
            //Abre e le primeira linha do arquivo das sequencias
            FileReader file = new FileReader(sequenceFilePath);
            BufferedReader buff = new BufferedReader(file);
            String line = buff.readLine().trim();
            
           
            
            //Abre e le primeira linha do arquivo das sequencias
            FileReader fastaFile = new FileReader(fastaFilePath);
            BufferedReader buffFasta = new BufferedReader(fastaFile);
            String fastaLine = buffFasta.readLine().trim();
            
            


            String newFileRelation = "";

            while (fastaLine != null) {
                if (fastaLine.equals(">" + line) ) {
                    //adiciona a linha 
                    newFileRelation += fastaLine + "\n";
                    boolean name = false;
                    while (name == false) {
                        if ((fastaLine = buffFasta.readLine()) != null) {
                            if (fastaLine.startsWith(">")) {
                                name = true;
                            } else {
                                newFileRelation += fastaLine + "\n";
                            }
                        } 
                        else {
                            //acabou o arquivo fasta
                            name = true;
                        }
                    }
                    //seq adicionada, abrindo arquivo e lendo desde o inicio novamente
                    file = new FileReader(sequenceFilePath);
                    buff = new BufferedReader(file);
                    line = buff.readLine().trim();
                } else {
                    //le a seguinte linha
                    if ((line = buff.readLine())!=null)
                        {
                        line = line.trim();
                        }
                    else  
                    {
                        //acabou o arquivo de seq, fasta nao esta no arquivo, ignora o fasta
                        //abre de novo o arquivo de seq
                        file = new FileReader(sequenceFilePath);
                        buff = new BufferedReader(file);
                        line = buff.readLine().trim();

                        // parte pro proximo fasta
                        boolean name = false;
                        while (name == false) {
                            if ((fastaLine = buffFasta.readLine())!= null){
                                
                                if (fastaLine.startsWith(">")) {
                                    name = true;
                                } 
                                
                                fastaLine.trim();
                            }
                            else{
                                name = true;
                            }
                        }
                    }
                }
            }
            //System.out.println("saiu");
            //System.in.read();

            String fileName = "new_"+fastaName ;
            FileWriter fastafstream = new FileWriter(fileName);
            BufferedWriter fastaout = new BufferedWriter(fastafstream);
            fastaout.write(newFileRelation);
            fastaout.close();
            System.out.println("Criando fasta");

            String relation = "NEW_FASTA_FILE\n";
            relation +=  fileName + "\n";
            
            String relationFile = "ERelation.txt";
            FileWriter fstream = new FileWriter(relationFile);
            BufferedWriter out = new BufferedWriter(fstream);
            out.write(relation);
            out.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
    static void filterseq(String seq1FilePath, String seq2FilePath, String name) {
        try {
            //Abre e le primeira linha do arquivo das sequencias
            FileReader seq2_file = new FileReader(seq2FilePath);
            BufferedReader buff = new BufferedReader(seq2_file);
            String seq2_line = buff.readLine().trim();
            
            //Abre e le primeira linha do arquivo das sequencias
            FileReader seq1_file = new FileReader(seq1FilePath);
            BufferedReader buffFile1 = new BufferedReader(seq1_file);
            String seq1_line = buffFile1.readLine().trim();
            seq1_line = buffFile1.readLine().trim();

            String newFileRelation = "SEQUENCIA\n";
            
            // treeset para ir conferindo
            TreeSet<String> sequencesList = new TreeSet<String>();
            while (seq1_line != null) {
                seq2_file = new FileReader(seq2FilePath);
                buff = new BufferedReader(seq2_file);
                seq2_line = buff.readLine().trim();
                seq2_line = buff.readLine().trim();
                while (seq2_line != null) {
                    if (seq1_line.equals(seq2_line) ) {
                        //adiciona a linha 
                        if(sequencesList.contains(seq1_line)==false){
                        
                            newFileRelation += seq1_line + "\n";
                            sequencesList.add(seq1_line);
                            seq2_line=null;
                        }     
                        seq2_line=null;
                                             
                        

                    }else{
                        //prox seq2
                    if ((seq2_line = buff.readLine()) != null) {
                continue;
                    }
                    else
                    {
                        seq2_line=null;
                    }
                    }
                }
                if ((seq1_line = buffFile1.readLine()) != null) {
                continue;
                }
                else
                {
                seq1_line=null;
                }
            }
            //System.out.println("saiu");
            //System.in.read();

            String fileName = name+".txt" ;
            FileWriter seqfstream = new FileWriter(fileName);
            BufferedWriter seqfileout = new BufferedWriter(seqfstream);
            seqfileout.write(newFileRelation);
            seqfileout.close();
            System.out.println("Criando seq");

            

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    static void createERelation(String name) {
        try {
            String relation = "NEW_SEQ_NAME\n";
            relation += name + ".txt\n";

            String relationFile = "ERelation.txt";
            FileWriter fstream = new FileWriter(relationFile);
            BufferedWriter out = new BufferedWriter(fstream);
            out.write(relation);
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
        static void createERelation(String name, String relationName) {
        try {
            String relation = "NAME"+";"+relationName+"\n";
            relation += name+";"+name+"_seqFile.txt\n";

            String relationFile = "ERelation.txt";
            FileWriter fstream = new FileWriter(relationFile);
            BufferedWriter out = new BufferedWriter(fstream);
            out.write(relation);
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
        
    static void finallist(String seq1FilePath, String blastFilePath, String fastaName, String name) {
        try {
            //Abre e le primeira linha do arquivo das sequencias
            FileReader blast_file = new FileReader(blastFilePath);
            BufferedReader buff = new BufferedReader(blast_file);
            String blast_line = buff.readLine().trim();
            
            //Abre e le primeira linha do arquivo das sequencias
            FileReader seq1_file = new FileReader(seq1FilePath);
            BufferedReader buffFile1 = new BufferedReader(seq1_file);
            String seq1_line = buffFile1.readLine().trim();
            seq1_line = buffFile1.readLine().trim();
            String newFileRelation = "FINAL_LIST\n";
            TreeSet<String> sequencesList = new TreeSet<String>();

            while (seq1_file != null) {
                blast_file = new FileReader(blastFilePath);
                buff = new BufferedReader(blast_file);
                blast_line = buff.readLine().trim();
                blast_line = buff.readLine().trim();
                while (blast_line != null) {
                    if (seq1_line.equals(blast_line) ) {
                        //adiciona a linha 
                        break;
                    }
                    
                        //prox seq2
//                    seq1_line = buff.readLine().trim();
                    
                    if ((blast_line = buff.readLine())== null){
                        if(sequencesList.contains(seq1_line)==false){
                        
                            sequencesList.add(seq1_line);
                     
                            newFileRelation+=seq1_line+'\n';
                            blast_line=null;
                        }
                    }
                    
                    
                }
                if ((seq1_line =buffFile1.readLine())!= null){
                seq1_line =seq1_line.trim();
                }
                else
                {
                break;
                }
            }
            //System.out.println("saiu");
            //System.in.read();

            String fileName = name+"_seqFile.txt" ;
            FileWriter seqfstream = new FileWriter(fileName);
            BufferedWriter seqfileout = new BufferedWriter(seqfstream);
            seqfileout.write(newFileRelation);
            seqfileout.close();
            System.out.println("Criando seq");

            

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
    
    static void prodigal_basic(String filePath) {
        try {
            String file = filePath;

            String relation = "PRODIGAL_FILE\n" + filePath + " \n";

            String relationFile = "ERelation.txt";
            FileWriter fstream = new FileWriter(relationFile);
            BufferedWriter out = new BufferedWriter(fstream);
            out.write(relation);
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    static void fraggene_basic(String filePath) {
        try {
            String file = filePath;
            String path[] = file.split("/");
            file = path[path.length - 1];
            String relation = "FRAGGENE_FILE\n" + filePath + "\n";

            String relationFile = "ERelation.txt";
            FileWriter fstream = new FileWriter(relationFile);
            BufferedWriter out = new BufferedWriter(fstream);
            out.write(relation);
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void metagene_basic(String filePath) {
        try {
            String tline[];
            String file = filePath;
            String path[] = file.split("/");
            file = path[path.length - 1];
            String relation = "METAGENE_FILE\n" + filePath + "\n";

            String relationFile = "ERelation.txt";
            FileWriter fstream = new FileWriter(relationFile);
            BufferedWriter out = new BufferedWriter(fstream);
            out.write(relation);
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
            