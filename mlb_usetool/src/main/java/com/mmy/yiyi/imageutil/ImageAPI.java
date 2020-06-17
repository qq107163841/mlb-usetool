package com.mmy.yiyi.imageutil;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.PixelFormat;
import android.graphics.drawable.Drawable;
import android.os.Environment;
import android.util.Log;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 * 安卓关于图片的转换交流工具-mlb
 */
public class ImageAPI {
    /**
     * //根据路径获取图片文件
     * @param filePath
     * @param scale 使BitmapFactory分配更少的空间 对原图降采样
     * @return
     */
    public static Bitmap getImageByFilePath(String filePath, int scale) {
        Bitmap res = null;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(filePath, options);
        options.inJustDecodeBounds = false;
        options.inSampleSize = scale;
        options.inPreferredConfig = Bitmap.Config.ARGB_4444;
        return res;
    }

    /**
     * //按宽高压缩载入图片
     * @param filePath 路径
     * @param Towidth 宽
     * @param ToHeight 高
     * @return
     */
    public static Bitmap getImageByFilePath(String filePath, int Towidth, int ToHeight) {
        Bitmap res = null;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        if (!new File(filePath).exists())
            return res;
        BitmapFactory.decodeFile(filePath, options);

        int origionalWidth = options.outHeight;
        int origionalHeight = options.outWidth;
        options.inJustDecodeBounds = false;
        int scale = Math.max(origionalWidth / Towidth, origionalHeight / ToHeight);
        options.inSampleSize = scale;
        options.inPreferredConfig = Bitmap.Config.ARGB_4444;
        try {
            res = BitmapFactory.decodeFile(filePath, options);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } catch (OutOfMemoryError e) {
            e.printStackTrace();
            return null;
        }
        return res;
    }


    /**
     * 把byte转成文件保存本地
     * @param bytes 流
     * @param document 本地的文件名
     * @param imageName 图片的名字
     * @param imageType 图片的类型 .jpg .png
     */
    public static void bytesToImageFile(byte[] bytes,String document,String imageName,String imageType) {
        try {
            String path= Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator
                    + document+"/";
            File folder=new File(path);
            if(!folder.exists()){
                folder.mkdir();
            }
            String savePath = path + imageName + imageType;
            DataOutputStream fos = new DataOutputStream(new BufferedOutputStream(new BufferedOutputStream(new FileOutputStream(savePath))));
            fos.write(bytes, 0, bytes.length);
            fos.flush();
            fos.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    /**
     *
     * @param photo
     * @param document 本地的文件名
     * @param imageName 图片的名字
     * @param imageType 图片的类型 .jpg .png
     * @return
     */
    public static boolean saveImage(Bitmap photo,String document,String imageName,String imageType) {
        try {
            String path= Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator
                    + document+"/";
            File folder=new File(path);
            if(!folder.exists()){
                folder.mkdir();
            }
            String savePath = path + imageName + imageType;
            BufferedOutputStream bos = new BufferedOutputStream(
                    new FileOutputStream(savePath, false));
            photo.compress(Bitmap.CompressFormat.JPEG, 100, bos);
            bos.flush();
            bos.close();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * drawable转Bitmap
     * @param drawable
     * @return
     */
    public static Bitmap drawableToBitmap(Drawable drawable) {
        // 取 drawable 的长宽
        int w = drawable.getIntrinsicWidth();
        int h = drawable.getIntrinsicHeight();

        // 取 drawable 的颜色格式
        Bitmap.Config config = drawable.getOpacity() != PixelFormat.OPAQUE ? Bitmap.Config.ARGB_8888
                : Bitmap.Config.RGB_565;
        // 建立对应 bitmap
        Bitmap bitmap = Bitmap.createBitmap(w, h, config);
        // 建立对应 bitmap 的画布
        Canvas canvas = new Canvas(bitmap);
        drawable.setBounds(0, 0, w, h);
        // 把 drawable 内容画到画布中
        drawable.draw(canvas);
        return bitmap;
    }

    /**
     * 直接载入图片
     * @param path
     * @return
     */
    public static Bitmap getBitmap(String path) {
        return BitmapFactory.decodeFile(path);
    }



}
