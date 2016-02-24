package br.com.casadocodigo.loja.infra;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.S3ClientOptions;

import javax.enterprise.inject.Produces;

/**
 * Created by Nando on 23/02/16.
 */
public class AmazonS3ClientProducer {

    @Produces
    public AmazonS3Client s3Ninja(){
        BasicAWSCredentials credentials = new BasicAWSCredentials("AKIAIOSFODNN7EXAMPLE", "wJalrXUtnFEMI/K7MDENG/bPxRfiCYEXAMPLEKEY");
        AmazonS3Client s3Client = new AmazonS3Client(credentials, new ClientConfiguration());

        s3Client.setS3ClientOptions(new S3ClientOptions().withPathStyleAccess(true));
        s3Client.setEndpoint("http://localhost:9444/s3");

        return s3Client;
    }
}
