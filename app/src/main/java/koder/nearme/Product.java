package koder.nearme;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by a7md on 5/1/17.
 */

public class Product extends RealmObject {

    @PrimaryKey
    public long id;
    public String title;
    public String quantity;
    public String calories;

    public Product() {
        this.id = 0;
        this.title = "";
        this.quantity = "";
        this.calories = "";
    }
}
