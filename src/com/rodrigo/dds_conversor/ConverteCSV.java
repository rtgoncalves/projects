package com.rodrigo.dds_conversor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;

class ConverteCSV {
	
	private StringBuilder stringBuilder; 
	private String caminho_destino_txt, caminho_destino_csv;
	private String nome_arquivo_sem_extensao, data;
		
	public void generateCsvFile(String caminho_destino_csv, String nome_arquivo_csv) {
		caminho_destino_txt = caminho_destino_csv
				+ "\\" + nome_arquivo_csv.replaceAll(".csv", ".txt");
		
		this.caminho_destino_csv = caminho_destino_csv
				+ "\\" + nome_arquivo_csv;
		
		nome_arquivo_sem_extensao = nome_arquivo_csv.replaceAll(".csv","").toUpperCase();

	    switch (nome_arquivo_sem_extensao) {
	       case "BF_OPER_CALCULADO":
		     	  converte_BF_OPER_CALCULADO();
		   break;	    
	       case "BFBOOK":
	     	  converte_BFBOOK();
	       break;
	       case "BFDIGEXT":
	    	   converte_BFDIGEXT();
	       break;
	       case "BFDIGNEG":
	    	   converte_BFDIGNEG();
	       break;
	       case "BFDIGNEG_GERENCIAL":
	    	   converte_BFDIGNEG_GERENCIAL();
	       break;
	       case "BFESTOQUE_GERENCIAL":
	    	   converte_BFESTOQUE_GERENCIAL();
	       break;	       
	       case "BFPOSCLS_GERENCIAL":
	    	   converte_BFPOSCLS_GERENCIAL();
	       break;	       	       
	       default:
	  		 JOptionPane.showMessageDialog(null,
			    "Layout do arquivo " + nome_arquivo_sem_extensao + " não cadastrado.",
			    "DDS_Conversor", JOptionPane.ERROR_MESSAGE);	        	  
	    }
	}

	public void converte_BFBOOK() {

		try {
			File file = new File(caminho_destino_txt);
			
			while (!file.exists()) {
				try {
					Thread.sleep(2000);					
				}
				catch (InterruptedException erro) {
					
				}				
			}
			
		    // Lê o arquivo .txt gerado anteriormente
			FileReader fileReader = new FileReader(caminho_destino_txt);		
			
			BufferedReader reader = new BufferedReader(fileReader);
			
			// Cria o arquivo CSV e grava o HEADER
		    FileWriter writer = new FileWriter(caminho_destino_csv);		    

		    writer.append("MNEMONIC");
		    writer.append(";");
		    writer.append("IMS NUMBER");
		    writer.append(";");
		    writer.append("FIRM CODE");
		    writer.append(";");		    
		    writer.append("SETOR CONTÁBIL");
		    writer.append(";");
		    writer.append("GOC");		    
		    writer.append("\r\n");
		    
			while ((data = reader.readLine()) != null) {
		        stringBuilder = new StringBuilder(data);
				stringBuilder.insert(8, ";");
				stringBuilder.insert(17, ";");
				stringBuilder.insert(21, ";");
				stringBuilder.insert(27, ";");
				writer.append(stringBuilder);
			    writer.append("\r\n");				
			}
			  
			fileReader.close();
			reader.close();
		       
		    writer.flush();
		    writer.close();
		      
		    JOptionPane.showMessageDialog(null,
			   "Conversão efetuada com sucesso!",
			   "DDS_Conversor", JOptionPane.INFORMATION_MESSAGE);	      
		}
		catch (FileNotFoundException erro1) {
			JOptionPane.showMessageDialog(null,
				    "Erro ao gerar arquivo CSV! Arquivo " + nome_arquivo_sem_extensao +
				    ".txt" +
				    " não encontrado.",
					"DDS_Conversor", JOptionPane.ERROR_MESSAGE);			
		}
		catch (IOException erro2) {
			JOptionPane.showMessageDialog(null,
			    "Erro ao gerar arquivo CSV! " + erro2 + " ",
				"DDS_Conversor", JOptionPane.ERROR_MESSAGE);		   
		}   
	}

