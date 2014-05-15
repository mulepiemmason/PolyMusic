package model;

import java.util.ArrayList;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class UtilisateurDB {

	@SuppressLint("SdCardPath")
	private static final String USERS_PATH = new String("/sdcard/Users");
	
	private static final int VERSION_BDD = 1;
	private static final String NOM_BDD = "users.db";
	
	
	// User COL
		private static final String TABLE_USER = "user";
		private static final String COL_ID_USER = "id";
		private static final String COL_FIRSTNAME = "firstname";
		private static final String COL_LASTNAME = "lastname";
		private static final String COL_PSOEUDO = "psoeudo";
		private static final String COL_MAIL = "mail";
		private static final String COL_PICPROFIL = "picprofil";
		
		private SQLiteDatabase db;
		private MySQLite myDbLite;
		
		public UtilisateurDB(Context context){
			// Create the DB SQLite
			myDbLite = new MySQLite(context, NOM_BDD, null, VERSION_BDD);
		}
		
		public void open(){
			// Open our DB
			db = myDbLite.getWritableDatabase();
		}
	 
		public void close(){
			// Close our DB
			db.close();
		}
		
		public SQLiteDatabase getBDD(){
			// return db object
			return db;
		}
		
		public MySQLite getMyDb(){
			// return db object
			return myDbLite;
		}
		
		public long addMusic(Utilisateur u) {
			ContentValues values = new ContentValues();
			values.put(COL_FIRSTNAME, u.getNom());
			values.put(COL_ID_USER, u.getId());
			values.put(COL_LASTNAME, u.getPrenom());
			values.put(COL_PSOEUDO, u.getPsoeudo());
			values.put(COL_MAIL, u.getMail());
			values.put(COL_PICPROFIL, u.getPhotoDeProfil());


			return db.insert(TABLE_USER, null, values);
		}
		
		public int deleteMusic(int id) {
			return db.delete(TABLE_USER, COL_ID_USER + "=" + id, null);
		}
		
		public Cursor getAllMusic() {
			return db.query(TABLE_USER, null, null, null, null, null, null);
		}

		
		public ArrayList<Utilisateur> cursorToMusic(Cursor c) {
			ArrayList<Utilisateur> list = new ArrayList<Utilisateur>();
			boolean isNotEmpty = c.moveToFirst();
			while(isNotEmpty) {
				Utilisateur u = new Utilisateur();
				u.setId(c.getInt(c.getColumnIndexOrThrow(COL_ID_USER)));
				u.setNom(c.getString(c.getColumnIndexOrThrow(COL_FIRSTNAME)));
				u.setPrenom(c.getString(c.getColumnIndexOrThrow(COL_LASTNAME)));
				u.setMail(c.getString(c.getColumnIndexOrThrow(COL_MAIL)));
				u.setPsoeudo(c.getString(c.getColumnIndexOrThrow(COL_PSOEUDO)));
				u.setPhotoDeProfil(c.getBlob(c.getColumnIndexOrThrow(COL_PICPROFIL)));
				
				list.add(u);
				isNotEmpty = c.moveToNext();
			}
			list.trimToSize();
			return list;
		}
		
		
		
		public int updateMusicComparedWithSD(Utilisateur u) {
			ContentValues values = new ContentValues();
			values.put(COL_ID_USER, u.getId());
			values.put(COL_FIRSTNAME, u.getNom());
			values.put(COL_LASTNAME, u.getPrenom());
			values.put(COL_MAIL, u.getMail());
			values.put(COL_PSOEUDO, u.getPsoeudo());
			values.put(COL_PICPROFIL, u.getPhotoDeProfil());
			return db.update(TABLE_USER, values, COL_ID_USER+"="+u.getId(), null);
		}
		
}
