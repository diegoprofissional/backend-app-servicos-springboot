package br.com.syscomercial.appservico.utilitarios;

import net.coobird.thumbnailator.Thumbnails;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class TratadorImagem {

    public String transformarArquivoFotoURL(MultipartFile arquivoFoto){

       String diretorioNomeFoto  = salvarImagemOriginalSistemaArquivo(arquivoFoto);
       String diretorioNomeFotoRedimensionada = redimensionarFoto(diretorioNomeFoto);
       String urlFotoAWSS3 = enviarAWSS3(diretorioNomeFotoRedimensionada);

       return urlFotoAWSS3;

    }





    private String  salvarImagemOriginalSistemaArquivo(MultipartFile arquivoFoto) {

        File file = new File("/home/arquivosTemporarios", "arquivo.jpg");
        try{
            FileOutputStream outputStream = new FileOutputStream(file);
            outputStream.write(arquivoFoto.getBytes());



        }catch (Exception e){

        }

        return "/home/arquivosTemporarios/arquivo.jpg";

    }

    private String redimensionarFoto(String diretorioNomeFoto){

        try {
            File fotoOriginalSalva = new File(diretorioNomeFoto);

            Thumbnails.of(fotoOriginalSalva)
                    .size(200, 200) // Tamanho da miniatura
                    .toFile(new File("/home/arquivosTemporarios/miniatura.jpg")); // Salva a miniatura em um arquivo

            // Após a criação da miniatura, você pode excluir o arquivo original se necessário
            fotoOriginalSalva.delete();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "/home/arquivosTemporarios/miniatura.jpg";

    }

    private String enviarAWSS3( String diretorioNomeFotoRedimensionada ){

       String urlSWSS3 =  ServicoS3.enviarArquivoS3(diretorioNomeFotoRedimensionada);

        return urlSWSS3;

    }
    }



