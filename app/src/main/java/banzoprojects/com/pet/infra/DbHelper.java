package banzoprojects.com.pet.infra;



import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper {
    public static final String TAG = DbHelper.class.getSimpleName();
    public static final String DB_NOME = "mypet.db";
    public static final int DB_VERSAO = 1;

    //atributos da tabela pessoa
    public static final String TABELA_USUARIO ="usuario";
    public static final String COLUNA_ID = "_id";
    public static final String COLUNA_NOME = "nome";
    public static final String COLUNA_EMAIL = "email";
    public static final String COLUNA_SENHA = "senha";

    //atributos da tabela animal
    public static final String TABELA_ANIMAL = "animais";
    public static final String COLUNA_RACA = "raca";
    public static final String COLUNA_SEXO = "sexo";
    public static final String COLUNA_COR = "cor";
    public static final String COLUNA_NASCIMENTO = "nascimento";
    public static final String COLUNA_PESO = "peso";
    public static final String COLUNA_ALTURA = "altura";
    public static final String COLUNA_TIPO = "tipo";
    public static final String COLUNA_ID_USUARIO = "id_usuario";



    public DbHelper(Context context) {

        super(context, DB_NOME, null, DB_VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABELA_USUARIO + "("
                + COLUNA_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUNA_NOME + " TEXT,"
                + COLUNA_EMAIL + " TEXT,"
                + COLUNA_SENHA + " TEXT);");


        db.execSQL("CREATE TABLE " + TABELA_ANIMAL + "("
                + COLUNA_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUNA_NOME + " TEXT,"
                + COLUNA_RACA + " TEXT,"
                + COLUNA_SEXO + " TEXT,"
                + COLUNA_COR + " TEXT,"
                + COLUNA_NASCIMENTO + " DATE,"
                + COLUNA_PESO + " DOUBLE,"
                + COLUNA_ALTURA + " DOUBLE,"
                + COLUNA_TIPO + " TEXT,"
                + COLUNA_ID_USUARIO + "INTEGER);");

    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXIST " + TABELA_USUARIO);
        db.execSQL("DROP TABLE IF EXIST " + TABELA_ANIMAL);
        onCreate(db);

    }
}