package com.rodrigo.dds_conversor;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * 
 * @author Rodrigo Gonçalves
 * 
 * Permitir a conversão de arquivo .DDS em arquivos .TXT e .CSV
 *
 */

public class Main extends JFrame implements ActionListener, ItemListener {
	
	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private JLabel lb_origem, lb_destino, lb_dev;
	private JTextField tf_origem, tf_destino;
	private JButton bt_origem, bt_destino, bt_converter, bt_sair, bt_lista_arquivos;
	private JFileChooser fc_origem, fc_destino;
	private JCheckBox cb_csv, cb_txt;
	private ImageIcon icone, icone_consulta;
	private URL url_icone, url_icone_consulta;	
	private String caminho_origem_dds, caminho_destino_txt, caminho_destino_csv;
	private String nome_arquivo_dds, nome_arquivo_txt, nome_arquivo_csv;
	private String comando_vutil;
	private String caminho_origem_selecionado = "C:\\";
	private String caminho_destino_selecionado = "C:\\";
	
	public static void main(String args[]) {
		JFrame frame = new Main();
		frame.setUndecorated(true);
		frame.getRootPane().setWindowDecorationStyle(JRootPane.FRAME);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	
	public Main() {
		setBounds(200, 200, 490, 280);
		setTitle("DDS_Conversor");
		
		UIManager.put("TextField.font", new Font("arial", Font.BOLD, 11));		
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(220,220,200));

		url_icone = getClass().getResource("imagens/icone.png");		
		icone = new ImageIcon(url_icone);
		
		url_icone_consulta = getClass().getResource("imagens/icone_consulta.png");
		icone_consulta = new ImageIcon(url_icone_consulta);		
		
		lb_origem = new JLabel("Origem (.dds)");
		lb_origem.setBounds(15, 15, 100, 20);
		
		tf_origem = new JTextField();
		tf_origem.setBounds(15, 38, 400, 23);
		tf_origem.setText(" ");
		tf_origem.setEditable(false);
		
		bt_origem = new JButton(icone);
		bt_origem.addActionListener(this);
		bt_origem.setBounds(425, 38, 40, 23);
		
		lb_destino = new JLabel("Destino (.csv/.txt)");
		lb_destino.setBounds(15, 70, 120, 20);

		tf_destino = new JTextField();
		tf_destino.setBounds(15, 93, 400, 23);
		tf_destino.setText(" ");
		tf_destino.setEditable(false);
		
		bt_destino = new JButton(icone);
		bt_destino.addActionListener(this);
		bt_destino.setBounds(425, 93, 40, 23);
		
		cb_csv = new JCheckBox("csv");
		cb_csv.setSelected(true);
		cb_csv.setBounds(15, 135, 45, 23);
		cb_csv.addItemListener(this);		

		cb_txt = new JCheckBox("txt");
		cb_txt.setSelected(true);
		cb_txt.setBounds(75, 135, 45, 23);		
		cb_txt.addItemListener(this);

		bt_lista_arquivos = new JButton(icone_consulta);
		bt_lista_arquivos.addActionListener(this);
		bt_lista_arquivos.setToolTipText("Lista os arquivos disponíveis para conversão");
		bt_lista_arquivos.setBounds(15, 175, 45, 30);
		bt_lista_arquivos.setBackground(new Color(220,220,200));
		
		bt_converter = new JButton("Converter");
		bt_converter.addActionListener(this);
		bt_converter.setToolTipText("Efetua a conversão");
		bt_converter.setMnemonic(KeyEvent.VK_C);
		bt_converter.setBounds(275, 175, 90, 23);
		
		bt_sair = new JButton("Sair");
		bt_sair.addActionListener(this);
		bt_sair.setToolTipText("Encerra a aplicação");
		bt_sair.setMnemonic(KeyEvent.VK_S);
		bt_sair.setBounds(375, 175, 90, 23);		
		
		lb_dev = new JLabel("Equipe BM&F - MATERA Systems, 2017");
		lb_dev.setFont(new Font("Dialog", Font.ITALIC, 10));
		lb_dev.setBounds(15, 226, 300, 20);

		panel.add(lb_origem, null);
		panel.add(tf_origem, null);
		panel.add(bt_origem, null);
		panel.add(lb_destino, null);
		panel.add(tf_destino, null);
		panel.add(bt_destino, null);
		panel.add(cb_csv, null);
		panel.add(cb_txt, null);
		panel.add(bt_lista_arquivos, null);
		panel.add(bt_converter, null);		
		panel.add(bt_sair, null);
		panel.add(lb_dev, null);

		getContentPane().add(panel);
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == bt_origem) {
			fc_origem = new JFileChooser(caminho_origem_selecionado);
			FileNameExtensionFilter filtro_dds = new FileNameExtensionFilter("Arquivos DDS", "dds");  
			fc_origem.addChoosableFileFilter(filtro_dds);
			fc_origem.setAcceptAllFileFilterUsed(false);
			
			if (fc_origem.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
				tf_origem.setText(fc_origem.getSelectedFile().getAbsolutePath());
				tf_destino.setText(fc_origem.getCurrentDirectory().toString());
				caminho_origem_dds = fc_origem.getSelectedFile().getAbsolutePath();
				caminho_origem_selecionado = fc_origem.getSelectedFile().getAbsolutePath();
				caminho_destino_txt = tf_destino.getText().toString();
				caminho_destino_selecionado = tf_destino.getText().toString();			   
				nome_arquivo_dds = fc_origem.getSelectedFile().getName().toUpperCase();			   
				nome_arquivo_txt = nome_arquivo_dds.replaceAll(".DDS", ".txt");
				nome_arquivo_csv = nome_arquivo_dds.replaceAll(".DDS", ".csv");
			}			
		}
				