	public void converte_BFDIGEXT() {
		try {
			File file = new File(caminho_destino_txt);
			
			while (!file.exists()) {
				try {
					Thread.sleep(2000);					
				}
				catch (InterruptedException erro) {					
				}				
			}
			
		    // Lê o arquivo .txt gerado anteriormente
			FileReader fileReader = new FileReader(caminho_destino_txt);		
			
			BufferedReader reader = new BufferedReader(fileReader);
			
			// Cria o arquivo CSV e grava o HEADER
		    FileWriter writer = new FileWriter(caminho_destino_csv);		    

		    writer.append("CODCLI");
		    writer.append(";");
		    writer.append("AGCOMP");
		    writer.append(";");
		    writer.append("CODATI");
		    writer.append(";");		    
		    writer.append("CODMER");
		    writer.append(";");
		    writer.append("CODVEN");
		    writer.append(";");
		    writer.append("TIPNEG");
		    writer.append(";");
		    writer.append("TIPOPE");
		    writer.append(";");
		    writer.append("NRODOC");
		    writer.append(";");
		    writer.append("QUANTI");
		    writer.append(";");
		    writer.append("QTDDAY");
		    writer.append(";");
		    writer.append("QTDLIQ");
		    writer.append(";");
		    writer.append("AJUATU");
		    writer.append(";");
		    writer.append("AJUANT");
		    writer.append(";");
		    writer.append("TAXANM");
		    writer.append(";");
		    writer.append("TAXADT");
		    writer.append(";");
		    writer.append("EMOLNM");
		    writer.append(";");
		    writer.append("EMOLDT");
		    writer.append(";");
		    writer.append("PREEXE");
		    writer.append(";");
		    writer.append("AGENTE");
		    writer.append(";");
		    writer.append("TIPCAL");
		    writer.append(";");
		    writer.append("TOTANM");
		    writer.append(";");
		    writer.append("TOTADT");
		    writer.append(";");
		    writer.append("TOTALQ");
		    writer.append(";");
		    writer.append("MEREXE");
		    writer.append(";");
		    writer.append("VENEXE");
		    writer.append(";");
		    writer.append("VRMCNM");
		    writer.append(";");
		    writer.append("VRMCDT");
		    writer.append(";");
		    writer.append("REGNOR");
		    writer.append(";");
		    writer.append("REGDAY");
		    writer.append(";");
		    writer.append("BASENM");
		    writer.append(";");
		    writer.append("BASEDT");
		    writer.append(";");
		    writer.append("CONTNM");
		    writer.append(";");
		    writer.append("CONTDT");
		    writer.append(";");
		    writer.append("INDICE");		    
		    writer.append(";");
		    writer.append("EMOLDI");		    
		    writer.append(";");		    
		    writer.append("CLTRAN");		    
		    writer.append(";");		    
		    writer.append("DIDTXJ");		    
		    writer.append(";");		    
		    writer.append("AGCORI");		    
		    writer.append(";");		    
		    writer.append("DI1TRM");		    
		    writer.append(";");		    
		    writer.append("PRETRM");		    
		    writer.append(";");		    
		    writer.append("FLAFRC");		    
		    writer.append(";");		    
		    writer.append("PRENEG");		    
		    writer.append(";");		    
		    writer.append("DI1TXJ");		    
		    writer.append(";");		    
		    writer.append("CODBRO");		    
		    writer.append(";");		    
		    writer.append("ATID11");		    
		    writer.append(";");		    
		    writer.append("DIRETO");		    
		    writer.append(";");		    
		    writer.append("EURO");		    
		    writer.append(";");		    
		    writer.append("INDTER");		    
		    writer.append(";");		    
		    writer.append("TRANSF");		    
		    writer.append(";");		    
		    writer.append("ATIVO2");		    
		    writer.append(";");		    
		    writer.append("ATIORI");		    
		    writer.append(";");		    
		    writer.append("CUSTDT");		    
		    writer.append(";");		    
		    writer.append("CUSTNM");		    
		    writer.append(";");		    
		    writer.append("LIVRE");		    
		    writer.append("\r\n");
		    
			while ((data = reader.readLine()) != null) {
		        stringBuilder = new StringBuilder(data);
				stringBuilder.insert(10, ";");  // CODCLI
				stringBuilder.insert(15, ";");  // AGCOMP
				stringBuilder.insert(19, ";");  // CODATI
				stringBuilder.insert(23, ";");  // CODMER
				stringBuilder.insert(28, ";");  // CODVEN
				stringBuilder.insert(30, ";");  // TIPNEG
				stringBuilder.insert(32, ";");  // TIPOPE
				stringBuilder.insert(44, ";");  // NRODOC
				stringBuilder.insert(50, ";");  // QUANTI
				stringBuilder.insert(56, ";");  // QTDDAY
				stringBuilder.insert(62, ";");  // QTDLIQ
				stringBuilder.insert(76, ";");  // AJUATU
				stringBuilder.insert(88, ";");  // AJUANT
				stringBuilder.insert(103, ";"); // TAXANM
				stringBuilder.insert(118, ";"); // TAXADT
				stringBuilder.insert(133, ";"); // EMOLNM
				stringBuilder.insert(148, ";"); // EMOLDT
				stringBuilder.insert(157, ";"); // PREEXE
				stringBuilder.insert(163, ";"); // AGENTE
				stringBuilder.insert(165, ";"); // TIPCAL
				stringBuilder.insert(182, ";"); // TOTANM
				stringBuilder.insert(199, ";"); // TOTADT
				stringBuilder.insert(216, ";"); // TOTALQ
				stringBuilder.insert(220, ";"); // MEREXE
				stringBuilder.insert(225, ";"); // VENEXE
				stringBuilder.insert(240, ";"); // VRMCNM
				stringBuilder.insert(255, ";"); // VRMCDT
				stringBuilder.insert(270, ";"); // REGNOR
				stringBuilder.insert(285, ";"); // REGDAY
				stringBuilder.insert(300, ";"); // BASENM
				stringBuilder.insert(315, ";"); // BASEDT
				stringBuilder.insert(332, ";"); // CONTNM
				stringBuilder.insert(349, ";"); // CONTDT
				stringBuilder.insert(361, ";"); // INDICE
				stringBuilder.insert(376, ";"); // EMOLDI
				stringBuilder.insert(387, ";"); // CLTRAN
				stringBuilder.insert(397, ";"); // DIDTXJ
				stringBuilder.insert(402, ";"); // AGCORI
				stringBuilder.insert(421, ";"); // DI1TRM
				stringBuilder.insert(436, ";"); // PRETRM
				stringBuilder.insert(439, ";"); // FLAFRC
				stringBuilder.insert(451, ";"); // PRENEG
				stringBuilder.insert(461, ";"); // DI1TXJ
				stringBuilder.insert(467, ";"); // CODBRO
				stringBuilder.insert(471, ";"); // ATID11
				stringBuilder.insert(473, ";"); // DIRETO
				stringBuilder.insert(476, ";"); // EURO
				stringBuilder.insert(478, ";"); // INDTER
				stringBuilder.insert(480, ";"); // TRANSF
				stringBuilder.insert(484, ";"); // ATIVO2
				stringBuilder.insert(488, ";"); // ATIORI
				stringBuilder.insert(495, ";"); // CUSTDT
				stringBuilder.insert(502, ";"); // CUSTNM
				
				writer.append(stringBuilder);
			    writer.append("\r\n");				
			}
			  
			fileReader.close();
			reader.close();
		       
		    writer.flush();
		    writer.close();
		      
		    JOptionPane.showMessageDialog(null,
			   "Conversão efetuada com sucesso!",
			   "DDS_Conversor", JOptionPane.INFORMATION_MESSAGE);	      
		}
		catch (FileNotFoundException erro1) {
			JOptionPane.showMessageDialog(null,
				    "Erro ao gerar arquivo CSV! Arquivo " + nome_arquivo_sem_extensao +
				    ".txt" +
				    " não encontrado.",
					"DDS_Conversor", JOptionPane.ERROR_MESSAGE);			
		}
		catch (IOException erro2) {
			JOptionPane.showMessageDialog(null,
			    "Erro ao gerar arquivo CSV! " + erro2 + " ",
				"DDS_Conversor", JOptionPane.ERROR_MESSAGE);		   
		}   
	}
	
