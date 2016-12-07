package banzoprojects.com.pet.alimentacao.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import banzoprojects.com.pet.alimentacao.dominio.Alimento;
import banzoprojects.com.pet.animal.dao.AnimalDAO;
import banzoprojects.com.pet.infra.DbHelper;
import banzoprojects.com.pet.infra.Sessao;

/**
 * Created by Antonio on 01/12/2016.
 */

public class AlimentoDao {
    private DbHelper dbHelper;
    private AnimalDAO animalDAO;

    public AlimentoDao(Context context) {
        dbHelper = new DbHelper((context));
        animalDAO=new AnimalDAO(context);
    }

    public long inserir(Alimento alimento) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(dbHelper.COLUNA_NOME_ALIMENTO, alimento.getNome());
        values.put(dbHelper.COLUNA_RECOMENDADO, alimento.getRecomendado());
        values.put(dbHelper.ID_ANIMAL, Sessao.getAnimal().get_idAnimal());

        String tabela = DbHelper.TABELA_ALIMENTO;

        long id = db.insert(tabela, null, values);
        db.close();

        return id;
    }

    public Alimento getAlimento(String nome) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        Cursor cursor = db.query(dbHelper.TABELA_ALIMENTO, new String[]{" * "}, " nome=? ", new String[]{nome}, null, null, null);

        Alimento alimento = null;
        if (cursor.moveToFirst()) {
            alimento = criarAlimento(cursor);
        }
        cursor.close();
        db.close();
        return alimento;
    }

    private Alimento criarAlimento(Cursor cursor) {
        Alimento alimento = new Alimento();
        alimento.set_id(cursor.getLong(0));
        alimento.setNome(cursor.getString(1));
        alimento.setRecomendado(cursor.getString(2));
        alimento.setAnimal(animalDAO.getAnimal(cursor.getLong(3)));
        return alimento;
    }

    public List<Alimento> listaAlimentoRecomendado() {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        List<Alimento> listaAlimentoRecomendado = new ArrayList<Alimento>();
        Cursor cursor = db.query(dbHelper.TABELA_ALIMENTO,new String[]{" * "} , dbHelper.ID_ANIMAL+ " = "+ Sessao.getAnimal().get_idAnimal() + " and " +dbHelper.COLUNA_RECOMENDADO + " = 'SIM'", null, null, null, null);
        if  (cursor.moveToFirst()) {
            while(cursor.isAfterLast()) {
                Alimento alimento = new Alimento(cursor.getLong(0),
                        cursor.getString(1),
                        cursor.getString(2));
                listaAlimentoRecomendado.add(alimento);
                cursor.moveToNext();
            }
        }
        cursor.close();
        return listaAlimentoRecomendado;
    }

    public List<Alimento> listaAlimentoNaoRecomendado() {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        List<Alimento> listaAlimentoNaoRecomendado = new ArrayList<Alimento>();
        Cursor cursor = db.query(dbHelper.TABELA_ALIMENTO,new String[]{" * "} , dbHelper.ID_ANIMAL+ " = "+ Sessao.getAnimal().get_idAnimal() + " and " +dbHelper.COLUNA_RECOMENDADO + " is not 'SIM'", null, null, null, null);
        if  (cursor.moveToFirst()) {
            while(cursor.isAfterLast()) {
                Alimento alimento = new Alimento(cursor.getLong(0),
                        cursor.getString(1),
                        cursor.getString(2));
                listaAlimentoNaoRecomendado.add(alimento);
                cursor.moveToNext();
            }
        }
        cursor.close();
        return listaAlimentoNaoRecomendado;
    }

    public ArrayList<String> getAlimentosRecomendado(long id) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String comando = "SELECT * FROM " + DbHelper.TABELA_ALIMENTO +
                " WHERE " + DbHelper.ID_ANIMAL + " LIKE ? AND " + DbHelper.COLUNA_RECOMENDADO + " = 'sim'";
        String idString = Long.toString(id);
        String [] argumentos = {idString};
        Cursor cursor = db.rawQuery(comando, argumentos);
        ArrayList<String> alimentosRecomendados = new ArrayList<String>();
        String caminhoColuna = DbHelper.COLUNA_NOME_ALIMENTO;
        int indexColunaCaminho = cursor.getColumnIndex(caminhoColuna);
        while(cursor.moveToNext()) {
            String caminho = cursor.getString(indexColunaCaminho);
            alimentosRecomendados.add(caminho);
        }
        cursor.close();
        db.close();
        return alimentosRecomendados;
    }

    public ArrayList<String> getAlimentosNaoRecomendado(long id) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String comando = "SELECT * FROM " + DbHelper.TABELA_ALIMENTO +
                " WHERE " + DbHelper.ID_ANIMAL + " LIKE ? AND " + DbHelper.COLUNA_RECOMENDADO + " is not 'sim'";
        String idString = Long.toString(id);
        String [] argumentos = {idString};
        Cursor cursor = db.rawQuery(comando, argumentos);
        ArrayList<String> alimentosNaoRecomendados = new ArrayList<String>();
        String caminhoColuna = DbHelper.COLUNA_NOME_ALIMENTO;
        int indexColunaCaminho = cursor.getColumnIndex(caminhoColuna);
        while(cursor.moveToNext()) {
            String caminho = cursor.getString(indexColunaCaminho);
            alimentosNaoRecomendados.add(caminho);
        }
        cursor.close();
        db.close();
        return alimentosNaoRecomendados;
    }

}
