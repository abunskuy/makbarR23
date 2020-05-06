package akbar2.abun.biodatadiri2

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_edit_profil_actifity.*

class EditProfilActifity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_profil_actifity)
    val intentData=intent.extras
        val namaUser=intentData?.getString("nama")
        edtProfilName.setText(namaUser)
        btnedit.setOnClickListener { saveData() }

    }
    private fun saveData(){
        val namaEdit=edtProfilName.text.toString()
        if(!namaEdit.isEmpty()){
            val result= Intent()
            result.putExtra("nama",namaEdit)
            setResult(Activity.RESULT_OK,result)
        }else{
            setResult(Activity.RESULT_CANCELED)
        }
        finish()
    }
}
