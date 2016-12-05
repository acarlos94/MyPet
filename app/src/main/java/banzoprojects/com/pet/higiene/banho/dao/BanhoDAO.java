package banzoprojects.com.pet.higiene.banho.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import banzoprojects.com.pet.higiene.banho.dominio.Banho;
import banzoprojects.com.pet.infra.DbHelper;


public class BanhoDAO {
    private DbHelper dbHelper;

    public BanhoDAO(Context context) {
        dbHelper = new DbHelper((context));
    }

    public long inserir(Banho banho) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(dbHelper.COLUNA_DATA_BANHO, banho.getDataBanho());
        values.put(dbHelper.COLUNA_LOCAL_BANHO, banho.getLocalBanho());
        values.put(dbHelper.COLUNA_DATA_PROX_BANHO, banho.getDataProxBanho());
        values.put(dbHelper.ANIMAL_ID, banho.getIdAnimal());

        String tabela = DbHelper.TABELA_BANHO;

        long id = db.insert(tabela, null, values);
        db.close();

        return id;
    }

//    public Banho getBanho(String idAnimal) {
//        SQLiteDatabase db = dbHelper.getWritableDatabase();
//
//        Cursor cursor = db.query(dbHelper.TABELA_BANHO, new String[]{" * "}, " idAnimal=? ", new String[]{idAnimal}, null, null, null);
//
//        Banho banho = null;
//        if (cursor.moveToFirst()) {
//            banho = criarBanho(cursor);
//        }
//        cursor.close();
//        db.close();
//        return banho;
//    }

    private Banho criarBanho(Cursor cursor) {
        Banho banho = new Banho();
        banho.set_id(cursor.getLong(0));
        banho.setDataBanho(cursor.getString(1));
        banho.setLocalBanho(cursor.getString(2));
        banho.setDataProxBanho(cursor.getString(3));
        banho.setIdAnimal(cursor.getLong(4));
        return banho;
    }

    public List<Banho> listaBanhos(String idAnimal) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        List<Banho> listaBanho= new ArrayList<Banho>();
        Cursor cursor = db.query(dbHelper.TABELA_BANHO,new String[]{" * "} , dbHelper.ANIMAL_ID+ " = ", new String[]{idAnimal}, null, null, null, null);
        if  (cursor.moveToFirst()) {
            while(cursor.isAfterLast()) {
                Banho banho = new Banho(cursor.getLong(0),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3),
                        cursor.getLong(4));
                listaBanho.add(banho);
                cursor.moveToNext();
            }
        }
        cursor.close();
        return listaBanho;
    }
//    public ArrayList<String> getBanhos(long id) {
//        SQLiteDatabase db = dbHelper.getReadableDatabase();
//        String comando = "SELECT * FROM " + DbHelper.TABELA_BANHO +
//                " WHERE " + DbHelper.ANIMAL_ID + " LIKE ?";
//        String idString = Long.toString(id);
//        String [] argumentos = {idString};
//        Cursor cursor = db.rawQuery(comando, argumentos);
//
//        ArrayList<String> nomeAnimal = new ArrayList<String>();
//        String caminhoColuna = DbHelper.COLUNA_NOME;
//        int indexColunaCaminho = cursor.getColumnIndex(caminhoColuna);
//        while(cursor.moveToNext()) {
//            String caminho = cursor.getString(indexColunaCaminho);
//            nomeAnimal.add(caminho);
//        }
//        cursor.close();
//        db.close();
//        return nomeAnimal;
//    }
}