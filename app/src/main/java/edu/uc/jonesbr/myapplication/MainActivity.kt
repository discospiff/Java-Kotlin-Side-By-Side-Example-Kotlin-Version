package edu.uc.jonesbr.myapplication

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.ArrayAdapter
import edu.uc.jonesbr.myapplication.dto.Food

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {

    private var allFoods  = ArrayList<Food>()
    private var food = Food()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

        actType.setOnItemClickListener { parent, view, position, id ->
            // TODO do something here, like change the color based on the cuisine.
        }

        btnSave.setOnClickListener {
            save()
        }
        prepopulateFoods()
        updateSpinner()
    }

    private fun prepopulateFoods() {
        val mustard = Food("Mustard", 0, "1.29", "0")
        allFoods.add(mustard)
        val pickles = Food("Pickles")
        allFoods.add(pickles)
        val pawpaw = Food("Paw Paw", 100, "10.00")
        allFoods.add(pawpaw)
        val fujiApple = Food(name="Fuji Apple", cost="1.99")
        allFoods.add(fujiApple)
    }

    private fun save() {
        with (food) {
            name = edtName.text.toString()
            if (edtCalories.text.toString().trim().length > 0) {
                calories = Integer.parseInt(edtCalories.text.toString())
            }
            cost = edtCost.text.toString()
            prepTime = edtPrepTime.text.toString()
            type = actType.text.toString()
        }
        allFoods.add(food)
        food = Food()
        // updateSpinner()
    }

    private fun updateSpinner() {
        val adapter = ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, allFoods)
        spnFood.adapter = adapter
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
