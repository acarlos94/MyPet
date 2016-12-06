package banzoprojects.com.pet.vacina.dao;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import banzoprojects.com.pet.infra.DbHelper;
import banzoprojects.com.pet.infra.Sessao;
import banzoprojects.com.pet.vacina.dominio.Vacina;

public class VacinaDAO {
    private DbHelper dbHelper;

    public VacinaDAO(Context context){dbHelper = new DbHelper(context);}

    public long inserir(Vacina vacina){
        SQLiteDatabase db= dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(dbHelper.COLUNA_NOME_VACINA, vacina.getNome_vacina());
        values.put(dbHelper.COLUNA_DATA_VACINA, vacina.getData_vacina());
        values.put(dbHelper.COLUNA_LOCAL, vacina.getLocal());
        values.put(dbHelper.COLUNA_DATA_PROXIMA_VACINA, vacina.getProxima_vacina());
//        mudar
//        values.put(dbHelper.ANIMAL_ID, Sessao.getUsuario().get_idUsuario());


        String tabela = dbHelper.TABELA_VACINAS;

        long id = db.insert(tabela, null, values);
        db.close();
        return id;
    }
    public Vacina getVacina(String nome){
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        Cursor cursor = db.query(dbHelper.TABELA_VACINAS, new String[]{" * "}, " nome=? ", new String[]{nome}, null, null, null);

        Vacina vacina=null;
        if (cursor.moveToFirst()){
            vacina = criarVacina(cursor);
        }
        cursor.close();
        db.close();
        return vacina;
    }
    private Vacina criarVacina(Cursor cursor){
        Vacina vacina = new Vacina();
        vacina.set_id(cursor.getLong(0));
        vacina.setNome_vacina(cursor.getString(1));
        vacina.setData_vacina(cursor.getString(2));
        vacina.setLocal(cursor.getString(3));
        vacina.setProxima_vacina(cursor.getString(4));
        return vacina;
    }

    public List<Vacina> listaVacinas(){
        SQLiteDatabase db=dbHelper.getReadableDatabase();
        List<Vacina>listaVacina=new ArrayList<Vacina>();

        Cursor cursor = db.query(dbHelper.TABELA_VACINAS,new String[]{" * "} , dbHelper.ANIMAL_ID+ " = "+ Sessao.getAnimal().get_idAnimal(), null, null, null, null);
        if (cursor.moveToFirst()) {
            while (cursor.isAfterLast()) {
                Vacina vacina = new Vacina(cursor.getLong(0),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3),
                        cursor.getString(4));
                listaVacina.add(vacina);
                cursor.moveToNext();
            }
        }
        cursor.close();
        return listaVacina;
    }

    public ArrayList<String> getVacinais(long id){
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String comando = "SELECT * FROM " + DbHelper.TABELA_VACINAS +
                " WHERE " + DbHelper.ANIMAL_ID + " LIKE ?";
        String idString = Long.toString(id);
        String [] argumentos = {idString};
        Cursor cursor = db.rawQuery(comando, argumentos);
        ArrayList<String> nomeVacina = new ArrayList<String>();
        String caminhoColuna = dbHelper.COLUNA_NOME_VACINA;
        int indexColunaCaminho = cursor.getColumnIndex(caminhoColuna);
        while (cursor.moveToNext()){
            String caminho = cursor.getString(indexColunaCaminho);
            nomeVacina.add(caminho);
        }
        cursor.close();
        db.close();
        return nomeVacina;
    }
}
