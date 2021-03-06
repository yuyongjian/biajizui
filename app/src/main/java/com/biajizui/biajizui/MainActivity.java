package com.biajizui.biajizui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.Window;

import com.biajizui.fragment.FragmentIndicator;
import com.biajizui.fragment.FragmentIndicator.OnIndicateListener;
import com.biajizui.imgsrcoll.ImgScroll;
import android.widget.LinearLayout;
import java.util.List;
/**
 * @author yuyongjian
 * 主界面
 */
public class MainActivity extends FragmentActivity {

	public static Fragment[] mFragments;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);

		setFragmentIndicator(0);
		
	}

	/**
	 * 设置fragment
	 */
	private void setFragmentIndicator(int whichIsDefault) {
		mFragments = new Fragment[4];
		mFragments[0] = getSupportFragmentManager().findFragmentById(R.id.fragment_home);
		mFragments[1] = getSupportFragmentManager().findFragmentById(R.id.fragment_search);
		mFragments[2] = getSupportFragmentManager().findFragmentById(R.id.fragment_settings);
		mFragments[3] = getSupportFragmentManager().findFragmentById(R.id.fragment_settings);
		getSupportFragmentManager().beginTransaction().hide(mFragments[0])
				.hide(mFragments[1]).hide(mFragments[2]).hide(mFragments[3]).show(mFragments[whichIsDefault]).commit();

		FragmentIndicator mIndicator = (FragmentIndicator) findViewById(R.id.indicator);
		FragmentIndicator.setIndicator(whichIsDefault);
		mIndicator.setOnIndicateListener(new OnIndicateListener() {
			@Override
			public void onIndicate(View v, int which) {
				getSupportFragmentManager().beginTransaction()
						.hide(mFragments[0]).hide(mFragments[1])
						.hide(mFragments[2]).hide(mFragments[3]).show(mFragments[which]).commit();
			}
		});
	}

	@Override
	protected void onResume() {
		super.onResume();
	}
	
	@Override
	protected void onPause() {
		super.onPause();
	}
	
}
