package com.nguyenlinh.android.mygooglemaps.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by nguye on 3/8/2017.
 *
 */

public class DatabaseCoppy {
    private static String DATABASE_NAME = "DiaDiemDB.sqlite";
    private static final String DB_PATH_SUFFIX = "/databases/";
    public static SQLiteDatabase database=null;

    private Context context;
    public DatabaseCoppy(Context context){
        this.context = context;
    }

    public void xuLySaoChepCSDL() {
        File dbFile = context.getDatabasePath(DATABASE_NAME);
        if (!dbFile.exists()){
            try{
                CoppyDataBaseAsset();
                Toast.makeText(this.context,"Coppying sucess from" +
                        "Assets folder", Toast.LENGTH_LONG).show();
            } catch (Exception ex){
                Toast.makeText(this.context, ex.toString(),Toast.LENGTH_LONG).show();
            }
        }
    }

    private void CoppyDataBaseAsset() {
        try{
            InputStream myInput;
            //Lấy đường dẫn SQLite
            myInput = context.getAssets().open(DATABASE_NAME);
            //Lấy đường dẫn thư mục gốc
            String outFileName= LayDuongDanLuuTru();

            File f = new File(context.getApplicationInfo().dataDir+DB_PATH_SUFFIX);
            //Kiểm tra tồn tại
            if(!f.exists()){
                f.mkdir();
            }
            //Mở db rỗng từ outputStream
            OutputStream myOutput = new FileOutputStream(outFileName);
            //Lấy dữ liệu từ inputFile lên outputFile
            byte[] buffer = new byte[1024];
            int length;
            while ((length = myInput.read(buffer)) > 0){
                //ghi file
                myOutput.write(buffer,0,length);
            }
            //Đóng file
            myOutput.flush();
            myOutput.close();
            myInput.close();
        } catch (Exception ex){
            Log.e("Loi_SaoChep",ex.toString());
        }
    }

    public String LayDuongDanLuuTru() {
        return context.getApplicationInfo().dataDir + DB_PATH_SUFFIX+
                DATABASE_NAME;
    }
}
