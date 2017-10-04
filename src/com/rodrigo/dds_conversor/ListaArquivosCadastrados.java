package com.rodrigo.dds_conversor;

import java.awt.BorderLayout;
import java.awt.Container;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JRootPane;
import javax.swing.JScrollPane;

public class ListaArquivosCadastrados extends JDialog {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JList<String> list;
	private JScrollPane scrollPane;
	
	private JDialog dialog;
	
	private String[] arquivos_cadastrados = { "BF_OPER_CALCULADO", "BFBOOK", "BFDIGEXT",
			"BFDIGNEG", "BFDIGNEG_GERENCIAL", "BFESTOQUE_GERENCIAL", "BFPOSCLS_GERENCIAL" };
	
	public ListaArquivosCadastrados() {
	    dialog = new JDialog();
	    dialog.setTitle("Arquivos disponíveis para conversão");
	    dialog.setUndecorated(true);
		dialog.getRootPane().setWindowDecorationStyle(JRootPane.FRAME);
		dialog.setResizable(false);
		dialog.setSize(380, 150);
		dialog.setLocationRelativeTo(null);
	    
	    list = new JList<String>(arquivos_cadastrados);
	    list.setSelectionInterval(-1, -1);
	    
	    scrollPane = new JScrollPane(list);

	    Container contentPane = dialog.getContentPane();
	    contentPane.add(scrollPane, BorderLayout.CENTER);

	    dialog.setModal(true);
	    dialog.setVisible(true);	    
	}
}
