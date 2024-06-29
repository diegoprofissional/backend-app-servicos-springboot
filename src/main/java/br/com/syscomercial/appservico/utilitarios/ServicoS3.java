package br.com.syscomercial.appservico.utilitarios;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.PutObjectRequest;

import java.io.File;
import java.net.URL;
import java.util.UUID;

public class ServicoS3 {

    public static String enviarArquivoS3(String arquivo) {
        String accessKey = "";
        String secretKey = "";

        AmazonS3 s3Client = new AmazonS3Client(new BasicAWSCredentials(accessKey, secretKey));

        String bucketName = "velho-bucket";
        String fileName = "proservicos" + UUID.randomUUID().toString()  + ".jpg";

        File fileToUpload = new File(arquivo);

        PutObjectRequest request = new PutObjectRequest(bucketName, fileName, fileToUpload);

        s3Client.putObject(request);

        URL url = s3Client.getUrl(bucketName, fileName);
        return url.toString();
    }

}
