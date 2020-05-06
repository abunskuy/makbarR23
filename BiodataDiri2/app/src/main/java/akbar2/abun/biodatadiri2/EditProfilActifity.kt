package akbar2.abun.biodatadiri2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class EditProfilActifity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_profil_actifity)
    val intentData=intent.extras
        val namaUser=intentData.getString("nama")

    }
}
