package su.petrowich.jad_d2_layouts_kt

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.Toast

class loEditText : AppCompatActivity() {

    var etEmail: EditText? = null
    var etPassword: EditText? = null
    var btnSend: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lo_edit_text)

        etEmail = findViewById<EditText>(R.id.etEmail)
        etEmail?.onChange{enableSend()}

        etPassword = findViewById<EditText>(R.id.etPassword)
        etPassword?.onChange{enableSend()}

        //при нажатии готово в пароле вызываем тост
        etPassword?.setOnEditorActionListener() { v, actionId, event ->
            if(actionId == EditorInfo.IME_ACTION_DONE){
                showPassword()
                true
            } else {
                false
            }
        }

        btnSend = findViewById<Button>(R.id.btnSend)
        btnSend?.setOnClickListener(btnClickListener)
    }

    private val btnClickListener = View.OnClickListener { view ->
        if (view.getId() == R.id.btnSend) {
            showPassword()
        }
    }

    fun EditText.onChange(cb: (String) -> Unit) {
        this.addTextChangedListener(object: TextWatcher {
            override fun afterTextChanged(s: Editable?) { cb(s.toString()) }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })
    }

    internal fun enableSend() {
        if (etEmail!!.text.length > 0 && etPassword!!.text.length > 0)
            btnSend?.isEnabled = true
        else
            btnSend?.isEnabled = false
    }

    fun showPassword() {
        val login = etEmail!!.getText().toString() + " " + etPassword!!.getText().toString()
        Toast.makeText(this, login, Toast.LENGTH_LONG).show()
    }

}
