/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package src;

import java.io.IOException;

/**
 *
 * @author sbenza
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
//        TESTE DOS EXTRATORES
//       String p = "/Users/sbenza/Downloads/exp/prodigal/866/399/058/0/4481482.00.prodigal.gff";
//        String f = "/Users/sbenza/Downloads/exp/fraggene/866/398/159/0/4481482.00.fraggene.ffn";
//        String m = "/Users/sbenza/Downloads/exp/metagene/866/398/282/0/4481482.00.metagenemark.gff";
//        String b = "/Users/sbenza/Downloads/exp/blast/919/045/429/0/new_ac1_00.blast.tabular";
        //String pe = "/Users/sbenza/Downloads/4481486.5.prodigal.gff_seq.txt";
        //String fe = "/Users/sbenza/Downloads/4481486.5.fraggene.ffn_seq.txt";
     //   String me = "/Users/sbenza/Downloads/4481486.5.metagenemark.gff_seq.txt";
      // String be = "/Users/sbenza/Downloads/4481486.5.blast.tabular_seq.txt";
//        String nf = "/Users/sbenza/NetBeansProjects/SciMGExtractor/new_seqFile.txt";
        //String f3 = "/Users/sbenza/NetBeansProjects/SciMGExtractor/3.txt";
//        Extractor.prodigal_nm(p);
//        Extractor.metagene_nm(m);
//        Extractor.fraggene_nm(f);
//        Extractor.blast_nm(b);
       // Extractor.filterseq(pe,fe,"3");
        //System.in.read();
        //Extractor.filterseq(f3,me,"3");
        //Extractor.finallist(f3, be, "4","2");
        //String f = "/Users/sbenza/Dropbox/Mestrado/Experimentos/SciMG/4481482";
        //Extractor.pyfasta(f,"200");
//        Extractor.fraggene(d);
//        Extractor.metagene(e);
        //String s = "/Users/sbenza/Downloads/abrolios_828486";
        //String d = "/Users/sbenza/Downloads/ac1_00";
       // Extractor.fastafilter(s, d);
//        Extractor.createfile();
//        String s = "";
//        Extractor.createfile("a","b","c","d","e");
        //String fasta = "/Users/sbenza/Downloads/fasta";
        //String seq = "/Users/sbenza/Downloads/seq";
        //Extractor.fastafilter(fasta, seq, "fastateste");
        if(args.length >= 1){
            String activity = args[0];
            if(activity.equals("prodigal") && args.length == 2){
                Extractor.prodigal(args[1]);
            }else if(activity.equals("fraggene") && args.length == 2){
                Extractor.fraggene(args[1]);
            }else if(activity.equals("metagene") && args.length == 2){
                Extractor.metagene(args[1]);
            }else if(activity.equals("blast") && args.length == 2){
                Extractor.blast(args[1]);
            
            }else if(activity.equals("pyfasta") && args.length == 3){
                Extractor.pyfasta(args[1],args[2]);
                        
            }else if(activity.equals("filtersequence") && args.length == 3){
                Extractor.filtersequence(args[1],args[2]);
            
            }else if(activity.equals("createfile") && args.length == 2){
                Extractor.createfile(args[1]);
            
            }else if(activity.equals("fastafilter") && args.length == 3){
                Extractor.fastafilter(args[1],args[2]);
            
            }else if(activity.equals("prodigal_nm") && args.length == 2){
                Extractor.prodigal_nm(args[1]);
            
            }else if(activity.equals("metagene_nm") && args.length == 2){
                Extractor.metagene_nm(args[1]);
            
            }else if(activity.equals("fraggene_nm") && args.length == 2){
                Extractor.fraggene_nm(args[1]);
            
            }else if(activity.equals("blast_nm") && args.length == 2){
                Extractor.blast_nm(args[1]);
            
            }else if(activity.equals("filterfile") && args.length == 3){
                Extractor.filterfile(args[1]);
            
            }else if(activity.equals("createERelation") && args.length == 2){
                Extractor.createERelation(args[1]);
            
            }else if(activity.equals("createERelation") && args.length == 3){
                Extractor.createERelation(args[1],args[2]);
            
            }else if(activity.equals("filterseq") && args.length == 4){
                Extractor.filterseq(args[1],args[2],args[3]);
                
            }else if(activity.equals("finallist") && args.length == 5){
                Extractor.finallist(args[1],args[2],args[3],args[4]);
            }
        }
    }
    
}
