package model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class MySQLite extends SQLiteOpenHelper{

	
	// User COL
	private static final String TABLE_USER = "user";
	private static final String COL_ID_USER = "id";
	private static final String COL_FIRSTNAME = "firstname";
	private static final String COL_LASTNAME = "lastname";
	private static final String COL_PSOEUDO = "psoeudo";
	private static final String COL_MAIL = "mail";
	private static final String COL_PICPROFIL = "picprofil";
	
	
	private static final String BDD_USER = 	"CREATE TABLE " + TABLE_USER + " (" +
			COL_ID_USER + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
			COL_FIRSTNAME + " VARCHAR(30) NOT NULL, " +
			COL_LASTNAME + " VARCHAR(30) NOT NULL, " +
			COL_PSOEUDO + " VARCHAR(30) NOT NULL, " +
			COL_MAIL + " VARCHAR(40) , " +
			COL_PICPROFIL + " BLOB);" ;
	
	
	
	public MySQLite(Context context, String name, CursorFactory factory,
			int version) {
		super(context, name, factory, version);
	
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(BDD_USER);
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

		
	}

}
