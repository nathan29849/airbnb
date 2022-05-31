package com.example.airbnb


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
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
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SettingActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySettingBinding
    private val viewModel by viewModels<SettingViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_setting)

        binding.cvSettingBottom.setContent() {
            DrawBottomView()
        }
        binding.cvSettingTop.setContent {
            DrawTopView(viewModel)
        }

        listenPageMoving()

        setContentView(binding.root)
    }


    private fun listenPageMoving() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.nowFragment.collect {
                    it.changePage(
                        supportFragmentManager,
                        R.id.setting_fragment_container,
                        viewModel
                    )
                }
            }
        }
    }

    @Composable
    fun DrawTopView(viewModel: SettingViewModel) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Color(ContextCompat.getColor(this, R.color.airbnb_gray))
                )
        ) {
            val topExplain by viewModel.topExplain.collectAsState(initial = "")
            val topContent by viewModel.topRangeContent.collectAsState(initial = "")

            Text(text = topExplain)
            Text(text = topContent)
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