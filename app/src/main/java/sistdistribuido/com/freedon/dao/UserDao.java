package sistdistribuido.com.freedon.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import sistdistribuido.com.freedon.dataBase.DataBaseHelper;
import sistdistribuido.com.freedon.models.User;

/**
 * Created by brunodocarmo on 10/12/17.
 */

// Todo: passar as colunas para variaveis

public class UserDAO {

    private DataBaseHelper dataBaseHelper;
    private SQLiteDatabase sqLiteDatabase;
    private String tableName = "user";
    private String datePattern = "yyyy-MM-dd";

    public UserDAO(Context context) {

        try {
            dataBaseHelper = new DataBaseHelper(context);
            dataBaseHelper.createdatabase();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Add a new User
    public void create(User user) {
        openDB();

        ContentValues contentValues = getUsersData(user);

        sqLiteDatabase.insert(tableName, null, contentValues);
        closeDB();
    }

    public void update(User user) {
        openDB();
        ContentValues data = getUsersData(user);

        try {
            String[] params = {String.valueOf(user.getId())};
            sqLiteDatabase.update(tableName, data,
                    "id = ?", params);
        } finally {
            closeDB();
        }
    }

    // Delete the user
    public void delete(User user) {
        openDB();

        try {
            String[] params = {String.valueOf(user.getId())};
            sqLiteDatabase.delete(tableName, "id = ?", params);
        } finally {
            closeDB();
        }
    }

    // Get all the users storage in DB
    public List<User> getUsers() {
        String query = "SELECT * FROM " + tableName;

        return getDB(query);
    }

    private List<User> getDB(String query) {
        openDB();
        List<User> users = new ArrayList<>();
        try (Cursor cursor = sqLiteDatabase.rawQuery(query, null)) {
            while (cursor.moveToNext()) {
                User user = new User();

                user.setId(cursor.getInt(cursor.getColumnIndex("id")));
                user.setName(cursor.getString(cursor.getColumnIndex("name")));
                user.setEmail(cursor.getString(cursor.getColumnIndex("email")));
                user.setPassword(cursor.getString(cursor.getColumnIndex("password")));
                user.setProfileImage(cursor.getBlob(cursor.getColumnIndex("profileImage")));
                user.setDescription(cursor.getString(cursor.getColumnIndex("description")));

                DateFormat format = new SimpleDateFormat(datePattern, Locale.US);
                Date date = null;
                try {
                    date = format.parse(cursor.getString(cursor.getColumnIndex("birthdate")));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                user.setBirthDate(date);

                user.setPhoneNumber(cursor.getString(cursor.getColumnIndex("phoneNumber")));
                // TODO: chaves estrangeiras

                user.setHouseNumber(cursor.getInt(cursor.getColumnIndex("houseNumber")));
                user.setAdditionalInfo(cursor.getInt(cursor.getColumnIndex("additionalInfo")));

                users.add(user);
            }
        } finally {
            closeDB();
        }

        return users;
    }

    private ContentValues getUsersData(User user) {
        ContentValues contentValues = new ContentValues();

        contentValues.put("id", user.getId());
        contentValues.put("name", user.getName());
        contentValues.put("email", user.getEmail());
        contentValues.put("password", user.getPassword());
        contentValues.put("profileImage", user.getProfileImage());
        contentValues.put("description", user.getDescription());

        SimpleDateFormat dateFormat = new SimpleDateFormat(datePattern, Locale.US);
        contentValues.put("birthDate", dateFormat.format(user.getBirthDate()));

        contentValues.put("phone", user.getPhoneNumber());

        // TODO: chaves estrangeiras

        contentValues.put("houseNumber", user.getHouseNumber());
        contentValues.put("additionalInfo", user.getAdditionalInfo());

        return contentValues;
    }

    private void openDB() {
        sqLiteDatabase = dataBaseHelper.opendatabase();
    }

    private void closeDB() {
        sqLiteDatabase.close();
    }
}
