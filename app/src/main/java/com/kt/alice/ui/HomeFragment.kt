package com.kt.alice.ui

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.res.ResourcesCompat
import androidx.core.graphics.blue
import androidx.core.graphics.green
import androidx.core.graphics.red
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.math.MathUtils
import com.google.android.material.navigation.NavigationView
import com.google.android.material.snackbar.BaseTransientBottomBar
import com.google.android.material.snackbar.Snackbar
import com.kt.alice.R
import com.kt.alice.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var bottomSheetBehavior: BottomSheetBehavior<NavigationView>

    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            //param1 = it.getString(ARG_PARAM1)
            //param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater,container,false)

        /*val viewModel: BingWallpaperViewModel = ViewModelProvider(this).get(BingWallpaperViewModel::class.java)

        viewModel.getBingWallpaper().observe(viewLifecycleOwner) {
            XLog.v("当钱数据" + it.images)
        }*/

        initTopBar()
        initBottomBar()
        initListener()
        initBottomSheet()


        return binding.getRoot()
    }

    private fun initBottomSheet() {
        bottomSheetBehavior = BottomSheetBehavior.from(binding.navigationView)
        bottomSheetBehavior.state = BottomSheetBehavior.STATE_HIDDEN //先手动隐藏
        binding.scrim.visibility = View.GONE

        //手动设置 稀松布背景 类似底部工作表
        bottomSheetBehavior.addBottomSheetCallback(object : BottomSheetBehavior.BottomSheetCallback() {
            override fun onStateChanged(bottomSheet: View, newState: Int) {
                //XLog.v("newState:  $newState")
            }

            override fun onSlide(bottomSheet: View, slideOffset: Float) {
                val baseColor = Color.BLACK
                // 60% opacity
                val baseAlpha =
                    ResourcesCompat.getFloat(resources, R.dimen.material_emphasis_medium)
                // Map slideOffset from [-1.0, 1.0] to [0.0, 1.0]
                val offset = (slideOffset - -1f) / (1f - -1f) + 0f
                val alpha =
                    MathUtils.lerp(0f, 255f, offset * baseAlpha).toInt()

                /**
                 * 从 alpha、red、green、blue 分量返回一个 color-int.
                 * 这些分量值应该是\([0..255]\)，但是没有执行范围检查，所以如果它们超出范围，返回的颜色是未定义的.
                 * @param alpha 颜色的 Alpha 分量 \([0..255]\)
                 * @param red Red component \([0..255]\) of the color
                 * @param green Green component \([0..255]\) of the color
                 * @param blue Blue component \([0..255]\) of the color
                 */
                val color = Color.argb(alpha, baseColor.red, baseColor.green, baseColor.blue)
                binding.scrim.setBackgroundColor(color)
            }
        })

    }

    private fun initListener() {
        binding.floatingActionButton.setOnClickListener {
            //先弹 小吃店
            Snackbar.make(
                binding.floatingActionButton,
                "浏览实时热点？",
                BaseTransientBottomBar.LENGTH_SHORT
            ).setAction("确定") {
                ItemListDialogFragment.newInstance(30).show(parentFragmentManager, "dialog")
            }
                .setAnchorView(binding.floatingActionButton)
                .show()
        }

        binding.scrim.setOnClickListener {
            //手动设置 点击稀松布 隐藏抽屉
            bottomSheetBehavior.state = BottomSheetBehavior.STATE_HIDDEN
            binding.scrim.visibility = View.GONE
        }

        binding.navigationView.setNavigationItemSelectedListener {
            // 处理选定的菜单项
            when (it.itemId) {
                R.id.item1 -> {
                    it.isChecked = true
                    binding.scrim.visibility = View.GONE
                    bottomSheetBehavior.state = BottomSheetBehavior.STATE_HIDDEN
                }
                R.id.item5 -> {
                    //item.setChecked(true);
                    binding.scrim.visibility = View.GONE
                    bottomSheetBehavior.state = BottomSheetBehavior.STATE_HIDDEN
                }
            }
            true
        }


    }

    private fun initBottomBar() {
        binding.bottomAppBar.setNavigationOnClickListener {
            binding.scrim.visibility = View.VISIBLE
            bottomSheetBehavior.state = BottomSheetBehavior.STATE_HALF_EXPANDED  //手动展开 半展开效果好一点
        }

        binding.bottomAppBar.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.search -> {
                    Toast.makeText(context, "搜索", Toast.LENGTH_SHORT).show()
                    //findNavController(this).navigate(R.id.action_home_to_news_details)
                    findNavController().navigate(R.id.action_home_to_news_details)
                }
                R.id.more -> Toast.makeText(context, "更多操作", Toast.LENGTH_SHORT).show()
            }
            true
        }


    }

    private fun initTopBar() {
        binding.toolbar.setNavigationOnClickListener {
            Toast.makeText(context, "点击导航图标", Toast.LENGTH_SHORT).show()
        }

        binding.toolbar.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.favorite -> Toast.makeText(
                    context,
                    "收藏按钮",
                    Toast.LENGTH_SHORT
                ).show()
                R.id.search -> Toast.makeText(context, "搜索按钮", Toast.LENGTH_SHORT)
                    .show()
                R.id.more -> Toast.makeText(context, "菜单=更多选项", Toast.LENGTH_SHORT)
                    .show()
            }
            true
        }

    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomeFragment().apply {
                arguments = Bundle().apply {
                    //putString(ARG_PARAM1, param1)
                    //putString(ARG_PARAM2, param2)
                }
            }
    }
}