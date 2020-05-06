package akbar2.abun.biodatadiri2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Message
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setDataSpinner()

        btnSimpan.setOnClickListener { validasiInput () }
    }


    private fun goToProfilActivity(function: () -> Unit) {
        val intent = Intent(this, ProfilActivity::class.java)
        startActivity(intent)

    }
    private var namaInput: String = ""
    private var umurInput: String = ""
    private var EmailInput: String = ""
    private var alamatInput: String = ""
    private var telponInput: String = ""
    private var spinnerInput: String = ""
    private fun validasiInput() {
        //mendapatkan value/data dari tiap EditText dan menyimpannya ke

        namaInput = nama.text.toString()
        EmailInput = Email.text.toString()
        telponInput = telpon.text.toString()
        alamatInput = alamat.text.toString()
        spinnerInput = Spinner.selectedItem.toString()
        umurInput=umur.text.toString()

        when {
            namaInput.isEmpty() -> nama.error = "Nama tidak boleh kosong"
            spinnerInput.equals("Pilih Jenis Kelamin", ignoreCase = true) ->
                tampilToast("Jenis Kelamin harus dipilih")
            EmailInput.isEmpty() -> Email.error = "Email tidak boleh kosong"
            umurInput.isEmpty() -> umur.error = "umur tidak boleh kosong"
            telponInput.isEmpty() -> telpon.error = "Telp tidak boleh kosong"
            alamatInput.isEmpty() -> alamat.error = "Alamat tidak boleh kosong"
            else -> {
                tampilToast("Navigasi ke halaman profil")
                goToProfilActivity()

            }
        }
    }
    private fun tampilToast(message: String){
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show()
    }

    private fun setDataSpinner() {
        val adapter = ArrayAdapter.createFromResource(
            this,
            R.array.jenis_kelamin,
            android.R.layout.simple_spinner_item
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        Spinner.adapter = adapter
    }

    private fun goToProfilActivity(){
        val intent = Intent(this,ProfilActivity::class.java)
        val bundle=Bundle()
        bundle.putString("nama",namaInput)
        bundle.putString("spinner",spinnerInput)
        bundle.putString("Email",EmailInput)
        bundle.putString("telpon",telponInput)
        bundle.putString("alamat",alamatInput)
        bundle.putString("umur",umurInput)

        intent.putExtras(bundle)
        startActivity(intent)
    }
}