package banzoprojects.com.pet.animal.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import banzoprojects.com.pet.animal.dominio.Animal;
import banzoprojects.com.pet.infra.DbHelper;

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
        values.put(dbHelper.COLUNA_ID_USUARIO, animal.getIdUsuario());

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
        animal.set_id(cursor.getInt(0));
        animal.setNome(cursor.getString(1));
        animal.setRaca(cursor.getString(2));
        animal.setSexo(cursor.getString(3));
        animal.setCor(cursor.getString(4));
        animal.setNascimento(cursor.getString(5));
        animal.setPeso(cursor.getDouble(6));
        animal.setAltura(cursor.getDouble(7));
        animal.setTipo(cursor.getString(8));
        animal.setIdUsuario(cursor.getInt(9));
        return animal;
    }
}