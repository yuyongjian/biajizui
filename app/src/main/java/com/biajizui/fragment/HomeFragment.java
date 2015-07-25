package com.biajizui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.biajizui.imgsrcoll.ImgScroll;
import com.biajizui.view.TitleView;
import com.biajizui.biajizui.R;
import com.biajizui.view.TitleView.OnLeftButtonClickListener;
import com.biajizui.view.TitleView.OnRightButtonClickListener;
import com.biajizui.biajizui.HelpActivity;

import java.util.List;
import java.util.ArrayList;
import android.widget.ImageView;
import android.view.View.OnClickListener;
import android.widget.ImageView.ScaleType;
import android.widget.Toast;
/**
 * @author yuyongjian
 * 首页
 */
public class HomeFragment extends Fragment {

	private View mParent;
	
	private FragmentActivity mActivity;
	
	private TitleView mTitle;
	
	private TextView mText;

	private ImgScroll myPager; // 图片容器
	private LinearLayout ovalLayout; // 圆点容器
	private List<View> listViews; // 图片组

	/**
	 * Create a new instance of DetailsFragment, initialized to show the text at
	 * 'index'.
	 */
	public static HomeFragment newInstance(int index) {
		HomeFragment f = new HomeFragment();

		// Supply index input as an argument.
		Bundle args = new Bundle();
		args.putInt("index", index);
		f.setArguments(args);

		return f;
	}

	public int getShownIndex() {
		return getArguments().getInt("index", 0);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_home, container, false);
		return view;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		mActivity = getActivity();
		mParent = getView();

		mTitle = (TitleView) mParent.findViewById(R.id.title);
		mTitle.setTitle(R.string.title_home);
		mTitle.setLeftButton(R.string.exit, new OnLeftButtonClickListener() {

			@Override
			public void onClick(View button) {
				mActivity.finish();
			}

		});
		mTitle.setRightButton(R.string.help, new OnRightButtonClickListener() {

			@Override
			public void onClick(View button) {
				goHelpActivity();
			}
		});

		myPager = (ImgScroll) getActivity().findViewById(R.id.myvp);
		ovalLayout = (LinearLayout) getActivity().findViewById(R.id.vb);
		InitViewPager();//初始化图片
		//开始滚动
		myPager.start(getActivity(), listViews, 4000, ovalLayout,
				R.layout.ad_bottom_item, R.id.ad_item_v,
				R.drawable.dot_focused, R.drawable.dot_normal);

	}
	
	private void goHelpActivity() {
		Intent intent = new Intent(mActivity, HelpActivity.class);
		startActivity(intent);
	}

	@Override
	public void onHiddenChanged(boolean hidden) {
		super.onHiddenChanged(hidden);
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
	}

	/**
	 * 初始化图片
	 */
	private void InitViewPager() {
		listViews = new ArrayList<View>();
		int[] imageResId = new int[] { R.drawable.food1, R.drawable.food2,
				R.drawable.food3, R.drawable.food4, R.drawable.food5 };
		for (int i = 0; i < imageResId.length; i++) {
			ImageView imageView = new ImageView(getActivity());
			imageView.setOnClickListener(new OnClickListener() {
				public void onClick(View v) {// 设置图片点击事件
					Toast.makeText(getActivity(),
							"点击了:" + myPager.getCurIndex(), Toast.LENGTH_SHORT)
							.show();
				}
			});
			imageView.setImageResource(imageResId[i]);
			imageView.setScaleType(ScaleType.CENTER_CROP);
			listViews.add(imageView);
		}
	}

}
