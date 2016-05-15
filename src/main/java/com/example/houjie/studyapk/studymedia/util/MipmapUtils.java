package com.example.houjie.studyapk.studymedia.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by hj on 2016/5/9.
 */
public class MipmapUtils {
    public static  Bitmap  ZipBitmap(String from){
        BitmapFactory.Options options = new BitmapFactory.Options();
        //只得到图片的宽和高
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(from,options);
        //设置图片的压缩比例
        options.inSampleSize = computsampleSize(options,20,32);
        //
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeFile(from,options);
    }

    private static int computsampleSize(BitmapFactory.Options options, int wight, int hight) {
        int w = options.outWidth;
        int h = options.outHeight;
        int inSampleSize = 1;
        if(h>hight||w>wight){
            int heigthR = Math.round(h/hight);
            int wightR = Math.round(w/wight);
            inSampleSize = heigthR>wightR?wightR:heigthR;
            Log.i("h>hight||w>wight","+++++++++++++++"+inSampleSize);
        }
        if(h<hight||w<wight){
            int heigthR = Math.round(hight/h);
            int wightR = Math.round(wight/w);
            inSampleSize = heigthR>wightR?wightR:heigthR;
            Log.i("h<hight||w<wight","+++++++++++++++"+inSampleSize);
        }
        return inSampleSize;
    }

    /**
     * 保存图片
     * @param bmp
     * @param absolutePath 保存文件的绝对路径及文件名，包括后缀
     */
    private void saveCroppedImage(Bitmap bmp,String absolutePath){

    }

    private void saveCroppedImage(Bitmap bmp,String absoluteDirPath,String name) {
        File file = new File(absoluteDirPath);
        if (!file.exists())
            file.mkdir();
        file = new File(name.trim());
        String fileName = file.getName();
        String mName = fileName.substring(0, fileName.lastIndexOf("."));
        String sName = fileName.substring(fileName.lastIndexOf("."));
        // /sdcard/myFolder/temp_cropped.jpg
        String newFilePath = "/sdcard/myFolder" + "/" + mName + "_cropped" + sName;
        file = new File(newFilePath);
        try {
        file.createNewFile();
        FileOutputStream fos = new FileOutputStream(file);
        bmp.compress(Bitmap.CompressFormat.JPEG, 50, fos);
        fos.flush();
        fos.close();
        } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
        }
        }
}
