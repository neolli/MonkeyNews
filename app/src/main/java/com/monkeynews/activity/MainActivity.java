package com.monkeynews.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.Window;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;
import com.monkeynews.R;
import com.monkeynews.slidingmenu.MenuLeftFragment;
import com.monkeynews.slidingmenu.MenuRightFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * MonkeyNews APP 入口
 */
public class MainActivity extends SlidingFragmentActivity {


    private List<Fragment> mFragments = new ArrayList<Fragment>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.main);
        initMenu();
        initView();
    }

    private void initMenu() {
        Fragment leftMenu = new MenuLeftFragment();
        setBehindContentView(R.layout.left_menu_frame);
        getSupportFragmentManager().beginTransaction().replace(R.id.left_menu_frame, leftMenu)
                .commit();
        SlidingMenu menu = getSlidingMenu();
        menu.setMode(SlidingMenu.LEFT_RIGHT);
        // 设置触摸屏幕模式
        menu.setTouchModeAbove(SlidingMenu.TOUCHMODE_MARGIN);
        menu.setShadowWidthRes(R.dimen.shadow_width);
        menu.setShadowDrawable(R.drawable.shadow);
        // 设置滚动菜单视图的宽度
        menu.setBehindOffsetRes(R.dimen.slidingmenu_offset);
        // 设置渐入渐出效果值
        menu.setFadeDegree(0.35F);
        menu.setSecondaryShadowDrawable(R.drawable.shadow);
        menu.setSecondaryMenu(R.layout.right_menu_frame);
        Fragment rightMenu = new MenuRightFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.right_menu_frame, rightMenu)
                .commit();
    }

    /**
     * 初始化layout控件
     */
    private void initView() {

    }

    public void showLeftMenu(View view){
        getSlidingMenu().showMenu();
    }

    public void showRightMenu(View view){
        getSlidingMenu().showSecondaryMenu();
    }
}