		if (e.getSource() == bt_destino) {
			fc_destino = new JFileChooser(caminho_destino_selecionado);
			fc_destino.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			if (fc_destino.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
				tf_destino.setText(fc_destino.getSelectedFile().getPath());
				caminho_destino_txt = fc_destino.getSelectedFile().getAbsolutePath();
				caminho_destino_selecionado = fc_destino.getSelectedFile().getAbsolutePath();
			}
		}
		
		if (e.getSource() == bt_converter) {
			if (tf_origem.getText().equals(" ")) {
				JOptionPane.showMessageDialog(null,
						"Selecione o local do arquivo de origem!",
						"DDS_Conversor", JOptionPane.INFORMATION_MESSAGE);
				return;
			}
			
			if (tf_destino.getText().equals(" ")) {
				JOptionPane.showMessageDialog(null,
						"Selecione o local do arquivo de destino!",
						"DDS_Conversor", JOptionPane.INFORMATION_MESSAGE);
				return;
			}
			
			if ((!cb_csv.isSelected() && ((!cb_txt.isSelected())))) {
				JOptionPane.showMessageDialog(null,
						"Selecione um tipo de conversão!",
						"DDS_Conversor", JOptionPane.INFORMATION_MESSAGE);
				return;
			}

			/*
			 * Gera o arquivo texto para utilizá-lo na gravação do arquivo CSV
			 */			
			getContentPane().setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
			
			comando_vutil = "vutil32 -u -t "
				      + caminho_origem_dds
				      + " "
				      + caminho_destino_txt
				      + "\\"
				      + nome_arquivo_txt;
			
			// Testes
			/* comando_vutil = "C:\\vutil\\bin\\vutil32 -u -t "
				      + caminho_origem_dds
				      + " "
				      + caminho_destino_txt
				      + "\\"
				      + nome_arquivo_txt; */			

			try {
				Runtime.getRuntime().exec(comando_vutil);			
			}
			catch(IOException erro) {
				JOptionPane.showMessageDialog(null,
					"Erro ao converter arquivo texto! " + erro,
					"DDS_Conversor", JOptionPane.ERROR_MESSAGE);
				getContentPane().setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
				return;
			}

			if (cb_csv.isSelected()) {				
				caminho_destino_csv = caminho_destino_txt;
				
			    ConverteCSV converte_csv = new ConverteCSV();
				converte_csv.generateCsvFile(caminho_destino_csv, nome_arquivo_csv);				
			}
			
			if (!cb_txt.isSelected()) {
				File file = new File(caminho_destino_txt + "\\" + nome_arquivo_txt);
				file.delete();
			}
			
			if (cb_txt.isSelected() && (!cb_csv.isSelected())) {
				File file = new File(caminho_destino_txt + "\\" + nome_arquivo_txt);
				
				while (!file.exists()) {
					try {
						Thread.sleep(2000);					
					}
					catch (InterruptedException erro) {}
				}
			    JOptionPane.showMessageDialog(null,
			    		"Conversão efetuada com sucesso!",
						"DDS_Conversor", JOptionPane.INFORMATION_MESSAGE);				
			}
			
			getContentPane().setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
			tf_origem.setText(" ");
			tf_destino.setText(" ");
			cb_csv.setSelected(true);
			cb_txt.setSelected(true);
			bt_converter.setFocusable(false);
		}
		
		if (e.getSource() == bt_lista_arquivos) {
			ListaArquivosCadastrados lista_arquivos = new ListaArquivosCadastrados();
			lista_arquivos.dispose();
			bt_lista_arquivos.setFocusable(false);
			bt_converter.setFocusable(false);
		}
		
		if (e.getSource() == bt_sair) {
			System.exit(0);
		}
	}
}