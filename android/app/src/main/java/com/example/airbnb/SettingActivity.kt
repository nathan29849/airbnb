package com.example.airbnb


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.commit
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.airbnb.databinding.ActivitySettingBinding
import com.example.airbnb.ui.PriceSettingFragment
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch


class SettingActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySettingBinding
    private val viewModel: SettingViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_setting)

        binding.cvSettingBottom.setContent() {
            DrawBottomView()
        }
        binding.cvSettingTop.setContent {
            DrawTopView()
        }

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.nowFragment.collect {
                    it.changePage(supportFragmentManager , R.id.setting_fragment_container)
                }
            }
        }
        setContentView(binding.root)
    }

    @Composable
    fun DrawTopView() {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Color(ContextCompat.getColor(this, R.color.airbnb_gray))
                )
        ) {

        }
    }

    @Composable
    fun DrawBottomView() {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Color(ContextCompat.getColor(this, R.color.airbnb_gray))
                ),
            verticalAlignment = Alignment.CenterVertically,

            ) {
            Spacer(modifier = Modifier.width(10.dp))
            Button(onClick = {
                viewModel.changeToNextFragment()
            }) {
                Text(text = getString(R.string.price_page_jump))
            }
            Spacer(modifier = Modifier.width(10.dp))
            Button(onClick = { /*TODO*/ }) {
                Text(text = getString(R.string.price_page_reset))
            }
        }
    }
}