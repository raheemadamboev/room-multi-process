package xyz.teamgravity.roommultiprocess.presentation.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.NonCancellable
import kotlinx.coroutines.launch
import xyz.teamgravity.roommultiprocess.data.model.NumberModel
import xyz.teamgravity.roommultiprocess.data.repository.NumberRepository
import javax.inject.Inject
import kotlin.random.Random

@HiltViewModel
class NumberViewModel @Inject constructor(
    private val repository: NumberRepository,
) : ViewModel() {

    var generatedNumber by mutableStateOf(-1)
        private set

    fun onGenerate() {
        viewModelScope.launch(NonCancellable) {
            generatedNumber = Random.nextInt()
            repository.insertNumber(NumberModel(number = generatedNumber))
        }
    }
}