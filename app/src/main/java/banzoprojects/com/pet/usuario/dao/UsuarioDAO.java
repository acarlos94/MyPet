package banzoprojects.com.pet.usuario.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import banzoprojects.com.pet.infra.DbHelper;
import banzoprojects.com.pet.usuario.dominio.Usuario;


public class UsuarioDAO {
    private DbHelper dbHelper;
    private SQLiteDatabase database;

    public UsuarioDAO(Context context){

        dbHelper = new DbHelper(context);
    }

    private SQLiteDatabase getDatabase(){
        if(database==null){
            database = dbHelper.getWritableDatabase();
        }
        return database;
    }

    public long inserir(Usuario usuario){
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        String nome = DbHelper.COLUNA_NOME;
        String email = DbHelper.COLUNA_EMAIL;
        String senha = DbHelper.COLUNA_SENHA;

        values.put(nome, usuario.getNome());
        values.put(email, usuario.getEmail());
        values.put(senha, usuario.getSenha());

        String tabela = DbHelper.TABELA_USUARIO;

        long id = db.insert(tabela, null, values);
        db.close();

        return id;
    }

    public Usuario getUsuario(String email, String senha) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        String comando = "SELECT * FROM " + DbHelper.TABELA_USUARIO +
                " WHERE " + DbHelper.COLUNA_EMAIL + " LIKE ? AND " +
                DbHelper.COLUNA_SENHA + " LIKE ?";
        String[] argumentos = {email, senha};
        Cursor cursor = db.rawQuery(comando, argumentos);
        Usuario usuario = null;
        if (cursor.moveToNext()){
            usuario = criarUsuario(cursor);
        }
        cursor.close();
        db.close();
        return usuario;
    }

    public Usuario getUsuario(Usuario usuario) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        String email = usuario.getEmail();
        String senha = usuario.getSenha();

        Cursor cursor = db.query(dbHelper.TABELA_USUARIO,new String[]{" * "}, " email=? and senha=?", new String[]{email, senha}, null, null, null);

        Usuario usuarioVerificado = null;
        if  (cursor.moveToFirst()){
            usuarioVerificado = criarUsuario(cursor);
        }
        cursor.close();
        db.close();
        return usuarioVerificado;
    }

    public Usuario getUsuario(String email) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        Cursor cursor = db.query(dbHelper.TABELA_USUARIO,new String[]{" * "}, " email=?", new String[]{email}, null, null, null);

        Usuario usuario = null;
        if  (cursor.moveToFirst()){
            usuario = criarUsuario(cursor);
        }
        cursor.close();
        db.close();
        return usuario;

    }
    public Usuario getUsuario(Long id){
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        Cursor cursor = db.query(dbHelper.TABELA_USUARIO,new String[]{" * "}, " _id=?",
                new String[]{id.toString()}, null, null, null);

        Usuario usuario = null;
        if  (cursor.moveToFirst()){
            usuario = criarUsuario(cursor);
        }
        cursor.close();
        db.close();
        return usuario;
    }

    private Usuario criarUsuario(Cursor cursor) {
        Usuario usuario = new Usuario();
        usuario.set_idUsuario(cursor.getLong(0));
        usuario.setNome(cursor.getString(1));
        usuario.setEmail(cursor.getString(2));
        usuario.setSenha(cursor.getString(3));

        return usuario;
    }


//    public List<Usuario> listarUsuarios() {
//
//        List<Usuario> usuarios = new ArrayList<>();
//
//        Cursor cursor = getDatabase().query(dbHelper.TABELA_USUARIO,new String[]{" * "} , dbHelper.USUARIO_ID+ " = "+ Sessao.getUsuario().get_idUsuario(), null, null, null, null);
//
//
//        if  (cursor.moveToFirst()) {
//            while(cursor.isAfterLast()) {
//                Usuario usuario = new Usuario(cursor.getInt(0),
//                        cursor.getString(1),
//                        cursor.getString(2),
//                        cursor.getString(3));
//                usuarios.add(usuario);
//                cursor.moveToNext();
//            }
//        }
//        cursor.close();
//        return usuarios;
//    }
}