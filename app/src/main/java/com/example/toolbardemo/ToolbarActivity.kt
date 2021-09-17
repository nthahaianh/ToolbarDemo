package com.example.toolbardemo

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_toolbar.*
import kotlinx.android.synthetic.main.custom_toolbar.*
import kotlinx.android.synthetic.main.custom_toolbar.view.*
import kotlinx.android.synthetic.main.dialog.*

class ToolbarActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_toolbar)
        setSupportActionBar(toolbar2 as Toolbar)
        replaceFragment(Fragment1())

        var btnShow = toolbar2.btnShow
        var etInput = toolbar2.etInput
        btnShow.setOnClickListener {
            Toast.makeText(this, etInput.text, Toast.LENGTH_SHORT).show()
        }

        fab.setOnClickListener { displayDialog(etInput.text.toString())}
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
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

    private fun displayDialog(string: String){
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(R.layout.dialog)

        val window = dialog.window ?: return

        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT)
        window.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        val windowAttributes = window.attributes
        windowAttributes.gravity = Gravity.CENTER
        window.attributes = windowAttributes

        val btnClose = dialog.dialog_btnClose
        val etInput = dialog.dialog_etInput
        etInput.text = string
        btnClose.setOnClickListener {
            dialog.dismiss() }
        dialog.show()
    }
}