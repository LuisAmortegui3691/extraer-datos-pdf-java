package com.mycompany.mavenproject1;

import java.io.File;
import java.util.Scanner;
import java.util.Arrays;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.tools.PDFText2HTML;

public class PDFtoXMLConverter {

    public static void main(String[] args) {
        
        //Variable entrada Documento
        String rutaArchivoPDF = "C:\\prueba.pdf";
        //Llamada funcion para extraer info PDF
        String textoExtraido = extraerTextoPDF(rutaArchivoPDF);
        
        //Asignar variable cadena a lo extraido
        String cadena = textoExtraido;
        //Genera un split por cada espacio
        String[] arrayTexto = cadena.split( " ");
        //Generar el arreglo por las cadenas de texto 
        String[] array = new String[arrayTexto.length];
        
        //Ciclo para imprimir el arrego
        for (int i = 0; i < arrayTexto.length; i++) {
            array[i] = arrayTexto[i].trim();
            
            System.out.println("Posicion " + i + ". " +array[i]);
        }
        
        
    }
    
    //Funcion para extraer informacion PDF
    public static String extraerTextoPDF(String rutaArchivo) {
        try {
            PDDocument document = PDDocument.load(new File(rutaArchivo));
            PDFTextStripper pdfStripper = new PDFTextStripper();
            String texto = pdfStripper.getText(document);
            document.close();
            
            return texto;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