	public void converte_BFDIGNEG() {
		try {
			File file = new File(caminho_destino_txt);
			
			while (!file.exists()) {
				try {
					Thread.sleep(2000);					
				}
				catch (InterruptedException erro) {					
				}				
			}
			
		    // Lê o arquivo .txt gerado anteriormente
			FileReader fileReader = new FileReader(caminho_destino_txt);		
			
			BufferedReader reader = new BufferedReader(fileReader);
			
			// Cria o arquivo CSV e grava o HEADER
		    FileWriter writer = new FileWriter(caminho_destino_csv);		    

		    writer.append("AGCOMP");
		    writer.append(";");
		    writer.append("TIPNEG");
		    writer.append(";");
		    writer.append("CODCLI");
		    writer.append(";");		    
		    writer.append("CODATI");
		    writer.append(";");
		    writer.append("CODMER");
		    writer.append(";");
		    writer.append("CODVEN");
		    writer.append(";");
		    writer.append("TIPOPE");
		    writer.append(";");
		    writer.append("NRODOC");
		    writer.append(";");
		    writer.append("QUANTI");
		    writer.append(";");
		    writer.append("PRENEG");
		    writer.append(";");
		    writer.append("QTDLIQ");
		    writer.append(";");
		    writer.append("QTDDAY");
		    writer.append(";");
		    writer.append("TAXANM");
		    writer.append(";");
		    writer.append("TAXADT");
		    writer.append(";");
		    writer.append("PREEXE");
		    writer.append(";");
		    writer.append("CLTRAN");
		    writer.append(";");
		    writer.append("DESCNM");
		    writer.append(";");
		    writer.append("DESCDT");
		    writer.append(";");
		    writer.append("AJUATU");
		    writer.append(";");
		    writer.append("AJUANT");
		    writer.append(";");
		    writer.append("AGENTE");
		    writer.append(";");
		    writer.append("TIPCAL");
		    writer.append(";");
		    writer.append("INDTER");
		    writer.append(";");
		    writer.append("MEREXE");
		    writer.append(";");
		    writer.append("VENEXE");
		    writer.append(";");
		    writer.append("NROESP");
		    writer.append(";");
		    writer.append("DIDTXJ");
		    writer.append(";");
		    writer.append("CORBAS");
		    writer.append(";");
		    writer.append("CORTOT");
		    writer.append(";");
		    writer.append("BROKER");
		    writer.append(";");
		    writer.append("CODBRO");
		    writer.append(";");
		    writer.append("DI1TRM");
		    writer.append(";");
		    writer.append("PRETRM");		    
		    writer.append(";");
		    writer.append("DOCORI");		    
		    writer.append(";");		    
		    writer.append("FLAFRC");		    
		    writer.append(";");		    
		    writer.append("FRCESP");		    
		    writer.append(";");		    
		    writer.append("LIVRE");		    
		    writer.append(";");		    
		    writer.append("REGNOR");		    
		    writer.append(";");		    
		    writer.append("REGDAY");		    
		    writer.append(";");		    
		    writer.append("BOOK");		    
		    writer.append(";");		    
		    writer.append("LIVRE1");		    
		    writer.append("\r\n");
		    
			while ((data = reader.readLine()) != null) {
		        stringBuilder = new StringBuilder(data);
				stringBuilder.insert(4, ";");
				stringBuilder.insert(6, ";");
				stringBuilder.insert(17, ";");
				stringBuilder.insert(21, ";");
				stringBuilder.insert(25, ";");
				stringBuilder.insert(30, ";");
				stringBuilder.insert(32, ";");
				stringBuilder.insert(44, ";");
				stringBuilder.insert(50, ";");
				stringBuilder.insert(62, ";");
				stringBuilder.insert(68, ";");
				stringBuilder.insert(74, ";");
				stringBuilder.insert(89, ";");
				stringBuilder.insert(104, ";");
				stringBuilder.insert(114, ";");
				stringBuilder.insert(125, ";");
				stringBuilder.insert(140, ";");
				stringBuilder.insert(155, ";");
				stringBuilder.insert(169, ";");
				stringBuilder.insert(181, ";");
				stringBuilder.insert(187, ";");
				stringBuilder.insert(189, ";");
				stringBuilder.insert(191, ";");
				stringBuilder.insert(195, ";");
				stringBuilder.insert(200, ";");
				stringBuilder.insert(236, ";");
				stringBuilder.insert(246, ";");
				stringBuilder.insert(261, ";");
				stringBuilder.insert(277, ";");
				stringBuilder.insert(278, ";");
				stringBuilder.insert(284, ";");
				stringBuilder.insert(303, ";");
				stringBuilder.insert(318, ";");
				stringBuilder.insert(325, ";");
				stringBuilder.insert(328, ";");
				stringBuilder.insert(330, ";");
				stringBuilder.insert(333, ";");
				stringBuilder.insert(348, ";");
				stringBuilder.insert(363, ";");
				stringBuilder.insert(384, ";");
				
				writer.append(stringBuilder);
			    writer.append("\r\n");				
			}
			  
			fileReader.close();
			reader.close();
		       
		    writer.flush();
		    writer.close();
		      
		    JOptionPane.showMessageDialog(null,
			   "Conversão efetuada com sucesso!",
			   "DDS_Conversor", JOptionPane.INFORMATION_MESSAGE);	      
		}
		catch (FileNotFoundException erro1) {
			JOptionPane.showMessageDialog(null,
				    "Erro ao gerar arquivo CSV! Arquivo " + nome_arquivo_sem_extensao +
				    ".txt" +
				    " não encontrado.",
					"DDS_Conversor", JOptionPane.ERROR_MESSAGE);			
		}
		catch (IOException erro2) {
			JOptionPane.showMessageDialog(null,
			    "Erro ao gerar arquivo CSV! " + erro2 + " ",
				"DDS_Conversor", JOptionPane.ERROR_MESSAGE);		   
		}   
	}
	
