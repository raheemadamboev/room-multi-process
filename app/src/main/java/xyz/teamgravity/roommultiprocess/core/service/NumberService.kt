package xyz.teamgravity.roommultiprocess.core.service

import android.widget.Toast
import androidx.lifecycle.LifecycleService
import androidx.lifecycle.lifecycleScope
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import xyz.teamgravity.roommultiprocess.data.repository.NumberRepository
import javax.inject.Inject

@AndroidEntryPoint
class NumberService : LifecycleService() {

    @Inject
    lateinit var repository: NumberRepository

    override fun onCreate() {
        super.onCreate()

        observe()
    }

    private fun observe() {
        observeLastNumber()
    }

    private fun observeLastNumber() {
        lifecycleScope.launch {
            repository.getLastNumber().collectLatest { number ->
                if (number != null) Toast.makeText(this@NumberService, number.number.toString(), Toast.LENGTH_SHORT).show()
            }
        }
    }
}