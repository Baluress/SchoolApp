package com.example.schoolapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.appcompat.widget.Toolbar
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.ui.navigateUp
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.navigation.NavigationView
import com.xwray.groupie.GroupieAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration

     //private lateinit var rvMain: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        installSplashScreen()

        setContentView(R.layout.activity_main)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        val drawerLayout = findViewById<DrawerLayout>(R.id.drawer_layout)
        val navView = findViewById<NavigationView>(R.id.nav_view)

        val navController = findNavController(R.id.nav_host_fragment_content_main)

        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home, R.id.nav_grades, R.id.nav_information, R.id.nav_grades_list
            ), drawerLayout
        )

        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }

//        val mainItems = mutableListOf<MainItem>()
//        mainItems.add(
//            MainItem(
//                id = 1,
//                drawableId = R.drawable.ic_baseline_event_note_36,
//                textStringId = R.string.menu_grades
//            )
//        )
//
//        mainItems.add(
//            MainItem(
//                id = 2,
//                drawableId = R.drawable.ic_baseline_info_36,
//                textStringId = R.string.menu_informations
//            )
//        )


//        val adapter = MainAdapter(mainItems) { id ->
//            when (id) {
//                1 -> {
//                    // Trocar para activity de calcular notas
//                    val intent = Intent(this, GradesActivity::class.java)
//                    startActivity(intent)
//                }
//                2 -> {
//                    val intent = Intent(this, InfoActivity::class.java)
//                    startActivity(intent)
//                }
//            }
//        }
//        rvMain = findViewById(R.id.rv_main)
//        rvMain.adapter = adapter
//        rvMain.layoutManager = LinearLayoutManager(this)

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

//    private inner class MainAdapter(
//        private val mainItems: List<MainItem>,
//        private val onItemClickListener: (Int) -> Unit
//    ) : RecyclerView.Adapter<MainAdapter.MainViewHolder>() {
//
//        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
//            val view = layoutInflater.inflate(R.layout.main_item, parent, false)
//            return MainViewHolder(view)
//        }
//
//        override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
//            val itemCurrent = mainItems[position]
//            holder.bind(itemCurrent)
//        }
//
//        override fun getItemCount(): Int {
//            return mainItems.size
//        }
//
//        private inner class MainViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//            fun bind(item: MainItem) {
//
//                val imgIcon: ImageView = itemView.findViewById(R.id.img_main_icon)
//                val txtIcon: TextView = itemView.findViewById(R.id.txt_main_icon)
//                val container: LinearLayout = itemView.findViewById(R.id.container_icon)
//
//                imgIcon.setImageResource(item.drawableId)
//                txtIcon.setText(item.textStringId)
//
//                container.setOnClickListener {
//                    onItemClickListener.invoke(item.id)
//                }
//            }
//        }
    //}
}