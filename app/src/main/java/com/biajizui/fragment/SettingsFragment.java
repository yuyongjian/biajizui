package com.biajizui.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.biajizui.biajizui.R;
import com.biajizui.view.TitleView;
import com.biajizui.view.TitleView.OnLeftButtonClickListener;
import com.biajizui.view.TitleView.OnRightButtonClickListener;

/**
 * @author yuyongjian
 * 设置页面
 */
public class SettingsFragment extends Fragment {
	
	private View mParent;
	
	private FragmentActivity mActivity;

	private TitleView mTitle;

	/**
	 * Create a new instance of DetailsFragment, initialized to show the text at
	 * 'index'.
	 */
	public static SettingsFragment newInstance(int index) {
		SettingsFragment f = new SettingsFragment();

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
		View view = inflater
				.inflate(R.layout.fragment_settings, container, false);
		return view;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		mParent = getView();
		mActivity = getActivity();

		mTitle = (TitleView) mParent.findViewById(R.id.title);
		mTitle.setTitle(R.string.title_show);
		mTitle.setLeftButton(R.string.back, new OnLeftButtonClickListener() {

			@Override
			public void onClick(View button) {
			}
		});
		mTitle.hiddenLeftButton();
		mTitle.setRightButton(R.string.help, new OnRightButtonClickListener() {

			@Override
			public void onClick(View button) {
			}
		});

	}

}