	public void converte_BFDIGNEG_GERENCIAL() {
		try {
			File file = new File(caminho_destino_txt);
			
			while (!file.exists()) {
				try {
					Thread.sleep(2000);					
				}
				catch (InterruptedException erro) {					
				}				
			}
			
		    // Lê o arquivo .txt gerado anteriormente
			FileReader fileReader = new FileReader(caminho_destino_txt);		
			
			BufferedReader reader = new BufferedReader(fileReader);
			
			// Cria o arquivo CSV e grava o HEADER
		    FileWriter writer = new FileWriter(caminho_destino_csv);		    

		    writer.append("AGCOMP");
		    writer.append(";");
		    writer.append("TIPNEG");
		    writer.append(";");
		    writer.append("NRODOC");
		    writer.append(";");		    
		    writer.append("CODCLI");
		    writer.append(";");
		    writer.append("CODATI");
		    writer.append(";");		    
		    writer.append("CODMER");
		    writer.append(";");
		    writer.append("CODVEN");
		    writer.append(";");
		    writer.append("TIPOPE");
		    writer.append(";");
		    writer.append("BOOK");
		    writer.append(";");
		    writer.append("QUANTI");
		    writer.append(";");
		    writer.append("ALLOC-ID");
		    writer.append(";");
		    writer.append("PRENEG");
		    writer.append(";");
		    writer.append("FLAFRC");
		    writer.append(";");
		    writer.append("TIPCAL");
		    writer.append(";");
		    writer.append("BROKER");
		    writer.append("\r\n");
		    
			while ((data = reader.readLine()) != null) {
		        stringBuilder = new StringBuilder(data);
				stringBuilder.insert(4, ";");
				stringBuilder.insert(6, ";");
				stringBuilder.insert(18, ";");
				stringBuilder.insert(29, ";");
				stringBuilder.insert(33, ";");
				stringBuilder.insert(37, ";");
				stringBuilder.insert(42, ";");
				stringBuilder.insert(44, ";");
				stringBuilder.insert(65, ";");
				stringBuilder.insert(71, ";");
				stringBuilder.insert(107, ";");
				stringBuilder.insert(119, ";");
				stringBuilder.insert(122, ";");
				stringBuilder.insert(124, ";");
				writer.append(stringBuilder);
			    writer.append("\r\n");				
			}
			  
			fileReader.close();
			reader.close();
		       
		    writer.flush();
		    writer.close();
		      
		    JOptionPane.showMessageDialog(null,
			   "Conversão efetuada com sucesso!",
			   "DDS_Conversor", JOptionPane.INFORMATION_MESSAGE);	      
		}
		catch (FileNotFoundException erro1) {
			JOptionPane.showMessageDialog(null,
				    "Erro ao gerar arquivo CSV! Arquivo " + nome_arquivo_sem_extensao +
				    ".txt" +
				    " não encontrado.",
					"DDS_Conversor", JOptionPane.ERROR_MESSAGE);			
		}
		catch (IOException erro2) {
			JOptionPane.showMessageDialog(null,
			    "Erro ao gerar arquivo CSV! " + erro2 + " ",
				"DDS_Conversor", JOptionPane.ERROR_MESSAGE);		   
		}   
	}
	
