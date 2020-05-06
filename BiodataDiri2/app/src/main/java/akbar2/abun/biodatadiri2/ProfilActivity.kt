package akbar2.abun.biodatadiri2

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_profil.*

class ProfilActivity : AppCompatActivity() {

    companion object{
        val REQUEST_CODE =100
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profil)
        btnEdit.setOnClickListener {}

        ambilData()
        btnEdit.setOnClickListener { navigasiKeEditProfil() }
    }
   private fun ambilData(){
       val bundle =intent.extras
       val nama:String? =bundle?.getString("nama")
       val spinner:String? =bundle?.getString("spinner")
       val umur:String? =bundle?.getString("spinner")
       val telpon:String? =bundle?.getString("telpon")
       val alamat:String? =bundle?.getString("alamat")
       val email :String? =bundle?.getString("email")

       txtNama.text=nama
       txtJenisKelamin.text=spinner
       txtTelpon.text=telpon
       txtjalan.text=alamat
       txtumur.text=umur
       txtEmail.text=email

   }
    private fun  navigasiKeEditProfil(){
        val intent=Intent(this,EditProfilActifity::class.java)
        val namaUser=nama.text.toString()
        intent.putExtra("nama",namaUser)
        startActivityForResult(intent, REQUEST_CODE)

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode== REQUEST_CODE){
            if (resultCode==Activity.RESULT_OK ){
                val result=data?.getStringExtra("nama")
            }else{
                Toast.makeText(this,"Edit failed",
                Toast.LENGTH_SHORT).show()

            }
        }
    }
}
