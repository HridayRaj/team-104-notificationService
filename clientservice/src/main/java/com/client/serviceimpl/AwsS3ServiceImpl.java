package com.client.serviceimpl;

import java.net.URL;
import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazonaws.HttpMethod;
import com.amazonaws.services.s3.AmazonS3;

@Service
public class AwsS3ServiceImpl {
    

    private final AmazonS3 amazonS3;

    @Autowired
    public AwsS3ServiceImpl(AmazonS3 amazonS3) {
        this.amazonS3 = amazonS3;
    }

    public String generatePreSignedUrl(String filePath , String bucketName , HttpMethod httpMethod){
       
        Calendar calendar = Calendar.getInstance();

        calendar.setTime(new Date());
        
        calendar.add(Calendar.MINUTE ,60);

        return amazonS3.generatePresignedUrl(bucketName, filePath, calendar.getTime(), httpMethod).toString();

        
    }


}
