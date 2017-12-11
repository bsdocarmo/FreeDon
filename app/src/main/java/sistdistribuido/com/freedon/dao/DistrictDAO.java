package sistdistribuido.com.freedon.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import sistdistribuido.com.freedon.dataBase.DataBaseHelper;
import sistdistribuido.com.freedon.models.District;
import sistdistribuido.com.freedon.models.User;

/**
 * Created by brunodocarmo on 10/12/17.
 */

public class DistrictDAO {
    private DataBaseHelper dataBaseHelper;
    private SQLiteDatabase sqliteDatabase;
    private String tableName = "district";
    private String columnID = "id";
    private String columnDistrictName = "districtName";

    public DistrictDAO(Context context) {
        try {
            dataBaseHelper = new DataBaseHelper(context);
            openDB();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Add a new district
    public void create(District district) {
        openDB();

        ContentValues contentValues = getDistrictsData(district);
        sqliteDatabase.insert(tableName, null, contentValues);

        closeDB();
    }

    // Get all the districts saved in DB
    public List<District> getDistricts() {
        String query = "SELECT * FROM " + tableName;

        return getDB(query);
    }

    public District search(String column, int keyWord) {

        String query = "SELECT * FROM " + tableName + " WHERE " + column + " LIKE " + keyWord;

        return getDB(query).get(0);
    }

    // Delete the district
    public void delete(User user) {
        openDB();

        try {
            String [] params = {String.valueOf(user.getId())};
            sqliteDatabase.delete(tableName, columnID+ " = ?", params);
            sqliteDatabase.close();
        } finally {
            closeDB();
        }
    }

    public void update(District district) {
        ContentValues datas = getDistrictsData(district);

        String[] params = {String.valueOf(district.getId())};
        sqliteDatabase.update(tableName, datas, columnID + " = ?", params);
    }

    private void openDB() {
        sqliteDatabase = dataBaseHelper.opendatabase();
    }

    private void closeDB() {
        sqliteDatabase.close();
    }

    private List<District> getDB(String query) {
        openDB();
        List<District> districts = new ArrayList<>();

        try {
            Cursor cursor = sqliteDatabase.rawQuery(query, null);
            while (cursor.moveToNext()) {
                District district = new District();

                district.setId((cursor.getInt(cursor.getColumnIndex(columnID))));
                district.setDistrictName(cursor.getString(cursor.getColumnIndex(columnDistrictName)));

                districts.add(district);
            }
            cursor.close();
        } finally {
            closeDB();
        }

        return districts;
    }

    private ContentValues getDistrictsData(District district) {
        ContentValues contentValues = new ContentValues();

        contentValues.put(columnDistrictName, district.getDistrictName());

        return contentValues;
    }
}
