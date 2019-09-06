package com.truplat.common;

import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Service;

@Service
public class ImageService {
	
	private static int IMAGE_WIDTH = 612;
	
	public BufferedImage resize(BufferedImage originalImage) {  
        int width = originalImage.getWidth();  
        int height = originalImage.getHeight();  
        
        if(width < IMAGE_WIDTH) {
        	return originalImage;
        }
        
        float percentage = (IMAGE_WIDTH*100)/width;
        int newWidth = Math.round((percentage*width)/100);
        int newHeight = Math.round((percentage*height)/100);
        
        BufferedImage resizedImage = new BufferedImage(newWidth, newHeight, originalImage.getType());  
        Graphics2D graphics = resizedImage.createGraphics();  
        graphics.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);  
        graphics.drawImage(originalImage, 0, 0, newWidth, newHeight, 0, 0, width, height, null);  
        graphics.dispose();  
        return resizedImage;  
    } 
	
	public String getFormatName(String fileName) {  

		String fileExtension = FilenameUtils.getExtension(fileName);
		if("png".equalsIgnoreCase(fileExtension)){
			return "png";
		}
		if("jpg".equalsIgnoreCase(fileExtension) || "jpeg".equalsIgnoreCase(fileExtension)){
			return "jpg";
		}
		if("bmp".equalsIgnoreCase(fileExtension)){
			return "bmp";
		}
		return null;
	}  

}
