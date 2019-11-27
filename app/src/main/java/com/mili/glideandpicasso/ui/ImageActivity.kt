
package com.mili.glideandpicasso.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupActionBarWithNavController
import com.mili.glideandpicasso.R
import com.mili.glideandpicasso.databinding.ActivityMainBinding

class ImageActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var controller: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding  = DataBindingUtil.setContentView(this,R.layout.activity_main)
        controller = findNavController(R.id.host_fragment)
        NavigationUI.setupWithNavController(binding.bottomNavigationView,controller)
    }

    override fun onSupportNavigateUp(): Boolean {
        onNavigateUp()
        return true
    }
}