	public void converte_BFPOSCLS_GERENCIAL() {
		try {
			File file = new File(caminho_destino_txt);
			
			while (!file.exists()) {
				try {
					Thread.sleep(2000);					
				}
				catch (InterruptedException erro) {					
				}				
			}
			
		    // Lê o arquivo .txt gerado anteriormente
			FileReader fileReader = new FileReader(caminho_destino_txt);		
			
			BufferedReader reader = new BufferedReader(fileReader);
			
			// Cria o arquivo CSV e grava o HEADER
		    FileWriter writer = new FileWriter(caminho_destino_csv);		    

		    writer.append("BOOK");
		    writer.append(";");
		    writer.append("AGCOMP");
		    writer.append(";");
		    writer.append("CODCLI");
		    writer.append(";");
		    writer.append("CODATI");
		    writer.append(";");		    
		    writer.append("CODMER");
		    writer.append(";");
		    writer.append("CODVEN");
		    writer.append(";");
		    writer.append("TIPOPE");
		    writer.append(";");
		    writer.append("QTDCON");
		    writer.append("\r\n");
		    
			while ((data = reader.readLine()) != null) {
		        stringBuilder = new StringBuilder(data);
				stringBuilder.insert(8, ";");
				stringBuilder.insert(13, ";");
				stringBuilder.insert(24, ";");
				stringBuilder.insert(28, ";");
				stringBuilder.insert(32, ";");
				stringBuilder.insert(37, ";");
				stringBuilder.insert(39, ";");
				writer.append(stringBuilder);
			    writer.append("\r\n");				
			}
			  
			fileReader.close();
			reader.close();
		       
		    writer.flush();
		    writer.close();
		      
		    JOptionPane.showMessageDialog(null,
			   "Conversão efetuada com sucesso!",
			   "DDS_Conversor", JOptionPane.INFORMATION_MESSAGE);	      
		}
		catch (FileNotFoundException erro1) {
			JOptionPane.showMessageDialog(null,
				    "Erro ao gerar arquivo CSV! Arquivo " + nome_arquivo_sem_extensao +
				    ".txt" +
				    " não encontrado.",
					"DDS_Conversor", JOptionPane.ERROR_MESSAGE);			
		}
		catch (IOException erro2) {
			JOptionPane.showMessageDialog(null,
			    "Erro ao gerar arquivo CSV! " + erro2 + " ",
				"DDS_Conversor", JOptionPane.ERROR_MESSAGE);		   
		}   
	}
	
