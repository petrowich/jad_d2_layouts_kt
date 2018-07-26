package su.petrowich.jad_d2_layouts_kt

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.FrameLayout
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnShapes = findViewById<Button>(R.id.btnShapes)
        btnShapes.setOnClickListener(btnClickListener)

        val btnEditText = findViewById<Button>(R.id.btnEditText)
        btnEditText.setOnClickListener(btnClickListener)

        val btnCL = findViewById<Button>(R.id.btnCL)
        btnCL.setOnClickListener(btnClickListener)

        val btnCLChains = findViewById<Button>(R.id.btnCLChains)
        btnCLChains.setOnClickListener(btnClickListener)
    }

    private val btnClickListener = View.OnClickListener { view ->

        var intent: Intent? = null

        when (view.getId()) {
            R.id.btnShapes -> intent = Intent(applicationContext, loShapes::class.java)
            R.id.btnEditText -> intent = Intent(applicationContext, loEditText::class.java)
            R.id.btnCL -> intent = Intent(applicationContext, loCL::class.java)
            R.id.btnCLChains -> intent = Intent(applicationContext, loCLChains::class.java)
        }
        if (intent != null) startActivity(intent)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.m_color, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.item_black -> setTheme("чёрный", android.graphics.Color.BLACK, android.graphics.Color.WHITE)
            R.id.item_white -> setTheme("белый", android.graphics.Color.WHITE, android.graphics.Color.BLACK)
            R.id.item_red -> setTheme("красный", android.graphics.Color.RED, android.graphics.Color.RED)
            R.id.item_green -> setTheme("зелёный", android.graphics.Color.GREEN, android.graphics.Color.GREEN)
            R.id.item_blue ->  setTheme("синий", android.graphics.Color.BLUE, android.graphics.Color.BLUE)
            else -> return super.onOptionsItemSelected(item)
        }

        return true
    }

    fun setTheme(themeName: String, tvColor: Int, bgColor: Int){

        val tvText = findViewById<TextView>(R.id.tvText)
        val lBg = findViewById<FrameLayout>(R.id.lBg)

        tvText.text = themeName
        tvText.setTextColor(tvColor)
        lBg.setBackgroundColor(bgColor)
    }
}
