package com.client.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;

@Configuration
public class AmazonConfig {
    
    
    public class AwsS3Config {
        @Value("${cloud.aws.credentials.access-key}")
        private String accessKeyId;
    
        @Value("${cloud.aws.credentials.secret-key}")
        private String accessKeySecret;
    
       
    
        @Bean
        public AmazonS3 getAmazonS3Client() {
            final BasicAWSCredentials basicAwsCredentials = new BasicAWSCredentials(accessKeyId, accessKeySecret);
            // Get Amazon S3 client and return the S3 client object
            return AmazonS3ClientBuilder
                .standard()
                .withCredentials(new AWSStaticCredentialsProvider(basicAwsCredentials))
                .withRegion("us-east-1")
                .build();
        }
    }
}