	public void converte_BFESTOQUE_GERENCIAL() {
		try {
			File file = new File(caminho_destino_txt);
			
			while (!file.exists()) {
				try {
					Thread.sleep(2000);					
				}
				catch (InterruptedException erro) {					
				}				
			}
			
		    // Lê o arquivo .txt gerado anteriormente
			FileReader fileReader = new FileReader(caminho_destino_txt);		
			
			BufferedReader reader = new BufferedReader(fileReader);
			
			// Cria o arquivo CSV e grava o HEADER
		    FileWriter writer = new FileWriter(caminho_destino_csv);		    

		    writer.append("AGCOMP");
		    writer.append(";");
		    writer.append("CODCLI");
		    writer.append(";");		    
		    writer.append("CODATI");
		    writer.append(";");
		    writer.append("CODMER");
		    writer.append(";");
		    writer.append("CODVEN");
		    writer.append(";");
		    writer.append("BOOK");
		    writer.append(";");
		    writer.append("DATOPE");
		    writer.append(";");
		    writer.append("QTD");
		    writer.append(";");
		    writer.append("QTDDT");
		    writer.append(";");
		    writer.append("QTDLQ");
		    writer.append(";");
		    writer.append("REGNM");
		    writer.append(";");
		    writer.append("REGDT");
		    writer.append(";");
		    writer.append("EMONM");
		    writer.append(";");
		    writer.append("EMODT");
		    writer.append(";");
		    writer.append("COMPRA");
		    writer.append(";");
		    writer.append("VENDA");
		    writer.append(";");
		    writer.append("LUCDT");
		    writer.append(";");
		    writer.append("PRJDT");
		    writer.append(";");
		    writer.append("LIQ-COMPRA");
		    writer.append(";");
		    writer.append("LIQ-VENDA");
		    writer.append(";");
		    writer.append("AJUPOS-TOT");
		    writer.append(";");
		    writer.append("AJUNEG-TOT");
		    writer.append(";");
		    writer.append("AJUPOS");
		    writer.append(";");
		    writer.append("AJUNEG");
		    writer.append(";");
		    writer.append("AJUPOS-C");
		    writer.append(";");
		    writer.append("AJUNEG-C");
		    writer.append(";");
		    writer.append("AJUPOS-V");
		    writer.append(";");
		    writer.append("AJUNEG-V");
		    writer.append(";");
		    writer.append("PREMIO-C");
		    writer.append(";");
		    writer.append("PREMIO-V");
		    writer.append(";");
		    writer.append("LIQ-PREMIO-C");
		    writer.append(";");
		    writer.append("LIQ-PREMIO-V");		    
		    writer.append(";");
		    writer.append("TXPER");		    
		    writer.append(";");		    
		    writer.append("LUC-LIQ-C");		    
		    writer.append(";");		    
		    writer.append("LUC-LIQ-V");		    
		    writer.append(";");		    
		    writer.append("PRJ-LIQ-C");		    
		    writer.append(";");		    
		    writer.append("PRJ-LIQ-V");		    
		    writer.append(";");		    
		    writer.append("REGNM-ACU");		    
		    writer.append(";");		    
		    writer.append("REGDT-ACU");		    
		    writer.append(";");		    
		    writer.append("EMONM-ACU");
		    writer.append(";");
		    writer.append("EMODT-ACU");
		    writer.append(";");
		    writer.append("COMPRA-ACU");
		    writer.append(";");
		    writer.append("VENDA-ACU");
		    writer.append(";");
		    writer.append("LUCDT-ACU");
		    writer.append(";");
		    writer.append("PRJDT-ACU");
		    writer.append(";");
		    writer.append("AJUPOS-TOT-ACU");
		    writer.append(";");
		    writer.append("AJUNEG-TOT-ACU");
		    writer.append(";");
		    writer.append("AJUPOS-ACU");
		    writer.append(";");
		    writer.append("AJUNEG-ACU");
		    writer.append(";");
		    writer.append("AJUPOS-C-ACU");
		    writer.append(";");
		    writer.append("AJUNEG-C-ACU");
		    writer.append(";");
		    writer.append("AJUPOS-V-ACU");
		    writer.append(";");
		    writer.append("AJUNEG-V-ACU");
		    writer.append(";");
		    writer.append("PREMIO-C-ACU");
		    writer.append(";");
		    writer.append("PREMIO-V-ACU");
		    writer.append(";");
		    writer.append("LIQ-PREMIO-C-ACU");
		    writer.append(";");
		    writer.append("LIQ-PREMIO-V-ACU");
		    writer.append(";");
		    writer.append("LUC-LIQ-C-ACU");
		    writer.append(";");
		    writer.append("LUC-LIQ-V-ACU");
		    writer.append(";");
		    writer.append("PRJ-LIQ-C-ACU");
		    writer.append(";");
		    writer.append("PRJ-LIQ-V-ACU");
		    writer.append("\r\n");
		    
			while ((data = reader.readLine()) != null) {
		        stringBuilder = new StringBuilder(data);
				stringBuilder.insert(4, ";");
				stringBuilder.insert(13, ";");
				stringBuilder.insert(17, ";");
				stringBuilder.insert(21, ";");
				stringBuilder.insert(26, ";");
				stringBuilder.insert(47, ";");
				stringBuilder.insert(56, ";");
				stringBuilder.insert(62, ";");
				stringBuilder.insert(68, ";");
				stringBuilder.insert(74, ";");
				stringBuilder.insert(89, ";");
				stringBuilder.insert(104, ";");
				stringBuilder.insert(119, ";");
				stringBuilder.insert(134, ";");
				stringBuilder.insert(149, ";");
				stringBuilder.insert(164, ";");
				stringBuilder.insert(179, ";");
				stringBuilder.insert(194, ";");
				stringBuilder.insert(209, ";");
				stringBuilder.insert(224, ";");
				stringBuilder.insert(239, ";");
				stringBuilder.insert(254, ";");
				stringBuilder.insert(269, ";");
				stringBuilder.insert(284, ";");
				stringBuilder.insert(299, ";");
				stringBuilder.insert(314, ";");
				stringBuilder.insert(329, ";");
				stringBuilder.insert(344, ";");
				stringBuilder.insert(359, ";");
				stringBuilder.insert(374, ";");
				stringBuilder.insert(389, ";");
				stringBuilder.insert(404, ";");
				stringBuilder.insert(419, ";");
				stringBuilder.insert(434, ";");
				stringBuilder.insert(449, ";");
				stringBuilder.insert(464, ";");
				stringBuilder.insert(479, ";");
				stringBuilder.insert(494, ";");
				stringBuilder.insert(509, ";");
				stringBuilder.insert(524, ";");
				stringBuilder.insert(539, ";");
				stringBuilder.insert(554, ";");
				stringBuilder.insert(569, ";");
				stringBuilder.insert(584, ";");
				stringBuilder.insert(599, ";");
				stringBuilder.insert(614, ";");
				stringBuilder.insert(629, ";");
				stringBuilder.insert(644, ";");
				stringBuilder.insert(659, ";");
				stringBuilder.insert(674, ";");
				stringBuilder.insert(689, ";");
				stringBuilder.insert(704, ";");
				stringBuilder.insert(719, ";");
				stringBuilder.insert(734, ";");
				stringBuilder.insert(749, ";");
				stringBuilder.insert(764, ";");
				stringBuilder.insert(779, ";");
				stringBuilder.insert(794, ";");
				stringBuilder.insert(809, ";");
				stringBuilder.insert(824, ";");
				
				writer.append(stringBuilder);
			    writer.append("\r\n");				
			}
			  
			fileReader.close();
			reader.close();
		       
		    writer.flush();
		    writer.close();
		      
		    JOptionPane.showMessageDialog(null,
			   "Conversão efetuada com sucesso!",
			   "DDS_Conversor", JOptionPane.INFORMATION_MESSAGE);	      
		}
		catch (FileNotFoundException erro1) {
			JOptionPane.showMessageDialog(null,
				    "Erro ao gerar arquivo CSV! Arquivo " + nome_arquivo_sem_extensao +
				    ".txt" +
				    " não encontrado.",
					"DDS_Conversor", JOptionPane.ERROR_MESSAGE);			
		}
		catch (IOException erro2) {
			JOptionPane.showMessageDialog(null,
			    "Erro ao gerar arquivo CSV! " + erro2 + " ",
				"DDS_Conversor", JOptionPane.ERROR_MESSAGE);		   
		}   
	}
	
