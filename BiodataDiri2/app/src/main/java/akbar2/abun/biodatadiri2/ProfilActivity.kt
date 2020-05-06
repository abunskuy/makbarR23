package akbar2.abun.biodatadiri2

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_profil.*

class ProfilActivity : AppCompatActivity() {

    companion object {
        val REQUEST_CODE = 100
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profil)


        btnEdit.setOnClickListener {}

        ambilData()
        btnEdit.setOnClickListener { navigasiKeEditProfil() }
        btncall.setOnClickListener { dialPhoneNumber(txtTelpon.text.toString()) }
        btnabout.setOnClickListener{gotoAbout()}
    }


    private fun ambilData() {
        val bundle = intent.extras
        val nama = bundle?.getString("nama")
        val spinner = bundle?.getString("spinner")
        val umur = bundle?.getString("umur")
        val telpon = bundle?.getString("telpon")
        val alamat = bundle?.getString("alamat")
        val Email = bundle?.getString("Email")

        txtNama.text = nama
        txtJenisKelamin.text = spinner
        txtTelpon.text = telpon
        txtjalan.text = alamat
        txtumur.text = umur
        txtEmail.text = Email

    }

    private fun navigasiKeEditProfil() {
        val intent = Intent(this, EditProfilActifity::class.java)
        val namaUser = txtNama.text.toString()
        intent.putExtra("nama", namaUser)
        startActivityForResult(intent, REQUEST_CODE)

    }
    private fun gotoAbout(){
        val intent = Intent(this, Aboutme::class.java)
        startActivity(intent)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CODE) {
            if (resultCode == Activity.RESULT_OK) {
                val result = data?.getStringExtra("nama")
                txtNama.text = result
            } else {
                Toast.makeText(this, "Edit failed", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun dialPhoneNumber(phoneNumber: String) {
        val dialIntent = Intent(Intent.ACTION_DIAL).apply {
            data = Uri.parse("tel:$phoneNumber")
        }
        if (dialIntent.resolveActivity(packageManager) != null) {
            startActivity(dialIntent)
        }

    }
}
