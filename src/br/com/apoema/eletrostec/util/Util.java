package br.com.apoema.eletrostec.util;


import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Calendar;

import org.springframework.web.multipart.MultipartFile;

public class Util {

    public static boolean fazerUploadImagem(MultipartFile imagem) {
        boolean sucessoUpload = false;

        if (!imagem.isEmpty()) {
            String nomeArquivo = imagem.getOriginalFilename();
            try {
                // Criando o diretório para armazenar o arquivo
                //String maquina = "/home/ifpe/git/Padarias";
                //String workspaceProjeto = "/WebContent/view/img/produtos";
                String maquina = "/opt/tomcat-latest/webapps/Eletrostec/";
                String workspaceProjeto = "view/img/";
               
                File dir = new File(maquina + workspaceProjeto);

                if (!dir.exists()) {
                    dir.mkdirs();
                }

                // Criando o arquivo no diretório
                File serverFile = new File(maquina + workspaceProjeto  +  Calendar.getInstance().getTime() + " - " + nomeArquivo);
                BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
                stream.write(imagem.getBytes());
                stream.close();
                System.out.println("Arquivo armazenado em:" + serverFile.getAbsolutePath());
                System.out.println("Você fez o upload do arquivo " + nomeArquivo + " com sucesso");
                sucessoUpload = true;
            } catch (Exception e) {
                System.out.println("Você falhou em carregar o arquivo " + nomeArquivo + " => " + e.getMessage());
            }
        } else {
            System.out.println("Você falhou em carregar o arquivo porque ele está vazio ");
        }
        return sucessoUpload;
    }

    public static String sha1(String input) throws NoSuchAlgorithmException {
        MessageDigest mDigest = MessageDigest.getInstance("SHA1");
        byte[] result = mDigest.digest(input.getBytes());
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < result.length; i++) {
            sb.append(Integer.toString((result[i] & 0xff) + 0x100, 16).substring(1));
        }

        return sb.toString();
    }
}



