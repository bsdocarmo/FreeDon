package sistdistribuido.com.freedon.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import sistdistribuido.com.freedon.dataBase.DataBaseHelper;
import sistdistribuido.com.freedon.models.City;
import sistdistribuido.com.freedon.models.User;

/**
 * Created by brunodocarmo on 10/12/17.
 */

public class CityDAO {
    private DataBaseHelper dataBaseHelper;
    private SQLiteDatabase sqliteDatabase;
    private String tableName = "city";
    private String columnID = "id";
    private String columnCityName = "cityName";

    public CityDAO(Context context) {
        try {
            dataBaseHelper = new DataBaseHelper(context);
            openDB();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Add a new city
    public void create(City city) {
        openDB();

        ContentValues contentValues = getCitiesData(city);
        sqliteDatabase.insert(tableName, null, contentValues);

        closeDB();
    }

    // Get all the cities saved in DB
    public List<City> getCities() {
        String query = "SELECT * FROM " + tableName;

        return getDB(query);
    }

    public City search(String column, int keyWord) {

        String query = "SELECT * FROM " + tableName + " WHERE " + column + " LIKE " + keyWord;

        return getDB(query).get(0);
    }

    // Delete the city
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

    public void update(City city) {
        ContentValues datas = getCitiesData(city);

        String[] params = {String.valueOf(city.getId())};
        sqliteDatabase.update(tableName, datas, columnID + " = ?", params);
    }

    private void openDB() {
        sqliteDatabase = dataBaseHelper.opendatabase();
    }

    private void closeDB() {
        sqliteDatabase.close();
    }

    private List<City> getDB(String query) {
        openDB();
        List<City> cities = new ArrayList<>();

        try {
            Cursor cursor = sqliteDatabase.rawQuery(query, null);
            while (cursor.moveToNext()) {
                City city = new City();

                city.setId((cursor.getInt(cursor.getColumnIndex(columnID))));
                city.setCityName(cursor.getString(cursor.getColumnIndex(columnCityName)));

                cities.add(city);
            }
            cursor.close();
        } finally {
            closeDB();
        }

        return cities;
    }

    private ContentValues getCitiesData(City city) {
        ContentValues contentValues = new ContentValues();

        contentValues.put(columnCityName, city.getCityName());

        return contentValues;
    }
}