	public void converte_BF_OPER_CALCULADO() {
		try {
			File file = new File(caminho_destino_txt);
			
			while (!file.exists()) {
				try {
					Thread.sleep(2000);					
				}
				catch (InterruptedException erro) {					
				}				
			}
			
		    // Lê o arquivo .txt gerado anteriormente
			FileReader fileReader = new FileReader(caminho_destino_txt);		
			
			BufferedReader reader = new BufferedReader(fileReader);
			
			// Cria o arquivo CSV e grava o HEADER
		    FileWriter writer = new FileWriter(caminho_destino_csv);		    

		    writer.append("BOOK");
		    writer.append(";");
		    writer.append("CODATI");
		    writer.append(";");		    
		    writer.append("CODMER");
		    writer.append(";");
		    writer.append("TIPOPE");
		    writer.append(";");
		    writer.append("AGCOMP");
		    writer.append(";");
		    writer.append("TIPNEG");
		    writer.append(";");
		    writer.append("NRODOC");
		    writer.append(";");
		    writer.append("CODCLI");
		    writer.append(";");
		    writer.append("CODVEN");
		    writer.append(";");
		    writer.append("ALLOC-ID");
		    writer.append(";");
		    writer.append("QUANTI");
		    writer.append(";");
		    writer.append("QUANTI-DT");
		    writer.append(";");
		    writer.append("QUANTI-LQ");
		    writer.append(";");
		    writer.append("AJUATU");
		    writer.append(";");
		    writer.append("AJUANT");
		    writer.append(";");
		    writer.append("TXREG-NM");
		    writer.append(";");
		    writer.append("TXREG-DT");
		    writer.append(";");
		    writer.append("TXEMO-NM");
		    writer.append(";");
		    writer.append("TXEMO-DT");
		    writer.append(";");
		    writer.append("PREEXE");
		    writer.append(";");
		    writer.append("AGENTE");
		    writer.append(";");
		    writer.append("TIPCAL");
		    writer.append(";");
		    writer.append("TOTANM");
		    writer.append(";");
		    writer.append("TOTADT");
		    writer.append(";");
		    writer.append("TOTALQ");
		    writer.append(";");
		    writer.append("MEREXE");
		    writer.append(";");
		    writer.append("VENEXE");
		    writer.append(";");
		    writer.append("VRMCNM");
		    writer.append(";");
		    writer.append("VRMCDT");
		    writer.append(";");
		    writer.append("REGNOR");
		    writer.append(";");
		    writer.append("REGDAY");
		    writer.append(";");
		    writer.append("BASENM");		    
		    writer.append(";");
		    writer.append("BASEDT");		    
		    writer.append(";");		    
		    writer.append("CONTNM");		    
		    writer.append(";");		    
		    writer.append("CONTDT");		    
		    writer.append(";");		    
		    writer.append("INDICE");		    
		    writer.append(";");		    
		    writer.append("EMOLDI");		    
		    writer.append(";");		    
		    writer.append("CLTRAN");		    
		    writer.append(";");		    
		    writer.append("DIDTXJ");		    
		    writer.append(";");		    
		    writer.append("AGCORI");
		    writer.append(";");
		    writer.append("DI1TRM");
		    writer.append(";");
		    writer.append("PRETRM");
		    writer.append(";");
		    writer.append("FLAFRC");
		    writer.append(";");
		    writer.append("PRENEG");
		    writer.append(";");
		    writer.append("DI1TXJ");
		    writer.append(";");
		    writer.append("CODBRO");
		    writer.append(";");
		    writer.append("ATID11");
		    writer.append(";");
		    writer.append("DIRETO");
		    writer.append(";");
		    writer.append("EURO");
		    writer.append(";");
		    writer.append("INDTER");
		    writer.append(";");
		    writer.append("TRANSF");
		    writer.append(";");
		    writer.append("ATIVO2");
		    writer.append(";");
		    writer.append("ATIORI");
		    writer.append(";");
		    writer.append("CUSTDT");
		    writer.append(";");
		    writer.append("CUSTNM");
		    writer.append(";");
		    writer.append("CORRET-NM");
		    writer.append(";");
		    writer.append("CORRET-DT");
		    writer.append(";");
		    writer.append("TXPER");
		    writer.append(";");
		    writer.append("VAL-NM");
		    writer.append(";");
		    writer.append("VAL-DT");
		    writer.append(";");
		    writer.append("VAL-LQ");
		    writer.append(";");
		    writer.append("AJU");
		    writer.append(";");
		    writer.append("AJU-DES");
		    writer.append("\r\n");
		    
			while ((data = reader.readLine()) != null) {
		        stringBuilder = new StringBuilder(data);
				stringBuilder.insert(20, ";");
				stringBuilder.insert(24, ";");
				stringBuilder.insert(28, ";");
				stringBuilder.insert(30, ";");
				stringBuilder.insert(35, ";");
				stringBuilder.insert(37, ";");
				stringBuilder.insert(49, ";");
				stringBuilder.insert(60, ";");
				stringBuilder.insert(65, ";");
				stringBuilder.insert(101, ";");
				stringBuilder.insert(107, ";");
				stringBuilder.insert(113, ";");
				stringBuilder.insert(119, ";");
				stringBuilder.insert(133, ";");
				stringBuilder.insert(145, ";");
				stringBuilder.insert(160, ";");
				stringBuilder.insert(175, ";");
				stringBuilder.insert(190, ";");
				stringBuilder.insert(205, ";");
				stringBuilder.insert(214, ";");
				stringBuilder.insert(220, ";");
				stringBuilder.insert(222, ";");
				stringBuilder.insert(239, ";");
				stringBuilder.insert(256, ";");
				stringBuilder.insert(273, ";");
				stringBuilder.insert(277, ";");
				stringBuilder.insert(282, ";");
				stringBuilder.insert(297, ";");
				stringBuilder.insert(312, ";");
				stringBuilder.insert(327, ";");
				stringBuilder.insert(342, ";");
				stringBuilder.insert(357, ";");
				stringBuilder.insert(372, ";");
				stringBuilder.insert(389, ";");
				stringBuilder.insert(406, ";");
				stringBuilder.insert(418, ";");
				stringBuilder.insert(433, ";");
				stringBuilder.insert(444, ";");
				stringBuilder.insert(454, ";");
				stringBuilder.insert(459, ";");
				stringBuilder.insert(478, ";");
				stringBuilder.insert(493, ";");
				stringBuilder.insert(496, ";");
				stringBuilder.insert(508, ";");
				stringBuilder.insert(518, ";");
				stringBuilder.insert(524, ";");
				stringBuilder.insert(528, ";");
				stringBuilder.insert(530, ";");
				stringBuilder.insert(533, ";");
				stringBuilder.insert(535, ";");
				stringBuilder.insert(537, ";");
				stringBuilder.insert(541, ";");
				stringBuilder.insert(545, ";");
				stringBuilder.insert(552, ";");
				stringBuilder.insert(559, ";");
				stringBuilder.insert(574, ";");
				stringBuilder.insert(589, ";");
				stringBuilder.insert(604, ";");
				stringBuilder.insert(621, ";");
				stringBuilder.insert(638, ";");
				stringBuilder.insert(655, ";");
				stringBuilder.insert(672, ";");
				stringBuilder.insert(689, ";");
				
				writer.append(stringBuilder);
			    writer.append("\r\n");				
			}
			  
			fileReader.close();
			reader.close();
		       
		    writer.flush();
		    writer.close();
		      
		    JOptionPane.showMessageDialog(null,
			   "Conversão efetuada com sucesso!",
			   "DDS_Conversor", JOptionPane.INFORMATION_MESSAGE);	      
		}
		catch (FileNotFoundException erro1) {
			JOptionPane.showMessageDialog(null,
				    "Erro ao gerar arquivo CSV! Arquivo " + nome_arquivo_sem_extensao +
				    ".txt" +
				    " não encontrado.",
					"DDS_Conversor", JOptionPane.ERROR_MESSAGE);			
		}
		catch (IOException erro2) {
			JOptionPane.showMessageDialog(null,
			    "Erro ao gerar arquivo CSV! " + erro2 + " ",
				"DDS_Conversor", JOptionPane.ERROR_MESSAGE);		   
		}   
	}		
}