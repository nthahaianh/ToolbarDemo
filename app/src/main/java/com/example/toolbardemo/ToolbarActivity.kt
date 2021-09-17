package com.example.toolbardemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.fragment.app.Fragment

class ToolbarActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_toolbar)
        replaceFragment(Fragment1())
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.search -> {
                Toast.makeText(this, "Search selected", Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.item1 -> {
                replaceFragment(Fragment1())
                return true
            }
            R.id.item2 -> {
                replaceFragment(Fragment2())
                return true
            }
            R.id.item3 -> {
                replaceFragment(Fragment3())
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun replaceFragment(fragment: Fragment){
        val transaction = supportFragmentManager?.beginTransaction()
        transaction.replace(R.id.main_container, fragment)
        transaction.commit()
    }
}