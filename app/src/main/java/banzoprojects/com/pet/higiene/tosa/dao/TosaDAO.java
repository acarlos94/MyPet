package banzoprojects.com.pet.higiene.tosa.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import banzoprojects.com.pet.higiene.tosa.dominio.Tosa;
import banzoprojects.com.pet.infra.DbHelper;


public class TosaDAO {
    private DbHelper dbHelper;

    public TosaDAO(Context context) {
        dbHelper = new DbHelper((context));
    }

    public long inserir(Tosa tosa) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(dbHelper.COLUNA_DATA_TOSA, tosa.getDataTosa());
        values.put(dbHelper.COLUNA_LOCAL_TOSA, tosa.getLocalTosa());
        values.put(dbHelper.COLUNA_DATA_PROX_TOSA, tosa.getDataProxTosa());
        values.put(dbHelper.ANIMAL_ID, tosa.getIdAnimal());

        String tabela = DbHelper.TABELA_TOSA;

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

    private Tosa criarTosa(Cursor cursor) {
        Tosa tosa = new Tosa();
        tosa.set_id(cursor.getLong(0));
        tosa.setDataTosa(cursor.getString(1));
        tosa.setLocalTosa(cursor.getString(2));
        tosa.setDataProxTosa(cursor.getString(3));
        tosa.setIdAnimal(cursor.getLong(4));
        return tosa;
    }

    public List<Tosa> listaTosas(String idAnimal) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        List<Tosa> listaTosa = new ArrayList<Tosa>();
        Cursor cursor = db.query(dbHelper.TABELA_TOSA, new String[]{" * "}, dbHelper.ANIMAL_ID + " = ", new String[]{idAnimal}, null, null, null, null);
        if (cursor.moveToFirst()) {
            while (cursor.isAfterLast()) {
                Tosa tosa = new Tosa(cursor.getLong(0),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3),
                        cursor.getLong(4));
                listaTosa.add(tosa);
                cursor.moveToNext();
            }
        }
        cursor.close();
        return listaTosa;
    }
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
