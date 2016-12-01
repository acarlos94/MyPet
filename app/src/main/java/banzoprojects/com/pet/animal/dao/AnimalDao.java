package banzoprojects.com.pet.animal.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import banzoprojects.com.pet.animal.dominio.Animal;
import banzoprojects.com.pet.infra.DbHelper;
import banzoprojects.com.pet.infra.Sessao;

public class AnimalDAO {
    private DbHelper dbHelper;

    public AnimalDAO(Context context) {
        dbHelper = new DbHelper((context));
    }

    public long inserir(Animal animal) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(dbHelper.COLUNA_NOME, animal.getNome());
        values.put(dbHelper.COLUNA_RACA, animal.getRaca());
        values.put(dbHelper.COLUNA_SEXO, animal.getSexo());
        values.put(dbHelper.COLUNA_COR, animal.getCor());
        values.put(dbHelper.COLUNA_NASCIMENTO, animal.getNascimento());
        values.put(dbHelper.COLUNA_PESO, animal.getPeso());
        values.put(dbHelper.COLUNA_ALTURA, animal.getAltura());
        values.put(dbHelper.COLUNA_TIPO, animal.getTipo());
        values.put(dbHelper.USUARIO_ID, Sessao.getUsuario().get_idUsuario());

        String tabela = DbHelper.TABELA_ANIMAL;

        long id = db.insert(tabela, null, values);
        db.close();

        return id;
    }

    public Animal getAnimal(String nome) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        Cursor cursor = db.query(dbHelper.TABELA_ANIMAL, new String[]{" * "}, " nome=? ", new String[]{nome}, null, null, null);

        Animal animal = null;
        if (cursor.moveToFirst()) {
            animal = criarAnimal(cursor);
        }
        cursor.close();
        db.close();
        return animal;
    }

    private Animal criarAnimal(Cursor cursor) {
        Animal animal = new Animal();
        animal.set_id(cursor.getLong(0));
        animal.setNome(cursor.getString(1));
        animal.setRaca(cursor.getString(2));
        animal.setSexo(cursor.getString(3));
        animal.setCor(cursor.getString(4));
        animal.setNascimento(cursor.getString(5));
        animal.setPeso(cursor.getString(6));
        animal.setAltura(cursor.getString(7));
        animal.setTipo(cursor.getString(8));
        animal.setIdUsuario(cursor.getLong(9));
        return animal;
    }
    public List<Animal> listaAnimais() {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        List<Animal> listaAnimal = new ArrayList<Animal>();
        Cursor cursor = db.query(dbHelper.TABELA_ANIMAL,new String[]{" * "} , dbHelper.USUARIO_ID+ " = "+ Sessao.getUsuario().get_idUsuario(), null, null, null, null);
        if  (cursor.moveToFirst()) {
            while(cursor.isAfterLast()) {
                Animal animal = new Animal(cursor.getLong(0),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3),
                        cursor.getString(4),
                        cursor.getString(5),
                        cursor.getString(6),
                        cursor.getString(7),
                        cursor.getString(8),
                        cursor.getLong(9));
                listaAnimal.add(animal);
                cursor.moveToNext();
            }
        }
        cursor.close();
        return listaAnimal;
    }
    public ArrayList<String> getAnimais(long id) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String comando = "SELECT * FROM " + DbHelper.TABELA_ANIMAL +
                " WHERE " + DbHelper.USUARIO_ID + " LIKE ?";
        String idString = Long.toString(id);
        String [] argumentos = {idString};
        Cursor cursor = db.rawQuery(comando, argumentos);
        ArrayList<String> nomeAnimal = new ArrayList<String>();
        String caminhoColuna = DbHelper.COLUNA_NOME;
        int indexColunaCaminho = cursor.getColumnIndex(caminhoColuna);
        while(cursor.moveToNext()) {
            String caminho = cursor.getString(indexColunaCaminho);
            nomeAnimal.add(caminho);
        }
        cursor.close();
        db.close();
        return nomeAnimal;
    }

}