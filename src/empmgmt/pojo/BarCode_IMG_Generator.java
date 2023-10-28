/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empmgmt.pojo;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;

/**
 *
 * @author saumy
 */
public class BarCode_IMG_Generator {
    public static void createImage(String image_name,String myString){
        try
        {
            Code128Bean code128= new Code128Bean();
            code128.setHeight(15f);
            
            ByteArrayOutputStream baos= new  ByteArrayOutputStream();
            BitmapCanvasProvider canvas=new BitmapCanvasProvider(baos,"image/x-png",300,BufferImage.TYPE_BYTE_BINARY,false,0);
            
            code128.generateBarcode(canvas,myString);
            canvas.finish();
            
            String userdir=System.getProperty("userdir");
            System.out.println("user dir is:"+userdir);
            FileOutputStream fos=new FileOutputStream(userdir+"\\Barcode\\"+image_name);
            fos.write(baos.toByteArray());
            fos.flush();
            fos.close();
            
        }
        catch(Exception e){
            System.out.println("Exception in barcode generated"+e.getMessage());
        }
    }
    
}
