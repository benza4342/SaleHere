package com.example.myapplication

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.myapplication.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint
import io.socket.client.Socket
import io.socket.emitter.Emitter
import timber.log.Timber
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {

    private lateinit var navController: NavController

    @Inject
    lateinit var mSocket: Socket

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        mSocket.on(Socket.EVENT_CONNECT, onConnect)
        mSocket.on(Socket.EVENT_DISCONNECT, onDisconnect)
        mSocket.on(Socket.EVENT_CONNECT_ERROR, onConnectError)
        mSocket.on("new-notification", onNotification);
        mSocket.connect();
        binding.bottom.getOrCreateBadge(R.id.page_4).apply {
            isVisible = true
            number = 1
        }
        binding.bottom.setOnNavigationItemSelectedListener(this)
        val navHostFragment: NavHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragment) as NavHostFragment
        navController = navHostFragment.navController
    }

    private val onConnect = Emitter.Listener {
        runOnUiThread {
            Timber.e("Connected")
        }
    }

    private val onNotification = Emitter.Listener {
        runOnUiThread {
            val badge = binding.bottom.getOrCreateBadge(R.id.page_4).number + 1
            binding.bottom.getOrCreateBadge(R.id.page_4).number = badge
        }
    }

    private val onConnectError = Emitter.Listener {
        runOnUiThread {
        }
    }

    private val onDisconnect = Emitter.Listener {
        runOnUiThread {
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        if (item.isChecked) return true
        return when (item.itemId) {
            R.id.page_1 -> {
                navController.navigateUp()
                true
            }
            R.id.page_3 -> {
                navController.navigate(R.id.achievementFragment)
                true
            }
            else -> {
                false
            }
        }
    }
}
