package koder.nearme;

import android.app.Application;
import android.content.SharedPreferences;

import io.realm.Realm;

/**
 * Created by a7md on 5/1/17.
 */

public class App extends Application {

    private Realm realmDB;

    @Override
    public void onCreate() {
        super.onCreate();

        Realm.init(this);

        SharedPreferences preferences = getSharedPreferences("pref", MODE_PRIVATE);

        if (!preferences.contains("first_time")) {
            String[] titles = getResources().getStringArray(R.array.titles);
            String[] quantities = getResources().getStringArray(R.array.quantities);
            String[] calories = getResources().getStringArray(R.array.calories);

            realmDB = Realm.getDefaultInstance();

            realmDB.beginTransaction();

            for (int i = 0; i < titles.length; i++) {
                Product product = new Product();
                product.id = nextID();
                product.title = titles[i];
                product.quantity = quantities[i];
                product.calories = calories[i];

                realmDB.copyToRealm(product);
            }
            realmDB.commitTransaction();

            SharedPreferences.Editor editor = preferences.edit();
            editor.putBoolean("first_time", true);
            editor.apply();
        }
    }


    public long nextID(){
        Number id = realmDB.where(Product.class).max("id");
        return (id != null) ? id.longValue() + 1 : 1;
    }
}
