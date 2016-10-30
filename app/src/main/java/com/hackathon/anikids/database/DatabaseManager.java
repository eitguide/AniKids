package com.hackathon.anikids.database;

/**
 * Created by nguyennghia on 10/27/16.
 */

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.hackathon.anikids.model.Animal;
import com.hackathon.anikids.model.Answer;
import com.hackathon.anikids.model.Question;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by NghiaNV on 01/09/2016.
 */
public class DatabaseManager extends SQLiteOpenHelper {
    private static final String TAG = "DatabaseManager";

    private static final String DATABASE_NAME = "ANIKIDS.db";
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_PATH = "/data/data/com.hackathon.anikids/databases/";

    private Context mContext;

    private static final String TABLE_QUOTE = "Anikids";
    private static final String ID_COLUMN = "id";
    private static final String NAME_VN_COLUMN = "name_vn";
    private static final String NAME_US_COLUMN = "name_us";
    private static final String AUDIO_URL_COLUMNN = "audio_url";
    private static final String IMAGE_URL_COLUMN = "image_url";
    private static final String STORY_COLUMN = "story";
    private static final String QUESTION_COLUMN = "question";
    private static final String STATUS_COLUMN = "status";


    private static DatabaseManager sInstance;

    public static synchronized DatabaseManager getInstance(Context context) {
        if (sInstance == null) {
            sInstance = new DatabaseManager(context.getApplicationContext());
        }
        return sInstance;
    }

    private DatabaseManager(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        Log.e(TAG, "DatabaseManager: ");
        mContext = context;
        boolean isExsits = isExistsDatabase();
        Log.e(TAG, "DatabaseManager: " + isExsits);
        if (!isExsits) {
            try {
                copyDataBase();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void copyDataBase() throws IOException {
        //Open your local db as the input stream
        InputStream myInput = mContext.getAssets().open("database/" + DATABASE_NAME);
        //Path to the just created empty db
        String outFileName = DATABASE_PATH + DATABASE_NAME;
        //Open the empty db as the output stream
        getReadableDatabase();
        close();
        OutputStream myOutput = new FileOutputStream(outFileName);
        //transfer bytes from the input file to the output file
        byte[] buffer = new byte[1024];
        int length;
        while ((length = myInput.read(buffer)) > 0) {
            myOutput.write(buffer, 0, length);
        }

        //Close the streams
        myOutput.flush();
        myOutput.close();
        myInput.close();
    }

    public boolean isExistsDatabase() {
        File file = new File(DATABASE_PATH + DATABASE_NAME);
        return file.exists();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.e(TAG, "onCreate: ");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.e(TAG, "onUpgrade: ");
        onCreate(db);
    }

    public List<Animal> getAllAnimals() {
        SQLiteDatabase db = getReadableDatabase();
        List<Animal> animals = new ArrayList<>();
        Cursor cursor = db.rawQuery("Select * from " + TABLE_QUOTE, null);
        if (cursor != null && cursor.moveToFirst()) {
            do {
                Animal animal = new Animal(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4),
                        cursor.getString(5), cursor.getString(6), cursor.getString(7));
                animals.add(animal);
            } while (cursor.moveToNext());
        }

        if (cursor != null)
            cursor.close();
        db.close();

        return animals;
    }

    public Animal getAnimalgetAnimalIdId(int id) {
        SQLiteDatabase db = getReadableDatabase();
        Animal animal = null;
        String sql = "Select * from " + TABLE_QUOTE + " where " + ID_COLUMN + " =  " + id;
        Cursor cursor = db.rawQuery(sql, null);
        if(cursor != null && cursor.moveToFirst()){
            animal = new Animal(cursor.getInt(0), cursor.getString(1), cursor.getString(2),
                    cursor.getString(3), cursor.getString(4), cursor.getString(5), cursor.getString(6), cursor.getString(7));
        }

        if (cursor != null)
            cursor.close();
        db.close();
        return animal;
    }
    public Question getRandomQuestion(){
        Question question = new Question();
        Answer answer1 = new Answer();
        Answer answer2 = new Answer();
        Answer answer3 = new Answer();
        Answer answer4 = new Answer();
        SQLiteDatabase db = getReadableDatabase();
        List<Animal> animals = new ArrayList<>();
        String sql = "Select * from " + TABLE_QUOTE ;
        Cursor cursor = db.rawQuery(sql, null);
        if(cursor != null && cursor.moveToFirst()){
            do {
                animals.add(new Animal(cursor.getInt(0), cursor.getString(1), cursor.getString(2),
                        cursor.getString(3), cursor.getString(4), cursor.getString(5), cursor.getString(6), cursor.getString(7)));
            }while (cursor.moveToNext());
        }
        int min = 1;
        int max = animals.size();
        int i = getRandomRange(min, max);

        switch (getRandomRange(1,4)){
            case 1:
                question.setQuestion(animals.get(1).getQuestion());
                answer1.setAnswer(animals.get(1).getNameVN());
                answer1.setTrue(true);
                answer2.setAnswer(animals.get(3).getNameVN());
                answer3.setAnswer(animals.get(11).getNameVN());
                answer4.setAnswer(animals.get(12).getNameVN());
                question.setAnswers1(answer1);
                question.setAnswers2(answer2);
                question.setAnswers3(answer3);
                question.setAnswers4(answer4);
                break;
            case 2:
                question.setQuestion(animals.get(5).getQuestion());
                answer2.setAnswer(animals.get(5).getNameVN());
                answer2.setTrue(true);
                answer1.setAnswer(animals.get(6).getNameVN());
                answer3.setAnswer(animals.get(18).getNameVN());
                answer4.setAnswer(animals.get(17).getNameVN());
                question.setAnswers1(answer1);
                question.setAnswers2(answer2);
                question.setAnswers3(answer3);
                question.setAnswers4(answer4);
                break;
            case 3:
                question.setQuestion(animals.get(8).getQuestion());
                answer3.setAnswer(animals.get(8).getNameVN());
                answer3.setTrue(true);
                answer2.setAnswer(animals.get(20).getNameVN());
                answer1.setAnswer(animals.get(21).getNameVN());
                answer4.setAnswer(animals.get(7).getNameVN());
                question.setAnswers1(answer1);
                question.setAnswers2(answer2);
                question.setAnswers3(answer3);
                question.setAnswers4(answer4);
                break;
            case 4:
                question.setQuestion(animals.get(9).getQuestion());
                answer4.setAnswer(animals.get(9).getNameVN());
                answer4.setTrue(true);
                answer2.setAnswer(animals.get(22).getNameVN());
                answer3.setAnswer(animals.get(4).getNameVN());
                answer1.setAnswer(animals.get(14).getNameVN());
                question.setAnswers1(answer1);
                question.setAnswers2(answer2);
                question.setAnswers3(answer3);
                question.setAnswers4(answer4);
                break;
        }
        return question;
    }
    private int getRandomRange(int min, int max){
        return new Random().nextInt(max - min + 1) + min;
    }

}

